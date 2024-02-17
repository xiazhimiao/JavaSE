package com.xiazhimiao.myfile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MyFileDemo1 {
    public static void main(String[] args) {
        String file = "E:\\学习记录.md";
        File file1 = new File(file);
        //获取最后一次文件修改的毫秒值
        long l = file1.lastModified();
        System.out.println(l);
        //JDK7格式化毫秒值
        Date date=new Date(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("JDK7格式化毫秒值"+format);

        //JDK8格式化毫秒值
        Instant instant = Instant.ofEpochMilli(l);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String format1 = formatter.format(localDateTime);
        System.out.println("JDK8格式化毫秒值"+format1);


    }
}
