package com.able.test.source;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class YuanTest {


    public static void main(String[] args) {
        SimpleDateFormat sdfNew = new SimpleDateFormat("yyyyMMdd");
        String res = "";
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(5, 0);
            res = sdfNew.format(cal.getTime());
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map argsHash = new HashMap();

        argsHash.put("runDate", "");
        argsHash.put("jobName", "ALL");

        if (1 == args.length) {
            System.out.println("args length = 1 ");
        }

        if (2 == args.length) {
            System.out.println("args length = 2 ");
        }

        if (3 == args.length) {
            System.out.println("args length =3 ");
        }
        System.out.println("main end");



/*        int coun = 0;
        ResourceBundle rs = ResourceBundle.getBundle("test");
        String str = rs.getString("STORM.THIS.TEST");

//        System.out.println(str);

        for (int i = 1;i<10;i++) {

            System.out.println(i);
            if(i==5){
                break;
            }
        }
        System.out.println(coun);*/


    }
}
