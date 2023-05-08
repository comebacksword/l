## day03流程控制语句

学习目标：

 * 了解流程控制语句的分类
    * 顺序结构
    * 分支结构/选择结构
    * 循环结构
 * 熟悉熟悉结构执行流程
    * 从上到下 从左到右
 * 掌握分支结构
    * if语句
       * 格式1 if(关系表达式){语句体}
       * 格式2 if(关系表达式){语句体1}else{语句体2}
       * 格式3 if(关系表达式1){语句体1} else if(关系表达式2){语句体2}else{语句体2}
    * switch语句
       * 格式 ： switch(值){ case 值： 语句体;break; .......  default 语句体n+1;}
 * 循环结构
    * 掌握for循环
       * for(初始化语句;条件判断语句;条件控制语句){循环体语句体}
    * while循环
       * 初始化语句  ; while(条件判断语句){循环体语句; 条件控制语句}
    * do-while循环
       * 初始化语句 ; do{循环体语句;条件控制语句}while(条件判断语句);
 * 死循环
    * for(;;){}   
    * while(true){}  掌握
    * do{}while(true);
 * 熟悉流程跳转控制语句
    * break
    * continue
 * 随机数
    * Random

### 1.流程控制语句

#### 1.1 顺序结构

```java
/*
    顺序结构：
        从上到下，从左到右,程序执行的基本顺序
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("开始");
        System.out.println(1+2+3+4+5+"a"+6+7+8+9);
        System.out.println("b");
        System.out.println("c");
        System.out.println("结束");
    }
}
```

#### 1.2分支结构if语句

##### 1.2.1 if语句格式1

```java
import java.util.Scanner;

/*
    if语句
        格式1:
            if(关系表达式){
                语句体;
            }
        执行流程：
            1.判断关系表达式的值
            2.如果为true执行语句体，否则执行其他代码
 */
public class Demo01格式1 {
    public static void main(String[] args) {
        //键盘录入一个数字判断是否是偶数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = scanner.nextInt();
        System.out.println("开始");
        //判断是否是偶数
        if (num%2==0){
            System.out.println(num+"是偶数");
        }
        System.out.println("结束");
    }
}
```

##### 1.2.2 if语句格式2

```java
/*
    if语句：
        格式2：
            if(关系表达式){
                语句体1;
            }else{
                语句体2;
            }
        执行流程：
            判断关系表达式的值是否为true，如果为true执行语句体1，否则执行语句体2

 */
public class Demo02格式2 {
    public static void main(String[] args) {
        //键盘录入一个数字判断是奇数还是偶数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入一个数字：");
        int num = scanner.nextInt();
        //判断奇偶数
        if (num%2==0){
            System.out.println(num+"是偶数");
        }else {
            System.out.println(num+"是奇数");
        }
    }
}
```

##### 1.2.3if语句格式3

```java
/*
    if语句
        格式3：
            if(关系表达式1){
                语句体1
            }else if(关系表达式2){
                语句体2
            }else{
                语句体3
            }
         执行流程：
            1.先判断关系表达式1的值
            2.如果为true执行 语句体1 结束
            3.如果为false 执行 关系表达式2
            4.判断关系表达式2的值是否为true
            5.如果为true执行语句体2
            6.否则执行语句体3
 */
public class Demo03格式3 {
    public static void main(String[] args) {
        int a = 9;
        if (a>10){
            System.out.println("a大于10");
        }else if (a == 10){
            System.out.println("a等于10");
        }else {
            System.out.println("a小于10");
        }
    }
}

```

#### 1.3分支语句switch语句

##### 1.3.1 switch格式

```java
import java.util.Scanner;

/*
    switch语句
        格式:
            switch(值){
                case 值: 语句体1;break;
                case 值: 语句体2;break;
                case 值: 语句体3;break;
                case 值: 语句体4;break;
                ... ...
                default:语句体n+1;break;
            }
         执行流程：
            获取switch后面值和case语句后面的值进行匹配，匹配上就执行语句体，如果都不匹配执行default语句
 */
public class Demo04switch {
    public static void main(String[] args) {
        //减肥计划 键盘录入星期数，查看减肥计划 周一 跑步 周二 游泳 周三 动感单车 周四 爬山 周五 跳绳 周六 SPA 周日 吃顿好的
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查看的星期数：");
        int week = sc.nextInt();
        //使用switch语句查看减肥计划
        switch (week){
            case 1:System.out.println("周一 跑步");break;
            case 2:System.out.println("周二 游泳");break;
            case 3:System.out.println("周三 动感单车");break;
            case 4:System.out.println("周四 爬山");break;
            case 5:System.out.println("周五 跳绳");break;
            case 6:System.out.println("周六 SPA");break;
            case 7:System.out.println("周日 吃顿好的");break;
            default:
                System.out.println("您输入的星期数不存在！");
        }
    }
}
```

