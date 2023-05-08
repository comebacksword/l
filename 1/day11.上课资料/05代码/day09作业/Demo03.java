package com.itheima._05作业;

import java.util.Scanner;

/*
    统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
 */
public class Demo03 {
    public static void main(String[] args) {
        //键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();
        //遍历字符串 统计个数
        //定义统计变量
        int bigCount = 0;
        int smallCount = 0;
        int numCount = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch>='A' && ch<='Z'){
                bigCount++;
            }
            if (ch>='a' && ch<='z'){
                smallCount++;
            }
            if (ch>='0' && ch<='9'){
                numCount++;
            }
        }
        System.out.println("大写字母有："+bigCount+"个");
        System.out.println("小写字母有："+smallCount+"个");
        System.out.println("数字字符有："+numCount+"个");

    }
}
