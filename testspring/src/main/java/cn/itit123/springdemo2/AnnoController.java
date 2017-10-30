package cn.itit123.springdemo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
@Controller
public class AnnoController {
    @Autowired
    private AnnoService annoService;

    public void execut() {
        System.out.println("AnnoController : hello !");
        annoService.hello();
    }
}
