

# day06-排序查找算法,Map集合,集合嵌套,斗地主案例

## 今日目标 :

- ##### TreeSet集合(重点)

- ##### 排序算法(理解)

- ##### 查找算法(理解)

- ##### Map集合(重点)

- ##### 集合嵌套(理解)

- ##### 斗地主案例(理解)

## 1 TreeSet集合

### 1.1 集合体系 

- Collection

  - List接口

    - ArrayList类
    - LinkedList类

  - Set接口

    - HashSet集合

    - ##### TreeSet集合

### 1.2 TreeSet特点 

- 不包含重复元素的集合[元素唯一]
- 没有带索引的方法[无索引]
- 可以按照指定的规则进行排序[可以排序]

### 1.3 TreeSet集合的练习

```java
package com.itheima.treeset_demo;

import java.util.Iterator;
import java.util.TreeSet;

/*
      1 TreeSet集合练习
            存储Integer类型的整数，并遍历
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(10);
        ts.add(10);
        ts.add(20);
        ts.add(10);
        ts.add(30);

        // 迭代器
        Iterator<Integer> it = ts.iterator();
        while(it.hasNext()){
            Integer s = it.next();
            System.out.println(s);
        }

        System.out.println("================");

        // 增强for
        for (Integer t : ts) {
            System.out.println(t);
        }
    }
}

```

- 如果TreeSet存储自定义对象 , 需要对自定义类进行指定排序规则 

  下列代码没有指定排序规则 , 所以运行会报出错误

```java
package com.itheima.treeset_demo;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
=============================================================
    
    
package com.itheima.treeset_demo;

import java.util.Iterator;
import java.util.TreeSet;

/*
      TreeSet集合练习
         存储学生对象，并遍历

 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();

        Student s1 = new Student("dilireba", 19);
        Student s2 = new Student("gulinazha", 20);
        Student s3 = new Student("maerzhaha", 18);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);

        System.out.println(ts);
    }
}

```



### 1.4 排序规则 

#### 1.4.1 自然排序

- ##### 使用步骤 
  - 使用空参构造创建TreeSet集合对象
  - 存储元素所在的类需要实现Comparable接口
  - 重写Comparable接口中的抽象方法 compareTo方法,指定排序规则

- ##### compareTo方法如何指定排序规则 : 

  - 此方法如果返回的是小于0 , 代表的是当前元素较小 , 需要存放在左边
  - 此方法如果返回的是大于0 , 代表的是当前元素较大, 需要存放在右边
  - 此方法如果返回的是0 , 代表的是当前元素在集合中已经存在 , 不存储

- ##### 练习 : 存储学生对象, 按照年龄的升序排序，并遍历

  ```java
  package com.itheima.treeset_demo;
  
  public class Student implements Comparable<Student>{
      private String name;
      private int age;
  
      public Student() {
      }
  
      public Student(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public int getAge() {
          return age;
      }
  
      public void setAge(int age) {
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  
      /*
  
       */
      @Override
      public int compareTo(Student o) {
          /*
              this : 当前要添加的元素
              o    : 集合中已经存在的元素
  
              如果方法返回值为负数 : 当前元素放左边
              如果方法的返回值为正数  : 当前元素放右边
              如果方法的返回值为0  : 说明当前元素在集合中存在,不存储
           */
          int result = this.age - o.age;
          return result;
      }
  }
  =====================================================
      
  package com.itheima.treeset_demo;
  import java.util.Iterator;
  import java.util.TreeSet;
  
  /*
        TreeSet集合练习
           存储学生对象，并遍历
  
   */
  public class TreeSetDemo2 {
      public static void main(String[] args) {
          TreeSet<Student> ts = new TreeSet<>();
  
          Student s1 = new Student("dilireba", 19);
          Student s2 = new Student("gulinazha", 20);
          Student s3 = new Student("maerzhaha", 18);
  
          ts.add(s1);
          ts.add(s2);
          ts.add(s3);
  
          System.out.println(ts);
      }
  }
  ```

  - ##### 对刚才的案例进行改进 , 如果年龄相等 , 那么对学生的名字在字典的顺序排序

  ```java
  package com.itheima.treeset_demo;
  
  public class Student implements Comparable<Student> {
      private String name;
      private int age;
  
      public Student() {
      }
  
      public Student(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public int getAge() {
          return age;
      }
  
      public void setAge(int age) {
          this.age = age;
      }
  
      @Override
      public String toString() {
          return "Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  
      /*
  
       */
      @Override
      public int compareTo(Student o) {
          /*
              this : 当前要添加的元素
              o    : 集合中已经存在的元素
  
              如果方法返回值为负数 : 当前元素放左边
              如果方法的返回值为正数  : 当前元素放右边
              如果方法的返回值为0  : 说明当前元素在集合中存在,不存储
           */
          int result = this.age - o.age;
          // 如果年龄相等 , 那么按照名字进行排序
          return result == 0 ? this.name.compareTo(o.name) : age;
      }
  }
  
  =============================================================
      
      
  package com.itheima.treeset_demo;
  
  import java.util.Iterator;
  import java.util.TreeSet;
  
  /*
        TreeSet集合练习
           存储学生对象, 按照年龄的升序排序，并遍历
  
   */
  public class TreeSetDemo2 {
      public static void main(String[] args) {
          TreeSet<Student> ts = new TreeSet<>();
  
          Student s1 = new Student("dilireba", 19);
          Student s2 = new Student("gulinazha", 20);
          Student s3 = new Student("maerzhaha", 18);
          Student s4 = new Student("ouyangnanan", 18);
  
          ts.add(s1);
          ts.add(s2);
          ts.add(s3);
          ts.add(s4);
  
          System.out.println(ts);
      }
  }
  
  ```

  

