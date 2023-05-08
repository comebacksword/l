## Day07 练习

### 1.珠峰

```java
/*
    世界最高山峰是珠穆朗玛峰(8848.86米=8848860毫米)，
    假如我有一张足够大的纸，它的厚度是0.1毫米。请问，折叠多少次，可以折成珠穆朗玛峰的高度。
 */
public class Demo01 {
    public static void main(String[] args) {
        //1.定义珠峰高度
        double zf = 8848860;
        //2.定义纸张厚度
        double paper = 0.1;
        //3.定义折叠的统计变量
        int count = 0;
        //4.只要纸张的厚度小于珠峰高度，就折叠
        while (paper < zf) {
            //折叠
            paper = paper * 2;
            //统计折叠的次数
            count++;
        }
        //5.输出折叠次数
        System.out.println("纸张需要折叠"+count+"次");
    }
}
```

### 2.百钱百鸡

```java
/*
    我国古代数学家张丘建在《算经》一书中提出的数学问题：
    鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，
    问鸡翁、鸡母、鸡雏各几何？
    公鸡：5文一只   20只
    母鸡：3文一只   33只
    小鸡：1文三只   只能买100只
 */
public class Demo02百钱百鸡 {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {//确定公鸡的只数
            for (int j = 0; j < 33; j++) {//确定母鸡的只数
                int z = 100-i-j;//小鸡的只数
                if (5*i+3*j+z/3==100 && z%3==0){
                    System.out.println("公鸡："+i+"只， 母鸡："+j+"值， 小鸡："+z+"只");
                }
            }
        }
    }
}

```

### 3.不死神兔

```java
/*
    第一个月有1对兔子，当兔子成长到三月个就成年，可以在生出1对小兔子，当小兔子成长到三个月也成年，也可以在生出一对兔子，
    如果兔子都不死，问第20个月一共有多少只兔子
    1 1 2 3 5 8 13
    1 1 1 1 1 1 1
        1 1 1 1 1
          1 1 1 1
            1 1 1
            1 1 1
              1 1
              1 1
              1 1
                1
                1
                1
                1
                1
 */
public class Demo03不死神兔 {
    public static void main(String[] args) {
        //定义长度为20的数组
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        System.out.println(arr[19]);
        //
        System.out.println(feiShi(20));
    }

    //递归
    public static int feiShi(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return feiShi(month - 1) + feiShi(month - 2);
        }
    }
}

```

### 4.机票

```java
/*
    机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
    按照如下规则计算机票价格：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。

    分析：
        定义一个方法可以进行键盘录入机票原价、月份和机舱类型。
        使用if判断月份是是旺季还是淡季，使用switch分支判断是头等舱还是经济舱。
        选择对应的折扣进行计算并返回计算的结果。
     1.定义方法
        1.1参数：原价机票 double,月份 int,机舱的类型 String
        1.2返回值：double 机票的最终价格
        1.3功能：
            1.使用if判断月份
            2.使用switch判断机舱类型


 */
public class Demo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票价格");
        double price = sc.nextDouble();
        System.out.println("请输入你乘坐的月份：");
        int month = sc.nextInt();
        System.out.println("请输入您乘坐的机舱类型：");
        String type = sc.next();
        double ticketPrice = getTicketPrice(price, month, type);
        System.out.println("机票的价格："+ticketPrice+"元");

    }
    public static double getTicketPrice(double price,int month,String type){
        /*switch (type){
            case "头等舱":
                if (month>=5&&month<=10){
                    price*=0.9;
                }else if (month == 11 || month == 12 || month>=1&&month<=4){
                    price*=0.85;
                }else {
                    System.out.println("您输出的机舱类型有误！");
                }
                break;
            case "经济舱":
                if (month>=5&&month<=10){
                    price*=0.7;
                }else if (month == 11 || month == 12 || month>=1&&month<=4){
                    price*=0.65;
                }else {
                    System.out.println("您输出的机舱类型有误！");
                }
                break;

            default:
                System.out.println("您输出的机舱类型有误！");
        }*/
        //旺季
        if (month>=5&&month<=10){
            switch (type){
                case "头等舱":
                    price*=0.9;break;
                case "经济舱":
                    price*=0.85;break;
                default:
                    System.out.println("您输出的机舱类型有误！");
            }

        }else if (month == 11 || month == 12 || month>=1&&month<=4){//淡季
            switch (type){
                case "头等舱":
                    price*=0.7;break;
                case "经济舱":
                    price*=0.65;break;
                default:
                    System.out.println("您输出的机舱类型有误！");
            }

        }else {
            System.out.println("您给出的月份有误！");
        }
        return price;

    }
}
```

### 5.素数

