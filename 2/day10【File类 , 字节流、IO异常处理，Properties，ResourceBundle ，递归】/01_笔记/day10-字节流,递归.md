# day11-IO流,Properties集合,IO工具类

## 今日目标 

- ##### IO流的介绍

- ##### IO流的分类

- ##### 字节输出流

- ##### 字节输入流

- ##### 字节缓冲区流

- ##### Properties集合

## 1 IO流的介绍

### 1.1 为什么要学习IO流

- 通过变量,数组,或者集合存储数据
  - 都是不能永久化存储 , 因为数据都是存储在内存中
  - 只要代码运行结束，所有数据都会丢失
- 使用IO流
  - 1，将数据写到文件中，实现数据永久化存储
  - 2，把文件中的数据读取到内存中(Java程序)

### 1.2 什么是IO流

- I  表示intput  ，是数据从硬盘进内存的过程，称之为读。
- O 表示output ，是数据从内存到硬盘的过程。称之为写
- IO的数据传输，可以看做是一种数据的流动，按照流动的方向，以内存为参照物，进行读写操作
  - 简单来说：内存在读，内存在写

### 1.3 IO流的分类

- 按照流向区分
  - 输入流 : 用来读数据
  - 输出流 : 用来写数据
- 按照类型区分
  - 字节流
  - 字符流
- 注意 : 
  - 字节流可以操作任意文件
  - 字符流只能操作纯文本文件
  - 用windows记事本打开能读的懂，那么这样的文件就是纯文本文件。

## 2 字节流输出流

### 2.1 字节输出流入门

- ##### FileOutputStream类 : 

  - `OutputStream`有很多子类，我们从最简单的一个子类开始。
  - `java.io.FileOutputStream `类是文件输出流，用于将数据写出到文件

- ##### 构造方法 : 

  - `public FileOutputStream(File file)`：创建文件输出流以写入由指定的 File对象表示的文件。 
  - `public FileOutputStream(String name)`： 创建文件输出流以指定的名称写入文件。

  ```java
  public class FileOutputStreamConstructor throws IOException {
      public static void main(String[] args) {
     	 	// 使用File对象创建流对象
          File file = new File("a.txt");
          FileOutputStream fos = new FileOutputStream(file);
        
          // 使用文件名称创建流对象
          FileOutputStream fos = new FileOutputStream("b.txt");
      }
  }
  ```

- ##### 字节输出流写数据快速入门

  - 创建字节输出流对象。
  - 写数据
  - 释放资源

  ```java
  package com.itheima.outputstream_demo;
  
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.IOException;
  
  /*
      字节输出流写数据快速入门 :
          1 创建字节输出流对象。
          2 写数据
          3 释放资源
   */
  public class OutputStreamDemo1 {
      public static void main(String[] args) throws IOException {
          // 创建字节输出流对象
          // 如果指定的文件不存在 , 会自动创建文件
          // 如果文件存在 , 会把文件中的内容清空
          FileOutputStream fos = new FileOutputStream("day11_demo\\a.txt");
  
          // 写数据
          // 写到文件中就是以字节形式存在的
          // 只是文件帮我们把字节翻译成了对应的字符 , 方便查看
          fos.write(97);
          fos.write(98);
          fos.write(99);
  
          // 释放资源
          // while(true){}
          // 断开流与文件中间的关系
          fos.close();
      }
  }
  ```

### 2.2 字节输出流写数据的方法

- 字节流写数据的方法

  - 1 void write(int b)    一次写一个字节数据
  - 2 void write(byte[] b)    一次写一个字节数组数据
  - 3 void write(byte[] b, int off, int len)  一次写一个字节数组的部分数据

  ```java
  package com.itheima.outputstream_demo;
  
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.IOException;
  
  /*
      字节流写数据的3种方式
          1 void write​(int b)	一次写一个字节数据
          2 void write​(byte[] b)	一次写一个字节数组数据
          3 void write​(byte[] b, int off, int len)	一次写一个字节数组的部分数据
   */
  public class OutputStreamDemo2 {
      public static void main(String[] args) throws IOException {
          // 创建字节输出流对象
          FileOutputStream fos = new FileOutputStream("day11_demo\\a.txt");
  
          // 写数据
  //        1 void write​(int b)	一次写一个字节数据
          fos.write(97);
          fos.write(98);
          fos.write(99);
  
  //        2 void write​(byte[] b)	一次写一个字节数组数据
          byte[] bys = {65, 66, 67, 68, 69};
          fos.write(bys);
  
  //        3 void write​(byte[] b, int off, int len)	一次写一个字节数组的部分数据
          fos.write(bys, 0, 3);
  
          // 释放资源
          fos.close();
      }
  }
  ```

  

