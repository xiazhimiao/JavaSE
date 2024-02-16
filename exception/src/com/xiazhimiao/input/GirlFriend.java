package com.xiazhimiao.input;

import com.xiazhimiao.customexception.AgeOutOfBoundsException;
import com.xiazhimiao.customexception.NameFormatException;

public class GirlFriend {
    String name;
    int age;

    public GirlFriend() {
    }

    public GirlFriend(String name, int age) {
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
        //添加限制
        if(name.length()<2 || name.length()>10){
            throw new NameFormatException(name+"不符合规范，长度3-10");
        }
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
        //添加限制
        if(age<18 || age>30){
            throw new AgeOutOfBoundsException(age+"不符合规范，18-30岁");
        }
        this.age = age;
    }

    public String toString() {
        return "GirlFriend{name = " + name + ", age = " + age + "}";
    }
}
