package com.itheima._03ArrayList常用方法;

import java.util.ArrayList;
import java.util.Scanner;

/*
    使用ArrayList集合存储5学生对象【学号 姓名 性别 年龄 居住地址 考试成绩】
    筛选出成绩大于90学生，求男生成绩的平均值  || 筛选出成绩大于90学生，求女生成绩的平均值

    学生对象的创建需要键盘录入学生信息创建学生对象，提示：学号不能重复,可以定义方法判断学号不重复

    //1.创建学生类
    //2.测试类中
        创建集合对象，在添加学生对象到集合中之前，判断学号是否可用
        筛选 成绩大于90并且是男生 学生平均成绩
        筛选 成绩大于90并且是女生 学生平均成绩


 */
public class Demo03 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Student> list = new ArrayList<>();
        //添加学生对象到集合中
        for (int i = 0; i < 5; i++) {
            Student student = createStudentObject(list);
            list.add(student);
        }
        System.out.println(list);
        //筛选 成绩大于90并且是男生 学生平均成绩
        double sumBoy = 0.0;
        int countBoy = 0;
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getGender().equals("男")&&stu.getScore()>90){
                sumBoy+=stu.getScore();
                countBoy++;
            }
        }
        double avgBoy = sumBoy/countBoy;
        System.out.println("成绩大于90并且是男生 学生平均成绩:"+avgBoy+"分");

        //筛选 成绩大于90并且是女生 学生平均成绩
        double sumGirl = 0.0;
        int countGirl = 0;

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getGender().equals("女") && stu.getScore()>90){
                sumGirl+=stu.getScore();
                countGirl++;
            }
        }
        double avgGirl = sumGirl/countGirl;
        System.out.println("成绩大于90并且是女生 学生平均成绩:"+avgGirl+"分");




    }

    public static Student createStudentObject(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        String id = null;
        while (true) {
            System.out.println("请输入学号：");
            id = sc.next();
            boolean flag = isExistingStudentID(list,id);
            if (flag){
                break;
            }else {
                System.out.println("您录入的学号已存在，请重新输入！");
            }
        }


        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入性别：");
        String gender = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入地址：");
        String address = sc.next();
        System.out.println("请输入成绩：");
        double score = sc.nextDouble();
        Student student = new Student(id,name,gender,age,address,score);
        return student;
    }
    //判断学号是否在集合中存在，如果存在返回false 说明学号已存在不可以在使用 如果不存在返回true，说明学号可以使用
    private static boolean isExistingStudentID(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId().equals(id)){
                return false;
            }
        }
        return true;
    }
}
