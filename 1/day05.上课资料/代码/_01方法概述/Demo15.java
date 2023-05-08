package com.itheima._01方法概述;
/*
    引用数据类型在方法的调用过程中，形参的改变，影响实参
 */
public class Demo15 {
    public static void main(String[] args) {
        int [] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        System.out.println(arr);
        System.out.println(arr[0]); //10
        System.out.println(arr[1]); //20
        System.out.println(arr[2]); //30
        changeNum(arr);
        System.out.println(arr);
        System.out.println(arr[0]); //10 11
        System.out.println(arr[1]); //20 22
        System.out.println(arr[2]); //30 33
    }

    public static void changeNum(int[] arr) {
        System.out.println(arr);
        System.out.println(arr[0]);//10
        System.out.println(arr[1]);//20
        System.out.println(arr[2]);//30
        arr[0] = 11;
        arr[1] = 22;
        arr[2] = 33;
        System.out.println(arr);
        System.out.println(arr[0]);//11
        System.out.println(arr[1]);//22
        System.out.println(arr[2]);//33
    }
}