### 2.3 写数据的换行和追加写入

```
package com.itheima.outputstream_demo;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    字节流写数据的换行和追加写入

    1 字节流写数据如何实现换行呢？
        写完数据后，加换行符
        windows : \r\n
        linux : \n
        mac : \r

    2 字节流写数据如何实现追加写入呢？
        通过构造方法 : public FileOutputStream(String name，boolean append)
        创建文件输出流以指定的名称写入文件。如果第二个参数为true ，不会清空文件里面的内容
 */
public class OutputStreamDemo3 {
    public static void main(String[] args) throws IOException {
        // 创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("day11_demo\\a.txt");

        // void write(int b)  一次写一个字节数据
        fos.write(97);
        // 因为字节流无法写入一个字符串 , 把字符串转成字节数组写入
        fos.write("\r\n".getBytes());
        fos.write(98);
        fos.write("\r\n".getBytes());
        fos.write(99);
        fos.write("\r\n".getBytes());

        // 释放资源
        fos.close();
    }
}
```

```java
package com.itheima.outputstream_demo;

import java.io.FileOutputStream;
import java.io.IOException;

/*
    字节流写数据的换行和追加写入

    1 字节流写数据如何实现换行呢？
        写完数据后，加换行符
        windows : \r\n
        linux : \n
        mac : \r

    2 字节流写数据如何实现追加写入呢？
        通过构造方法 : public FileOutputStream​(String name，boolean append)
        创建文件输出流以指定的名称写入文件。如果第二个参数为true ，不会清空文件里面的内容
 */
public class OutputStreamDemo3 {
    public static void main(String[] args) throws IOException {
        // 创建字节输出流对象
        // 追加写数据
        // 通过构造方法 : public FileOutputStream​(String name，boolean append) : 追加写数据
        FileOutputStream fos = new FileOutputStream("day11_demo\\a.txt" , true);

        // void write​(int b)	一次写一个字节数据
        fos.write(97);
        // 因为字节流无法写入一个字符串 , 把字符串转成字节数组写入
        fos.write("\r\n".getBytes());
        fos.write(98);
        fos.write("\r\n".getBytes());
        fos.write(99);
        fos.write("\r\n".getBytes());

        // 释放资源
        fos.close();
    }
    // 写完数据换行操作
    private static void method1() throws IOException {
        // 创建字节输出流对象
        FileOutputStream fos = new FileOutputStream("day11_demo\\a.txt");

        // void write​(int b)	一次写一个字节数据
        fos.write(97);
        // 因为字节流无法写入一个字符串 , 把字符串转成字节数组写入
        fos.write("\r\n".getBytes());
        fos.write(98);
        fos.write("\r\n".getBytes());
        fos.write(99);
        fos.write("\r\n".getBytes());

        // 释放资源
        fos.close();
    }
}

```



## 3 字节输入流

### 3.1 字节输入流介绍

- #####  字节输入流类

  - InputStream类 : 字节输入流最顶层的类 , 抽象类
                    --- FileInputStream类 : FileInputStream extends InputStream

- ##### 构造方法

  - public FileInputStream(File file) :  从file类型的路径中读取数据
  - public FileInputStream(String name) : 从字符串路径中读取数据

- ##### 步骤 

  -  创建输入流对象
  -  读数据
  -  释放资源

- ```
  package com.itheima.inputstream_demo;
  
  import java.io.FileInputStream;
  import java.io.IOException;
  
  /*
      字节输入流写数据快速入门 : 一次读一个字节
              第一部分 : 字节输入流类
                  InputStream类 : 字节输入流最顶层的类 , 抽象类
                  --- FileInputStream类 : FileInputStream extends InputStream
              第二部分 : 构造方法
                  public FileInputStream(File file) :  从file类型的路径中读取数据
                  public FileInputStream(String name) : 从字符串路径中读取数据
              第三部分 : 字节输入流步骤
                  1 创建输入流对象
                  2 读数据
                  3 释放资源
   */
  public class FileInputStreamDemo1 {
      public static void main(String[] args) throws IOException {
          // 创建字节输入流对象
          // 读取的文件必须存在 , 不存在则报错
          FileInputStream fis = new FileInputStream("day11_demo\\a.txt");
  
          // 读数据 , 从文件中读到一个字节
          // 返回的是一个int类型的字节
          // 如果想看字符, 需要强转
          int by = fis.read();
          System.out.println((char) by);
  
          // 释放资源
          fis.close();
      }
  }
  ```

