package com.itheima._02分支结构;
/*
    switch后面小括号中只能放 byte short int char String enum(枚举)
 */
public class Demo06Switch特点 {
    public static void main(String[] args) {
        int a = 10;
        switch (a){}
        char b = '0';
        switch (b){}
        short c = 20;
        switch (c){}
//        long d = 10L;
//        switch (d){}
        String s ="";
        switch (s){}
        WEEK week = WEEK.MONDAY;
        switch (week){}
   }
}
enum WEEK{
    MONDAY,SUNDAY
}
enum MONTH{

}