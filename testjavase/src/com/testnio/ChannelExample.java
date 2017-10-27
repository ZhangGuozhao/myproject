package com.testnio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.*;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * Created by dell on 2017/9/1.
 */
public class ChannelExample {
    public static void main(String[] args) {
//        File file =  new File("d:/mytestdata");
//        file  do not have a  getChannel method
        try {
            //rw  ±Ì æ  read    write
            RandomAccessFile randomAccessFile = new RandomAccessFile("d:/mytestdata/data.bin", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(48);

            int bytesReader = fileChannel.read(buffer);
            while (bytesReader != -1) {
                System.out.println("bytesReader = " + bytesReader);
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }

                buffer.clear();

                bytesReader = fileChannel.read(buffer);
            }

            randomAccessFile.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
