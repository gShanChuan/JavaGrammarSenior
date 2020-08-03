package com.shanchuan.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 *
 * 自定义泛型类
 *
 * @Author: ShanChuan
 * @Data: 17:472020/8/1
 */
public class CustomizeGenericTest<T>{

    String name;
    int    id;
    //类的内部结构可以使用泛型
    T t;

    public CustomizeGenericTest(){

    }
    public CustomizeGenericTest(String name,int id,T t){
        this.name=name;
        this.id=id;
        this.t=t;
    }

    public T getT(){
        return t;
    }

    public void setT(T t){
        this.t=t;
    }

    @Override
    public String toString() {
        return "CustomizeGenericTest{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", t=" + t +
                '}';
    }

    //泛型方法：在方法中出现了新的泛型参数，与类的泛型参数无关
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E>  list = new ArrayList<>();

        for(E e : arr){
            list.add(e);
        }
        return list;
    }
}

//指明泛型的类型
class SubClass1 extends CustomizeGenericTest<Integer>{

}

//不指明泛型的类型
class SubClass2<T> extends CustomizeGenericTest<T>{

}