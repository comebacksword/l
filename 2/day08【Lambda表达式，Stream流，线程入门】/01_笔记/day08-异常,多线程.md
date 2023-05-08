# day08-异常,多线程

## 今日目标 : 

- 异常的概述 
- 异常的分类 
- 异常的处理方式
- 自定义异常
- 多线程入门

## 1 异常的概述 

### 1.1 什么是异常?

- 异常就是程序出现了不正常情况 , 程序在执行过程中 , 数据导致程序不正常 , 最终导致了JVM的非正常停止
- 注意 : 语句错误不算在异常体系中

### 1.2 异常的存在的形式

- 异常有类型之分，比如我们之前有接触过的比较熟悉的数组越界异常（ArrayIndexOutOfBoundsException），空指针异常（NullPointerException），类型转换异常（ClassCastException）。当程序中产生异常时，其实就是在异常的位置创建了一个该异常的对象，该对象携带了相关的异常信息。
  - 简单来说 : 异常就是Java中提供的类的对象

### 1.3 程序中异常产生后，是如何处理的

- 程序中一旦产生异常，首先会中断向下执行。异常的传递要根据处理方式（后面章节会讲到）而定，如果没有处理，默认是将异常传递给本方法的调用者。不断往回传递，直到JVM收到该异常，此时程序终止执行

## 2 异常的分类

- 编译时期异常
  - 非RuntimeException及其子类 :  编译时异常就是在编译的时候可能出现的异常,  编译时期必须处理,否则程序无法执行
- 运行时期异常
  - RuntimeException及其子类 : 运行时异常就是在运行时可能出现的异常,  在编译时期不需要处理

## 3 异常的处理方式

### 3.1 JVM处理异常的方式

- 如果程序出现了问题，我们没有做任何处理，最终JVM会做默认的处理 , 那么JVM是如何处理的呢 ?
  - 把异常的类型 , 原因 , 位置打印在控制台
  - 程序停止执行
- 注意 : 程序中出现了异常 , 会在当前位置创建此异常的对象 , 对象中包含了异常的信息 , 并把此异常交给本方法的调用者处理

- 缺点 : 用户体验不好

### 3.2 手动处理异常方式

#### 3.2.1 声明异常

- 声明异常—— throws

  - 修饰符   返回值类型  方法名(参数列表)  throws 异常类型1 , 异常的类型2...   {  ...  }
  - 举例 : public void show() throws NullPointerException , ArrayIndexOutOfBoundsException  { .... }

- 作用 : 

  - 表示调用当前的方法可能会出现某些异常,使用时需要注意哦!
  - 如果当前方法没有出现任何异常, 那么代码会正常执行
  - 如果当前方法中出现了异常 , 会把异常交给本方法调用者处理(甩锅)

- ```java
  package com.itheima.exception_demo;
  
  import sun.java2d.pipe.SpanShapeRenderer;
  
  import java.text.ParseException;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  
  /*
      声明异常—— throws
          格式 : 修饰符   返回值类型  方法名(参数列表) throws 异常类型1 , 异常的类型2...   {  ...  }
          举例 : public void show() throws NullPointerException , ArrayIndexOutOfBoundsException  { .... }
          作用 :
              1 表示告知调用者当前的方法可能会出现某些异常,使用时需要注意哦!
              2 如果当前方法没有出现任何异常, 那么代码会正常执行
              3 如果当前方法中出现了异常 , 会把异常交给本方法调用者处理(甩锅)
  
      需求 :
          练习 : 定义两个方法一个运行时期异常 , 一个声明编译时期异常 !
  
      注意 :
          1 编译时异常因为在编译时就会检查，所以必须要写在方法后面进行显示声明
          2 运行时异常因为在运行时才会发生，所以在方法后面可以不写
          3 如果声明多个异常有子父类关系 , 那么只要声明一个父类即可(多态)
   */
  public class Exception_Throws {
      public static void main(String[] args) throws ParseException{
          printArr();// 如果此方法出现了异常 , 会交给jvm进行处理
          StringToDate();// 如果此方法出现了异常 , 会交给jvm进行处理
      }
  
      // 1 告诉调用者 , 此方法可能会出现异常哦
      // 2 如果此方法没有出现异常 , 那么会正常执行
      // 3 如果此方法中出现了异常 , 会把此异常交给调用者处理
      // 注意 : 如果声明的异常是一个运行时期异常 , 那么此声明可以省略
      public static void printArr() /*throws NullPointerException*/ {
          int[] arr = null;
          for (int i = 0; i < arr.length; i++) {
              System.out.println(arr[i]);
          }
      }
  
      // 1 告诉调用者 , 此方法可能会出现异常哦
      // 2 如果此方法没有出现异常 , 那么会正常执行
      // 3 如果此方法中出现了异常 , 会把此异常交给调用者处理
      // 注意 : 如果声明的异常 是一个编译时期异常 , 那么在编译时期必须处理 , 要么程序无法执行
      public static void StringToDate() throws ParseException {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          Date date = sdf.parse("2000-03-11 12:12:12");
      }
  }
  
  ```

