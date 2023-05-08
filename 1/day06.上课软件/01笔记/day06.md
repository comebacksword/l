## day06

#### 1.练习1

```java
import java.util.Arrays;
import java.util.Random;

/*
    利用随机数生成范围在2--10(包含2和10)之间的随机数存入到数组中(随机数可以重复)
    分别求出数组中的最大值，最小值和总和 打印到控制台
 */
public class Demo01 {
    public static void main(String[] args) {
        //定义数组
        int [] arr = new int[5];
        //创建随机数对象
        Random random = new Random();
        //生成随机数，存入到数组中
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(9)+2;
        }
        //打印数组
        System.out.println(Arrays.toString(arr));
        int max = arr[0];
        int min = arr[0];
        int sum = 0;
        //求最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max)
                max = arr[i];
        }
        //求最小值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                min = arr[i];
            }
        }
        //求和
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        System.out.println("max = "+max);
        System.out.println("min = "+min);
        System.out.println("sum = "+sum);

    }
}

```

#### 2.练习2

```java
import java.util.Scanner;

/*
    机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
按照如下规则计算机票价格：旺季（5-10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。
分析：
    1.变量 淡季 旺季 头等舱和经济舱
    2.判断  淡季 旺季
    3.根据  淡季 旺季 和 头等舱和经济舱 进行打折
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = sc.nextInt();
        System.out.println("请输入你选择的舱位：");
        String cang = sc.next();
        //机票原价
        System.out.println("请输入机票原价：");
        double price = sc.nextDouble();
        //2.判断淡季或旺季
        //3.根据淡旺季，和 头等舱和经济舱 运算规则进行算出票价
        if (month >= 5 && month <= 10) {//旺季
            switch (cang) {
                case "头等舱":
                    price *= 0.9;
                    break;
                case "经济舱":
                    price *= 0.85;
                    break;
                default:
                    System.out.println("您输入的舱位类型有误！");
            }

        } else if (month >= 1 && month <= 4 || month == 11 || month == 12) {//淡季
            switch (cang) {
                case "头等舱":
                    price *= 0.7;
                    break;
                case "经济舱":
                    price *= 0.65;
                    break;
                default:
                    System.out.println("您输入的舱位类型有误！");
            }
        } else {
            System.out.println("您输入月份有误！");
        }

        System.out.println("您的机票价格是：" + price + "元");

    }
}

```

#### 1.3求素数

```java
/*
    判断101 -- 200之间有多少个素数，并输出

    分析：
        1.求素数
            素数：如果除了1和它本身以外，不能被其他正整数整除，就叫素数。 2 3 5 7 11 13 17 19 23 29 31
        2.统计
        3.输出素数 和个数
 */
public class Demo03 {
    public static void main(String[] args) {
        //定义统计变量
        int count = 0;
      //判断是否是素数
        for (int a = 101; a <= 200; a++) {
            //调用判断是否是素数的方法，如果是返回true
            boolean flag = isPrime(a);
            if (flag){
                System.out.println(a+"是素数");

                //统计
                count++;
            }
        }
        System.out.println("101---200之间所有素数有："+count+"个");
    }
    //判断是否是素数的方法，如果是返回true
    private static boolean isPrime(int a) {
        boolean flag = true;
        for (int i = 2; i <= a /2; i++) {
            if (a %i == 0){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
```

#### 1.4验证码

```java
import java.util.Arrays;
import java.util.Random;

/*
  定义方法实现随机产生一个5位的验证码，每位可能是数字、大写字母、小写字母
 */
public class Demo04 {
    public static void main(String[] args) {
        //定义长度为5的数组，存放验证码
        char [] yzm = new char[5];
        //定义数组长度为62
        char [] chars = new char[62];
        //定义chars的索引
        int index = 0;
        //初始化验证码数据
        for (char i = '0'; i <= '9'; i++) {
            chars[index]= i;
            index++;
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            chars[index]= i;
            index++;
        }
        for (char i = 'a'; i <= 'z'; i++) {
            chars[index]= i;
            index++;
        }
        System.out.println(Arrays.toString(chars));

        //生成5个0--61的随机数
        Random random = new Random();
        //遍历验证码数组，根据随机数取值，存放到数组中
        for (int i = 0; i < 5; i++) {
            int indexNum = random.nextInt(62);
            yzm[i] = chars[indexNum];
        }
        System.out.println("验证码："+Arrays.toString(yzm));

    }
}

```

#### 1.5数组复制

```java
/*
    把一个数组中的元素复制到另一个新数组中去
    分析：
        1.参数：int[]arr
        2.返回值：有，类型 数组
 */
public class Demo05 {
    public static void main(String[] args) {
        int [] arr = {21, 23, 47, 57, 41, 54, 23, 73, 76, 80};
        //调用 方法
        int[] array = copyArray(arr);
        System.out.println(Arrays.toString(array));
    }
    public static int[] copyArray(int[]arr){
        //1.定义新数组 长度和老的数组一样
        int [] newArr = new int[arr.length];
        //2.遍历老的数组，取出元素，存放到新数组中
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}

```

