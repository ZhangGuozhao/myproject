package com.testSerializable;

import java.io.*;

/**
 * Created by dell on 2017/8/7.
 */
//反序列化
public class TestFoo {

    public static void main(String[] args) {
        try {
            Foo foo = new Foo("80",90,"100");
            File file = new File("foo.out");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(foo);
            objectOutputStream.close();
            System.out.println(foo);

            System.out.println("=======分割线=======");

            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Foo fooRead = (Foo) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(fooRead);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
