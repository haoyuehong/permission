package com.hz1202.controller;

import com.hz1202.common.JsonData;
import com.hz1202.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value = "/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData test(){
        try {
            log.info("【环境测试】环境测试");
            int i = 1/0;
        }catch (Exception e){
            throw new PermissionException("test exception");
        }
        return JsonData.success("hello");
    }
}
