package com.testSerializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by dell on 2017/8/9.
 */
//ʵ����Externalizable�ӿڽ������л�
public class FooEx implements Externalizable {
    private Integer age;
    private String name;

    public FooEx() {
    }

    public FooEx(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "FooEx{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    //��Externalizable�������л�����Ҫ����������������
    //ע���������������� ���л��ͷ����л��ķ���˳��Ҫͳһ
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(age);
        out.writeObject((String) name);
//        out.writeUTF(name);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        age = in.readInt();
        name = in.readObject().toString();
//        name = in.readUTF();

    }
}
