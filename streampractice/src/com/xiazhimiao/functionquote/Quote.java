package com.xiazhimiao.functionquote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class Quote {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 23));
        list.add(new Student("lisi", 24));
        list.add(new Student("wangwu", 25));

/*        String[] newlist = list.stream().map(new Function<Student, String>() {
            @Override
            public String apply(Student student) {
                return student.getName() + "-" + student.getAge();
            }
        }).toArray(String[]::new);      */
        //方法引用
        //引用其他类中的成员方法，类被抽象类的第一个参数限制
        //抽象方法的第二个参数及之后需要和被引用的成员方法对应参数一样，如果没有第二个参数，那被引用成员方法需要无参数
        String[] newlist = list.stream().map(Student::apply).toArray(String[]::new);

        System.out.println(Arrays.toString(newlist));
    }
}