### 3.2 字节输入流读多个字节

```
package com.itheima.inputstream_demo;

import java.io.FileInputStream;
import java.io.IOException;

/*
    字节输入流写数据快速入门 : 读多个字节
            第一部分 : 字节输入流类
                InputStream类 : 字节输入流最顶层的类 , 抽象类
                --- FileInputStream类 : FileInputStream extends InputStream
            第二部分 : 构造方法
                public FileInputStream(File file) :  从file类型的路径中读取数据
                public FileInputStream(String name) : 从字符串路径中读取数据
            第三部分 : 字节输入流步骤
                1 创建输入流对象
                2 读数据
                3 释放资源
 */
public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流对象
        // 读取的文件必须存在 , 不存在则报错
        FileInputStream fis = new FileInputStream("day11_demo\\a.txt");

        // 读数据 , 从文件中读到一个字节
        // 返回的是一个int类型的字节
        // 如果想看字符, 需要强转
//        int by = fis.read();
//        System.out.println(by);
//        by = fis.read();
//        System.out.println(by);
//        by = fis.read();
//        System.out.println(by);
//
//        by = fis.read();
//        System.out.println(by);
//        by = fis.read();
//        System.out.println(by);
//        by = fis.read();
//        System.out.println(by);

        // 循环改进
        int by;// 记录每次读到的字节
        while ((by = fis.read()) != -1) {
            System.out.print((char) by);
        }

        // 释放资源
        fis.close();
    }
}
```

### 3.3 图片的拷贝

```java
package com.itheima.inputstream_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    需求 : 把 "图片路径\xxx.jpg" 复制到当前模块下

    分析：
        复制文件，其实就把文件的内容从一个文件中读取出来(数据源)，然后写入到另一个文件中(目的地)
        数据源：
            xxx.jpg  --- 读数据 --- FileInputStream
        目的地：
            模块名称\copy.jpg --- 写数据 --- FileOutputStream

 */
public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("D:\\传智播客\\安装包\\好看的图片\\liqin.jpg");

        // 创建字节输出流
        FileOutputStream fos = new FileOutputStream("day11_demo\\copy.jpg");

        // 一次读写一个字节
        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        // 释放资源
        fis.close();
        fos.close();
    }
}

```

### 3.4 异常的捕获处理

- ##### JDK7版本之前处理方式 : 手动释放资源

  ```java
  package com.itheima.inputstream_demo;
  
  
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  
  /*
      需求 : 对上一个赋值图片的代码进行使用捕获方式处理
   */
  public class FileInputStreamDemo4 {
      public static void main(String[] args) {
          FileInputStream fis = null ;
          FileOutputStream fos = null;
          try {
              // 创建字节输入流对象
              fis = new FileInputStream("D:\\传智播客\\安装包\\好看的图片\\liqin.jpg");
  
              // 创建字节输出流
              fos = new FileOutputStream("day11_demo\\copy.jpg");
  
              // 一次读写一个字节
              int by;
              while ((by = fis.read()) != -1) {
                  fos.write(by);
              }
          } catch (IOException e) {
              e.printStackTrace();
          } finally {
              // 释放资源
              if(fis != null){
                  try {
                      fis.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
              // 释放资源
              if(fos != null){
                  try {
                      fos.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }
      }
  }
  
  ```

  

- ##### JDK7版本优化处理方式 : 自动释放资源

  - JDK7优化后可以使用 try-with-resource 语句 , 该语句确保了每个资源在语句结束时自动关闭。
    简单理解 : 使用此语句,会自动释放资源 , 不需要自己在写finally代码块了

  - 格式 : 

    ```java
    格式 :  
    try (创建流对象语句1 ; 创建流对象语句2 ...) {
            // 读写数据
        } catch (IOException e) {
            处理异常的代码...
        }
    
    举例 :
        try ( 
            FileInputStream fis1 = new FileInputStream("day11_demo\\a.txt") ; 
    	    FileInputStream fis2 = new FileInputStream("day11_demo\\b.txt") ) 
        {
            // 读写数据
        } catch (IOException e) {
            处理异常的代码...
        }
    
    ```

