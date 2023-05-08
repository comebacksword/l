package com.itheima._01方法概述;

import java.util.Arrays;

/*
    定义方法打印数组中的元素
    输出格式:[1, 2, 3, 4, 5, 6, 7, 8, 9]
    分析：
        1.参数：int [] arr;
        2.返回值：没有返回值
 */
public class Demo06 {
    public static void main(String[] args) {
        int [] brr = {1,2,3,4,5,6,7,8,9};
        //调用方法
        printArray(brr);
    }
    public static void printArray(int [] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i== arr.length-1){ //判断是否是最后一个元素 ，如果是就直接打印元素
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+", ");//如果不是最后一个元素，就要打印元素拼接逗号和空格
            }
        }
        System.out.println("]");
        //System.out.println(Arrays.toString(arr));

    }

}
