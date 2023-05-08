package com.itheima._03循环结构;

/*
    统计水仙花数个数，并打印，两个一行
    分析：
        水仙花数：是3位数 100-999 ；各个位上数字的立方和等于数字本身
        使用循环遍历100--999之间所有数字
        求每一个数字各个位上数字，然后求立方和
        判断立方和 和 数字本身是否相等
        如果相等就是水仙花数
     步骤：
        1.使用for循环获取每一个三位数
        2.求三位数各个位上的数字
        3.求各个位上数字的立方和
        4.判断立方和是否和数字本身相等
 */
public class Demo06统计水仙花数 {
    public static void main(String[] args) {
        //定义统计变量
        int count = 0;
        //1.使用for循环获取每一个三位数
        for (int i = 100; i <= 999; i++) {
            //2.求三位数各个位上的数字
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            //3.求各个位上数字的立方和
            double sum = Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3);
            //4.判断立方和是否和数字本身相等
            if (sum == i) {
                //统计水仙花数的个数
                count++;
                System.out.print(i + " ");
                if (count % 2 == 0) {
                    System.out.println();
                }

            }
        }
    }
}