#### 1.4.2 比较器排序

- ##### 使用步骤

  - TreeSet的带参构造方法使用的是  “比较器排序” 对元素进行排序的
  - 比较器排序，就是让TreeSet集合构造方法接收Comparator接口的实现类对象
  - 重写Comparator接口中的 compare(T o1,T o2)方法 , 指定排序规则
  - 注意 : o1代表的是当前往集合中添加的元素 , o2代表的是集合中已经存在的元素,排序原理与自然排序相同!

- ##### 排序规则

  - 排序原理与自然排序相同!

- ##### 练习

```java
package com.itheima.treeset_demo.comparator_demo;

public class Teacher  {
    private String name;
    private int age;

    public Teacher() {
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
======================================
    
package com.itheima.treeset_demo.comparator_demo;

import java.util.Comparator;
import java.util.TreeSet;

/*
      TreeSet集合练习
         存储学生对象, 按照年龄的升序排序，并遍历

 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet<Teacher> ts = new TreeSet<>(new ComparatorImpl());

        Teacher s1 = new Teacher("dilireba", 19);
        Teacher s2 = new Teacher("gulinazha", 20);
        Teacher s3 = new Teacher("maerzhaha", 18);
        Teacher s4 = new Teacher("ouyangnanan", 18);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);

        System.out.println(ts);
    }
}

// 比较器排序
class ComparatorImpl implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        int result = o1.getAge() - o2.getAge();
        return result == 0 ? o1.getName().compareTo(o2.getName()) : result;
    }
}
```

#### 1.4.3 两种排序的区别

- 自然排序：自定义类实现Comparable接口，重写compareTo方法，根据返回值进行排序。
- 比较器排序：创建TreeSet对象的时候传递Comparator的实现类对象，重写compare方法，根据返回值进行排序。
- 如果Java提供好的类已经定义了自然排序排序规则 , 那么我们可以使用比较器排序进行替换 
- 注意 : 如果自然排序和比较器排序都存在 , 那么会使用比较器排序

- 两种方式中，关于返回值的规则：
  - 如果返回值为负数，表示当前存入的元素是较小值，存左边
  - 如果返回值为0，表示当前存入的元素跟集合中元素重复了，不存
  - 如果返回值为正数，表示当前存入的元素是较大值，存右边

## 2 Collections单列集合工具类

- Collections工具类介绍
  - java.util.Collections 是集合的工具类，里面提供了静态方法来操作集合，乱序，排序....

### 2.1 shuffle方法

- public static void shuffle(List<?> list) 对集合中的元素进行打乱顺序。

- 集合中元素类型可以任意类型

  ```java
  package com.itheima.collections_demo;
  
  import java.util.ArrayList;
  import java.util.Collections;
  
  /*
      Collections类 : 操作单列集合的工具类
          public static void shuffle(List<?> list) 对集合中的元素进行打乱顺序
          1 乱序只能对List集合进行乱序
          2 集合中元素类型可以任意类型
  
          需求 : 定义一个List集合，里面存储若干整数。对集合进行乱序
   */
  public class ShuffleDemo {
      public static void main(String[] args) {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(10);
          list.add(30);
          list.add(50);
          list.add(40);
          list.add(20);
  
          Collections.shuffle(list);
  
          System.out.println(list);// 打印集合中的元素
      }
  }
  
  ```

### 2.2 sort方法

