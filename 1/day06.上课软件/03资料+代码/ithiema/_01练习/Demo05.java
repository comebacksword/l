package com.ithiema._01练习;

import java.util.Arrays;

/*
    把一个数组中的元素复制到另一个新数组中去
    分析：
        1.参数：int[]arr
        2.返回值：有，类型 数组
 */
public class Demo05 {
    public static void main(String[] args) {
        int [] arr = {21, 23, 47, 57, 41, 54, 23, 73, 76, 80};
        //调用 方法
        int[] array = copyArray(arr);
        System.out.println(Arrays.toString(array));
    }
    public static int[] copyArray(int[]arr){
        //1.定义新数组 长度和老的数组一样
        int [] newArr = new int[arr.length];
        //2.遍历老的数组，取出元素，存放到新数组中
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
