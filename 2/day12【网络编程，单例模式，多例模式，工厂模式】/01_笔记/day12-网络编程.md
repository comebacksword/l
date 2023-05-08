# day13-网络编程

## 今日目标

- ##### 网络编程

- ##### TCP通信

- ##### Junit单元测试

- ##### 单例设计模式

- ##### 多例设计模式

- ##### 工厂设计模式

## 1 网络编程

### 1.1 软件架构

- C/S结构 ：全称为Client/Server结构，是指客户端和服务器结构。常见程序有ＱＱ、迅雷等软件
- B/S结构 ：全称为Browser/Server结构，是指浏览器和服务器结构。常见浏览器有谷歌、火狐等
- 两种架构各有优势，但是都离不开网络的支持。网络编程 , 就是在一定的协议下，实现两台计算机的通信的程序
- ![image-20210418000257329](\imgs\image-20210418000257329.png)

### 1.2 什么是网络编程

- 在网络通信协议下，不同计算机上运行的程序，可以进行数据传输

### 1.3 网络编程三要素

- IP地址 : 设备在网络中的地址，是唯一的标识。
- 端口 : 设备在网络中的地址，是唯一的标识。
- 数据在网络中传输的规则，常见的协议有UDP协议和TCP协议。

### 1.4 IP地址

- IP：全称”互联网协议地址”，也称IP地址。是分配给上网设备的数字标签。常见的IP分类为：ipv4和ipv6

  简单来说 : 就是设备在网络中的唯一标识 , 想要连接哪一台电脑 , 就找到此电脑在网络中的ip地址

- IP地址常见分类 : ipv4和ipv6

- 常用命令：

  - ipconfig：查看本机IP地址
  - IP地址：检查网络是否连通

- 特殊IP地址：

  - 127.0.0.1：是回送地址也称本地回环地址，可以代表本机的IP地址，一般用来测试使用

- 为了方便我们对IP地址的获取和操作，Java提供了一个类InetAddress 供我们使用
  InetAddress：此类表示Internet协议（IP）地址

  - | static InetAddress getByName(String host) | 在给定主机名的情况下确定主机的 IP 地址 |
    | ----------------------------------------- | -------------------------------------- |
    | String getHostName()                      | 获取此 IP 地址的主机名                 |
    | String getHostAddress()                   | 返回 IP 地址字符串（以文本表现形式）。 |

### 1.5 端口

- 端口：应用程序在设备中唯一的标识。

- 端口号：应用程序的唯一标识方式 , 用两个字节表示的整数，它的取值范围是0~65535。
                其中0~1023之间的端口号用于一些知名的网络服务或者应用。
                我们自己使用1024以上的端口号就可以了。

- 注意：一个端口号只能被一个应用程序使用。

### 1.6 通信协议

- 协议：计算机网络中，连接和通信的规则被称为网络通信协议
- UDP协议
  - 用户数据报协议(User Datagram Protocol)
  - UDP是面向无连接通信协议。
  -  速度快，有大小限制一次最多发送64K，数据不安全，易丢失数据。
- TCP协议
  - 传输控制协议 (Transmission Control Protocol)
  - TCP协议是面向连接的通信协议。
  - 速度慢，没有大小限制，数据安全

## 2 TCP通信

### 2.1 TCP发送数据

```java
package com.itheima.tcp_demo.demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
    客户端 :

    发送数据的步骤
        1 创建客户端的Socket对象 : Socket(String host, int port) 与指定服务端连接
            参数说明：
            host 表示服务器端的主机名，也可以是服务器端的IP地址，只不过是String类型的
            port 表示服务器端的端口

        2 通获Socket对象取网络中的输出流，写数据
            OutputStream getOutputStream()

        3 释放资源
            void close()

 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端的Socket对象(Socket) 与指定服务端连接
        Socket socket = new Socket("127.0.0.1", 10010);

        // 通获Socket对象取网络中的输出流，写数据
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());

        // while(true){}

        // 释放资源
        os.close();
        socket.close();
    }
}
```

### 2.2 TCP接收数据

​	

