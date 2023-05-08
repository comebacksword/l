package com.itheima._01方法概述;

import java.util.Arrays;

/*
    获取数组最大值和最小值

    需求：设计一个方法用于获取数组中元素的最大值，和最小值
    分析：
        1.参数：int [] arr
        2.返回值：int []

 */
public class Demo16 {
    public static void main(String[] args) {
        //定义一个数组，用静态初始化完成数组元素初始化
        int[] arr = {87, 10, 70, 74, 3, 18, 67, 63, 94, 37};
        int[] maxAndMin = getMaxAndMin(arr);
        System.out.println(maxAndMin[0]);
        System.out.println(maxAndMin[1]);

        System.out.println(Arrays.toString(maxAndMin));

    }

    public static int[] getMaxAndMin(int[] arr) {
        //1.定义最大值
        int max = arr[0];
        //2.循环遍历
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //2.定义最小值
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
//        int [] brr = {max,min};
        int[] brr = new int[2];
        brr[0] = max;
        brr[1] = min;

        return brr;
    }
}
