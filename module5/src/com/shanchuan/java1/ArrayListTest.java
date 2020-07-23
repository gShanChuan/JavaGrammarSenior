package com.shanchuan.java1;

/**
 * @Description: ArrayList的源码分析
 * @Author: ShanChuan
 * @Data: 16:042020/7/23
 */
public class ArrayListTest {
    //jdk7
/*    底层创建了长度为10的object[] elementDate
    ArrayList list = new ArrayList();
    list.add(1);
    ...
    list.add(123);
    若此次添加导致elementDate容量不够，则扩容，
    默认情况下，扩容为原来容量的1.5倍，再copy数据。*/

    //jdk8
/*    底层创建了object[] elementDate = {}
    ArrayList list = new ArrayList();
    //第一次调用add时，才创建了长度为10的数组
    list.add(1);
    ...
    list.add(123);
    若此次添加导致elementDate容量不够，则扩容，
    默认情况下，扩容为原来容量的1.5倍，再copy数据。*/

}
