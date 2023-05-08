package com.itheima._04随机数;

import java.util.Random;

/*
    Random类 用来生成随机数的
    步骤：
        1.导包
        import java.util.Random
        2.创建对象
        Random r = new Random();
        3.生成随机数
        int num = r.nextInt(); //生成int取值范围内的随机数
        int num = r.nextInt(bound); //生成 0--bound之间随机数 包含0不包含bound  bound必须是int类型的正数
 */
public class Demo01随机数入门 {
    public static void main(String[] args) {
        Random random = new Random();

        /*for (int i=0;i<1000;i++) {
            ////生成int取值范围内的随机数
            int num = random.nextInt();
            System.out.println(num);
        }*/

        //生成 0--bound之间随机数 包含0不包含bound
        int i = random.nextInt(10);
        System.out.println(i);
        //bound必须是int类型的正数
//        int num = random.nextInt(-10); //IllegalArgumentException  bound must be positive
//        System.out.println(num);

        //生成 20 -- 90之间随机数
        int num  = random.nextInt(71)+20;//0--89
        //生成33 -- 99之间的随机数
        int num2 = random.nextInt(67)+33;

        /*
            生成区间内的随机数: [最小值 ，最大值]
                int num = random.nextInt(最大值-最小值+1)+最小值;
         */
        //生成 -10 -- 10之间的随机数
        int num3 = random.nextInt(21)-10;



    }
}