#### 3.2.2 抛出异常

- ##### 思考：

  - 以前出现了异常，虚拟机帮我们创建一个异常对象，抛给调用者。但是如果我们需要自己手动创建一个异常对象该如何写？

- ##### 格式 : 

  - ```java
    修饰符    返回值类型    方法名(参数列表)  {
        throw new 异常对象();
    }
    ```

- ##### 注意 : 

  - 抛出异常的格式必须在方法的内部完成
  - 如果手动抛出一个异常，下面的代码无法执行

- ```java
  package com.itheima.exception_demo;
  
  /*
      抛出异常演示 :
          格式 :
              修饰符  返回值类型  方法名(参数列表)  {
                  throw new 异常对象();
              }
  
          注意 :
              1 抛出异常的格式必须在方法的内部完成
              2 如果手动抛出一个异常，下面的代码无法执行
   */
  public class Exception_Throw {
      public static void main(String[] args) {
          System.out.println("家里有一个貌美如花的老婆");
          System.out.println("还有一个当官的兄弟");
          System.out.println("自己还有一个买卖");
          System.out.println("这样的生活你要不要?");
  
          // 程序不想往下执行了 ,怎么做 ???
          // 1 自己手动制造出一个异常
          // 2 当前异常也是交给了方法的调用者处理 , 也就是jvm处理
          // 3 下面代码无法执行
          throw new RuntimeException();
  
          // System.out.println("武大郎的标准生活!");
      }
  }
  
  ```

  

- ##### 作用 : 

  - 在方法中，当传递的参数有误，没有继续运行下去的意义了，则采取抛出处理，表示让该方法结束运行。
  - 告诉调用者方法中出现的问题原因

  ```java
  package com.itheima.exception_demo;
  
  /*
      抛出异常存在的意义所在 :
          1 在方法中，当传递的参数有误，没有继续运行下去的意义了，则采取抛出处理，表示让该方法结束运行。
          2 告诉调用者方法中出现了问题
  
      练习   : 定义一个方法 , 方法的参数接收一个数组 , 在方法中遍历数组 .
      需求1  : 如果方法接收的数组为null  , 使用输出语句提示
      需求2  : 如果方法接收的数组为null  , 使用抛出异常解决
      思考   : 两种方式的区别在哪里 ?
   */
  public class Exception_Throw2 {
      public static void main(String[] args) {
          int[] arr = {1, 2, 3, 4, 5};
          arr = null;
          // printArr1(arr);
          printArr2(arr);// 接收方法返回的异常 , 但是此异常有jvm进行处理
      }
  
      // 需求1  : 如果方法接收的数组为null  , 使用输出语句提示
      public static void printArr1(int[] arr) {
          if (arr == null) {
              System.out.println("数组为null");
          } else {
              for (int i = 0; i < arr.length; i++) {
                  System.out.println(arr[i]);
              }
          }
      }
  
      // 需求2  : 如果方法接收的数组为null  , 使用抛出异常解决
      public static void printArr2(int[] arr) {
          if (arr == null) {
              throw new RuntimeException();
          } else {
              for (int i = 0; i < arr.length; i++) {
                  System.out.println(arr[i]);
              }
          }
      }
  }
  ```

  ![image-20210410224739667](C:\Users\lenovo\AppData\Roaming\Typora\typora-user-images\image-20210410224739667.png)

#### 3.2.3 throws和throw的区别

- throws : 
  - 用在方法声明后面，跟的是异常类名
  - 表示声明异常，告知调用者调用该方法有可能会出现这样的异常
- throw : 
  - 用在方法体内，跟的是异常对象名
  - 表示手动抛出异常对象，告知调用者数据传入有误

#### 3.2.4 捕获异常

- 捕获处理异常介绍 : try, catch

  - 之前的声明或者抛出都是将异常传递出去,让调用者知道异常信息。
    而捕获处理是本方法内部进行处理 , 能够阻止异常的传递，从而保证程序能够继续往下执行。

