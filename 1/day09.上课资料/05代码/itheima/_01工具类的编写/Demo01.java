package com.itheima._01工具类的编写;

import java.util.Arrays;
/*
    工具类的编写:
        1.构造方法私有化
        2.成员方法静态化
 */
public class Demo01 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        SumUtil.sum();

    }
}

class SumUtil{
    private SumUtil(){}

    public static int sum(){
       return 1+1;
    }
}
