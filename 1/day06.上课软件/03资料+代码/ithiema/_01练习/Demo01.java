package com.ithiema._01练习;

import java.util.Arrays;
import java.util.Random;

/*
    利用随机数生成范围在2--10(包含2和10)之间的随机数存入到数组中(随机数可以重复)
    分别求出数组中的最大值，最小值和总和 打印到控制台
 */
public class Demo01 {
    public static void main(String[] args) {
        //定义数组
        int [] arr = new int[5];
        //创建随机数对象
        Random random = new Random();
        //生成随机数，存入到数组中
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(9)+2;
        }
        //打印数组
        System.out.println(Arrays.toString(arr));
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        //求最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max)
                max = arr[i];
        }
        //求最小值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                min = arr[i];
            }
        }
        //求和
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        System.out.println("max = "+max);
        System.out.println("min = "+min);
        System.out.println("sum = "+sum);

    }
}
