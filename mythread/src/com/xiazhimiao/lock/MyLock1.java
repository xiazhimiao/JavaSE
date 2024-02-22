package com.xiazhimiao.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock1 implements Runnable {
    //用lock+同步方法实现
    int i = 0;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {

            try {
                lock.lock();
                if (i == 100){
                    break;
                }
                i++;
                System.out.println(Thread.currentThread().getName() + "@" + i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                //把开锁写在这里，确保一定会开锁
                //不然可能造成没有开锁，进程无法结束的问题
                lock.unlock();
            }
        }


    }
}
