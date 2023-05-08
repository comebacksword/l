package com.itheima._01方法概述;

/*
    方法的概述：
        1.方法就是解决问题办法
        2.编程中的方法，具有特定功能的代码块
    方法定义：
        格式1：
            public static void 方法名(){
                方法体
            }
         调用：
           在main方法中调用格式 ：方法名();
        特点：
            方法和方法之间是平行关系，不能嵌套定义
            方法定义后不会自己执行，需要被调用后才能执行
            方法定义的先后顺序和方法执行顺序无关 和方法调用的顺序有关，谁先调用谁先执行

 */
public class Demo01 {
    public static void printHelloWorld(){
        System.out.println("HelloWorld");
    }
    public static void main(String[] args) {
//        sum();
//        printHelloWorld();
        sum2();
    }
    public static void sum(){
        System.out.println(1+1);
    }
    //定义方法求1-100之间的数据和
    public static void sum2(){
        //定义求和变量
        int sum = 0;
        //使用循环遍历获取1--100之间所有数据
        for (int i = 1; i <= 100; i++) {
            sum+=i;
        }
        System.out.println("1--100之间所有数据:"+sum);
    }

}
