package com.yechh.util;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/28 14:25
 * @description：
 * @modified By：
 * @version: v1.0
 */
public class sbutil {

    public static String converString(String s,String... args){

        StringBuffer sb=new StringBuffer(s);
        for (int i = 0; i < args.length; i++) {
            sb.append("_").append(args[i]);
        }
        return sb.toString();
    }
}
