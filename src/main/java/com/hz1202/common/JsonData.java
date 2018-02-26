package com.hz1202.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class JsonData {
    private boolean rest;
    private String msg;
    private Object data;

    public JsonData(boolean rest){
        this.rest = rest;
    }

    public static JsonData success(String msg, Object data){
        JsonData jsonData = new JsonData(true);
        jsonData.setMsg(msg);
        jsonData.setData(data);
        return jsonData;
    }

    public static JsonData success(Object data){
        JsonData jsonData = new JsonData(true);
        jsonData.setData(data);
        return jsonData;
    }

    public static JsonData success(String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.setMsg(msg);
        return jsonData;
    }

    public static JsonData success(){
        JsonData jsonData = new JsonData(true);
        return jsonData;
    }

    public static JsonData error(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.setMsg(msg);
        return jsonData;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put("rest",result);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }



}
