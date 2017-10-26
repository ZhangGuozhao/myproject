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
    //    ͨ��Selector������һ���̲߳������Channel��
//    ��Ϊ���̵߳��л���ϵͳ��˵�ǰ���ģ�����ÿ���߳�Ҳռ����ϵͳ����Դ��
//    ʹ��Selector�������һ�����������е�Channel
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile1 = new RandomAccessFile("d:/mytestdata/data.bin", "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("d:/mytestdata/data.bin", "rw");
//FileChannel���������ٷ�����ģʽ��
            FileChannel fc1 = randomAccessFile1.getChannel();
//          ����һ��Selector
            Selector selector = Selector.open();

//          �õ�һ��Channel
            SocketChannel socketChannel = SocketChannel.open();
//          The Channel must be in non-blocking mode to be used with a Selector.
//                    ͨ������λ�ڷ�����ģʽ���Ա���ѡ����һ��ʹ�á�
            socketChannel.configureBlocking(true);
//Channel��ע��selector
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
