package com.wzzz.wxs.order.cn.util;

public class RandomStr {

    private static String string = "abcdefghijklmnopqrstuvwxyz1234567890";


    private static int getRandom(int count) {
        return (int) Math.round(Math.random() * (count));
    }

    public static String getRandomString(int length){
        StringBuffer sb = new StringBuffer();
        int len = string.length();
        for (int i = 0; i < length; i++) {
            sb.append(string.charAt(getRandom(len-1)));
        }
        return sb.toString();
    }
}
