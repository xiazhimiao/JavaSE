package com.xiazhimiao.a05tcpdemo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {


        System.out.println(InetAddress.getLocalHost());


        //创建对象ServerSocket，确定端口
        ServerSocket ss = new ServerSocket(10086);

        //阻塞，等待连接
        Socket accept = ss.accept();

        //获取字节输入流
        InputStream inputStream = accept.getInputStream();

        //包装流：缓冲流+转换流
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        int b = 0;
        while ((b = br.read()) != -1) {
            System.out.print((char) b);
        }

        //释放资源
        accept.close();
        ss.close();
    }
}
