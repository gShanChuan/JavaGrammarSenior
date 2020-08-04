package com.shanchuan.java;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 *
 * 处理流之二：转换流的使用
 * InputStreamReader: 一个字节的输入流转换为字符的输入流
 * OutputStreamWriter: 一个字符的输出流转换为字节的输出流
 *
 * @Author: ShanChuan
 * @Data: 11:542020/8/4
 */
public class InputStreamReaderTest {

    @Test
    public void test() {
        InputStreamReader isr = null;//使用默认的字符集
        try {
            FileInputStream fis = new FileInputStream("hello.txt");
//    InputStreamReader isr = new InputStreamReader(fis);//使用默认的字符集
            isr = new InputStreamReader(fis, "utf-8");

            char[] cbuf = new char[3];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
