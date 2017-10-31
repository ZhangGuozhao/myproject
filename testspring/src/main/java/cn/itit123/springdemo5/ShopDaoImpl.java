package cn.itit123.springdemo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("shopDao")
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public float getBookPriceBySku(String sku) {
        String sql = "SELECT price FROM product WHERE sku = ?";
        /**
         * 第二个参数要用封装数据类型，如果用float.class，会提示 Type mismatch affecting row number 0 and column type 'FLOAT':
         * Value [40.0] is of type [java.lang.Float] and cannot be converted to required type [float] 错误
         */
        return jdbcTemplate.queryForObject(sql, Float.class, sku);
    }


    @Override
    public void updateBookStock(String sku) {
        // step1 防超卖，购买前先检查库存。若不够, 则抛出异常
        String sql = "SELECT stock FROM product WHERE sku = ?";
        int stock = jdbcTemplate.queryForObject(sql, Integer.class, sku);
        System.out.println("^^^^^^^^^^^^^^^^^商品( " + sku + " )可用库存 : " + stock);
        if(stock == 0){
            throw new ProductException("库存不足!再看看其他产品吧！");
        }
        // step2 更新库存
        jdbcTemplate.update("UPDATE product SET stock = stock -1 WHERE sku = ?", sku);
    }

    @Override
    public void updateUserBalance(String account, float price) {
        // step1 下单前验证余额是否足够, 若不足则抛出异常
        String sql = "SELECT balance FROM user WHERE account = ?";
        float balance = jdbcTemplate.queryForObject(sql, Float.class, account);
        System.out.println("^^^^^^^^^^^^^^^^^您当前余额 : " + balance + ", 当前商品价格 : " + price);
        if(balance < price){
            throw new UserException("您的余额不足!不支持购买！");
        }
        // step2 更新用户余额
        jdbcTemplate.update("UPDATE user SET balance = balance - ? WHERE account = ?", price, account);
        // step3 查看用于余额
        System.out.println("^^^^^^^^^^^^^^^^^您当前余额 : " + jdbcTemplate.queryForObject(sql, Float.class, account));
    }

}