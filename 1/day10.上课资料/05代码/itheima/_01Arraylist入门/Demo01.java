package com.itheima._01Arraylist入门;

/*
ArrayList:
    包结构：
        java.util.ArrayList
        public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
    描述：
        可调整大小的数组
    构造方法：
        ArrayList() 构造一个初始容量为十的空列表。
        ArrayList(int initialCapacity) 构造具有指定初始容量的空列表。
    常用方法：
        boolean add(E e) 指定的元素追加到此列表的末尾。
        void add(int index, E element) 在此列表中的指定位置插入指定的元素。
        E get(int index) 返回此列表中指定位置的元素。
        int size() 返回此列表中的元素数。
 */

import java.util.ArrayList;

public class Demo01 {
    public static void main(String[] args) {
        //ArrayList() 构造一个初始容量为十的空列表。
        ArrayList arrayList = new ArrayList();
        System.out.println(arrayList);
        //ArrayList(int initialCapacity) 构造具有指定初始容量的空列表。
        ArrayList list = new ArrayList(20);
        System.out.println(list);
        //boolean add(E e) 指定的元素追加到此列表的末尾。
        arrayList.add("张三");
        arrayList.add(100);
        arrayList.add(true);
        arrayList.add('a');
        arrayList.add(3.14);
        System.out.println(arrayList);

        int [] arr = new int[10];
        //泛型 用来约束集合中存储数据的数据类型 格式：类名<数据类型>
        ArrayList<String> lists = new ArrayList<>();
        lists.add("张三");
        /*lists.add(100);
        lists.add(true);
        lists.add('a');
        lists.add(3.14);*/
        lists.add("李四");
        lists.add("王二麻子");
        lists.add("赵六");
        lists.add("田七");
        lists.add("老八");
        lists.add("老幺0");
        lists.add("老幺1");
        lists.add("老幺2");
        System.out.println(lists);
        //void add(int index, E element) 在此列表中的指定位置插入指定的元素。
        lists.add(2,"思帅");
        System.out.println(lists);

        //E get(int index) 返回此列表中指定位置的元素。
        String s1 = lists.get(0);
        System.out.println(s1);
        System.out.println("----------");
        //获取集合中所有的元素 底层是数组，是数组就有索引，就是从0开始，到最大元素数量减一
        for (int i = 0; i < 8; i++) {
            String s = lists.get(i);
            System.out.println(s);
        }
        //求集合中存储元素的个数
//        int size() 返回此列表中的元素数。
        int size = lists.size();
        System.out.println(size);

        //遍历集合通用方法
        for (int i = 0; i < lists.size(); i++) {
            String s = lists.get(i);
            System.out.println(s);
        }


    }
}
