package com.xiazhimiao.a01dom4jdemo;

public class Person {
    private int id;
    private String name;
    private double age;

    public Person() {
    }

    public Person(int id, String name, double age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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
    public double getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(double age) {
        this.age = age;
    }

    public String toString() {
        return "Person{id = " + id + ", name = " + name + ", age = " + age + "}";
    }
}
