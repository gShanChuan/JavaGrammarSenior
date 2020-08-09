package com.shanchuan.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 *
 * 客户端发送文件给服务端，服务端将文件保存在本地
 *
 * @Author: ShanChuan
 * @Data: 16:112020/8/6
 */
public class TcpTest2 {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getLocalHost();
            socket = new Socket(inet, 8899);
            //2.获取输出流
            os = socket.getOutputStream();

            fis = new FileInputStream("test.txt");

            //3.写出数据
            byte[] bBuf = new byte[1024];
            int len;
            while ((len = fis.read(bBuf)) != -1) {
                os.write(bBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        FileOutputStream fos = null;
        try {
            //1.创建ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2.调用acccept方法表示接受来自客户端的数据的socket
            socket = serverSocket.accept();
            //3.获取输入流
            is = socket.getInputStream();
            //获取输出流
            fos = new FileOutputStream("test1.txt");

            byte[] bBuf = new byte[2];
            int len;
            while ((len = is.read(bBuf)) != -1) {
                fos.write(bBuf,0,len);
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
                if (fos != null)
                    fos.close();
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
