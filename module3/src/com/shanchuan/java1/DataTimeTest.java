package com.shanchuan.java1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Description: JDK 8之前的日期时间API
 * @Author: ShanChuan
 * @Data: 22:122020/7/16
 */
public class DataTimeTest {
    /*java.text.SimpleDateFormat类是一个不与语言环境有关的方式来格式化和解析日期的具体类。
     它允许进行格式化：日期文本、解析：文本日期
     实例化：
         SimpleDateFormat() ：默认的模式和语言环境创建对象
         public SimpleDateFormat(String pattern)：该构造方法可以用参数pattern
        指定的格式创建一个对象。
     格式化：
         public String format(Date date)：方法格式化时间对象date
     解析：
         public Date parse(String source)：从给定字符串的开始解析文本，以生成
    一个日期。
    */
    @Test
    public void test3() throws ParseException {
        //实例化 默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date date = new Date();
        //格式化
        String format = sdf.format(date);//20-7-17 下午8:41
        System.out.println(format);
        //解析 按格式书写
        String str = "20-7-17 下午8:23";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //实例化 指定格式 构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);//2020-07-17 08:41:00
        System.out.println(format1);
        //解析 按格式书写
        System.out.println(sdf1.parse("2020-07-17 08:41:00"));


    }
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
