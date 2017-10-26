package arche.Dao;

import arche.Model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by ZhangGuozhao on 2017/9/22.
 */
@Repository
public class AttachmentDaoImpl implements AttachmentDao {
    //引入spring-jdbc依赖包:这是利用的Springjdbc进行增删改查
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Attachment attachment) {
        jdbcTemplate.update("insert into user(username,password) values(?,?,?,?,?)",
                new Object[]{attachment.getCreateDate(), attachment.getFileName(),attachment.getFilePath(),attachment.getFileType()},
                new int[]{java.sql.Types.VARCHAR});
    }
}
