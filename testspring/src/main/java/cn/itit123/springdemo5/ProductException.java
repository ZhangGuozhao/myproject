package cn.itit123.springdemo5;

public class ProductException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ProductException() {
        super();
    }

    public ProductException(String message) {
        super(message);
    }

}