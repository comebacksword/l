package com.itheima._05作业;

import java.util.Scanner;

/*
    字符串反转

        举例：键盘录入”abc”

        输出结果：”cba”

 */
public class Demo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();
        //反转
        //方式一：
        //reverseString1(line);
        //方式二：
        //reverseString2(line);

        line = new StringBuilder(line).reverse().toString();
        System.out.println(line);


    }
    //方式二：
    private static void reverseString2(String line) {
        //1.定义空字符
        String s = "";
        //2.把字符串转成字符数组
        char[] chars = line.toCharArray();
        //3.倒叙遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            //4.拼接倒叙遍历的每一个元素
            s+=chars[i];
        }
        line = s;
        System.out.println(line);
    }

    //方式一：
    private static void reverseString1(String line) {

        //1.定义空字符
        String s = "";
        //2.倒叙遍历
        for (int i = line.length()-1; i >= 0; i--) {
            //3.拼接倒叙遍历的每一个元素
            s+= line.charAt(i);
        }
        //输出
        line =s;
        System.out.println(line);
    }

}
