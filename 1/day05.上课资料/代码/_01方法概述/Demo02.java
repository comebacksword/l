package com.itheima._01方法概述;

import java.util.Scanner;

/*
    方法定义的格式2：
         public static void 方法名(数据类型 变量名) {
         }
         调用：
            在main方法中 ： 方法名(值) ：值要和方法中参数数据类型一致

            传递参数过程，和变量没有关系 和数据类型有关系，要求数据类型要一致

            需要几个参数，传递几个参数，需要什么数据类型的参数，就传递相匹配数据类型
 */
public class Demo02 {
    public static void main(String[] args) {
        //定义方法，求1 - n之间数据和
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num = scanner.nextInt();
//        sum(num);
        System.out.println("请输入第二个数字：");
        int num2 = scanner.nextInt();
        sum2(num2,num);
    }

    public static void sum(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        System.out.println(s);
    }
    //定义方法求两个数的和
    public static void sum2(int a,int b){
        System.out.println(a+b);
    }
}