- public static <T extends Comparable> void sort (List<T> list): 对集合中的元素自然排序

  - 该方法只能对List集合进行排序
  - 从方法中泛型分析可知，集合中元素类型必须是Comparable的子类型

  ```java
  package com.itheima.collections_demo;
  
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.Comparator;
  
  /*
      Collections类 : 单列集合的工具类
          sort方法是一个重载的方法，可以实现自然排序及比较器排序。
          要特别注意的是sort方法只能对List集合进行排序，方法如下：
  
          public static <T extends Comparable> void sort (List<T> list)
  
          练习：定义List集合，存储若干整数，进行排序
   */
  public class SortDemo1 {
      public static void main(String[] args) {
          ArrayList<Integer> list = new ArrayList<>();
          list.add(3);
          list.add(2);
          list.add(4);
          list.add(1);
  
          // 使用此方法 , 需要集合中存储的元素实现Comparable接口
          Collections.sort(list);
  
          System.out.println(list);
      }
  }
  ```

  

- public static <T> void  sort (List<T> list, Comparator<? super T> c)

  - 方法只能对List集合排序

  - 对元素的类型没有要求

  - 需要定义一个比较器Comparator （规则和之前TreeSet时一样）

  - 使用场景：

    -  List集合中的元素类型不具备自然排序能力（元素类型没有实现结果 Comparable）
    -  List集合中的元素类型具备自然排序能力，但是排序规则不是当前所需要的。

    ```java
    package com.itheima.collections_demo;
    
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    
    /*
        Collections类 : 单列集合的工具类
            sort方法是一个重载的方法，可以实现自然排序及比较器排序。
            要特别注意的是sort方法只能对List集合进行排序，方法如下：
    
            public static <T extends Comparable> void sort (List<T> list) : 只能对集合中的元素自然排序
    
            需求1：定义一个List集合，存储若干整数，要求对集合进行降序排序
            分析：整数类型Integer具备自然排序能力，但是题目要求降序排序
    
            需求2：定义一个学生类，属性有姓名，年龄。创建若干对象放到List集合中。要求对List集合中学生对象进行年龄的升序排序。
            分析：自定义类型默认是没有自然排序能力的，我们使用自定义比较器方式排序。
    
    
     */
    public class SortDemo2 {
        public static void main(String[] args) {
    
            /*
                需求2：定义一个学生类，属性有姓名，年龄。创建若干对象放到List集合中。要求对List集合中学生对象进行年龄的升序排序。
                分析：自定义类型默认是没有自然排序能力的，我们使用自定义比较器方式排序
            */
            ArrayList<Student> list = new ArrayList<>();
            list.add(new Student("lisi", 24));
            list.add(new Student("zhangsan", 23));
    
            Collections.sort(list, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.getAge() - o2.getAge();
                }
            });
            System.out.println(list);
        }
    
        /*
            需求1：定义一个List集合，存储若干整数，要求对集合进行降序排序
            分析：整数类型Integer具备自然排序能力，但是题目要求降序排序
         */
        private static void method1() {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(3);
            list.add(2);
            list.add(4);
            list.add(1);
    
            // 使用此方法 , 需要集合中存储的元素实现Comparable接口
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
    
            System.out.println(list);
        }
    }
    ```

## 3 可变参数

### 3.1 可变参数介绍

- 在 JDK5 中提供了可变参数，允许在调用方法时传入任意个参数。可变参数原理就是一个数组形式存在
- 格式 : 修饰符 返回值类型 方法名(数据类型… 变量名) {  }
- 举例 : public void show(int ... num) : 表达式该方法可以接收任意个整数值 , 原理 : 其实就是一个int类型的数组

### 3.2 可变参数注意

- 可变参数只能作为方法的最后一个参数，但其前面可以有或没有任何其他参数。
- 可变参数本质上是数组，不能作为方法的重载。如果同时出现相同类型的数组和可变参数方法，是不能编译通过的。

### 3.3 可变参数的使用

- 调用可变参数方法，可以给出零到任意多个参数，编译器会将可变参数转化为一个数组，也可以直接传递一个数组。
  方法内部使用时直接当做数组使用即可

```java
package com.itheima.changevariable_demo;

/*
    1 什么是可变参数
        JDK5中,允许在调用方法时传入任意个参数。可变参数原理就是一个数组形式存在
        格式 : 修饰符 返回值类型 方法名(数据类型… 变量名) {  }
        举例 : public void show(int... num){}

    2 可变参数注意 :
        1) 可变参数只能作为方法的最后一个参数，但其前面可以有或没有任何其他参数。
        2) 可变参数本质上是数组，不能作为方法的重载。如果同时出现相同类型的数组和可变参数方法，是不能编译通过的。

    3 可变参数的使用 :
        调用可变参数的方法 , 可以传入0个到任意个数据 , 编译器会将可变参数转换成一个数组 , 也可以直接传递一个数组
        方法中把可变参数当做一个数组去使用即可


    练习：定义方法可以求任意个整数的和

 */
public class VariableDemo1 {
    public static void main(String[] args) {
        sum();
        sum(1, 2);
        sum(1, 2, 3, 4);
    }
    
    public static void sum(int... num) {// 方法的参数是一个int类型的可变参数
        int sum = 0;// 定义求和变量
        for (int i : num) {
            sum += i;
        }
        System.out.println(sum);
    }
}

```

