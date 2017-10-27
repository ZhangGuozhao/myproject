package com.testRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.Provider;

/**RMI服务端
 * Created by dell on 2017/8/22.
 */
public class Server {
    public static void main(String[] args) {
        //注册管理器
        Registry registry = null;
        try {
            //创建一个服务注册管理器
            registry = LocateRegistry.createRegistry(8088);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //创建一个服务
        try {
            ServiceImpl server = new ServiceImpl();
            registry.rebind("vince", server);
            System.out.println("bind server");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
