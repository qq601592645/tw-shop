package com.tw.controller;


import com.tw.annotation.SysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    private final static Logger log = LoggerFactory.getLogger(HomeController.class);


    @RequestMapping("/aop")
    @ResponseBody
    @SysLog("测试aoplog")
    public Object aop(String name, String nick) {
        Map<String, Object> map = new HashMap<>();
        log.info("我被执行了1！");
        map.put("res", "ok1");
        return map;
    }
}

