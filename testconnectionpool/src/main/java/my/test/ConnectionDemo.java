package my.test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ZhangGuozhao on 2017/9/26.
 */
public class ConnectionDemo {

    public static void main(String[] args) throws SQLException {
        System.out.println("使用连接池................................");
        long t1stat = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            long beginTime = System.currentTimeMillis();
            Connection conn = ConnectionManager.getInstance().getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement("select * from t_test");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    // do nothing...
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            long endTime = System.currentTimeMillis();
//            System.out.println("第" + (i + 1) + "次执行花费时间为:" + (endTime - beginTime));
        }
        System.out.println("总共耗费时间："+ (System.currentTimeMillis()-t1stat));

        System.out.println("不使用连接池................................");
        long t2stat = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            long beginTime = System.currentTimeMillis();
            MysqlDataSource mds = new MysqlDataSource();
            mds.setURL("jdbc:mysql://localhost:3306/testhiberante");
            mds.setUser("root");
            mds.setPassword("root");
            Connection conn = mds.getConnection();
            try {
                PreparedStatement pstmt = conn.prepareStatement("select * from t_test");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    // do nothing...
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            long endTime = System.currentTimeMillis();
//            System.out.println("第" + (i + 1) + "次执行花费时间为:"
//                    + (endTime - beginTime));
        }
        System.out.println("t2总共耗费时间："+ (System.currentTimeMillis()-t2stat));
    }
}
