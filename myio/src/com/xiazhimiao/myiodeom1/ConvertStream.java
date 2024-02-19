package com.xiazhimiao.myiodeom1;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStream {
    public static void main(String[] args) throws IOException {
        //转换流convert(转换)
        //JDK11之前：指定编码方式读取，不过已经淘汰了
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\a.txt"),"GBK");
        isr.close();

        //JDK11，
        FileReader fr=new FileReader("E:\\a.txt", Charset.forName("GBK"));
        fr.close();


        //JDK11之前：指定编码方式输出，不过已经淘汰了
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\a.txt"),"GBK");
        osw.close();

        //JDK11，
        FileWriter fw=new FileWriter("E:\\a.txt", Charset.forName("GBK"));
        fw.close();

        //下面演示 字节流 通过 转换流 变成 字符缓冲流，也就是字节流实现:
        //1.一次读一行
        //2.不出现乱码

     /*
        FileInputStream fileInputStream=new FileInputStream("E:\\");
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        //缓冲字符流
        BufferedReader bufferedReader =new BufferedReader(inputStreamReader);
        bufferedReader.close();
      */
        //当然可以写在一起
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\")));
        bufferedReader.close();










    }
}
