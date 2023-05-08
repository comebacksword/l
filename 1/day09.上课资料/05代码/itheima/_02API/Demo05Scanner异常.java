package com.itheima._02API;

import java.util.Scanner;

/*
    Scanner异常:
         //不匹配或超出范围 InputMismatchException
         //如果此扫描仪已关闭 :IllegalStateException

 */
public class Demo05Scanner异常 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        sc.close(); java.lang.IllegalStateException
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        System.out.println(num);
        /*
            请输入一个整数：a
            //不匹配或超出范围
            报错：java.util.InputMismatchException

            如果此扫描仪已关闭 :
            java.lang.IllegalStateException
         */
    }
}
