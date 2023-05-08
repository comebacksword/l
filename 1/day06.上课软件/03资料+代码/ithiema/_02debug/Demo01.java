package com.ithiema._02debug;
/*
    debug:就是代码的调试工具，用来查看代码在运行过程数据的变化

    debug：
        断点 : 在你查看代码块的行数旁边打
        如何运行 : run debug
        消除断点 : 在断点处在 点击一下
 */
public class Demo01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        sum(a,b);


    }

    public static void sum(int a, int b) {
        int c = a+b;
        System.out.println(c);
    }
}
