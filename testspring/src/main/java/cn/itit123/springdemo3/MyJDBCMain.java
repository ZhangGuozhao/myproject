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
    private JdbcTemplate jdbcTemplate = null; // JdbcTemplate ֻ��һ�� JDBC��С����,��֧�ּ�������
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate = null; // ֧�־�����������ߴ���Ŀɶ��ԡ�

    // ����飬�ڴ��������ʱ�����
    {
        ctx = new ClassPathXmlApplicationContext("demo3/applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("namedParameterJdbcTemplate");
    }

    // �����Ƿ��������ݿ����ӳ�
    @Test
    public void connectionDataSource() {
        System.out.println("----------- connectionDataSource ----------");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        try {
            // ���ܴ�ӡcom.mchange.v2.c3p0.impl.NewProxyConnection ˵�����ӳɹ���
            System.out.println(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("^^^^^^^^^^^ connectionDataSource ^^^^^^^^^^^");
    }

    /**
     * ֱ�Ӷ�Mysql���ݽ�������ɾ���ģ��飬ͳ�ƵĲ���
     */
    @Test
    public void crudMysqlOperation() {
        System.out.println("----------- crudMysqlOperation ----------");
        // ����
        String insertSql = "INSERT INTO ITDragon (account, password) VALUES (?,?)";
        System.out.println("insert result : " + jdbcTemplate.update(insertSql, "itdragon", "pwdItdragon"));
        // �޸�
        String updateSql = "UPDATE ITDragon SET password = ? WHERE account = ?";
        System.out.println("update result : " + jdbcTemplate.update(updateSql, "passwordItdragon", "itdragon"));
        // ��ѯ
        String querySql = "SELECT * FROM ITDragon";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(querySql);
        System.out.println("query result : " + results);
        // ɾ��
        String deleteSql = "DELETE FROM ITDragon WHERE account = ?";
        System.out.println("delete result : " + jdbcTemplate.update(deleteSql, "itdragon"));
        // ͳ��
        String countSql = "SELECT count(id) FROM ITDragon";
        System.out.println("count result : " + jdbcTemplate.queryForObject(countSql, Long.class));
        System.out.println("^^^^^^^^^^^ crudMysqlOperation ^^^^^^^^^^^");
    }

    /**
     * ֱ�Ӷ�Mysql���ݽ�������������ɾ���ĵĲ���
     */
    @Test
    public void batchCrudMysqlOperation() {
        System.out.println("----------- batchCrudMysqlOperation ----------");
        // ��������
        String insertSql = "INSERT INTO ITDragon (account, password) VALUES (?,?)";
        List<Object[]> insertArgs = new ArrayList<Object[]>();
        insertArgs.add(new Object[]{"itdragon", "pwdItdragon"});
        insertArgs.add(new Object[]{"blog", "pwdBlog"});
        System.out.println("batch insert result : " + jdbcTemplate.batchUpdate(insertSql, insertArgs));
        // ��ѯ
        String querySql = "SELECT * FROM ITDragon";
        List<Map<String, Object>> results = jdbcTemplate.queryForList(querySql);
        System.out.println("query result : " + results);
        // �����޸�
        String updateSql = "UPDATE ITDragon SET password = ? WHERE account = ?";
        List<Object[]> updateArgs = new ArrayList<Object[]>();
        updateArgs.add(new Object[]{"passwordItdragon", "itdragon"});
        updateArgs.add(new Object[]{"passwordBlog", "blog"});
        System.out.println("batch udpate result : " + jdbcTemplate.batchUpdate(updateSql, updateArgs));
        // ����ɾ��
        String deleteSql = "DELETE FROM ITDragon WHERE account = ?";
        List<Object[]> deleteArgs = new ArrayList<Object[]>();
        deleteArgs.add(new Object[]{"itdragon"});
        deleteArgs.add(new Object[]{"blog"});
        System.out.println("batch delete result : " + jdbcTemplate.batchUpdate(deleteSql, deleteArgs));
        // ͳ��
        String countSql = "SELECT count(id) FROM ITDragon";
        System.out.println("count result : " + jdbcTemplate.queryForObject(countSql, Long.class));
        System.out.println("^^^^^^^^^^^ batchCrudMysqlOperation ^^^^^^^^^^^");
    }

    /**
     * �������ɾ�Ĳ飬���� NamedParameterJdbcTemplate
     * Ҫ�󣺲�����Ҫ�����������һ��
     * �ô���֮ǰ�Ĳ����ã���ʾ����ֱ�ۣ�����Ŀɶ��Խϲ�����ʽϸߡ�
     * ȱ�㣺���ü�����ĸ
     */
    @Test
    public void crudObjectOperation() {
        System.out.println("----------- crudObjectOperation ----------");
        // ����
        String insertSql = "INSERT INTO ITDragon (account, password) VALUES (:account,:password)";
        ITDragon itDragon = new ITDragon();
        itDragon.setAccount("itdragon");
        itDragon.setPassword("pwdItdragon");
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(itDragon);
        System.out.println("insert object result : " + namedParameterJdbcTemplate.update(insertSql, paramSource));
        // ��ѯ
        String querySql = "SELECT * FROM ITDragon";
        // ʹ�� RowMapper ָ��ӳ����������
        RowMapper<ITDragon> rowMapper = new BeanPropertyRowMapper<ITDragon>(ITDragon.class);
        List<ITDragon> results = namedParameterJdbcTemplate.query(querySql, rowMapper);
        System.out.println("query object result : " + results);
        // ���º�ɾ�� Ҳ��update���������ﲻ�����������
        System.out.println("^^^^^^^^^^^ crudObjectOperation ^^^^^^^^^^^");
    }
}
