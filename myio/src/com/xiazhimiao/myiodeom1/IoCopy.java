package com.xiazhimiao.myiodeom1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class IoCopy {
    public static void main(String[] args) throws IOException {

        //源视频
        FileInputStream fileInputStream = new FileInputStream("E:\\1234.mp4");
        //拷贝的位置
        FileOutputStream fileOutputStream = new FileOutputStream("myio\\copy.mp4");
        //统计开始时间
        long start = System.currentTimeMillis();


        //第一种方式
    /*    int b;
        while ((b = fileInputStream.read()) != -1) {
            fileOutputStream.write(b);//这种方式拷贝大文件特别慢
        }*/


        //第二种方式

        int length;
        byte[] bytes = new byte[1024 * 1024 * 5];
        while ((length=fileInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,length);
        }


        //统计结束时间
        long end = System.currentTimeMillis();
        //计算时间
        long runTime = end - start;
        System.out.println(runTime);

        //这一步没必要日期对象
        //创建日期对象
        Instant instant = Instant.ofEpochMilli(runTime);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        //格式化
        String runTime1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:SSS").format(localDateTime);
        System.out.println(runTime1);


        //先打开后关闭
        fileOutputStream.close();
        fileInputStream.close();

    }
}