### 3.4 addAll方法

- static <T> boolean  addAll(Collection<? super T> c , T... elements) : 添加任意多个数据到集合中

  -  该方法就是一个含有可变参数的方法，使用时可以传入任意多个实参，实用方便！

  - 分析 : Collection<? super T> , ? 可以是 T 的类型或者父类型 , 反过来 , T是?类型或者子类型

    那么当你确定?的类型,也就是集合的类型 , 就可以往集合中添加此类型或者子类型 

  ```java
  package com.itheima.changevariable_demo;
  
  import java.util.ArrayList;
  import java.util.Collections;
  
  /*
      Collections的addAll方法
          static <T> boolean  addAll(Collection<? super T> c , T... elements) : 添加任意多个数据到集合中
          分析： 该方法就是一个含有可变参数的方法，使用时可以传入任意多个实参，实用方便！
  
          练习：创建一个List集合，使用addAll方法传入若干字符串
  
   */
  public class VariableDemo2 {
      public static void main(String[] args) {
          ArrayList<Integer> list = new ArrayList<>();
          Collections.addAll(list, 10, 20, 30, 40);
          System.out.println(list);// [10, 20, 30, 40]
      }
  }
  
  ```

  

## 4 排序,查找算法

### 4.1 冒泡排序

- 冒泡排序 : 将一组数据按照从小到大的顺序进行排序
- 冒泡排序原理 : 相邻元素两两作比较 , 大的元素往后放

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

