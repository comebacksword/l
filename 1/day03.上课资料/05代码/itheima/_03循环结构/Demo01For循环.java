package com.itheima._03循环结构;
/*
    循环结构：
        有明确的的开始和结束标志，循环往复执行一段代码
       分类：
        1.for循环
        2.while循环
        3.do-while循环
     for循环格式：
        for(初始化语句;条件判断语句;条件控制语句){
            循环体语句;
        }
        执行流程：
            1.初始化语句
            2.执行条件判断语句 ==> true 执行循环体语句 ==> 条件控制语句 ==>  2.执行条件判断语句
                            ==> false 结束for循环
 */
public class Demo01For循环 {
    public static void main(String[] args) {
        //打印1--5
        for (int i=1;i<=5;i++){
            System.out.println(i);
        }
        System.out.println("---------------");
        //打印5--1
        for (int i=5;i>=1;i--){
            System.out.println(i);
        }
    }
}
