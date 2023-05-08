package com.itheima._05作业;

import java.util.Scanner;

/*
    在测试类中，请查看键盘录入Scanner类的API，创建工人类对象，属性值由键盘录入，打印对象的属性值。输出效果如下：
	请录入工人姓名：
	张三
	请录入工人工龄：
	5

	该工人对象的属性信息如下：
	姓名：张三
	工龄：5

 */
public class Demo04Work {
    public static void main(String[] args) {
        //键盘录入Scanner
        Scanner scanner = new Scanner(System.in);
        //创建工人类对象
        Worker worker = new Worker();
        //属性值由键盘录入
        System.out.println("请输入工人姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入工人工龄：");
        int year = scanner.nextInt();

        worker.setName(name);
        worker.setYear(year);

        System.out.println("该工人对象的属性信息如下：");
        System.out.println("姓名："+worker.getName());
        System.out.println("工龄："+worker.getYear());


    }
}
