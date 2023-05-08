package com.itheima._02API;

import java.io.InputStream;
import java.util.Scanner;

/*
    Scanner类的使用:
        1. 在API中查找Scanner
        2. 查看包结构
            java.util.Scanner

           类结构：
            public final class Scanner extends Object implements Iterator<String>, Closeable
        3. 查看描述：
            一个简单的文本扫描器
        4.常用构造方法：
            Scanner(InputStream source) 构造一个新的 Scanner ，产生从指定输入流扫描的值。
        5.常用成员方法
            int nextInt() 将输入的下一个标记扫描为 int 。
            String next() 查找并返回此扫描仪的下一个完整令牌。
            String nextLine() 将此扫描仪推进到当前行并返回跳过的输入。

 */
public class Demo02Scanner类的使用 {
    public static void main(String[] args) {
       /* InputStream source = System.in;
        Scanner scanner = new Scanner(source);*/
        Scanner sc = new Scanner(System.in);
        //int nextInt() 将输入的下一个标记扫描为 int 。
        /*System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        System.out.println(num);*/

        //String next() 查找并返回此扫描仪的下一个完整令牌。 遇到空格结束数据接收
        System.out.println("请输入一个字符串：");
        String s1 = sc.next();
        System.out.println(s1);

        //String nextLine() 将此扫描仪推进到当前行并返回跳过的输入。遇到回车换行，就结束数据接收
        System.out.println("请输入一个字符串：");
        String s2 = sc.nextLine();
        System.out.println(s2);
    }
}
