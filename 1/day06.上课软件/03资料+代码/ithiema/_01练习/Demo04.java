package com.ithiema._01练习;

import java.util.Arrays;
import java.util.Random;

/*
  定义方法实现随机产生一个5位的验证码，每位可能是数字、大写字母、小写字母
 */
public class Demo04 {
    public static void main(String[] args) {
        //定义长度为5的数组，存放验证码
        char [] yzm = new char[5];
        //定义数组长度为62
        char [] chars = new char[62];
        //定义chars的索引
        int index = 0;
        //初始化验证码数据
        for (char i = '0'; i <= '9'; i++) {
            chars[index]= i;
            index++;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            chars[index]= i;
            index++;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            chars[index]= i;
            index++;
        }
        System.out.println(Arrays.toString(chars));

        //生成5个0--61的随机数
        Random random = new Random();
        //遍历验证码数组，根据随机数取值，存放到数组中
        for (int i = 0; i < 5; i++) {
            int indexNum = random.nextInt(62);
            yzm[i] = chars[indexNum];
        }
        System.out.println("验证码："+Arrays.toString(yzm));

    }
}
