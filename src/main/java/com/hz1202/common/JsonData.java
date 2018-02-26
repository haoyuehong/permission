package com.hz1202.common;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: mol
 * @Description:
 * @Date: create in 13:25 2018/2/26
 */
@Getter
@Setter
public class JsonData {
    private boolean ret;
    private String msg;
    private Object data;

    public JsonData(boolean ret){
        this.ret = ret;
    }

    public static JsonData susscess(Object object,String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.setMsg(msg);
        jsonData.setData(object);
        return jsonData;
    }

    public static JsonData susscess(){
        JsonData jsonData = new JsonData(true);
        return jsonData;
    }
    public static JsonData susscess(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.setData(object);
        return jsonData;
    }

    public static JsonData fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.setMsg(msg);
        return jsonData;
    }
}
