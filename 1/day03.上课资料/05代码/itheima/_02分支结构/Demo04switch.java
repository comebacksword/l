package com.itheima._02分支结构;

import java.util.Scanner;

/*
    switch语句
        格式:
            switch(值){
                case 值: 语句体1;break;
                case 值: 语句体2;break;
                case 值: 语句体3;break;
                case 值: 语句体4;break;
                ... ...
                default:语句体n+1;break;
            }
         执行流程：
            获取switch后面值和case语句后面的值进行匹配，匹配上就执行语句体，如果都不匹配执行default语句
 */
public class Demo04switch {
    public static void main(String[] args) {
        //减肥计划 键盘录入星期数，查看减肥计划 周一 跑步 周二 游泳 周三 动感单车 周四 爬山 周五 跳绳 周六 SPA 周日 吃顿好的
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查看的星期数：");
        int week = sc.nextInt();
        //使用switch语句查看减肥计划
        switch (week){
            case 1:System.out.println("周一 跑步");break;
            case 2:System.out.println("周二 游泳");break;
            case 3:System.out.println("周三 动感单车");break;
            case 4:System.out.println("周四 爬山");break;
            case 5:System.out.println("周五 跳绳");break;
            case 6:System.out.println("周六 SPA");break;
            case 7:System.out.println("周日 吃顿好的");break;
            default:
                System.out.println("您输入的星期数不存在！");
        }
    }
}