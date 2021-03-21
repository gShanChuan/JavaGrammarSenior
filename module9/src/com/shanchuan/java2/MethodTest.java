package com.shanchuan.java2;

import com.shanchuan.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description:
 *
 * 获取运行时类的方法结构
 * @Author: ShanChuan
 * @Data: 14:582020/8/9
 */
public class MethodTest {

    @Test
    public void test1(){
        Class<Person> aClass = Person.class;

        //getMethods仅能获取运行时类及其所有父类中声明为public的方法
        Method[] methods = aClass.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }

        //getDeclaredMethods获取运行时类声明的所有方法
        System.out.println();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method m : declaredMethods){
            System.out.println(m);
        }
    }

    /*
        @Xxx
        权限修饰符 返回值类型 方法名（形参列表）throws xxxException{}
     */
    @Test
    public void test2(){
        Class<Person> aClass = Person.class;
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method m : declaredMethods){
            //注解
            Annotation[] annotation = m.getAnnotations();
            for(Annotation a :annotation){
                System.out.println(a);
            }
            //权限修饰符
            System.out.print(Modifier.toString(m.getModifiers())+"\t\t");

            //返回值类型
            System.out.print(m.getReturnType().getName()+"\t\t");

            //方法名
            String name = m.getName();
            System.out.print(name);
            //形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if(parameterTypes!=null&&parameterTypes.length!=0){
                System.out.print('(');
                for(Class c : parameterTypes){
                    System.out.print(c.getName() + " args, ");
                }
                System.out.print(')'+"\t");
            }
            //抛出异常
            Class[] exceptionTypes = m.getExceptionTypes();

            if(exceptionTypes!=null&&exceptionTypes.length!=0){
                System.out.print("throws ");
                for(Class c : exceptionTypes){
                    System.out.print(c.getName() + " ");
                }
            }

            System.out.println();


        }
    }
}
