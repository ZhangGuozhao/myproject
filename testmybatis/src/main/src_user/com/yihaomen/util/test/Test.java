package com.yihaomen.util.test;

/**
 * Created by ZhangGuozhao on 2017/10/23.
 */
public class Test {
    public static Character getCharacter(String str) {
        char[] cha = str.toCharArray();
        for (int i = 0; i < 10; i++) {
            Character character = Character.valueOf(cha[i]);
//            不会循环一次就return
            return character;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getCharacter("abcdefggi"));
    }
}
