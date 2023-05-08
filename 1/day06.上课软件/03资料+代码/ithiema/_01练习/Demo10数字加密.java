package com.ithiema._01练习;

import java.util.Arrays;
import java.util.Scanner;

/*
某系统的数字密码，比如1983，采用加密方式进行传输，
规则如下：先得到每位数，然后每位数都加上5,再对10求余，最后将所有数字反转，得到一串新数。
    1983
     1  + 5  ==> % 10  ==6
     9  + 5  ==> % 10  ==4
     8  + 5  ==> % 10  ==3
     3  + 5  ==> % 10  ==8
键盘录入一个数字 加密
    1.求键盘录入的数字是几位数
    2.求各个位上数字
    3.加密
    4.反转后输出
 */
public class Demo10数字加密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = sc.nextInt();
        //求数字是几位数
        int count = counts(num);
        //定义数组
        int [] arr = new int[count];
        //求各个位上数字
        int y = 1;
        for (int i = 0; i < count; i++) {
            arr[i] = num/y%10;
            y*=10;
        }
        System.out.println("各个位上数字"+ Arrays.toString(arr));
        //加密
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i]+5)%10;
        }
        System.out.println("加密后的数字"+ Arrays.toString(arr));
    }
    //求数字是几位数
    private static int counts(int num) {
        //判断数字是几位数
        int count = 0;
        while (true) { //123
            if (num == 0) {
                break;
            } else {
                num /= 10; //1
                count++;
            }
        }
        return count;
    }
}
