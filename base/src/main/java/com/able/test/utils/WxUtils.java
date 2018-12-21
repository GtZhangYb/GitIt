package com.able.test.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class WxUtils {

    // 微信小程序 appid  和 secret
    private final static String WX_XCX_APP_ID = "wx813d4c088f3f2d2d";
    private final static String WX_XCX_APP_SECRET = "d0f1054a4bacd250428460074d863c87";

    // 微信测试公众号 appid  和 secret
    private final static String WX_CS_GZH_ZYB_OPEN_ID = "on6mP1vwejgUo9p75AnWOjp8lC54";
    private final static String WX_CS_GZH_APP_ID = "wxb218997695ecf443";
    private final static String WX_CS_GZH_SECRET = "aff586f3e5643426077138e00da314dd";

    //
    private final static String FORM_ID = "3cd79938affec0c045b831f95f6d05be";
//1.js? [sm]:80 ------------------form id  = 985ce3b9b2a8d744138a5fbbe0d656b6

    private final static String OPEN_ID =  "okFbr4p--s4x_y788XJ4vg2qej5A";//"okFbr4tuvDS2M0VtJ7h91uZM3yYc";


    public static void main(String[] args) {


        // 微信公众号发送消息
        sendWxCsGzhMessage();

        // 微信小程序发送 模板通知
        sendWxXcxMessages("okFbr4tuvDS2M0VtJ7h91uZM3yYc");
    }
    public static void sendWxCsGzhMessage(){
        String accessToken = getAccessToken(WX_CS_GZH_APP_ID, WX_CS_GZH_SECRET);
        System.out.println("access_token = "+accessToken);
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+accessToken;
        //            https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=
        String jsonString = getWxCsGzhMeaagetRequest().toJSONString();
        System.out.println("message data str = "+ jsonString);
        String post = send(url, "POST", jsonString, null);
        System.out.println(post);
    }

    public static JSONObject getWxCsGzhMeaagetRequest(){
        JSONObject js = new JSONObject();
        js.put("touser",WX_CS_GZH_ZYB_OPEN_ID);
        js.put("template_id","bcCQpF9ihvSTDw5GiZIfTu18rA45X_FV1FXff-KI07o");// 模板编码
//        js.put("url","m.only.cn"); // only 微信官网
        js.put("url","m.jackjones.com.cn");  // jackjones 微信官网
        JSONObject jsDemo = new JSONObject();
        jsDemo.put("value","jackjones-test");
        jsDemo.put("color","#173177");
        JSONObject jsData = new JSONObject();
        jsData.put("demo",jsDemo);
        js.put("data",jsData);
        return js;
    }

    public static String getWxXcxOpenidList(String accessToken){
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+accessToken+"&next_openid=";
        String send = send(url, null, null, null);
        return send;
    }

    // 微信小程序发送 消息
    public  static void sendWxXcxMessages(String openId){

        String token = getAccessToken(WX_XCX_APP_ID,WX_XCX_APP_SECRET);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",getData());
        jsonObject.put("page","pages/only/1");
        jsonObject.put("access_token",token);
        jsonObject.put("touser",openId);
        jsonObject.put("template_id","4CJB-ooN7jz6iHqmThDau8ZRhA-qKASsH8G15aofGHc");
        jsonObject.put("form_id",FORM_ID);

        System.out.println(jsonObject.toJSONString());

        String url = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token="+token;
        String result = send(url, "POST", jsonObject.toString(), null);
        System.out.println(result);
    }

    public static String getAccessToken(String appID,String appSecret){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appSecret;

        String result = send(url,null, null, null);
        JSONObject resultJson = JSONObject.parseObject(result);
        return resultJson.get("access_token").toString();

    }

    public static String send(String urlString,String method, String data, Map<String,String > properties){
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(3000);
            urlConnection.setDoOutput(true);
            urlConnection.setReadTimeout(3000);
            if (properties != null) {
                for (String key : properties.keySet()) {
                    urlConnection.addRequestProperty(key, properties.get(key));
                }
            }
            if("POST".equals(method)) {
                urlConnection.getOutputStream().write(data.getBytes("UTF-8"));
                urlConnection.getOutputStream().flush();
                urlConnection.getOutputStream().close();
            }

            InputStream in = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            StringBuffer temp = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                temp.append(line);
            }
            return temp.toString();
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static JSONObject getData(){

        JSONObject jsData = new JSONObject();
        JSONObject js1 = new JSONObject();
        js1.put("value","123456789");
        jsData.put("keyword1",js1);

        JSONObject js2 = new JSONObject();
        js2.put("value","11999");
        jsData.put("keyword2",js2);

        JSONObject js3 = new JSONObject();
        js3.put("value","今天");
        jsData.put("keyword3",js3);

        JSONObject js4 = new JSONObject();
        js4.put("value","IPhone XS MAX");
        jsData.put("keyword4",js4);

        JSONObject js5 = new JSONObject();
        js5.put("value","8888");
        jsData.put("keyword5",js5);

        return jsData;

    }
}
