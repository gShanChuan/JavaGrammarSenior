package com.shanchuan.java;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 *
 * 其他流的使用：
 * 1.标准的输入、输出流
 * 2.打印流
 * 3，数据流
 *
 * @Author: ShanChuan
 * @Data: 12:592020/8/4
 */
public class OtherStreamTest {

    /*
     System.in和System.out分别代表了系统标准的输入和输出设备
     默认输入设备是：键盘，输出设备是：控制台
     System.in的类型是InputStream
     System.out的类型是PrintStream
     重定向：通过System类的setIn，setOut方法对默认设备进行改变。
         public static void setIn(InputStream in)
         public static void setOut(PrintStream out)
     */
    public static void main(String[] args) {
        /*
        从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
进行输入操作，直至当输入“e”或者“exit”时，退出程序。

        方法一：scanner
        方法二：system.in
         */

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            String date;

            while ((date = br.readLine()) != null) {
                System.out.println(date.getBytes().length);

                if (date.equalsIgnoreCase("e") || date.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println(date.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
    实现将基本数据类型的数据格式转化为字符串输出
    打印流：PrintStream和PrintWriter
         提供了一系列重载的print()和println()方法，用于多种数据类型的输出
         PrintStream和PrintWriter的输出不会抛出IOException异常
         PrintStream和PrintWriter有自动flush功能
         PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。
    在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。
         System.out返回的是PrintStream的实例

     */
    @Test
    public void test(){
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }
}


