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



# 【TreeSet】

## 题目1

需求：

利用TreeSet实现以下需求：

1. 随机生成10个不同的0~50之间的整数，要求按照从小到大进行遍历。
2. 随机生成10个不同的50~100之间的整数，要求按照从大到小进行遍历。



思路分析：

TreeSet是具有排序特性的，默认按照自然排序。如果自然排序满足不了需求，可以使用自定义比较器。

需求1，可以使用自然排序实现；需求2可以使用自定义比较器实现



答案：

```java
package com.itheima.homework.test1;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

/*
    需求：
    利用TreeSet实现以下需求：
        1. 随机生成10个不同的0~50之间的整数，要求按照从小到大进行遍历。
        2. 随机生成10个不同的50~100之间的整数，要求按照从大到小进行遍历。

    思路分析：
    TreeSet是具有排序特性的，默认按照自然排序。如果自然排序满足不了需求，可以使用自定义比较器。
    需求1 : 可以使用自然排序实现；
    需求2 : 可以使用自定义比较器实现

 */
public class Test1 {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        Random r = new Random();
        // 1. 随机生成10个不同的0~50之间的整数，要求按照从小到大进行遍历。
        for (int i = 0; i < 10; i++) {
            int number = r.nextInt(51);// 0~50之间的整数
            ts.add(number);// 把随机数添加到集合中
        }
        System.out.println(ts);

        System.out.println("========================");

        TreeSet<Integer> ts2 = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        // 2. 随机生成10个不同的50~100之间的整数，要求按照从大到小进行遍历
        // 1. 随机生成10个不同的0~50之间的整数，要求按照从小到大进行遍历。
        for (int i = 0; i < 10; i++) {
            int number = r.nextInt(51);// 0~50之间的整数
            ts2.add(number);// 把随机数添加到集合中
        }
        System.out.println(ts2);
    }
}

```

打印结果：

```
[1, 4, 7, 10, 19, 28, 31, 47, 48]
========================
[45, 40, 30, 25, 23, 17, 15, 7, 2]
```



# 【Collections】

## 题目2

请定义一个可以存储“整数”的集合，并存储一些数据。

请按以下要求顺序编程实现：

1. 对集合中的数据打乱顺序；
1. 打印集合
1. 对集合中的数据进行升序排序
1. 打印集合
1. 对集合中的数据进行降序排序(要实现排序，不可以倒序遍历实现)
1. 打印集合



答案：

```java
package com.itheima.homework.test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    请定义一个可以存储“整数”的集合，并存储一些数据。

    请按以下要求顺序编程实现：
        1 对集合中的数据打乱顺序；
        2 打印集合
        3 对集合中的数据进行升序排序
        4 打印集合
        5 对集合中的数据进行降序排序(要实现排序，不可以倒序遍历实现)
        6 打印集合


 */
public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        //  1 对集合中的数据打乱顺序
        Collections.shuffle(list);
        System.out.println(list);

        // 2 对集合中的数据进行升序排序
        Collections.sort(list);
        System.out.println(list);

        // 3 对集合中的数据进行降序排序(要实现排序，不可以倒序遍历实现)
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

打印结果：

```java
[20, 40, 10, 30]
[10, 20, 30, 40]
[40, 30, 20, 10]
```



# 【排序，查找】

## 题目3

编程题【冒泡排序】

请按以下要求顺序编写程序：

1. 定义测试类，定义main()方法；
1. 定义以下数组：`int[] arr = {1,2,432,32,54,32,3,7,657,563,25,43,6,463,52};`
1. 用Arrays类打印此数组的所有元素；
1. 用“冒泡排序”对数组元素“升序”排序；打印排序后的数组。

思路：

参考课堂内容

答案：

```java
package com.itheima.homework.test3;

import java.util.Arrays;

/*
    编程题【冒泡排序】
    请按以下要求顺序编写程序：
        1. 定义测试类，定义main()方法；
        2. 定义以下数组：`int[] arr = {1,2,432,32,54,32,3,7,657,563,25,43,6,463,52};`
        3. 用Arrays类打印此数组的所有元素；
        4. 用“冒泡排序”对数组元素“升序”排序；打印排序后的数组。
 */
