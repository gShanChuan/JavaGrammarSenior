package com.shanchuan.java3;

import com.shanchuan.SetExer.Employee;
import com.shanchuan.SetExer.MyDate;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Description:
 *
 * TreeMap两种添加方式的使用
 *
 * @Author: ShanChuan
 * @Data: 17:512020/7/31
 */
public class TreeMapTest {
    //key为同一类的对象
    //自然排序
    @Test
    public void test(){
        TreeMap map = new TreeMap();

        Employee e1 = new Employee("b山川",22,new MyDate(1998,10,27));
        Employee e2 = new Employee("c子川",18,new MyDate(2002,6,11));
        Employee e3 = new Employee("d小川",18,new MyDate(2002,6,11));
        Employee e4 = new Employee("a黎明",54,new MyDate(1970,1,1));
        Employee e5 = new Employee("e刘德华",45,new MyDate(175,4,27));

        map.put(e1,1);
        map.put(e2,2);
        map.put(e3,3);
        map.put(e4,4);
        map.put(e5,5);

        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

    //定制排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Employee e1 = (Employee)o1;
                Employee e2 = (Employee)o2;
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        Employee e1 = new Employee("b山川",22,new MyDate(1998,10,27));
        Employee e2 = new Employee("c子川",18,new MyDate(2002,6,11));
        Employee e3 = new Employee("d小川",17,new MyDate(2002,6,11));
        Employee e4 = new Employee("a黎明",54,new MyDate(1970,1,1));
        Employee e5 = new Employee("e刘德华",45,new MyDate(175,4,27));

        map.put(e1,1);
        map.put(e2,2);
        map.put(e3,3);
        map.put(e4,4);
        map.put(e5,5);

        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

}
