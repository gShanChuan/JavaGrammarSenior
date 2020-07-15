package com.shanchuan.java;

/**
 * 继承方式  同步代码块
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

class Window1 extends Thread {

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {

        while (true) {
            //错误 this分别代表w1,w2,w3
//            synchronized (this) {
//            正确
            //synchronized (obj) {
            synchronized (Window1.class) {
                    if (ticket > 0)
                        System.out.println(getName() + ":票号为" + ticket--);
                    else
                        break;
            }
        }
    }
}
