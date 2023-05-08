package com.itheima._01方法概述;

import java.util.Scanner;

/*
    方法定义格式3：
        public static 返回值类型 方法名(参数列表){ //参数列表：参数可以有 一个，也可以有多个，也可以没有

            方法体

            return 值; //返回值的类型要和 方法的返回值类型相匹配
        }
        // 返回值类型根据需求 定义
     方法定义格式3调用：
        在main方法中调用：
            格式：

                方法名(参数......);直接调用，无意义 不推荐

                方法的返回值类型 变量名 = 方法名(参数......);//赋值调用

                System.out.println(方法名(参数......)); //输出调用



 */
public class Demo03 {
    public static void main(String[] args) {
        //键盘录入两个数字，定义方法接收两个数字，求他们最大值并返回
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int num2 = sc.nextInt();
        //直接调用，无意义 不推荐
//        getMax(num1,num2);
        //赋值调用
        int max = getMax(num1,num2);
        System.out.println(max);

        //输出调用
        System.out.println(getMax(num1,num2));
    }
    /*
        定义方法接收两个数字，求他们最大值并返回
        定义方法：
            参数：int a,int b
            功能：求最大值
            返回值：有 类型 int
     */
    public static int getMax(int a,int b){
        if (a>b){
            return a;
        }else {
            return b;
        }
    }
}
