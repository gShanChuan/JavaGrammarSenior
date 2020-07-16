package com.shanchuan.java;

import org.junit.Test;

/**
 * @Description: StringBuffer类和StringBuilder类的使用
 * @Author: ShanChuan
 * @Data: 15:452020/7/16
 */
public class StringBufferBuilder {

    /*
        String、StringBuffer、StringBuilder效率对比：
            StringBuilder > StringBuffer > String
     */
    @Test
    public void test3() {
        //初始设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }

    /*
        StringBuffer常用方法:
            StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
            StringBuffer delete(int start,int end)：删除指定位置的内容
            StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
            StringBuffer insert(int offset, xxx)：在指定位置插入xxx
            StringBuffer reverse() ：把当前字符序列逆转
            public int indexOf(String str)
            public String substring(int start,int end)
            public int length()
            public char charAt(int n )
            public void setCharAt(int n ,char ch)
     */
    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer();
        //append()
        s1.append("abcedf");
        s1.append('1');
        System.out.println(s1);
        //delete
        s1.delete(1, 3);
        System.out.println(s1);
        //replace
        s1.replace(0, 4, "hello");
        System.out.println(s1);
        //insert
        s1.insert(6, false);
        System.out.println(s1);
        //reverse
        s1.reverse();
        System.out.println(s1);


    }

    /*
        String:不可变的字符序列、
        StringBuffer:可变的字符序列、线程安全
        StringBuilder:可变的字符序列、线程不安全、jdk5.0新增

        均使用char数组存储

        源码分析：
        String str = new String();//new char[0]
        String str1 = new String(“abc”);//new char[]{'a','b','c'}

        StringBuffer sb = new StringBuffer();//new char[16]
        sb.append('a');//value[0]='a'
        sb.append('b');//value[1]='b'

        StringBuffer sb1 = new StringBuffer("abc");//new char[16+"abc".length()]
        //append("abc")

        问题1.sout(sb1.length())?
            3
        问题2.扩容?
            默认情况下，扩容为原本容量的2倍+2，同时将原有数组的元素复制到新数组中

        指导意义：若需经常扩容，即多次使用append，建议使用：StringBuffer(int capacity)

     */
    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0

    }
}
