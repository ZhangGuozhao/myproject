package com.testnio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by dell on 2017/9/4.
 */
public class ServerSocketChannelExample {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel1 = null;
        ServerSocketChannel serverSocketChannel2 = null;
        try {
            serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.socket().bind(new InetSocketAddress(9999));

            serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel2.socket().bind(new InetSocketAddress(9999));
//            ������ģʽ
            serverSocketChannel2.configureBlocking(false);
//            while (true) {
//                listen for incoming connection  ��������������ģʽ�ͷ�����ģʽ
//               ����ģʽ
//                SocketChannel socketChannel = serverSocketChannel1.accept();
//            }

            while (true) {
                SocketChannel sockenChannel2 = serverSocketChannel2.accept();
                while (sockenChannel2 != null) {
                    System.out.println("������ģʽ");
                }
            }








        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocketChannel1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        


    }
}
