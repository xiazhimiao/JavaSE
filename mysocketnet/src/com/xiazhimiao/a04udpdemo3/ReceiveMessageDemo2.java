package com.xiazhimiao.a04udpdemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ReceiveMessageDemo2 {
    public static void main(String[] args) throws IOException {
        //接收数据

        //1.创建快递公司
        //此时不能随机，必须和发送端发送的端口号保持一致
        MulticastSocket ms = new MulticastSocket(10086);


        //1.5将本机添加到224.0.0.1这组当中
        InetAddress address = InetAddress.getByName("224.0.0.1");
        ms.joinGroup(address);

        //2.1创建数据包
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data,data.length);
        //2.2接收数据包

        System.out.println("111");
        ms.receive(dp);//该方法是阻塞的，会一直等待数据
        System.out.println("222");

        //3.解析数据包
        int port = dp.getPort();
        InetAddress inetAddress = dp.getAddress();
        byte[] data1 = dp.getData();
        int length = dp.getLength();

        System.out.println("数据为:"+new String(data1,0,length));
        System.out.println("从:"+        inetAddress.getHostAddress()
        +"的"+port+"端口发出");

        //4.释放资源
        ms.close();


    }

}
