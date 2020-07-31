package com.shanchuan.java3;

import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * 一、|---Map:双类数据，存储key-value键值对的数据
 *          |---HashMap:主要实现类，线程不安全，存储null的key或value
 *              |---LinkedHashMap：维护链表，对于频繁的遍历操作，效率高于hashmap
 *          |---TreeMap：可以按照添加的key进行比较大小，实现排序
 *                       底层使用红黑树
 *          |---HashTable：古老实现类，线程安全,不能存储null的key或value
 *              |---properties：常用来处理配置文件。key-value都是string类型
 *
 * 二、Map结构的理解
 *   key：无序、不可重复，使用Set存储，所在类重写HashCode和equals()
 *   value：无序、可重复，使用Collection存储,所在类重写equals()
 *   key-value == entry
 *   entry：无序、不可重复，使用set存储
 *
 * 三、HashMap的底层实现原理？jdk1.7
 *      HahMap map = new HashMap();
 *      在实例化以后，底层创建了长度：16的数组Entry[] table
 *      ...多次put...
 *      map.put(key,value)
 *      首先，调用key所在类的hashcode计算key的哈希值，经过计算，得到在entry数组中的存放位置。
 *      若此位置上数据为空，key-value添加成功 --情况1
 *                 不为空，比较（key和已经一个或多个数据的key）的哈希值。
 *                      不相同，添加成功。--情况2
 *                      相同，调用equals方法
 *                          false：添加成功 --情况3
 *                          true：key-value替换已存在的数据
 *       补充：情况2和情况3与原来的数据以链表的方式存在
 *
 *
 *       扩容： 超出临界值&新要添加的位置!=null 扩容为原来容量的2倍，复制原有数据。
 *
 *       jdk8：
 *       1.new HashMap():一开始不创建数组
 *       2.底层数组为：Node[]
 *       3.首次调用put时，创建长度为16的数组
 *       4.底层结构：数组+链表+红黑表
 *       当数组的某一个索引位置上的元素以链表形式存在的数据个数>8 && 当前Node数组的长度 > 64
 *       则此索引位置上的数据使用红黑树存储。
 *
 *       DEFAULT_INITIAL_CAPACITY : HashMap的默认容量，16
 *       DEFAULT_LOAD_FACTOR：HashMap的默认加载因子 0.75f
 *       threshold：扩容的临界值，=容量*填充因子 16*0.75 = 12
 *       TREEIFY_THRESHOLD：Bucket中链表长度大于该默认值，转化为红黑树
 *       MIN_TREEIFY_CAPACITY：桶中的Node被树化时最小的hash表容量。64
 * 四、Map接口中常用方法
         添加、删除、修改操作：
             Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
             void putAll(Map m):将m中的所有key-value对存放到当前map中
             Object remove(Object key)：移除指定key的key-value对，并返回value
             void clear()：清空当前map中的所有数据
         元素查询的操作：
             Object get(Object key)：获取指定key对应的value
             boolean containsKey(Object key)：是否包含指定的key
             boolean containsValue(Object value)：是否包含指定的value
             int size()：返回map中key-value对的个数
             boolean isEmpty()：判断当前map是否为空
             boolean equals(Object obj)：判断当前map和参数对象obj是否相等
         元视图操作的方法：
             Set keySet()：返回所有key构成的Set集合
             Collection values()：返回所有value构成的Collection集合
             Set entrySet()：返回所有key-value对构成的Set集合
 *
 * @Author: ShanChuan
 * @Data: 11:562020/7/31
 */
public class MapTest {
    //存储null值
    @Test
    public void test1(){
        Map map = new HashMap();
//        map = new Hashtable();
        map.put(null,null);
    }

    //Map接口常用方法: 添加、删除、修改操作
    @Test
    public void test2() {
        HashMap map = new HashMap();
        System.out.println("***Object put(Object key,Object value)***");
        //put添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",1);
        //put修改
        map.put("AA",87);

        System.out.println(map);

        System.out.println("***void putAll(Map m)***");

        HashMap map1 = new HashMap();
        map1.put("CC","gsc");
        map1.put("DD",3);

        map.putAll(map1);
        System.out.println(map);

        System.out.println("***Object remove(Object key)***");
        map.remove("AA");
        System.out.println(map);

        System.out.println("***void clear()***");
        map.clear();
        System.out.println(map);
    }

    //Map接口常用方法: 元素查询的操作
//             Object get(Object key)：获取指定key对应的value
//             boolean containsKey(Object key)：是否包含指定的key
//             boolean containsValue(Object value)：是否包含指定的value
//             int size()：返回map中key-value对的个数
//             boolean isEmpty()：判断当前map是否为空
//             boolean equals(Object obj)：判断当前map和参数对象obj是否相等
    @Test
    public void test3() {
        HashMap map = new HashMap();
        System.out.println("***Object put(Object key,Object value)***");
        //put添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",1);

        System.out.println(map);

        System.out.println("***Object get(Object key)***");

        System.out.println("AA  " + map.get("AA") );
        System.out.println("cc  " + map.get("cc") );

        System.out.println("***boolean containsKey(Object key)***");

        System.out.println("AA  " + map.containsKey("AA") );
        System.out.println("cc  " + map.containsKey("cc") );

        System.out.println("***boolean containsValue(Object value)***");

        System.out.println("123  " + map.containsValue(123) );
        System.out.println("456  " + map.containsValue(456) );

        System.out.println("***int size()***");
        System.out.println(map.size());

        System.out.println("***boolean isEmpty()***");
        System.out.println(map.isEmpty());

        System.out.println("***boolean equals(Object obj)***");
        System.out.println(map.equals(map));

    }

    //Map接口常用方法: 元视图操作的方法：
    //             Set keySet()：返回所有key构成的Set集合
    //             Collection values()：返回所有value构成的Collection集合
    //             Set entrySet()：返回所有key-value对构成的Set集合
    @Test
    public void test4() {
        HashMap map = new HashMap();
        System.out.println("***Object put(Object key,Object value)***");
        //put添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 1);

        System.out.println(map);

        System.out.println("***Set keySet()***");
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("***Collection values()***");
        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("***Set entrySet()***");
        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}
