## day07

学习目标：

 * 掌握debug的使用   
 * 了解进制
    * 了解进制划分
    * 了解进制的转换
    * 了解原码反码补码
    * 了解位运算
 * 了解二维数组定义使用
    * 二维数组的定义和初始化
    * 二维数组的遍历
    * 了解二维数组常见操作
       * 求和
       * 求最值

### 1.Debug使用

#### 1.1debug概述

```java
debug：代码调试工具，
```

#### 1.2debug使用

```java
1.断点：
	就是你想查看执行过程代码，走到哪里停下，后续步骤需要手动操作
  	是供程序员使用的程序调试工具，它可以用于查看程序的执行流程，也可以用于追踪程序执行过程来调试程序。
2.如果打断点：
	在需要查看的地方的左侧行号的后面，点击鼠标左键
3.如何使用断点：
import java.util.Arrays;
/*
    Debug工具中：
        step into F7:
            下一步，如果方法点调用，直接进入到被调用的方法中（自己写的方法）；不进入被调用的java源码中方法，
        step over F8:
            下一步,只在本方法中运行下一步，如果被调用的方法中有断点，进入被调用的方法中
        Force step into Alt+Shift+F7 :
            下一步，只要有方法的调用就进入到被调用的方法中
        step out Shift + F8: 从被调用的方法中出来

        resume program F9:
            到下一个断点，如果后面没有断点，直接执行到程序结束
        stop Ctrl+F2 :
            结束程序运行
        view breakpoints:
            查看并管理断点
        mute breakpoints:
            屏蔽所有断点;
 */
public class Demo01 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        sum(a,b);
    }

    private static void sum(int a, int b) {
        int [] arr = new int[7];
        String s = Arrays.toString(arr);
        System.out.println(s);
        int c = a+b;
        System.out.println(c);
    }
}	
```

#### 1.3 使用debug查看判断偶数的执行流程

```java
/*
    输出1 -- 10 之间偶数，使用debug查看成执行的每一步
 */
public class Demo02 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            //判断是否是偶数
            if (i % 2 == 0) {
                System.out.println(i + "偶数");
            }
        }
    }
}
```

#### 1.4 基本数据类型方法调用中执行流程

```java
public class Demo03 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        sum(a,b);
        System.out.println(a);//10 ?? 30
        System.out.println(b);//20 ?? 50
    }

    private static void sum(int a, int b) {
        System.out.println(a); //10
        System.out.println(b); //20
         a = a+b;//30
         b = a+b;//50
        System.out.println(a);//30
        System.out.println(b);//50
    }
}
```

#### 1.5 基本数据类型方法调用中执行流程 

```java
public class Demo04 {
    public static void main(String[] args) {
        int [] arr = new int[3];
        changeNum(arr);
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }

    private static void changeNum(int[] arr) {
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

### 2.进制

#### 2.1进制的概述和分类

```java
进制：指进位制，是人们规定的一种进位方式
表示某一位置上的数，运算时是逢X进一位。
十进制是逢十进一，二进制就是逢二进一，八进制是逢八进一
  
常见进制：二进制，八进制，十进制，十六进制

```

#### 2.2为什么要学习进制？

```java
原因：计算机数据在底层运算的时候，都是以二进制形式
也有数据是以八进制、十进制、或者十六进制进行存储或运算，了解不同的进制，便于我们对数据的运算过程理解的更加深刻。
```

#### 2.3进制的运算规则

```java
十进制：
  	运算规则：逢十进一，借一当十。
二进制：
  	介绍：二进制数据是用0和1两个数码来表示。例如：0101000
	进位规则是“逢二进一”，借位规则是“借一当二”。
八进制：
  	八进制介绍：采用0，1，2，3，4，5，6，7八个数字，逢八进1
十六进制：
  	十六进制介绍：用数字0到9和字母A到F（或a~f）表示，其中:A~F表示10~15，这些称作十六进制。
	【0】【1】【2】【3】【4】【5】【6】【7】【8】【9】【a】【b】【c】【d】【e】【f】


```

#### 2.4不同进制的书写格式

```java
十进制：Java中，数值默认都是10进制，不需要加任何修饰。
二进制：数值前面以0b开头，b大小写都可以。
八进制：数值前面以0开头。
十六进制：数值前面以0x开头，x大小写都可以。
  
注意：以上内容是jdk7版本之后才被支持。

```

```java
public class Demo01 {
    public static void main(String[] args) {
        System.out.println(1010);
        System.out.println(0B1010);
        System.out.println(01010);
        System.out.println(0X1010);

    }
}
```



#### 2.5进制转换

```java
总结：	
  	1.任意进制到十进制的转换
      	公式：系数 * 基数的权次幂 相加
      	系数：每一【位】上的数
      	基数：几进制，就是几
      	权：从数值的右侧，以0开始，逐个+1增加
    2.十进制到任意进制的转换
	  	公式：除基取余
		使用源数据，不断的除以基数（几进制，基数就是几）得到余数，直到商为0，再将余数倒着拼起来即可。
