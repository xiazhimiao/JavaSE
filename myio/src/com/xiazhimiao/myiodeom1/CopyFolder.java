package com.xiazhimiao.myiodeom1;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CopyFolder {
    public static void main(String[] args) throws IOException {
        File file1 = new File("E:\\个人主页");
        File file2 = new File("E:\\个人主页Copy");
       /*
        注意：流是没办法直接和文件夹进行建立的，只能是文件！！！
         FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);
        */
        copyDirs(file1, file2);

    }

    private static void copyDirs(File file1, File file2) throws IOException {
        //创建副本目录,就算存在只是返回假而已
        file2.mkdirs();
        //获取文件夹内的文件
        File[] files = file1.listFiles();
        for (File file : files) {
            //判断是文件还是文件夹
            if (file.isFile()) {
                byte[] bytes = new byte[1024];
                int length = 0;
                FileInputStream fis = new FileInputStream(file);
                FileOutputStream fos = new FileOutputStream(new File(file2,file.getName()));
                while ((length=fis.read(bytes)) != -1) {
                    fos.write(bytes,0,length);
                }
            }else {
                copyDirs(file,new File(file2,file.getName()));
            }
        }
    }
}
