package com.yihaomen.dao;

import com.yihaomen.model.Article;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ZhangGuozhao on 2017/10/25.
 */
//使用SqlSessionDaoSupport
//如果与spring3 mvc 集成要用  autowire的话，在daoimpl 类上 加上注解 “@Repository” ，另外还需要在spring 配置文件中加入
//<context:component-scan base-package="com.yihaomen.dao" /> 这样在需要调用的地方，就可以使用autowire自动注入了。
@Repository
public class UserDAOImpl extends SqlSessionDaoSupport implements UserDAO {
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
    @Override
    public List<Article> getUserArticles(int userid) {
        return this.getSqlSession().selectList("com.yihaomen.inter.UserMapper.getUserArticles1", userid);
    }
}
