package com.test;

import java.util.Date;

/**
 * Created by dell on 2017/8/22.
 */
public class test {
    public static void main(String[] args) {
        boolean b = false;
        int a = 111000;
        double d = 456.124561;
        String stringB = String.valueOf(b);
        String stringA = String.valueOf(a);
        String stringD = String.valueOf(d);
        System.out.println(stringA);
        System.out.println(stringB);
        System.out.println(stringD);
        String null1 = null;
        String null2 = null;
        System.out.println("=====" + (null1 == null2));

    }
}
