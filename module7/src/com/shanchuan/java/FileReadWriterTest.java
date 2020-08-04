package com.shanchuan.java;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description:
 *
 * 1.流的分类
    按操作数据单位不同分为：字节流(8 bit)，字符流(16 bit)
    按数据流的流向不同分为：输入流，输出流
    按流的角色的不同分为：节点流，处理流

    抽象基类        节点流（文件流）        缓冲流（处理流的一种）
    InputStream     FileInputStream       BufferInputStream
    OutputStream    FileOutputStream      BufferOutputStream
    Reader          FileReader            BufferReader
    Writer          FileWriter            BufferWriter

    2.FileReader

 * @Author: ShanChuan
 * @Data: 17:572020/8/3
 */
public class FileReadWriterTest {
    /*
        FileReader
     */
    @Test
    public void test() {
        //1.实例化file类对象
        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            //2.提供流
            fr = new FileReader(file);
            //3.数据读入
            int date;
            while ((date=fr.read()) != -1){
                System.out.println((char)date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        FileReader的升级：使用重载的方法
        read(char[])
    */
    @Test
    public void test1() {
        //1.实例化file类对象
        File file = new File("hello.txt");
        FileReader fr = null;
        try {
            //2.提供流
            fr = new FileReader(file);
            //3.数据读入
            char[] cbuf = new char[5];
            int len;
            while ((len=fr.read(cbuf))!=-1){
//                for (int i = 0; i < len; i++) {
//                    //方式一：
//                    System.out.print(cbuf[i]);
//                }
                //方式二：
                System.out.print(new String(cbuf, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        FileWrite

        文件不存在，自动创建文件
             存在, 构造器选择是否追加
                        追加，在末尾添加数据
                        不追加，覆盖
     */
    @Test
    public void test2() throws IOException {
        //1.实例化file类对象
        File file = new File("hello1.txt");
        //2.提供流
        FileWriter fw = new FileWriter(file);
        //3.写出
        fw.write("i have a dream");

        //4.关闭流
        fw.close();

    }
}