```java
package com.itheima.tcp_demo.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
     服务端接收数据 :

    1 创建服务器端的Socket对象 : ServerSocket类
        ServerSocket(int port)  : 构造方法需要绑定一个端口号 , port就是端口号

    2 监听客户端连接,并接受连接，返回一个Socket对象
        Socket accept() : 该方法会一直阻塞直到建立连接

    3 获取网络中的输入流，用来读取客户端发送过来的数据
        InputStream getInputStream()

    4 释放资源 : 服务端一般不会关闭
        void close()
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
//        1 创建服务器端的Socket对象 : ServerSocket类
//        ServerSocket(int port)  : 构造方法需要绑定一个端口号 , port就是端口号
        ServerSocket serverSocket = new ServerSocket(10010);

//        2 监听客户端连接,并接受连接，返回一个Socket对象
//        Socket accept() : 该方法会一直阻塞直到建立连接
        Socket socket = serverSocket.accept();
//
//        3 获取网络中的输入流，用来读取客户端发送过来的数据
//        InputStream getInputStream()
        InputStream is = socket.getInputStream();
        int by;
        System.out.println("read方法执行前");
        while ((by = is.read()) != -1) {
            System.out.print((char) by);
        }
        System.out.println("read方法执行后");
    }
}
```

### 2.3  TCP通信原理分析

![image-20210418001010941](\imgs\image-20210418001010941.png)



### 2.4 TCP三次握手

![image-20210418001256988](\imgs\image-20210418001256988.png)

### 2.5 TCP练习1

```java
package com.itheima.tcp_demo.test1;

import java.io.*;
import java.net.Socket;

/*
    客户端 :

    发送数据的步骤
        1 创建客户端的Socket对象 : Socket(String host, int port) 与指定服务端连接
            参数说明：
            host 表示服务器端的主机名，也可以是服务器端的IP地址，只不过是String类型的
            port 表示服务器端的端口

        2 通获Socket对象取网络中的输出流，写数据
            OutputStream getOutputStream​()

        3 释放资源
            void close​()

 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端的Socket对象(Socket) 与指定服务端连接
        Socket socket = new Socket("127.0.0.1", 10010);

        // 通获Socket对象取网络中的输出流，写数据
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        // 像服务端写入结束标记
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(line);

        // 释放资源
        br.close();
        os.close();
        socket.close();
    }
}

```

```java
package com.itheima.tcp_demo.test1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
     服务端接收数据 :

    1 创建服务器端的Socket对象 : ServerSocket类
        ServerSocket​(int port)  : 构造方法需要绑定一个端口号 , port就是端口号

    2 监听客户端连接,并接受连接，返回一个Socket对象
        Socket accept​() : 该方法会一直阻塞直到建立连接

    3 获取网络中的输入流，用来读取客户端发送过来的数据
        InputStream getInputStream​()

    4 释放资源 : 服务端一般不会关闭
        void close​()
 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
//        1 创建服务器端的Socket对象 : ServerSocket类
//        ServerSocket​(int port)  : 构造方法需要绑定一个端口号 , port就是端口号
        ServerSocket serverSocket = new ServerSocket(10010);

//        2 监听客户端连接,并接受连接，返回一个Socket对象
//        Socket accept​() : 该方法会一直阻塞直到建立连接
        Socket socket = serverSocket.accept();
//
//        3 获取网络中的输入流，用来读取客户端发送过来的数据
//        InputStream getInputStream​()
        InputStream is = socket.getInputStream();
        int by;

        while ((by = is.read()) != -1) {
            System.out.print((char) by);
        }

        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bos.write("你谁啊");

        bos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}

```

### 2.6 TCP练习2

```java
package com.itheima.tcp_demo.test2;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket socket = new Socket("127.0.0.1", 10086);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\传智播客\\安装包\\好看的图片\\liqin.jpg"));

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        int by;
        while ((by = bis.read()) != -1) {// 从本地中读一个字节
            bos.write(by);// 往服务器写一个字节
            bos.flush();
        }
        // 写结束标记
        socket.shutdownOutput();

        // 把网络中的字节输入流 , 封装成高效的字符输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String line;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
        String msg = br.readLine();// 读到换行才叫读到一行, 所以必须写服务器必须写newLine
        System.out.println(msg);

        // 释放资源
        bis.close();
        socket.close();
    }
}

```

