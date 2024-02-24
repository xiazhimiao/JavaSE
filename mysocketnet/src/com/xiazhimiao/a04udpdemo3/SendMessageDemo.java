package com.xiazhimiao.a04udpdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //发送数据

        /*
        * 组播演示
        * 组播地址：224.0.0.0——239.255.255.255
        * 其中224.0.0.0——224.0.0.225为预留的组播地址
        *
        * */


        //1.获取快递公司
        //无参：使用随机端口号
        MulticastSocket ms = new MulticastSocket();

        //2.打包数据
        String str = "你好，世界！！！";
        byte[] bytes = str.getBytes();
        InetAddress inetAddress = InetAddress.getByName("224.0.0.1");
        int port = 10086;

        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,inetAddress,port);

        //3.发送数据
        ms.send(dp);
        //4.释放资源
        ms.close();
    }
}
