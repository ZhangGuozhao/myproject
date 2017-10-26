package com.testnio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.SocketChannel;

/**
 * Created by dell on 2017/9/6.
 */
public class PipeExample {
    public static void main(String[] args) {
        try {
            Pipe pipe = Pipe.open();

            Pipe.SinkChannel sink = pipe.sink();

//            writing to  a Pipe
            String newData = "New String to write to file..." + System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.clear();
            byteBuffer.put(newData.getBytes());
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                sink.write(byteBuffer);
            }

//            read from a Pipe

            Pipe.SourceChannel source = pipe.source();

            source.read(byteBuffer);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