public class Test3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 432, 32, 54, 32, 3, 7, 657, 563, 25, 43, 6, 463, 52};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {// 控制轮次
            for (int j = 0; j < arr.length - 1 - i; j++) {// 每轮相邻元素比较的次数
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

```



## 题目4

编程题【选择排序】

请按以下要求顺序编写程序：

1. 定义测试类，定义main()方法；
1. 定义以下数组：int[] arr = {7, 6, 5, 4, 3};
1. 用Arrays类打印此数组的所有元素；
1. 用“排序”对数组元素“升序”排序；打印排序后的数组。

答案：

```java
package com.itheima.homework.test4;

import java.util.Arrays;

/*
    请按以下要求顺序编写程序：
        1. 定义测试类，定义main()方法；
        2. 定义以下数组：int[] arr = {7, 6, 5, 4, 3};
        3. 用Arrays类打印此数组的所有元素；
        4. 用“排序”对数组元素“升序”排序；打印排序后的数组。
 */
public class Test4 {
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3};

        // 用Arrays类打印此数组的所有元素
        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;// 记录当前待排序中最小元素的索引

            int min = arr[minIndex];// 当前最小值
            for (int j = i; j < arr.length; j++) {
                // 如果当前待排序中有比当前元素还小的值
                if (arr[j] < min) {
                    // 把当前元素赋值给参照物
                    min = arr[j];
                    // 把当前元素的索引 , 赋值给minIndex
                    minIndex = j;
                }
            }

            // 如果当前元素不是最小值 , 那么和最小值作交换
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}

```





# 【Map集合】

## 题目5

请按以下要求顺序编码：

1. 定义一个：键Integer，值String类型的HashMap集合
1. 存储以下数据：”张三” ,“李四”,“王五”。（put）
1. 打印集合大小；
1. 使用“键找值”的方式遍历集合，打印键和值；(keySet)
1. 使用“键值对”的方式遍历集合，打印键和值；(entrySet)
1. 获取键为1的值，并打印(get)
1. 获取键为10的值，并打印
1. 判断集合中是否有键：10（containsKey）
1. 删除键为1的键值对，删除完毕打印集合



答案：

```java
package com.itheima.homework.test5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
    1. 定义一个：键Integer，值String类型的HashMap集合
    2. 存储以下数据：”张三” ,“李四”,“王五”。（put）
    3. 打印集合大小；
    4. 使用“键找值”的方式遍历集合，打印键和值；(keySet)
    5. 使用“键值对”的方式遍历集合，打印键和值；(entrySet)
    6. 获取键为1的值，并打印(get)
    7. 获取键为10的值，并打印
    8. 判断集合中是否有键：10（containsKey）
    9. 删除键为1的键值对，删除完毕打印集合
 */
public class Test5 {
    public static void main(String[] args) {
        // 1. 定义一个：键Integer，值String类型的HashMap集合
        HashMap<Integer, String> hm = new HashMap<>();
        // 2. 存储以下数据：”张三” ,“李四”,“王五”。（put）
        hm.put(0, "张三");
        hm.put(1, "李四");
        hm.put(2, "王五");
        // 3. 打印集合大小；
        System.out.println(hm.size());

        System.out.println("===================");

        // 4. 使用“键找值”的方式遍历集合，打印键和值；(keySet)
        Set<Integer> set = hm.keySet();
        for (Integer key : set) {
            String value = hm.get(key);
            System.out.println(key + "---" + value);
        }

        System.out.println("===================");

        // 5. 使用“键值对”的方式遍历集合，打印键和值；(entrySet)
        Set<Map.Entry<Integer, String>> set2 = hm.entrySet();
        for (Map.Entry<Integer, String> entry : set2) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "---" + value);
        }

        System.out.println("===================");

        // 6. 获取键为1的值，并打印(get)
        System.out.println(hm.get(1));

        System.out.println("===================");

        // 7. 获取键为10的值，并打印
        System.out.println(hm.get(10));

        System.out.println("===================");

        // 8. 判断集合中是否有键：10（containsKey）
        System.out.println(hm.containsKey(10));

        System.out.println("===================");

        // 9. 删除键为1的键值对，删除完毕打印集合
        System.out.println(hm.remove(1));
        System.out.println(hm);
    }
}

