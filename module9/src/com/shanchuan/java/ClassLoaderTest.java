package com.shanchuan.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 22:182020/8/8
 */
public class ClassLoaderTest {

    @Test
    public void test1(){
        //自定义类，使用系统类加载器进行加载
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader);

        //系统类加载器getParent（）获取扩展类加载器
        ClassLoader loader1 = loader.getParent();
        System.out.println(loader1);

        //扩展类加载器getParent（）无法获取引导类加载器
        //引导类加载器加载核心类库
        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);

        ClassLoader loader3 = String.class.getClassLoader();
        System.out.println(loader3);
    }

    /*
        Properties:用来读取配置文件
     */
    @Test
    public void test2() throws IOException {

        //读取配置文件的方式1
        Properties properties = new Properties();
//        properties.load(new FileInputStream("test.properties"));

        //使用classloader 路径在当前module的src下
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        InputStream resourceAsStream = loader.getResourceAsStream("test.properties");
        properties.load(resourceAsStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        System.out.println(user);
        System.out.println(password);


    }
}
