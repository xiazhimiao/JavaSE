package com.xiazhimiao.myobjstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class ObjStream {
    public static void main(String[] args) throws IOException {
        //创建序列化流对象
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:\\a.txt"));

        Student student = new Student("xiazhimiao",20);
        //写入
        //注意：如果对象没有实现标记接口，此时写入乱七八糟（个人实际观点）
        oos.writeObject(student);
        oos.close();
        //可序列化
        //ArrayList
        //TreeSet
        //HashMap
        //-----------------
        /*
            如果写入多个，并且读出
            一般采用集合存储并且序列化的方式进行存储本地文件
            这样在读取的时候，一次读取出集合，然后遍历集合拿到其中的对象就OK了！！！
            注解：集合本身是可序列化的
        */



    }
}
