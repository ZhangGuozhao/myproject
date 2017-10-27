package com.testnio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**UDP   User Datagram Protocol  用户数据报协议
 * 对应的Channel是  DatagramChannel
 * Created by dell on 2017/9/6.
 */
public class DatagramChannelExample {
    public static void main(String[] args) {
        try {
            DatagramChannel datagramChannel = DatagramChannel.open();
            datagramChannel.socket().bind(new InetSocketAddress(9999));

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.clear();
            datagramChannel.receive(byteBuffer);

            String newData = "New String to write to file ..." + System.currentTimeMillis();

            byteBuffer.flip();
            byteBuffer.put(newData.getBytes());

            datagramChannel.send(byteBuffer, new InetSocketAddress("jenkov.com",80));

            datagramChannel.connect(new InetSocketAddress("baidu.com",80));

            datagramChannel.read(byteBuffer);
            datagramChannel.write(byteBuffer);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
