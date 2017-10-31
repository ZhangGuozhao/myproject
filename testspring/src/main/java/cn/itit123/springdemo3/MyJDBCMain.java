package cn.itit123.springdemo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
public class MyJDBCMain {
    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null; // JdbcTemplate 只是一个 JDBC的小工具,不支持级联属性
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null; // 支持具名参数，提高代码的可读性。

    // 构造块，在创建对象的时候调用
    {
        ctx = new ClassPathXmlApplicationContext("demo3/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
    }

    // 测试是否连上数据库连接池
    @Test
    public void connectionDataSource() {
        System.out.println("----------- connectionDataSource ----------");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        try {
            // 若能打印com.mchange.v2.c3p0.impl.NewProxyConnection 说明连接成功。
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("^^^^^^^^^^^ connectionDataSource ^^^^^^^^^^^");
    }

    /**
     * 直接对Mysql数据进行增，删，改，查，统计的操作
     */
    @Test
    public void crudMysqlOperation() {
        System.out.println("----------- crudMysqlOperation ----------");
        // 插入
        String insertSql = "INSERT INTO ITDragon (account, password) VALUES (?,?)";
        System.out.println("insert result : " + jdbcTemplate.update(insertSql, "itdragon", "pwdItdragon"));
        // 修改
        String updateSql = "UPDATE ITDragon SET password = ? WHERE account = ?";
        System.out.println("update result : " + jdbcTemplate.update(updateSql, "passwordItdragon", "itdragon"));
        // 查询
        String querySql = "SELECT * FROM ITDragon";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(querySql);
        System.out.println("query result : " + results);
        // 删除
        String deleteSql = "DELETE FROM ITDragon WHERE account = ?";
        System.out.println("delete result : " + jdbcTemplate.update(deleteSql, "itdragon"));
        // 统计
        String countSql = "SELECT count(id) FROM ITDragon";
        System.out.println("count result : " + jdbcTemplate.queryForObject(countSql, Long.class));
        System.out.println("^^^^^^^^^^^ crudMysqlOperation ^^^^^^^^^^^");
    }

    /**
     * 直接对Mysql数据进行批量的增，删，改的操作
     */
    @Test
    public void batchCrudMysqlOperation() {
        System.out.println("----------- batchCrudMysqlOperation ----------");
        // 批量插入
        String insertSql = "INSERT INTO ITDragon (account, password) VALUES (?,?)";
        List<Object[]> insertArgs = new ArrayList<Object[]>();
        insertArgs.add(new Object[]{"itdragon", "pwdItdragon"});
        insertArgs.add(new Object[]{"blog", "pwdBlog"});
        System.out.println("batch insert result : " + jdbcTemplate.batchUpdate(insertSql, insertArgs));
        // 查询
        String querySql = "SELECT * FROM ITDragon";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(querySql);
        System.out.println("query result : " + results);
        // 批量修改
        String updateSql = "UPDATE ITDragon SET password = ? WHERE account = ?";
        List<Object[]> updateArgs = new ArrayList<Object[]>();
        updateArgs.add(new Object[]{"passwordItdragon", "itdragon"});
        updateArgs.add(new Object[]{"passwordBlog", "blog"});
        System.out.println("batch udpate result : " + jdbcTemplate.batchUpdate(updateSql, updateArgs));
        // 批量删除
        String deleteSql = "DELETE FROM ITDragon WHERE account = ?";
        List<Object[]> deleteArgs = new ArrayList<Object[]>();
        deleteArgs.add(new Object[]{"itdragon"});
        deleteArgs.add(new Object[]{"blog"});
        System.out.println("batch delete result : " + jdbcTemplate.batchUpdate(deleteSql, deleteArgs));
        // 统计
        String countSql = "SELECT count(id) FROM ITDragon";
        System.out.println("count result : " + jdbcTemplate.queryForObject(countSql, Long.class));
        System.out.println("^^^^^^^^^^^ batchCrudMysqlOperation ^^^^^^^^^^^");
    }

    /**
     * 对象的增删改查，改用 NamedParameterJdbcTemplate
     * 要求：参数名要和类的属性名一样
     * 好处：之前的参数用？表示，不直观，代码的可读性较差，出错率较高。
     * 缺点：多敲几个字母
     */
    @Test
    public void crudObjectOperation() {
        System.out.println("----------- crudObjectOperation ----------");
        // 插入
        String insertSql = "INSERT INTO ITDragon (account, password) VALUES (:account,:password)";
        ITDragon itDragon = new ITDragon();
        itDragon.setAccount("itdragon");
        itDragon.setPassword("pwdItdragon");
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(itDragon);
        System.out.println("insert object result : " + namedParameterJdbcTemplate.update(insertSql, paramSource));
        // 查询
        String querySql = "SELECT * FROM ITDragon";
        // 使用 RowMapper 指定映射结果集的行
        RowMapper<ITDragon> rowMapper = new BeanPropertyRowMapper<ITDragon>(ITDragon.class);
        List<ITDragon> results = namedParameterJdbcTemplate.query(querySql, rowMapper);
        System.out.println("query object result : " + results);
        // 更新和删除 也是update方法，这里不做过多的描述
        System.out.println("^^^^^^^^^^^ crudObjectOperation ^^^^^^^^^^^");
    }
}