//        // 第一轮排序
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] > arr[i + 1]) {
//                int temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//            }
//        }
//
//        System.out.println("第一轮排序:" + Arrays.toString(arr));
//
//
//        // 第二轮排序
//        for (int i = 0; i < arr.length - 2; i++) {
//            if (arr[i] > arr[i + 1]) {
//                int temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//            }
//        }
//
//        System.out.println("第二轮排序:" + Arrays.toString(arr));
//
//
//        // 第三轮排序
//        for (int i = 0; i < arr.length - 2; i++) {
//            if (arr[i] > arr[i + 1]) {
//                int temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//            }
//        }
//
//        System.out.println("第三轮排序:" + Arrays.toString(arr));
//
//
//        // 第四轮排序
//        for (int i = 0; i < arr.length - 2; i++) {
//            if (arr[i] > arr[i + 1]) {
//                int temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//            }
//        }
//
//        System.out.println("第四轮排序:" + Arrays.toString(arr));

		// 优化代码
        for (int j = 0; j < arr.length - 1; j++) {// 比较的轮次
            // 每轮相邻元素比较的次数
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
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

### 4.2 选择排序

- 选择排序原理 : 它的工作原理是每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。以此类推，直到全部待排序的数据元素排完。
- 注意事项 : 
  - 有n个元素，那么就要比较n-1轮次。
  - 每一趟中都会选出一个最值元素，较前一趟少比较一次

```java
package com.itheima.arraysort_demo.selectionsort_demo;
/*
    选择排序工作原理 :
        它的工作原理是每一次从待排序的数据元素中选出最小的一个元素，
        存放在序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
        以此类推，直到全部待排序的数据元素排完。

    注意 :
        1 有n个元素，那么就要比较n-1趟。
        2 每一趟中都会选出一个最值元素，较前一趟少比较一次
 */

import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, 2};

        // 遍历数组
        for (int i = 0; i < arr.length - 1; i++) {
            // 记录当前元素和其之后所有元素的最小值索引
            int minIndex = i;

            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j; //  把当前最小值的索引赋值给minIndex
                    min = arr[j];// 替换最小值
                }
            }

            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

```



### 4.3 二分查找

- 原理 : 每次去掉一般的查找范围
- 前提 : 数组必须有序

```java
package com.itheima.arraysort_demo.binarysearch_demo;

/*
    二分查找 :
        原理 : 每次去掉一般的查找范围
        前提 : 数组必须有序
        步骤 :
            1，定义两个变量，表示要查找的范围。默认min = 0 ， max = 最大索引
            2，循环查找，但是min <= max
            3，计算出mid的值
            4，判断mid位置的元素是否为要查找的元素，如果是直接返回对应索引
            5，如果要查找的值在mid的左半边，那么min值不变，max = mid -1.继续下次循环查找
            6，如果要查找的值在mid的右半边，那么max值不变，min = mid + 1.继续下次循环查找
            7，当 min > max 时，表示要查找的元素在数组中不存在，返回-1.
 */
public class BinarySearchDemo {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int i = binarySearch(arr, 8);
        System.out.println(i);

    }

    public static int binarySearch(int[] arr, int num) {
        // 定义两个变量，表示要查找的范围。默认min = 0 ， max = 最大索引
        int max = arr.length - 1;
        int min = 0;

        // 2，循环查找，但是min <= max
        while (min <= max) {
            // 3，计算出mid的值
            int mid = (min + max) / 2;

            if (arr[mid] == num) {
                //  4，判断mid位置的元素是否为要查找的元素，如果是直接返回对应索引
                return mid;
            } else if (arr[mid] > num) {
                // 5，如果要查找的值在mid的左半边，那么min值不变，max = mid -1.继续下次循环查找
                max = mid - 1;
            } else if (arr[mid] < num) {
                // 6，如果要查找的值在mid的右半边，那么max值不变，min = mid + 1.继续下次循环查找
                min = mid + 1;
            }
        }

        return -1;
    }
}

```

## 5 Map集合

### 5.1 Map集合的介绍

- java.util.Map<K,V> 集合，里面保存的数据是成对存在的，称之为双列集合。存储的数据，我们称为键值对。 之前所学的Collection集合中元素单个单个存在的，称为单列集合

### 5.2 特点

- Map<K,V>   K：键的数据类型；V：值的数据类型

- 特点 : 
  - 键不能重复，值可以重复
  - 键和值是 一 一 对应的，通过键可以找到对应的值
  - （键 + 值） 一起是一个整体 我们称之为“键值对” 或者  “键值对对象”，在Java中叫做“Entry对象”
- 使用场景 
  - 凡是要表示一一对应的数据时就可以Map集合
    - 举例 : 学生的学号和姓名  ---  (itheima001	小智)
    - 举例 : 夫妻的关系 ---- (王宝强	马蓉 )     (谢霆锋	张柏芝) 

### 5.3 常用实现类

- HashMap：
  - 此前的HashSet底层实现就是HashMap完成的，HashSet保存的元素其实就是HashMap集合中保存的键，底层结构是哈希表结构，具有键唯一，无序，特点。
- LinkedHashMap：
  - 底层结构是有链表和哈希表结构，去重，有序
- TreeMap：
  - 底层是有红黑树，去重，通过键排序

### 5.4 常用的方法

- public V put(K key, V value):  把指定的键与指定的值添加到Map集合中。
-  public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
-  public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
- public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中。
-  public boolean containKey(Object key):判断该集合中是否有此键。

```java
package com.itheima.map_demo.mapmethod_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    Map中常用方法 :
        public V put(K key, V value):  把指定的键与指定的值添加到Map集合中
        public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值
        public V get(Object key) 根据指定的键，在Map集合中获取对应的值
        public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中
        public boolean containKey(Object key): 判断该集合中是否有此键。

     需求 : 将以下数据保存到Map集合中 , 进行测试以上方法
        “文章“       "马伊琍
        “谢霆锋”     “王菲”
        “李亚鹏”     “王菲”

 */
public class MapDemo {
    public static void main(String[] args) {
        //  创建双列集合对象
        Map<String, String> hm = new HashMap<>();

        // 添加元素
        // public V put(K key, V value):  把指定的键与指定的值添加到Map集合中
        hm.put("文章", "马伊琍");
        hm.put("谢霆锋", "王菲");
        hm.put("李亚鹏", "王菲");

        // public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值
        // System.out.println(hm.remove("谢霆锋"));

        // public V get(Object key) 根据指定的键，在Map集合中获取对应的值
        // System.out.println(hm.get("李亚鹏"));

        // public Set<K> keySet(): 获取Map集合中所有的键，存储到Set集合中
//        Set<String> set = hm.keySet();
//        for (String key : set) {
//            System.out.println(key);
//        }

        // public boolean containKey(Object key): 判断该集合中是否有此键。
        // System.out.println(hm.containsKey("李亚鹏"));

        System.out.println(hm);// 打印集合 , 打印的是集合中的元素
    }
}

```

### 5.5 Map集合的遍历 

- ##### 第一种方式 : 键找值

  ```java
  package com.itheima.map_demo.map_test;
  ```

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    创建Map集合对象 , 往集合中添加以下四对元素 , 使用键找值遍历集合

    周瑜 -- 小乔
    孙策 -- 大乔
    刘备 -- 孙尚香
    诸葛亮 -- 黄月英

 */
public class MapTest1 {
    public static void main(String[] args) {
        // 创建集合对象
        Map<String, String> hm = new HashMap<>();

        // 添加元素
        hm.put("周瑜", "小乔");
        hm.put("孙策", "大乔");
        hm.put("刘备", "孙尚香");
        hm.put("诸葛亮", "黄月英");
    
        // 获取健集合
        Set<String> set = hm.keySet();
        
        // 遍历健集合 , 通过键找值
        for (String key : set) {
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }
    }
}

  ```

- 第二种方式  : 获取键值对对象 , 在找到键和值

​```java
package com.itheima.map_demo.map_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    需求 :  创建Map集合对象 , 往集合中添加以下三对元素
            使用获取Entry对象集合,在找到键和值 遍历集合

        张无忌 -- 赵敏
        张翠山 -- 殷素素
        张三丰 -- 郭芙

 */
public class MapTest2 {
    public static void main(String[] args) {
        // 创建集合对象
        Map<String, String> hm = new HashMap<>();

        // 添加元素
        hm.put("张无忌", "赵敏");
        hm.put("张翠山", "殷素素");
        hm.put("张三丰", "郭芙");

        // 获取键值对对象集合
        Set<Map.Entry<String, String>> set = hm.entrySet();

        // 遍历键值对对象集合 , 获取每一个键值对对象
        for (Map.Entry<String, String> entry : set) {
            // 通过entry对象获取键
            String key = entry.getKey();
            // 通过entry对象获取值
            String value = entry.getValue();
            System.out.println(key + "--" + value);
        }
    }
}

  ```

### 5.6 HashMap集合

- 注意 : HashMap集合 , 要想保证键唯一 , 那么键所在的类必须重写hashCode和equals方法

```java
package com.itheima.map_demo.map_test;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

```

```java
package com.itheima.map_demo.map_test;
import java.util.HashMap;
import java.util.Set;

/*
    HashMap类 :
        存储数据，每位学生（姓名，年龄）都有自己的家庭住址。
        学生和地址有对应关系，将学生对象和家庭住址存储到map集合中。学生作为键, 家庭住址作为值。
        要求：学生姓名相同并且年龄相同视为同一名学生，不能重复存储
 */
public class HashMapTest {
    public static void main(String[] args) {
        // 学生作为键, 家庭住址作为值。
        HashMap<Student, String> hm = new HashMap<>();

        hm.put(new Student("迪丽热巴", 18) , "新疆");
        hm.put(new Student("迪丽热巴", 18) , "中国");

        Set<Student> set = hm.keySet();
        for (Student key : set) {
            String value = hm.get(key);
            System.out.println(key + "--" + value);
        }
    }
}

```

### 5.7 LinkedHashMap集合

- LinkedHashMap类 , 在最底层采用的数据结构 : 是链表+哈希表。
- 特点 : 
  - 元素唯一
  - 元素有序

```java
package com.itheima.map_demo.map_test;

import java.util.LinkedHashMap;
import java.util.Set;

/*
    LinkedHashMap类 , 在最底层采用的数据结构 : 是链表+哈希表。
    特点 :
        1 元素唯一
        2 有序

    需求 : 创建LinkedHashMap对象 , 添加元素进行验证 元素唯一 , 有序的特点
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        // 创建集合对象
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1, "张三");
        linkedHashMap.put(1, "李四");
        linkedHashMap.put(2, "王五");
        linkedHashMap.put(3, "赵六");

        System.out.println(linkedHashMap);
    }
}

```

### 5.8 TreeMap集合

- TreeMap的底层是红黑树实现的，有排序的能力，键去重。

- 可以自然排序（键所在的类要实现Comparable）
- 若自定义类没有自然排序功能，或自然排序功能不满足要求时。可以自定义比较器排序（Comparator）

```java
package com.itheima.map_demo.map_test;
import java.util.TreeMap;

/*
    需求 :
        定义TreeMap集合存储键值对，键使用Integer，值使用String，存储若干键值对，遍历集合观察结果是否有排序。
 */
public class TreeMapTest1 {
    public static void main(String[] args) {
        //  定义TreeMap集合存储键值对，键使用Integer，值使用String
        // 创建集合对象
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(1, "张三");
        treeMap.put(3, "赵六");
        treeMap.put(2, "王五");

        System.out.println(treeMap);
    }
}

```

```java
package com.itheima.map_demo.map_test;

import java.util.Comparator;
import java.util.TreeMap;

/*
    需求：创建一个TreeMap集合，键是学生对象(Student)，值是籍贯(String)。
    学生属性姓名和年龄, 要求按照年龄进行升序排序并遍历
 */
public class TreeMapTest2 {
    public static void main(String[] args) {
        // 学生作为键, 家庭住址作为值。
        TreeMap<Student, String> tm = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        tm.put(new Student("迪丽热巴", 18), "新疆");
        tm.put(new Student("迪丽热巴", 16), "中国");

        System.out.println(tm);
    }
}

```



## 6 集合嵌套

### 6.1 List嵌套List

```java
package com.itheima.Collection_nested_demo;

import java.util.ArrayList;
import java.util.List;

/*
    使用场景举例：一年级有多个班级，每个班级有多名学生。要求保存每个班级的学生姓名，保存一个年级所有的班级信息

    思路：
    可以使用List集合保存一个班级的学生
    可以使用List集合保存所有班级

    因此我们可以定义集合如下：
    班级：List<String>
        举例 :
            List<String> 三年一班 = {迪丽热巴 , 古力娜扎 ,马尔扎哈 ,欧阳娜娜}
            List<String> 三年二班 = {李小璐 , 白百何 , 马蓉}
            List<String> 三年三班 = {林丹 ,文章, 陈赫}

    年级：List<List<String>>
        举例 :
            List<List<String>> 年级 = {三年一班 , 三年二班 , 三年三班}
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> 三年一班 = new ArrayList<>();
        三年一班.add("迪丽热巴");
        三年一班.add("古力娜扎");
        三年一班.add("马尔扎哈");
        三年一班.add("欧阳娜娜");

        List<String> 三年二班 = new ArrayList<>();
        三年二班.add("李小璐");
        三年二班.add("白百何");
        三年二班.add("马蓉");

        List<String> 三年三班 = new ArrayList<>();
        三年三班.add("林丹");
        三年三班.add("文章");
        三年三班.add("陈赫");

        List<List<String>> 年级 = new ArrayList<>();
        年级.add(三年一班);
        年级.add(三年二班);
        年级.add(三年三班);

        for (List<String> 班级 : 年级) {
            for (String name : 班级) {
                System.out.println(name);
            }
            System.out.println("-----------------");
        }
    }
}

```

### 6.2 List嵌套Map

```java
package com.itheima.Collection_nested_demo;

import java.util.*;

/*
    List嵌套Map :

    使用场景举例：一年级有多个班级，每个班级有多名学生。要求保存每个班级的学生姓名，姓名有与之对应的学号，保存一年级所有的班级信息。

    思路：
        1 可以使用Map集合保存一个班级的学生（键是学号，值是名字）
        2 可以使用List集合保存所有班级

    因此我们可以定义集合如下：

    班级：Map<String,String> 键是学号，值是姓名
        举例 :
            Map<String,String> 三年一班 = {it001 = 迪丽热巴 , it002 = 古力娜扎 ,it003 = 马尔扎哈 ,it004 = 欧阳娜娜}
            Map<String,String> 三年二班 = {it001 = 李小璐 , it002 = 白百何 , it003 = 马蓉}
            Map<String,String> 三年三班 = {it001 = 林丹 ,it002 = 文章, it003 = 陈赫}

    年级：List<Map<String,String>>保存每个班级的信息
        举例 :
              List<Map<String,String>> 年级 = {三年一班 , 三年二班 , 三年三班}
 */
public class Test2 {
    public static void main(String[] args) {
        Map<String, String> 三年一班 = new HashMap<>();
        三年一班.put("it001", "迪丽热巴");
        三年一班.put("it002", "古力娜扎");
        三年一班.put("it003", "马尔扎哈");
        三年一班.put("it004", "欧阳娜娜");


        Map<String, String> 三年二班 = new HashMap<>();
        三年二班.put("it001", "李小璐");
        三年二班.put("it002", "白百何");
        三年二班.put("it003", "马蓉");

        Map<String, String> 三年三班 = new HashMap<>();
        三年三班.put("it001", "林丹");
        三年三班.put("it002", "文章");
        三年三班.put("it003", "陈赫");


        List<Map<String, String>> 年级 = new ArrayList<>();
        年级.add(三年一班);
        年级.add(三年二班);
        年级.add(三年三班);

        for (Map<String, String> 班级 : 年级) {
            Set<String> studentId = 班级.keySet();
            for (String id : studentId) {
                String name = 班级.get(id);
                System.out.println(id + "---" + name);
            }
            System.out.println("=================");
        }
    }
}

```

### 6.3 Map嵌套Map

```java
package com.itheima.Collection_nested_demo;

import java.util.*;

/*
    Map嵌套Map

    使用场景举例：一个年级有多个班级，每个班级有多名学生。要求保存每个班级的学生姓名，姓名有与之对应的学号，保存一年级所有的班级信息，班级有与之对应的班级名称。

    思路：
    可以使用Map集合保存一个班级的学生（键是学号，值是名字）

    可以使用Map集合保存所有班级（键是班级名称，值是班级集合信息）

    因此我们可以定义集合如下：
    班级： Map<String,String> 键：学号，值：姓名
        举例 :
            Map<String,String> 三年一班 = {it001 = 迪丽热巴 , it002 = 古力娜扎 ,it003 = 马尔扎哈 ,it004 = 欧阳娜娜}
            Map<String,String> 三年二班 = {it001 = 李小璐 , it002 = 白百何 , it003 = 马蓉}
            Map<String,String> 三年三班 = {it001 = 林丹 ,it002 = 文章, it003 = 陈赫}

    年级： Map<String , Map<String,String>> 键：班级名称，值：具体班级信息
        举例:
            Map<String, Map<String,String>> 年级 = {"三年一班" = 三年一班 , "三年二班" = 三年二班 , "三年三班" = 三年三班 }

 */
public class Test3 {
    public static void main(String[] args) {

        Map<String, String> 三年一班 = new HashMap<>();
        三年一班.put("it001", "迪丽热巴");
        三年一班.put("it002", "古力娜扎");
        三年一班.put("it003", "马尔扎哈");
        三年一班.put("it004", "欧阳娜娜");


        Map<String, String> 三年二班 = new HashMap<>();
        三年二班.put("it001", "李小璐");
        三年二班.put("it002", "白百何");
        三年二班.put("it003", "马蓉");

        Map<String, String> 三年三班 = new HashMap<>();
        三年三班.put("it001", "林丹");
        三年三班.put("it002", "文章");
        三年三班.put("it003", "陈赫");


        Map<String, Map<String, String>> 年级 = new HashMap<>();
        年级.put("三年一班", 三年一班);
        年级.put("三年二班", 三年二班);
        年级.put("三年三班", 三年三班);

        Set<String> 班级名字集合 = 年级.keySet();

        for (String 班级名字 : 班级名字集合) {
            Map<String, String> 班级信息 = 年级.get(班级名字);
            Set<String> 学生学号 = 班级信息.keySet();
            for (String 学号 : 学生学号) {
                String 姓名 = 班级信息.get(学号);
                System.out.println("班级名字:" + 班级名字 + " ,学号:" + 学号 + " , 名字:" + 姓名);
            }
            System.out.println("============");
        }

    }
}

```



## 7 斗地主案例

```java
package com.itheima.doudizhu;

import java.util.*;

/*
    按照斗地主的规则，完成洗牌发牌的动作。
    要求完成以下功能：
    准备牌：组装54张扑克牌
    洗牌：54张牌顺序打乱
    发牌：三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
    看牌：查看三人各自手中的牌（按照牌的大小排序）、底牌

    规则：手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3

 */
public class DouDiZhu {
    public static void main(String[] args) {
        // 准备牌
        // 键我牌的序号 , 值为牌面
        HashMap<Integer, String> pokers = new HashMap<>();

        // 牌的颜色
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        int count = 2;
        for (String number : numbers) {// 3
            for (String color : colors) {
                // System.out.println(count + " = " + color + number);
                pokers.put(count, color + number);
                count++;
            }
        }
        pokers.put(0, "大王");
        pokers.put(1, "小王");

        System.out.println(pokers);

        // 洗牌
        Set<Integer> set = pokers.keySet();
        // 创建存储编号的list集合
        List<Integer> list = new ArrayList<>();// {10 , 6 , 8 , 20 , 22 , 11 ... }
        // 把set集合中的元素存储到list集合中
        list.addAll(set);
        // 打乱集合中编号
        Collections.shuffle(list);
        System.out.println(list);

        // 发牌
        TreeSet<Integer> 赌神 = new TreeSet<>();
        TreeSet<Integer> 赌圣 = new TreeSet<>();
        TreeSet<Integer> 赌侠 = new TreeSet<>();
        TreeSet<Integer> 底牌 = new TreeSet<>();
        // 遍历牌的编号
        for (int i = 0; i < list.size() - 3; i++) {
            if (i % 3 == 0) {
                赌神.add(list.get(i));
            } else if (i % 3 == 1) {
                赌圣.add(list.get(i));
            } else {
                赌侠.add(list.get(i));
            }
        }

        底牌.add(list.get(51));
        底牌.add(list.get(52));
        底牌.add(list.get(53));
        System.out.println("赌神:" + 赌神);
        System.out.println("赌圣:" + 赌圣);
        System.out.println("赌侠:" + 赌侠);
        System.out.println("底牌:" + 底牌);


        // 看牌
        // 赌神
        lookPoker(pokers, 赌神, "赌神:  ");

        // 赌圣
        lookPoker(pokers, 赌圣, "赌圣:  ");

        // 赌侠
        lookPoker(pokers, 赌侠, "赌侠:  ");

        // 底牌
        System.out.print("底牌:  ");
        for (Integer integer : 底牌) {
            String poker = pokers.get(integer);
            System.out.print(poker + "\t");
        }

    }

    private static void lookPoker(HashMap<Integer, String> pokers, TreeSet<Integer> 赌神, String s) {
        System.out.print(s);
        for (Integer integer : 赌神) {
            String poker = pokers.get(integer);
            System.out.print(poker + "\t");
        }
        System.out.println();
    }
}

```