```java
package com.itheima.tcp_demo.test2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 创建服务端的连接对象
        ServerSocket serverSocket = new ServerSocket(10086);
        Socket socket = null;
        BufferedInputStream bis = null;
        BufferedWriter socketBw = null;

        while (true) {
            // 获取Socket对象
            socket = serverSocket.accept();

            // 获取网络中的字节输入流  在封装成高效的字节输入流对象
            bis = new BufferedInputStream(socket.getInputStream());

            // 创建本地的字节输出流 , 封装成高效的字节输出流
            BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("day13_demo\\图片\\a.jpg"));

            int by;
            while ((by = bis.read()) != -1) {
                bw.write(by);
                bw.flush();
            }

            //关闭本地流
            bw.close();

            // 获取网络中的字节输出流 , 封装成高效的字符输出流
            socketBw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            socketBw.write("谢谢你");
            socketBw.newLine();// 必须有换行 , 因为readLine读到换行结束
            socketBw.flush();
        }

        // 释放资源
//        socketBw.close();
//        bis.close();
//        socket.close();
//        serverSocket.close();
    }
}

```

### 2.7 TCP练习3

```java
package com.itheima.tcp_demo.test3;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        // 创建客户端Socket对象
        Socket socket = new Socket("127.0.0.1", 10086);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\传智播客\\安装包\\好看的图片\\liqin.jpg"));

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        int by;
        while ((by = bis.read()) != -1) {// 从本地中读一个字节
            bos.write(by);// 往服务器写一个字节
            bos.flush();
        }
        // 写结束标记
        socket.shutdownOutput();

        // 把网络中的字节输入流 , 封装成高效的字符输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String line;
//        while ((line = br.readLine()) != null) {
//            System.out.println(line);
//        }
        String msg = br.readLine();// 读到换行才叫读到一行, 所以必须写服务器必须写newLine
        System.out.println(msg);

        // 释放资源
        bis.close();
        socket.close();
    }
}

```

```java
package com.itheima.tcp_demo.test3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        // 创建服务端的连接对象
        ServerSocket serverSocket = new ServerSocket(10086);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            // 获取Socket对象
            Socket socket = serverSocket.accept();
            executorService.submit(new ServerThread(socket));
        }

        // 释放资源
//        socketBw.close();
//        bis.close();
//        socket.close();
//        serverSocket.close();
    }
}

```

```java
package com.itheima.tcp_demo.test3;

import javax.management.relation.RoleUnresolved;
import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ServerThread implements Runnable {
    Socket socket = null;
    BufferedOutputStream bw = null;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            // 获取网络中的字节输入流  在封装成高效的字节输入流对象
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

            // 创建本地的字节输出流 , 封装成高效的字节输出流
            bw = new BufferedOutputStream(new FileOutputStream("day13_demo\\图片\\" + UUID.randomUUID() + ".jpg"));

            int by;
            while ((by = bis.read()) != -1) {
                bw.write(by);
                bw.flush();
            }
            // 获取网络中的字节输出流 , 封装成高效的字符输出流
            BufferedWriter socketBw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            socketBw.write("谢谢你");
            socketBw.newLine();// 必须有换行 , 因为readLine读到换行结束
            socketBw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭本地流
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

```





## 3 单例设计模式

### 学习目标

- 能够使用单例设计模式设计代码

### 内容讲解

- 正常情况下一个类可以创建多个对象 

```java
public static void main(String[] args) {
	// 正常情况下一个类可以创建多个对象
	Person p1 = new Person();
	Person p2 = new Person();
	Person p3 = new Person();
}
```

- 如果说有时一个对象就能搞定的事情 , 非要创建多个对象 , 浪费内存!!!

  

#### 3.1 单例设计模式的作用

- 单例模式，是一种常用的软件设计模式。通过单例模式可以保证项目中，应用该模式的这个类只有一个实例。

  即一个类只有一个对象实例。

- 好处 ：可以节省内存，共享数据

  

#### 3.2 单例设计模式实现步骤

1. 将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
2. 在该类内部产生一个唯一的实例化对象，并且将其封装为private static 类型的成员变量。
3. 定义一个静态方法返回这个唯一对象。



#### 3.3 单例设计模式的类型

根据创建对象的时机单例设计模式又分为以下两种:

1. 饿汉单例设计模式

2. 懒汉单例设计模式

   

=============================================================================================



#### 3.4 饿汉单例设计模式

- 饿汉单例设计模式就是使用类的时候已经将对象创建完毕

  不管以后会不会使用到该实例化对象，先创建了再说。很着急的样子，故被称为“饿汉模式”。