- 捕获异常的格式

  - ```java
    try {
        try中存放可能会出现问题的代码
            1.代码...
            2.代码...
            3.代码...
    } catch (异常类型 变量名) {
        	4.处理异常方案
           打印异常，获取异常原因记录日志......）
    }
    5.其他代码...
    ```

- 执行方式 

  - 如果 try 中没有遇到问题，怎么执行？
    -  从上往下依次执行 , catch中不执行
  -  如果 try 中代码2遇到了问题，问题下面的代码还会执行吗？
    - 不会执行,会拿当前异常对象和异常类型匹配,匹配成功执行处理异常代码
  - 如果出现的问题没有被捕获，那么程序如何运行？
    -  如果异常没有捕获到 , 虚拟机会帮助我们处理

- 多异常捕获处理方案

  - 多个异常，每个异常单独处理

    - ```java
      try{
          异常1
      }catch(异常1){
      
      } 
      try{
          异常2
      }catch(异常2){
      
      }
      ```

  - 多个异常，一次捕获，多次处理

    - ```java
      try{
          异常1
          异常2
      }catch(异常1){
      }catch(异常2){
      }
      ```

  - 多个异常，异常一次捕获，一次处理

    - ```java
      try{
          异常1
          异常2
      }catch(Exception e){
      }
      ```

### 3.3 Throwable 的成员方法

| **方法名**                    | **说明**                          |
| ----------------------------- | --------------------------------- |
| public String getMessage()    | 返回此 throwable 的详细消息字符串 |
| public String toString()      | 返回此可抛出的简短描述            |
| public void printStackTrace() | 把异常的错误信息输出在控制台      |



### 3.4 异常练习

```java
package com.itheima.exception_demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
    定义一个方法接收一个生日日期字符串(xxxx年xx月xx)
    main方法中让用户输入一个生日日期字符串，调用设计好的方法计算在地球上活了多少天。

    要求：如果解析发生异常，捕获异常，提示用户要重新输入生日日期字符串，直到输入正确的日期为止。
    思考：设计代此码的过程中想想什么时候捕获异常，什么时候声明异常？

 */
public class ExceptionTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入生日(xxxx-xx-xx):");
        
        while (true) {
            String birthday = sc.nextLine();
            try {
                method(birthday);
                break;// 如果生日没有问题结束死循环
            } catch (ParseException e) {
                System.out.println("录入生日格式有误!");
            }
        }
    }

    public static void method(String strDate) throws ParseException {
        // 创建日期模板对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 解析字符串
        Date date = sdf.parse(strDate);

        // 获取生日到1970/1/1 经历的毫秒值
        long time1 = date.getTime();

        // 当前系统时间到1970/1/1 经历的毫秒值
        Date d2 = new Date();
        long time2 = d2.getTime();


        System.out.println("活了" + (time2 - time1) / (1000L * 60 * 60 * 24) + "天");
    }
}

```

## 4 自定义异常

### 4.1 概述

- 当JDK中的异常类型，不满足实际的业务需要时。就可以自己定义异常。例如，学生的年龄数据，如果是负数或者数据  超过了150认为是不合法的，就需要抛出异常。JDK中就没有表示年龄的异常，就需要自己定义异常了

### 4.2 实现步骤

- 定义异常类
- 写继承关系
- 空参构造
- 带参构造

### 4.3 自定义异常注意 

-  如果要自定义编译时异常，就继承Exception
-  如果要自定义运行时异常，就继承RuntimeException 





## 5 多线程入门

### 5.1 多线程相关的概念

- 并发与并行 
  - 并行：在同一时刻，有多个任务在多个CPU上同时执行。
  - 并发：在同一时刻，有多个任务在单个CPU上交替执行。
- 进程与线程
  - 进程：就是操作系统中正在运行的一个应用程序。
  - 线程：就是应用程序中做的事情。比如：360软件中的杀毒，扫描木马，清理垃圾。

### 5.2 什么是多线程

- 是指从软件或者硬件上实现多个线程并发执行的技术。
  具有多线程能力的计算机因有硬件支持而能够在同一时间执行多个线程，提升性能。
- 好处 : 提高任务的执行性能

### 5.3 多线程的创建方式

#### 5.3.1 继承Thread方式