##### 1.3.2 switch语句练习

```java
/*
    键盘录入一个是月份，输出对应的季节

    分析：
        1.键盘录入
            导包
            创建对象
            接收数据
        2.获取接收的数据
            使用switch语句匹配，输出对应季节
        3.case语句具有穿透性，遇到break才停止
 */
public class Demo05switch练习 {
    public static void main(String[] args) {
        //创建对象
        Scanner scanner = new Scanner(System.in);
        //接收数据
        System.out.println("请输入一个月份：");
        int month = scanner.nextInt();
        //使用switch语句匹配，输出对应季节
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("冬季");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("春季");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("夏季");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("秋季");
                break;
            default:
                System.out.println("您给的月份有误！");
                break;

        }

    }
}
```

##### 1.3.3 switch特点

```java
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
```

#### 1.4循环结构for循环

##### 1.4.1 for循环

```java
/*
    循环结构：
        有明确的的开始和结束标志，循环往复执行一段代码
       分类：
        1.for循环
        2.while循环
        3.do-while循环
     for循环格式：
        for(初始化语句;条件判断语句;条件控制语句){
            循环体语句;
        }
        执行流程：
            1.初始化语句
            2.执行条件判断语句 ==> true 执行循环体语句 ==> 条件控制语句 ==>  2.执行条件判断语句
                            ==> false 结束for循环
 */
public class Demo01For循环 {
    public static void main(String[] args) {
        //打印1--5
        for (int i=1;i<=5;i++){
            System.out.println(i);
        }
        System.out.println("---------------");
        //打印5--1
        for (int i=5;i>=1;i--){
            System.out.println(i);
        }
    }
}
```

##### 1.4.2 For循环求和 

```java
public class Demo02For循环求和 {
    public static void main(String[] args) {
        //求1--100之间所有数字和
        int sum = 0;
        //遍历1--100之间所有的数字
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("sum = "+sum);
    }
}
```

##### 1.4.3 For循环求奇数和

```java
//求1--100之间所有奇数和
public class Demo03For循环求奇数和 {
    public static void main(String[] args) {
        int sum = 0;
        //循环遍历获取1--100之间所有数据和，数据必须是奇数
        /*for (int i = 1; i <= 100; i++) {
            //判断是否是奇数，如果是累加求和
            if (i%2!=0){
                sum+=i;//sum = sum+i;
            }
        }*/
        for (int i = 1; i < 100; i+=2) {
            sum+=i;
        }
        System.out.println("1--100之间所有奇数和："+sum);
    }
}
```

##### 1.4.4For循环求偶数和

```java
//求1--100之间所有偶数和
public class Demo04For循环求偶数和 {
    public static void main(String[] args) {
        //定义求和变量
        int sum = 0;
        //遍历1--100之间所有数字，筛选出偶数，累加
        /*for (int i = 1; i <= 100; i++) {
            if (i%2==0) //if语句后面如果只有一行代码，大括号可以省略不写
                sum+=i;
        }*/
        for (int i = 0; i <= 100; i+=2) {
            sum+=i;
        }
        System.out.println("1--100之间所有偶数和："+sum);
    }
}
```

##### 1.4.5For循环统计

```java
/*
    统计1--100之间能被2整数的数字的个数，能被3整除的数字的个数
 */
public class Demo05For循环统计 {
    public static void main(String[] args) {
        //定义两个统计变量
        int count1 = 0; //统计能被3整除个数
        int count2 = 0; //统计能被2整除个数
        //使用for循环遍历1--100之间数字
        for (int i = 1; i <= 100; i++) {
            //筛选数字
            if (i % 3 == 0)
                count1++;

            if (i % 2 == 0)
                count2++;

        }
        System.out.println("count1 = " + count1);
        System.out.println("count2 = " + count2);

    }
}
```

##### 1.4.6 统计水仙花数

```java
/*
    统计水仙花数个数，并打印，两个一行
    分析：
        水仙花数：是3位数 100-999 ；各个位上数字的立方和等于数字本身
        使用循环遍历100--999之间所有数字
        求每一个数字各个位上数字，然后求立方和
        判断立方和 和 数字本身是否相等
        如果相等就是水仙花数
     步骤：
        1.使用for循环获取每一个三位数
        2.求三位数各个位上的数字
        3.求各个位上数字的立方和
        4.判断立方和是否和数字本身相等
 */
public class Demo06统计水仙花数 {
    public static void main(String[] args) {
        //定义统计变量
        int count = 0;
        //1.使用for循环获取每一个三位数
        for (int i = 100; i <= 999; i++) {
            //2.求三位数各个位上的数字
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            //3.求各个位上数字的立方和
            double sum = Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3);
            //4.判断立方和是否和数字本身相等
            if (sum == i) {
                //统计水仙花数的个数
                count++;
                System.out.print(i + " ");
                if (count % 2 == 0) {
                    System.out.println();
                }

            }
        }
    }
}

```

