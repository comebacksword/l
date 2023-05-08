package com.itheima._05练习;

import java.util.ArrayList;

/*
    1、请按以下要求编写代码：

	1.        定义一个只能存储字符串的集合对象；

	2.        向集合内添加以下数据：

      	 “孙悟空”

       	“猪八戒”

       	“沙和尚”

      	 “铁扇公主”

	3.        不用遍历，直接打印集合；

	4.        获取第4个元素（注意，是--第4个元素，它的索引是？）

	5.        打印一下集合大小；

	6.        删除元素“铁扇公主”

	7.        删除第3个元素（注意：是--第3个元素）

	8.        将元素“猪八戒”改为“猪悟能”

1. 再次打印集合；

 */
public class Demo01 {
    public static void main(String[] args) {
        //1.        定义一个只能存储字符串的集合对象；
        ArrayList<String> list = new ArrayList<>();
        //2.        向集合内添加以下数据：
        list.add("孙悟空");
        list.add("猪八戒");
        list.add("沙和尚");
        list.add("铁扇公主");
        //3.        不用遍历，直接打印集合；
        System.out.println(list);
        //4.        获取第4个元素（注意，是--第4个元素，它的索引是？）
        String s = list.get(3);
        System.out.println(s);
        //5.        打印一下集合大小；
        int size = list.size();
        System.out.println("集合的大小："+size);
        //6.        删除元素“铁扇公主”
//        list.remove("铁扇公主");
        list.remove(3);
        //7.        删除第3个元素（注意：是--第3个元素）
        list.remove(2);
        //8.        将元素“猪八戒”改为“猪悟能”
        list.set(1,"猪悟能");
        //再次打印集合；
        System.out.println(list);


    }
}
