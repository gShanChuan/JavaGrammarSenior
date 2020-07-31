package com.shanchuan.SetExer;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 20:562020/7/30
 */
public class EmployeeTest {

    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        Employee e1 = new Employee("b山川",22,new MyDate(1998,10,27));
        Employee e2 = new Employee("c子川",18,new MyDate(2002,6,11));
        Employee e3 = new Employee("d小川",18,new MyDate(2002,6,11));
        Employee e4 = new Employee("a黎明",54,new MyDate(1970,1,1));
        Employee e5 = new Employee("e刘德华",45,new MyDate(175,4,27));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        for(Object o : set){
            System.out.println(o);
        }

    }

    @Test
    public void test2(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Employee e1 = (Employee)o1;
                Employee e2 = (Employee)o2;

                MyDate e1Birthday = e1.getBirthday();
                MyDate e2Birthday = e2.getBirthday();

                int minusYear = e1Birthday.getYear() - e2Birthday.getYear();
                if(minusYear != 0)
                    return minusYear;
                int minusMonth = e1Birthday.getMonth() - e2Birthday.getMonth();
                if(minusMonth != 0)
                    return minusMonth;
                int minusDay = e1Birthday.getDay() - e2Birthday.getDay();
                if(minusDay != 0)
                    return minusDay;
                return 0;

            }
        });

        Employee e1 = new Employee("b山川",22,new MyDate(1998,10,27));
        Employee e2 = new Employee("c子川",18,new MyDate(2002,6,11));
        Employee e3 = new Employee("d小川",18,new MyDate(2002,6,10));
        Employee e4 = new Employee("a黎明",54,new MyDate(1970,1,1));
        Employee e5 = new Employee("e刘德华",45,new MyDate(1975,4,27));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        for(Object o : set){
            System.out.println(o);
        }

    }
}
