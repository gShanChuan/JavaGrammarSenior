package com.shanchuan.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:
 *
 * 测试FileInputStream和测试FileOutputStream
 *
 * @Author: ShanChuan
 * @Data: 21:422020/8/3
 */
public class FileInputOutputStreamTest {

    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //实例化file类对象
            File file = new File("hello.txt");

            //2.流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] bBuf = new byte[5];
            int len;
            while ((len=fis.read(bBuf))!=-1){
                System.out.print(new String(bBuf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.close
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileInputOutStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //实例化file类对象
            File srcfile = new File("1.jpg");
            File destfile = new File("2.jpg");

            //2.流
            fis = new FileInputStream(srcfile);
            fos = new FileOutputStream(destfile);

            //3.读数据
            byte[] bBuf = new byte[5];
            int len;
            while ((len=fis.read(bBuf))!=-1){
                fos.write(bBuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.close
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
