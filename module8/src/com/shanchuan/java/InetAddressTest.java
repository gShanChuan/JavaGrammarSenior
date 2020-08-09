package com.shanchuan.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description:
 *
 * InetAddress类
 *
 * @Author: ShanChuan
 * @Data: 11:452020/8/6
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {

            //InetAddress类实例化
            System.out.println("*****InetAddress类实例化*****");
            InetAddress address1 = InetAddress.getByName("192.168.10.14");
            System.out.println(address1);
            InetAddress address2 = InetAddress.getByName("www.baidu.com");
            System.out.println(address2);
            //获取本机ip
            InetAddress address3 = InetAddress.getLocalHost();
            System.out.println(address3);

            //getHostName、getHostAddress两个常用方法
            System.out.println(address2.getHostName());
            System.out.println(address2.getHostAddress());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
