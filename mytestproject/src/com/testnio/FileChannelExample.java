package com.testnio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dell on 2017/9/4.
 */
public class FileChannelExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("c£º/mytestdata/data.bin");
            FileOutputStream fileOutputStream = new FileOutputStream("c:/mytest/data.bin");

            FileChannel in = fileInputStream.getChannel();
            FileChannel out = fileInputStream.getChannel();

            RandomAccessFile randomAccessFile = new RandomAccessFile("c£º/mytestdata/data.bin", "rw");

            FileChannel inChannel = randomAccessFile.getChannel();
            FileChannel outChannel = randomAccessFile.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
//            data read form Channel to Buffer
            int bytesRead = inChannel.read(byteBuffer);

            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            String newBytes = "New String writing to Channel in " + System.currentTimeMillis();

            buf.put(newBytes.getBytes());

            buf.flip();
            while (buf.hasRemaining()) {
//                data write from Buffer to Channel
                outChannel.write(buf);
            }

            long pos = inChannel.position();
            outChannel.position(pos + 123);

            long fileSize = inChannel.size();
            inChannel.truncate(1024);

            inChannel.force(true);


            inChannel.close();
            outChannel.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
