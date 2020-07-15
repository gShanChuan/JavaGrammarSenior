package com.shanchuan.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四：线程池
 * @author ShanChuan
 * @create 2020-07-13 18:02
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //1.获得指定数量线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //设置线程池的属性
//        System.out.println(service.getClass());
//        ThreadPoolExecutor t = (ThreadPoolExecutor)service;
//        t.setCorePoolSize(15);
//        t.setKeepAliveTime();
        //2.执行指定的线程操作
        NumberThread n = new NumberThread();
        service.execute(n);//适合使用于runnable
        service.execute(n);//适合使用于runnable
        //3.关闭连接池
        service.shutdown();
//        service.submit();//适合使用于callable
    }
}

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}