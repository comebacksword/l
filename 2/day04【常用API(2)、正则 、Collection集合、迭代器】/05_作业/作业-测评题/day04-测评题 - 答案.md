## 选择题

### 题目1(单选):

**下列关于包装类对应的关系错误的是( C  )**

#### 选项 :

​	A. byte-Byte

​	B. int-Integer

​	C. char-Char

​	D. boolean-Boolean



### 题目2(单选):

**下列关于Arrays类说法错误的是( C )**

#### 选项 :

​	A. Arrays类属于数组工具类 

​	B. Arrays类中排序方法是sort()

​	C. Arrays类中的方法需要创建对象进行调用

​	D. Arrays类中把数组转成字符串的方法是toString()



### 题目3(多选):

**下列关于自动装箱和拆箱正确的是( ABCD  )**

#### 选项 :

​	A. 自动装箱指的是基本数据类型自动转成对应的包装类类型

​	B. 自动拆箱指的是包装类类型自动转成对应的基本数据类型

​	C. Integer i = 10;  // 属于自动装箱

​	D. Int num  = new Integer("100"); // 属于自动拆箱



### 题目4(多选):

**下列关于数组和集合描述正确的是( CD )**

#### 选项 :

​	A. 数组和集合的长度都是可变的

​	B. 数组只能存储基本数据类型,集合只能存储引用数据类型

​	C. 数组的长度固定,集合的长度可变

​	D. 数组可以存储基本数据类型和引用数据类型 , 集合只能存储引用数据类型



### 题目5(单选):

**下列不属于Collection集合中的方法是（D) **

#### 选项 :

​	A. add()

​	B. size()

​	C. remove()

​	D. delete()



### 题目6(单选):

**下列关于Collection集合遍历方式正确的是 ( D )**

#### 选项 :

​	A. 迭代器 , 增强for , 普通for循环

​	B. 迭代器 ,  普通for循环

​	C. 增强for, 普通for循环

​	D. 迭代器 , 增强for



### 题目7(多选):

**下列关于增强for循环说法正确的是 ( ABD )**

#### 选项 :

​	A. 增强for循环可以遍历数组也可以遍历单列集合

​	B. 增强for循环没有索引

​	C. 增强for遍历集合 , 可以通过集合对象修改集合的长度

​	D. 增强for的底层采用的是迭代器



### 题目8(单选):

**下列关于单列集合体系说法错误的是( C )**

#### 选项 :

​	A. List和Set都是属于Collection的子接口

​	B. ArrayList类属于List接口的实现类

​	C. LinkedHashMap类属于Collection接口的实现类

​	D. HashSet类属于Set接口的实现类



### 题目9(单选):

**查看下列代码 , 选出程序正确的执行结果( A )**

```java
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        System.out.println(list);
    }
}
```

#### 选项 :

​	A. [1, 2]

​	B. [2, 3]

​	C. [1, 3]

​	D. [1, 2 , 3]



### 题目10(单选):

**查看下列代码 , 选出程序正确的执行结果( C )**

```java
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove((Integer) 2);
        System.out.println(list);
    }
}
```

#### 选项 :

​	A. [1, 2]

​	B. [2, 3]

​	C. [1, 3]

​	D. [1, 2 , 3]

