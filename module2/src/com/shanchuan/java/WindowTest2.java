package com.shanchuan.java;

/**
 * 实现接口方式 同步代码块
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
    //锁
//    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticket > 0)
                    System.out.println(Thread.currentThread().getName() + ":票号=" + ticket--);
                else
                    break;
            }
        }
    }
}