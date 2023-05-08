## 选择题

### 题目1(单选):

**关于下列File的功能描述错误的是(  B )**

#### 选项 :

​	A. createNewFile()用于创建文件的方法

​	B. delete()只能删除文件

​	C. isFile()用于判断是否是一个文件

​	D. getAbsolutePath()获取文件的绝对路径



### 题目2(单选):

**对于下列递归删除一个文件夹的代码补全( C )**

```java
public class Demo {
    public static void main(String[] args) {
        File f = new File("D:\\aaa");
        deleteFiles(f);
    }

    private static void deleteFiles(File f) {
        File[] files = f.__位置1__();

        for (File file : files) {
            if (file.__位置2__()) {
                // 递归
                deleteFiles(file);
            } else {
                // 删除文件
                file.__位置3__();
            }
        }
        // 删除当前文件夹
        f.__位置4__();
    }
}
```

#### 选项 :

​	A. 位置1:listFiles 	位置2:isFile		  	位置3:delete	位置4:remove

​	B. 位置1:list		 	位置2:isDirectory	位置3:delete	位置4:delete	

​	C. 位置1:listFiles 	位置2:isDirectory	位置3:delete	位置4:delete	

​	D. 位置1:listFiles 	位置2:isFile		  	位置3:delete	位置4:remove



### 题目3(单选):

**关于下列字节输出流写数据的代码合理补全( C )**

```java
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        __位置1__ fos = new __位置1__("day11_demo\\a.txt");

        fos.__位置2__(97);
        fos.__位置2__(98);
        fos.__位置2__(99);

        fos.__位置3__();
    }
}
```

#### 选项 :

​	A. 位置1:OutputStream		  位置2:write	位置3:flush

​	B. 位置1:OutputStream		  位置2:write	位置3:close

​	C. 位置1:FileOutputStream	位置2:write	位置3:close

​	D. 位置1:FileOutputStream	位置2:write	位置3:flush



### 题目4(单选):

**关于下列字节输入流读数据的代码合理补全 ( A )**

```java
public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        __位置1__ fis = new __位置1__("day11_demo\\a.txt");
        
        byte[] bys = new byte[1024];
        int len;

        while ((__位置2__ = fis.read(__位置3__)) != -1) {
            // 打印数组的内容
            System.out.print(__位置4__);
        }

        fis.close();
    }
}
```



#### 选项 :

​	A. 位置1: FileInputStream	位置2:len		位置3:bys	位置4: new String(bys , 0 , len)

​	B. 位置1: FileInputStream	位置2:bys	   位置3:len 	位置4: new String(bys)

​	C. 位置1: InputStream		  位置2:bys	   位置3:len 	位置4: new String(bys , 0 , len)

​	D. 位置1: InputStream		  位置2:len		位置3:bys	位置4: new String()



### 题目5(多选):

**关于字节输出流换行,追加写数据描述正确的是 (  BC )**

#### 选项 :

​	A. 追加写数据需要使用构造方法 public FileOutputStream(String name，boolean append) 第二个参数为 false

​	B. 追加写数据需要使用构造方法 public FileOutputStream(String name，boolean append) 第二个参数为 true

​	C. Windows系统换行需要写入\r\n

​	D. Windows系统换行需要写入\p\v



### 题目6(单选):

**关于下列字节缓冲流复制文件代码补全( D  )**

```java
public class BufferedStreamDemo {
    public static void main(String[] args) throws IOException {
        __位置1__ bis = new __位置1__(new FileInputStream("D:\\好看的图片\\liqin.jpg"));

        __位置2__ bos = new __位置2__(new FileOutputStream("day11_demo\\copy.jpg"));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(__位置3__)) != -1) {
            bos.__位置4__;
        }

        bis.close();
        bos.close();
    }
}
```

#### 选项 :

​	A. 位置1:FileInputStream		     位置2:BufferedOutputStream	 位置3:bys	位置4:write(bys, 0, len)

​	B. 位置1:BufferedInputStream	位置2:BufferedOutputStream	位置3:bys	位置4:write(bys)

​	C. 位置1:BufferedInputStream	位置2:FileOutputStream			  位置3:bys	位置4:write(bys, 0, len)

​	D. 位置1:BufferedInputStream	位置2:BufferedOutputStream	位置3:bys	位置4:write(bys, 0, len)



### 题目7(多选):

**下列关于Properties集合的特有功能有( ABC )**

#### 选项 :

​	A. setProperty()用于设置集合的键和值

​	B. getProperty()用于获取集合中的键值对

​	C. stringPropertyNames()用于获取健集合

​	D. getSet()用于获取健集合



### 题目8(单选):

**关于下列Properties集合的代码补全( C )**

```java
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        // 创建Properties集合对象
        Properties properties = new Properties();

        // 使用字节流 , 把文件中的键值对, 读取到集合中
        properties.__位置1__(new __位置2__("day11_demo\\prop.__位置3__"));

        // 打印集合中的数据
        System.out.println(properties);
    }
}
```

#### 选项 :

​	A. 位置1: store	 位置2:FileInputStream		位置3:properties

​	B. 位置1: load	  位置2:FileReader				  位置3:Properties

​	C. 位置1: load	  位置2:FileInputStream		位置3:properties

​	D. 位置1: store	位置2:FileReader				  位置3:Properties



### 题目9(单选):

**关于下列ResourceBundle工具类的代码补全( D )**

```java
public class ResourceBundleDemo {
    public static void main(String[] args) {
		// 读取src根目录下的user.properties文件
        ResourceBundle resourceBundle = __位置1__("__位置2__");

        // String getString(String key) : 通过键，获取对应的值
        String value1 = resourceBundle.__位置3__("username");
        String value2 = resourceBundle.getString("password");
        System.out.println(value1);
        System.out.println(value2);
    }
}
```

#### 选项 :

​	A.  位置1: new ResourceBundle()         		位置2: user 					    位置3: getValues

​	B.  位置1: new ResourceBundle()   			  位置2: user.properties 	位置3: getString

​	C.  位置1: ResourceBundle.getBundle		位置2: user.properties 	位置3: getValues

​	D.  位置1: ResourceBundle.getBundle		位置2: user 					   位置3: getString

