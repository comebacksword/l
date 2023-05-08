package com.itheima._05练习;

import java.util.ArrayList;
import java.util.Collections;

/*
    定义测试类Test，完成以下要求：
	①定义public static ArrayList<Phone> filter(ArrayList<Phone> list,double price) {...}方法:
	要求：遍历list集合，将list中价格大于参数price的元素存入到另一个ArrayList 中并返回

 	②在main方法内完成以下要求: a.根据以下内容创建并初始化3个Phone对象
  {"小米MIX2",2999,"新机皇"}
 {"HUAWEI", 5888,"火爆新机"}
{"VIVO X9s",1998,"火爆新机"}
b.创建一个ArrayList list_phone，将上面的3个Phone对象添加到list_phone中，调用 filter方法传入list_phone和2000，根据返回的list集合输出所有元素信息

 */
public class Demo04TestPhone {
    public static ArrayList<Phone> filter(ArrayList<Phone> list, double price) {
        //1.创建新的集合
        ArrayList<Phone> newPhoneList = new ArrayList<>();
        //2.遍历list集合，将list中价格大于参数price的元素
        for (int i = 0; i < list.size(); i++) {
            Phone phone = list.get(i);
            if (phone.getPrice() > price) {
                //存入到另一个ArrayList
                newPhoneList.add(phone);
            }
        }
        return newPhoneList;

    }

    public static void main(String[] args) {
        //a.根据以下内容创建并初始化3个Phone对象
        ArrayList<Phone> list_phone = new ArrayList<>();
        Collections.addAll(list_phone, new Phone("小米MIX2", 2999, "新机皇"),
                new Phone("HUAWEI", 5888, "火爆新机"),
                new Phone("VIVO X9s", 1998, "火爆新机"));
        //调用 filter方法传入list_phone和2000
        ArrayList<Phone> list = filter(list_phone, 2000);
        for (int i = 0; i < list.size(); i++) {
            Phone phone = list.get(i);
            System.out.println(phone.getName()+"  "+phone.getPrice()+"  "+phone.getType());
        }
    }

}
