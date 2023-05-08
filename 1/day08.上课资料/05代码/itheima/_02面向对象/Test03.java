package com.itheima._02面向对象;
/*
    面向对象的特征：
        封装：
            表现形式：
                1.private 关键字 修饰成员变量
                2.特定功能代码 封装方法
                3.具有形同属性和行为一类事物，封装成类
        继承：
            父类和子类产生关系，extends
        多态：
            父类的引用存放子类对象
 */

public class Test03 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        //输出数组的元素，如下：[1,2,3,4,5,6,7,8,9]
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+", ");
            }
        }
        System.out.println("]");
    }
}

class Cat extends Animal{
    public static void main(String[] args) {
        Animal cat = new Cat();
    }
}
class Animal{}

