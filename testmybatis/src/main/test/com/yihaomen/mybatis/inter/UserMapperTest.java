package com.yihaomen.mybatis.inter;

import com.yihaomen.inter.UserMapper;
import com.yihaomen.model.Article;
import com.yihaomen.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ZhangGuozhao on 2017/10/18.
 */
public class UserMapperTest {

    private SqlSession sqlSession;

    @Before
    public void setSqlSession() throws Exception{
        SqlSessionFactory sqlSessionFactory = null;
        try {
            Reader reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void selectUserById1() throws Exception{
        try {
//            这种方式是用SqlSession实例来直接执行已映射的SQL语句：
//            查询User  id 为12 的User  并打印到控制台
//            如下sqlSession里的selectOne方法取得数据库的值
            User user = (User) sqlSession.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 3);
            assertEquals("winter", user.getUserName());
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserAge());
            System.out.println(user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void selectUserById2() throws Exception{
        try {
//            接口编程方式，<mapper namespace="com.yihaomen.mybatis.inter.UserMapper">
            UserMapper userOperation = sqlSession.getMapper(UserMapper.class);
            User user = userOperation.selectUserByID(1);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    //    获取UserList
    @Test
    public void testGetUserList() throws Exception{
        try {
            UserMapper userOperation = sqlSession.getMapper(UserMapper.class);
            List<User> users = userOperation.selectUsers("summer");
            for (User user : users) {
                System.out.println(user.getId() + ":" + user.getUserName() + ":" + user.getUserAddress());
            }
        } finally {
            sqlSession.close();
        }
    }
//    注意在增加，更改，删除的时候要调用session.commit()
    //    增加User
    @Test
    public void testAddUser() throws Exception{
        User user = new User();
        user.setUserAddress("人民广场");
        user.setUserName("飞鸟");
        user.setUserAge("80");
        try {
            UserMapper userOperation = sqlSession.getMapper(UserMapper.class);
            userOperation.addUser(user);
            sqlSession.commit();
            System.out.println("当前增加的用户 id为:" + user.getId());
        } finally {
            sqlSession.close();
        }
    }
//删除User
    @Test
    public void testDeleteUser() throws Exception{
        try {
            UserMapper userOperation = sqlSession.getMapper(UserMapper.class);
            userOperation.deleteUser(2);
            sqlSession.commit();
            System.out.println("删除成功!");
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserArticles1() throws Exception {
        try {
            UserMapper userOperation = sqlSession.getMapper(UserMapper.class);
            List<Article> articles = userOperation.getUserArticles1(1);
            for (Article article : articles) {
                System.out.println(article.getId() + ", " + article.getUser().getId() + ", " + article.getTitle());
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserArticles2() throws Exception {
        try {
            UserMapper userOperation = sqlSession.getMapper(UserMapper.class);
            List<Article> articles = userOperation.getUserArticles2(1);
            for (Article article : articles) {
                System.out.println(article.getId() + ", " + article.getUser().getId() + ", " + article.getTitle());
            }
        } finally {
            sqlSession.close();
        }
    }

}
