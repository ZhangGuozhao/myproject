package my.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by ZhangGuozhao on 2017/9/26.
 */
public final class ConnectionManager {
    private static ConnectionManager instance;
    private static ComboPooledDataSource dataSource;

    //使用单例模式
    private ConnectionManager() throws PropertyVetoException {
        dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testhiberante");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setInitialPoolSize(5); //初始化连接数
        dataSource.setMinPoolSize(1);//最小连接数
        dataSource.setMaxPoolSize(10);//最大连接数
        dataSource.setMaxStatements(50);//最长等待时间
        dataSource.setMaxIdleTime(60);//最大空闲时间，单位毫秒
    }

    public static final ConnectionManager getInstance() {
        if (instance == null) {
            try {
                instance = new ConnectionManager();
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }

        }
        return instance;
    }

    public synchronized final Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
