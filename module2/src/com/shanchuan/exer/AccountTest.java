package com.shanchuan.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打
 * 印账户余额。
 *
 * @author ShanChuan
 * @create 2020-07-12 19:54
 */
public class AccountTest {
    public static void main(String[] args) {
        Customer a = new Customer(new Account(0));
        Thread t1 = new Thread(a,"储户1");
        Thread t2 = new Thread(a,"储户2");

        t1.start();
        t2.start();
    }

}

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double money) {
        this.balance += money;
    }
}

class Customer implements Runnable {

    private Account account;
    ReentrantLock lock = new ReentrantLock(true);

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {

            try {
                lock.lock();
                account.deposit(1000);
                System.out.println(Thread.currentThread().getName() + "存钱1000，"
                        + "余额:" + account.getBalance());
            } finally {
                lock.unlock();
            }

        }
    }
}