package com.xiazhimiao.a03udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessageDemo {
    public static void main(String[] args) throws IOException {
        //简易聊天室，死循环的接收，多个发送端
        //接收数据

        //1.创建快递公司
        //此时不能随机，必须和发送端发送的端口号保持一致
        DatagramSocket ds = new DatagramSocket(10086);

        //2.1创建数据包
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data,data.length);
        //2.2接收数据包

        while (true) {
            ds.receive(dp);//该方法是阻塞的，会一直等待数据

            //3.解析数据包
            int port = dp.getPort();
            InetAddress inetAddress = dp.getAddress();
            byte[] data1 = dp.getData();
            int length = dp.getLength();

            System.out.println("数据为:"+new String(data1,0,length));
            System.out.println("从:"+inetAddress+"的"+port+"端口发出");
        }

        //4.释放资源
        //ds.close();


    }

}
