package com.itheima._02分支结构;
/*
    if语句
        格式3：
            if(关系表达式1){
                语句体1
            }else if(关系表达式2){
                语句体2
            }else{
                语句体3
            }
         执行流程：
            1.先判断关系表达式1的值
            2.如果为true执行 语句体1 结束
            3.如果为false 执行 关系表达式2
            4.判断关系表达式2的值是否为true
            5.如果为true执行语句体2
            6.否则执行语句体3
 */
public class Demo03格式3 {
    public static void main(String[] args) {
        int a = 9;
        if (a>10){
            System.out.println("a大于10");
        }else if (a == 10){
            System.out.println("a等于10");
        }else {
            System.out.println("a小于10");
        }
    }
}
