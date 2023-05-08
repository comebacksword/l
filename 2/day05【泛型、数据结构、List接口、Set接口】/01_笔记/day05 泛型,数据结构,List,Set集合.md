# day05 泛型,数据结构,List,Set

## 今日目标 

- ##### 泛型使用

- ##### 数据结构 

- ##### List

- ##### Set

## 1  泛型

### 1.1  泛型的介绍

- 泛型是一种类型参数，专门用来保存类型用的
  - 最早接触泛型是在ArrayList<E>，这个E就是所谓的泛型了。使用ArrayList时，只要给E指定某一个类型，里面所有用到泛型的地方都会被指定对应的类型

### 1.2 使用泛型的好处

- 不用泛型带来的问题
  - 集合若不指定泛型，默认就是Object。存储的元素类型自动提升为Object类型。获取元素时得到的都是Object，若要调用特有方法需要转型，给我们编程带来麻烦.
- 使用泛型带来的好处
  - 可以在编译时就对类型做判断，避免不必要的类型转换操作，精简代码，也避免了因为类型转换导致的代码异常

```java
 //泛型没有指定类型，默认就是Object
ArrayList list = new ArrayList();
list.add("Hello");
list.add("World");
list.add(100);
list.add(false);
//集合中的数据就比较混乱，会给获取数据带来麻烦
for (Object obj : list) {
    String str = (String) obj;
    //当遍历到非String类型数据，就会报异常出错
    System.out.println(str + "长度为：" + str.length());
}
```

### 1.3 泛型的注意事项 

- 泛型在代码运行时，泛型会被擦除。后面学习反射的时候，可以实现在代码运行的过程中添加其他类型的数据到集合

  - 泛型只在编译时期限定数据的类型 , 在运行时期会被擦除

  

### 1.4 自定义泛型类

- 当一个类定义其属性的时候，不确定具体是什么类型时，就可以使用泛型表示该属性的类型

- ##### 定义的格式

  - 在类型名后面加上一对尖括号，里面定义泛型。一般使用一个英文大写字母表示，如果有多个泛型使用逗号分隔
  - public class 类名<泛型名>{ ... }

  ```java
  举例 : 
  public class Student<X,Y>{  
      X  xObj; 
  } 
  ```

- ##### 泛型的确定

  - 当创建此泛型类是 , 确定泛型类中泛型的具体数据类型

- ##### 练习

```java
package com.itheima.genericity_demo.genericity_class;

import java.time.Period;

/*
    需求 : 定义一个人类，定义一个属性表示爱好，但是具体爱好是什么不清楚，可能是游泳，乒乓，篮球。
 */
public class GenericityDemo {
    public static void main(String[] args) {
        Person<BasketBall> person = new Person<>();
        person.setHobby(new BasketBall());

        Person<Swim> person2 = new Person<>();
        person2.setHobby(new Swim());

        Person person3 = new Person<>();// 如果没有指定泛型 , 那么默认使用Object数据类型
    }
}

class Person<H> {
    // 定义属性表达爱好
    private H hobby;


    public H getHobby() {
        return hobby;
    }

    public void setHobby(H hobby) {
        this.hobby = hobby;
    }
}

class Swim {
}

class PingPang {
}

class BasketBall {
}
```

### 1.3 自定义泛型接口

- 当定义接口时，内部方法中其参数类型，返回值类型不确定时，就可以使用泛型替代了。

- ##### 定义泛型接口

  - 在接口后面加一对尖括号 , 尖括号中定义泛型 , 一般使用大写字母表示, 多个泛型用逗号分隔
  - public interface<泛型名> {  ... }
  - 举例 :

  ```java
  public interface Collection<E>{
  	public boolean add(E e);
  } 
  
  ```

- ##### 泛型的确定

  - 实现类去指定泛型接口的泛型
  - 实现了不去指定泛型接口的泛型 , 进行延续泛型 , 回到泛型类的使用

```java
package com.itheima.genericity_demo.genericity_interface;
/*
    需求:
    模拟一个Collection接口，表示集合，集合操作的数据不确定。
    定义一个接口MyCollection具体表示。

 */
// 泛型接口
public interface MyCollection<E> {
    // 添加功能
    public abstract void add(E e);
    // 删除功能
    public abstract void remove(E e);
}

// 指定泛型的第一种方式 : 让实现类去指定接口的泛型
class MyCollectionImpl1 implements MyCollection<String>{
    @Override
    public void add(String s) {

    }
    @Override
    public void remove(String s) {

    }
}
// 指定泛型的第二种方式 : 实现类不确定泛型,延续泛型,回到泛型类的使用
class MyCollectionImpl2<E> implements MyCollection<E>{

    @Override
    public void add(E a) {

    }

    @Override
    public void remove(E a) {

    }
}
```

### 1.4 自定义泛型方法 

- 当定义方法时，方法中参数类型，返回值类型不确定时，就可以使用泛型替代了

