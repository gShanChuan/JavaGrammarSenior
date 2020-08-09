package com.shanchuan.java1;

import java.io.Serializable;

/**
 * @Description:
 * @Author: ShanChuan
 * @Data: 12:192020/8/9
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }
    private void eat(){
        System.out.println("生物吃东西");
    }
}
