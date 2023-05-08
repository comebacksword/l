package com.itheima._03循环结构;
/*
    1.for循环的初始化语句在循环内部，出来循环就不能使用
    2.while和do-while初始化语句在循环外面，循环结束后，可以继续使用
    3.for循环和while循环 先判断后执行 ，do-while先执行后判断
 */
public class Demo13三种循环区别 {
    public static void main(String[] args) {
        //打印1--5
        for (int i=1;i<=5;i++){
            System.out.println(i);
        }

        System.out.println("---------------");
        int i= 1;
        while (i<=5){
            System.out.println(i);
            i++;
        }
        System.out.println(i);
        System.out.println("---------------");
        int j = 1;
        do {
            System.out.println(j);
            j++;
        }while (j<=5);
    }
}
