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

//      创建SocketChannel 方法：
//             1： SocketChannel.open()
//             2:   当一个新连接到达ServerSocketChannel时会新建一个SocketChannel；

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
//            connect()方法可能在建立connection之前就返回
            socketChannel.connect(new InetSocketAddress("http://jenkov.com",80));
//            所以需要进行判断
            while (!socketChannel.finishConnect()) {

            }








            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
