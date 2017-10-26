package com.testnio;

import java.nio.*;
import java.nio.channels.*;

/**
 * Created by dell on 2017/9/1.
 */
public class Test {
    //Channel  Buffer  Selector 是NIO的三大核心组件

    //The FileChannel reads data from and to files.
    FileChannel fileChannel;//abstract

    //The DatagramChannel can read and write data over the network via UDP.
    DatagramChannel datagramChannel;//abstract

    //The SocketChannel can read and write data over the network via TCP.
    SocketChannel socketChannel;//abstract

    //The ServerSocketChannel allows you to listen for incoming TCP connections, like a web server does.
    //For each incoming connection a SocketChannel is created.
    ServerSocketChannel serverSocketChannel;//abstract

    ByteBuffer byteBuffer;
    CharBuffer charBuffer;
    DoubleBuffer doubleBuffer;
    FloatBuffer floatBuffer;
    IntBuffer intBuffer;
    LongBuffer longBuffer;
    ShortBuffer shortBuffer;

    MappedByteBuffer mappedByteBuffer;

    Pipe pipe;
    FileLock fileLock;

    Selector selector;





    public static void main(String[] args) {
        Selector selector;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (fileChannel != null ? !fileChannel.equals(test.fileChannel) : test.fileChannel != null) return false;
        if (datagramChannel != null ? !datagramChannel.equals(test.datagramChannel) : test.datagramChannel != null)
            return false;
        if (socketChannel != null ? !socketChannel.equals(test.socketChannel) : test.socketChannel != null)
            return false;
        if (serverSocketChannel != null ? !serverSocketChannel.equals(test.serverSocketChannel) : test.serverSocketChannel != null)
            return false;
        if (byteBuffer != null ? !byteBuffer.equals(test.byteBuffer) : test.byteBuffer != null) return false;
        if (charBuffer != null ? !charBuffer.equals(test.charBuffer) : test.charBuffer != null) return false;
        if (doubleBuffer != null ? !doubleBuffer.equals(test.doubleBuffer) : test.doubleBuffer != null) return false;
        if (floatBuffer != null ? !floatBuffer.equals(test.floatBuffer) : test.floatBuffer != null) return false;
        if (intBuffer != null ? !intBuffer.equals(test.intBuffer) : test.intBuffer != null) return false;
        if (longBuffer != null ? !longBuffer.equals(test.longBuffer) : test.longBuffer != null) return false;
        if (shortBuffer != null ? !shortBuffer.equals(test.shortBuffer) : test.shortBuffer != null) return false;
        if (mappedByteBuffer != null ? !mappedByteBuffer.equals(test.mappedByteBuffer) : test.mappedByteBuffer != null)
            return false;
        if (pipe != null ? !pipe.equals(test.pipe) : test.pipe != null) return false;
        if (fileLock != null ? !fileLock.equals(test.fileLock) : test.fileLock != null) return false;
        return selector != null ? selector.equals(test.selector) : test.selector == null;

    }

    @Override
    public int hashCode() {
        int result = fileChannel != null ? fileChannel.hashCode() : 0;
        result = 31 * result + (datagramChannel != null ? datagramChannel.hashCode() : 0);
        result = 31 * result + (socketChannel != null ? socketChannel.hashCode() : 0);
        result = 31 * result + (serverSocketChannel != null ? serverSocketChannel.hashCode() : 0);
        result = 31 * result + (byteBuffer != null ? byteBuffer.hashCode() : 0);
        result = 31 * result + (charBuffer != null ? charBuffer.hashCode() : 0);
        result = 31 * result + (doubleBuffer != null ? doubleBuffer.hashCode() : 0);
        result = 31 * result + (floatBuffer != null ? floatBuffer.hashCode() : 0);
        result = 31 * result + (intBuffer != null ? intBuffer.hashCode() : 0);
        result = 31 * result + (longBuffer != null ? longBuffer.hashCode() : 0);
        result = 31 * result + (shortBuffer != null ? shortBuffer.hashCode() : 0);
        result = 31 * result + (mappedByteBuffer != null ? mappedByteBuffer.hashCode() : 0);
        result = 31 * result + (pipe != null ? pipe.hashCode() : 0);
        result = 31 * result + (fileLock != null ? fileLock.hashCode() : 0);
        result = 31 * result + (selector != null ? selector.hashCode() : 0);
        return result;
    }
}