- ##### 代码实践

  ```java
  package com.itheima.inputstream_demo;
  
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.IOException;
  
  /*
      JDK7版本优化处理方式
  
      需求 : 对上一个赋值图片的代码进行使用捕获方式处理
   */
  public class FileInputStreamDemo5 {
      public static void main(String[] args) {
          try (
                  // 创建字节输入流对象
                  FileInputStream fis = new FileInputStream("D:\\传智播客\\安装包\\好看的图片\\liqin.jpg");
                  // 创建字节输出流
                  FileOutputStream fos = new FileOutputStream("day11_demo\\copy.jpg")
          ) {
              // 一次读写一个字节
              int by;
              while ((by = fis.read()) != -1) {
                  fos.write(by);
              }
              // 释放资源 , 发现已经灰色 , 提示多余的代码 , 所以使用 try-with-resource 方式会自动关流
              // fis.close();
              // fos.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

  

### 3.4 字节输入流一次读一个字节数组

- FileInputStream类 :

  - public int read(byte[] b)  : 从输入流读取最多b.length个字节的数据, 返回的是真实读到的数据个数

  ```java
  package com.itheima.inputstream_demo;
  
  
  import javax.sound.midi.Soundbank;
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.IOException;
  
  /*
     FileInputStream类 :
          public int read​(byte[] b)：
          1 从输入流读取最多b.length个字节的数据
          2 返回的是真实读到的数据个数
   */
  public class FileInputStreamDemo6 {
      public static void main(String[] args) throws IOException {
          // 创建字节输入流对象
          FileInputStream fis = new FileInputStream("day11_demo\\a.txt");
  
  //        public int read​(byte[] b)：
  //        1 从输入流读取最多b.length个字节的数据
  //        2 返回的是真实读到的数据个数
  
          byte[] bys = new byte[3];
  
  //        int len = fis.read(bys);
  //        System.out.println(len);// 3
  //        System.out.println(new String(bys));// abc
  //
  //        len = fis.read(bys);
  //        System.out.println(len);// 2
  //        System.out.println(new String(bys));// efc
  
          System.out.println("==========代码改进===============");
  
  //        int len = fis.read(bys);
  //        System.out.println(len);// 3
  //        System.out.println(new String(bys, 0, len));// abc
  //
  //        len = fis.read(bys);
  //        System.out.println(len);// 2
  //        System.out.println(new String(bys, 0, len));// ef
  
          System.out.println("==========代码改进===============");
  
          int len;
          while ((len = fis.read(bys)) != -1) {
              System.out.print(new String(bys , 0 , len));
          }
  
          fis.close();
      }
  }
  
  ```

- 对复制图片的代码进行使用一次读写一个字节数组的方式进行改进

   ```java
  package com.itheima.inputstream_demo;
  
  
  import java.io.FileInputStream;
  import java.io.FileNotFoundException;
  import java.io.FileOutputStream;
  import java.io.IOException;
  
  /*
      需求 : 对复制图片的代码进行使用一次读写一个字节数组的方式进行改进
  
      FileInputStream类 :
          public int read​(byte[] b)：
          1 从输入流读取最多b.length个字节的数据
          2 返回的是真实读到的数据个数
   */
  public class FileInputStreamDemo7 {
      public static void main(String[] args) throws IOException {
          // 创建字节输入流对象
          FileInputStream fis = new FileInputStream("D:\\传智播客\\安装包\\好看的图片\\liqin.jpg");
          // 创建字节输出流
          FileOutputStream fos = new FileOutputStream("day11_demo\\copy.jpg");
  
          byte[] bys = new byte[1024];
          int len;// 每次真实读到数据的个数
          int by;
          while ((len = fis.read(bys)) != -1) {
              fos.write(bys, 0, len);
          }
  
          // 释放资源
          fis.close();
          fos.close();
      }
  }
  
  ```

  

## 4 字节缓冲区流

### 4.1 字节缓冲流概述

- 字节缓冲流：
  - ​    BufferOutputStream：缓冲输出流
  - ​    BufferedInputStream：缓冲输入流

- 构造方法：
  - ​    字节缓冲输出流：BufferedOutputStream(OutputStream out)
  - ​    字节缓冲输入流：BufferedInputStream(InputStream in)

- 为什么构造方法需要的是字节流，而不是具体的文件或者路径呢？
  - ​    字节缓冲流仅仅提供缓冲区，不具备读写功能 , 而真正的读写数据还得依靠基本的字节流对象进行操作

### 4.2 字节缓冲流案例

```java
package com.itheima.bufferedstream_demo;

