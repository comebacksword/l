package com.itheima._01面向对象入门;

import com.itheima._02面向对象.Test03;

import java.util.Arrays;

public class _01面向对象入门 {
    public static void main(String[] args) {
        int [] arr = {1,2,3};
        //面向过程
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
        //面向对象
        System.out.println(Arrays.toString(arr));

    }
}
