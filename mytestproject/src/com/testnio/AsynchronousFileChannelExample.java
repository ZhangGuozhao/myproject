package com.testnio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * Created by dell on 2017/9/7.
 */
public class AsynchronousFileChannelExample {
    public static void main(String[] args) {
        Path path = Paths.get("d:/mytestdata", "data", "bin.txt");
        System.out.println(path);
        try {
            AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
//            read via future
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            long position = 0;
            Future<Integer> read = asynchronousFileChannel.read(byteBuffer, position);
            while (read.isDone()) ;

            byteBuffer.flip();
            byte[] data = new byte[byteBuffer.limit()];

            byteBuffer.get(data);// byteBuffer 的内容 get到data中
            System.out.println(new String(data));
            byteBuffer.clear();
//reading data via a CompletionHandler
            asynchronousFileChannel.read(byteBuffer, position, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {

                    System.out.println("result = " + result);
                    attachment.flip();
                    byte[] data = new byte[attachment.limit()];
                    attachment.get(data);
                    System.out.println(new String(data));
                    attachment.clear();
                }


                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {

                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