```

#### 2.6快速进制转换法

##### 2.6.1 8421码：

```java
8421码又称BCD码，是BCD代码中最常用的一种
BCD： (Binary-Coded Decimal‎) 二进制码十进制数
在这种编码方式中，每一位二进制值的1都是代表一个固定数值，把每一位的1代表的十进制数加起来得到的结果就是它所代表的十进制数。
```

##### 2.6.2 二进制快速转八进制

```java
八进制：将三个二进制位看为一组，再进行转换
原因：八进制逢八进一，三个二进制位最多可以表示111，也就是数值7，如果出现第四位，就超范围了
```

##### 2.6.3 二进制快速转十六进制

```java
十六进制：将四个二进制位看为一组，再进行转换
原因：十六进制逢十六进一，四个二进制位最多可以表示1111，也就是数值15，如果出现第五位，就超范围了
```

### 3.原码反码补码

#### 3.1 原码反码补码概述

```java
原码（可直观看出数据大小）
    就是二进制定点表示法，即最高位为符号位，【0】表示正，【1】表示负，其余位表示数值的大小。
    通过一个字节表示+7和-7，代码：byte b1 = 7;   byte b2 = -7;
    一个字节等于8个比特位，也就是8个二进制位
        0(符号位)	0000111
        1(符号位)	0000111
反码
	正数的反码与其原码相同；负数的反码是对其原码逐位取反，但符号位除外。
补码（数据以该状态进行运算）
	正数的补码与其原码相同；负数的补码是在其反码的末位加1。
      
注意：计算机中的数据，都是以二进制补码的形式在运算，而补码则是通过反码和原码推算出来的。

```

#### 3.2 位运算符

##### 3.2.1 位运算符介绍

```jaav
位运算符指的是二进制位的运算，先将十进制数转成二进制后再进行运算。
在二进制位运算中，1表示true，0表示false。
```

| 符号   | 计算方式                                     |
| ---- | ---------------------------------------- |
| &    | 遇到0（false）则0（false），两边同时为1（true），结果才是1（true） |
| \|   | 遇到1（true）则1（true），两边都是0（false），结果才是0（false） |
| ^    | 相同为false，不同为true                         |
| ~    | 取反，二进制位全部取反，0变1，1变0，包括符号位                |
| <<   | 有符号左移运算，左边符号位丢弃，右边补齐0                    |
| >>   | 有符号右移运算，根据符号位，补齐左边                       |
| >>>  | 无符号右移，无论最符号位是0还是1，都补0                    |

```java
public class Demo02 {
    public static void main(String[] args) {
        System.out.println(6&2);
        System.out.println(7&2);

        System.out.println(6|2);

        System.out.println(6^2);
        System.out.println(~6);
        /*
            有符号左移：正整数左移几位，就是乘以2的几次幂
         */
        System.out.println(3<<1); //6
        System.out.println(3<<2); //12
        System.out.println(3<<3); //24
        System.out.println(3<<4); //48
        /*
            有符号左移：负整数左移几位，就是成2的几次幂
         */
        System.out.println(-3<<1);
        System.out.println(-3<<2);
        System.out.println(-3<<2);
        System.out.println(-3<<4);
        /*
            有符号左移：正整数右移几位，就是除以2的几次幂
         */
        System.out.println(48>>1);
        System.out.println(48>>2);
        System.out.println(48>>3);
        System.out.println(48>>4);
         /*
            有符号左移：负整数右移几位，就是除以2的几次幂
         */
        System.out.println(-48>>1);
        System.out.println(-48>>2);
        System.out.println(-48>>3);
        System.out.println(-48>>4);
        /*
         无符号右移
         */
        System.out.println(48>>>1);
        System.out.println(-48>>>1);

        //1变成8效率最高使用左移
        System.out.println(1<<3);
    }
```

##### 3.2.2 异或运算的特点 一个数，被另外一个数，异或两次，该数本身不变。

```java
/*
    异或运算的特点：
        一个数字被另外一个数字异或两次还是数字本身
 */
public class Demo03 {
    public static void main(String[] args) {
        System.out.println(6^5^5);
        System.out.println(5^6^5);
        System.out.println(5^5^6);

        //
    }
}
```



##### 3.2.3数据交换练习

```java
/*
需求：已知两个整数变量a = 10，b = 20，使用程序实现这两个变量的数据交换
最终输出a = 20，b = 10;
 */
public class Demo04 {
    public static void main(String[] args) {
//        method1();
        //不使用第三方变量
        int a = 10;
        int b = 20;
        a = a ^ b; // a = 10^20
        b = a ^ b; // b = 10^20^20 = 10
        a = a ^ b; // a = 10^20^10 = 20
        System.out.println(a);
        System.out.println(b);


    }

