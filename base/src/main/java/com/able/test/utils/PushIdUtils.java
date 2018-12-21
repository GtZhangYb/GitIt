package com.able.test.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

public class PushIdUtils {
    public static void main(String[] args) throws Exception{
        getPushidByJson("push_con");

    }

    private static void getPushidByJson(String fileName) throws IOException {
        File file = new File("C:\\Users\\zhangyabo\\Desktop\\pushid.json");

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        BufferedReader bf = new BufferedReader(isr);
        String line = null;
        String reachSegmentFilePath = null;
        String pushId = null;
        StringBuffer sbf = new StringBuffer("");
        while((line =bf.readLine())!=null){
//            reachSegmentFilePath = getreachSegmentFilePath(line);
          reachSegmentFilePath = getPushId(line);
//            reachSegmentFilePath = getPushidAndCon(line); // 获取解析后的 pushID，短信内容，短信长度
            System.out.println(reachSegmentFilePath);
            if(null!=reachSegmentFilePath &&reachSegmentFilePath.length()>0 ){
                sbf.append(reachSegmentFilePath).append("\n");
            }
        }

        File  outFile = new File("C:\\Users\\zhangyabo\\Desktop\\"+fileName+".csv");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile));
        bufferedWriter.write(sbf.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    private static String getreachSegmentFilePath(String line) {
        JSONObject js = JSONObject.parseObject(line);
        String id = (String) js.get("id");
        String url = ((String) js.get("reachSegmentFilePath")).replaceAll("hdfs://","");
        return id +","+url;
    }

    private static String  getPushId(String line) {
        JSONObject js = JSONObject.parseObject(line);
        if(null!=js.get("id"))
            return (String) js.get("id");
        return null;
    }

    private static String getPushidAndCon(String jsonStr){
        JSONObject js = JSONObject.parseObject(jsonStr);
        // pushId
        String  id = (String) js.get("id");
     /*   if(null==id || id.length()==0)
            return null;
        // 任务执行时间
        String runtime = (String)js.get("appointedTime");
        String time = (runtime.split(" "))[0];
        JSONObject jsCon = (JSONObject)js.get("data");
        // 短信签名
        String sign = (String) jsCon.get("sign");
        // 短信内容
        String content = ((String) jsCon.get("content")).trim();
        // 通道
        String channle = (String) jsCon.get("channelCode");
        String jg = null;
        if(channle.startsWith("SMS_EMAY")){
            return null;
        }else if(channle.startsWith("SMS_ALIYUN")){
            jg = "ali";
        }else if(channle.startsWith("SMS_TENCENT")){
            return  null;
        }else return null;

        // 短信长度 = 短信内容长度+ 签名长度 + 【】
        int len = 0;
        int smsNum =0;
        if(channle.startsWith("SMS_TENCENT")){

            int signLen = 0;
            // 腾讯短信 长度计算
            if(channle.equals("SMS_TENCENT_ONLY_1")){ // 你的ONLY
                signLen = "你的ONLY".length()+2;
            }else if(channle.equals("SMS_TENCENT_JACKJONES_1")){ // 杰克琼斯中国
                signLen = "杰克琼斯中国".length()+2;
            }else if(channle.equals("SMS_TENCENT_VEROMODA_1")){ // VEROMODA
                signLen = "VEROMODA".length()+2;
            }else if(channle.equals("SMS_TENCENT_SELECTED_1")){ // SELECTED
                signLen = "SELECTED".length()+2;
            }else if(channle.equals("SMS_TENCENT_JLINDEBERG_1")){ // 金林德伯格
                signLen = "金林德伯格".length()+2;
            }else if(channle.equals("SMS_TENCENT_BESTSELLER_1")){ // 绫致时装
                signLen = "绫致时装".length()+2;
            }else if(channle.equals("SMS_TENCENT_SHIZHUANG_1")){ // BESTSELLER时装
                signLen = "BESTSELLER时装".length()+2;
            }else if(channle.equals("SMS_TENCENT_HAY_1")){ // HAY
                signLen = "HAY".length()+2;
            }else if(channle.equals("SMS_TENCENT_OUTLETS_1")) { // 绫致奥莱
                signLen = "绫致奥莱".length()+2;
            }else if(channle.equals("SMS_TENCENT_NAMEIT_1")) { // Nameit
                signLen = "Nameit".length()+2;
            }

            // TODO

            len = content.length()+signLen;
//            smsNum = getTen

        }else {
            len = content.length() + sign.length() + 2 +6;
            smsNum = getAliSmsNum(len);

        }*/
        // 短信内容
        JSONObject jsCon = (JSONObject)js.get("data");
        String content = ((String) jsCon.get("content")).trim();
        return id+","+content;
//        return time+","+jg+","+id+","+"【"+sign+"】"+content+","+len+","+smsNum;
//        return  id+",【"+sign+"】"+content+","+len+","+smsNum;
    }

    private static int getAliSmsNum(int len) {

        int smsNum = 0;
        if(len<=70){
            smsNum = 1;
        }else if(len>70&&len<135) {
            smsNum = 2;
        }else if(len >=135 && len<135+67){
            smsNum = 3;
        }else
            smsNum = 3+(len-135)/67;

        return smsNum;
    }


}
















