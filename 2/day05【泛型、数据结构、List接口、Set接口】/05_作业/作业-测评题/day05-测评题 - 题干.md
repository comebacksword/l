## 选择题

### 题目1(单选):

**查看下列代码,选出正确的传参(   )**

```java
public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Number>  list2 = new ArrayList<Number>();
        ArrayList<Object>  list3 = new ArrayList<Object>();

        show1(__位置1__);
        show2(__位置2__);
    }
  
    public static void show1(ArrayList<? super String> list) {

    }
    public static void show2(ArrayList<? extends Number> list) {

    }
}  
```

#### 选项 :

​	A. 位置1: list2  位置2: list3

​	B. 位置1: list1  位置2: list2

​	C. 位置1: list3  位置2: list1

​	D. 位置1: list1  位置2: list3



### 题目2(单选):

**请选出数组结构和链表结构的特点(   )**

#### 选项 :

​	A. 数组结构查询慢,增删快 ; 链表结构查询快 , 增删慢

​	B. 数组结构查询慢,增删快 ; 链表结构增删快 , 查询慢

​	C. 数组结构查询快,增删慢 ; 链表结构增删快 , 查询慢

​	D. 数组结构查询快,增删慢 ; 链表结构查询快 , 增删慢



### 题目3(单选):

**请选出栈结构和队列结构的特点(  )**

#### 选项 :

​	A. 栈结构先进后出 , 队列结构先进后出

​	B. 栈结构先进先出 , 队列结构先进后出

​	C. 栈结构先进先出 , 队列结构先进先出

​	D. 栈结构先进后出 , 队列结构先进先出



### 题目4(单选):

**下列对于List集合特点说法正确的是（  ) **

#### 选项 :

​	A. 有序 , 无索引 , 元素唯一

​	B. 有序 , 有索引 , 元素可以重复

​	C. 无序 , 无索引 , 元素可以重复

​	D. 无序 , 有索引 , 元素唯一



### 题目5(单选):

**下列对于Set集合特点说法正确的是(  )**

#### 选项 :

​	A. 有序 , 无索引 , 元素可以重复

​	B. 无序 , 无索引 , 元素可以重复

​	C. 无序 , 无索引 , 元素唯一

​	D. 有序 , 有索引, 元素唯一



### 题目6(单选):

**下列对于HashSet集合保证元素唯一需要依赖于什么 ( )**

#### 选项 :

​	A. HashSet集合存储元素所在的类必须重写hashCode和equals方法

​	B. HashSet集合存储元素所在的类必须重写hashCode和toString方法

​	C. HashSet集合存储元素所在的类必须重写hashCode方法

​	D. HashSet集合存储元素所在的类必须重写toString和equals方法



### 题目7(单选):

**下列关于List集合的遍历方式正确的是(  )**

#### 选项 :

​	A. 普通for循环 , 增强for循环

​	B. 增强for循环 , 迭代器

​	C. 普通for, 增强for循环 , 迭代器

​	D. 键找值, 迭代器



### 题目8(单选):

**下列关于Set集合的遍历方式正确的是(  )**

#### 选项 :

​	A. 普通for循环 , 增强for循环

​	B. 增强for循环 , 迭代器

​	C. 键找值 , 增强for循环 , 迭代器

​	D. 键找值, 迭代器



### 题目9(单选):

**下列关于ArrayList和LinkedList的数据结构正确是(  )**

#### 选项 :

​	A. ArrayList属于链表结构 , LinkedList属于队列结构

​	B. ArrayList属于数组结构 , LinkedList属于哈希表结构

​	C. ArrayList属于链表结构 , LinkedList属于数组结构

​	D. ArrayList属于数组结构 , LinkedList属于链表结构



### 题目10(多选):

**下列关于红黑树的规则说法正确的是(  )**

#### 选项 :

​	A. 对每一个节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点

​	B. 根节点必须是黑色

​	C. 不能出现两个黑色节点相连的情况

​	D. 每一个节点或是红色的，或者是黑色的

