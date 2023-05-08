package com.itheima._02API;

import java.util.Scanner;

/*
    键盘录入姓名和年龄 性别，封装成学生对象，并输出值
    分析：
        1.键盘录入
        2.创建学生类
        3.使用构造方法创建对象 封装 输出值
 */
public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的姓名：");
        String name = sc.nextLine();
        System.out.println(name);
        System.out.println("请输入学生的年龄：");
        int age = sc.nextInt();
        System.out.println(age);
        System.out.println("请输入学生的性别：");
        String gender = sc.next();
        System.out.println(gender);
        // 3.使用构造方法创建对象
        Student student = new Student();
        //封装数据
        student.setName(name);
        student.setAge(age);
        student.setGender(gender);

        //输出值
        System.out.println(student.getName()+"..."+student.getAge()+"..."+ student.getGender());


    }
}
