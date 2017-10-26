package arche.Dao;

import arche.Model.User;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by ZhangGuozhao on 2017/9/25.
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    public void save(User user) {
//        jdbcTemplate.update()
    }
}
