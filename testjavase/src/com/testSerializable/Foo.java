package com.testSerializable;

import java.io.*;

/**
 * Created by dell on 2017/8/7.
 */
//���л�
public class Foo implements Serializable {
    private String height;
    //    当某个字段被声明为transient后默认序列化机制就会忽略该字段。此处将Person类中的age字段声明为transient，如下所示，
    transient private Integer width;
    private String depth;

    public Foo() {
    }

    public Foo(String height, Integer width, String depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
//将类内的属性定义为transient的属性可以通过writeObject 和readObject 两个方法重新进行属性的序列化
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(width);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        width = objectInputStream.readInt();
    }

    @Override
    public String toString() {
        return "Foo{" +
                "height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", depth='" + depth + '\'' +
                '}';
    }
}
