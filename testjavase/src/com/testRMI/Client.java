package com.testRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RMI�ͻ���
 * Created by dell on 2017/8/22.
 */
public class Client {
    public static void main(String[] args) {
        //ע�������
        Registry registry = null;
        //��ȡ����ע�������
        try {
            registry = LocateRegistry.getRegistry("127.0.0.1",8088);
            //�г�����ע��ķ���
            String[] list = registry.list();
            for (String r : list) {
                System.out.println(r);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        try {
            //����������ȡ����
            IService server = (IService) registry.lookup("vince");
            //����Զ�̷���
            String result = server.queryName("hahahahahah");
            //������ý��
            System.out.println("result from remote : " + result);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
