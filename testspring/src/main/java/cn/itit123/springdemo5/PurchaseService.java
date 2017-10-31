package cn.itit123.springdemo5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseService {

    @Autowired
    private ShopDao shopDao;

    /**
     * 模拟用户购买商品，测事务回滚
     * 最基本用法，直接在方法或者类上使用注解@Transactional。值得注意的是：只能在公共方法上使用
     * 对应的测试方法是 basicTransaction()
     */
//    @Transactional
    /**
     * 事务的传播 propagation=Propagation.REQUIRED
     * 常用的有两种 REQUIRED，REQUIRES_NEW
     * 对应的测试方法是  propagationTransaction()
     */
//  @Transactional(propagation=Propagation.REQUIRED)
    /**
     *大事务里，新建一个小事务
     */
//  @Transactional(propagation=Propagation.REQUIRES_NEW)
    /**
     * 事务的隔离性
     * 将事务隔离起来，减少在高并发的场景下发生 脏读，幻读和不可重复读的问题
     * 默认值是READ_COMMITTED 只能避免脏读的情况。
     * 不好演示，没有对应的测试方法。
     */
//  @Transactional(isolation=Isolation.READ_COMMITTED)
    /**
     * 回滚事务属性
     * 默认情况下声明式事务对所有的运行时异常进行回滚，也可以指定某些异常回滚和某些异常不回滚。（意义不大）
     * noRollbackFor 指定异常不回滚
     * rollbackFor 指定异常回滚
     */
//  @Transactional(noRollbackFor={UserException.class, ProductException.class})
//  @Transactional(rollbackFor={UserException.class, ProductException.class})
    /**
     * 超时和只读属性
     * 超时：在指定时间内没有完成事务则回滚。可以减少资源占用。参数单位是秒
     * 如果超时，则提示错误信息：
     * org.springframework.transaction.TransactionTimedOutException: Transaction timed out
     * 只读属性：指定事务是否为只读. 若事务只读数据则有利于数据库引擎优化事务。
     * 因为该事务有修改数据的操作，若设置只读true，则提示错误信息
     * nested exception is java.sql.SQLException: Connection is read-only. Queries leading to data modification are not allowed
     * 对应的测试方法是 basicTransaction()
     */
  @Transactional(timeout=5, readOnly=false)
    public void purchase(String account, String sku) {
      // 测试超时用的
      try {
          Thread.sleep(6000);
      } catch (InterruptedException e) {
      }
      //1. 获取书的单价
      float price = shopDao.getBookPriceBySku(sku);

      //2. 更新数的库存
      shopDao.updateBookStock(sku);

      //3. 更新用户余额
      shopDao.updateUserBalance(account, price);

    }

}