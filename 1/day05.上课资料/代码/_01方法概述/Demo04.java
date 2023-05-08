package com.itheima._01方法概述;

/*
    方法定义格式：
        格式1：
            public static void 方法名(){
                方法体
            }
        调用：
            在main方法中调用：方法名();
        格式2：
            public static void 方法名(参数列表){ //参数可以有一个也可以有多个，也可以没有，如果有多个要使用逗号隔开
                方法体
            }
        调用：
            在main方法中调用：方法名();

        格式3：
            public static 返回值类型 方法名(参数列表){ //参数可以有一个也可以有多个，也可以没有，如果有多个要使用逗号隔开
                方法体;
                return 值; //值要和方法的返回值数据类型一致
            }
 */
public class Demo04 {
    public static void main(String[] args) {
        //格式1调用：
        getNum();//直接调用
        //void x = getNum();//赋值调用
//        System.out.println(getNum());//输出调用
//        格式2:
        getSum(100);

        //格式3调用：
        int sum2 = getSum2(10, 20);
        System.out.println(sum2);
        System.out.println(getSum2(5,10));

    }

    //格式1
    //定义求所有水仙花数在控制台输出
    public static void getNum() {
        //1.循环 遍历获取所有三位数
        for (int i = 100; i <= 999; i++) {
            //2.求三位数各个位上的数字
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                System.out.println("水仙花数：" + i);
            }
        }

    }

    //格式2：
    //定义方法 求1到n之间的所有奇数和(n>1)在控制台输出
    public static void getSum(int n) {
        //1.定义变量
        int sum = 0;
        //2.获取1--n之间的所有数据
        for (int i = 1; i <= n; i++) {
            //3.判断是否是奇数
            if (i%2!=0){
                //4.是奇数就累加求和
                sum+=i;
            }
        }
        System.out.println("sum = "+sum);
    }

    //格式3：
    //定义方法求两个数的和 并返回
    public static int getSum2(int a,int b){
        return a+b;
    }


}
