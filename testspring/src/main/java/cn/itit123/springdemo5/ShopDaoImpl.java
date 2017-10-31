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
         * �ڶ�������Ҫ�÷�װ�������ͣ������float.class������ʾ Type mismatch affecting row number 0 and column type 'FLOAT':
         * Value [40.0] is of type [java.lang.Float] and cannot be converted to required type [float] ����
         */
        return jdbcTemplate.queryForObject(sql, Float.class, sku);
    }


    @Override
    public void updateBookStock(String sku) {
        // step1 ������������ǰ�ȼ���档������, ���׳��쳣
        String sql = "SELECT stock FROM product WHERE sku = ?";
        int stock = jdbcTemplate.queryForObject(sql, Integer.class, sku);
        System.out.println("^^^^^^^^^^^^^^^^^��Ʒ( " + sku + " )���ÿ�� : " + stock);
        if(stock == 0){
            throw new ProductException("��治��!�ٿ���������Ʒ�ɣ�");
        }
        // step2 ���¿��
        jdbcTemplate.update("UPDATE product SET stock = stock -1 WHERE sku = ?", sku);
    }

    @Override
    public void updateUserBalance(String account, float price) {
        // step1 �µ�ǰ��֤����Ƿ��㹻, ���������׳��쳣
        String sql = "SELECT balance FROM user WHERE account = ?";
        float balance = jdbcTemplate.queryForObject(sql, Float.class, account);
        System.out.println("^^^^^^^^^^^^^^^^^����ǰ��� : " + balance + ", ��ǰ��Ʒ�۸� : " + price);
        if(balance < price){
            throw new UserException("��������!��֧�ֹ���");
        }
        // step2 �����û����
        jdbcTemplate.update("UPDATE user SET balance = balance - ? WHERE account = ?", price, account);
        // step3 �鿴�������
        System.out.println("^^^^^^^^^^^^^^^^^����ǰ��� : " + jdbcTemplate.queryForObject(sql, Float.class, account));
    }

}