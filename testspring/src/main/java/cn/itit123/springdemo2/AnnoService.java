package cn.itit123.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
@Service
public class AnnoService {
//    ����ӿڵı��
    @Autowired
    private AnnoRepository annoRepository;

    public void hello() {
        System.out.println("AnnoService : hello!");
        annoRepository.hello();
    }
}
