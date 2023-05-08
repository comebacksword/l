package com.itheima._03循环结构;
/*
    死循环：
        for(;;){}
        while(true){}  //推荐使用
        do{}while(true);
 */
public class Demo14死循环 {
    public static void main(String[] args) {
        /*for(;;){
            System.out.println("不要停");
        }*/
        /*while (true){
            System.out.println("停不下来了");
        }*/
        do {
            System.out.println("受不了啦......");
        }while (true);
    }
}
