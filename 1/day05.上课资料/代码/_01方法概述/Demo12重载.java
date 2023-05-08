package com.itheima._01方法概述;

import java.util.Arrays;
/*
    方法重载：
        1.在同一个类中，方法名相同
        2.参数不同：
            参数类型不同
            参数个数不同
            参数类型顺序不同
         3.和返回值无关
 */
public class Demo12重载 {
    public static void main(String[] args) {
        int [] brr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(brr));
        double [] crr = {1.0,2.0,3.0,4,5,6,7,8,9};
        System.out.println(Arrays.toString(crr));
    }
    public static void sum(){

    }
    public static void sum(int a,int b){

    }
    public static void sum(double a,double b){

    }
    public static void sum(long a,int b){

    }
    public static int sum(int  a,long b){
        return 0;
    }
}