import java.io.*;

/*
    字节缓冲流：
        BufferOutputStream：缓冲输出流
        BufferedInputStream：缓冲输入流

    构造方法：
        字节缓冲输出流：BufferedOutputStream​(OutputStream out)
        字节缓冲输入流：BufferedInputStream​(InputStream in)

    为什么构造方法需要的是字节流，而不是具体的文件或者路径呢？
        字节缓冲流仅仅提供缓冲区，不具备读写功能 , 而真正的读写数据还得依靠基本的字节流对象进行操作

    需求 : 使用缓冲流进行复制文件

 */
public class BufferedStreamDemo1 {
    public static void main(String[] args) throws IOException {
        // 创建高效的字节输入流对象
        // 在底层会创建一个长度为8192的数组
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\传智播客\\安装包\\好看的图片\\liqin.jpg"));
        // 创建高效的字节输出流
        // 在底层会创建一个长度为8192的数组
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day11_demo\\copy.jpg"));

        // 使用高效流 , 一次读写一个字节
        int by;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }

//        byte[] bys = new byte[1024];
//        int len;// 每次真实读到数据的个数
//        while ((len = bis.read(bys)) != -1) {
//            bos.write(bys, 0, len);
//        }

        // 释放资源
        // 在底层会把基本的流进行关闭
        bis.close();
        bos.close();
    }
}

```

### 4.3 缓冲流一次读写一个字节原理

![image-20210415002851261](\img\image-20210415002851261.png)

### 4.4 缓冲流一次读写一个字节数组原理

![image-20210415002914607](\img\image-20210415002914607.png)

- ##### 四种方式复制视频文件

```java
package com.itheima.bufferedstream_demo;

import java.awt.image.DataBufferDouble;
import java.io.*;

/*
    需求：把“xxx.avi”复制到模块目录下的“copy.avi” , 使用四种复制文件的方式 , 打印所花费的时间

    四种方式：
        1 基本的字节流一次读写一个字节          : 花费的时间为:196662毫秒
        2 基本的字节流一次读写一个字节数组      : 花费的时间为:383毫秒
        3 缓冲流一次读写一个字节                : 花费的时间为:365毫秒
        4 缓冲流一次读写一个字节数组            : 花费的时间为:108毫秒

    分析 :
        数据源 : "D:\a.wmv"
        目的地 : "day11_demo\copy.wmv"
 */
public class BufferedStreamDemo2 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        // method1();
        // method2();
        // method3();
        method4();

        long endTime = System.currentTimeMillis();
        System.out.println("花费的时间为:" + (endTime - startTime) + "毫秒");
    }

    // 4 缓冲流一次读写一个字节数组
    private static void method4() throws IOException {
        // 创建高效的字节输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.wmv"));
        // 创建高效的字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day11_demo\\copy.wmv"));

        // 一次读写一个字节数组
        byte[] bys = new byte[1024];
        int len;// 每次真实读到数据的个数
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }

        // 释放资源
        bis.close();
        bos.close();
    }

    //  3 缓冲流一次读写一个字节
    private static void method3() throws IOException {
        // 创建高效的字节输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\a.wmv"));
        // 创建高效的字节输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day11_demo\\copy.wmv"));

        // 一次读写一个字节
        int by;
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }


        // 释放资源
        bis.close();
        bos.close();
    }

    // 2 基本的字节流一次读写一个字节数组
    private static void method2() throws IOException {
        // 创建基本的字节输入流对象
        FileInputStream fis = new FileInputStream("D:\\a.wmv");
        // 创建基本的字节输出流对象
        FileOutputStream fos = new FileOutputStream("day11_demo\\copy.wmv");

        // 一次读写一个字节数组
        byte[] bys = new byte[1024];
        int len;// 每次真实读到数据的个数
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        // 释放资源
        fis.close();
        fos.close();
    }

    // 1 基本的字节流一次读写一个字节
    private static void method1() throws IOException {
        // 创建基本的字节输入流对象
        FileInputStream fis = new FileInputStream("D:\\a.wmv");
        // 创建基本的字节输出流对象
        FileOutputStream fos = new FileOutputStream("day11_demo\\copy.wmv");

        // 一次读写一个字节
        int by;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        // 释放资源
        fis.close();
        fos.close();
    }
}

