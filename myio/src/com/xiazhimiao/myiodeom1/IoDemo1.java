package com.xiazhimiao.myiodeom1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDemo1 {
    public static void main(String[] args) throws IOException {
        //如果出错就采用抛出处理
        //或者try包裹也可以
        FileOutputStream fileOutputStream = new FileOutputStream("myio/a.txt");
        fileOutputStream.write(97);
        //如果程序运行时不关闭通道，就会占用对应的文件，外界不能进行删除操作
        //如果Java程序关闭，会自动关闭通道
        fileOutputStream.close();
        //不停止程序
        while (true) {
        }

}
