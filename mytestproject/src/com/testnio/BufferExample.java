package com.testnio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dell on 2017/9/1.
 */
public class BufferExample {
    public static void main(String[] args) {

        try {
            RandomAccessFile randomAccessFile = null;
            randomAccessFile = new RandomAccessFile("d:/mytestdata/data.bin", "rw");

            //获得一个Channel
            FileChannel fileChannel = randomAccessFile.getChannel();

            //初始化一个Buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
//            CharBuffer charBuffer = CharBuffer.allocate(1024);
//            charBuffer.put("zhangle");
//            IntBuffer intBuffer = IntBuffer.allocate(20);
//            intBuffer.put(127);


            //将数据写入Buffer： （1）利用Channel 的read
            int bytesRead = fileChannel.read(byteBuffer);
//            将数据写入Buffer： （2）直接写到Buffer利用put
            byteBuffer.put((byte) 2);
//设置Buffer的mark点
//            byteBuffer.mark();
//            重设到Buffer的mark点
//            byteBuffer.reset();


            while (bytesRead != -1) {
                //将Buffer模式转换
                byteBuffer.flip();

                //对Buffer的读：（1）利用Buffer 的get 直接读
//              byte b =  byteBuffer.get();
                //对Buffer的读： （2）读Buffer到Channel (将数据写入Channel)
//              int byte = fileChannel.write(byteBuffer)

                while (byteBuffer.hasRemaining()) {
                    //读取Buffer里内容并输出到控制台
                    System.out.print((char) byteBuffer.get());
                }
                //读取Buffer完成后清空Buffer
                byteBuffer.clear();
                // 会将已读取的内容清空，下次写入时从未读取的内容处开始写入
//                byteBuffer.compact();
                bytesRead = fileChannel.read(byteBuffer);
            }
            randomAccessFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
