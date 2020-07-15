package com.shanchuan.java;

/**
 * 多线程的创建方式一：继承Thread类
 * @author ShanChuan
 * @create 2020-07-09 11:15
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();

        //必须调用start方法
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();

        for (int i = 1; i < 10; i++) {
            if(i%2!=0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
}

//求解100以内的偶数
class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}