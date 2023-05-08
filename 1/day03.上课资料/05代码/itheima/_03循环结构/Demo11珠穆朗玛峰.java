package com.itheima._03循环结构;
/*
    需求：世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米)，假如我有一张足够大的纸，它的厚度是0.1毫米。
请问，我折叠多少次，可以折成珠穆朗玛峰的高度?

步骤：
    1.先定义纸张厚度
    2.定义珠峰高度
    3.运算：
        只要纸张的厚度小于珠峰高度，就继续折叠
        纸张每次折叠都要是上一次2倍
        每折叠一次，就要记录一次
 */
public class Demo11珠穆朗玛峰 {
    public static void main(String[] args) {
        //1.先定义纸张厚度
        double paper = 0.1;
        //2.定义珠峰高度
        double zf = 8844430;
        //3.定义计数器
        int count = 0;
        //4.统计折叠次数
        while (paper<zf){
            paper *= 2;
            count++;
        }
        System.out.println("折叠："+count+"次");
    }
}
