package com.hz1202.controller;

import com.hz1202.common.ApplicationContextHelper;
import com.hz1202.common.JsonData;
import com.hz1202.dao.SysAclModuleMapper;
import com.hz1202.exception.ParamException;
import com.hz1202.model.SysAclModule;
import com.hz1202.param.TestVO;
import com.hz1202.utils.BeanValidator;
import com.hz1202.utils.JsonMapper;
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
    public JsonData testException(){
        log.info("【环境测试】环境测试");
        throw new RuntimeException("TEST EXCEPTION");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData testValidate(TestVO testVO) throws ParamException{
        log.info("【校验测试】校验测试");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.object2String(module));
        BeanValidator.check(testVO);
        return JsonData.createSuccess("test validate");
    }
}
