package com.itheima._03循环结构;

public class Demo02For循环求和 {
    public static void main(String[] args) {
        //求1--100之间所有数字和
        int sum = 0;
        //遍历1--100之间所有的数字
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum = "+sum);
    }
}
