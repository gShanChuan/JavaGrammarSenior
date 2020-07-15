package com.shanchuan.java2;

/**
 * 线程通信：使用两个线程打印 1-100。线程1, 线程2 交替打印
 * @author ShanChuan
 * @create 2020-07-12 20:22
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{

    private int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //唤醒
                notifyAll();

                if (num <= 100)
                    System.out.println(Thread.currentThread().getName() + ":" + (num++));
                else
                    break;
                //睡眠
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}