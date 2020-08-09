package com.shanchuan.java;

import org.junit.Test;

import java.util.Random;

/**
 * @Description:
 * 通过反射创建运行时类的对象
 * @Author: ShanChuan
 * @Data: 11:152020/8/9
 */

public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> pClass = Person.class;
        /*
            newInstance():调用此方法，创建对应的运行时类的对象
            1.调用空参构造器
            2.空参构造器访问权限得够
         */
        Person person = pClass.newInstance();
        System.out.println(person);

    }

    //体会反射的动态性
    @Test
    public void test2(){
        int i = new Random().nextInt(3);
        String classPath = "";
        switch (i){
            case 0:
                classPath="java.util.Date";
                break;
            case 1:
                classPath="java.lang.Object";
                break;
            case 2:
                classPath="com.shanchuan.java.Person";
                break;
        }

        try {
            System.out.println(getInstance(classPath));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    /*
        创建一个指定类的对象
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
