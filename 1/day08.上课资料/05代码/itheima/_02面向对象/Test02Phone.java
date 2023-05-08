package com.itheima._02面向对象;
/*
    构造方法：
        作用：构造作用用来创建对象和new关键字
        格式：
            格式1： public 类名(){}
            格式2： public 类名(参数列表){......}

    特点：
        1.如果本类中没有构造方法，JVM会默认提供一个无参的构造方法
        2.构造方法可以重载
        3.构造方法没有返回值，也不能使用 void
        4.构造方法中没有return关键字 ,可以写，但是没有必要，非要写return;
 */
public class Test02Phone {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone xiaomi = new Phone("XIAOMI");
        Phone phone1 = new Phone(2999.0);
        Phone huawei = new Phone("HUAWEI",17998.0);

    }
}
