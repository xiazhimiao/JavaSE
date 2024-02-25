package com.xiazhimiao.a07tcpdemo2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket ss = new ServerSocket(10086);
        //获取socket
        Socket accept = ss.accept();
        //获取输入流打印数据
        InputStreamReader isr = new InputStreamReader(accept.getInputStream());
        int b = 0;
        while ((b=isr.read())!=-1){
            System.out.print((char) b);
        }

        //开始回写数据
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("有多开心？".getBytes());

        //释放资源
        //关闭通道，关闭服务器
        accept.close();
        ss.close();

    }
}
