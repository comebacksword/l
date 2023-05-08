package com.itheima._05练习;

import java.util.ArrayList;
import java.util.Collections;

/*
    定义ArrayList集合，存入多个字符串
	1、 如:"ab1","123ad","bca","dadfadf","dddaaa","你好啊","我来啦","别跑啊"
 	2.遍历集合,删除长度大于5的字符串,打印删除后的集合对象
 	3.基于上一步,删除集合中元素包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
 */
public class Demo05 {
    public static void main(String[] args) {
        //定义ArrayList集合，存入多个字符串
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"ab1","123ad","bca","dadfadf","dddaaa","你好啊","我来啦","别跑啊");
        //2.遍历集合,删除长度大于5的字符串,打印删除后的集合对象
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length()>5){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
        //3.基于上一步,删除集合中元素包含0-9数字的字符串(只要字符串中包含0-9中的任意一个数字就需要删除此整个字符串)
        //[ bca, 你好啊, 我来啦, 别跑啊]
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            for (int j = 0; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (ch>='0'&&ch<='9'){
                    list.remove(i);
                    i--;
                    break;
                }
            }
        }
        System.out.println(list);



    }
}