```



### 5.1 Properties集合的概述

- properties是一个Map体系的集合类

  - `public class Properties extends Hashtable <Object,Object>`

- 为什么在IO流部分学习Properties

  - Properties中有跟IO相关的方法

- 当做双列集合使用

  - 不需要加泛型 , 工作中只存字符串

  ```java
  package com.itheima.properties_demo;
  
  import java.util.Map;
  import java.util.Properties;
  import java.util.Set;
  
  /*
      1 properties是一个Map体系的集合类
          - `public class Properties extends Hashtable <Object,Object>`
      2 为什么在IO流部分学习Properties
          - Properties中有跟IO相关的方法
      3 当做双列集合使用
          - 不需要加泛型 , 工作中只存字符串
   */
  public class PropertiesDemo1 {
      public static void main(String[] args) {
          // 创建集合对象
          Properties properties = new Properties();
  
          // 添加元素
          properties.put("it001" , "张三");
          properties.put("it002" , "李四");
          properties.put("it003" , "王五");
  
          // 遍历集合 : 键找值
          Set<Object> set = properties.keySet();
          for (Object key : set) {
              System.out.println(key + "---" + properties.get(key));
          }
  
          System.out.println("========================");
          
          // 遍历集合 : 获取对对象集合 , 获取键和值
          Set<Map.Entry<Object, Object>> set2 = properties.entrySet();
          for (Map.Entry<Object, Object> entry : set2) {
              Object key = entry.getKey();
              Object value = entry.getValue();
              System.out.println(key + "---" + value);
          }
      }
  }
  ```



### 5.2 Properties作为集合的特有方法

-   Object setProperty(String key, String value)	设置集合的键和值，都是String类型，相当于put方法
-   String getProperty(String key)	使用此属性列表中指定的键搜索属性 , 相当于get方法
-   Set<String> stringPropertyNames()	从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串 , 相当于keySet方法

```java
package com.itheima.properties_demo;

import java.util.Properties;
import java.util.Set;

/*
    Properties作为集合的特有方法
        Object setProperty(String key, String value)	设置集合的键和值，都是String类型，相当于put方法
        String getProperty(String key)	使用此属性列表中指定的键搜索属性 , 相当于get方法
        Set<String> stringPropertyNames​()	从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串 , 相当于keySet方法
 */
public class PropertiesDemo2 {

    public static void main(String[] args) {
        // 创建集合对象
        Properties properties = new Properties();

        // 添加元素
        properties.setProperty("it001", "张三");
        properties.setProperty("it002", "李四");
        properties.setProperty("it003", "王五");

        // 遍历集合 : 键找值
        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            System.out.println(key + "---" + properties.getProperty(key));
        }
    }
}
```



### 5.3 properties中和IO相关的方法

- void load(InputStream inStream)    以字节流形式 , 把文件中的键值对, 读取到集合中
- void load(Reader reader)    以字符流形式 , 把文件中的键值对, 读取到集合中
- void store(OutputStream out, String comments) 把集合中的键值对,以字节流形式写入文件中 , 参数二为注释
- void store(Writer writer, String comments)  把集合中的键值对,以字符流形式写入文件中 , 参数二为注释

```java
package com.itheima.properties_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
   Properties和IO流结合的方法
        void load​(InputStream inStream)	以字节流形式 , 把文件中的键值对, 读取到集合中
        //void load​(Reader reader)	以字符流形式 , 把文件中的键值对, 读取到集合中
        void store​(OutputStream out, String comments)	把集合中的键值对,以字节流形式写入文件中 , 参数二为注释
        //void store​(Writer writer, String comments)	把集合中的键值对,以字符流形式写入文件中 , 参数二为注释
 */
