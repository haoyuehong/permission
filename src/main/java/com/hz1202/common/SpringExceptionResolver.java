package com.hz1202.common;

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
        String defaultMsg = "System error";
        //定义文本请求和页面请求
        if(url.endsWith(".json")){
            //json请求
            if(e instanceof PermissionException){
                JsonData jsonData = JsonData.error(e.getMessage());
                mv = new ModelAndView("jsonView",jsonData.toMap());
            }else{
                log.error("unkwon json exception={},url={},",e,url);
                JsonData jsonData = JsonData.error(defaultMsg);
                mv = new ModelAndView("jsonView",jsonData.toMap());
            }
        }else if(url.endsWith(".page")){
            //页面请求
            log.error("unkwon page exception={},url={},",e,url);
            JsonData jsonData = JsonData.error(defaultMsg);
            mv = new ModelAndView("exception",jsonData.toMap());
        }else{
            log.error("unkwon exception={},url={},",e,url);
            JsonData jsonData = JsonData.error(defaultMsg);
            mv = new ModelAndView("jsonView",jsonData.toMap());
        }
        return mv;
    }
}
