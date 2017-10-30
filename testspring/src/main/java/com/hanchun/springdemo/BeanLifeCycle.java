package com.hanchun.springdemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by ZhangGuozhao on 2017/10/27.
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean {
    // default-init-method="defautInit" default-destroy-method="defaultDestroy" 配置文件中的默认构造方法
    public void defautInit() {
        System.out.println("Bean defautInit.");
    }

    // default-init-method="defautInit" default-destroy-method="defaultDestroy" 配置文件中的默认构造方法
    public void defaultDestroy() {
        System.out.println("Bean defaultDestroy.");
    }

    @Override
    //覆盖接口要求的方法
    public void destroy() throws Exception {
        System.out.println("Bean destroy.");
    }

    @Override
    //覆盖接口要求的方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean afterPropertiesSet.");
    }

    //另一种方法，在配置文件中规定的 init-method="start" destroy-method="stop"  对应类中声明相应方法
    public void start() {
        System.out.println("Bean start .");
    }

    //另一种方法，在配置文件中规定的 init-method="start" destroy-method="stop"  对应类中声明相应方法
    public void stop() {
        System.out.println("Bean stop.");
    }
}
