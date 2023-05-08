package com.itheima._03循环结构;

/*
    @@@@@
    @@@@@
    @@@@@
    @@@@@

 */
public class Demo08打印星号 {
    public static void main(String[] args) {
        for (int j = 0; j < 4; j++) { //外层循环控制行数
            for (int i = 0; i < 5; i++) { //内层循环控制列数
                System.out.print("@");
            }
            System.out.println();
        }
    }
}
