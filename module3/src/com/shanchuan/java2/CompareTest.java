package com.shanchuan.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: java对象之间的比较问题（comparable、comparator）
 * comparable、comparator的比较：
 *  comparable接口的方式一旦确定，保证实现comparable接口的类的对象在任何位置都可以比较大小
 *  comparator接口的方式属于临时性
 * @Author: ShanChuan
 * @Data: 17:492020/7/18
 */
public class CompareTest {

    /*
        comparable的使用: 自然排序
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

    /*
        comparator接口的使用：定制排序
            1.当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码，
            或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
            那么可以考虑使用 Comparator 的对象来排序
            2.重写compare(Object o1,Object o2)方法，比较o1和o2的大小：如果方法返
            回正整数，则表示o1大于o2；如果返回0，表示相等；返回负整数，表示
            o1小于o2。
     */
    @Test
    public void test3() {
        String[] arr = new String[]{"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        //按照从大到小的顺序
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("razer",134);
        arr[1] = new Goods("xiaomi",99);
        arr[2] = new Goods("罗技",399);
        arr[3] = new Goods("罗技",22);
        arr[4] = new Goods("华为",22);
        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
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