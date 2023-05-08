package com.itheima._02API;

import java.util.Scanner;

/*
    Scanner类中next()和nextLine方法的区别
 */
public class Demo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s1 = sc.next();
        System.out.println(s1);

        System.out.println("请输入一个字符串：");
        String s2 = sc.nextLine();
        System.out.println(s2);

        System.out.println("请输入一个字符串：");
        String s3 = sc.nextLine();
        System.out.println(s3);
    }
}