```java
/*
    找101-200之间的素数
    素数：
        这个数字只能被1和他本身整除
        2 3 5 7
    1.循环遍历 1--数组本身之间所有数字，使用数字本身除以2--数字本身减一之间数据，只要有又被整数数字就不是素数

    分析：
        1.获取101到200之间的所有整数
        2.判断101到200之间每一个数字是否是素数
            2.1 定义标识  用来标识数字是否是素数
                boolean flag = true;//默认数字是素数
            2.2使用循环判断数字是否是素数
                如果不是，flag = false
            2.3判断flag是true还是false
                如果是true数字就是素数
                如果是false数字就不是素数


 */
public class Demo05 {
    public static void main(String[] args) {
        //1.获取101到200之间的所有整数
        for (int i = 101; i <= 200; i++) {
            //2.判断101到200之间每一个数字是否是素数
            //2.1 定义标识  用来标识数字是否是素数
            boolean flag = true;//默认数字是素数
            //2.2使用循环判断数字是否是素数
            for (int j = 2; j <= i/2; j++) {
                if (i%j == 0){
                    //如果不是，flag = false
                    flag = false;
                    break;
                }
            }
            //2.3判断flag是true还是false
            if (flag){
                System.out.println(i);
            }
        }
    }
}

```

### 6.验证码

```java
import java.util.Random;

/*
    定义方法实现随机产生一个5位的验证码，每位可能是数字、大写字母、小写字母
   分析：
    1.参数：int 位数
    2.返回值：String 验证码
    3.生成验证码

 */
public class Demo06验证码 {
    public static void main(String[] args) {
        //调用方法
        String code = getCode(5);
        System.out.println(code);

    }
    public static String getCode(int num){
        //创建随机数默认空的字符串
        String str ="";
        //创建随机数对象
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            int n = r.nextInt(3);
            switch (n){
                case 0:
                    //随机获取一个大写字符
                    char c1 = (char) (r.nextInt(26)+65);
                    //和默认空字符串拼接
                    str+=c1;break;
                case 1:
                    //随机获取一个小写字符
                    char c2 = (char) (r.nextInt(26)+97);
                    //和默认空字符串拼接
                    str+=c2;break;
                case 2:
                    //随机获取一个小写字符
                    char c3 = (char) (r.nextInt(10)+48);
                    //和默认空字符串拼接
                    str+=c3;break;
            }
        }
        return str;

    }
}
```

### 7.数组元素的复制

```java
import java.util.Arrays;

/*
    把一个数组中的元素复制到另一个新数组中去。
    分析：
        1.参数：int[] arr
        2.返回值：int[] newArr
        3.功能：
            就是把老的数组的数据放到新的数组中安装老的数组的存储数据顺序
 */
public class Demo08数组元素的复制 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int newArr[] = copyArrayToNewArray(arr);
        String s = Arrays.toString(newArr);
        System.out.println(s);

        int newArr2[] = copyArrayReverse(arr);
        System.out.println(Arrays.toString(newArr2));
    }
    //复制数组元素逆序存放到新的数组中
    private static int[] copyArrayReverse(int[] arr) {
        int [] brr = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            brr[arr.length-1-i] = arr[i];
//        }
        int index = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            brr[index] = arr[i];
            index --;
        }
        return brr;
    }
    //复制数组中元素到新的数组中
    private static int[] copyArrayToNewArray(int[] arr) {
        //定义新的数组
        int[] brr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            brr[i] = arr[i];
        }
        return brr;
    }
}
```

### 8数组元素赋值区间

```java
/*
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9}; 复制一部分到新的数组中

    分析：
        1.参数
            原数组
            开始索引
            结束索引
            注意：结束的索引要大于开始索引，结束的索引要小于数组长度
        2.返回值：
            int [] brr
 */
public class Demo09数组元素赋值区间 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入开始的索引：");
        int startIndex = scanner.nextInt();
        System.out.println("请输入结束的索引：");
        int endIndex = scanner.nextInt();
        int[] brr = copyRangeToNewArray(arr,startIndex,endIndex);
        System.out.println(Arrays.toString(brr));



    }

    private static int[] copyRangeToNewArray(int[] arr, int startIndex, int endIndex) {
        if (arr == null){
            return null;
        }
        if (endIndex<=startIndex){
            throw new ArrayIndexOutOfBoundsException("结束索引小于了开始索引");
        }
        int [] brr = new int[endIndex-startIndex+1];
        int index = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            brr[index] = arr[i];
            index++;
        }
        return brr;
    }
}
```

### 9.数字加密

