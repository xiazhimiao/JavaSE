package com.xiazhimiao.a02udpdemo1;

import java.io.IOException;
import java.net.*;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //发送数据

        //1.获取快递公司
        //无参：使用随机端口号
        DatagramSocket ds = new DatagramSocket();

        //2.打包数据
        String str = "你好，世界！！！";
        byte[] bytes = str.getBytes();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,inetAddress,port);

        //3.发送数据
        ds.send(dp);
        //4.释放资源
        ds.close();
    }
}
