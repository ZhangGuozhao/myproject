package com.testSerializable;

import java.io.*;

/**
 * Created by dell on 2017/8/9.
 */
public class TestFooEx {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FooEx fooEx = new FooEx(18, "уен╟");
        File file = new File("FooEx.out");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(fooEx);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        FooEx fooExRead = (FooEx)objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(fooExRead);
    }
}
