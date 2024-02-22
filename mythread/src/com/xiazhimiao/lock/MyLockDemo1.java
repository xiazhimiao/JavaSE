package com.xiazhimiao.lock;

public class MyLockDemo1 {
    public static void main(String[] args) {
        //创建任务
        MyLock1 mylock1 = new MyLock1();

        //创建进程
        Thread thread1 = new Thread(mylock1);
        Thread thread2 = new Thread(mylock1);
        Thread thread3 = new Thread(mylock1);

        //进程给名字
        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");

        //启动进程
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
