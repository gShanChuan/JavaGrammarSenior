package com.shanchuan.exer;

/**
 * 创建两个分线程，其中一个线程遍历100以内的偶数，另一个遍历100以内的奇数
 * @author ShanChuan
 * @create 2020-07-09 11:53
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        new Mythread1().start();
//        new Mythread2().start();

        //匿名子类对象
        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    if(i%2==0)
                        System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    if(i%2!=0)
                        System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }.start();
    }
}

class Mythread1 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class Mythread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            if(i%2!=0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}