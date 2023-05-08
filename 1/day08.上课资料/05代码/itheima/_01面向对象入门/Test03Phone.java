package com.itheima._01面向对象入门;

public class Test03Phone {
    public static void main(String[] args) {
        //创建对象
        Phone phone = new Phone();
        //调用成员变量
        phone.brand = "XIAOMI";
        phone.price = 2999.0;

        String brand = phone.brand;
        double price = phone.price;
        System.out.println(brand);
        System.out.println(price);
        //调用成员方法
        phone.call();
        phone.sendMessage();
    }
}
