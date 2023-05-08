package com.itheima._01面向对象入门;

public class TestTV {
    public static void main(String[] args) {
        //创建对象
        TV tv = new TV();
        //成员变量赋值
        tv.brand = "HUAWEI";
        tv.price = 188888.88;
        //成员变量取值
        String brand = tv.brand;
        double price = tv.price;
        System.out.println(brand);
        System.out.println(price);

        System.out.println(tv.brand);
        System.out.println(tv.price);

        //使用成员方法
        tv.watchTv();
    }
}
