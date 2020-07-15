package com.shanchuan.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * JDK5.0 新增线程创建方式 新增方式一：实现Callable接口
 * @author ShanChuan
 * @create 2020-07-13 13:48
 */
public class CallableTest {
    public static void main(String[] args) {
        NumThread n = new NumThread();
        FutureTask f = new FutureTask(n);

        new Thread(f).start();

        try {
            Object value = f.get();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0 ;

        for (int i = 1; i <= 100; i++) {
            Thread.sleep(100);
            if(i%2==0) {
                System.out.println(i);
                sum += i;
            }
        }

        return sum;//自动装箱
    }
}