- ##### 泛型方法的定义

  - 可以在方法的返回值类型前定义泛型
  - 格式 : public  <泛型名> 返回值类型  方法名(参数列表){ ... }
  - 举例 : public <T> void show(T t) { ... }

- ##### 泛型的确定 

  - 当调用一个泛型方法 , 传入的参数是什么类型, 那么泛型就会被确定

- ##### 练习 

  ```java
  package com.itheima.genericity_demo.genericity_method;
  
  import java.util.ArrayList;
  import java.util.Arrays;
  
  public class Test {
      public static void main(String[] args) {
          // Collection集合中 : public <T> T[] toArray(T[] a) : 把集合中的内容存储到一个数组中 , 进行返回
          ArrayList<String> list = new ArrayList<>();
          list.add("abc");
          list.add("ads");
          list.add("qwe");
          String[] array = list.toArray(new String[list.size()]);
          System.out.println(Arrays.toString(array));
      }
  
      // 接收一个集合 , 往集合中添加三个待指定类型的元素
      public static <X> void addElement(ArrayList<X> list, X x1, X x2, X x3) {
          list.add(x1);
          list.add(x2);
          list.add(x3);
      }
  }
  ```

### 1.5 通配符

- 当我们对泛型的类型确定不了，而是表达的可以是任意类型，可以使用泛型通配符给定

  符号就是一个问号：?  表示任意类型，用来给泛型指定的一种通配值。如下

```java
public static void shuffle(List<?> list){
   //…
} 

说明：该方法时来自工具类Collections中的一个方法，用来对存储任意类型数据的List集合进行乱序
```

- 泛型通配符结合集合使用

  - 泛型通配符搭配集合使用一般在方法的参数中比较常见。在集合中泛型是不支持多态的，如果为了匹配任意类型，我们就会使用泛型通配符了。
  - 方法中的参数是一个集合,集合如果携带了通配符，要特别注意如下
    - 集合的类型会提升为Object类型
    - 方法中的参数是一个集合,集合如果携带了通配符,那么此集合不能进行添加和修改操作 , 可以删除和获取

  ```java
  package com.itheima.genericity_demo;
  
  
  import java.util.ArrayList;
  import java.util.List;
  
  public class Demo {
      public static void main(String[] args) {
          ArrayList<String> list = new ArrayList<>();
          list.add("abc");
          list.add("asd");
          list.add("qwe");
          // 方法的参数是一个集合 , 集合的泛型是一个通配符 , 可以接受任意类型元素的集合
          show(list);
      }
  
      public static void show(List<?> list) {
          // 如果集合的泛型是一个通配符 , 那么集合中元素以Object类型存在
          Object o = list.get(0);
  
          // 如果集合的泛型是一个通配符 , 那么此集合不能进行添加和修改操作 , 可以删除和获取
          // list.add(??);
  
          // 删除可以
          list.remove(0);
          // 获取元素可以
          for (Object o1 : list) {
              System.out.println(o1);
          }
      }
  }
  ```

  ```java
  package com.itheima.genericity_demo;
  
  import java.util.ArrayList;
  
  /*
      已知存在继承体系：Integer继承Number，Number继承Object。
      定义一个方法，方法的参数是一个ArrayList。
      要求可以接收ArrayList<Integer>,ArrayList<Number>,ArrayList<Object>,ArrayList<String>这些类型的数据。
  
      结论 : 具体类型的集合,不支持多态 , 要想接收任意类型集合 , 需要使通配符集合
   */
  public class Test1 {
      public static void main(String[] args) {
          ArrayList<Integer> list1 = new ArrayList<>();
          ArrayList<Number> list2 = new ArrayList<>();
          ArrayList<String> list3 = new ArrayList<>();
          ArrayList<Object> list4 = new ArrayList<>();
  
          useList5(list1);
          useList5(list2);
          useList5(list3);
          useList5(list4);
      }
  
      // 此方法只能接收存储Integer类型数据的集合
      public static void useList1(ArrayList<Integer> list) {
  
      }
  
      // 此方法只能接收存储Number类型数据的集合
      public static void useList2(ArrayList<Number> list) {
  
      }
  
      // 此方法只能接收存储String类型数据的集合
      public static void useList3(ArrayList<String> list) {
  
      }
  
      // 此方法只能接收存储Object类型数据的集合
      public static void useList4(ArrayList<Object> list) {
  
      }
  
      public static void useList5(ArrayList<?> list) {
  
      }
  
  }
  ```

### 1.6 受限泛型

- 受限泛型是指，在使用通配符的过程中 , 对泛型做了约束，给泛型指定类型时，只能是某个类型父类型或者子类型

