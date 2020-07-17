package com.shanchuan.java1;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description: JDK 8中的日期时间API
 * @Author: ShanChuan
 * @Data: 21:492020/7/17
 */
public class DataTimeTest2 {
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
