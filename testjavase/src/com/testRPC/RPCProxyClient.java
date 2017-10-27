package com.testRPC;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2017/8/18.
 *û�㶮��������2017��8��22��10:58:58
 */

public class RPCProxyClient implements InvocationHandler {
    private Object object;

    public RPCProxyClient(Object object) {
        this.object = object;
    }

    //�õ����������
    public static Object getProxy(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new RPCProxyClient(object)
                );

    }
//��дInvocationHandler���invoke����
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //���������
        Object result = new Object();
        //....ִ��ͨ������߼�
        //...
        return result;
    }
}
