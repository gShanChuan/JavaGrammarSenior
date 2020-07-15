package com.shanchuan.java;

/**
 * Thread类中常见方法说明
 *
 * @author ShanChuan
 * @create 2020-07-09 12:10
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        //修改构造器命名
        TestThread t1 = new TestThread("线程1");
        //设置分线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);
//        t1.setName("线程1");
        t1.start();

        //主线程命名
        Thread.currentThread().setName("主线程");
        //设置主线程的优先级
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName()
                        + ":" + Thread.currentThread().getPriority() + ":" + i);
            //使得主线程进入阻塞，唤醒副线程
            //            if (i % 10 == 0) {
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(t1.isAlive());
    }

}

class TestThread extends Thread {

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//睡眠指定秒数
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(getName() + ":" + getPriority() + ":" + i);
            }
//放弃cpu执行权
//            if(i%10==0)
//                yield();
        }
    }
}

