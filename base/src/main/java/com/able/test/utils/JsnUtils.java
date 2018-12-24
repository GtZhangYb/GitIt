package com.able.test.utils;

import com.alibaba.fastjson.JSONObject;

public class JsnUtils {

    public static void main(String[] args) {
        StringBuffer tsb  = new StringBuffer();
        tsb.append("{\"one\":\"1\",\"two\":\"2\",\"three\":\"3\"}");
        JSONObject js = JSONObject.parseObject(tsb.toString());
        System.out.println(1234567);

        // there are something error need to be solved
        System.out.println(js);
    }

    public static String objToJson(){

        // this is a method to get JSON String
        return null;
    }
}
