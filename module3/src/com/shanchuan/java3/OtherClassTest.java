package com.shanchuan.java3;

import org.junit.Test;

/**
 * @Description: 其他常用类的使用：1.system 2.math 3.bigInteger 和 bigDecimal
 * @Author: ShanChuan
 * @Data: 19:172020/7/18
 */
public class OtherClassTest {

    /*
    system类的使用
     */
    @Test
    public void test() {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);
        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);
        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);
        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);
        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);
        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }

    /*
    math类的使用
    java.lang.Math提供了一系列静态方法用于科学计算。其方法的参数和返回值类型一般为double型。
        abs 绝对值
        acos, asin, atan, cos, sin, tan 三角函数
        sqrt 平方根
        pow( double a, doble b)a的b次幂
        log 自然对数
        exp e为底指数
        max( double a, double b)
        min( double a, double b)
        random() 返回0 .0 到1 .0 的随机数
        long round ( double a)double型数据a转换为long型（四舍五入）
        toDegrees( double angrad)弧度—>角度
        toRadians( double angdeg)角度—>弧度
    }

    /*
    java.math包的BigInteger可以表示不可变的任意精度的整数。
    BigInteger 提供所有 Java 的基本整数操作符的对应物，并提供 java.lang.Math 的所有相关方法。
    另外，BigInteger 还提供以下运算：模算术、GCD 计算、质数测试、素数生成、
    位操作以及一些其他操作。
     常用方法
         public BigInteger abs()：返回此 BigInteger 的绝对值的 BigInteger。
         BigInteger add(BigInteger val) ：返回其值为 (this + val) 的 BigInteger
         BigInteger subtract(BigInteger val) ：返回其值为 (this - val) 的 BigInteger
         BigInteger multiply(BigInteger val) ：返回其值为 (this * val) 的 BigInteger
         BigInteger divide(BigInteger val) ：返回其值为 (this / val) 的 BigInteger。整数
        相除只保留整数部分。
         BigInteger remainder(BigInteger val) ：返回其值为 (this % val) 的 BigInteger。
         BigInteger[] divideAndRemainder(BigInteger val)：返回包含 (this / val) 后跟
        (this % val) 的两个 BigInteger 的数组。
         BigInteger pow(int exponent) ：返回其值为 (thisexponent) 的 BigInteger。
     */

    /*
    在商业计算中，要求数字精度比较高，故用到java.math.BigDecimal类。
         BigDecimal类支持不可变的、任意精度的有符号十进制定点数。
         构造器
         public BigDecimal(double val)
         public BigDecimal(String val)
         常用方法
         public BigDecimal add(BigDecimal augend)
         public BigDecimal subtract(BigDecimal subtrahend)
         public BigDecimal multiply(BigDecimal multiplicand)
         public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
     */
}
