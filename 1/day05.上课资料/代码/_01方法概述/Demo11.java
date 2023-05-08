package com.itheima._01方法概述;

public class Demo11 {
    public static void main(String[] args) {
        eat();
    }

    public static void eat() {
        study();
        System.out.println("吃饭");
        sleep();
    }

    public static void sleep() {
        System.out.println("睡觉");
    }

    public static void study() {
        System.out.println("学习");
    }
}
