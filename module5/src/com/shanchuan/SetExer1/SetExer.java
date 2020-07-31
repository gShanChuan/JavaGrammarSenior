package com.shanchuan.SetExer1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Description:
 * 练习：在List内去除重复数字值，要求尽量简单
 * @Author: ShanChuan
 * @Data: 11:022020/7/31
 */
public class SetExer {

    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }
}
