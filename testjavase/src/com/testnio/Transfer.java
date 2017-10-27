package com.testnio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by dell on 2017/9/1.
 */
public class Transfer {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile1 = new RandomAccessFile("d:/mytestdata/data.bin","rw");
            FileChannel fromChannel = randomAccessFile1.getChannel();

            RandomAccessFile randomAccessFile2 = new RandomAccessFile("d:/mytestdata/data.bin","rw");
            FileChannel toChannel = randomAccessFile2.getChannel();

            long position = 0;
            long count  = fromChannel.size();

            // transfers data from a source£¨may not be FileChannel£© channel into the FileChannel.
            toChannel.transferFrom(fromChannel, position, count);
            //transfer FileChannel into other Channel
            toChannel.transferTo(position, count, fromChannel);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