- 代码如下：

  ```java
  public class Singleton {
      // 1.将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
      private Singleton() {}
  
      // 2.在该类内部产生一个唯一的实例化对象，并且将其封装为private static 类型的成员变量。
      private static final Singleton instance = new Singleton();
      
      // 3.定义一个静态方法返回这个唯一对象。
      public static Singleton getInstance() {
          return instance;
      }
  }
  ```



- 需求：定义一个皇帝类，要求对象只能存在一个。

  ```java
  package com.itheima.singledesign;
  /*
      需求 : 使用单例模式(饿汉式) , 要求此类只能有一个对象
  
      步骤 :
          1. 将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
          2. 在该类内部产生一个唯一的实例化对象，并且将其封装为private static 类型的成员变量。
          3. 定义一个静态方法返回这个唯一对象。
   */
  public class King {
      // 1. 将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
      private King(){}
      // 2. 在该类内部产生一个唯一的实例化对象，并且将其封装为private static 类型的成员变量。
      private static final King KING = new King();
      // 3. 定义一个静态方法返回这个唯一对象。
      public static King getInstance(){
          return KING;
      }
  }
  ```



=============================================================================================



####  3.5 懒汉单例设计模式

- 懒汉单例设计模式就是调用getInstance()方法时对象才被创建

  也就是说先不急着实例化出对象，等要用的时候才实例化出对象。不着急，故称为“懒汉模式”。

  代码如下：


  ```java
public class Singleton {
 
	 // 1.将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
    private Singleton() {}
    
    // 2.在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
    private static Singleton instance;// 0x001

    // 3.定义一个静态方法返回这个唯一对象。要用的时候才例化出对象
    public static synchronized Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
  ```

- ##### 注意 ：

  - 懒汉单例设计模式在多线程环境下可能会实例化出多个对象，不能保证单例的状态，所以加上关键字：synchronized，保证其同步安全。

  

- 需求：使用懒汉单例 ，改写皇帝类的单例模式

  ```java
  package com.itheima.singledesign;
  
  /*
      需求 : 使用单例模式(懒汉式) , 要求此类只能有一个对象
  
      步骤 :
          1. 将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
          2. 在该类内部定义一个private static修饰的成员变量 . 此变量不需要赋值
          3. 定义一个静态方法返回这个唯一对象。 此方法需要加上synchronized关键字保证在多线程中也只有一个实例对象
   */
  public class King2 {
      // 1. 将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
      private King2() {
      }
  
      // 2. 在该类内部定义一个private static修饰的成员变量 . 此变量不需要赋值
      private static King2 king;// null
  
      // 3. 定义一个静态方法返回这个唯一对象。 此方法需要加上synchronized关键字保证在多线程中也只有一个实例对象
      public static synchronized King2 getInstance() {
          if (king == null) {
              king = new King2();
          }
          return king;
      }
  }
  ```
  
  

#### 知识小结

- 单例模式可以保证系统中一个类只有一个对象实例。
- 实现单例模式的步骤：

  - 将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
  - 在该类内部产生一个唯一的实例化对象，并且将其封装为private static类型的成员变量。
  - 定义一个静态方法返回这个唯一对象。






## 4 多例设计模式

### 学习目标

- 能使用多例设计模式设计代码

### 内容讲解

#### 4.1 多例设计模式的作用

- 多例模式，是一种常用的设计模式之一。通过多例模式可以保证项目中，应用该模式的类有**固定数量的实例**。

  多例类要自我创建并管理自己的实例，还要向外界提供获取本类实例的方法。



- 使用场景：线程池

  ```java
  线程池 = Executors.newFixedThreadPool(3);
  ```



#### 4.2.实现步骤

​	1.创建一个类,  将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。

​	2.在类中定义该类被创建对象的总数量

​	3.在类中定义存放类实例的list集合

​	4.在类中提供静态代码块,在静态代码块中创建类的实例

​	5.提供获取类实例的静态方法



#### 4.3.实现代码

- 某一个学科有固定3位老师，年级中上该课程的老师就是这三位老师其中一位 

  要求使用多例模式 ,每次获取的都是这三位老师其中一位