##### 1.4.7 逢七必过

```java
/*
    1--100 逢七必过：数字只要包含7就喊过 是7的倍数 或者数字有7 就要喊过

    continue:关键字的意思是跳过本次继续下一次
 */
public class Demo07逢七必过 {
    public static void main(String[] args) {
        /*for (int i = 0; i < 10; i++) {
            if (i==7){
                System.out.println("过");
                continue;
            }
            System.out.println(i); // 0 1 3 4
        }*/
        int count =0 ;
        //遍历1--100之间的数字
        for (int i = 1; i < 100; i++) {
            //判断 是否包含7 ：是7的倍数 或者个位上是7 或者十位是7
            if (i%7==0 || i%10 == 7 || i/10%10 == 7){

                System.out.println("过");

                continue;
            }
            System.out.println(i);

        }
    }
}

```

##### 1.4.8打印星号

```java
/*
    @@@@@
    @@@@@
    @@@@@
    @@@@@

 */
public class Demo08打印星号 {
    public static void main(String[] args) {
        for (int j = 0; j < 4; j++) { //外层循环控制行数
            for (int i = 0; i < 5; i++) { //内层循环控制列数
                System.out.print("@");
            }
            System.out.println();
        }
    }
}
```

##### 1.4.9 九九乘法表

```java
public class Demo09九九乘法表 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+i*j +"\t");
            }
            System.out.println();
        }
    }
}
```

#### 1.5while循环

##### 1.5.1 while循环

```java
/*
    while循环
        格式：
            初始化语句
            while(条件判断语句){
                循环体语句;
                条件控制语句
            }
         执行流程：
            1.初始化语句
            2.条件判断语句 ==》true 循环体语句 ==》条件控制语句 ==》 2.条件判断语句
                        ==》false 结束循环
 */
public class Demo10while循环 {
    public static void main(String[] args) {
        //打印1--5
        for (int i=1;i<=5;i++){
            System.out.println(i);
        }
        System.out.println("---------------");
        int i= 1;
        while (i<=5){
            System.out.println(i);
            i++;
        }
        System.out.println("---------------");
        //打印5--1
        /*for (int i=5;i>=1;i--){
            System.out.println(i);
        }*/
        int j = 5;
        while (j>=1){
            System.out.println(j);
            j--;
        }

    }
}

```

##### 1.5.2 珠穆朗玛峰

```java
/*
    需求：世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米)，假如我有一张足够大的纸，它的厚度是0.1毫米。
请问，我折叠多少次，可以折成珠穆朗玛峰的高度?

步骤：
    1.先定义纸张厚度
    2.定义珠峰高度
    3.运算：
        只要纸张的厚度小于珠峰高度，就继续折叠
        纸张每次折叠都要是上一次2倍
        每折叠一次，就要记录一次
 */
public class Demo11珠穆朗玛峰 {
    public static void main(String[] args) {
        //1.先定义纸张厚度
        double paper = 0.1;
        //2.定义珠峰高度
        double zf = 8844430;
        //3.定义计数器
        int count = 0;
        //4.统计折叠次数
        while (paper<zf){
            paper *= 2;
            count++;
        }
        System.out.println("折叠："+count+"次");
    }
}

```

#### 1.6 do-while循环

##### 1.6.1 do-while循环

```java
/*
    do-while循环
        格式：
            初始化语句
            do{
                循环体语句;
                条件控制语句
            }while(条件判断语句);
        执行流程：
            1.初始化语句
            2.循环体语句
            3.条件控制语句
            4.条件判断语句 ==> true 循环体语句 ==> 条件控制语句 ==> 4.条件判断语句;
                        ==> false 结束循环
 */
public class Demo12DoWhile {
    public static void main(String[] args) {
        //打印1--5
        for (int i=1;i<=5;i++){
            System.out.println(i);
        }
        System.out.println("---------------");
        int i= 1;
        while (i<=5){
            System.out.println(i);
            i++;
        }
        System.out.println("---------------");
        int j = 1;
        do {
            System.out.println(j);
            j++;
        }while (j<=5);
    }
}

```

#### 1.7 三种循环区别

