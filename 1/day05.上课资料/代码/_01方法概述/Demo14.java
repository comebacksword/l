package com.itheima._01方法概述;
/*
    基本数据类型在方法的调用过程中，形参的改变，不影响实参
 */
public class Demo14 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a); //10
        System.out.println(b); //20
        changeNum(a,b);
        System.out.println(a); //10
        System.out.println(b); //20
    }

    public static void changeNum(int a, int b) {
        System.out.println(a); //10
        System.out.println(b); //20
        a = a+b; // 30
        b = a+b; // 50
        System.out.println(a); //30
        System.out.println(b); //50
    }
}
