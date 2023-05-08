package com.itheima._02面向对象;

/*
    private: 修饰成员变量
        表示私有的，外界不能直接访问，只能在本类中访问
        如果测试类中本类的对象，需要访问私有成员变量 赋值，在本类提供setXxx 给私有成员变量赋值
        如果测试类中本类的对象，需要访问私有成员变量 取值，在本类提供getXxx 给私有成员变量取值
    this关键字：
        1.区分成员变量和局部变量
        2.代表当前对象的引用，那个对象调用此方法，方法中的this，就是此对象
 */
public class Test01Student {
    public static void main(String[] args) {
        //创建对象
        Student student = new Student();
        //使用成员变量
        //student.name = "林青霞";
        student.setName("林青霞");
        //student.age = 300; // 0 -- 120
        student.setAge(16);


//        System.out.println(student.name);
        //System.out.println(student.age);
        String name = student.getName();
        System.out.println(name);
        int age = student.getAge();
        System.out.println(age);

        Student student1 = new Student();
        student1.setName("王祖贤");
        student1.setAge(17);

        System.out.println(student1.getName());
        System.out.println(student1.getAge());
    }
}
