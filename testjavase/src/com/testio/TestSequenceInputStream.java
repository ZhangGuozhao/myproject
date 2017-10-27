package com.testio;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by dell on 2017/8/31.
 */
public class TestSequenceInputStream {
    public static void main(String[] args) throws IOException {
        InputStream inputStream1 = new FileInputStream("d:/mytestdata/file1.txt");
        InputStream inputStream2 = new FileInputStream("d:/mytestdata/file2.txt");

//SerquenceInputStream 将两个InputStream前后连接起来
//        trywithsource 处理sequenceInputStream的关闭
        try (SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStream1, inputStream2);
        ) {
            Reader reader = new InputStreamReader(sequenceInputStream);
            //将InputStream转成Reader
            BufferedReader bufferedReader1 = new BufferedReader(reader);
            int i = 0;
            while (i < 5) {
                System.out.println(bufferedReader1.readLine());
                i++;
            }

        }


        InputStream inputStream3 = new FileInputStream("d:/mytestdata/file3.cvc");
        InputStream inputStream4 = new FileInputStream("d:/mytestdata/file4.vvv");
// 多余两个InputStream组合成SequenceInputSteam
// 方法1：查看SequenceInputStream 构造方法：SequenceInputStream(Enumeration<? extends InputStream> e)；
// 方法2： 两两组合，最后再组合（此法略）。
        Vector<InputStream> streams = new Vector<>();
        streams.add(inputStream1);
        streams.add(inputStream2);
        streams.add(inputStream3);
        streams.add(inputStream4);
        SequenceInputStream sequenceInputStream2 = new SequenceInputStream(streams.elements());

        //将InputStream转成Reader
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(sequenceInputStream2));
        int i = 0;
        while (i < 15) {
            System.out.println(bufferedReader2.readLine());
            i ++;
        }
        sequenceInputStream2.close();

    }

}
