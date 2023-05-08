package com.itheima._02分支结构;

import java.util.Scanner;

/*
    if语句：
        格式2：
            if(关系表达式){
                语句体1;
            }else{
                语句体2;
            }
        执行流程：
            判断关系表达式的值是否为true，如果为true执行语句体1，否则执行语句体2

 */
public class Demo02格式2 {
    public static void main(String[] args) {
        //键盘录入一个数字判断是奇数还是偶数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入一个数字：");
        int num = scanner.nextInt();
        //判断奇偶数
        if (num%2==0){
            System.out.println(num+"是偶数");
        }else {
            System.out.println(num+"是奇数");
        }
    }
}
