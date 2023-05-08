package com.itheima._03;
/*
    局部变量和成员变量区别：
        代码中的位置：
            成员变量：类中方法外
            局部变量：在方法的声明上 或者方法内部
        在内存中的位置：
            成员变量：在堆中
            局部变量：在栈中
        声明周期不一样：
            局部变量：随着方法的调用而存在，随着方法的弹栈而消失
            成员变量：随着对象的创建而存在，对象对象的消失而消失
        初始化值：
            局部变量没有默认，成员变量有默认值

 */
public class Phone {
    private String name;
    private double price;
    private String productAddress;

    //提供空参满参的构造方法

    public Phone() {
    }

    public Phone(String name, double price, String productAddress) {
        this.name = name;
        this.price = price;
        this.productAddress = productAddress;
    }
    //提供get和set方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }
}
