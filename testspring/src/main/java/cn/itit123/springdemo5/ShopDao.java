package cn.itit123.springdemo5;

/**
 * Created by ZhangGuozhao on 2017/10/31.
 */
public interface ShopDao {
    float getBookPriceBySku(String sku);
    void updateBookStock(String sku);
    void updateUserBalance(String account, float price);
}
