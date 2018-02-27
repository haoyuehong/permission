package com.hz1202.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: mol
 * @Description:获取上下文工具类
 * @Date: create in 14:33 2018/2/27
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper  implements ApplicationContextAware{
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T> T  popBean(Class<T> clazz){
        if(applicationContext == null){
            return null;
        }
        return applicationContext.getBean(clazz);
    }

    public static <T> T popBean(String name,Class<T> clazz){
        if(applicationContext == null){
            return null;
        }
        return applicationContext.getBean(name,clazz);

    }
}
