package com.hz1202.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value = "/test")
@Slf4j
public class TestController {
    @RequestMapping("/hello")
    @ResponseBody
    public String test(){
        log.info("【环境测试】环境测试");
        return "hello";
    }
}
