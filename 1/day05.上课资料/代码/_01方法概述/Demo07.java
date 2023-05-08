package com.itheima._01方法概述;

import java.util.Scanner;


/*
    键盘录入两个数字，求最大值并返回给调用者

    分析：
        1.键盘录入
        2.定义方法：
            2.1 参数：int a,int b
            2.2 返回值 ：有 ，返回值类型：int
 */
public class Demo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int num2 = sc.nextInt();
        //调用方法
        int max = getMaxs(num1, num2);
        System.out.println(max);


    }
    public static int getMaxs(int a, int b) {
        return a > b ? a : b;
    }

}
