package com.shanchuan.java2;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * 一、set接口概述
 *       Set接口是Collection的子接口，set接口没有提供额外的方法
 *       Set 集合不允许包含相同的元素，如果试把两个相同的元素加入同一个Set 集合中，则添加操作失败。
 *       Set 判断两个对象是否相同不是使用 == 运算符，而是根据 equals() 方法
 *      >实现类：hashset、linkedhashset、treeset
 *      >set中没有添加新方法
 *
 * 二、set的无序、不可重复
 *      无序：不等于随机性
 *      不可重复性：保证添加的元素按照equals()判断时，不能返回true，即：相同的元素只能添加一个。
 * 三、添加元素的过程（hashset为例）：
 *      调用hashCode()方法，计算元素的哈希值，进而得到元素在底层数组上的索引，
 *      判断此索引位置上是否为空：
 *          没有，添加成功
 *          有，则比较哈希值：
 *              不相同，添加成功 -->情况1
 *              相同，则利用equals判断是否相等：
 *                  不相等，添加成功 -->情况2
 *                  相等，添加失败。
 *       情况1、2：添加的新元素与老元素以链表形式存储（七上八下）
 * 四：HashSet、LinkedHashSet、TreeSet
 * @Author: ShanChuan
 * @Data: 18:452020/7/23
 */
public class SetTest {
    //HashSet
    @Test
    public void test1(){
        HashSet set = new HashSet();
        set.add(132);
        set.add(2);
        set.add(3);
        set.add("gsc");
        set.add("g");
        set.add(new Date());

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet
    //添加时，还记录前后添加的元素，维护一个链表
    @Test
    public void test2(){
        LinkedHashSet set = new LinkedHashSet();
        set.add(123);
        set.add(2);
        set.add(3);
        set.add("gsc");
        set.add(new Date());

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //TreeSet
//    1.只能有相同类的才能存储
    //2.类需要实现两种比较器的一种
        //自然排序中，比较两个对象是否相等的标准为compareTo()
        //定制排序中，比较两个对象是否相等的标准为compare()
    @Test
    public void test3(){
//        TreeSet set = new TreeSet();
//
//        set.add(34);
//        set.add(23);
//        set.add(-1);
//        set.add(99);
//
//        Iterator iterator = set.iterator();
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare((Integer)o1,(Integer)o2);
            }
        };
        TreeSet set = new TreeSet(comparator);

        set.add(34);
        set.add(23);
        set.add(-1);
        set.add(99);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
