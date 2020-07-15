package com.shanchuan.java;

/**
 * 创建多线程的方式二：实现Runnable接口的类
 * @author ShanChuan
 * @create 2020-07-09 15:38
 */
public class ThreadTest2 {
    public static void main(String[] args) {
        MThread mThread = new MThread();

        Thread t1 = new Thread(mThread);
        Thread t2 = new Thread(mThread);

        t1.start();
        t2.start();

    }
}

class MThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0)
                System.out.println(Thread.currentThread().getName() +":"+ i);
        }
    }
}
