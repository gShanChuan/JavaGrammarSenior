package com.shanchuan.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 15:562020/8/8
 */
public class ReflectionTest {
    //反射之前，对于person类的操作
    @Test
    public void tese1(){
        //1.创建person类的对象

        Person tom = new Person("tom", 20);

        //2.通过对象，调用其内部属性、方法
        tom.age=22;
        tom.show();

        //不可以调用私有的方法及其内部结构
        //如：name、showNation（）以及私有构造器
    }

    //反射之后，对于person类的操作
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<Person> personClass = Person.class;

        //1.通过反射，创建person类的对象
        Constructor<Person> cons = personClass.getConstructor(String.class, int.class);
        Person tom = cons.newInstance("tom", 22);

        //2.通过反射，调用其内部属性、方法
        Field age = personClass.getDeclaredField("age");
        age.set(tom,22);
        System.out.println(tom);

        Method show = personClass.getDeclaredMethod("show");
        show.invoke(tom);

        //通过反射,调用私有结构
        Constructor<Person> cons1 = personClass.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person jerry = cons1.newInstance("jerry");
        System.out.println(jerry);

        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry,"HanMeiMei");
        System.out.println(jerry);

        Method showNation = personClass.getDeclaredMethod("showNation");
        showNation.setAccessible(true);
        showNation.invoke(jerry);
    }

    /*
    加载到内存的类，我们就称为运行时类，作为Class的一个实例
    换句话说，Class的实例就对应着一个运行时类

    2.加载到内存中的运行时类，会缓存一定的时间，在此时间之内，我们
    可以通过不同的方式来获取此运行时类
     */
    //获取Class类实例的方法
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一:调用运行时类的属性：.class
        Class<Person> perClass1 = Person.class;
        System.out.println(perClass1);
        //方式二：类的对象：.getClass()
        Person person = new Person();
        Class perClass2 = person.getClass();
        System.out.println(perClass2);
        //方式三：调用Class的静态方法：forName(string classPath)
        //最常用
        Class perClass3 = Class.forName("com.shanchuan.java.Person");
        System.out.println(perClass3);


        System.out.println(perClass1==perClass2);
        System.out.println(perClass1==perClass3);

        //方式四：使用类的加载器
        ClassLoader loader = ReflectionTest.class.getClassLoader();
        Class perClass4 = loader.loadClass("com.shanchuan.java.Person");
        System.out.println(perClass4);

    }

    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;//接口
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;//枚举类
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
// 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }
}
