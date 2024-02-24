package com.xiazhimiao.a01InetAddressdemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyInetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {

        //获取InetAddress的对象
        //IP对象，也就是一台电脑的对象
        InetAddress inetAddress = InetAddress.getByName("192.168.1.4");
        System.out.println(inetAddress);
        //获取名称
        System.out.println(inetAddress.getHostName());
        //获取IP地址
        System.out.println(inetAddress.getHostAddress());


    }
}
