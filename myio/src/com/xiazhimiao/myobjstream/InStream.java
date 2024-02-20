package com.xiazhimiao.myobjstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class InStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //反序列化流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\a.txt"));
        //返回是obj，可以做强转
        Student o = (Student) ois.readObject();
        System.out.println(o);
    }
}
