package com.itheima._03循环结构;
/*
    while循环
        格式：
            初始化语句
            while(条件判断语句){
                循环体语句;
                条件控制语句
            }
         执行流程：
            1.初始化语句
            2.条件判断语句 ==》true 循环体语句 ==》条件控制语句 ==》 2.条件判断语句
                        ==》false 结束循环
 */
public class Demo10while循环 {
    public static void main(String[] args) {
        //打印1--5
        for (int i=1;i<=5;i++){
            System.out.println(i);
        }
        System.out.println("---------------");
        int i= 1;
        while (i<=5){
            System.out.println(i);
            i++;
        }
        System.out.println("---------------");
        //打印5--1
        /*for (int i=5;i>=1;i--){
            System.out.println(i);
        }*/
        int j = 5;
        while (j>=1){
            System.out.println(j);
            j--;
        }

    }
}
