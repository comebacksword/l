package com.itheima._03String;

import java.util.Arrays;

/*
    String:
        1.查看类结构
            java.lang.String
            public final class String extends Object implements Serializable, Comparable<String>, CharSequence
        2.描述
            String类代表字符串。 Java程序中的所有字符串文字（例如"abc" ）都被实现为此类的实例。
            字符串不变; 它们的值在创建后不能被更改。因为String对象是不可变的，它们可以被共享。
        3.常用构造方法
            String(String original) 初始化新创建的String对象，使其表示与参数相同的字符序列; 换句话说，新创建的字符串是参数字符串的副本。
            String() 初始化新创建的 String对象，使其表示空字符序列。
            String(byte[] bytes)通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
            String(byte[] bytes, int offset, int length) 通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。
            String(char[] value) 分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。
            String(char[] value, int offset, int count) 分配一个新的 String ，其中包含字符数组参数的子阵列中的字符。
 */
public class Demo01 {
    public static void main(String[] args) {
        String name1 = "张三";
        String name2 = "张三";
        //String(String original) 初始化新创建的String对象，使其表示与参数相同的字符序列; 换句话说，新创建的字符串是参数字符串的副本。
        String name3 = new String("张三");
        String name4 = new String("张三");
//        System.out.println(name3 == name4);
        //String() 初始化新创建的 String对象，使其表示空字符序列。
        String s1 = new String();//String s = "";
        System.out.println(s1);
        //String(byte[] bytes)通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
        byte[] bytes = {97,98,99,100,101,102,103};
        String s2 = new String(bytes);
        System.out.println(s2);
        //String(byte[] bytes, int offset, int length) 通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。
        String s3 = new String(bytes, 2, 3);
        System.out.println(s3);

        //String(char[] value) 分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。
        char[] chars = {'a','b','c','d','e','f','g'};
        String s4 = new String(chars);
        System.out.println(s4);
        //String(char[] value, int offset, int count) 分配一个新的 String ，其中包含字符数组参数的子阵列中的字符。
        String s5 = new String(chars, 0, 3);
        System.out.println(s5);

        //如果要定义一个已知值的字符串
        String s = "值";


    }
}
