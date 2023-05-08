## day02 复习day01

### 1.java概述

#### 1.1java发展史

```java
1995年sun公司推出java
JDK 5 这个版本 跨度最大
JDK 8 目前最流行 稳定 免费
最新版本JDK 17
上课使用 JDK 16
2009年被Oracle收购
```

#### 1.2 java优点

```java
跨平台，做到一次编写到处运行
平台：操作系统 Windows MacOS Linux
跨平台的原理：针对不同的操作系统提供不同的JVM
```

#### 1.3JDK JRE JVM之间关系

```java
JDK > JRE > JVM
```

#### 1.4JDK的下载和安装

```java
官网下载
 安装注意事项：
  	1.不要安装在C盘或者系统盘
  	2.路径自己规划
  	3.路径中不能有中文，不能空格，不能有其他字符，只能有英文
```

#### 1.5nodepad++安装

```java
配置：
  在设置菜单栏 --> 首选项 --> 新建 --> 系统 Windows 编码 ANSI 语言JAVA
```

#### 16.idea安装和项目的创建

```java
创建项目是首先配置工作空间ideaprojects,一般和idea的安装目录平级
  
创建项目：
  	1.file --> new -->project-->empty project 创建一个空的项目
  	2.创建模块 new module 注意选择JDK 每个模块都要统一JDK版本
项目导入：
  	1.file --> open --> 在弹出框 找到要导入的项目的目录，选择项目名，点击确定
项目的删除：
  	1.从硬盘删除
模块导入：
  	1.file --> new --> module from exiting source --> 在弹出框找到要导入的项目，再找模块，选择模块名，然后点击确定
```

#### 1.7 思维导图 和markdown软件安装

```java

```

### 2.java基础知识

#### 2.1 DOS命令行

```java
切换盘符：盘符名字：
dir:查看当前目录下的所有文件和文件夹
cd:
	cd .. 退回上一级
    cd 目录 进入下一进入级目录
    cd 目录\目录\目录... 进入多级目录
cls: 清屏
exit: 退出
ipconfig /all 查看本机所有网络配置   
ping ip地址 测试网络是否连通
```

#### 2.2 JDK配置

```java
1.JAVA_HOME JDK安装路径
2.编辑path变量  在path变量中新建 %JAVA_HOME%\bin  置顶
3.使用 javac ; java ; java -version
```

#### 2.3HelloWorld编写

```java
public class HelloWorld{  
  public staitc void main(String[]args){ //主方法 或者main方法，是java程序运行入口
    System.out.println("HelloWorld"); //输出语句 输出双引号中的内容
  }
}
//public 是修饰符 如果修饰类 java文件名要和类名一模一样
//class 是一个标识，用来定义类的，class后面就是类名
```

#### 2.4bug和乱码

```java
bug：
  程序在编码或者运行中出现问题/异常
乱码：
  统一编码
  在编译时，加Java源文件的编码  javac -encoding 编码  Java源文件
```

#### 2.5HelloWorld编码常见问题

```java
1.大小写
2.括号
3.中文字符
```

#### 2.6注释

```java
  单行注释  //
  多行注释  /*  */
  文档注释  /*********/
```

#### 2.7关键字

```java
1.特殊含义
2.全部小写
3.在高级文本编辑器中高亮显示
```

#### 2.8常量

```java
定义：在程序运行中其值不可改变
分类：
  	整数常量
  	小数常量
  	字符常量
  	布尔常量
  	字符串常量
  	空常量    空常量不能直接输出
```

#### 2.9变量

##### 2.9.1数据类型

```java
基本数据类型
  	整型：
  		byte   1个字节
  		short  2个字节
  		int	   4个字节
  		long   8个字节
 	浮点型：
  		float  4个字节
  		double 8个字节
  	字符型
  		char   2个字节
  	布尔类型
  		boolean 1个字节
引用数据类型
  	数组
  	类
  	接口
```

##### 2.9.2变量的定义和使用

```java
格式：
  	数据类型 变量名 = 值;
	int a = 10；
注意事项：
    1.变量名不能重复定义
    2.区分大小写
    3.变量的作用域在他所在的大扩中
    4.变量先赋值后使用
    5.float类型的数据后面加f或F 推荐是F
    6.long类型数据后面加l或L 推荐是L
```

#### 2.10标识符和驼峰命名法

```java
标识符：
  	用来定义类名变量名方法名
组成：
  	数字，字母 下划线 $美元符号
注意事项：
  	1.不能以数字开头
  	2.不是关键字
  	3.区分大小写

  
驼峰命名法：
  	大驼峰：命名类名
  		   每一个单词的首字母都要大写
  	小驼峰：命名变量名和方法名
  		   有一个单词，首字母小写，多个单词的时候，第一个单词首字母小写，取余单词首字母大写
```

