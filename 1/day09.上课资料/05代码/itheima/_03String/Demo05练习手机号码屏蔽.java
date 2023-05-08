package com.itheima._03String;

import java.util.Scanner;

/*
    键盘录入一个手机号码,屏蔽中间四位
    13917295832 ==> 139****5832
 */
public class Demo05练习手机号码屏蔽 {
    public static void main(String[] args) {
        //1.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个手机号：");
        String phoneNum = sc.nextLine();
        //2.使用字符串截取的方法
        String s1 = phoneNum.substring(0, 3);
        System.out.println(s1);
        String s2 = phoneNum.substring(7);
        System.out.println(s2);

        String newPhoneNum = s1+"****"+s2;
        System.out.println(newPhoneNum);
    }
}
