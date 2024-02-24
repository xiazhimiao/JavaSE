package com.xiazhimiao.a03udpdemo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendMessageDemo {
    public static void main(String[] args) throws IOException {
        //运行创建多个实例
        //发送数据

        //1.获取快递公司
        //无参：使用随机端口号
        DatagramSocket ds = new DatagramSocket();

        //2.打包数据
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入消息:");
            String s = sc.nextLine();

            if("886".equals(s)){
                break;
            }

            byte[] bytes = s.getBytes();
            //如果发送端，IP设置为255.255.255.255就会变成广播，发送给局域网内所有主机
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            int port = 10086;

            DatagramPacket dp = new DatagramPacket(bytes,bytes.length,inetAddress,port);

            //3.发送数据
            ds.send(dp);
        }
        //4.释放资源
        ds.close();
    }
}