- 分类 : 

  - 泛型的下限 : 
    - <? super 类型>         //只能是某一类型，及其父类型，其他类型不支持
  - 泛型的上限 : 
    - <? extends 类型>     //只能是某一个类型，及其子类型，其他类型不支持

  ```java
  package com.itheima.genericity_demo.wildcard_demo;
  
  import java.util.ArrayList;
  
  /*
    wildcardCharacter
  
    基于上一个知识点，定义方法
      show1方法，参数只接收元素类型是Number或者其父类型的集合
      show2方法，参数只接收元素类型是Number或者其子类型的集合
  
   */
  public class Test2 {
      public static void main(String[] args) {
          ArrayList<Integer> list1 = new ArrayList<>();
          ArrayList<Number> list2 = new ArrayList<>();
          ArrayList<Object> list3 = new ArrayList<>();
  
          show1(list3);
          show1(list2);
  
          show2(list2);
          show2(list1);
      }
      // 此方法可以接受集合中存储的是Number或者Number的父类型 , 下限泛型
      public static void show1(ArrayList<? super Number> list) {
  
      }
      // 此方法可以接受集合中存储的是Number或者Number的子类型 , 上限泛型
      public static void show2(ArrayList<? extends Number> list) {
  
      }
  }
  ```

## 2 数据结构

- 栈结构 : 先进后出

- 队列结构 : 先进先出

- 数组结构 : 查询快 , 增删慢

- 链表结构 : 查询慢 , 增删快

- 二叉树

  - 二叉树 : 每个节点最多有两个子节点

  - 二茬查找树 : 每个节点的左子节点比当前节点小 , 右子节点比当前节点大

  - 二茬平衡树 : 在查找树的基础上, 每个节点左右子树的高度不超过1 

  - 红黑树 : 

    - 每一个节点或是红色的，或者是黑色的

    - 根节点必须是黑色

    - 如果一个节点没有子节点或者父节点，则该节点相应的指针属性值为Nil，这些Nil视为叶节点，每个叶节点(Nil)是黑色的

    - 不能出现两个红色节点相连的情况

    - 对每一个节点，从该节点到其所有后代叶节点的简单路径上，均包含相同数目的黑色节点

    - 添加元素 : 

      ![image-20210405235529852](D:\传智播客\上海-JavaSE进阶面授\day05【泛型，数据结构，List接口，Set接口】\笔记\img\image-20210405235529852.png)

- 哈希表结构 : 

  - 哈希值：是JDK根据对象的地址或者字符串或者数字算出来的int类型的数值
  - Object类中有一个方法可以获取对象的哈希值
    public int hashCode()：返回对象的哈希码值
  - 对象的哈希值特点
    - 同一个对象多次调用hashCode()方法返回的哈希值是相同的
    - 默认情况下，不同对象的哈希值是不同的。而重写hashCode()方法，可以实现让不同对象的哈希值相同

## 3 List集合

- List集合是Collection集合子类型，继承了所有Collection中功能，同时List增加了带索引的功能

- ##### 特点 : 

  - 元素的存取是有序的【有序】
  - 元素具备索引 【有索引】
  - 元素可以重复存储【可重复】

- ##### 常见的子类 

  - ArrayList：底层结构就是数组【查询快，增删慢】
  - Vector：底层结构也是数组（线程安全，同步安全的，低效，用的就少)
  - LinkedList：底层是链表结构（双向链表）【查询慢，增删快】

- #####  List中常用的方法

  - public void add(int index, E element): 将指定的元素，添加到该集合中的指定位置上。
  - public E get(int index):返回集合中指定位置的元素
  - public E remove(int index): 移除列表中指定位置的元素, 返回的是被移除的元素。\
  - public E set(int index, E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素

- ##### LinkedList类 

  - LinkedList底层结构是双向链表。每个节点有三个部分的数据，一个是保存元素数据，一个是保存前一个节点的地址，一个是保存后一个节点的地址。可以双向查询，效率会比单向链表高。
  - LinkedList特有方法
    - public void addFirst(E e):将指定元素插入此列表的开头。
    - public void addLast(E e):将指定元素添加到此列表的结尾。
    - public E getFirst():返回此列表的第一个元素。
    - public E getLast():返回此列表的最后一个元素。
    - public E removeFirst():移除并返回此列表的第一个元素。
    - public E removeLast():移除并返回此列表的最后一个元素。

## 4 Set集合

- Set集合也是Collection集合的子类型，没有特有方法。Set比Collection定义更严谨
- 特点 : 
  - 元素不能保证插入和取出顺序（无序）
  - 元素是没有索引的(无索引)
  - 元素唯一(元素唯一)
- Set常用子类
  - HashSet：底层由HashMap，底层结构哈希表结构。
    去重，无索引，无序。
    哈希表结构的集合，操作效率会非常高。
  - LinkedHashSet:底层结构链表加哈希表结构。
    具有哈希表表结构的特点，也具有链表的特点。
  - TreeSet：底层是有TreeMap，底层数据结构 红黑树。
    去重，让存入的元素具有排序（升序排序）

