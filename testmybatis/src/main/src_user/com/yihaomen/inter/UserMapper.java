package com.yihaomen.inter;

import com.yihaomen.model.Article;
import com.yihaomen.model.User;
import com.yihaomen.util.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZhangGuozhao on 2017/10/18.
 */
//以接口的方式编程

public interface UserMapper {
    //    与 User.xml 里面配置的 select 的id 对应（<select id="selectUserByID"）
    User selectUserByID(int id);

    //   查询User 集合
    List<User> selectUsers(String userName);

    //    增加User
    void addUser(User user);

    //    删除User
    void deleteUser(int id);

    //查询某个user的所有文章（userid）(多对一 第一种）
    List<Article> getUserArticles1(int id);

    //查询某个user的所有文章（userid）（多对一 第二种）
    List<Article> getUserArticles2(int id);
//    分页方法查询某个user下的所有文章
    List<Article> selectArticleListPage(@Param("page") PageInfo page, @Param("userid") int userid);
}
