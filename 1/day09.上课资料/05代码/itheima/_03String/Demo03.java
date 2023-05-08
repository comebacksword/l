package com.itheima._03String;

import java.util.Arrays;

/*
    字符串的常用方法：
        boolean equals(Object anObject) 将此字符串与指定对象进行比较。
        char charAt(int index) 返回 char指定索引处的值。
        boolean endsWith(String suffix) 测试此字符串是否以指定的后缀结尾。
        byte[] getBytes() 使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
        int length() 返回此字符串的长度。
        String replace(CharSequence target, CharSequence replacement) 将与字面目标序列匹配的字符串的每个子字符串替换为指定的字面替换序列。
        String substring(int beginIndex) 返回一个字符串，该字符串是此字符串的子字符串。
        String trim() 返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
 */
public class Demo03 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); //true
        String s3 = new String("abc");
        System.out.println(s1 == s3); //false
        //boolean equals(Object anObject) 将此字符串与指定对象进行比较。
        boolean b1 = s1.equals(s2);
        System.out.println(b1); //true
        boolean b2 = s1.equals(s3);
        System.out.println(b2); //true

        //char charAt(int index) 返回 char指定索引处的值。
        String s4 = "abcdefg";
//        char c = s4.charAt(0);
//        System.out.println(c);
        /*for (int i = 0; i < 7; i++) {
            char c1 = s4.charAt(i);
            System.out.println(c1);
        }*/
        //boolean endsWith(String suffix) 测试此字符串是否以指定的后缀结尾。
        String date = "2021年5月";
        boolean b3 = date.endsWith("5月");
        System.out.println(b3);
        //boolean startsWith(String prefix) 测试此字符串是否以指定的前缀开头。
        String s5 = "李家豪";
        boolean b4 = s5.startsWith("李");
        System.out.println(b4);
        //byte[] getBytes() 使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
        String name = "刘毅";
        byte[] bytes = name.getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));

        //boolean isEmpty()返回 true如果，且仅当 length()为 0 。
        String s6 = "";
        boolean b5 = s6.isEmpty();
        System.out.println(b5);
        System.out.println(s5.isEmpty());

        // int length() 返回此字符串的长度。
        String s7 = "abcdefg";
        int length = s7.length();
        System.out.println(length);
        /*for (int i = 0; i < s7.length(); i++) {
            System.out.println(s7.charAt(i));
        }*/
        //args.length

        //String replace(CharSequence target, CharSequence replacement) 将与字面目标序列匹配的字符串的每个子字符串替换为指定的字面替换序列。
        String massage = "你真的TMD你真的TMD你真的TMD你真的TMD";
        String replace = massage.replace("TMD", "***");
        System.out.println(replace);

        //String[] split(String regex) 将此字符串分割为给定的 regular expression的匹配。
        String stuInfo = "张三,23";
        String[] sp1 = stuInfo.split(",");
        System.out.println(Arrays.toString(sp1));

        //String substring(int beginIndex) 返回一个字符串，该字符串是此字符串的子字符串。
        String s8 = "abcdefg";
        String s9 = s8.substring(3);
        System.out.println(s9);
        //String substring(int beginIndex, int endIndex) 返回一个字符串，该字符串是此字符串的子字符串。
        String s10 = s8.substring(1, 3);
        System.out.println(s10);

        //char[] toCharArray() 将此字符串转换为新的字符数组。
        char[] chars = s8.toCharArray();
        System.out.println(Arrays.toString(chars));
       /* for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }*/
        //String toLowerCase()将所有在此字符 String使用默认语言环境的规则，以小写。
        String s11 = "ABCdefg";
        String s12 = s11.toLowerCase();
        System.out.println(s12);
        //String toUpperCase() 将所有在此字符 String使用默认语言环境的规则大写。
        String s13 = s11.toUpperCase();
        System.out.println(s13);

//        System.out.println(s11.equals(s12));//false

        //boolean equalsIgnoreCase(String anotherString) 将此 String与其他 String比较，忽略案例注意事项。
        System.out.println(s11.equalsIgnoreCase(s12));

        // String trim() 返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
        String username = "                      admin                 ";
        System.out.println(username);
        String s14 = username.trim();
        System.out.println(s14);

    }
}
