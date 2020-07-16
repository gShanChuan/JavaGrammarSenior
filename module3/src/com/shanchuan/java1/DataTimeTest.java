package com.shanchuan.java1;

import org.junit.Test;
import java.util.Date;


/**
 * @Description: JDK 8之前的日期时间API
 * @Author: ShanChuan
 * @Data: 22:122020/7/16
 */
public class DataTimeTest {
    /*
     java.util.Date类:表示特定的瞬间，精确到毫秒
        -->java.sql.Date类
     构造器：
         Date()：使用无参构造器创建的对象可以获取本地当前时间。
         Date(long date)
     常用方法
         getTime():返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象
        表示的毫秒数。
         toString():把此 Date 对象转换为以下形式的 String： dow mon dd
        hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun, Mon, Tue,
        Wed, Thu, Fri, Sat)，zzz是时间标准。
     */
    @Test
    public void test2() {
        //构造器1: Date()
        Date data1 = new Date();
        System.out.println(data1);//Thu Jul 16 22:23:07 CST 2020
        System.out.println(data1.getTime());//1594909479828
        //构造器2：Date(long date)
        Date date2 = new Date(1594909479828l);
        System.out.println(date2);
        //java.sql.data类
        java.sql.Date date3 = new java.sql.Date(1594909479828l);
        System.out.println(date3);//2020-07-16
        //new的util.date->new的sql.date
        Date data4 = new Date();
        java.sql.Date data5 = new java.sql.Date(data4.getTime());
    }

    /*
    System类提供的public static long currentTimeMillis()用来返回当前时
    间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
     */
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //称为时间戳
        System.out.println(time);
    }

}
