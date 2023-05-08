package com.itheima._01Arraylist入门;

import java.util.ArrayList;

/*
    list集合存Student对象并遍历获取每一个学生的姓名和年龄
    步骤：
        1.创建集合对象
        2.创建学生对象
        3.把学生对象添加到集合中
        4.遍历集合获取学生对象，使用学生getXxx获取学的信息 输出到控制台
 */
public class Demo03 {
    public static void main(String[] args) {
        // 创建集合对象
        ArrayList<Student> students = new ArrayList<>();
        // 创建学生对象
        Student stu1 = new Student("张三", 18);
        Student stu2 = new Student("李四", 19);
        Student stu3 = new Student("王五", 20);
        Student stu4 = new Student("赵六", 21);
        Student stu5 = new Student("田七", 22);
        Student stu6 = new Student("老八", 23);
        // 把学生对象添加到集合中
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);
        students.add(stu6);
        //4.遍历集合获取学生对象，使用学生getXxx获取学的信息 输出到控制台
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            //使用学生getXxx获取学的信息 输出到控制台
            System.out.println(student.getName()+"..."+student.getAge());
        }
        //5.求集合中所有 人的年龄和
        int sum = 0;
        for (int i = 0; i < students.size(); i++) {
            /*Student student = students.get(i);
            int age = student.getAge();
            sum+=age;*/
            sum+=students.get(i).getAge();
        }
    }
}
