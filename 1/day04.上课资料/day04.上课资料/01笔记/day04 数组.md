## day04 数组

学习目录

 * 熟悉数组定义
 * 掌握数组初始化
    * 动态初始化
    * 静态初始化
 * 掌握数组相关操作
    * 索引
    * 求数组长度
    * 遍历数组
    * 求最大值
    * 求最小值
    * 求和
    * 求平均值
    * 冒泡排序
 * 数组数组操作中出现问题
    * 索引越界异常
    * 空指针异常
 * 了解数组的内存图
    * java 内存结构
    * 单个数组的内存图
    * 多个数组指向各自堆内存的内存图
    * 多个数组指向同一个堆内存的内存图
 * ​

### 1.数组定义和定义格式

```java
数组是一个容器用来存储相同数据类型数据的容器
  
  格式：
  	数据类型 [] 数组名;  
	int [] arr;
	数据类型 数组名 [];
	int arr[]
```

### 2.数组的初始化

#### 2.1数组动态初始化

##### 2.1.1数组动态初始化的格式

```java
/*
    动态初始化格式：
        数据类型 [] 数组名 = new 数据类型[长度]; //必须是>=0正整数
        int [] arr = new int[3]; //定义一个能够存储 int类型相匹配的数据长度为3的数组
 */
public class Demo01 {
    public static void main(String[] args) {
        int [] arr = new int[3];
        System.out.println(arr); //[I@119d7047
        /*
            [I@119d7047
            [: 这个地址是数组的
            I：int类型
            @：分隔符
            119d7047：数组在内存中16进制地址
         */
    }
}
```

#### 2.2动态初始化数组的操作

##### 2.2.1动态初始化数组取值

```java
/*
    动态初始化数组取值:
        格式：数组数据类型 变量名 = 数组名[索引];
    索引：
        索引就是数中每个初始化空间的编号，索引从0开始 到数组长度减一 ，索引是连续的，每次递增一
    动态初始化数组有默认：
        byte short int long 类型的数组有默认值 0
        float double 类型的数组有默认值 0.0
        char 类型的数组有默认值 '\u0000'
        boolean 类型的数组有默认值 false
    引用数据类型数据有默认值:
        null
 */
public class Demo02动态初始化数组取值 {
    public static void main(String[] args) {
        int [] arr = new int[3];
        System.out.println(arr); //[I@119d7047
        //数组索引 就是 0 1 2
        //格式：数组数据类型 变量名 = 数组名[索引];
        int a = arr[0];
        System.out.println(a);
        int b = arr[1];
        System.out.println(b);
        int c = arr[2];
        System.out.println(c);
        System.out.println("--------");

        byte[] brr = new byte[3];
        System.out.println(brr[0]);
        System.out.println(brr[1]);
        System.out.println(brr[2]);
        System.out.println("--------");

        short[] crr = new short[3];
        System.out.println(crr[0]);
        System.out.println(crr[1]);
        System.out.println(crr[2]);
        System.out.println("--------");

        long[] drr = new long[3];
        System.out.println(drr[0]);
        System.out.println(drr[1]);
        System.out.println(drr[2]);
        System.out.println("--------");

        float[] err = new float[3];
        System.out.println(err[0]);
        System.out.println(err[1]);
        System.out.println(err[2]);
        System.out.println("--------");

        double[] frr = new double[3];
        System.out.println(frr[0]);
        System.out.println(frr[1]);
        System.out.println(frr[2]);
        System.out.println("--------");

        char[] grr = new char[3];
        System.out.println(grr[0]);
        System.out.println(grr[1]);
        System.out.println(grr[2]);
        System.out.println("--------");

        boolean[] hrr = new boolean[3];
        System.out.println(hrr[0]);
        System.out.println(hrr[1]);
        System.out.println(hrr[2]);
        System.out.println("--------");

        String[] srr = new String[3];
        System.out.println(srr[0]);
        System.out.println(srr[1]);
        System.out.println(srr[2]);
    }
}
```

##### 2.2.2数组遍历

```java
/*
    动态初始化数组的遍历:
        1.索引是连续的，每次递增一
        2.使用循环遍历获取数组的索引
        3.根据索引获取值
 */
public class Demo03动态初始化数组的遍历 {
    public static void main(String[] args) {
        //定义长度为5的数组
        int [] arr = new int[5];
        System.out.println(arr);
        /*System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);*/
        for (int i = 0; i < 5; i++) {
            //打印索引
//            System.out.println(i);
            System.out.println(arr[i]);
        }

    }
}
```

