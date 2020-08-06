package com.shanchuan.java;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Description:
 *
 * 任意存储文件流RandomAccessFile
 * 1.继承Object类，实现了DataInput 和 DataOutput（即可以输出，也可以输入）
 * 2.说明
 * 构造器
 *      public RandomAccessFile(File file, String mode)
 *      public RandomAccessFile(String name, String mode)
 * 创建 RandomAccessFile 类实例需要指定一个 mode 参数，
 * 该参数指定 RandomAccessFile 的访问模式：
 *      r: 以只读方式打开
 *      rw：打开以便读取和写入
 *      rwd:打开以便读取和写入；同步文件内容的更新
 *      rws:打开以便读取和写入；同步文件内容和元数据的更新
 *  如果模式为只读r。则不会创建文件，而是会去读取一个已经存在的文件，
 * 如果读取的文件不存在则会出现异常。 如果模式为rw读写。如果文件不
 * 存在则会去创建文件，如果存在则不会创建。
 *
 * @Author: ShanChuan
 * @Data: 17:082020/8/5
 */
public class RandomAccessFileTest {

    @Test
    public void test1(){
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile("1.jpg","r");
            raf2 = new RandomAccessFile("4.jpg","rw");

            byte[] buf = new byte[1024];
            int len;
            while ((len=raf1.read(buf))!=-1){
                raf2.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf1!=null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2!=null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("hello.txt","rw");
            //指定开始覆盖的指针位置
            raf.seek(1);
            //若写出文件存在，对文件内容覆盖，默认从头
            raf.write("xyz".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf!=null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
