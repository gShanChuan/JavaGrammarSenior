package com.shanchuan.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 * 客户端。并关闭相应的连接
 * @Author: ShanChuan
 * @Data: 16:222020/8/6
 */
public class TcpTest3 {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;

        InputStream is = null;
        InputStreamReader isr = null;

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

            socket.shutdownOutput();;

            is = socket.getInputStream();
            isr = new InputStreamReader(is);

            char[] cbuf = new char[10];
            while ((len = isr.read(cbuf)) != -1) {
                System.out.print(new String(cbuf, 0, len));
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

        OutputStream os = null;
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
                fos.write(bBuf, 0, len);
            }

            os = socket.getOutputStream();
            os.write("已收到".getBytes());

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
