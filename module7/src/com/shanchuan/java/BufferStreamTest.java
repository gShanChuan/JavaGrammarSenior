package com.shanchuan.java;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 * 处理流之一：缓冲流的使用
 *
 * 作用：提高流的读取、写入速度
 *
 * BufferedReader : readLine
 * BufferedWriter: write + newline
 *
 * @Author: ShanChuan
 * @Data: 10:282020/8/4
 */
public class BufferStreamTest {
    @Test
    public void BufferStreamTest(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("1.jpg");
            File destFile = new File("3.jpg");

            //2.造流
            //2.1 先造节点流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.1 再造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3.读取、写入
            byte[] bBuf = new byte[5];
            int len;
            while((len=bis.read(bBuf))!=-1){
                bos.write(bBuf,0,len);
//                bos.flush();刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭 先关外边
            try {
                if(bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bos!=null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //关闭外层流的同时，内层流也会关闭
//            try {
//                fis.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }


    }
}
