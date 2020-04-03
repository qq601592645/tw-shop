package com.tw.service;

import com.tw.common.base.ResultCode;
import com.tw.common.exception.BaseException;
import com.tw.mapper.AddressMapper;
import com.tw.mapper.UserMapper;
import com.tw.model.Address;
import com.tw.model.AddressCriteria;
import com.tw.model.User;
import com.tw.model.UserCriteria;
import com.tw.utils.JwtUtil;
import com.tw.utils.Utils;
import com.tw.view.WxUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aisiA on 2019/5/22.
 */
@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private JwtUtil jwtUtil;

    public Map<String,Object> login(WxUserInfo wxUserInfo) {
        //暂未做微信特殊字符处理
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.or().andOpenIdEqualTo(wxUserInfo.getOpenId());
        List<User> list = userMapper.selectByExample(userCriteria);
        Map<String,Object>map=new HashMap<String,Object>();
        if (list != null && list.size() > 0) {
            String token=jwtUtil.generateToken(list.get(0).getUserId(),"ROLE_USER");
            map.put("token",token);
            map.put("userId",list.get(0).getUserId());
            return map;
        } else {
            User user=new User();
            String userId= Utils.getUserId();
            user.setUserId(userId);
            user.setOpenId(wxUserInfo.getOpenId());
            user.setNickName(wxUserInfo.getNickName());
            userMapper.insert(user);
            String token=jwtUtil.generateToken(userId,"ROLE_USER");
            map.put("token",token);
            map.put("userId",userId);
            return map;
        }
    }

    public Address getAddressList(String userId){
        AddressCriteria addressCriteria=new AddressCriteria();
        addressCriteria.or().andUserIdEqualTo(userId);
         List<Address>list=addressMapper.selectByExample(addressCriteria);
        if(list==null){
            return null;
        }
        return list.get(0);
    }

    public Address getAddress(Integer addressId) {
     Address address=addressMapper.selectByPrimaryKey(addressId);
        return address;
    }
}
