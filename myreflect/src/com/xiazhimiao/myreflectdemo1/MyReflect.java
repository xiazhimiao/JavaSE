package com.xiazhimiao.myreflectdemo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Pattern;

public class MyReflect {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //1创建prop集合读取文件信息
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("myreflect\\prop.properties");
        prop.load(fis);
        fis.close();
        System.out.println(prop);

        //2读取集合信息
        String className = (String) prop.get("classname");
        String methodName = (String) prop.get("method");

        //3利用反射创建对象并运行方法
        Class aClass = Class.forName(className);
        // Object o = aClass.newInstance();
        Constructor o = aClass.getDeclaredConstructor(int.class, String.class);
        //这里必须参数
        Object o1 = o.newInstance(30, "阿伟");
        System.out.println(o1);

        Method method = aClass.getDeclaredMethod(methodName);
        //取消权限
        method.setAccessible(true);
        method.invoke(o1);
    }
}
