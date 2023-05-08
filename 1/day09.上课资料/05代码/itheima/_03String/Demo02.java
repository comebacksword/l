package com.itheima._03String;

public class Demo02 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ab";
        String s3 = s2 + "c"; // new StringBuilder(s2).append("c").toString();
        String s4 = "ab" + "c";
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //true
    }
}
