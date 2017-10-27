package com.testRPC;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dell on 2017/8/18.
 *没搞懂代理。。。2017年8月22日10:58:58
 */

public class RPCProxyClient implements InvocationHandler {
    private Object object;

    public RPCProxyClient(Object object) {
        this.object = object;
    }

    //得到被代理对象
    public static Object getProxy(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new RPCProxyClient(object)
                );

    }
//重写InvocationHandler里的invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //结果参数；
        Object result = new Object();
        //....执行通信相关逻辑
        //...
        return result;
    }
}
