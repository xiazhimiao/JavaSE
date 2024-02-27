package com.xiazhimiao.classloaderdemo;

public class ClassLoaderDemo1 {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        //获取平台类加载器
        ClassLoader platformClassLoader = systemClassLoader.getParent();

        //获取启动类加载器
        ClassLoader bootstrapClassLoader = platformClassLoader.getParent();

        //系统类加载器,负责加载用户类路径上所指定的类库
        System.out.println(systemClassLoader);

        //平台类加载器,负责加载JDK中一些特殊的模块
        System.out.println(platformClassLoader);

        //虚拟机的内置类加载器，通常表示为null ，并且没有父null
        System.out.println(bootstrapClassLoader);

    }
}