```java
import java.util.Arrays;
import java.util.Scanner;

/*
    某系统的数字密码，比如1983，采用加密方式进行传输，
    规则如下：先得到每位数，然后每位数都加上5,再对10求余，最后将所有数字反转，得到一串新数。

    1.键盘录入一个数字
    2.求这个数字是几位数
    3.获取每一位上的数字 ，存到数组中
    4.加密：取出数组的每个元素和5求和，然后和10取余的到最终数字，存储数组中

 */
public class Demo10数字加密 {
    public static void main(String[] args) {
        //1.键盘录入一个数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = sc.nextInt();
        //2.求这个数字是几位数
        //定义统计变量
        int count = getCount(num);
        System.out.println(num+"是"+count+"位数。");

        //3.获取每一位上的数字 ，存到数组中
        //新建数组
        int[]arr = new int[count];
        int y = 1;
        for (int i = 0; i < count; i++) {
            arr[i] = num/y%10;
            y*=10;//每循环一次都要乘以10
        }
        //打印数组中元素，查看是否逆序输出
        System.out.println(Arrays.toString(arr));

        //4.加密：取出数组的每个元素和5求和，然后和10取余的到最终数字，存储数组中
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i]+5)%10;
        }
        System.out.println("加密后：1987"+Arrays.toString(arr));

    }
    //求一个数字是几位数，返回位数
    private static int getCount(int num) {
        int count = 0;
        //定义变量接收键盘录入的数字
        int x = num;
        while (true){
            x = x/10;
            count++;
            if (x == 0){
                break;
            }
        }
        return count;
    }
}

```

### 10双色球

```java
package com.ithiema._02练习;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {
         int[] luckNumbers = createLuckNumbers();
         System.out.println(Arrays.toString(luckNumbers));
        int[] userNumbers = userInputNumbers();
        System.out.println(Arrays.toString(userNumbers));
        //判断是否中奖
        judge(luckNumbers,userNumbers);
    }

    private static void judge(int[] luckNumbers, int[] userNumbers) {
        //定义红球匹配的个数
        int countRed = 0;
//        蓝球匹配的个数
        int countBlue = 0;
        //统计红球出现次数
        for (int i = 0; i < luckNumbers.length-1; i++) {
            //获取每个幸运红球号
            int luckNum = luckNumbers[i];
            for (int j = 0; j < userNumbers.length-1; j++) {
                //获取每个用户红球号吗
                int num = userNumbers[j];
                if (luckNum == num){
                    countRed++;
                }
            }
        }
        //统计蓝球号吗是否中
        if (luckNumbers[6]==userNumbers[6]){
            countBlue++;
        }
        if (countRed == 6 && countBlue == 1){
            System.out.println("一等奖");
        }else if (countRed == 6 && countBlue == 0){
            System.out.println("二等奖");
        }else if (countRed == 5 && countBlue == 1){
            System.out.println("三等奖");
        }else if (countRed == 5 && countBlue == 0 || countRed == 4 && countBlue == 1){
            System.out.println("四等奖");
        }else if (countRed == 4 && countBlue == 0 || countRed == 3 && countBlue == 1){
            System.out.println("五等奖");
        }else if (countRed == 2 && countBlue == 1 || countRed == 1 && countBlue == 1 ||countRed == 0 && countBlue == 1){
            System.out.println("六等奖");
        }else {
            System.out.println("感谢您为中国福利事业做出贡献！");
        }
    }

    //用户输入的号码
    private static int[] userInputNumbers() {
        //定义双色球号码数组
        int[] arr = new int[7];
        //键盘录入
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("请输入第" + (i + 1) + "个红球：");
            int redBallNum = sc.nextInt();
            //判断用户录入红球号码是否在取值范围内
            if (redBallNum >= 1 && redBallNum <= 33) {
                //如果在判断红球是否可用
                boolean flag = checkNum(arr, redBallNum);
                //如果返回值为true，说明红球可用
                if (flag) {
                    //把红球存入到数组中
                    arr[i] = redBallNum;
                } else {
                    //红球不可用，从新生成
                    i--;
                }
            }else {
                //不在取值范围内，重新输入
                System.out.println("您输入有误！");
                i--;
            }
        }
        //输入篮球号码
        while (true) {
            System.out.println("请输入蓝球号：");
            int blueBallNum = sc.nextInt();
            if (blueBallNum>=1&&blueBallNum<=16){
                //蓝球号码可用
                arr[6] = blueBallNum;
                break;
            }else {
                System.out.println("您输入的有误，请重新输入！");
            }
        }
        return arr;

    }

    //生成中奖号码
    private static int[] createLuckNumbers() {
        //定义中奖号码数组
        int[] arr = new int[7];
        //创建随机数对象
        Random random = new Random();
        //蓝球号码 取值1--16，存放数组的最大索引
        arr[6] = random.nextInt(16) + 1;
        //红球号吗 取值1--33，存放到数组中，但是要求红球号码不能重复
        for (int i = 0; i < arr.length - 1; i++) {
            int redBallNum = random.nextInt(33) + 1;
            //判断红球号码是否可用
            boolean flag = checkNum(arr, redBallNum);
            //如果flag为true 代表红球可用
            if (flag) {
                arr[i] = redBallNum;
            } else {
                i--;
            }
        }

        return arr;
    }

    //判断红球是否重复
    private static boolean checkNum(int[] arr, int redBallNum) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == redBallNum) {
                return false;
            }
        }
        return true;
    }
}

```

































