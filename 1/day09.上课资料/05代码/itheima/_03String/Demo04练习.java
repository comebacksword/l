package com.itheima._03String;
/*
    切割学生信息字符串，封装成学生对象
 */
public class Demo04练习 {
    public static void main(String[] args) {
        String stuInfo = "张三,男,18";
        //使用split方法切割字符串
        String[] stu = stuInfo.split(",");
        String name = stu[0];
        String gender = stu[1];
        String age = stu[2];
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setAge(Integer.valueOf(age));//Integer.valueOf(age) 把字符串的数字，转成int类型的值


        System.out.println(student.getName());
        System.out.println(student.getGender());
        System.out.println(student.getAge());
    }
}
