package com.itheima._03循环结构;
/*
    1--100 逢七必过：数字只要包含7就喊过 是7的倍数 或者数字有7 就要喊过

    continue:关键字的意思是跳过本次继续下一次
 */
public class Demo07逢七必过 {
    public static void main(String[] args) {
        /*for (int i = 0; i < 10; i++) {
            if (i==7){
                System.out.println("过");
                continue;
            }
            System.out.println(i); // 0 1 3 4
        }*/
        int count =0 ;
        //遍历1--100之间的数字
        for (int i = 1; i < 100; i++) {
            //判断 是否包含7 ：是7的倍数 或者个位上是7 或者十位是7
            if (i%7==0 || i%10 == 7 || i/10%10 == 7){

                System.out.println("过");

                continue;
            }
            System.out.println(i);

        }
    }
}
