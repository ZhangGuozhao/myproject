package cn.itit123.springdemo2;

import org.springframework.stereotype.Repository;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
@Repository
public class AnnoRepositoryImp implements AnnoRepository {
    @Override
    public void hello() {
        System.out.println("AnnoRepository : hello!");
    }
}
