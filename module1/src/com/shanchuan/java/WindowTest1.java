package com.shanchuan.java;

/**
 * 创建3个窗口买票 ，总票数为100张,继承Thread的方式
 * 存在线程安全问题
 *
 * @author ShanChuan
 * @create 2020-07-09 15:23
 */
public class WindowTest1 {
    public static void main(String[] args) {

        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }

}

class Window1 extends Thread{

    private static int ticket = 100;

    @Override
    public void run() {

        while(ticket>0){
            if(ticket>0)
                System.out.println(getName()+":票号为"+ticket--);
        }
    }
}
