package com.itheima._04随机数;

import java.util.Random;
import java.util.Scanner;

/*
    需求：程序自动生成一个1-100之间的数字，使用程序实现猜出这个数字是多少？
    分析：
        1.随机数 Random
        2.猜数字 Scanner
        3.不知道猜多少次 死循环 while(true)
     步骤：
        1.生成随机数 1--100
        2.猜数字
            2.1 键盘录入数字
            2.2 判断如果大了 提示猜大了 如果小了 提示猜小了 如果相等 恭喜你猜对了
 */
public class Demo02猜数字 {
    public static void main(String[] args) {
        //1.生成随机数 1--100
        Random random = new Random();
        int guessNum = random.nextInt(100)+1;
        //System.out.println(guessNum);
        //2.猜数字
        //2.1 键盘录入数字
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个1--100之间的数字：");
            int num = sc.nextInt();
            if (num>guessNum){
                System.out.println("您猜大了！");
            }else if (num<guessNum){
                System.out.println("您猜小了！");
            }else if (num == guessNum){
                System.out.println("恭喜你，猜对了！晚上可以Happy了");break; //结束离break最近循环
            }
        }
    }
}
