package com.itheima._01面向对象入门;
/*
    类：  类是对同一类事物的描述，具有相同属性和行为为的一类事物统称
    对象： 对象是具体存在事物，就是类的实体，是类的具体体现；
    创建类：
        public class 类名{
            属性： 成员变量
            行为： 成员方法
        }
        public class Student{
            //属性： 成员变量
            String name;
            int age;
            //行为： 成员方法
            public void study(){
                sout("好好学习");
            }
        }
    创建对象：
        格式：
            类名 对象名/变量名 = new 类名();
        步骤：
            1.创建测试类
            2.书写main方法
            3.在main方法中创建对象
                Student stu = new Student();
    使用对象:
        步骤：
            1.使用属性或者叫使用成员变量 进行赋值
            格式：
                对象名.属性名 = 值;
                对象名.成员变量 = 值;
                stu.name = "张三";
                stu.age = 18;
             2.使用属性或者叫使用成员变量 进行取值
             格式：
                成员变量的数据类型 变量名 = 对象名.成员变量名;
                String x = stu.name;
                int y = stu.age;
                输出取值
                sout(stu.name);
                sout(stu.age);
              3.使用成员方法
              格式：
                对象名.成员方法名();

 */
public class Test02面向对象入门小结 {
}
