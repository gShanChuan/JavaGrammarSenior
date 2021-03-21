package com.shanchuan.java2;

import com.shanchuan.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 15:562020/8/9
 */
public class OtherTest {
    /*
        构造器
     */
    @Test
    public void test1(){

        Class<Person> aClass = Person.class;
        //getConstructors仅能获取运行时类中声明为public的构造器
        Constructor[] constructors = aClass.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }
        //getDeclaredConstructors仅能获取运行时类中声明的所有构造器
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for(Constructor c : declaredConstructors){
            System.out.println(c);
        }
    }

    //父类
    @Test
    public void test2(){

        Class<Person> aClass = Person.class;
        //父类
        Class<? super Person> superclass = aClass.getSuperclass();
        System.out.println(superclass);
    }

    //带泛型的父类
    @Test
    public void test3(){

        Class<Person> aClass = Person.class;
        //带泛型的父类
        Type genericSuperclass = aClass.getGenericSuperclass();
        System.out.println(genericSuperclass);

    }

    //父类的泛型
    @Test
    public void test4(){

        Class<Person> aClass = Person.class;
        Type genericSuperclass = aClass.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for(Type t : actualTypeArguments){
            System.out.println(t.getTypeName());
        }

    }

    //接口
    @Test
    public void test5(){
        Class<Person> aClass = Person.class;
        Class[] interfaces = aClass.getInterfaces();
        for(Class c : interfaces){
            System.out.println(c);
        }
        //父类的接口
        Class[] interfaces1 = aClass.getSuperclass().getInterfaces();
        for(Class c : interfaces1){
            System.out.println(c);
        }
    }

    //包
    @Test
    public void test6(){
        Class<Person> aClass = Person.class;
        Package aPackage = aClass.getPackage();
        System.out.println(aPackage.getName());
    }

    //注解
    @Test
    public void test7(){
        Class<Person> aClass = Person.class;
        Annotation[] annotations = aClass.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }

}
