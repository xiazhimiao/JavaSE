package com.xiazhimiao.myreflectdemo1;

public class Teacher {
    int age;
    String name;

    public Teacher() {
    }

    public Teacher(int age, String name) {
        this.age = age;
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

    private void teach(){
        System.out.println(name+"在教书");
    }
    public String toString() {
        return "Teacher{age = " + age + ", name = " + name + "}";
    }
}
