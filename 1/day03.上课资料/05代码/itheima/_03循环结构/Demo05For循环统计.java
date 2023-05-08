package com.itheima._03循环结构;

import java.util.Arrays;

/*
    统计1--100之间能被2整数的数字的个数，能被3整除的数字的个数
 */
public class Demo05For循环统计 {
    public static void main(String[] args) {
        //定义两个统计变量
        int count1 = 0; //统计能被3整除个数
        int count2 = 0; //统计能被2整除个数
        //使用for循环遍历1--100之间数字
        for (int i = 1; i <= 100; i++) {
            //筛选数字
            if (i % 3 == 0)
                count1++;

            if (i % 2 == 0)
                count2++;

        }
        System.out.println("count1 = " + count1);
        System.out.println("count2 = " + count2);

    }
}
