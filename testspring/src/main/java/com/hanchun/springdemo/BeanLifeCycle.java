package com.hanchun.springdemo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by ZhangGuozhao on 2017/10/27.
 */
public class BeanLifeCycle implements InitializingBean, DisposableBean {
    // default-init-method="defautInit" default-destroy-method="defaultDestroy" �����ļ��е�Ĭ�Ϲ��췽��
    public void defautInit() {
        System.out.println("Bean defautInit.");
    }

    // default-init-method="defautInit" default-destroy-method="defaultDestroy" �����ļ��е�Ĭ�Ϲ��췽��
    public void defaultDestroy() {
        System.out.println("Bean defaultDestroy.");
    }

    @Override
    //���ǽӿ�Ҫ��ķ���
    public void destroy() throws Exception {
        System.out.println("Bean destroy.");
    }

    @Override
    //���ǽӿ�Ҫ��ķ���
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean afterPropertiesSet.");
    }

    //��һ�ַ������������ļ��й涨�� init-method="start" destroy-method="stop"  ��Ӧ����������Ӧ����
    public void start() {
        System.out.println("Bean start .");
    }

    //��һ�ַ������������ļ��й涨�� init-method="start" destroy-method="stop"  ��Ӧ����������Ӧ����
    public void stop() {
        System.out.println("Bean stop.");
    }
}
