package com.hz1202.common;

import com.hz1202.exception.ParamException;
import com.hz1202.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver{
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        String url = request.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "系统错误";
        //定义文本请求和页面请求
        //json请求
        if(url.endsWith(".json")){
           //判断是否是我们自定义的异常
            if(e instanceof PermissionException || e instanceof ParamException){
                //创建异常返回信息
                JsonData jsonData = JsonData.createError(e.getMessage());
                //封装异常信息
                mv = new ModelAndView("jsonView",jsonData.toMap());
            }else{
                log.error("未知【json】异常 exception={},url={},",e,url);
                JsonData jsonData = JsonData.createError(defaultMsg);
                mv = new ModelAndView("jsonView",jsonData.toMap());
            }
        }else if(url.endsWith(".page")){
            //页面请求
            log.error("未知【页面】异常 exception={},url={},",e,url);
            JsonData jsonData = JsonData.createError(defaultMsg);
            mv = new ModelAndView("exception",jsonData.toMap());
        }else{
            log.error("未知异常 exception={},url={},",e,url);
            JsonData jsonData = JsonData.createError(defaultMsg);
            mv = new ModelAndView("jsonView",jsonData.toMap());
        }
        return mv;
    }
}
