package com.itheima._01方法概述;

import java.util.Scanner;

/*
    形参：形式参数
        方法定义时的参数
    实参：实际参数
        方法调用时传递的参数，有实际的值

 */
//键盘录入一个数字，定义方法求奇偶数
public class Demo13形参和实参 {
    public static void main(String[] args) {
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数：");
        int num = sc.nextInt();
        isEvenNum(num);
    }
    /*
        定义方法：
            返回值：void
            参数：int a;
     */
    public static void isEvenNum(int a){
        //判断奇偶数
        if (a%2==0){
            System.out.println(a+"是偶数！");
        }else {
            System.out.println(a+"是奇数！");
        }
    }

}
