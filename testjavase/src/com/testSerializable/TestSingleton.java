package com.testSerializable;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;

import java.io.*;

/**
 * Created by dell on 2017/8/9.
 */
public class TestSingleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = Person.getInstance();
        File file = new File("Person.out");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(person);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Person personRead = (Person) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(personRead);
        //����Person�������readSolve������ ������ȣ�û�ɹ���
        System.out.println(Person.getInstance() == person);
    }
}
