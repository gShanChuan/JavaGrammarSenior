package com.shanchuan.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 *
 * 1.泛型在继承方面的体现
 * 2.通配符的使用
 *
 * @Author: ShanChuan
 * @Data: 21:592020/8/1
 */
public class GenericTest {

    //泛型在继承方面的体现
    //类A是类B的父类，G<A> 和 G<B>二者不具备子父类关系，二者是并列关系
    @Test
    public void test(){
        Object o1 = null;
        String o2 = null;
        o1=o2;

        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
//        list1=list2;
    }

    /*
     通配符的使用
        通配符：？
        类A是类B的父类，G<A> 和 G<B>二者不具备子父类关系，二者是并列关系
        二者共同的父类是G<?>
     */
    @Test
    public void test1(){
        ArrayList<Object> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        ArrayList<?> list3=null;
        list3=list1;
        list3=list2;

        list2.add("aa");
        //添加：对于list<?>就不能添加数据
        //出了添加null
        list3.add(null);

        //读取
        System.out.println(list3.get(0));
    }

    /*
     有限制的通配符的使用
     通配符指定上限
        上限extends：使用时指定的类型必须是继承某个类，或者实现某个接口，即<=
     通配符指定下限
        下限super：使用时指定的类型不能小于操作的类，即>=
     举例：
         <? extends Number> (无穷小 , Number]
        只允许泛型为Number及Number子类的引用调用
         <? super Number> [Number , 无穷大)
        只允许泛型为Number及Number父类的引用调用
         <? extends Comparable>
        只允许泛型为实现Comparable接口的实现类的引用调用
     */
    @Test
    public void test2(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1=list3;
        list1=list4;
//        list1=list5;

//        list2=list3;
        list2=list4;
        list2=list5;




    }

}