```java
/*
    1.for循环的初始化语句在循环内部，出来循环就不能使用
    2.while和do-while初始化语句在循环外面，循环结束后，可以继续使用
    3.for循环和while循环 先判断后执行 ，do-while先执行后判断
 */
public class Demo13三种循环区别 {
    public static void main(String[] args) {
        //打印1--5
        for (int i=1;i<=5;i++){
            System.out.println(i);
        }

        System.out.println("---------------");
        int i= 1;
        while (i<=5){
            System.out.println(i);
            i++;
        }
        System.out.println(i);
        System.out.println("---------------");
        int j = 1;
        do {
            System.out.println(j);
            j++;
        }while (j<=5);
    }
}

```

#### 1.8 死循环

```java
/*
    死循环：
        for(;;){}
        while(true){}  //推荐使用
        do{}while(true);
 */
public class Demo14死循环 {
    public static void main(String[] args) {
        /*for(;;){
            System.out.println("不要停");
        }*/
        /*while (true){
            System.out.println("停不下来了");
        }*/
        do {
            System.out.println("受不了啦......");
        }while (true);
    }
}
```

### 2.随机数

#### 2.1 随机数入门

```java
import java.util.Random;

/*
    Random类 用来生成随机数的
    步骤：
        1.导包
        import java.util.Random
        2.创建对象
        Random r = new Random();
        3.生成随机数
        int num = r.nextInt(); //生成int取值范围内的随机数
        int num = r.nextInt(bound); //生成 0--bound之间随机数 包含0不包含bound  bound必须是int类型的正数
 */
public class Demo01随机数入门 {
    public static void main(String[] args) {
        Random random = new Random();

        /*for (int i=0;i<1000;i++) {
            ////生成int取值范围内的随机数
            int num = random.nextInt();
            System.out.println(num);
        }*/

        //生成 0--bound之间随机数 包含0不包含bound
        int i = random.nextInt(10);
        System.out.println(i);
        //bound必须是int类型的正数
//        int num = random.nextInt(-10); //IllegalArgumentException  bound must be positive
//        System.out.println(num);

        //生成 20 -- 90之间随机数
        int num  = random.nextInt(71)+20;//0--89
        //生成33 -- 99之间的随机数
        int num2 = random.nextInt(67)+33;

        /*
            生成区间内的随机数: [最小值 ，最大值]
                int num = random.nextInt(最大值-最小值+1)+最小值;
         */
        //生成 -10 -- 10之间的随机数
        int num3 = random.nextInt(21)-10;
    }
}
```

#### 2.2猜数字

```java
import java.util.Random;
import java.util.Scanner;

/*
    需求：程序自动生成一个1-100之间的数字，使用程序实现猜出这个数字是多少？
    分析：
        1.随机数 Random
        2.猜数字 Scanner
        3.不知道猜多少次 死循环 while(true)
     步骤：
        1.生成随机数 1--100
        2.猜数字
            2.1 键盘录入数字
            2.2 判断如果大了 提示猜大了 如果小了 提示猜小了 如果相等 恭喜你猜对了
 */
public class Demo02猜数字 {
    public static void main(String[] args) {
        //1.生成随机数 1--100
        Random random = new Random();
        int guessNum = random.nextInt(100)+1;
        //System.out.println(guessNum);
        //2.猜数字
        //2.1 键盘录入数字
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个1--100之间的数字：");
            int num = sc.nextInt();
            if (num>guessNum){
                System.out.println("您猜大了！");
            }else if (num<guessNum){
                System.out.println("您猜小了！");
            }else if (num == guessNum){
                System.out.println("恭喜你，猜对了！晚上可以Happy了");break; //结束离break最近循环
            }
        }
    }
}

```

### 3 流程跳转控制语句

```java
/*
    流程跳转控制语句：
        continue; 跳过本次 继续下一次
        break; 在循环中 用来结束循环，但是结束当前循环或者说是离我最近循环
 */
public class Demo01 {
    public static void main(String[] args) {
        // continue; 跳过本次 继续下一次
        for (int i = 0; i < 5; i++) {
            if (i==2){
                continue;
            }
            System.out.println(i);
        }
        System.out.println("-------");
        //break; 在循环中 用来结束循环，但是结束当前循环或者说是离我最近循环
        for (int i = 0; i < 5; i++) {
            if (i==2){
                break;
            }
            System.out.println(i);
        }
        //但是结束当前循环或者说是离我最近循环
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (j == 2){
                    break;
                }
                System.out.println("i = "+i +";   j = "+j);
            }
        }
        System.out.println("-----");
        //如果嵌套循环 想结束外层循环
        wc:for (int i = 0; i < 5; i++) {
            nc: for (int j = 0; j < 5; j++) {
                if (j == 2){
                    break wc;
                }
                System.out.println("i = "+i +";   j = "+j);
            }
        }
    }
}
```





































