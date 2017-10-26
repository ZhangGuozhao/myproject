package com.testhibernate.dao;


import com.testhibernate.entity.TTest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by ZhangGuozhao on 2017/9/25.
 */
public class UserDao {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.saveUser();
        System.out.println("=====");
    }

    // TODO: 2017/9/25    Table 'testhiberante.hibernate_sequence' doesn't exist  解决这个问题
    public void saveUser() {
        //表示加载配置文件
        Configuration cfg = new Configuration().configure();
//        建立sessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();
//        获取session
        Session session = sessionFactory.openSession();
//        SessionFactory sessionFactory;
//        Session session = null;
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();

        try {

//             A SessionFactory is set up once for an application!
//            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//            session = sessionFactory.openSession();
//            开始事务
            session.beginTransaction();
            //业务操作
//            User user = new User();
//            user.setUsername("zhangsan");
//            user.setPassword("23456");
//            user.setSex("男");
            TTest t1 = new TTest();
            t1.setUsername("张乐");
            t1.setPassword("123456");
            t1.setSex("男");
            //未执行事务之前，数据处于游离状态
            session.save(t1);
            //提交事务
            session.getTransaction().commit();
            System.out.println("程序运行成功，请查看数据库结果！");
        } catch (Exception e) {
            e.printStackTrace();
            //如果抛出异常，事务回滚
            session.getTransaction().rollback();

        } finally {
            //关闭session
//            StandardServiceRegistryBuilder.destroy(registry);
            session.close();
        }
    }
}
