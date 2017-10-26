package com.testRMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.Provider;

/**RMI�����
 * Created by dell on 2017/8/22.
 */
public class Server {
    public static void main(String[] args) {
        //ע�������
        Registry registry = null;
        try {
            //����һ������ע�������
            registry = LocateRegistry.createRegistry(8088);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //����һ������
        try {
            ServiceImpl server = new ServiceImpl();
            registry.rebind("vince", server);
            System.out.println("bind server");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
