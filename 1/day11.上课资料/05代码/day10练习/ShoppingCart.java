package com.itheima._05练习;

import com.itheima._04模拟购物车.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        ArrayList<Item> shoppingCartList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===========购物车============");
            System.out.println("1. 添加商品到购物车");
            System.out.println("2. 删除购物车商品");
            System.out.println("3. 修改商品数量");
            System.out.println("4. 查询购物车");
            System.out.println("请输入你的选择：");
            int num = sc.nextInt();
            switch (num) {
                case 1:
//                    System.out.println("1. 添加商品到购物车");
                    addItem(shoppingCartList, sc);
                    break;
                case 2:
//                    System.out.println("2. 删除购物车商品");
                    deleteItemByItmeId(shoppingCartList,sc);
                    break;
                case 3:
//                    System.out.println("3. 修改商品数量");
                    updateItemCountByItemId(shoppingCartList,sc);
                    break;
                case 4:
//                    System.out.println("4. 查询购物车");
                    showItem(shoppingCartList);
                    break;
                default:
                    System.out.println("您的输入有误！");
            }
        }
    }
    //修改商品
    private static void updateItemCountByItemId(ArrayList<Item> shoppingCartList, Scanner sc) {
        if (shoppingCartList.isEmpty()){
            System.out.println("购物车空空如也！");
            return;
        }
        System.out.println("请输入你要修改的商品的编号：");
        String updateId = sc.next();
        int index = isExsitingId(shoppingCartList, updateId);
        if (index == -1){
            System.out.println("您输入的商品的编号在购物车中不存在，请确认后，重新选择操作");
            return;
        }else {
            while (true) {
                System.out.println("请输入你要修改商品的购买数量：");
                int newCount = sc.nextInt();
                if (newCount>0){
                    Item item = shoppingCartList.get(index);
                    item.setCount(newCount);
                    System.out.println("修改成功！");
                    //调用查询方法
                    showItem(shoppingCartList);
                    return;
                }else {
                    System.out.println("商品购买的数量必须大于0！");
                }
            }
        }

    }

    //删除商品
    private static void deleteItemByItmeId(ArrayList<Item> shoppingCartList,Scanner sc) {
        if (shoppingCartList.isEmpty()){
            System.out.println("购物车空空如也！");
            return;
        }
        System.out.println("请输入你要删除的商品的编号：");
        String deleteId = sc.next();
        int index = isExsitingId(shoppingCartList, deleteId);
        if (index == -1){
            System.out.println("您输入的商品的编号在购物车中不存在，请确认后，重新选择操作");
            return;
        }else {
            shoppingCartList.remove(index);
            System.out.println("删除成功！");
        }


    }

    //查询商品
    private static void showItem(ArrayList<Item> shoppingCartList) {
        if (shoppingCartList.isEmpty()){
            System.out.println("购物车空空如也！");
            return;
        }
        System.out.println("商品编号\t商品名字\t商品价格\t购买数量\t商品描述");
        for (int i = 0; i < shoppingCartList.size(); i++) {
            Item item = shoppingCartList.get(i);
            System.out.println(item.getId()+"\t\t"+item.getName()+"\t\t"+item.getPrice()+"\t\t"+item.getCount()+"\t\t"+item.getDescription());
        }
    }

    private static void addItem(ArrayList<Item> shoppingCartList, Scanner sc) {
        //public Item(String id, String name, String description, double price, int count)
        String id = null;
        while (true) {
            System.out.println("请输入商品的编号：");
            id = sc.next();
           int index =  isExsitingId(shoppingCartList,id);
           if (index == -1){
               break;
           }else {
               System.out.println("您输入的商品编号已存在！");
           }

        }
        System.out.println("请输入商品的名字：");
        String name = sc.next();
        System.out.println("请输入商品的描述：");
        String description = sc.next();
        System.out.println("请输入商品的价格：");
        double price = sc.nextDouble();
        System.out.println("请输入商品的购买数量：");
        int count = sc.nextInt();
        Item item = new Item(id,name,description,price,count);
        shoppingCartList.add(item);
        System.out.println("添加成功！");

    }
//    判断商品的id是否在集合中存在，如果存在返回商品id对应的集合中所有，若果不存在返回-1
    private static int isExsitingId(ArrayList<Item> shoppingCartList, String id) {
        for (int i = 0; i < shoppingCartList.size(); i++) {
            Item item = shoppingCartList.get(i);
            if (item.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
