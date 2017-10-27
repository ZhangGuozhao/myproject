package com.testEnum;

/**
 * 对Enum进行遍历和Switch
 */

public class Main {

    public static void main(String[] args) {
/*//遍历Enum
        for (TestEnum testEnum1 : TestEnum.values()) {
            System.out.println(testEnum1.toString()+"--");
            System.out.println(testEnum1.ordinal());

            if(testEnum1.equals(TestEnum.SUN)){
                System.out.println("==========");
                System.out.println("今天是星期日");
            }
        }

        System.out.println("+--------分割线---------+");

        testEnum testEnum = testEnum.SUN;

       switch (testEnum){
            case MON:
                System.out.println("今天星期一");
                break;
            case TUE:
                System.out.println("今天星期二");
                break;
            case WEN:
                System.out.println("今天星期三");
                break;
            case THU:
                System.out.println("今天星期四");
                break;
            case FRI:
                System.out.println("今天星期五");
            default:
                System.out.println("Happy Weekend!");
        }*/
        TestEnum testEnum = TestEnum.MON;
        TestEnum testEnum1 = TestEnum.TUE;
        TestEnum testEnum2 = TestEnum.MON;
        System.out.println("getDeclaringClass " + testEnum.getDeclaringClass());
        System.out.println("ordinal " + testEnum.ordinal());
        System.out.println("compareTo " + testEnum1.compareTo(testEnum));
        System.out.println("compareTo " + testEnum.compareTo(testEnum2));
        System.out.println("toString " + testEnum.toString());
        System.out.println("name " + testEnum.name());
        System.out.println("valueOf " + testEnum.valueOf("MON"));
    }
}
