package com.ithiema._01练习;

import java.util.Scanner;

/*
    机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
按照如下规则计算机票价格：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。
分析：
    1.变量 淡季 旺季 头等舱和经济舱
    2.判断  淡季 旺季
    3.根据  淡季 旺季 和 头等舱和经济舱 进行打折
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = sc.nextInt();
        System.out.println("请输入你选择的舱位：");
        String cang = sc.next();
        //机票原价
        System.out.println("请输入机票原价：");
        double price = sc.nextDouble();
        //2.判断淡季或旺季
        //3.根据淡旺季，和 头等舱和经济舱 运算规则进行算出票价
        if (month >= 5 && month <= 10) {//旺季
            switch (cang) {
                case "头等舱":
                    price *= 0.9;
                    break;
                case "经济舱":
                    price *= 0.85;
                    break;
                default:
                    System.out.println("您输入的舱位类型有误！");
            }

        } else if (month >= 1 && month <= 4 || month == 11 || month == 12) {//淡季
            switch (cang) {
                case "头等舱":
                    price *= 0.7;
                    break;
                case "经济舱":
                    price *= 0.65;
                    break;
                default:
                    System.out.println("您输入的舱位类型有误！");
            }
        } else {
            System.out.println("您输入月份有误！");
        }

        System.out.println("您的机票价格是：" + price + "元");

    }
}
