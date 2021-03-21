package com.shanchuan.java2;

import com.shanchuan.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 *
 * 调用运行时类  指定的结构、属性、方法、构造器
 *
 * @Author: ShanChuan
 * @Data: 10:412020/8/10
 */
public class ReflectionTest {

    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> aClass = Person.class;

        Person p = aClass.newInstance();
        //getField获取运行类中和父类声明为public的指定的属性
        Field id = aClass.getField("id");
        /*
        设置当前属性的值
         */
        id.set(p,203);
        /*
        获取当前属性的值
         */
        System.out.println(id.get(p));
    }
    @Test
    public void testField1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> aClass = Person.class;

        Person p = aClass.newInstance();
        //getDeclaredField获取运行类中指定的属性 不论权限
        Field name = aClass.getDeclaredField("name");
        //2.设置当前属性是可访问的
        name.setAccessible(true);

        name.set(p,"tom");
        System.out.println(name.get(p));

    }

    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Person> aClass = Person.class;
        Person person = aClass.newInstance();

//        getDeclaredMethod

        Method show = aClass.getDeclaredMethod("show", String.class);

        show.setAccessible(true);

        String result = (String)show.invoke(person, "中国");
        System.out.println(result);

        //静态方法
        Method sMethod = aClass.getDeclaredMethod("sMethod");
        sMethod.setAccessible(true);
        //第一个参数随便填
        System.out.println(sMethod.invoke(aClass));
    }

    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;

        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person tom = declaredConstructor.newInstance("tom");
        System.out.println(tom);


    }
}
