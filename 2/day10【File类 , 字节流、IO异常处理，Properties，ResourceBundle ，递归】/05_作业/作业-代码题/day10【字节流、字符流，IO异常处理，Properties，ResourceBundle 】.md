```java
作业规范【必读】

命名要求：
	1. 类名，接口名，枚举名，注解名使用大驼峰
	2. 变量名，方法名，包名均使用小驼峰
	3. 常量名全大写，多个单词下划线分割
	4. 名字要见名知意，如果不知道对应的英文，可以使用拼音代替。不可使用无意义字符
  
代码规范：
	格式要良好，使用IDEA格式化缩进（快捷键：Ctrl+Alt+L）
  
答题规范：
	1. 每道题完整代码请贴入对应题目中的代码区。
    2. 如果有运行结果的，请把代码运行结果放到文档中
```



# 【IO认识】

## 简答题

1. 请解释IO是什么意思？

   ```
   
   ```
   
2. 请说出IO流的顶级父类有哪些？

   ```
   
   ```



# 【字节流】

## 题目1

在你计算机的一个盘（比如D盘）根目录下创建一个文件，名字叫做 file01.txt。保存以下内容（要求是单字节字符，比如字母或者数字）

**file01.txt**

```java
abcdef123456
```

要求：

1. 使用字节输入流**一次读取一个字节**的方法将file01.txt的文件读取并打印
2. 使用字节输入流**一次读取多个字节**的方法将file01.txt的文件读取并打印



代码模板：

~~~java
public class InputStreamTest{
  public static void main(String[] args){
    	read1();
    	System.out.println("======");
      read2();
  }
  
  public static void read1(){
    //TODO 一次读取一个字节
  }
  public static void read2(){
    //TODO 一次读取多个字节
  }
}
~~~





---

答案：

```java

```



打印结果：

```java

```







## 题目2

在D盘中创建两个文件夹，img1,img2。在img1中放置一个图片文件，将img1中的图片文件使用字节流复制到img2中。



答案：

```java

```



# 【字符流】

素材

```java
登鹳雀楼
王之涣
白日依山尽，
黄河入海流。
欲穷千里目，
更上一层楼。
```

## 题目3

将素材，登鹤雀楼诗文使用字符输出流写到一个文本文件中。

答案：

```java

```



## 题目4

将题目1中文件的诗文使用字符输入流读取并打印到控制台。

答案：

```java

```



## 题目5

1. 请定义一个Student类，属性：姓名、性别、年龄、分数，属性类型都用String。

​	   无参、全参构造方法

​	   get/set方法

 2.  定义测试类，编写main()方法：定义一个集合

     ```java
     List<Student> stuList = new ArrayList<>();
     stuList.add(new Student("张三","男","20","88");
     stuList.add(new Student("李四","女","19","99");
     ```

3. 遍历这个集合，将每个Student对象中的数据按以下格式写到项目根目录下的student.txt中：

   ```java
   张三,男,20,88
   李四,女,19,99
   ```

   

-----

答案：

```java

```





# 【IO资源处理】

##  题目6

请使用FileWriter向文件输出：HelloWorld

要求：

1. 用 `try-catch-finally` 方式处理异常。
2. 用 `try-with-resource` 方式处理异常。



代码模板：

```java
public class Demo01 {
    public static void main(String[] args) {

    }

    public static void test1() {
        //TODO
        // 请使用FileWriter向文件输出：HelloWorld
        // 用 try-catch-finally 方式处理异常。
    }


    public static void test2() {
        //TODO
        // 请使用FileWriter向文件输出：HelloWorld
        // 用 try-with-resource 方式处理异常。
    }
}

```



答案：

```java

```



# 【属性集】

## 题目7

请编写程序，定义一个Properties对象，存储以下内容：

```java
Properties pro = new Properties();
pro.setProperty("brand", "Iphone11Pro Max");
pro.setProperty("capacity", "256G");
pro.setProperty("price", "10899");
```

请将上述内容写入到文件`iphone.properties`中（自己选定文件存储的位置）。



答案：

```java

```



## 题目8

将题目一中 `iphone.properties`文件的数据加载到 Properties对中，并遍历打印出来。

答案：

```java

```





# 【ResourceBundle】

## 题目9

在src目录中创建一个文件：iphone.properties，内容如下

```properties
brand=Iphone11Pro Max
capacity=256G
price=10899
```

使用ResourceBundle工具类，将brand，capacity，price的值读取并打印到控制台。

```java

```



打印结果：

```

```

