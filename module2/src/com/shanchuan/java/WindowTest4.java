package com.shanchuan.java;

/**
 * 继承方式 同步方法
 * 创建3个窗口买票 ，总票数为100张,继承Thread的方式
 * 存在线程安全问题
 *
 * @author ShanChuan
 * @create 2020-07-09 15:23
 */
public class WindowTest4 {
    public static void main(String[] args) {

        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }

}

class Window4 extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {

        while(true){
            saleTicket();
        }
    }

//    private synchronized void saleTicket() 此时锁为this
    private static synchronized void saleTicket() {//此时锁为Window4.class
        if (ticket > 0)
            System.out.println(Thread.currentThread().getName() + ":票号=" + ticket--);
    }
}
