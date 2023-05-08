package com.itheima._01方法概述;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
    获取数组最大值
    分析：
        1.数组自定义
        2.方法定义：
            返回值：有 int类型
            参数： 有 数组
 */
public class Demo09 {
    public static void main(String[] args) {
        //1.定义数组
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int length = scanner.nextInt();
        int [] brr = new int[length];
        //生成1--100之间的随机数 填充数组
        Random random = new Random();
        for (int i = 0; i < brr.length; i++) {
            brr[i] = random.nextInt(100)+1;
        }
        //打印数组
        System.out.println(Arrays.toString(brr));

        //调用方法
        int max = getMax(brr);
        System.out.println(max);

    }
    //求数组最大值
    public static int getMax(int [] arr){
        //1.定义最大值
        int max = arr[0];
        //2.使用循环遍历数组获取每一个元素
        for (int i = 0; i < arr.length; i++) {
            //3.和定义最大值比较，如果比最大值还要大，就跟新最大值
            if (arr[i]>max){
                max = arr[i];
            }
        }
        //4.返回最大值
        return max;
    }
}
