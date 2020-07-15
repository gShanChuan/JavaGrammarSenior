package com.shanchuan.java;
import org.junit.Test;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 20:262020/7/15
 */

public class StringTest {
    /*
    String的实例化方式：
        1.字面量
        2.new

     */
    @Test
    public void test2(){
        //1.声明在方法区中的字符串常量池，地址相同
        String s1 = "javaEE";
        String s2 = "javaEE";
        //2.声明在堆中，地址不同
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s3==s4);//false


    }
    /*
    String:字符串，使用一对“”引起来表示
        1.String声明为final，不可被继承
        2.String实现了Serializable接口：可序列化
                实现了Comparable接口：  可比较大小
        3.String内部定义了final char[] value用于存储字符串数据
        4.String：代表不可变的字符序列：不可变性
            重新赋值
            连接
            修改字符(relpace)
        5.通过字面量的方式给字符串变量赋值，此时值声明在字符串常量池
        6.字符串常量池中不会存储相同内容的字符串
     */
    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);

        s1="hello";

        System.out.println(s1);
        System.out.println(s2);

        System.out.println("********************");
        String s3 = "abc";
        s3+="def";
        System.out.println(s3);

        System.out.println("********************");
        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);
        System.out.println(s5);

    }
}
