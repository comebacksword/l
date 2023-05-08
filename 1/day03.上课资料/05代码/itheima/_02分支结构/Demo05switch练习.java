package com.itheima._02分支结构;

import java.util.Scanner;

/*
    键盘录入一个是月份，输出对应的季节

    分析：
        1.键盘录入
            导包
            创建对象
            接收数据
        2.获取接收的数据
            使用switch语句匹配，输出对应季节
        3.case语句具有穿透性，遇到break才停止
 */
public class Demo05switch练习 {
    public static void main(String[] args) {
        //创建对象
        Scanner scanner = new Scanner(System.in);
        //接收数据
        System.out.println("请输入一个月份：");
        int month = scanner.nextInt();
        //使用switch语句匹配，输出对应季节
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("您给的月份有误！");
                break;

        }

    }
}
