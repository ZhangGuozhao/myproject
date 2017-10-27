package com.testnio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * Created by dell on 2017/9/1.
 */
public class TestScatterGather {
    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("d:/mytestdata/data.bin", "rw");

            FileChannel fileChannel = randomAccessFile.getChannel();

            ByteBuffer head = ByteBuffer.allocate(48);
            ByteBuffer body = ByteBuffer.allocate(1024);

            ByteBuffer[] byteBuffers = {head, body};

//        Scatterɢ��   ��һ��Channel�������Buffer
            long bytedata = fileChannel.read(byteBuffers);
//        Gather�ۺ�    �Ѷ��Buffer����һ��Channel
            long writedata = fileChannel.write(byteBuffers);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
