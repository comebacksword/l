package com.itheima._05练习;
/*
    定义个学生类Student，包含空参构造、满参构造和以下成员变量：
    姓名name(String类型)  成绩 score(int 类型)
    生成以上成员变量的set、get方法
 */
public class Student {
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
