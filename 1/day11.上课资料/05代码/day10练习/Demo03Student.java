package com.itheima._05练习;

import java.util.ArrayList;
import java.util.Scanner;

/*
    定义个学生类Student，包含空参构造、满参构造和以下成员变量：
        姓名name(String类型)  成绩 score(int 类型)
        生成以上成员变量的set、get方法
        定义测试类，创建三个对象，存入集合中，之后遍历集合list，求出三个学生的平均成绩

 */
public class Demo03Student {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        //键盘录入学生信息封装学生对象
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入学生的姓名:");
            String name = sc.next();
            System.out.println("请输入学生的成绩");
            int score = sc.nextInt();
            Student student = new Student();
            student.setName(name);
            student.setScore(score);
            //添加到集合中
            list.add(student);
        }
        //遍历集合list
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getName()+"..."+stu.getScore());
        }
        //求出三个学生的平均成绩
        double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
           sum+= list.get(i).getScore();
        }
        double avg = sum/list.size();
        System.out.println("三个学生的平均成绩："+avg+"分");


    }
}
