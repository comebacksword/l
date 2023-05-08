## 选择题

### 题目1(多选):

**下列关于TreeSet集合排序的原理正确的是 (  ABC  )**

#### 选项 :

​	A. 排序方法如果返回的是小于0 , 代表的是当前元素较小 , 需要存放在左边

​	B. 排序方法如果返回的是大于0 , 代表的是当前元素较大, 需要存放在右边

​	C. 排序此方法如果返回的是0 , 代表的是当前元素在集合中已经存在 , 不存储

​	D. 自然排序和比较器排序的原理是不同的



### 题目2(多选):

**下列属于Collections工具类中的方法有 ( ACD )**

#### 选项 :

​	A. shuffle()  : 对单列集合进行乱序

​	B. remove() : 删除集合中的元素

​	C. sort() : 对单列集合进行排序

​	D. addAll() : 对单列集合批量添加元素



### 题目3(单选):

**下列关于可变参数说法错误的是(  D )**

#### 选项 :

​	A. 可变参数只能作为方法的最后一个参数，但其前面可以有或没有任何其他参数。

​	B. 调用可变参数方法，可以给出零到任意多个参数

​	C. 可变参数本质上是数组，不能作为方法的重载

​	D. 调用可变参数方法 , 不可以传递数组只能传入任意多个参数



### 题目4(单选):

**补全下列冒泡排序的代码,选出最合理的选项（ C ) **

```java
package com.itheima.arraysort_demo.bubblesort_demo;

import java.util.Arrays;

/*
    冒泡排序 : 将一组数据按照从小到大的顺序进行排序
    冒泡排序的原理 : 相邻元素两两作比较 , 大的元素往后放

    需求 : 将数组中的元素 {3,5,2,1,4} 进行升序排序
 */
public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 1, 4};

        for (int j = 0; __位置1__ ; j++) {
            for (int i = 0; __位置2__ ; i++) {
                if (__位置3__) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            System.out.println("第" + (j + 1) + "轮排序:" + Arrays.toString(arr));
        }
    }
}
```

#### 选项 :

​	A. 位置1 : j < arr.length          位置2: i < arr.length - 1 - j   位置3 : arr[i + 1] > arr[i]

​	B. 位置1 : j < arr.length - 1     位置2: i < arr.length - 1  	 位置3 : arr[i] > arr[i + 1]

​	C. 位置1 : j < arr.length - 1     位置2: i < arr.length - 1 - j   位置3 : arr[i] > arr[i + 1]

​	D. 位置1 : j < arr.length          位置2: i < arr.length - 1 - j   位置3 : arr[i] > arr[i + 1]



### 题目5(单选):

**补全下列二分查找的代码,选出最合理的选项 ( C  )**

```java
public class BinarySearchDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int i = binarySearch(arr, 8);
        System.out.println(i);
    }

    public static int binarySearch(int[] arr, int num) {
        int max = arr.length - 1;
        int min = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            
            if (arr[mid] == num) {
               	__位置1__
            } else if (arr[mid] > num) {
                __位置2__
            } else if (arr[mid] < num) {
                __位置3__
            }
        }
        return -1;
    }
}
```

#### 选项 :

​	A. 位置1:return mid;   	 	位置2:max = mid + 1;  	位置3:min = mid + 1;

​	B. 位置1:return arr[mid];    位置2:max = mid - 1;  	 位置3:min = mid + 1;

​	C. 位置1:return mid;   	     位置2:max = mid - 1;  	 位置3:min = mid + 1;

​	D. 位置1:return mid;   	     位置2:max = mid +1; 	  位置3:min = mid - 1;



### 题目6(多选):

**下列对于Map集合的特点说法正确的是 ( BC )**

#### 选项 :

​	A. 所有的双列集合都是无序的

​	B. 键不能重复，值可以重复

​	C. 键和值是 一 一 对应的，通过键可以找到对应的值

​	D. Map集合键可以重复 , 但是值是唯一的



### 题目7(单选):

**下列关于Map集合遍历的方式说法正确的是( A )**

#### 选项 :

​	A. 键找值 , 获取键值对对象在获取键和值

​	B. 迭代器 , 键找值

​	C. 键找值 ,迭代器 , 增强for

​	D. 迭代器, 获取键值对对象在获取键和值 



### 题目8(多选):

**下列对于Map集合方法描述正确的是(  BCD )**

#### 选项 :

​	A. add() : 添加元素

​	B. remove() : 根据键删除元素

​	C. keySet() : 获取键集合

​	D. containKey() : 判断集合是否存在指定的键



### 题目9(单选):

**下列关于Map集合的实现类数据结构说法正确的是( D )**

#### 选项 :

​	A. HashMap集合属于链表结构    , TreeMap集合属于红黑树结构

​	B. LinkedHashMap集合属于链表+哈希表结构 , TreeMap集合属于链表结构

​	C. HashMap集合属于二叉树结构 , TreeMap集合属于哈希表结构

​	D. HashMap集合属于哈希表结构 , TreeMap集合属于红黑树结构



### 题目10(单选):

**下列关于HashMap保证键唯一需要依赖于什么( A )**

#### 选项 :

​	A. 键所在的类需要重写hashCode和equals方法

​	B. 键所在的类需要重写hashCode和toString方法

​	C. 键和值所在的类需要重写hashCode和equals方法

​	D. 键和值所在的类需要重写toString和equals方法

