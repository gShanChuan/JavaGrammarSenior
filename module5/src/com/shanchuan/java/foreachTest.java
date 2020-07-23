package com.shanchuan.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @Description:
 * Java 5.0 提供了 foreach 循环迭代访问 Collection和数组。
 * @Author: ShanChuan
 * @Data: 14:302020/7/23
 */
public class foreachTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        //add()
        System.out.println("**************add************");
        coll.add(123);
        coll.add("aa");
        coll.add("AA");
        coll.add(new Date());

        //for( 集合中元素的类型 局部变量: 集合对象)
        for(Object obj:coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3};
        //for( 数组中元素的类型 局部变量: 数组对象)
        for(int i:arr){
            System.out.println(i);
        }

    }
}
