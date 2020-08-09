package com.shanchuan.java1;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 12:192020/8/9
 */
@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparable<String> , MyInterface{

    private String name;
    int age;
    public int id;

    @MyAnnotation("abc")
    public Person(){}
    private Person(String name){
        this.name=name;
    }

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    @MyAnnotation
    private String show(String nation) throws NullPointerException,ClassNotFoundException{
        System.out.println("我的国籍"+nation);
        return nation;
    }
    public String display(String interests,int age){
        return interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
    @Override
    public void info() {

    }
}
