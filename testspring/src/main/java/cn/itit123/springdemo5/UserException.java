package cn.itit123.springdemo5;

/**
 * Created by ZhangGuozhao on 2017/10/31.
 */
public class UserException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

}