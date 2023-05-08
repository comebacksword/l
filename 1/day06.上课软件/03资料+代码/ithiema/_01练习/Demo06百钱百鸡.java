package com.ithiema._01练习;
/*
    我国古代数学家张丘建在《算经》一书中提出的数学问题：
    鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，
    问鸡翁、鸡母、鸡雏各几何？
    公鸡：5文一只   20只
    母鸡：3文一只   33只
    小鸡：1文三只   只能买100只
 */
public class Demo06百钱百鸡 {
    public static void main(String[] args) {
        //公鸡的取值范围0--20
        //母鸡的取值范围0--33
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 33; j++) {
                int z = 100-i-j;
                if (5*i+3*j+z/3 == 100 && z%3==0){
                    System.out.println("公鸡："+i+"只，母鸡："+j+"只，小鸡："+z+"只");
                }
            }
        }
    }
}
