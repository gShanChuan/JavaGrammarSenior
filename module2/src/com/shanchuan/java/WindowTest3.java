package com.shanchuan.java;

/**
 * 实现方式 同步方法
 *
 * @author ShanChuan
 * @create 2020-07-10 14:33
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w, "窗口1");
        Thread t2 = new Thread(w, "窗口2");
        Thread t3 = new Thread(w, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window3 implements Runnable {
    private int ticket = 100;//天然的共享数据 只用一个对象就好饿

    @Override
    public void run() {
        while (true) {
            saleTicket();
        }
    }

    private synchronized void saleTicket() {
        if (ticket > 0)
            System.out.println(Thread.currentThread().getName() + ":票号=" + ticket--);
    }
}