#### 1.6 百钱百鸡

```java
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

```

#### 1.7不死神兔

```java
/*
    一对兔子，从出生后第三个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，
    假如兔子都不死，问第二十个月的兔子对数为多少？
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
public class Demo07不死神兔 {
    public static void main(String[] args) {
        //定义长度为20的数组
        int [] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
       /* arr[2] = arr[0] + arr[1];
        arr[3] = arr[1] + arr[2];
        arr[4] = arr[2] + arr[3];
        arr[5] = arr[3] + arr[4];*/

        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-2]+arr[i-1];
        }
        System.out.println("第二十个月兔子有："+arr[19]+"对");

        //调用递归实现斐波那契数列
        int count = fibonacci(20);
        System.out.println(count);

    }

    //递归实现不死神兔
    public static int fibonacci(int month){
        if (month == 1 || month == 2){
            return 1;
        }else {
            return fibonacci(month - 1) + fibonacci(month - 2);
        }
    }

    //递归：方法自己调用自己，他也有明确开始和结束标志 1*2*3*4*5
    /*public static int jieCheng(int n){
        if (n==1)
            return 1;
        else
           return n*jieCheng(n-1);  // 3 *
    }*/

}

```

#### 1.8 数组复制一个区间到新的数组

```java
import java.util.Arrays;

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
public class Demo08 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //调用方法
        int[] arrayRange = copyArrayRange(arr, 3, 5);
        //打印新的数组
        System.out.println(Arrays.toString(arrayRange));

    }

    public static int[] copyArrayRange(int[] arr, int startIndex, int endIndex) {
//        结束的索引要大于开始索引
        if (endIndex < startIndex) {
            System.out.println("您给的参数错误，开始索引要小于结束索引");
            return null;
        }
        if (endIndex > arr.length - 1) {
            System.out.println("结束的索引要小于数组长度");
            return null;
        }
        //定义新的数组的长度
        //{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length = endIndex - startIndex + 1;
        //创建新的数组
        int [] newArr = new int[length];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[startIndex];
            startIndex++;
        }
     return newArr;
    }
}

```

#### 1.9评委打分

```java
import java.util.Arrays;
import java.util.Scanner;

/*
    在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。
    选手的最后得分为：去掉最高分、最低分后的4个评委的平均分，请完成上述过程并计算出选手的得分。

    1.定义长度为6 的数组 ，存放6个评委打分
    2.使用键盘录入6个成绩 填充数组
    3.求最高分 求最低分 求总分
    4.总分减去 最高分最低分 除以 4 得到歌手最终得分

 */
public class Demo09评委打分 {
    public static void main(String[] args) {
        //1.定义长度为6 的数组 ，存放6个评委打分
        int [] arr = new int[6];
        //    2.使用键盘录入6个成绩 填充数组
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+(i+1)+"个评委的打分：");
            int score = sc.nextInt();
            if (score>=0&&score<=100){
                arr[i] = sc.nextInt();
            }else {
                System.out.println("您输入的分数有误，请检查后重新输入！");
                i--;
            }

        }
        //打印数组
        System.out.println(Arrays.toString(arr));
        //    3.求最高分 求最低分 求总分
        int max = arr[0];//最高分
        int min = arr[0];//最低分
        int sum = 0;//总分
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("max = "+ max);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("min = "+min);
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        System.out.println("sum = "+sum);
        //    4.总分减去 最高分最低分 除以 4 得到歌手最终得分
        int avg = (sum-max-min)/(arr.length-2);
        System.out.println("歌手的最终得分："+avg);
    }
}

```

#### 1.10 数字加密

```java
import java.util.Arrays;
import java.util.Scanner;

/*
某系统的数字密码，比如1983，采用加密方式进行传输，
规则如下：先得到每位数，然后每位数都加上5,再对10求余，最后将所有数字反转，得到一串新数。
    1983
     1  + 5  ==> % 10  ==6
     9  + 5  ==> % 10  ==4
     8  + 5  ==> % 10  ==3
     3  + 5  ==> % 10  ==8
键盘录入一个数字 加密
    1.求键盘录入的数字是几位数
    2.求各个位上数字
    3.加密
    4.反转后输出
 */
public class Demo10数字加密 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = sc.nextInt();
        //求数字是几位数
        int count = counts(num);
        //定义数组
        int [] arr = new int[count];
        //求各个位上数字
        int y = 1;
        for (int i = 0; i < count; i++) {
            arr[i] = num/y%10;
            y*=10;
        }
        System.out.println("各个位上数字"+ Arrays.toString(arr));
        //加密
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i]+5)%10;
        }
        System.out.println("加密后的数字"+ Arrays.toString(arr));
    }
    //求数字是几位数
    private static int counts(int num) {
        //判断数字是几位数
        int count = 0;
        while (true) { //123
            if (num == 0) {
                break;
            } else {
                num /= 10; //1
                count++;
            }
        }
        return count;
    }
}

```

