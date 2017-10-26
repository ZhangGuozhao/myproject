package com.test;

/**
 * Created by dell on 2017/9/7.
 */
public class ThreePointExamples {
    private String name;

    public void threePoint(Integer... integer) {
        for (Integer i : integer) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ThreePointExamples threePointExamples = new ThreePointExamples();
        Integer integer1 = new Integer(1);
        Integer integer2 = new Integer(2);
        Integer integer3 = new Integer(3);

        threePointExamples.threePoint(integer1, integer2, integer3);
        threePointExamples.threePoint(integer1, integer2);

        Integer[] integerArr = {1, 3, 5, 7, 9};
        threePointExamples.threePoint(integerArr);

        Integer[] integers = new Integer[5];
        integers[0] = new Integer(1);
        integers[1] = new Integer(2);

        System.out.println(integers.length);
        for (Integer i : integers) {
            System.out.print(i);
        }
        System.out.println();

        Integer[] integers3 = new Integer[]{1,2,5};
        Integer arrayCapcity =  new Integer(15);
        String[] stringArr = new String[arrayCapcity];
        System.out.println("stringArr's length = " + stringArr.length);
    }
}
