package com.able.test.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AliDetailUtils {

    public static void main(String[] args) throws Exception {

        // 获取 pushid 的量
        File file = new File("C:\\Users\\zhangyabo\\Desktop\\push_con.csv");

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
        BufferedReader bf = new BufferedReader(isr);

        Map<String ,String> pushMap = new HashMap<String, String>();

        String line;
        while((line =bf.readLine())!=null){
            String[] split = line.split(",");
            pushMap.put(split[0],line);
        }
        bf.close();
        isr.close();
        // 获取pushid 对应的名称
        File file_act = new File("C:\\Users\\zhangyabo\\Desktop\\push_act.csv");
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream(file_act));
        BufferedReader bf2 = new BufferedReader(isr2);

        Map<String ,String> pushActMap = new HashMap<String, String>();

        String line2;
        while((line2 =bf2.readLine())!=null){
            String[] split = line2.split(",");
            pushActMap.put(split[3],line2);
        }
        bf2.close();
        isr2.close();

        // 读取 阿里文件
        File ali = new File("C:\\Users\\zhangyabo\\Desktop\\push_act.csv");
        InputStreamReader aliist = new InputStreamReader(new FileInputStream(ali));
        BufferedReader aibf = new BufferedReader(aliist);

        String aliline;
        while((aliline =aibf.readLine())!=null){
            String[] split = aliline.split(",");
//            pushActMap.put(split[3],aliline);
        }






    }
}
