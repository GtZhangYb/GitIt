package com.able.test.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonUtils {

    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("123","799");
        map.put("456",456);
        String result = mapToJsonStr(map);
        System.out.println(result);


        String str = new String();

        str.length();

    }

    public static String mapToJsonStr(Map<String, Object> map){
        JSONObject json = (JSONObject) JSONArray.toJSON(map);

        return json.toJSONString();
    }
}
