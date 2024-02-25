package com.xiazhimiao.a05tcpdemo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        //如果连接不上，代码报错
        Socket socket = new Socket("127.0.0.1",10086);
        //Socket socket = new Socket("172.17.0.11",10086);

        //从连接通道中获取输出流
        OutputStream outputStream = socket.getOutputStream();

        //写出数据
        outputStream.write("你好你好".getBytes());

        //释放资源
        //注意：因为流是包裹在通道中，所以只需要关闭通道就足够
        //outputStream.close();
        socket.close();


    }
}
