package com.itheima._01Arraylist入门;

import java.util.ArrayList;

/*
    ArrayList集合存储数据的特点：
        有序可可重复;

 */
public class Demo02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");
        list.add("张三5");
        list.add("张三6");
        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");
        list.add("张三5");
        list.add("张三6");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }
}
