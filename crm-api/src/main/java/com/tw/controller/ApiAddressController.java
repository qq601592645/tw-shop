package com.tw.controller;

import com.tw.common.base.AppResultBuilder;
import com.tw.common.base.ResponseObject;
import com.tw.common.exception.BaseException;
import com.tw.model.Address;
import com.tw.service.UserService;
import com.tw.service.WeChatMiniProgramService;
import com.tw.view.WxUserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by aisiA on 2019/5/13.
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/api/address", produces = "application/json; charset=utf-8")
@Api(value = "获得用户地址接口", description = "获得用户接口")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST})
public class ApiAddressController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getAddressList", method = RequestMethod.POST)
    @ApiOperation(value = "登录")

    public Address getAddressInfo(@ApiParam(required = true, value = "用户userId") @RequestParam(required = true)String userId
    ){
           Address address=userService.getAddressList(userId);
            return address;
    }

    @ResponseBody
    @RequestMapping(value = "/getAddress", method = RequestMethod.POST)
    @ApiOperation(value = "地址")

    public Address getAddress(@ApiParam(required = true, value = "用户userId") @RequestParam(required = true)Integer addressId
    ){
        Address address=userService.getAddress(addressId);
        return address;
    }
}