##### 2.2.3动态初始化数组的赋值

```java
/*
    动态初始化数组的赋值:
        格式：
            数组名[索引] = 值;

 */
public class Demo04动态初始化数组的赋值 {
    public static void main(String[] args) {
        int [] arr = new int[3];
        // 数组名[索引] = 值;
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        //使用for循环遍历数组 取值
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

#### 2.3数组静态初始化

##### 2.3.1数组静态初始化格式

```java
/*
    数组静态初始化格式:
        格式1：
            数据类型 [] 数组名 = new 数据类型[]{... ...}
            int [] arr = new int[]{1,2,3,4,5,6,7,8,9};
        格式2：
            数据类型 [] 数组名 = {... ...}
            int [] arr = {1,2,3,4,5,6,7,8,9};
    静态初始化数组用来存放已知值

    求数组的长度:
        格式：数组名.length

    遍历数组的通用格式：
        for (int i = 0; i < 数组名.length; i++) {
            System.out.println(数组名[i]);
        }

 */
public class Demo05数组静态初始化格式 {
    public static void main(String[] args) {
        //数据类型 [] 数组名 = new 数据类型[]{... ...}
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        //数据类型 [] 数组名 = {... ...}
        int[] brr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //遍历数组
        for (int i = 0; i < 9; i++) {
            System.out.println(brr[i]);
        }
        System.out.println("----------------------------");
        int[] crr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        //求数组的长度：格式：数组名.length
//        int length = crr.length;
//        System.out.println(length);

        for (int i = 0; i < crr.length; i++) {
            System.out.println(crr[i]);
        }

     

    }
}

```

#### 2.4数组操作

##### 2.4.1 求和

```java
/*
    需求：某部门5名员工的销售额分别是：16、26、36、6、100，请计算出他们部门的总销售额。
    分析：
        1.定义变量用来存储最终和
        2.遍历数组获取数组中的每一个元素
        3.累加求和
        4.输出最终和
 */
public class Demo01 {
    public static void main(String[] args) {
        int [] arr = {16,26,36,6,100};
        //1.定义变量用来存储最终和
        int sum = 0;
        //2.遍历数组获取数组中的每一个元素
        for (int i = 0; i < arr.length; i++) {
            //3.累加求和
            sum+= arr[i];
        }
        //4.输出最终和
        System.out.println("总销售额："+sum+"万元");

    }
}
```

##### 2.4.2 求最大值

```java
/*
    数组元素求最大值:
    int[] faceScores = {15, 9000, 10000, 20000, 9500, -5};
    分析：
        1.先定义最大值 ，最大值从数组取，默认取第一个
        2.遍历数组获取数组中的每一个元素
        3.和最大值比较，如果比最大值还要大，跟新最大值
        4.求出最大值并输出
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] faceScores = {15, 9000, 10000, 20000, 9500, -5};
        //1.先定义最大值 ，最大值从数组取，默认取第一个
        int max = faceScores[0];
        //2.遍历数组获取数组中的每一个元素
        for (int i = 0; i < faceScores.length; i++) {
            //3.和最大值比较，如果比最大值还要大，跟新最大值
            if (faceScores[i]>max){
                max = faceScores[i];
            }

        }
        //4.求出最大值并输出
        System.out.println("颜值最高的美女是："+max);


    }
}
```

##### 2.4.3 求最小值

```java
/*
`   数组元素求最小值:
        1.定义一个最小值，最小值从数组中取，默认是第一个元素
        2.遍历数组，获取中的每一个元素
        3.和最小值比较，如果比最小值还要小，就更新最小值
        4.求出最小值并输出
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 98, 78, 2, 5};
        //1.定义一个最小值，最小值从数组中取，默认是第一个元素
        int min = arr[0];
        //2.遍历数组，获取中的每一个元素
        for (int i = 0; i < arr.length; i++) {
            //3.和最小值比较，如果比最小值还要小，就更新最小值
            if (arr[i]<min){
                min = arr[i];
            }
        }
        //4.求出最小值并输出
        System.out.println("数组中元素的最小值："+min);
    }
}
```

##### 2.4.4 数组随机排序

```java
/*
    某公司开发部5名开发人员，要进行项目进展汇报演讲，现在采取随机排名后进行汇报。
请先依次录入5名员工的工号，然后展示出一组随机的排名顺序。

    22 33 35 13 88
   分析：
    1.先使用数组 存储 员工号
    int [] arr = {22,33,35,13,88}
    2.定义新的数组
    int [] brr = new int[arr.length];
    3.生成随机数 取值范围 0 -- 4
    4.使用随机数当做索引 从arr数组取出元素存放到brr 数组中【提示判断工号是否已经被存储】
 */
