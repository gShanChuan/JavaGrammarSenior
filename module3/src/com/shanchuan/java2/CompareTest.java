package com.shanchuan.java2;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: java对象之间的比较问题（comparable、comparator）
 * @Author: ShanChuan
 * @Data: 17:492020/7/18
 */
public class CompareTest {

    /*
        comparable的使用:
            实现compareTo():
                如果当前对象this大于形参对象obj，则返回正整数，如果当前对象this小于形参对象obj，则返回
                负整数，如果当前对象this等于形参对象obj，则返回零。
     */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){

        Goods[] arr = new Goods[5];
        arr[0] = new Goods("razer",134);
        arr[1] = new Goods("xiaomi",99);
        arr[2] = new Goods("罗技",399);
        arr[3] = new Goods("罗技",22);
        arr[4] = new Goods("华为",22);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

//com.shanchuan.java2.Goods cannot be cast to java.lang.Comparable
class Goods implements Comparable{
    private String name;
    private int price;

    public Goods() {
    }

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Goods){
            Goods g = (Goods)o;
            if(this.price != g.getPrice())
                return this.price-g.getPrice();
            else
                //某属性相等，继续按不同属性排序
                return this.name.compareTo(g.getName());
        }
        throw new RuntimeException("传入数据类型不一致");
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}