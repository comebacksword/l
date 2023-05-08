package com.itheima._05作业;

/*
    2.获取一个字符在一个字符串中出现的次数，
	比如：String st = "adfdfsfksdfsdjfhsjdfhsfkdfgjdfkgljlds";
	字符‘f’在字符串st中出现的次数

	分析：
	    1.定义方法
	        参数：2个；String st ,char c
	        返回值：int

 */
public class Demo02 {
    public static void main(String[] args) {
        String st = "adfdfsfksdfsdjfhsjdfhsfkdfgjdfkgljlds";
        char c = 'f';

        int count = getCount(st, c);
        System.out.println(count);
    }

    //获取一个字符在一个字符串中出现的次数
    private static int getCount(String st, char c) {
        //定义统计变量
        int count = 0;
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch == c)
                count++;
        }

        return count;
    }
}
