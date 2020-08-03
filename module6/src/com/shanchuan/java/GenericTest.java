package com.shanchuan.java;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 *
 * 泛型的使用：
 * 一.jdk1.5新增的特性
 *
 * 二.在集合中使用泛型；
 *      >实例化集合类时，可以指明具体的泛型类型
 *      >指明后，在集合类或接口中，凡是定义类或接口时，
 *      内部结构使用到类的泛型的位置，都知道那指定为实例化的泛型类型。
 *      >没有指明泛型的类型，默认类型为Object类
 * 三.自定义泛型结构：泛型类、接口、方法
 * 四.注意事项
    1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：
    <E1,E2,E3>
    2. 泛型类的构造器如下：public GenericClass(){}。
    而下面是错误的：public GenericClass<E>(){}
    3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
    4. 泛型不同的引用不能相互赋值。
    >尽管在编译时ArrayList<String>和ArrayList<Integer>是两种类型，但是，在运行时只有
    一个ArrayList被加载到JVM中。
    5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价
    于Object。经验：泛型要使用一路都用。要不用，一路都不要用。
    6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
    7. jdk1.7，泛型的简化操作：ArrayList<Fruit> flist = new ArrayList<>();
    8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
    9. 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态
    属性的类型、非静态方法的参数类型、非静态方法的返回值类型。但在静态方法
    中不能使用类的泛型。
    10. 异常类不能是泛型的
    11. 不能使用new E[]。但是可以：E[] elements = (E[])new Object[capacity];
    参考：ArrayList源码中声明：Object[] elementData，而非泛型参数类型数组。
    12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：
         子类不保留父类的泛型：按需实现
             没有类型 擦除
             具体类型
         子类保留父类的泛型：泛型子类
             全部保留
             部分保留
    结论：子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型
 *
 * @Author: ShanChuan
 * @Data: 16:052020/8/1
 */
public class GenericTest {

    //测试泛型方法
    @Test
    public void test5(){
        CustomizeGenericTest<String> c = new CustomizeGenericTest();
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = c.copyFromArrayToList(new Integer[]{1, 23, 4});
        System.out.println(list);
    }
    //注意事项
    @Test
    public void test4(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        list1=list2;
    }
    //自定义泛型类
    @Test
    public void test3(){
        CustomizeGenericTest<String> c = new CustomizeGenericTest();
        c.setT("s");
        c.setT("sss");
        //子类指明泛型的类型，即是普通的类
        SubClass1 s1 = new SubClass1();
        s1.setT(122);
        //子类不指明,仍是泛型类
        SubClass2<String> s2 = new SubClass2();
        s2.setT("123");
    }

    //不使用泛型
    @Test
    public void test(){
        ArrayList list = new ArrayList();

        //需求存放学生的成绩
        list.add(78);
        list.add(100);
        list.add(34);
        list.add(89);
        list.add(80);
        //问题1:类型不安全
//        list.add("tom");

        for(Object score : list){

            //问题二：强转，可能出现类型转换异常ClassCastException
            int stuScore = (int) score;
            System.out.println(stuScore);

        }

    }

    //在集合中使用泛型，arraylist
    @Test
    public void test1(){
//        ArrayList<Integer> list = new ArrayList<Integer>();
        //类型推断 jdk7
        ArrayList<Integer> list = new ArrayList<>();

        //需求存放学生的成绩
        list.add(78);
        list.add(100);
        list.add(34);
        list.add(89);
        list.add(80);
        //编译时，进行类型检查，保证数据的安全
//        list.add("tom");

        //避免强转
        for(Integer score : list){

            int stuScore = score;
            System.out.println(stuScore);

        }
    }

    //在集合中使用泛型，hashmap
    @Test
    public void test2(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("tom",99);
        map.put("jack",90);
        map.put("jerry",81);
//        map.put(123,"sss");
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> set = map.entrySet();

        for (Map.Entry<String, Integer> next : set) {
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.print("key=" + key);
            System.out.println(",value=" + value);
        }

    }
}
