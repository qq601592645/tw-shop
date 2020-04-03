package com.tw.controller;

import com.tw.common.base.AppResultBuilder;
import com.tw.common.base.ResponseObject;
import com.tw.common.exception.BaseException;
import com.tw.service.UserService;
import com.tw.service.WeChatMiniProgramService;
import com.tw.view.WxUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aisiA on 2019/5/13.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/auth", produces = "application/json; charset=utf-8")
@Api(value = "授权登录接口", description = "授权登录接口")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ApiAuthController {

    @Autowired
    private WeChatMiniProgramService weChatMiniProgramService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login_by_weixin", method = RequestMethod.POST)
    @ApiOperation(value = "登录")

    public ResponseObject<?> LoginByWeixin(@ApiParam(required = true, value = "登录凭证") @RequestParam(required = true)String code,
                                           @ApiParam(required = true, value = "加密数据") @RequestParam(required = true) String encryptedData,
                                           @ApiParam(required = true, value = "偏移量iv") @RequestParam(required = true) String iv
    ){
        try {
            WxUserInfo wxUserInfo=weChatMiniProgramService.getUserInfo(code, encryptedData, iv);
            Map<String,Object> map=userService.login(wxUserInfo);
            return AppResultBuilder.success(map);
        } catch (BaseException e) {
            return e.buildResponseObject();
        }
    }
}
