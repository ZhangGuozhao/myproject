package com.testRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI客户端
 * Created by dell on 2017/8/22.
 */
public class Client {
    public static void main(String[] args) {
        //注册管理器
        Registry registry = null;
        //获取服务注册管理器
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1",8088);
            //列出所有注册的服务
            String[] list = registry.list();
            for (String r : list) {
                System.out.println(r);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            //根据命名获取服务
            IService server = (IService) registry.lookup("vince");
            //调用远程方法
            String result = server.queryName("hahahahahah");
            //输出调用结果
            System.out.println("result from remote : " + result);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
