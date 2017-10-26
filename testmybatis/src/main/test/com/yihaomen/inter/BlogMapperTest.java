package com.yihaomen.inter;

import com.yihaomen.model.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
//测试里的内容取消mybatis的dataSource注释
/**
 * Created by ZhangGuozhao on 2017/10/23.
 */
public class BlogMapperTest {
    private SqlSession sqlSession;

    @Before
    public void setSqlSession() throws Exception {
        SqlSessionFactory sqlSessionFactory = null;
        try {
            Reader reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.sqlSession = sqlSessionFactory.openSession();
    }


    @Test
    public void testDynamicIfTest() throws Exception {
//        动态SQL语句if ；  控制台查看SQL语句显示
        Blog blog1 = new Blog();
        blog1.setOwner("张伟");
        Blog blog2 = new Blog();
        blog2.setTitle("有意义的一天");
        Blog blog3 = new Blog();
        blog3.setContent("123456789");
        Blog blog4 = new Blog();
        blog4.setOwner("123");
        blog4.setContent("123");
        blog4.setTitle("123");
        Blog[] blogs = {blog1, blog2, blog3, blog4};
        for (int i = 0; i < 4; i++) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = blogMapper.dynamicIfTest(blogs[i]);
            System.out.println(blogs[i]);
        }
    }

    @Test
    public void testDynamicChooseTest() throws Exception {
        Blog blog1 = new Blog();
        blog1.setTitle("123");
        blog1.setContent("123");
        blog1.setOwner("123");

        Blog blog2 = new Blog();
        blog2.setContent("123");
        blog1.setOwner("123");

        Blog blog3 = new Blog();

        Blog[] blogs = {blog1, blog2, blog3};
        for (int i = 0; i < blogs.length; i++) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = blogMapper.dynamicChooseTest(blogs[i]);
            System.out.println(blog);
        }
    }

    @Test
    public void testDynamicTrimTest() throws Exception {
        Blog blog1 = new Blog();
        blog1.setTitle("123");
        blog1.setContent("123");
        blog1.setOwner("123");

        Blog blog2 = new Blog();
        blog2.setTitle("123");
        blog2.setContent("123");


        Blog blog3 = new Blog();
        blog3.setOwner("123");
        blog3.setContent("123");

        Blog blog4 = new Blog();
        blog4.setContent("123");

        Blog blog5 = new Blog();
        blog5.setTitle("123");
        blog5.setOwner("123");

        Blog[] blogs = {blog1, blog2, blog3, blog4, blog5};
        for (int i = 0; i < blogs.length; i++) {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = blogMapper.dynamicTrimTest(blogs[i]);
            System.out.println(blog);
        }

    }

    @Test
    public void testDynamicWhereTest() throws Exception {
//where  见注释
    }

    @Test
    public void testDynamicSetTest() throws Exception {
        Blog blog = new Blog();
        blog.setId("5");
        blog.setTitle("title");
        blog.setContent("123");

        System.out.println(blog);
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.dynamicSetTest(blog);
//        注意需要进行事务提交
        sqlSession.commit();
    }

    @Test
    public void testDynamicForeachTest() throws Exception {
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        ids.add(5);
        List<Blog> blogs = blogMapper.dynamicForeachTest(ids);
        for (Blog blog : blogs)
            System.out.println(blog);
        sqlSession.close();
    }

    @Test
    public void testDynamicForeach2Test() throws Exception {
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        int[] ids = {1, 2, 3, 4, 5};
        List<Blog> blogs = blogMapper.dynamicForeach2Test(ids);
        for (Blog blog : blogs)
            System.out.println(blog);
        sqlSession.close();
    }

    @Test
    public void testDynamicForeach3Test() throws Exception {
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> param = new HashMap<String, Object>();

        List<Integer> userlist = new ArrayList<Integer>();
        userlist.add(1);
        userlist.add(2);
        userlist.add(3);
        userlist.add(4);
        param.put("ids", userlist);

        List<Blog> blogs = blogMapper.dynamicForeach3Test(param);
        for (Blog blog : blogs)
            System.out.println(blog);
        sqlSession.close();
    }

    @Test
    public void testDynamicForeach4Test() throws Exception {
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> param = new HashMap<String, Object>();

        List<Integer> userlist = new ArrayList<Integer>();
        userlist.add(1);
        userlist.add(2);
        userlist.add(3);
        param.put("ids", userlist);
        param.put("title", "中国");

        List<Blog> blogs = blogMapper.dynamicForeach4Test(param);
        for (Blog blog : blogs)
            System.out.println(blog);
        sqlSession.close();
    }
}