#### 1.11 模拟双色球

```java
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
    随机一组中奖号码的分析:
        中奖号码由6个红球和1个篮球组成(注意：6个红球要求不能重复)。
        红球 : 1--33
        篮球 : 1--16
    用户输入一组双色球号码:
        1.键盘录入
        2.判断红球是否重复 1--33之间
        3.输入蓝球 1--16之间
    中奖情况判断的分析:
        1.中奖号码
        2.用户录入号码
        3.输出中奖结果

 */
public class Demo11模拟双色球 {
    public static void main(String[] args) {
        int[] luckNumbers = createLuckNumbers();
        System.out.println(Arrays.toString(luckNumbers));
        int[] userNumbers = userInputNumbers();
        System.out.println(Arrays.toString(userNumbers));
        judge(luckNumbers, userNumbers);


    }

    private static void judge(int[] luckNumbers, int[] userNumbers) {
        //1.定义计数器 记录红球中奖次数
        int redBall = 0;
        for (int i = 0; i < luckNumbers.length - 1; i++) {
            for (int j = 0; j < userNumbers.length-1; j++) {
                if (luckNumbers[i] == userNumbers[j]){
                    redBall++;
                    break;
                }
            }
        }
        //2.求蓝球是否中奖
        int blueBall = luckNumbers[6] == userNumbers[6] ? 1:0;

        if (redBall == 6 && blueBall == 1) {
            System.out.println("抽中了一等奖恭喜获得一千万");
        } else if (redBall == 6) {
            System.out.println("抽中了二等奖恭喜获得五百万");
        } else if (redBall == 5 && blueBall == 1) {
            System.out.println("抽中了三等奖恭喜获得三千元");
        } else if (redBall == 5) {
            System.out.println("抽中了四等奖恭喜获得二百元");
        } else if (redBall == 4 && blueBall == 1) {
            System.out.println("抽中了四等奖恭喜获得二百元");
        } else if (redBall == 4) {
            System.out.println("抽中了五等奖恭喜获得十元");
        } else if (redBall == 3 && blueBall == 1) {
            System.out.println("抽中了五等奖恭喜获得十元");
        } else if (redBall == 2 && blueBall == 1) {
            System.out.println("抽中了五等奖恭喜获得十元");
        } else if (redBall == 1 && blueBall == 1) {
            System.out.println("抽中了六等奖恭喜获得五元");
        } else if (blueBall == 1) {
            System.out.println("抽中了六等奖恭喜获得十元");
        } else {
            System.out.println("哦豁一毛都没抽中");
        }

    }

    public static int[] userInputNumbers() {
        //定义数组 存放用户输入的号码
        int arr[] = new int[7];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入第" + (i + 1) + "个红球号码：");
            int redBall = sc.nextInt();
            //判断红球是否在1--33之间
            if (redBall >= 1 && redBall <= 33) {
                //判断红球是否重复
                boolean flag = isExisting(arr, redBall);
                if (flag) {
                    arr[i] = redBall;
                } else {
                    i--;
                    System.out.println("您输入号码重复，请重新输入！");
                }

            } else {
                System.out.println("您的输入有误,请重新输入！");
                i--;
            }

        }
        while (true) {
            System.out.println("请输入蓝球号码：");
            int blueBall = sc.nextInt();
            if (blueBall >= 1 && blueBall <= 16) {
                arr[6] = blueBall;
                break;
            } else {
                System.out.println("您的输入有误，请重新输入！");
            }
        }

        return arr;
    }

    //生成中奖号
    public static int[] createLuckNumbers() {
        //定义长度为7的数组 中奖号码由6个红球和1个篮球
        int[] arr = new int[7];
        //使用随机数生成蓝球
        Random random = new Random();
        int blueBall = random.nextInt(16) + 1;
        arr[6] = blueBall;
        //生成红球
        for (int i = 0; i < arr.length - 1; i++) {
            int redBall = random.nextInt(33) + 1;
            //判断红球号码是否在数组中存在
            boolean flag = isExisting(arr, redBall);
            if (flag) {
                arr[i] = redBall;
            } else {
                i--;
            }
        }

        return arr;

    }

    //判断红球号码是否在数组中存在
    public static boolean isExisting(int[] arr, int redBall) {
        //默认红球号码可用

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == redBall) {
                return false;
            }
        }
        return true;

    }
}

```

#### 2.debug

```java
/*
    debug:就是代码的调试工具，用来查看代码在运行过程数据的变化

    debug：
        断点 : 在你查看代码块的行数旁边打
        如何运行 : run debug
        消除断点 : 在断点处在 点击一下
 */
public class Demo01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        sum(a,b);


    }

    public static void sum(int a, int b) {
        int c = a+b;
        System.out.println(c);
    }
}

```