public class PropertiesDemo3 {
    public static void main(String[] args) throws IOException {
        // 创建Properties集合对象
        Properties properties = new Properties();

        // void load​(InputStream inStream)	以字节流形式 , 把文件中的键值对, 读取到集合中
        properties.load(new FileInputStream("day11_demo\\prop.properties"));

        // 打印集合中的数据
        System.out.println(properties);
    }
}

```

```java
package com.itheima.properties_demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
   Properties和IO流结合的方法
        void load​(InputStream inStream)	以字节流形式 , 把文件中的键值对, 读取到集合中
        //void load​(Reader reader)	以字符流形式 , 把文件中的键值对, 读取到集合中
        void store​(OutputStream out, String comments)	把集合中的键值对,以字节流形式写入文件中 , 参数二为注释
        //void store​(Writer writer, String comments)	把集合中的键值对,以字符流形式写入文件中 , 参数二为注释
 */
public class PropertiesDemo3 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("zhangsan" , "23");
        properties.setProperty("lisi" , "24");
        properties.setProperty("wangwu" , "25");
        properties.store(new FileOutputStream("day11_demo\\prop2.properties") , "userMessage");
    }

    private static void method1() throws IOException {
        // 创建Properties集合对象
        Properties properties = new Properties();

        // void load​(InputStream inStream)	以字节流形式 , 把文件中的键值对, 读取到集合中
        properties.load(new FileInputStream("day11_demo\\prop.properties"));

        // 打印集合中的数据
        System.out.println(properties);
    }
}

```



##  6  ResourceBundle加载属性文件

#### 学习目标

- 能够熟练使用ResourceBundle工具类快速读取属性文件的值

#### 内容讲解

#### 【1】API介绍

`java.util.ResourceBundle`它是一个抽象类，我们可以使用它的子类PropertyResourceBundle来读取以.properties结尾的配置文件。

##### 通过静态方法直接获取对象：

```java
static ResourceBundle getBundle(String baseName) 可以根据名字直接获取默认语言环境下的属性资源。
参数注意: baseName 
  	1.属性集名称不含扩展名。
    2.属性集文件是在src目录中的
  
比如：src中存在一个文件 user.properties
ResourceBundle bundle = ResourceBundle.getBundle("user");
```

ResourceBundle中常用方法：

```java
 String getString(String key) : 通过键，获取对应的值
```



#### 【2】代码实践

通过ResourceBundle工具类

将一个属性文件 放到src目录中，使用ResourceBundle去获取键值对数据

```java
package com.itheima.resourcebundle_demo;

import java.util.ResourceBundle;

/*
    1   java.util.ResourceBundle : 它是一个抽象类
        我们可以使用它的子类PropertyResourceBundle来读取以.properties结尾的配置文件

    2   static ResourceBundle getBundle(String baseName) 可以根据名字直接获取默认语言环境下的属性资源。
        参数注意: baseName
            1.属性集名称不含扩展名。
            2.属性集文件是在src目录中的
        比如：src中存在一个文件 user.properties
        ResourceBundle bundle = ResourceBundle.getBundle("user");

    3 ResourceBundle中常用方法：
         String getString(String key) : 通过键，获取对应的值

    优点 : 快速读取属性文件的值

     需求 :
        通过ResourceBundle工具类
        将一个属性文件 放到src目录中，使用ResourceBundle去获取键值对数据
 */
public class ResourceBundleDemo {
    public static void main(String[] args) {
        // public static final ResourceBundle getBundle(String baseName)
        // baseName : properties文件的名字 , 注意 : 扩展名不需要加上 , properties必须在src的根目录下
        ResourceBundle resourceBundle = ResourceBundle.getBundle("user");

        // String getString(String key) : 通过键，获取对应的值
        String value1 = resourceBundle.getString("username");
        String value2 = resourceBundle.getString("password");
        System.out.println(value1);
        System.out.println(value2);
    }
}

```



#### 内容小结

1. 如果要使用ResourceBundle加载属性文件，属性文件需要放置在哪个位置？

   ```
   src的根目录
   ```

   

2. 请描述使用ResourceBundle获取属性值的大致步骤是怎样的？

   ```
   1 获取ResourceBundle对象
   2 通过ResourceBundle类中的getString(key) : 根据键找值
   ```