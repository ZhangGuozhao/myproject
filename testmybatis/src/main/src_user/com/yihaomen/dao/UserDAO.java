package com.yihaomen.dao;

import com.yihaomen.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ZhangGuozhao on 2017/10/25.
 */

/*
* 前面的系列mybatis 文章，已经基本讲到了mybatis的操作，但都是基于mapper映射操作的，
* 在mybatis 3中这个mapper 接口貌似充当了以前在ibatis 2中的 DAO 层的作用。
* 但事实上，如果有这个mapper接口不能完成的工作，或者需要更复杂的扩展的时候，你就需要自己的DAO 层.
* 事实上 mybatis 3 也是支持DAO 层设计的，类似于ibatis 2 .下面介绍下.
* */

public interface UserDAO {
    List<Article> getUserArticles(int userid);
}
