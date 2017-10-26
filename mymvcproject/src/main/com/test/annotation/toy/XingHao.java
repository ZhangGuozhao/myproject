package test.annotation.toy;

/**
 * Created by ZhangGuozhao on 2017/10/10.
 */
public class XingHao {
    public static void main(String[] args) {
        String tel = "15122399591";
//        手机号的隐藏 （正则表达式）
//        String telEncode = tel.replaceAll("(\\d{3})(\\d{4})\\d{4}", "$1$2****");
        String telEncode = tel.replaceAll("(\\d{3})(\\d{4})\\d{4}", "$1****$2");
        System.out.println(telEncode);
//        邮箱地址的隐藏
        String email = "412687009@qq.com";
        String emailEncode = email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
//        String emailEncode = email.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$4");
        System.out.println(emailEncode);
//        身份证号的隐藏
        String idCard = "241637199017134029";
        String idCardEncode =idCard.replaceAll("(\\d{4})(\\d{10})(\\w{4})","$1$3$2****");
        System.out.println(idCardEncode);

    }
}
