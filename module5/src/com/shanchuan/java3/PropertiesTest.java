package com.shanchuan.java3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Description:
 * Properties 类是 Hashtable 的子类，该对象用于处理属性文件
 * @Author: ShanChuan
 * @Data: 20:522020/7/31
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("test.properties");
        properties.load(fileInputStream);

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name="+name);
        System.out.println("password="+password);
    }
}
