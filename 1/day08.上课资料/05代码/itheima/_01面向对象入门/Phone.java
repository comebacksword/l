package com.itheima._01面向对象入门;

public class Phone {
    String brand;
    double price;

    //成员方法：打电话，发短信
    public void call(){
        System.out.println("打电话，说情话");
    }
    public void sendMessage(){
        System.out.println("发短信，他走了，你可以来了！");
    }
}
