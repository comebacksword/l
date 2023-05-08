package com.itheima._02分支结构;

import java.util.Scanner;

/*
    if语句
        格式1:
            if(关系表达式){
                语句体;
            }
        执行流程：
            1.判断关系表达式的值
            2.如果为true执行语句体，否则执行其他代码
 */
public class Demo01格式1 {
    public static void main(String[] args) {
        //键盘录入一个数字判断是否是偶数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = scanner.nextInt();
        System.out.println("开始");
        //判断是否是偶数
        if (num%2==0){
            System.out.println(num+"是偶数");
        }
        System.out.println("结束");
    }
}
