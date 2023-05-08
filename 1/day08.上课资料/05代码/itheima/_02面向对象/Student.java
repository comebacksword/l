package com.itheima._02面向对象;

public class Student {
    private String name;
    private int age;

    public void setAge(int age){
        if (age>0&&age<=120){
            this.age = age;
        }else {
            System.out.println("您给的年龄不合理！");
        }
    }
    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void study(){
        System.out.println("好好学习，天天向上！");
    }
    public void eat(){
        System.out.println("吃饭饭！");
    }
    public void sleep(){
        System.out.println("单身狗，抱着自己，睡觉觉！");
    }
}
