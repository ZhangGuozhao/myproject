package com.testRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**�������ӿ�
 * Created by dell on 2017/8/22.
 */

public interface IService extends Remote {
    public String queryName(String no) throws RemoteException;

}
