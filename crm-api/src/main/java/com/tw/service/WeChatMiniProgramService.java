package com.tw.service;

import com.tw.common.base.ResultCode;
import com.tw.common.exception.BaseException;
import com.tw.config.Constant;
import com.tw.utils.AesCbcUtil;
import com.tw.utils.EncryptUtils;
import com.tw.utils.HttpUtils;
import com.tw.view.WxUserInfo;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tw on 2018/11/20.
 */
@Component
public class WeChatMiniProgramService {
    String CODE2ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    //登录凭证获得openid
    public Map<String,String> getOpenId(String code) throws BaseException {
       String url = String.format(CODE2ACCESSTOKEN_URL, Constant.wechatMiniAppId, Constant.wechatMiniAppSecret, code);
        String content = HttpUtils.requestGet(url, null, null);
        if (content == null) {
            throw new BaseException(ResultCode.INTERFACE_PARSE_ERROR);
        }
        HashMap<String, Object> returnMap = EncryptUtils.stringToMap(content);
        if(returnMap==null){
            throw new BaseException(ResultCode.INTERFACE_OUTTER_INVOKE_ERROR);
        }

        String openId= (String) returnMap.get("openid");
        String sessionKey=(String) returnMap.get("session_key");
        if(openId!=null) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("openId", openId);
            map.put("sessionKey", sessionKey);
            map.put("code", code);
            return map;
        }
        throw new BaseException(ResultCode.INTERFACE_OUTTER_INVOKE_ERROR,(String) returnMap.get("errmsg"));
    }
//解密获得微信的用户信息
    public WxUserInfo getUserInfo(String code,String encryptedData,String iv) throws BaseException {
        String url = String.format(CODE2ACCESSTOKEN_URL, Constant.wechatMiniAppId, Constant.wechatMiniAppSecret, code);
        String content = HttpUtils.requestGet(url, null, null);
        if (content == null) {
            throw new BaseException(ResultCode.INTERFACE_PARSE_ERROR);
        }
        HashMap<String, Object> returnMap = EncryptUtils.stringToMap(content);
        if(returnMap==null){
            throw new BaseException(ResultCode.INTERFACE_OUTTER_INVOKE_ERROR);
        }
            String openId= (String) returnMap.get("openid");
            String sessionKey=(String) returnMap.get("session_key");
            if(openId!=null) {
                String result = null;
                try {
                    result = AesCbcUtil.decrypt(encryptedData, sessionKey, iv, "UTF-8");
                } catch (Exception e) {
                    throw new BaseException(ResultCode.DATA_CODE_ERROR);
                }
                Map<String, Object> map = new HashMap<String, Object>();
            WxUserInfo wxUserInfo = new WxUserInfo();
            if (null != result && result.length() > 0) {
                JSONObject userInfoJSON = JSONObject.fromObject(result);
                wxUserInfo.setOpenId((String) userInfoJSON.get("openId"));
                wxUserInfo.setNickName((String) userInfoJSON.get("nickName"));
                wxUserInfo.setGender((int) userInfoJSON.get("gender"));
                wxUserInfo.setCity((String) userInfoJSON.get("city"));
                wxUserInfo.setProvince((String) userInfoJSON.get("province"));
                wxUserInfo.setCountry((String) userInfoJSON.get("country"));
                wxUserInfo.setAvatarUrl((String) userInfoJSON.get("avatarUrl"));
                wxUserInfo.setUnionId((String) userInfoJSON.get("unionId"));
                return wxUserInfo;
            }
                throw new BaseException(ResultCode.INTERFACE_OUTTER_INVOKE_ERROR);
        }
        throw new BaseException(ResultCode.INTERFACE_OUTTER_INVOKE_ERROR,(String) returnMap.get("errmsg"));
    }
}
