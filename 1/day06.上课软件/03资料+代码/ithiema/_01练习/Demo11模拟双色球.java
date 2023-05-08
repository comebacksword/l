package com.ithiema._01练习;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
    随机一组中奖号码的分析:
        中奖号码由6个红球和1个篮球组成(注意：6个红球要求不能重复)。
        红球 : 1--33
        篮球 : 1--16
    用户输入一组双色球号码:
        1.键盘录入
        2.判断红球是否重复 1--33之间
        3.输入蓝球 1--16之间
    中奖情况判断的分析:
        1.中奖号码
        2.用户录入号码
        3.输出中奖结果

 */
public class Demo11模拟双色球 {
    public static void main(String[] args) {
        int[] luckNumbers = createLuckNumbers();
        System.out.println(Arrays.toString(luckNumbers));
        int[] userNumbers = userInputNumbers();
        System.out.println(Arrays.toString(userNumbers));
        judge(luckNumbers, userNumbers);


    }

    private static void judge(int[] luckNumbers, int[] userNumbers) {
        //1.定义计数器 记录红球中奖次数
        int redBall = 0;
        for (int i = 0; i < luckNumbers.length - 1; i++) {
            for (int j = 0; j < userNumbers.length-1; j++) {
                if (luckNumbers[i] == userNumbers[j]){
                    redBall++;
                    break;
                }
            }
        }
        //2.求蓝球是否中奖
        int blueBall = luckNumbers[6] == userNumbers[6] ? 1:0;

        if (redBall == 6 && blueBall == 1) {
            System.out.println("抽中了一等奖恭喜获得一千万");
        } else if (redBall == 6) {
            System.out.println("抽中了二等奖恭喜获得五百万");
        } else if (redBall == 5 && blueBall == 1) {
            System.out.println("抽中了三等奖恭喜获得三千元");
        } else if (redBall == 5) {
            System.out.println("抽中了四等奖恭喜获得二百元");
        } else if (redBall == 4 && blueBall == 1) {
            System.out.println("抽中了四等奖恭喜获得二百元");
        } else if (redBall == 4) {
            System.out.println("抽中了五等奖恭喜获得十元");
        } else if (redBall == 3 && blueBall == 1) {
            System.out.println("抽中了五等奖恭喜获得十元");
        } else if (redBall == 2 && blueBall == 1) {
            System.out.println("抽中了五等奖恭喜获得十元");
        } else if (redBall == 1 && blueBall == 1) {
            System.out.println("抽中了六等奖恭喜获得五元");
        } else if (blueBall == 1) {
            System.out.println("抽中了六等奖恭喜获得十元");
        } else {
            System.out.println("哦豁一毛都没抽中");
        }

    }

    public static int[] userInputNumbers() {
        //定义数组 存放用户输入的号码
        int arr[] = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入第" + (i + 1) + "个红球号码：");
            int redBall = sc.nextInt();
            //判断红球是否在1--33之间
            if (redBall >= 1 && redBall <= 33) {
                //判断红球是否重复
                boolean flag = isExisting(arr, redBall);
                if (flag) {
                    arr[i] = redBall;
                } else {
                    i--;
                    System.out.println("您输入号码重复，请重新输入！");
                }

            } else {
                System.out.println("您的输入有误,请重新输入！");
                i--;
            }

        }
        while (true) {
            System.out.println("请输入蓝球号码：");
            int blueBall = sc.nextInt();
            if (blueBall >= 1 && blueBall <= 16) {
                arr[6] = blueBall;
                break;
            } else {
                System.out.println("您的输入有误，请重新输入！");
            }
        }

        return arr;
    }

    //生成中奖号
    public static int[] createLuckNumbers() {
        //定义长度为7的数组 中奖号码由6个红球和1个篮球
        int[] arr = new int[7];
        //使用随机数生成蓝球
        Random random = new Random();
        int blueBall = random.nextInt(16) + 1;
        arr[6] = blueBall;
        //生成红球
        for (int i = 0; i < arr.length - 1; i++) {
            int redBall = random.nextInt(33) + 1;
            //判断红球号码是否在数组中存在
            boolean flag = isExisting(arr, redBall);
            if (flag) {
                arr[i] = redBall;
            } else {
                i--;
            }
        }

        return arr;

    }

    //判断红球号码是否在数组中存在
    public static boolean isExisting(int[] arr, int redBall) {
        //默认红球号码可用

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == redBall) {
                return false;
            }
        }
        return true;

    }
}
