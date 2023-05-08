package com.itheima._05跳转控制语句;
/*
    流程跳转控制语句：
        continue; 跳过本次 继续下一次
        break; 在循环中 用来结束循环，但是结束当前循环或者说是离我最近循环
 */
public class Demo01 {
    public static void main(String[] args) {
        // continue; 跳过本次 继续下一次
        for (int i = 0; i < 5; i++) {
            if (i==2){
                continue;
            }
            System.out.println(i);
        }
        System.out.println("-------");
        //break; 在循环中 用来结束循环，但是结束当前循环或者说是离我最近循环
        for (int i = 0; i < 5; i++) {
            if (i==2){
                break;
            }
            System.out.println(i);
        }
        //但是结束当前循环或者说是离我最近循环
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 2){
                    break;
                }
                System.out.println("i = "+i +";   j = "+j);
            }
        }
        System.out.println("-----");
        //如果嵌套循环 想结束外层循环
        wc:for (int i = 0; i < 5; i++) {
            nc: for (int j = 0; j < 5; j++) {
                if (j == 2){
                    break wc;
                }
                System.out.println("i = "+i +";   j = "+j);
            }
        }
    }
}
