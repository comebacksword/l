package com.itheima._03ArrayList常用方法;

import java.util.ArrayList;
import java.util.Iterator;

/*
    boolean isEmpty() 如果此列表不包含元素，则返回 true 。
    Iterator<E> iterator() 以正确的顺序返回该列表中的元素的迭代器。
    E remove(int index) 删除该列表中指定位置的元素。
    boolean remove(Object o) 从列表中删除指定元素的第一个出现（如果存在）。
    E set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
 */
public class Demo01 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        //boolean isEmpty() 如果此列表不包含元素，则返回 true 。
        System.out.println(list.isEmpty());
        list.add("张三");
        /*String s = printList(list);
        System.out.println(s);*/
        list.add("李四");
        list.add("张三");
        list.add("王五");
        list.add("张三");

        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }*/
        //E remove(int index) 删除该列表中指定位置的元素。根据索引 删除指定元素，返回被删除的元素
//        String s = list.remove(0);
//        System.out.println(s);
//        System.out.println(list);
        //boolean remove(Object o) 从列表中删除指定元素的第一个出现（如果存在）。
        /*boolean b = list.remove("张三");
        System.out.println(b);
        System.out.println(list);*/
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("张三")){
                list.remove("张三");
                break;
            }
        }
        System.out.println(list);

        //E set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
        String s = list.set(0, "李小四");
        System.out.println(s);
        System.out.println(list); //李小四
        System.out.println(list);

    }
    public static String printList(ArrayList<String> list){
        boolean empty = list.isEmpty();
        if (empty){
            return null;
        }else {
            return list.toString();
        }

    }
}
