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



# 【Lambda】

## 【简答】

**简单题不在每日反馈中，请同学们以文档形式提交给授课老师**

1. 请简述Lambda的使用前提条件？

   ```
   
   ```

2. 什么叫做函数式接口

   ```
   
   ```

3. 请说出Lambda表达式的格式

   ```
   
   ```
   
4. 请说出Lambda表达式参数和函数体的简化规则

   ```
   
   ```



   


## 【编码】

### 题目1

请使用Lambda表达式启动一个Thread线程，线程中打印：1--100所有数字。

答案：

```java

```

 

### 题目2

请使用Lambda表达式调用Collections的sort()方法，可以实现对一个List<String>集合进行：降序排序。

编写main()方法，在main()中按以下步骤编写代码：

 1. 定义一个List<String>集合，并存储以下数据：

    ```
    "cab","bac","acb","cba",“bca”,"abc"
    ```

    2. 使用Lambda表达式调用Collections的sort()方法对集合进行降序排序。

2. 排序后向控制台打印集合的所有元素。



答案：

```java

```



### 题目3

给定一个计算器 Calculator 接口，内含抽象方法 calc(减法)，其功能是可以将两个数字进行相减，并返回差值。

```java
public interface Calculator { 
	public abstract int calc(int a, int b); 
}
```

在下面的代码中，请分别使用Lambda的标准格式及省略格式调用 invokeCalc 方法，完成130和120的相减计算： 

```java
public class TestInvokeCalc {
    public static void main(String[] args) {
			//TODO 请分别使用Lambda【标准格式】及【省略格式】调用
 		 	//invokeCalc方法来计算130‐120的结果
    }
    private static void invokeCalc(int a, int b, Calculator calculator) {
        int result = calculator.calc(a, b);
        System.out.println("结果是：" + result);
    }
}
```



----------

答案：

```java

```







# 【Stream】

## 题目4

现在有两个`ArrayList`集合存储队伍当中的多个成员姓名，要求使用Stream流**依次**进行以下若干操作步骤：

1. 第一个队伍只要名字为3个字的成员姓名；
2. 第一个队伍筛选之后只要前3个人；
3. 第二个队伍只要姓张的成员姓名；
4. 第二个队伍筛选之后不要前2个人；
5. 将两个队伍合并为一个队伍；
6. 根据姓名创建`Person`对象；
7. 打印整个队伍的Person对象信息。

两个队伍（集合）的代码如下：

```java
public class DemoArrayListNames {
    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("陈玄风");
        one.add("梅超风");
        one.add("陆乘风");
        one.add("曲灵风");
        one.add("武眠风");
        one.add("冯默风");
        one.add("罗玉风");
        List<String> two = new ArrayList<>();
        two.add("宋远桥");
        two.add("俞莲舟");
        two.add("俞岱岩");
        two.add("张松溪");
        two.add("张翠山");
        two.add("殷梨亭");
        two.add("莫声谷");
		// ....
    }
}
```

而`Person`类的代码为：

```java
public class Person {
    
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```



-------

答案：

```java

```





# 【File】

## 题目5

请完善代码模板中的逻辑，键盘输入文件路径字符串，调用show方法，传入路径字符串（如果这个路径表示的文件实际不存在，则创建文件），输出这个文件的文件名、绝对路径名、父目录、文件大小、后缀名。

代码模板如下：

```java
public class FileTest1{
  public static void main(String[] args){
        //TODO 1.完成键盘录入字符串
		//TODO 2.调用show方法传入字符串
  }
  
  public static void show(String filePath){
    //TODO 3.按题干需求完成功能
  }
  
}
```





-----



答案：

~~~java

~~~





# 【递归】

## 题目6

在你的计算机某一个盘的根目录创建一个文件夹做测试用，里面放置一些含有子文件的文件夹，及一些文件。写程序实现删除非空文件夹。

代码模板

~~~java
public class DiGuiTest02{
  public static void main(String[] args){
    
  }
  
  public static void removeFile(File dir){
    //TODO 实现删除文件夹
    
  }
}
~~~



----

答案：

~~~java

~~~



