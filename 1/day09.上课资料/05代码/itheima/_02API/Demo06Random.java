package com.itheima._02API;

import java.util.Random;

/*
    Random类：
        1.类结构
            java.util.Random
            public class Random extends Object implements Serializable
        2.学习类的描述
            该类的实例用于生成伪随机数的流
        3.构造方法
            Random() 创建一个新的随机数生成器。
            Random(long seed) 使用单个 long种子创建一个新的随机数生成器。
        4.成员方法中的常用方法
            //int nextInt(int bound)返回伪随机的，均匀分布 int值介于0（含）和指定值（不包括），从该随机数生成器的序列绘制。
            //int nextInt() 返回下一个伪随机数，从这个随机数发生器的序列中均匀分布 int值。
        5.nextInt方法中出现的异常
            IllegalArgumentException: bound must be positive

 */
public class Demo06Random {
    public static void main(String[] args) {
        //Random() 创建一个新的随机数生成器。
        Random random = new Random();
        System.out.println(random);
        //Random(long seed) 使用单个 long种子创建一个新的随机数生成器。
        Random random1 = new Random(100L);
        System.out.println(random1);

        //常用方法
        //int nextInt(int bound)返回伪随机的，均匀分布 int值介于0（含）和指定值（不包括），从该随机数生成器的序列绘制。
        int num = random.nextInt(10);
        System.out.println(num);

        //int nextInt() 返回下一个伪随机数，从这个随机数发生器的序列中均匀分布 int值。
        int num2 = random.nextInt();
        System.out.println(num2);

        /*
            java.lang.IllegalArgumentException: bound must be positive
         */
//        int num3 = random.nextInt(0);
//        System.out.println(num3);

    }
}