```



打印结果：

```
3
===================
0---张三
1---李四
2---王五
===================
0---张三
1---李四
2---王五
===================
李四
===================
null
===================
false
===================
李四
{0=张三, 2=王五}
```



## 题目6

有以下字符串：

String str = “fje你kw我FDQFj你feAF他Eajf他eo2FA我FEjfew”;

请编程统计每个字符出现的次数



答案：

```java
package com.itheima.homework.test6;

import java.util.HashMap;

/*
    有以下字符串：

    String str = “fje你kw我FDQFj你feAF他Eajf他eo2FA我FEjfew”;

    请编程统计每个字符出现的次数
 */
public class Test6 {
    public static void main(String[] args) {
        String str = "fje你kw我FDQFj你feAF他Eajf他eo2FA我FEjfew";
        // 键存储字符, 值存储字符出现的次数
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            // 拿到字符串中每一个字符
            char ch = str.charAt(i);
            // 存在键为此字符
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {// 不存在
                hm.put(ch, 1);
            }
        }

        System.out.println(hm);
    }
}
```



打印结果：

```
{你=2, A=2, a=1, D=1, e=4, E=2, f=4, F=5, j=4, k=1, o=1, 我=2, Q=1, 2=1, 他=2, w=2}
```



## 题目7

需求：研发部门有5个人，信息如下：（姓名-工资）【柳岩=2100, 张亮=1700, 诸葛亮=1800, 灭绝师太=2600, 东方不败 =3800】,将以上员工的相关信息存放在适合的集合中,给柳岩涨工资300,迭代出每个元素的内容输出到控制台。

思路：

- 使用HashMap存储数据
- 使用put方法进行对新增或者修改数据

答案：

```java
package com.itheima.homework.test7;

import java.util.HashMap;

/*
    需求：研发部门有5个人，信息如下：（姓名-工资） 【柳岩=2100, 张亮=1700, 诸葛亮=1800, 灭绝师太=2600, 东方不败 =3800】
          将以上员工的相关信息存放在适合的集合中,给柳岩涨工资300,迭代出每个元素的内容输出到控制台。
    思路：
    1 使用HashMap存储数据
    2 使用put方法进行对新增或者修改数据
 */
public class Test7 {
    public static void main(String[] args) {
        // 创建集合对象
        HashMap<String, Integer> hm = new HashMap<>();

        // 添加院申诉
        hm.put("柳岩", 2100);
        hm.put("张亮", 1700);
        hm.put("诸葛亮", 1800);
        hm.put("灭绝师太", 2600);
        hm.put("东方不败", 3800);

        // 给柳岩涨工资300
        hm.put("柳岩", hm.get("柳岩") + 3000);

        System.out.println(hm);
    }
}

```



打印结果：

```
{灭绝师太=2600, 张亮=1700, 诸葛亮=1800, 柳岩=5100, 东方不败=3800}
```



## 题目8

需求：使用LinkedHashMap保存学生对象，及其对应的家庭住址；要求：

1. 学生具有学号、姓名和成绩三个属性；
2. 其中，学号不能重复；

思路：

- 要重写hashCode和equals方法，学号不能重复，只要选中学号即可。



步骤：

1. 定义学生类包含学号、姓名和成绩三个属性；
2. 重写hashCode和equals方法，选中学号即可
3. 定义LinkedHashMap对象，键是学生对象，值是地址
4. 创建学生对象存入数据
5. 遍历查看结果

答案：

```java
package com.itheima.homework.test8;

public class Student {
    private String id;
    private String name;
    private int score;

    public Student() {
    }

