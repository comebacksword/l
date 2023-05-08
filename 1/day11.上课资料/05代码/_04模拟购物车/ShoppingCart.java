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
                    deleteItem(shopCartList,sc);
                    break;
                case 3:
                    System.out.println("修改购买数量");
                    updateItemCount(shopCartList,sc);
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

    private static void updateItemCount(ArrayList<Item> shopCartList, Scanner sc) {
        //判断购物车是否为空
        if (shopCartList.isEmpty()){
            System.out.println("购物车空空如也，先添加在修改！");
            return;
        }
        System.out.println("请输入你要修改的商品的id：");
        String deleteItemId = sc.next();
        int index = isExistingItemid(shopCartList, deleteItemId);
        if (index!=-1){
            int newCount = 0;
            while (true) {
                System.out.println("请输入你要修改的商品的数量：");
                newCount = sc.nextInt();
                if (newCount>0){
                    break;
                }else {
                    System.out.println("商品的数量必须大于0;");
                }
            }
            Item item = shopCartList.get(index);
            item.setCount(newCount);
            System.out.println("修改成功");
            return;
        }else {
            System.out.println("请输入你要修改的商品的id不存在！");
        }
    }

    // 删除商品
    private static void deleteItem(ArrayList<Item> shopCartList,Scanner scanner) {
        //判断购物车是否为空
        if (shopCartList.isEmpty()){
            System.out.println("购物车空空如也，先添加在删除！");
            return;
        }
        //删除
        //提示你要删除的商品的id
        System.out.println("请输入你要删除的商品的id：");
        String deleteItemId = scanner.next();
        int index = isExistingItemid(shopCartList, deleteItemId);
        if (index!=-1){
            shopCartList.remove(index);
            System.out.println("删除成功");
            return;
        }else {
            System.out.println("你要删除的商品不存在！");
        }


    }

    private static void showItemInfo(ArrayList<Item> shopCartList) {
        if (shopCartList.isEmpty()){
            System.out.println("购物车为空，请添加后查看");
            return;
        }
        System.out.println("========");
        System.out.println("商品编号\t商品名字\t商品价格\t商品数量\t商品描述\t\t");
        for (int i = 0; i < shopCartList.size(); i++) {
            Item item = shopCartList.get(i);
            System.out.println(item.getId()+"\t\t"+item.getName()+"\t\t"+item.getPrice()+"\t"+item.getCount()+"\t\t"+item.getDescription()+"\t");
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
