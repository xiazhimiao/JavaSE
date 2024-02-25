package com.xiazhimiao.a07tcpdemo2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10086);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("见到你很开心".getBytes());

        //写出一个结束标记
        //否则服务器的数据输入循环不会停止
        socket.shutdownOutput();

        //接收服务器回写的数据
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        int b = 0;
        while ((b=isr.read())!=-1){
            System.out.print((char) b);
        }

        //释放资源
        socket.close();



    }
}
