package com.ithiema._01练习;

import java.util.Arrays;
import java.util.Scanner;

/*
    在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。
    选手的最后得分为：去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分。

    1.定义长度为6 的数组 ，存放6个评委打分
    2.使用键盘录入6个成绩 填充数组
    3.求最高分 求最低分 求总分
    4.总分减去 最高分最低分 除以 4 得到歌手最终得分

 */
public class Demo09评委打分 {
    public static void main(String[] args) {
        //1.定义长度为6 的数组 ，存放6个评委打分
        int [] arr = new int[6];
        //    2.使用键盘录入6个成绩 填充数组
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+(i+1)+"个评委的打分：");
            int score = sc.nextInt();
            if (score>=0&&score<=100){
                arr[i] = sc.nextInt();
            }else {
                System.out.println("您输入的分数有误，请检查后重新输入！");
                i--;
            }

        }
        //打印数组
        System.out.println(Arrays.toString(arr));
        //    3.求最高分 求最低分 求总分
        int max = arr[0];//最高分
        int min = arr[0];//最低分
        int sum = 0;//总分
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("max = "+ max);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("min = "+min);
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        System.out.println("sum = "+sum);
        //    4.总分减去 最高分最低分 除以 4 得到歌手最终得分
        int avg = (sum-max-min)/(arr.length-2);
        System.out.println("歌手的最终得分："+avg);
    }
}