    private static void method1() {
        int a = 10;
        int b = 20;
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}

```

##### 3.2.3 数组反转

```java
import java.util.Arrays;

/*
需求：已知一个数组 arr = {19, 28, 37, 46, 50}; 用程序实现把数组中的元素值交换，
          交换后的数组 arr = {50, 46, 37, 28, 19}; 并在控制台输出交换后的数组元素。

 */
public class Demo05 {
    public static void main(String[] args) {
        int[] arr = {19, 28, 37, 46, 50};
//        reverseArray(arr);
        for (int start = 0, end = arr.length - 1; start < end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        //打印反转后的数组：
        System.out.println(Arrays.toString(arr));


    }

    private static void reverseArray(int[] arr) {
        //定义开始索引
        int start = 0;
        //定义结束索引
        int end = arr.length - 1;

        //判断开始的索引小于结束的索引 交换位置
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            //
            start++;
            end--;
        }
        //打印反转后的数组：
        System.out.println(Arrays.toString(arr));
    }
}
```

### 4.二维数组

#### 4.1二维数组概述

```java
二维数组也是一种容器，不同于一维数组，该容器存储的都是一维数组容器
```

#### 4.2 二维数组格式

```java
格式1：数据类型 [ ] [ ] 变量名;
范例：int [ ] [ ] arr;
格式2：数据类型 变量名[ ] [ ];
范例：int arr[ ] [ ];
格式3：数据类型[ ] 变量名[ ];
范例：int[ ] arr[ ];
```

#### 4.3二维数组动态初始化

```java
格式：数据类型 [ ] [ ] 变量名 = new 数据类型[ m ] [ n ];
  	m表示这个二维数组，可以存放多少个一维数组
  	n表示每一个一维数组，可以存放多少个元素
范例：int [ ] [ ] arr = new int [ 2 ][ 3 ];
	该数组可以存放2个一维数组，每个一维数组中可以存放3个int类型元素
```

#### 4.4二维数组遍历

```java
public class Demo01 {
    public static void main(String[] args) {
        int [] [] arr = new int[4][3];
        /*System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        /*System.out.println(arr[0][0]);
        System.out.println(arr[0][1]);
        System.out.println(arr[0][2]);

        System.out.println(arr[1][0]);
        System.out.println(arr[1][1]);
        System.out.println(arr[1][2]);

        System.out.println(arr[2][0]);
        System.out.println(arr[2][1]);
        System.out.println(arr[2][2]);

        System.out.println(arr[3][0]);
        System.out.println(arr[3][1]);
        System.out.println(arr[3][2]);*/
        for (int i = 0; i < arr.length; i++) {//外层循环获取每一个以为数组的地址
//            System.out.println(arr[i]);
//            int [] brr = arr[i];
//            System.out.println(brr);
            for (int j = 0; j < arr[i].length; j++) {//获取 每一个以为数组中的元素
                System.out.println(arr[i][j]);
            }
        }
    }
}
```

#### 4.5二维数组的静态初始化

```java
格式：数据类型 [ ] [ ] 变量名 = new 数据类型[ ] [ ] {  {元素1,元素2},  {元素1, 元素2} };
范例：int [ ] [ ] arr = new int [ ][ ] { {11,22} , {33,44} };
简化格式：数据类型 [ ] [ ] 变量名 = {  {元素1,元素2},  {元素1, 元素2} };
范例：int [ ] [ ] arr = { {11,22} , {33,44} };

```

#### 4.6二维数组常见操作

```java
/*
    某公司季度，和月份统计的数据如下：单位(万元)
	第一季度：22,66,44
	第二季度：77,33,88
	第三季度：25,45,65
	第四季度：11,66,99

1.遍历数组，获取每个月销售额度
 */
public class Demo02 {
    public static void main(String[] args) {
        int[][]arr = {{22,66,44},{77,33,88},{25,45,65},{11,66,99}};
        //1.遍历数组，获取每个月销售额度
        //获取每一个以为数组
        /*for (int i = 0; i < arr.length; i++) {
            //获取每一个一维数组中的元素
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }*/
        //2.求年度销售总和
        //定义变量
        int sum = 0;
        //遍历二维数组获取每一个一维数组
        for (int i = 0; i < arr.length; i++) {
            //获取每一个一维数组中的元素
            for (int j = 0; j < arr[i].length; j++) {
                //累加求和
                sum+=arr[i][j];
            }
        }
        System.out.println("年销售总和："+sum+"万元");

        //求平均值
        //先求二维数组长度
        int count = 0;//统计二维数组中的元素
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                count++;
            }
        }
        double avg = sum*1.0/count;
        System.out.println(avg);
        //求最大值
        //先定义最大值
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]>max){
                    max = arr[i][j];
                }
            }
        }
        System.out.println("max = "+max);
        //求二维数组最小值
        //先定义最小值
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]<min){
                    min = arr[i][j];
                }
            }
        }
        System.out.println("min = "+min);
    }
}
```





















