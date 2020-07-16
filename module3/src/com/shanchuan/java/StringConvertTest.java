package com.shanchuan.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Description: String与其他结构的转换
 * @Author: ShanChuan
 * @Data: 13:512020/7/16
 */
public class StringConvertTest {
    /*
        String与字节数组之间的转换
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] b1 = s1.getBytes();//使用默认的字符集 编码
        System.out.println(Arrays.toString(b1));
        byte[] b2 = s1.getBytes("gbk");//使用gbk字符集 一个字编码两个字节
        System.out.println(Arrays.toString(b2));

        String s3 = new String(b1);//使用默认的字符集 解码
        System.out.println(s3);
        String s4 = new String(b1,"gbk");//编码集和解码集不同
        System.out.println(s4);
        String s5 = new String(b2,"gbk");//使用gbk字符集 解码
        System.out.println(s5);

    }
    /*
        String与char数组之间的转换
     */
    @Test
    public void test2(){
        //toCharArray()
        String s1 = "abc123";
        char[] c1 = s1.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            System.out.println(c1[i]);
        }
        //new String(c1)
        String s2 = new String(c1);
        System.out.println(s2);
    }

    /*
        String与基本数据类型、包装类之间的转换
     */
    @Test
    public void test1(){
        //string->基本数据类型、包装类
        String s1 = "123";
        int n1 = Integer.parseInt(s1);
        System.out.println(n1);
        //基本数据类型、包装类->string
        String s2 = String.valueOf(n1);
        System.out.println(s2);
    }
}
