package com.able.test.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlTest {

    public static void main(String[] args) {

        try {
            File file = new File("E:\\bestseller\\documents\\worklogs\\url_test.txt");
//            FileInputStream in = new FileInputStream(file);

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line =br.readLine())!=null){
                if(!urlStatus("https://"+line)){
                    System.out.println(line);
                }else{
                    System.out.println("--");
                }
            }
        }catch (Exception e){

        }

    }

    private static boolean urlStatus(String urlStr){
        try {
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setConnectTimeout(3000);

            if(200 == conn.getResponseCode()){
                return true;
            }
        }catch (Exception e){

        }
        return false;
    }
}
