## 选择题

### 题目1(单选):

**下列关于编码表说法错误的是 ( B )**

#### 选项 :

​	A.  GBK是中国的码表，一个中文以两个字节的形式存储

​	B.  Unicode是万国码表，以UTF-8编码后一个中文以两个字节的形式存储

​	C.  ASCII码表包括了数字字符，英文大小写字符和一些常见的标点符号字符

​	D.  字符流由字节流加上编码表组成



### 题目2(单选):

**下列不属于字符流写数据的是 ( C )**

#### 选项 :

​	A. void write(int c)  写一个字符

​	B. void write(char[] cbuf)  写入一个字符数组

​	C. void write(char[] cbuf, int of)  写入字符数组的一部分

​	D. void write(String str)  写一个字符串



### 题目3(单选):

**下列对于刷新和关流说法错误的是  ( D )**

#### 选项 :

​	A. flush刷新流，刷新之后还可以继续写数据

​	B. close关闭流, 一旦关闭，就不能再写数据

​	C. close会自动刷新缓冲

​	D.  flush之后不能在使用close方法



### 题目4(单选):

**对下列字符输入流读数据代码补全（ B ) **

```java
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        // 创建字符输入流对象
        __位置1__ fr = new __位置1__("day12_demo\\charstream.txt");

        // 一次读一个字符数组数据
        char[] chs = new char[1024];
        int len;
        while ((len = fr.read(__位置2__)) != -1) {
            System.out.print(__位置3__);
        }
        // 释放资源
        fr.close();
    }
}
```

#### 选项 :

​	A. 位置1:FileReader	  位置2:len  	位置3:new String(chs)

​	B. 位置1:FileReader	  位置2:chs 	位置3:new String(chs, 0, len)

​	C. 位置1:Reader			位置2:len  	位置3:new String(chs, 0, len)

​	D.位置1: Reader			位置2:chs 	位置3:new String(chs)



### 题目5(单选):

**对于下列字符缓冲流复制文件代码补全 ( D )**

```java
public class BufferedStreamDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建高效的字符输入流对象
        __位置1__ br = new __位置1__(new FileReader("day12_demo\\abc.txt"));

        // 循环改进
        String line;
        while((line = br.__位置2__()) != __位置3__){
            System.out.println(line);
        }

        // 释放资源
        br.close();
        bw.close();
    }
}
```

#### 选项 :

​	A. 位置1:BufferedReader		位置2:readLine		  位置3:-1

​	B. 位置1:BufferedReader		位置2:read				 位置3:-1

​	C. 位置1:BufferedReader		位置2:read				 位置3:null		

​	D. 位置1:BufferedReader		位置2:readLine		 位置3:null		



### 题目6(多选):

**下列关于字符缓冲流特有功能说法正确的是(  AB )**

#### 选项 :

​	A. newLine属于BufferedWriter类,会根据操作系统的不同,写入不同的行分隔符

​	B. readLine属于BufferedReader类,用于一次读取一行数据,读不到换行符号

​	C. newLine属于BufferedWriter类,写入\r\n换行符

​	D. readLine属于BufferedReader类,用于一次读取一行数据,可以读到换行符号



### 题目7(单选):

**使用转换流把GBK文件转成UTF-8文件代码补全 ( A )**

```java
public class ConversionDemo2 {
    public static void main(String[] args) throws IOException {
        // 创建转换输入流
        InputStreamReader isr = new InputStreamReader(new FileInputStream("GBK编码的文件.txt"), __位置1__);

        // 创建转换输出流
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("UTF编码的文件.txt"), __位置2__);

        int ch;
        while ((ch = __位置3__) != -1) {
            __位置4__
        }

        // 释放资源
        isr.close();
        osw.close();
    }
}
```



#### 选项 :

​	A.  位置1:"GBK"	位置2:"UTF-8"		位置3:isr.read()		位置4:osw.write(ch);	

​	B. 位置1:"GBK"	位置2:"UTF-8"		位置3:osw.read()		位置4:isr.write(ch);	

​	B. 抽象方法必须存在抽象类中

​	C. 位置1:"UTF-8"	位置2:"GBK"		位置3:isr.write()		位置4:osw.read(ch);	

​	D. 位置1:"UTF-8"	位置2:"GBK"		位置3:isr.read()		位置4:osw.write(ch);	



### 题目8(单选):

**对于下列对象操作流说法错误的是 ( A )**

#### 选项 :

​	A. 如果一个类对象想要被序列化 , 那么此类需要实现Serializable接口,重写接口中的抽象方法

​	B. 对象序列化流序列化了一个对象后，假如我们修改了对象所属的Javabean类，会抛出InvalidClassException异常

​	C. 给该成员变量加transient关键字修饰，该关键字标记的成员变量不参与序列化过程

​	D. 如果一个类的手动给出序列号,那么此类将不再自动生成序列号



### 题目9(多选):

**下列关于commons-io工具包正确的使用步骤是(DBAC )**

#### 选项 :

​	A. 将commons-io-2.6.jar加入到项目中

​	B. 把commons-io-2.6.jar包复制到指定的Module的lib目录中

​	C. 在使用commons-io中的工具类时,先进行导包

​	D. 下载commons-io相关jar包

