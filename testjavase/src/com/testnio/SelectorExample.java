package com.testnio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by dell on 2017/9/1.
 */
public class SelectorExample {
    //    通过Selector可以用一个线程操作多个Channel；
//    因为对线程的切换对系统来说是昂贵的，而且每个线程也占用了系统的资源；
//    使用Selector你可以用一个来操作所有的Channel
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile1 = new RandomAccessFile("d:/mytestdata/data.bin", "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("d:/mytestdata/data.bin", "rw");
//FileChannel不能运行再非阻塞模式下
            FileChannel fc1 = randomAccessFile1.getChannel();
//          产生一个Selector
            Selector selector = Selector.open();

//          得到一个Channel
            SocketChannel socketChannel = SocketChannel.open();
//          The Channel must be in non-blocking mode to be used with a Selector.
//                    通道必须位于非阻塞模式，以便与选择器一起使用。
            socketChannel.configureBlocking(true);
//Channel上注册selector
//            This is an "interest set", meaning what events you are interested in listening for in the Channel, via the Selector.
//            SelectionKey.OP_ACCEPT
//            SelectionKey.OP_CONNECT
//              SelectionKey.OP_WRITE
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
//            socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_ACCEPT);
            int interestSet = selectionKey.interestOps();
            boolean isInterestedInAccept = (interestSet & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT;
            boolean isInterestedInRead = (interestSet & SelectionKey.OP_READ) == SelectionKey.OP_READ;
            boolean isInterestedInWrite = (interestSet & SelectionKey.OP_WRITE) == SelectionKey.OP_WRITE;
            boolean isInterestedInConnect = (interestSet & SelectionKey.OP_CONNECT) == SelectionKey.OP_CONNECT;

            int readSet = selectionKey.readyOps();

            selectionKey.isAcceptable();
            selectionKey.isConnectable();
            selectionKey.isReadable();
            selectionKey.isWritable();

            selectionKey.channel();
            selectionKey.selector();

            Test test = new Test();
            selectionKey.attach(test);
            selectionKey.attachment();
            SelectionKey selectionKey1 = socketChannel.register(selector, SelectionKey.OP_READ, test);

            selectionKey.channel();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isWritable()) {
                    System.out.println("writable");
                } else if (key.isReadable()) {
                    System.out.println("readable");
                } else if (key.isConnectable()) {
                    System.out.println("connectable");
                } else if (key.isAcceptable()) {
                    System.out.println("acceptable");
                }

                iterator.remove();

            }


            selector.wakeup();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
