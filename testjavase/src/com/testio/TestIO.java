package com.testio;

import java.io.*;

/**
 * Created by dell on 2017/8/28.
 */
public class TestIO {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new ObjectInputStream(new FileInputStream( new File("c:/testio.txt")));
            ObjectInputStream objectInputStream;
            SequenceInputStream sequenceInputStream;
            PushbackInputStream pushbackInputStream;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
