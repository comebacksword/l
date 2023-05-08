package com.itheima._05作业;

import java.util.Scanner;

/*
5、编写一个Java程序，提示用户输入一串字符串，要求字符串中必须存在字母（需要代码判断）

	1.若不符合要求，则提示用户重新输入直至符合要求为止

	2.若符合要求，则判断字符串中大写字母出现次数并打印。

	分析：
	    1.键盘录入一个字符串：
	    2.判断字符串中是否存在字母字符，
	        如果存在，停止循环，同时统计大写字母字符出现的次数
	        如果不存在继续输入  用到死循环


 */
public class Demo05 {
    public static void main(String[] args) {
        // 1.键盘录入一个字符串：
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个包含字母的字符串：");
            String line = sc.nextLine();
            //2.判断字符串中是否存在字母字符，
            //定义统计字母字符的变量
            int charCount = 0;
            int bigCount = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                //统计所有字母字符的个数
                if (c>='A'&&c<='Z' || c>='a'&&c<='z'){
                    charCount++;
                    //统计大写字母字符的个数
                    if (c>='A'&&c<='Z'){
                        bigCount++;
                    }
                }
            }
            if (charCount>0){
                System.out.println("字符串中大写字母个数："+bigCount+"个");
                break;
            }else {
                System.out.println("您输入的字符串中不包含字母，请重新输入！");
            }
        }
    }
}














