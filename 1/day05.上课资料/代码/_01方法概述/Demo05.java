package com.itheima._01方法概述;
/*
    定义方法在控制台打印九九乘法表
    分析：
        1.不要返回值  返回值类型 void
        2.参数：没有参数
 */
public class Demo05 {
    public static void main(String[] args) {
        //调用方法
        print();

    }
    //定义方法
    public static void print(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }

    }
}
