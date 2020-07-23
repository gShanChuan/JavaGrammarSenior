package com.shanchuan.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * 一、List接口概述
 *       鉴于Java中数组用来存储数据的局限性，我们通常使用List替代数组
 *       List集合类中元素有序、且可重复，集合中的每个元素都有其对应的顺序索引。
 *       List容器中的元素都对应一个整数型的序号记载其在容器中的位置，可以根据
 *      序号存取容器中的元素。
 *       JDK API中List接口的实现类常用的有：
 *          ArrayList：主要实现类，线程不安全、底层使用object[] elementDate
 *          LinkedList：底层使用双向链表
 *          Vector：古老实现类，线程安全、object[] elementDate
 * 二、list中常用方法
 * List除了从Collection集合继承的方法外，List 集合里添加了一些根据索引来
 * 操作集合元素的方法。
 * void add(int index, Object ele):在index位置插入ele元素
 * boolean addAll(int index, Collection eles):从index位置开始将eles中
 * 的所有元素添加进来
 * Object get(int index):获取指定index位置的元素
 * int indexOf(Object obj):返回obj在集合中首次出现的位置
 * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * Object remove(int index):移除指定index位置的元素，并返回此元素
 * Object set(int index, Object ele):设置指定index位置的元素为ele
 * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
 * 位置的子集合
 *
 * @Author: ShanChuan
 * @Data: 15:052020/7/23
 */
public class ListTest {
    @Test
    public void test(){

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add("gsc");
        System.out.println(list);
        //void add(int index, Object ele):在index位置插入ele元素
        System.out.println("*******add(int index, Object ele)**********");
        list.add(1,'a');
        System.out.println(list);
        //boolean addAll(int index, Collection eles):从index位置开始将eles中
        //的所有元素添加进来
        System.out.println("*******addAll(int index, Collection eles)**********");
        List<Integer> list1 = Arrays.asList(7, 8, 9);
        list.addAll(1,list1);
        System.out.println(list);
        //Object get(int index):获取指定index位置的元素
        System.out.println("*******Object get(int index)**********");
        System.out.println(list.get(0));
        //indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println("*******indexOf(Object obj)**********");
        System.out.println(list.indexOf("dd"));
        //lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        System.out.println("*******lastIndexOf(Object obj)**********");
        System.out.println(list.indexOf("gsc"));
        //Object remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println("*******Object remove(int index)**********");
        list.remove(0);
        System.out.println(list);
        //Object set(int index, Object ele):设置指定index位置的元素为ele
        System.out.println("*******set(int index, Object ele)**********");
        list.set(0,"java");
        System.out.println(list);
        //subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
        // * 位置的子集合
        System.out.println("*******subList(int fromIndex, int toIndex)**********");
        System.out.println(list.subList(0, 2));

    }
}
