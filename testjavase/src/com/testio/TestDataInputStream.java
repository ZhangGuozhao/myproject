package com.testio;

import java.io.*;

/**
 * Created by dell on 2017/8/31.
 */
public class TestDataInputStream {
    public static void main(String[] args) throws FileNotFoundException {

//         DataInputStream常常和  DataOutputStream一起使用
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("d:/mytestdata/out.bin"));
        try {
            dataOutputStream.writeInt(12321321);
            dataOutputStream.writeChars("Music In My Blood");
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataInputStream dataInputStream  = new DataInputStream(new FileInputStream("d:/mytestdata/out.bin"));
        try {
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
