package com.testSerializable;

import java.io.*;

/**
 * Created by dell on 2017/8/9.
 */
//进行Singleton的序列化
public class Person implements Externalizable{
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public static class InstanceHolder {
        public static final Person instance = new Person(18, "张伟");
    }

    public static Person getInstance() {
        return  InstanceHolder.instance;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
    //
    private Person readResolve() throws ObjectStreamException {
        return InstanceHolder.instance;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String)in.readObject().toString();
        age = in.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }
}
