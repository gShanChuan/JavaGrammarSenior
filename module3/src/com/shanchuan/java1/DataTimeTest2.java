package com.shanchuan.java1;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @Description: JDK 8中的日期时间API
 * @Author: ShanChuan
 * @Data: 21:492020/7/17
 */
public class DataTimeTest2 {
    /*
    java.time.format.DateTimeFormatter 类：该类提供了三种格式化方法：
         预定义的标准格式。如：
        ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
         本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
         自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
    ofPattern(String pattern) 静态方法,返回一个指定字符串格式的DateTimeFormatter
    format(TemporalAccessor t) 格式化一个日期、时间，返回字符串
    parse(CharSequence text) 将指定格式的字符序列解析为一个日期、时间
     */
    @Test
    public void test3(){
        //1.预定义的标准格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        String str1 = formatter1.format(LocalDateTime.now());
        System.out.println(str1);
        //解析
        TemporalAccessor parse = formatter1.parse("2020-07-18T13:47:46.349");
        System.out.println(parse);
        //2.本地化相关的格式
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //3.自定义
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatter2.format(LocalDateTime.now()));

    }
    /*
    Instant：时间线上的一个瞬时点。 这可能被用来记录应用程序中的事件时间戳。
    在UNIX中，这个数从1970年开始，以秒为的单位；同样的，在Java中，也是从1970年开始，但以毫秒为单位。
        now() 静态方法，返回默认UTC时区的Instant类的对象
        ofEpochMilli(long epochMilli) 静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒
        数之后的Instant类的对象
        atOffset(ZoneOffset offset) 结合即时的偏移来创建一个 OffsetDateTime
        toEpochMilli() 返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
     */
    @Test
    public void test2(){
        //获取本初子午线的当前时间
        Instant instant = Instant.now();
        System.out.println(instant);
        //设置时区偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //返回1970-01-01 00:00:00到当前时间的毫秒数，即为时间戳
        System.out.println(instant.toEpochMilli());
        //
        System.out.println(Instant.ofEpochMilli(1595050613795l));
    }
    /*
    LocalDate、LocalTime、LocalDateTime类的使用：
    实例化：
        now() / * now(ZoneId zone) 静态方法，根据当前时间创建对象/指定时区的对象
        of() 静态方法，根据指定日期/时间创建对象
    get：
        getDayOfMonth()/getDayOfYear() 获得月份天数(1-31) /获得年份天数(1-366)
        getDayOfWeek() 获得星期几(返回一个 DayOfWeek 枚举值)
        getMonth() 获得月份, 返回一个 Month 枚举值
        getMonthValue() / getYear() 获得月份(1-12) /获得年份
        getHour()/getMinute()/getSecond() 获得当前对象对应的小时、分钟、秒
    set：
        withDayOfMonth()/withDayOfYear()/
        withMonth()/withYear() 将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象
    add/sub:
        plusDays(), plusWeeks(),
        plusMonths(), plusYears(),plusHours() 向当前对象添加几天、几周、几个月、几年、几小时
        minusMonths() / minusWeeks()/
        minusDays()/minusYears()/minusHours() 从当前对象减去几月、几周、几天、几年、几小时
     */
    @Test
    public void test1(){
        //now():当前时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of:指定时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 23, 43, 22);
        System.out.println(localDateTime1);
        //getXxx
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());
        //withXxx(set) 不可变性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        //plusXxx(add) 不可变性
        LocalDateTime localDateTime3 = localDateTime.plusDays(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);

        //minusXxx(sub)
        LocalDateTime localDateTime4 = localDateTime.minusDays(2);
        System.out.println(localDateTime);
        System.out.println(localDateTime4);

    }
}
