package com.shanchuan.java;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 17:352020/8/6
 */
public class UDPTest {

    //发送端
    @Test
    public void sender(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getLocalHost();
            byte[] bytes = "udp方式发送的数据".getBytes();

            DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,inetAddress,8899);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }

    }

    @Test
    public void receiver(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8899);

            byte[] bBuf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bBuf,0,bBuf.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData()));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }

    }
}
