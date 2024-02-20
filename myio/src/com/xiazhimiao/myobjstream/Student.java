package com.xiazhimiao.myobjstream;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -2405961321352788702L;

    /*
    这里需要实现一个标记接口，否则会报错
    标记接口：告知本类可以实现序列化
    Serializable:其中没有抽象方法
    NotSerializableException
    serialVersionUID:`  根据类中属性，方法等计算出的“版本号”，
                        如果没有创建，并且修改了类中的属性，在反序列化以前的文件时，会因为版本问题报错
    */


    private String name;
    private int age;

    //如果不想要把性别也序列化，可以加一个关键字
    //顺态关键字
    //transient:作用：不让当前变量被序列化
    private transient String  gender;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
