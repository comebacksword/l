package com.itheima._03;

public class Test01Phone {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setName("HUAWEI");
        phone.setPrice(17988.0);
        phone.setProductAddress("Made in China");
        System.out.println(phone.getName());
        System.out.println(phone.getPrice());
        System.out.println(phone.getProductAddress());
    }
}
