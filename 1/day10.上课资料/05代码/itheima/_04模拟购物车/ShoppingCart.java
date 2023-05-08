package com.itheima._04模拟购物车;


import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        ArrayList<Item> shopCartList = new ArrayList<>();
        //键盘录入
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("1 添加商品");
            System.out.println("2 删除商品");
            System.out.println("3 修改购买数量");
            System.out.println("4 展示购物车");
            System.out.println("请输入你的操作：");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("添加商品");
                    addItem(shopCartList,sc);
                    break;
                case 2:
                    System.out.println("删除商品");
                    break;
                case 3:
                    System.out.println("修改购买数量");
                    break;
                case 4:
                    System.out.println("展示购物车");
                    showItemInfo(shopCartList);
                    break;
                default:
                    System.out.println("您输入有误！");

            }
        }
    }

    private static void showItemInfo(ArrayList<Item> shopCartList) {
        if (shopCartList.isEmpty()){
            System.out.println("购物车为空，请添加后查看");
            return;
        }
        System.out.println("========");
        for (int i = 0; i < shopCartList.size(); i++) {
            Item item = shopCartList.get(i);
            System.out.println(item.getId()+"\t"+item.getName()+"\t"+item.getDescription()+"\t"+item.getPrice()+"\t"+item.getCount());
        }

    }

    private static void addItem(ArrayList<Item> shopCartList,Scanner sc) {

        String id = null;
        while (true) {
            System.out.println("请输入商品的id:");
            id = sc.next();
            //判断商品的id是否存在在购物车中 如果不存
            int index = isExistingItemid(shopCartList,id);
            if (index == -1){
                break;
            }else { //利用购物车中存在的商品的索引，更新商品数量
                System.out.println("商品已在购物车中");
                Item item = shopCartList.get(index);
                int count = item.getCount();
//                int i = sc.nextInt();
                item.setCount(count+1);
                return;
                //shopCartList.get(index).setCount(shopCartList.get(index).getCount()+1);
            }
        }
        System.out.println("请输入商品的名称:");
        String name = sc.next();
        System.out.println("请输入商品的描述:");
        String description = sc.next();
        System.out.println("请输入商品的价格:");
        double price = sc.nextDouble();
        System.out.println("请输入商品的数量:");
        int count = sc.nextInt();
        Item item = new Item(id,name,description,price,count);
        shopCartList.add(item);
        System.out.println("添加成功");


    }
    //判断商品id 是否在集合中存在 如果存在返回，id对应商品对象，在集合中的索引，如果不存在返回值 -1
    private static int isExistingItemid(ArrayList<Item> shopCartList, String id) {
        for (int i = 0; i < shopCartList.size(); i++) {
            Item item = shopCartList.get(i);
            if (item.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
