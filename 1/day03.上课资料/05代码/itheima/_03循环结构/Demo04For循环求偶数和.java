package com.itheima._03循环结构;
//求1--100之间所有偶数和
public class Demo04For循环求偶数和 {
    public static void main(String[] args) {
        //定义求和变量
        int sum = 0;
        //遍历1--100之间所有数字，筛选出偶数，累加
        /*for (int i = 1; i <= 100; i++) {
            if (i%2==0) //if语句后面如果只有一行代码，大括号可以省略不写
                sum+=i;
        }*/
        for (int i = 0; i <= 100; i+=2) {
            sum+=i;
        }
        System.out.println("1--100之间所有偶数和："+sum);
    }
}
