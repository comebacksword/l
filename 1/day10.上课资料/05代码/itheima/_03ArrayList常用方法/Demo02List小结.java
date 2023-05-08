package com.itheima._03ArrayList常用方法;

import java.util.ArrayList;
import java.util.Iterator;

/*
        常用方法小结：
            boolean add(E e) 将指定的元素追加到此列表的末尾。
            void add(int index, E element) 在此列表中的指定位置插入指定的元素。
            int size() 返回此列表中的元素数。
            E get(int index) 返回此列表中指定位置的元素。
            Iterator<E> iterator() 以正确的顺序返回该列表中的元素的迭代器。
            E remove(int index) 删除该列表中指定位置的元素。
            boolean remove(Object o) 从列表中删除指定元素的第一个出现（如果存在）。
            E set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
 */
public class Demo02List小结 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        // boolean add(E e) 将指定的元素追加到此列表的末尾。
        list.add("思帅");
        list.add("杨涌");
        list.add("刘毅");
        list.add("高海谦");
        list.add("张宇");
        list.add("家豪");
        list.add("陶铖");
        list.add("赵宇飞");
        list.add("胡坷屹");
        System.out.println(list);
        list.add(1,"张三");
        list.add(5,"张三");
        list.add(7,"张三");
        list.add(8,"张三");
        list.add(11,"张三");
        list.add(12,"张三");
        System.out.println(list);
        //int size() 返回此列表中的元素数
        int size = list.size();
        System.out.println(size);

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            //E get(int index) 返回此列表中指定位置的元素。
            String s = list.get(i);
            System.out.println(s);
        }
        //迭代器 了解
        // Iterator<E> iterator() 以正确的顺序返回该列表中的元素的迭代器。
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println("------------");
        //E remove(int index) 删除该列表中指定位置的元素。
        //删除集合中的张三
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("张三")){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
        //E set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
        list.set(5,"李家豪");
        System.out.println(list);


    }
}
