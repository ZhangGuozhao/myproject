package com.testio;

import com.testSerializable.Person;

import java.io.*;

/**
 * Created by dell on 2017/8/31.
 */
public class TestObjectInputStream {
    public static class Person implements Serializable {
        public  String name;
        private int age;

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/mytestdata/object.bin"));
            Person person = new Person();
            person.name = "zhangzhao";
            person.age = 25;

            objectOutputStream.writeObject(person);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/mytestdata/object.bin"));
            Person personRead = (Person) objectInputStream.readObject();
            System.out.println(personRead.toString());
//            ¹Ø±ÕÁ÷
            objectInputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
