package com.testRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * ����ʵ��
 * Created by dell on 2017/8/22.
 */
public class ServiceImpl extends UnicastRemoteObject implements IService {
    private  static final long SERIAL_VERSION_UID = 682805210518738166L;

    public ServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String queryName(String no) throws RemoteException {
        //�����ľ���ʵ��
        System.out.println("hello" + no);
        return String.valueOf(System.currentTimeMillis());
    }
}
