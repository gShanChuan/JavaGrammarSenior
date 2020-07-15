package com.shanchuan.java2;

/**
 * 生产者/消费者问题
 * <p>
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处
 * 取走产品，店员一次只能持有固定数量的产品(比如:20），如果生产者试图
 * 生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通
 * 知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * <p>
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 *
 * @author ShanChuan
 * @create 2020-07-12 21:20
 */
//到家
public class ProductTest {

    public static void main(String[] args) {
        Clerk c = new Clerk();
        Productor pro = new Productor(c);
        Customer cus = new Customer(c);

        Thread t1 = new Thread(pro, "生产者");
        Thread t2 = new Thread(cus, "消费者1");
        Thread t3 = new Thread(cus, "消费者2");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Clerk {
    private int productNum;

    public synchronized void saleProduct() {//同步监视器：Clerk c
        if (productNum > 0) {
            System.out.println(Thread.currentThread().getName() + ":消费第" + productNum + "产品");
            productNum--;
            notify();
        } else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void produceProduct() {//同步监视器：Clerk c

        if (productNum < 20) {
            productNum++;
            System.out.println(Thread.currentThread().getName() + ":生产第" + productNum + "产品");
            notify();
        } else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public int nowProductNum() {
        return productNum;
    }
}

class Productor implements Runnable {
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.produceProduct();
        }

    }
}

class Customer implements Runnable {

    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.saleProduct();
        }
    }
}
