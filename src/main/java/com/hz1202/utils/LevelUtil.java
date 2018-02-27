package com.hz1202.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 定义部门等级计算规则
 */
public class LevelUtil {
    /**
     * 定义分隔符
     */
    public final static String SEPARATOR = ".";
    /**
     * 定义最顶层部门等级
     */
    public final static String ROOT = "0";

    /**
     * 定义部门等级计算规则，上级部门等级.上级部门id
     * 0
     * 0.1
     * 0.2
     * 0.21
     */
    public static String calculateLevel(String parentLevel, Integer parentId){
        if(StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else{
            return StringUtils.join(parentLevel,SEPARATOR,parentId);
        }
    }


}
