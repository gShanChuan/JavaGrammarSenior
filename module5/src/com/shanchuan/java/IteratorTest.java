package com.shanchuan.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @Description: 使用迭代器iterator方法遍历collection
 * 1.GOF给迭代器模式的定义为：提供一种方法访问一个容器(container)对象中各个元
 * 素，而又不需暴露该对象的内部细节。迭代器模式，就是为容器而生。
 * 2.遍历方式：hasnext和next配合使用
 * @Author: ShanChuan
 * @Data: 11:442020/7/23
 */
public class IteratorTest {
    //hasnext和next配合使用
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add()
        System.out.println("**************add************");
        coll.add(123);
        coll.add("aa");
        coll.add("AA");
        coll.add(new Date());

        //使用iterator方法遍历collection
        System.out.println("**************使用iterator方法遍历collection************");
        Iterator iterator = coll.iterator();
        //方式一
/*        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
//        System.out.println(iterator.next());*/
        //方式二
        /*for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());
        }*/
        //方式三
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //iterator中的remove方法
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        //add()
        System.out.println("**************add************");
        coll.add(123);
        coll.add("aa");
        coll.add("AA");
        coll.add(new Date());

        //iterator中的remove方法
        System.out.println("**************iterator中的remove方法************");
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if("aa".equals(next))
                iterator.remove();
        }

        System.out.println(coll);

    }
}
