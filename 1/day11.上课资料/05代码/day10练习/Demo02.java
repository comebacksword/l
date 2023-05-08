package com.itheima._05练习;

import java.util.ArrayList;
import java.util.Collections;

/*
    在测试类中创建6个对象（对象数据如下），依次将Avengers对象存入集合。
    遍历集合删除其中性别为男且姓名长度大于等于3的元素，将剩余的元素数据打印在控制台。
 */
public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Avengers> list = new ArrayList<>();
        // 在测试类中创建6个对象
       /* Avengers a1 = new Avengers(1, "钢铁侠", "男");
        Avengers a2 = new Avengers(2, "美国队长", "男");
        Avengers a3 = new Avengers(3, "黑寡妇", "女");
        Avengers a4 = new Avengers(4, "绿巨人", "男");
        Avengers a5 = new Avengers(5, "雷神", "男");
        Avengers a6 = new Avengers(6, "星云", "女");*/
        //依次将Avengers对象存入集合。
        /*list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);*/
//        Collections.addAll(list,a1,a2,a3,a4,a5,a6);
        Collections.addAll(list,new Avengers(1, "钢铁侠", "男"),
                new Avengers(2, "美国队长", "男")
                ,new Avengers(3, "黑寡妇", "女")
                ,new Avengers(4, "绿巨人", "男"),
                new Avengers(5, "雷神", "男"),
                new Avengers(6, "星云", "女"));
        //遍历集合删除其中性别为男且姓名长度大于等于3的元素，
        for (int i = 0; i < list.size(); i++) {
            Avengers avenger = list.get(i);
            if (avenger.getSex().equals("男") && avenger.getName().length()>=3){
                list.remove(i);
                i--;
            }
        }
        //将剩余的元素数据打印在控制台。
        for (int i = 0; i < list.size(); i++) {
            Avengers avenger = list.get(i);
            System.out.println(avenger.getId()+"  "+ avenger.getName()+"   "+avenger.getSex());
        }

    }
}
