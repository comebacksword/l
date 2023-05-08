## day01

学习目标：

 * 了解java发展史
 * 掌握JDK安装和使用
 * 了解Java优点
 * 熟练编写HelloWorld的编码案例
 * 知道什么是bug，会解决HelloWorld编码过程中常见bug
 * 会使用常用的CMD命令
 * 了解标识符
 * 掌握驼峰命名法
 * 掌握java基础知识
    * 注释
    * 关键字
    * 常量/字面量
    * 变量
       * 变量的定义
       * 掌握java数据类型
          * 基本数据类型
          * 引用数据类型
 * 了解计算机存储数据基本单位
    * 字节 byte
    * 位 bits
    * KB
    * MB
    * GB
    * TB
    * PB

### 1.Java概述

#### 1.1java发展史

```java
Java是美国 Sun 公司（Stanford University Network）在1995年推出的计算机编程语言，后被Oracle公司收购。
  Java 早期称为Oak(橡树)，后期改名为Java。
  Java 之父：詹姆斯·高斯林（James Gosling）。
  
```

#### 1.2java优点

```java
世界上最流行的编程语言之一，在国内使用最为广泛的编程语言。
可移植性、安全可靠、性能较好。做到一次编写，到处运行，跨平台
开发社区最完善，功能最为丰富。
```

#### 1.3跨平台

```java
平台：就是操作系统
  Windows
  MacOS
  Linux
 跨平台的原理：
  针对不同平台提供不同JVM
```

#### 1.4程序编写的三个步骤

```java
  编写代码
  编译代码
  运行代码
```

### 2.DOS命令行

| 操作             | 说明                       |
| -------------- | ------------------------ |
| 盘符名称:          | 盘符切换。E:回车，表示切换到E盘。       |
| dir            | 查看当前路径下的内容。              |
| cd 目录          | 进入单级目录。cd itheima        |
| cd ..          | 回退到上一级目录。                |
| cd 目录1\目录2\... | 进入多级目录。cd itheima\JavaSE |
| cd \           | 回退到盘符目录。                 |
| cls            | 清屏。                      |
| exit           | 退出命令提示符窗口。               |
| ipconfig /all  | 查看所有的网络配置                |
| ping IP地址      | 测试网络是否连通                 |

### 3.JDK下载和安装

#### 3.1下载

```java
从官网下载，或者团队共享的JDK
```

#### 3.2安装

```java
1.不要安装在C盘或者系统盘
2.安装目录要自己规划
3.安装目录不能有中文，不能有空格，不能有其他字符，只允许英文字符
```

#### 3.3 JDK JRE JVM 

```java
JDK > JRE > JVM
  JDK是 Java 语言的软件开发工具包，JDK是整个java开发的核心，它包含了JAVA的运行环境（JVM+Java系统类库）和JAVA工具。
  Java运行环境（Java Runtime Environment，简称JRE）JRE可以让计算机系统运行Java应用程序（Java Application）。
  JVM是Java Virtual Machine（Java虚拟机）的缩写，JVM是一种用于计算设备的规范，它是一个虚构出来的计算机，是通过在实际的计算机上仿真模拟各种计算机功能来实现的。
```

### 4.环境变量的配置

```java
新建：
  JAVA_HOME 值JDK安装路径D:\develop\Java\jdk-16.0.1
编辑path变量
    在path变量中添加%JAVA_HOME%\bin
```

### 5HelloWorld

#### 5.1HelloWorld编写

```java
public class HelloWorld{
	public static void main(String[] args){ // main方法或者叫主方法，java中所有程序执行的入口
		System.out.println("HelloWorld"); //输出语句 用来输出双引号中的内容的 双引号引起来的又叫字符串
	}
}
//public 是一个修饰符，使用public修饰的类，文件名要和类名一模一样
//class 是一个标识，class是用来定义类，class后面字符串，表示类名
```

#### 5.2 乱码问题 

```java
原因：编码不一样，导致乱码
  在编译时加上当前文件的编码 javac -encoding 编码  Java文件
```

#### 5.3 bug

```java
程序在编译或运行时出现的错误
```

#### 5.4HelloWorld 常见编码错误

```java
1.大小写问题
  2.中文字符
  3.乱码
  4.括号问题，java中的括号都是成对出现的，有左边就有右边
```

### 6.高级文本编辑器 nodepad++

```java

```

### 7.Java基础知识

