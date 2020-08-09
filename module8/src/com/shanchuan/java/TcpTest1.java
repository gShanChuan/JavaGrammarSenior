package com.shanchuan.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 实现TCP协议的网络编程
 * @Author: ShanChuan
 * @Data: 14:332020/8/6
 */
public class TcpTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getLocalHost();
            socket = new Socket(inet, 8899);
            //2.获取输出流
            os = socket.getOutputStream();
            //3.写出数据
            os.write("高山川asdcada".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    //服务端
    @Test
    public void server() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        InputStreamReader isr = null;
        try {
            //1.创建ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2.调用acccept方法表示接受来自客户端的数据的socket
            socket = serverSocket.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //3.读取数据
            isr = new InputStreamReader(is);

            char[] cBuf = new char[2];
            int len;
            while ((len = isr.read(cBuf)) != -1) {
                System.out.print(new String(cBuf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
