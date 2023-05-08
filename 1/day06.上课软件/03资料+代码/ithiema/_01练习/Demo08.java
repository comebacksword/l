package com.ithiema._01练习;

import java.util.Arrays;

/*
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 复制一部分到新的数组中

    分析：
        1.参数
            原数组
            开始索引
            结束索引
            注意：结束的索引要大于开始索引，结束的索引要小于数组长度
        2.返回值：
            int [] brr
 */
public class Demo08 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //调用方法
        int[] arrayRange = copyArrayRange(arr, 3, 5);
        //打印新的数组
        System.out.println(Arrays.toString(arrayRange));

    }

    public static int[] copyArrayRange(int[] arr, int startIndex, int endIndex) {
//        结束的索引要大于开始索引
        if (endIndex < startIndex) {
            System.out.println("您给的参数错误，开始索引要小于结束索引");
            return null;
        }
        if (endIndex > arr.length - 1) {
            System.out.println("结束的索引要小于数组长度");
            return null;
        }
        //定义新的数组的长度
        //{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length = endIndex - startIndex + 1;
        //创建新的数组
        int [] newArr = new int[length];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[startIndex];
            startIndex++;
        }
     return newArr;
    }
}