- 基本步骤：

  - 创建一个类继承Thread类。
  - 在类中重写run方法（线程执行的任务放在这里）
  - 创建线程对象，调用线程的start方法开启线程。
  - 执行程序，观察控制台的打印数据的现象

  ```java
  package com.itheima.thread_demo;
  
  /*
      线程的创建方式1：继承Thread方式
  
      基本步骤 :
          1 创建一个类继承Thread类。
          2 在类中重写run方法（线程执行的任务放在这里）
          3 创建线程对象，调用线程的start方法开启线程。
  
      需求 :
          我们启动一个Java程序，其实默认就存在一个主线程（main方法所在线程）
          接下来，我们在主线程启动一个线程，打印1到100的数字，主线程启动完线程后又打印1到100的数字。
          此时主线程和启动的线程在并发执行，观察控制台打印的结果。
   */
  public class MyThread01 {
      public static void main(String[] args) {
          // 创建线程对象，调用线程的start方法开启线程。
          MyThread mt = new MyThread();
          mt.start();
  
          // main方法中的任务
          for (int i = 1; i <= 100; i++) {
              System.out.println("i:" + i);
          }
      }
  }
  // 创建一个类继承Thread类。
  class MyThread extends Thread {
      // 在类中重写run方法（线程执行的任务放在这里）
      @Override
      public void run() {
          for (int i = 1; i <= 100; i++) {
              System.out.println("i:" + i);
          }
      }
  }
  ```

#### 5.3.2 实现Runable方式

- 构造方法

  -  public Thread(Runnable target)
  -  public Thread(Runnalbe target , String name)

- 实现步骤 

  - 定义任务类实现Runnable，并重写run方法 
  - 创建任务对象
  - 使用含有Runnable参数的构造方法，创建线程对象并指定任务。
  - 调用线程的start方法，开启线程

  ```java
  package com.itheima.thread_demo;
  
  /*
       线程的创建方式2：实现Runnable方式
  
      基本步骤 :
          1 定义任务类实现Runnable，并重写run方法
          2 创建任务对象
          3 使用含有Runnable参数的构造方法，创建线程对象并指定任务。
          4 调用线程的start方法，开启线程
  
      需求 :
          我们启动一个Java程序，其实默认就存在一个主线程（main方法所在线程）
          接下来，我们在主线程启动一个线程，打印1到100的数字，主线程启动完线程后又打印1到100的数字。
          此时主线程和启动的线程在并发执行，观察控制台打印的结果。
   */
  public class MyThread02 {
      public static void main(String[] args) {
          // 创建线程对象，调用线程的start方法开启线程。
          MyRunnable mr = new MyRunnable();
          Thread thread= new Thread(mr);
          thread.start();
  
          // main方法中的任务
          for (int i = 1; i <= 100; i++) {
              System.out.println("i:" + i);
          }
      }
  
  }
  
  // 1 定义任务类实现Runnable，并重写run方法
  class MyRunnable implements Runnable {
      // 在类中重写run方法（线程执行的任务放在这里）
      @Override
      public void run() {
          for (int i = 1; i <= 100; i++) {
              System.out.println("i:" + i);
          }
      }
  }
  
  ```

### 5.3.3 Thread类中常用方法

- String getName()：返回此线程的名称

- Thread类中设置线程的名字

  - void setName(String name)：将此线程的名称更改为等于参数 name
  - 通过构造方法也可以设置线程名称

- public static Thread currentThread()：返回对当前正在执行的线程对象的引用

- public static void sleep(long time)：让线程休眠指定的时间，单位为毫秒

- 线程有两种调度模型

  - 分时调度模型：所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间片
    抢占式调度模型：优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个，优先级高的线程
  - 获取的 CPU 时间片相对多一些

  ```java
  package com.itheima.thread_demo.thread_method;
  
  /*
      线程有两种调度模型
          1 分时调度模型：所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间片
          2 抢占式调度模型：优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个，优先级高的线程
             获取的 CPU 时间片相对多一些
  
          注意 : Java使用的是抢占式调度模型
  
  
          优先级高 , 只是抢夺到cpu执行的概率高而已 , 只是一种概率问题
   */
  public class PriorityDemo {
      public static void main(String[] args) {
          Thread thread1 = new Thread(new Runnable() {
              @Override
              public void run() {
                  for (int i = 0; i < 1000; i++) {
                      System.out.println(Thread.currentThread().getName() + ":" + i);
                  }
              }
          });
          // 优先级最低
          thread1.setPriority(1);
          thread1.start();
  
          Thread thread2 = new Thread(new Runnable() {
              @Override
              public void run() {
                  for (int i = 0; i < 1000; i++) {
                      System.out.println(Thread.currentThread().getName() + ":" + i);
                  }
              }
          });
          // 优先级最高
          thread2.setPriority(10);
          thread2.start();
      }
  }
  ```

  