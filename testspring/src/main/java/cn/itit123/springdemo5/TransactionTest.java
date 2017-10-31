package cn.itit123.springdemo5;

import java.util.Arrays;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionTest {

    private ApplicationContext ctx = null;
    private PurchaseService purchaseService = null;
    private BatchPurchaseService batchPurchaseService = null;

    {
        ctx = new ClassPathXmlApplicationContext("demo5/applicationContext.xml");
        purchaseService = (PurchaseService) ctx.getBean("purchaseService");
        batchPurchaseService = (BatchPurchaseService) ctx.getBean("batchPurchaseService");
    }

    /**
     * 用户买一本书
     * 基本用法-事务回滚
     * 把@Transactional 注释。假设当前用户余额只有10元。单元测试后，用户余额没有变，spring的库存却减少了。赚了！！！
     * 把@Transactional 注释打开。假设当前用户余额只有10元。单元测试后，用户余额没有变，spring的库存也没有减少。这就是回滚。
     * 回滚：按照业务逻辑，先更新库存，再更新余额。现在是库存更新成功了，但在余额逻辑抛出异常。最后数据库的值都没有变。也就是库存回滚了。
     */
    @Test
    public void basicTransaction() {
        System.out.println("^^^^^^^^^^^^^^^^^@Transactional 最基本的使用方法");
        purchaseService.purchase("itdragon", "spring");
    }

    /**
     * 用户买多本书
     * 事务的传播性 -大事务中，有小事务，小事务的表现形式
     * 用@Transactional, 当前用户余额50，是可以买一本书的。运行结束后，数据库中用户余额并没有减少，两本书的库存也都没有减少。
     * 用@Transactional(propagation=Propagation.REQUIRED), 运行结果是一样的。
     * 把REQUIRED 换成 REQUIRES_NEW 再运行 结果还是一样。。。。。
     * 为什么呢？？？？ 因为我弄错了！！！！！
     * 既然是事务的传播性，那当然是一个事务传播给另一个事务。
     * 需要新增一个事务类批量购买 batchPurchase事务， 包含了purchase事务。
     * 把 REQUIRED 换成 REQUIRES_NEW 运行的结果是：用户余额减少了，第一本书的库存也减少了。
     * REQUIRED：如果有事务在运行，当前的方法就在这个事务内运行。否则，就启动一个新的事务，并在自己的事务内运行。大事务回滚了，小事务跟着一起回滚。
     * REQUIRES_NEW：当前的方法必须启动新事务，并在自己的事务内运行。如果有事务在运行，应该将它挂起。大事务虽然回滚了，但是小事务已经结束了。
     * 如果用REQUIRES_NEW，则可以买一本。
     */
    @Test
    public void propagationTransaction() {
        System.out.println("^^^^^^^^^^^^^^^^^@Transactional(propagation) 事务的传播性");
        batchPurchaseService.batchPurchase("itdragon", Arrays.asList("java", "spring"));
    }

    /**
     * 测试异常不回滚，故意超买（不常用）
     * 当前用户余额10元，买了一本价值40元的java书。运行结束后，余额没有少，java书的库存减少了（赚了！）。因为设置指定异常不回滚！
     * 指定异常回滚就不测了。
     */
    @Test
    public void noRollbackForTransaction() {
        System.out.println("^^^^^^^^^^^^^^^^^@Transactional(noRollbackFor) 设置回滚事务属性");
        purchaseService.purchase("itdragon", "java");
    }
}