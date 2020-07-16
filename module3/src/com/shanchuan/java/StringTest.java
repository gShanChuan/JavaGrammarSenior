package com.shanchuan.java;
import org.junit.Test;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 20:262020/7/15
 */

public class StringTest {

    /*
    不同拼接的方式对比：
        1.常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
        2.只要其中有一个是变量，结果就在堆中
        3.如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test3(){
        String s1 = "javaee";
        String s2 = "hadoop";

        String s3 = "javaeehadoop";
        String s4 = "javaee"+"hadoop";
        String s5 = s1+"hadoop";
        String s6 = "javaee"+s2;

        System.out.println(s3==s4);//true
        System.out.println(s3==s5);//false
        System.out.println(s3==s6);//false
        System.out.println(s5==s6);//false

        String s7 = s5.intern();
        System.out.println(s3==s7);//true


    }
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