```java
package com.itheima.moreinstance_demo;

import com.itheima.homework.work.Student;

import java.util.ArrayList;
import java.util.Random;

/*
    需求  : 某一个学科有固定3位老师，年级中上该课程的老师就是这三位老师其中一位
            要求使用多例模式 ,每次获取的都是这三位老师其中一位

    实现步骤 :
        1.创建一个类,  将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
        2.在类中定义该类被创建对象的总数量
        3.在类中定义存放类实例的list集合
        4.在类中提供静态代码块,在静态代码块中创建类的实例
        5.提供获取类实例的静态方法
 */
public class Teacher {
    // 1.创建一个类,  将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
    private Teacher() {
    }

    // 2.在类中定义该类被创建对象的总数量
    private static int count = 3;

    // 3.在类中定义存放类实例的list集合
    private static ArrayList<Teacher> list = new ArrayList<>();

    // 4.在类中提供静态代码块,在静态代码块中创建类的实例
    static {
        for (int i = 0; i < count; i++) {
            list.add(new Teacher());
        }
    }

    // 5.提供获取类实例的静态方法
    public static Teacher getInstance() {
        int index = new Random().nextInt(count);// [0,3)
        return list.get(index);
    }

}
```



#### 4.4 小结

- 多例模式作用 : 可以保证项目中一个类有固定个数的实例, 在实现需求的基础上, 能够提高实例的复用性.

  实现多例模式的步骤 ：

  - 创建一个类,  将构造方法私有化，使其不能在类的外部通过new关键字实例化该类对象。
  - 在类中定义该类被创建的总数量
  - 在类中定义存放类实例的list集合
  - 在类中提供静态代码块,在静态代码块中创建类的实例
  - 提供获取类实例的静态方法





## 5 工厂设计模式

### 学习目标

- 能够使用工厂设计模式设计代码

### 内容讲解

#### 5.1 概述

- 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。之前我们创建类对象时, 都是使用 new 对象的形式创建, 除new 对象方式以外, 工厂模式也可以创建对象.

  

#### 5.2 作用

- 解决类与类之间的耦合问题

  

#### 5.3案例实践

- 需求：定义汽车工厂类，生产各种品牌的车

- 实现步骤
  - 编写一个Car接口, 提供run方法
  - 编写一个Falali类实现Car接口,重写run方法
  - 编写一个Benchi类实现Car接口,重写run方法
  - 提供一个CarFactory(汽车工厂),用于生产汽车对象
  - 定义CarFactoryTest测试汽车工厂

**实现代码**

```java
package com.itheima.factorydesign_demo;

/*
  - 需求：定义汽车工厂类，生产各种品牌的车

  - 实现步骤
      - 编写一个Car接口, 提供run方法
      - 编写一个Falali类实现Car接口,重写run方法
      - 编写一个Benchi类实现Car接口
      - 提供一个CarFactory(汽车工厂),用于生产汽车对象
      - 定义CarFactoryTest测试汽车工厂
 */
public class CarTest {
    public static void main(String[] args) {
        Car car = CarFactory.getInstance(CarBrand.FALALI);
        car.run();
    }
}

// 定义车的品牌枚举
enum CarBrand {
    // 枚举项
    FALALI, BENCHI, DAZHONG, BAOMA;
}

// 生产汽车对象的工厂
class CarFactory {
    // 私有构造
    private CarFactory() {
    }

    public static Car getInstance(CarBrand brand) {
        switch (brand) {
            case FALALI:
                return new Falali(1);
            case BENCHI:
                return new Benchi();
            default:
                return null;
        }
    }
}

//// 生产汽车对象的工厂
//class CarFactory {
//    // 私有构造
//    private CarFactory() {
//    }
//
//    public static Car getInstance(String brand) {
//        switch (brand) {
//            case "Falali":
//                return new Falali(1);
//            case "Benchi":
//                return new Benchi();
//            default:
//                return null;
//        }
//    }
//}

// 编写一个Car接口, 提供run方法
interface Car {
    public abstract void run();
}

class Falali implements Car {
    public Falali(int num) {
    }

    @Override
    public void run() {
        System.out.println("法拉利破百需要3秒!");
    }
}

class Benchi implements Car {
    @Override
    public void run() {
        System.out.println("奔驰破百需要5秒!");
    }
}
```



#### 知识小结

- 工厂模式的存在可以改变创建对象的方式,降低类与类之间的耦合问题.