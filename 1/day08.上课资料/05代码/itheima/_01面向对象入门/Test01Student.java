package com.itheima._01面向对象入门;
/*
    创建对象
        格式：类名 对象名 = new 类名();
        范例：Student s = new Student();
    使用对象
        1：使用成员变量
        格式：对象名.变量名
        范例：p.name
        2：使用成员方法
        格式：对象名.方法名()
        范例：p.study();
 */
public class Test01Student {
    public static void main(String[] args) {
        Student stu = new Student();
        System.out.println(stu); //com.itheima.Student@776ec8df
        /*
        com.itheima.Student@776ec8df
        com.itheima.Student :包名 + 类名 称为：全类名
        @ ：分割符
        776ec8df： 十六进制的内存地址
         */
        //对象的使用
        // 对象名.属性名
        stu.name = "张三";
        stu.age = 18;
        // 对象名.方法名();
        stu.study();

        //取值
        String x = stu.name;
        System.out.println("x = "+x);
        int y = stu.age;
        System.out.println("y = "+y);
    }
}
