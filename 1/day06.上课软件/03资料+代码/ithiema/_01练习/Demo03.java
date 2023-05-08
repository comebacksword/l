package com.ithiema._01练习;

/*
    判断101 -- 200之间有多少个素数，并输出

    分析：
        1.求素数
            素数：如果除了1和它本身以外，不能被其他正整数整除，就叫素数。 2 3 5 7 11 13 17 19 23 29 31
        2.统计
        3.输出素数 和个数
 */
public class Demo03 {
    public static void main(String[] args) {
        //定义统计变量
        int count = 0;
      //判断是否是素数
        for (int a = 101; a <= 200; a++) {
            //调用判断是否是素数的方法，如果是返回true
            boolean flag = isPrime(a);
            if (flag){
                System.out.println(a+"是素数");

                //统计
                count++;
            }
        }
        System.out.println("101---200之间所有素数有："+count+"个");
    }
    //判断是否是素数的方法，如果是返回true
    private static boolean isPrime(int a) {
        boolean flag = true;
        for (int i = 2; i <= a /2; i++) {
            if (a %i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
