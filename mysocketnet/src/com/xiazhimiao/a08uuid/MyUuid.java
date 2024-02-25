package com.xiazhimiao.a08uuid;

import java.util.UUID;

public class MyUuid {
    public static void main(String[] args) {
        //uuid生成唯一标识符，可以用作文件名

        System.out.println(UUID.randomUUID());
        //replace参数是char，但可以传字符串，多态
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
        //空字符Java是不允许的
        //System.out.println(UUID.randomUUID().toString().replace('-', ""));找不到合适的方法


        String Str = new String("Runoob-1");

        System.out.print("返回值 :" );
        System.out.println(Str.replace('-', '6'));

        System.out.print("返回值 :" );
        System.out.println(Str.replace('u', 'D'));
    }
}
