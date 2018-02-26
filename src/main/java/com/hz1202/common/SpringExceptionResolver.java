package com.hz1202.common;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: mol
 * @Description:
 * @Date: create in 13:33 2018/2/26
 */
public class SpringExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        //获取请求路径
        String url = request.getRequestURL().toString();
        //定义全局异常
        ModelAndView mv;
        //默认异常
        String defaultMsg = "System error";

        return null;
    }
}
