package com.testEnum;

/**
 * ��Enum���б�����Switch
 */

public class Main {

    public static void main(String[] args) {
/*//����Enum
        for (TestEnum testEnum1 : TestEnum.values()) {
            System.out.println(testEnum1.toString()+"--");
            System.out.println(testEnum1.ordinal());

            if(testEnum1.equals(TestEnum.SUN)){
                System.out.println("==========");
                System.out.println("������������");
            }
        }

        System.out.println("+--------�ָ���---------+");

        testEnum testEnum = testEnum.SUN;

       switch (testEnum){
            case MON:
                System.out.println("��������һ");
                break;
            case TUE:
                System.out.println("�������ڶ�");
                break;
            case WEN:
                System.out.println("����������");
                break;
            case THU:
                System.out.println("����������");
                break;
            case FRI:
                System.out.println("����������");
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
