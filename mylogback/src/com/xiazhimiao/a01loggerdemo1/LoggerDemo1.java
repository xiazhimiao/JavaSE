package com.xiazhimiao.a01loggerdemo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LoggerDemo1 {
    //获取日志对象
    public static final Logger LOGGER = LoggerFactory.getLogger(LoggerDemo1.class);

    public static void main(String[] args) {

        //登录操作
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String userName = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        if("zhangsan".equals(userName)&&"123".equals(password)){
            System.out.println("登录成功");
            LOGGER.info("账号为:"+userName+",密码为:"+password+"的用户登录成功");
        }else {
            System.out.println("登录失败");
            LOGGER.info("账号为:"+userName+",密码为:"+password+"的用户登录失败");
        }
    }
}
