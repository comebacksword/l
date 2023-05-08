package com.itheima._04StringBuilder;
/*
    StringBuilder类的学习：
        1.类结构
            java.lang.StringBuilder
            public final class StringBuilder extends Object implements Serializable, CharSequence
        2.描述：
            一个可变的字符序列；
        3.构造方法
            StringBuilder() 构造一个没有字符的字符串构建器，初始容量为16个字符。
            StringBuilder(int capacity) 构造一个没有字符的字符串构建器，由 capacity参数指定的初始容量。
            StringBuilder(String str) 构造一个初始化为指定字符串内容的字符串构建器。
        4.成员方法
            int capacity() 返回当前容量。
            StringBuilder append(boolean b) 将 boolean参数的字符串表示附加到序列中。
            String toString() 返回表示此顺序中的数据的字符串。


 */
public class Demo01 {
    public static void main(String[] args) {
        //StringBuilder() 构造一个没有字符的字符串构建器，初始容量为16个字符。
        StringBuilder sb = new StringBuilder();
        //int capacity() 返回当前容量。
        int capacity = sb.capacity();
        System.out.println(capacity);

        //StringBuilder(int capacity) 构造一个没有字符的字符串构建器，由 capacity参数指定的初始容量。
        StringBuilder sb2 = new StringBuilder(32);
        int capacity1 = sb2.capacity();
        System.out.println(capacity1);

        //StringBuilder(String str) 构造一个初始化为指定字符串内容的字符串构建器。
        StringBuilder sb3 = new StringBuilder("abc");
        System.out.println(sb3);
        System.out.println(sb3.capacity());
        System.out.println("=============================");
        //常用方法
        //StringBuilder append(boolean b) 将 boolean参数的字符串表示附加到序列中。
        StringBuilder sb4 = sb.append(100);
        System.out.println(sb4);
        System.out.println(sb);
        System.out.println(sb == sb4);
        System.out.println("--------------------------");
        StringBuilder sb5 = sb4.append(true);
        System.out.println(sb4);
        System.out.println(sb5);
        System.out.println(sb);
        System.out.println(sb == sb4);
        System.out.println(sb5 == sb4);
        sb.append(100).append(true).append('a').append("zhangsan");
        System.out.println(sb);
        System.out.println(sb4);
        System.out.println(sb5);
        System.out.println("----------------------");
        System.out.println(sb.toString());
    }
}