public class Demo04 {
    public static void main(String[] args) {
        //1.先使用数组 存储 员工号
        int[] arr = {22, 33, 35, 13, 88};
        //2.定义新的数组
        int[] brr = new int[arr.length];
        //3.生成随机数 取值范围 0 -- 4
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            //获取随机数 取出随机数对应的数组中元素
            int id = arr[random.nextInt(5)];
            //引入第三方变量 判断数字是否被使用 默认是没有被使用
            boolean falg = true;
            //判断id 是否在brr中
            for (int j = 0; j < brr.length; j++) {
                int x = brr[j];
                if (x == id) {
                    falg = false;
                    i--;
                    break;
                }
            }
            if (falg) {
                brr[i] = id;
            }
        }
        System.out.println(Arrays.toString(brr));
    }
}
```

##### 2.4.5 冒泡排序

```java
import java.util.Arrays;
/*
    1.相邻的两个数据 两两比较如果前面大于后面的就交换位置
    2.第一轮交换完成后，确定最大值
    3.数组有多长，我们就是交换多少轮
 */
public class Demo05 {
    public static void main(String[] args) {
        int [] arr = {5,4,3,2,1};

        for (int j = 0;j < arr.length; j++) {
            for (int i = 0; i < arr.length-1 -j; i++) {
                if (arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            System.out.println("第"+(j+1)+"轮交换结果："+Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));


    }
}
```

### 3.数组的内存图

#### 3.1java的内存分配

```java
/*
      java的内存结构：
        栈：方法运行时所进入的内存
        堆：new 出来的东西会在这块内存中开辟空间并产生地址
        方法区：字节码文件加载时进入的内存
        本地方法栈：和操作系统交互
        程序计数器：每个线程都拥有一个独立的程序计数器，用于记录当前线程所要执行的字节码指令，该类内存区域为“线程私有”内存
        寄存器：和cpu相关
 */
public class Demo01 {
}
```

#### 3.2单个数组的内存图

```java
/*
    单个数组指向自己的堆内存，无论如何修改数据，最后取值的时候，取得是修改后的最新值
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

    }
}
```

#### 3.3多个数组的内存图 指向各自的堆内存

```java
/*
多个数组指向各自的堆内存，无论如何修改自己的堆内存中数据，再去取值的时候，取得是修改后的最新值
 */
public class Demo03 {
    public static void main(String[] args) {
        int[] arr = new int[2];
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        arr[0] = 10;
        arr[1] = 20;
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);

        int[] brr = new int[2];
        System.out.println(brr);
        System.out.println(brr[0]);
        System.out.println(brr[1]);
        brr[0] = 11;
        brr[1] = 22;
        System.out.println(brr);
        System.out.println(brr[0]);
        System.out.println(brr[1]);

    }
}
```

#### 3.4多个数组的内存图 指向同一片的堆内存

```java
/*
    多个数组指向同一个对内存，无论谁修改堆内存中的数据，后来取值的时候取得是修改后的最新值
 */
public class Demo04 {
    public static void main(String[] args) {
        int[] arr = new int[2];
        arr[0] = 10;
        arr[1] = 20;
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);

        int[] brr = arr;
        System.out.println(brr);
        System.out.println(brr[0]);
        System.out.println(brr[1]);
        brr[0] = 11;
        brr[1] = 22;
        System.out.println(brr);
        System.out.println(brr[0]);
        System.out.println(brr[1]);
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);

    }
}
```

### 4.数组操作中常见问题

```java
public class Demo01 {
    public static void main(String[] args) {
        int [] arr = new int[3];
        //访问了不存在索引 ArrayIndexOutOfBoundsException
        //System.out.println(arr[3]);//ArrayIndexOutOfBoundsException
//        arr[5] = 20;
        arr = null;
//        arr[0] = 10; //NullPointerException

    }
}
```























