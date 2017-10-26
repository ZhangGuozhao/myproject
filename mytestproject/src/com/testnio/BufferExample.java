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

            //���һ��Channel
            FileChannel fileChannel = randomAccessFile.getChannel();

            //��ʼ��һ��Buffer
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
//            CharBuffer charBuffer = CharBuffer.allocate(1024);
//            charBuffer.put("zhangle");
//            IntBuffer intBuffer = IntBuffer.allocate(20);
//            intBuffer.put(127);


            //������д��Buffer�� ��1������Channel ��read
            int bytesRead = fileChannel.read(byteBuffer);
//            ������д��Buffer�� ��2��ֱ��д��Buffer����put
            byteBuffer.put((byte) 2);
//����Buffer��mark��
//            byteBuffer.mark();
//            ���赽Buffer��mark��
//            byteBuffer.reset();


            while (bytesRead != -1) {
                //��Bufferģʽת��
                byteBuffer.flip();

                //��Buffer�Ķ�����1������Buffer ��get ֱ�Ӷ�
//              byte b =  byteBuffer.get();
                //��Buffer�Ķ��� ��2����Buffer��Channel (������д��Channel)
//              int byte = fileChannel.write(byteBuffer)

                while (byteBuffer.hasRemaining()) {
                    //��ȡBuffer�����ݲ����������̨
                    System.out.print((char) byteBuffer.get());
                }
                //��ȡBuffer��ɺ����Buffer
                byteBuffer.clear();
                // �Ὣ�Ѷ�ȡ��������գ��´�д��ʱ��δ��ȡ�����ݴ���ʼд��
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
