package com.itheima._02面向对象;
/*
标准类的编写：
    1.成员变量私有化 提供getXxx和SetXxx方法
    2.提供空参满参的构造方法

 */
public class Phone {
   private String brand;
   private double price;
   private String productAddress;
   //无参构造方法
   public Phone(){
       System.out.println("无参构造方法被调用！");
   }
   /*public Phone(String productAddress){
       this.productAddress = productAddress;
   }*/
   //有参构造方法
    public Phone(String brand){
        System.out.println("有参构造方法被调用！ brand");
       this.brand = brand;
    }
    public Phone(double price){
        System.out.println("有参构造方法被调用！ price");
        this.price = price;
    }

    public Phone(String brand,double price){
        System.out.println("满参构造方法被调用！ price");
       this.brand = brand;
       this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void call(){
        System.out.println("打电话");
    }
    public void sendMessage(){
        System.out.println("发短信");
    }
}
