package com.shanchuan.java2;

import com.shanchuan.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Description:
 *
 * 获取当前运行时类的属性结构
 *
 * @Author: ShanChuan
 * @Data: 12:522020/8/9
 */
public class FieldTest {

    @Test
    public void test1(){
        Class aClass = Person.class;

        //获取属性结构
        // getFields仅能获取运行时类及其所有父类中声明为public的属性
        Field[] fields = aClass.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        //getDeclaredFields获取运行时类声明的所有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f);
        }
    }

    //权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class aClass = Person.class;
        Field[] declaredFields = aClass.getDeclaredFields();
        for(Field f:declaredFields){
            //1.权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers)+'\t');
            //2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName()+'\t');
            //3.变量名
            String name = f.getName();
            System.out.println(name);
        }
    }

}
