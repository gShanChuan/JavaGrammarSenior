package com.shanchuan.java;

/**
 * @Description:
 * 1.枚举类的理解：
 *  类的对象只有有限个，确定的。
 * 2.当需要定义一组常量时，强烈建议使用枚举类
 * 3.枚举类的实现
 *      JDK1.5之前需要自定义枚举类
 *      JDK 1.5 新增的 enum 关键字用于定义枚举类
 * 4.若枚举只有一个对象, 则可以作为一种单例模式的实现方式。
 * 5.Enum类的主要方法：
 *       values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的
 *      枚举值。
 *       valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符
 *      串必须是枚举类对象的“名字”。如不是，会有运行时异常：
 *      IllegalArgumentException。
 *       toString()：返回当前枚举类对象常量的名称
 * 6.实现接口的枚举类
 *      若每个枚举值在调用实现的接口方法呈现相同的行为方式，则只
 *      要统一实现该方法即可。
 *      若需要每个枚举值在调用实现的接口方法呈现出不同的行为方式,
 *      则可以让每个枚举值分别来实现该方法
 * @Author: ShanChuan
 * @Data: 14:372020/7/21
 */
public class EnumTest {
    public static void main(String[] args) {
        //自定义枚举类
        System.out.println(Season.SPRING);
        //使用enum关键字定义枚举类
        System.out.println(season1.SPRING);
        //values()
        season1[] values = season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
        //valueOf():查找枚举对象
        season1 winter = season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();

    }
}

interface Info{
    void show();
}
//使用enum关键字定义枚举类
enum season1 implements Info{
    //提供当前枚举类的对象,多个对象用","隔开，末尾对象用";"
    SPRING("春天","春暖花开"){
        @Override
        public void show() {

        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {

        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {

        }
    },
    WINTER("冬天天","冰天雪地"){
        @Override
        public void show() {

        }
    };

    //声明属性：private final
    private final String seasonName;
    private final String seasonDec;
    //私有化构造器
    private season1(String seasonName,String seasonDec){
        this.seasonName=seasonName;
        this.seasonDec=seasonDec;
    }

    //提供其他功能

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDec() {
        return seasonDec;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }

    //无需提供toString
    //继承于java.lang,enum类

}
//自定义枚举类
class Season{
    //声明属性：private final
    private final String seasonName;
    private final String seasonDec;
    //私有化构造器
    private Season(String seasonName,String seasonDec){
        this.seasonName=seasonName;
        this.seasonDec=seasonDec;
    }
    //提供当前枚举类的对象:public static final
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天天","冰天雪地");

    //提供其他功能

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDec() {
        return seasonDec;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDec='" + seasonDec + '\'' +
                '}';
    }
}