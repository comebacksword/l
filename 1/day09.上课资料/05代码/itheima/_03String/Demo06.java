package com.itheima._03String;

import java.util.Scanner;

/*
    模拟用户登录

 */
public class Demo06 {
    public static void main(String[] args) {
        String username = "admin";
        String password = "123456";
        //键盘录入
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            String userN = sc.nextLine();
            System.out.println("请输入密码：");
            String pwd = sc.nextLine();
            if (userN.trim().equals(username) && password.equals(pwd) ){
                System.out.println("登录成功，你可以上网看你想看的电影，玩你想玩的游戏！");
                break;
            }else {
                if (2-i==0){
                    System.out.println("您的账户被锁定，请联系管理员！");
                }else {
                    System.out.println("账户名或密码错误！您还有"+(2-i)+"次机会！");
                }
            }
        }
    }
}
