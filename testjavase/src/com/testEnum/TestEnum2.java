package com.testEnum;

/**
 * Created by dell on 2017/7/28.
 */
public enum TestEnum2 {
    MON(1),TUE(2),WEN(3),THU(4),FRI(5),SAT(6){
//       public boolean isRest(){
//            return  true;
//        }
    },
    SUN(0){
//        public boolean isRest() {
//            return true;
//        }
    };

    public int value;

    TestEnum2(int value) {
        this.value = value;
    }
}
