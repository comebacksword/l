package com.itheima._01面向对象入门;

public class 测试洗衣机类 {
    public static void main(String[] args) {
        洗衣机 隔壁老王家 = new 洗衣机();
        //属性的使用
        隔壁老王家.品牌 = "海尔兄弟";
        隔壁老王家.价格 = 888.0;

        String x = 隔壁老王家.品牌;
        double y = 隔壁老王家.价格;
        System.out.println(x);
        System.out.println(y);
        System.out.println(隔壁老王家.品牌);
        System.out.println(隔壁老王家.价格);
        //行为的使用
        隔壁老王家.洗衣服();
    }
}
