package com.tw.controller;

import com.tw.common.base.ResponseObject;
import com.tw.common.base.Status;
import com.tw.common.helper.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aisiA on 2018/10/23.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/auth", produces = "application/json; charset=utf-8")
@Api(value = "账号认证", description = "账号认证接口")
@CrossOrigin(origins = "*", methods = { RequestMethod.POST })
public class LoginController {

    @Autowired
    private JwtUtil jwtUtil;
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登陆")
    public ResponseObject<?> login(@ApiParam(required = true, value = "账号") @RequestParam(required = true)String username,@ApiParam(required = true, value = "密码") @RequestParam(required = true)String password){


        Map<String,String> token=loginClient(username,password);
        if(token==null){
            return Status.BadRequest.getResponseObject("该账号无法登陆！");
        }
        return Status.OK.getResponseObject(token);
    }

    public Map<String,String> loginClient(String username, String password) {

//        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username,password);
//        final Authentication authentication = authenticationManager.authenticate(upToken);
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        //JwtUser userDetails = (JwtUser) userDetailsService.loadUserByUsername(username);
        Map<String,String>map=new HashMap<String,String>();
 //
            final String token = jwtUtil.generateToken(username);
            map.put("token", token);
            return map;
    }
}
