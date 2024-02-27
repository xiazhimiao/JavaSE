package com.xiazhimiao.classloaderdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ClassLoaderDemo2 {
    public static void main(String[] args) throws IOException {

        //static ClassLoader getSystemClassLoader() 获取系统类加载器
        //InputStream getResourceAsStream(String name)  加载某一个资源文件


        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        InputStream stream = systemClassLoader.getResourceAsStream("prop.properties");
        //prop.properties文件编码问题，导致字符流用utf-8读也是乱码
        //InputStreamReader isr = new InputStreamReader(stream);

        Properties prop = new Properties();

        prop.load(stream);

        stream.close();

        System.out.println(prop);
    }
}