#### 7.1注释

```java
单行注释 ： //
多行注释 : /*    */
文档注释 ：/**   */
```

#### 7.2 关键字

```java
特点：
  	1.有特殊含义
  	2.全部小写
  	3.在高级文本编辑器总高亮显示
```

#### 7.3常量

```java
含义：
  在程序运行中，其值不可以改变
```

```java
/*
	常量：
		整数常量
		小数常量
		字符串常量
		字符常量
		布尔常量
		空常量
 */
 public class Demo01{
	//这是主方法
	public static void main(String[] args){
		//这是输出语句，输出双引号中的内容
		System.out.println("HelloWorld"); //字符串常量
		System.out.println(520); //整数常量
		System.out.println(13.14); //小数常量
		System.out.println('0'); //字符常量
		System.out.println('a'); //字符常量
		System.out.println('汉'); //字符常量
		System.out.println(true); //布尔常量
		System.out.println(false); //布尔常量
		//System.out.println(null); //空常量  空常量不能直接打印
 }
}
```

#### 7.4变量

```java
定义：
  	在程序运行中，其值可以改变的量，叫变量1
```

##### 7.4.1java数据类型

```java
基本数据类型
  整型：
  	byte		1个字节		-128 -- 127     
  	short		2个字节		-32768 -- 32767
  	int			4个字节		-2147483648 -- 2147483647
  	long		8个字节
  浮点型：
  	float		4个字节
  	double		8个字节
  字符型：
  	char		2个字节		0 -- 65535
  布尔类型：
  	boolean		1个字节
  
引用数据类型
  数组
  类
  接口
```

##### 7.4.2 变量定义和使用

```java
 /*
	格式：
  	数据类型 变量名;
	int a;
	double b;
使用：
     变量名 = 值;
	a = 10;
	b = 20.0;
变量的定义和使用
  	数据类型 变量名 = 值;
	int c = 30;
	*/
 public class Demo02{
	//这是主方法
	public static void main(String[] args){
		int a;
		a = 10;
		double b;
		b = 20.0;
		
		int c = 30;
		
		System.out.println(a); 
		System.out.println(b); 
		System.out.println(c); 
		}
}
```

### 8标识符

```java
/*
标识符的作用：
  	用来定义类名 变量名 和方法名的规则
  	包含 数字 字母 下划线_ 美元符号$
注意事项：
  	1.不能以数字开头
  	2.不能java关键字
  	3.区分大小写
	
驼峰命名法：
	1.大驼峰
		所有单词的首字母都要大写
		用来命名：类名
		Student  AppleCount
	2.小驼峰
		如果有一个单词，首字母小写，如果有多个单词，第一个单词首字母小写，其余单词首字母大写
		用来命名：变量名和方法名
		name firstName lastName
		getStudentName();getOrders();
	*/
public class Demo03{
	//这是主方法
	public static void main(String[] args){
		int $3a = 10;
		int $3A = 20;
		
		System.out.println(); 
	}
}
```

### 9.变量定义的注意事项

```java
/*
	变量定义的注意事项：
		1.变量名不能重复定义
		2.变量名区分大小写
		3.变量名定义做到符合驼峰命名法，做到见名知义
		4.变量的作用域，只在他所在的大括号中有作用
		5.同一行代码可以定义多个变量名，要使用逗号隔开
		6.float类型数据在定义是后面要加f或F，推荐使用F
		7.long类型数据在定义是后面要加l或L，推荐使用L
*/
public class Demo04{
	//这是主方法
	public static void main(String[] args){
		int a = 10,b,c,d,e;
		
		double A = 20.0;
		
		int age = 18;
		
		double score = 99.99;
		long s = 1000000000000L;
		float f = 3.14F;
		
		 
		{
			//int b = 30;
			System.out.println(a);
			System.out.println(b);
			
		}
	}
}
```

### 10.常量优化机制

```java
/*
	整数默认是int类型
	Java中存在常量优化机制：
		byte b = 10;  // -128 -- 127
		short c = 20; // -32768 -- 32767
	Java中的隐式类型转换：
		long e = 40;  //小的数据类型可以直接向大的数据类型转换
*/
public class Demo05{
	//这是主方法
	public static void main(String[] args){
		byte b = 10;
		short c = 20;
		int d = 30;
		long e = 40;		
	}
}
```

### 11 idea卸载和安装

```java
见视频
```















