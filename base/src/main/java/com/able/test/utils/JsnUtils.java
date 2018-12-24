package com.able.test.utils;

import com.alibaba.fastjson.JSONObject;

public class JsnUtils {

    public static void main(String[] args) {
        StringBuffer tsb  = new StringBuffer();
        tsb.append("{\"one\":\"1\",\"two\":\"2\",\"three\":\"3\"}");
        JSONObject js = JSONObject.parseObject(tsb.toString());
        System.out.println(1234567);
        System.out.println(js);
    }

    public static String objToJson(){

        return null;
    }
}
