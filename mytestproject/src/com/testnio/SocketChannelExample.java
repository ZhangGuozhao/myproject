package com.testnio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by dell on 2017/9/4.
 *
 */
public class SocketChannelExample {
    public static void main(String[] args) {
        try {

//      ����SocketChannel ������
//             1�� SocketChannel.open()
//             2:   ��һ�������ӵ���ServerSocketChannelʱ���½�һ��SocketChannel��

            SocketChannel socketChannel = SocketChannel.open();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(byteBuffer);

            while (byteBuffer.hasRemaining()){
                byte b = byteBuffer.get();
            }
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                socketChannel.write(byteBuffer);
            }

            socketChannel.configureBlocking(false);
//            connect()���������ڽ���connection֮ǰ�ͷ���
            socketChannel.connect(new InetSocketAddress("http://jenkov.com",80));
//            ������Ҫ�����ж�
            while (!socketChannel.finishConnect()) {

            }








            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
