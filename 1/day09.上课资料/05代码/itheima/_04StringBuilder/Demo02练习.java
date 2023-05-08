package com.itheima._04StringBuilder;

import java.util.Scanner;

/*
    键盘录入一个字符串,实现字符串的逆序输出
    举栗子：
        键盘录入 abc
        输出 cba
 */
public class Demo02练习 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();
        //定义一个空的字符串
        String str = "";
        /*for (int i = line.length()-1; i >= 0; i--) {
            char c = line.charAt(i);
            str+=c;
        }
        System.out.println(str);*/
        /*char[] chars = line.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            str+=chars[i];
        }
        System.out.println(str);*/
        /*StringBuilder sb = new StringBuilder(line);
        //StringBuilder reverse() 导致该字符序列被序列的相反代替。
        StringBuilder reverse = sb.reverse();
        System.out.println(sb);
        System.out.println(sb == reverse);*/
        System.out.println(new StringBuilder(line).reverse().toString());
    }
}
