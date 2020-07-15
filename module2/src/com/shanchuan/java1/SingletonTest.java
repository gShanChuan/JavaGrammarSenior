package com.shanchuan.java1;

/**
 * 使用同步机制 将懒汉式改写成线程安全的
 *
 * @author ShanChuan
 * @create 2020-07-12 12:34
 */
public class SingletonTest {
}


class Bank {
    private Bank() {

    }

    private static Bank instance = null;

    //效率稍高
    public static Bank getInstance() {//添加synchronized修饰，实现锁

        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null)
                    instance = new Bank();
            }
        }
        return instance;
    }

    //以下方式效率稍差
//    public synchronized Bank getInstance() {//同步代码块
//        synchronized (Bank.class) {
//            if (instance == null)
//                instance = new Bank();
//            return instance;
//        }
//    }

//    public static synchronized Bank getInstance() {//添加synchronized修饰，实现锁
//        if (instance == null)
//            instance = new Bank();
//        return instance;
//    }
}