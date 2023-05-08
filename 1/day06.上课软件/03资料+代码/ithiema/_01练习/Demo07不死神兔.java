package com.ithiema._01练习;
/*
    一对兔子，从出生后第三个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
    假如兔子都不死，问第二十个月的兔子对数为多少？
    1 1 2 3 5 8 13
    1 1 1 1 1 1 1
        1 1 1 1 1
          1 1 1 1
            1 1 1
            1 1 1
              1 1
              1 1
              1 1
                1
                1
                1
                1
                1
 */
public class Demo07不死神兔 {
    public static void main(String[] args) {
        //定义长度为20的数组
        int [] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
       /* arr[2] = arr[0] + arr[1];
        arr[3] = arr[1] + arr[2];
        arr[4] = arr[2] + arr[3];
        arr[5] = arr[3] + arr[4];*/

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-2]+arr[i-1];
        }
        System.out.println("第二十个月兔子有："+arr[19]+"对");

        //调用递归实现斐波那契数列
        int count = fibonacci(20);
        System.out.println(count);

    }

    //递归实现不死神兔
    public static int fibonacci(int month){
        if (month == 1 || month == 2){
            return 1;
        }else {
            return fibonacci(month - 1) + fibonacci(month - 2);
        }
    }

    //递归：方法自己调用自己，他也有明确开始和结束标志 1*2*3*4*5
    /*public static int jieCheng(int n){
        if (n==1)
            return 1;
        else
           return n*jieCheng(n-1);  // 3 *
    }*/

}
