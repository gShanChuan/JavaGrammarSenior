package com.shanchuan.java;

/**
 * 创建3个窗口买票 ，总票数为100张,实现Runnable接口
 *
 * @author ShanChuan
 * @create 2020-07-09 15:56
 */
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w = new Window2();
        Thread t1 = new Thread(w, "窗口1");
        Thread t2 = new Thread(w, "窗口2");
        Thread t3 = new Thread(w, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}

class Window2 implements Runnable {
    private int ticket = 100;//天然的共享数据 只用一个对象就好饿

    @Override
    public void run() {
        while (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + ":票号=" + ticket--);
        }
    }
}