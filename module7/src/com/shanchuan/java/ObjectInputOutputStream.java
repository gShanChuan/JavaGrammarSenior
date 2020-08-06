package com.shanchuan.java;

import org.junit.Test;

import java.io.*;

/**
 * @Description: 对象流 ObjectInputStream和OjbectOutputSteam
 *
 *  用于存储和读取基本数据类型数据或对象的处理流。
 * 它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *  序列化：用ObjectOutputStream类保存基本类型数据或对象的机制
 *  反序列化：用ObjectInputStream类读取基本类型数据或对象的机制
 *  ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 * @Author: ShanChuan
 * @Data: 16:022020/8/5
 */
public class ObjectInputOutputStream {

    /*
        序列化：将内存中的java对象保存到磁盘中、通过网络传输
     */
    @Test
    public void test() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("test.dat"));

            oos.writeObject(new String("天安门"));
            oos.writeObject(new person("高山川",22));


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
        反序列化
     */
    @Test
    public void test1() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("test.dat"));

            System.out.println(ois.readObject());
            System.out.println(ois.readObject());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}

//自定义类实现序列化和反序列化
//1.需要实现Serializable或者Externalizable接口
//2.定义全局常量，static final long serialVersionUID
//3.其内部属性均可序列化

class person implements Serializable{

    public static final long serialVersionUID = -4353675676242637842L;

    private String name;
    private int    age;

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}