    public Student(String id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

```

```jav
package com.itheima.homework.test8;

import java.util.LinkedHashMap;

/*
    需求：使用LinkedHashMap保存学生对象，及其对应的家庭住址；要求：
        1. 学生具有学号、姓名和成绩三个属性；
        2. 其中，学号不能重复；

    思路：
        - 要重写hashCode和equals方法，学号不能重复，只要选中学号即可。
 */
public class Test8 {
    public static void main(String[] args) {
        LinkedHashMap<Student, String> linkedHashMap = new LinkedHashMap<>();

        Student s1 = new Student("it001" , "柳岩", 100);
        Student s2 = new Student("it002" , "景甜", 80);
        Student s3 = new Student("it003" , "李沁", 90);

        linkedHashMap.put(s1 , "哈尔滨");
        linkedHashMap.put(s2 , "青岛");
        linkedHashMap.put(s3 , "呼和浩特");

        System.out.println(linkedHashMap);
    }
}

```



打印结果：

张三和李四的学号一样，不能重复存储

```
{Student{id='it001', name='柳岩', score=100}=哈尔滨
Student{id='it002', name='景甜', score=80}=青岛
Student{id='it003', name='李沁', score=90}=呼和浩特}
```



## 题目9

需求：

1.利用键盘录入，输入一个字符串,统计该字符串中各个字符的数量

2.如用户输入字符串:"helloworld java",程序输出结果：h(1)e(1)l(3)o(2) (2)w(1)r(1)d(1)j(1)a(2)v(1)

3.注：输出结果不要求顺序一致



答案：

```java
package com.itheima.homework.test9;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
    1.利用键盘录入，输入一个字符串,统计该字符串中各个字符的数量
    2.如用户输入字符串:"helloworld java",程序输出结果：h(1)e(1)l(3)o(2) (2)w(1)r(1)d(1)j(1)a(2)v(1)
    3.注：输出结果不要求顺序一致
 */
public class Test9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串:");
        String str = sc.nextLine();

        // 键存储字符, 值存储字符出现的次数
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            // 拿到字符串中每一个字符
            char ch = str.charAt(i);
            // 存在键为此字符
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) + 1);
            } else {// 不存在
                hm.put(ch, 1);
            }
        }

        // System.out.println(hm);
        // 创建sb对象
        StringBuilder sb = new StringBuilder();
        // 获取集合中所有的键
        Set<Character> set = hm.keySet();
        for (Character key : set) {
            Integer value = hm.get(key);
            // 按照指定的格式作拼接
            sb.append(key).append("(").append(value).append(")");
        }

        // 打印sb中内容
        System.out.println(sb);
    }
}

```



打印结果：

```
请输入一个字符串:
abcacbacabcba
a(5)b(4)c(4)
```



# 【集合嵌套】

## 题目10

需求：一个年级有若干个班级，每个班级有若干个学生；要求：

1. 学生具有学号、姓名和成绩，学号和学生信息是一一对应的；
2. 使用集合保存这个年级的所有学生的信息，然后遍历输出；



思路：

- 班级：Map<Integer,Student> 键：学号，值：学生对象
- 年级：List<Map<Integer,Student>> 使用List集合将每个班级保存



答案：

```java
package com.itheima.homework.test10;

import java.util.*;

/*
    需求：一个年级有若干个班级，每个班级有若干个学生；要求：
    1. 学生具有学号、姓名和成绩，学号和学生信息是一一对应的；
    2. 使用集合保存这个年级的所有学生的信息，然后遍历输出；

    思路：
    - 班级：Map<Integer,Student> 键：学号，值：学生对象
    - 年级：List<Map<Integer,Student>> 使用List集合将每个班级保存
 */
public class Test10 {
    public static void main(String[] args) {
        // 创建年级集合
        List<Map<Integer, Student>> list = new ArrayList<>();

        // 创建第一个班级
        Map<Integer, Student> classNumber1 = new HashMap<>();
        classNumber1.put(111, new Student("张三"));
        classNumber1.put(222, new Student("李四"));
        classNumber1.put(333, new Student("王五"));

        // 创建第二个班级
        Map<Integer, Student> classNumber2 = new HashMap<>();
        classNumber2.put(444, new Student("赵六"));
        classNumber2.put(555, new Student("钱⑦"));

        // 把班级添加到年级中
        list.add(classNumber1);
        list.add(classNumber2);

        for (Map<Integer, Student> classNumbers : list) {
            Set<Integer> set = classNumbers.keySet();
            for (Integer id : set) {
                Student student = classNumbers.get(id);
                System.out.println(id + "---" + student);
            }

            System.out.println("==============");
        }
    }
}

```



打印结果：

```java
333---Student{name='王五'}
222---Student{name='李四'}
111---Student{name='张三'}
==============
555---Student{name='钱⑦'}
444---Student{name='赵六'}
==============
```

