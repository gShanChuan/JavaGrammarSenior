package com.shanchuan.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * @Description:
 * 一、集合框架的概述
 *  1.集合、数组都是对多个数据进行存储操作的数据结构
 *  2.数组在存储多个数据方面的特点
 *      >一旦初始化后，其长度确定
 *      >其元素类型确定
 *  3.框架结构
 *  Java 集合可分为 Collection 和 Map 两种体系
 *      Collection接口：单列数据，定义了存取一组对象的方法的集合
 *          List：元素有序、可重复的集合
 *          Set：元素无序、不可重复的集合
 *       Map接口：双列数据，保存具有映射关系“key-value对”的集合
 * 4.Collection接口中的常用方法
 * @Author: ShanChuan
 * @Data: 13:252020/7/22
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add()
        System.out.println("**************add************");
        coll.add(123);
        coll.add("aa");
        coll.add("AA");
        coll.add(new Date());
        System.out.println(coll);

        //size() 获取添加的元素的个数
        System.out.println("**************size************");
        System.out.println(coll.size());

        //addAll()
        System.out.println("**************addAll************");
        Collection coll1 = new ArrayList();
        coll1.add('e');
        coll1.add('w');
        coll.addAll(coll1);
        System.out.println(coll);

        //isEmpty()
        System.out.println("**************isEmpty************");
        System.out.println(coll.isEmpty());
        //contains() 判断是否包含obj 判断依据是值是否相同
//        即利用equals()
        System.out.println("**************contains************");
        System.out.println(coll.contains(123));
        //containsAll()
        System.out.println("**************containsAll************");
        System.out.println(coll.containsAll(coll1));
        //remove() 移除指定obj,判断依据是值是否相同
        // 即利用equals()
        System.out.println("**************remove************");
        coll.remove('w');
        System.out.println(coll);
        //removeAll() 有啥移啥 最后结果为差集
        System.out.println("**************removeAll************");
        coll.removeAll(coll1);
        System.out.println(coll);
        //retainAll() 有啥不移啥 最后结果为交集
        System.out.println("**************retainAll************");
        coll1.add(123);
        coll.retainAll(coll1);
        System.out.println(coll);
        //equals()
        System.out.println("**************equals************");
        Collection coll2 = Arrays.asList(123);
        System.out.println(coll.equals(coll2));
        //hashCode()
        System.out.println("**************hashCode************");
        System.out.println(coll.hashCode());
        //toArray()
        System.out.println("**************toArray************");
        System.out.println(Arrays.toString(coll.toArray()));
        //iterator()

        //clear()
        System.out.println("**************clear************");
        coll.clear();
        System.out.println(coll);

    }

}
