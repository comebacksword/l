package com.itheima._03循环结构;

//求1--100之间所有奇数和
public class Demo03For循环求奇数和 {
    public static void main(String[] args) {
        int sum = 0;
        //循环遍历获取1--100之间所有数据和，数据必须是奇数
        /*for (int i = 1; i <= 100; i++) {
            //判断是否是奇数，如果是累加求和
            if (i%2!=0){
                sum+=i;//sum = sum+i;
            }
        }*/
        for (int i = 1; i < 100; i+=2) {
            sum+=i;
        }
        System.out.println("1--100之间所有奇数和："+sum);
    }
}
