package test.annotation.toy;

/**
 * Created by ZhangGuozhao on 2017/10/9.
 */
public class Toy1 {
    public static void main(String[] args) {
        int[] arr = new int[]{
                9,5,1,2,3
        };
        int[] index =new int[]{

            2, 1, 2, 3, 3, 4, 0, 0, 1, 0, 2
        } ;
        String tel = "";
        for (int i : index) {
//            i取到index里的数值
            tel += arr[i];
            System.out.println(i);
        }
        System.out.println(tel);
    }

}
