package com.shanchuan.java1;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * lock的使用
 *
 * @author ShanChuan
 * @create 2020-07-12 13:43
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w, "窗口1");
        Thread t2 = new Thread(w, "窗口2");
        Thread t3 = new Thread(w, "窗口3");


        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int ticket = 100;//天然的共享数据 只用一个对象就好饿

    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);//锁
    //fair：公平，先来先得

    @Override
    public void run() {
        while (true) {
//            saleTicket();
            try {
                //2.上锁
                lock.lock();

                if (ticket > 0){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":票号=" + ticket--);
                }
                else
                    break;
            } finally {
                //3.解锁
                lock.unlock();

            }
        }


    }

    private void saleTicket() {
        if (ticket > 0)
            System.out.println(Thread.currentThread().getName() + ":票号=" + ticket--);
    }
}