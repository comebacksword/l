## day10

学习目标：

 * 掌握ArrayList集合的使用

### 1.ArrayList入门

#### 1.1 ArrayList概述

```java
/*
ArrayList:
    包结构：
        java.util.ArrayList
        public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
    描述：
        可调整大小的数组
    构造方法：
        ArrayList() 构造一个初始容量为十的空列表。
        ArrayList(int initialCapacity) 构造具有指定初始容量的空列表。
    常用方法：
        boolean add(E e) 指定的元素追加到此列表的末尾。
        void add(int index, E element) 在此列表中的指定位置插入指定的元素。
        E get(int index) 返回此列表中指定位置的元素。
        int size() 返回此列表中的元素数。
 */

import java.util.ArrayList;

public class Demo01 {
    public static void main(String[] args) {
        //ArrayList() 构造一个初始容量为十的空列表。
        ArrayList arrayList = new ArrayList();
        System.out.println(arrayList);
        //ArrayList(int initialCapacity) 构造具有指定初始容量的空列表。
        ArrayList list = new ArrayList(20);
        System.out.println(list);
        //boolean add(E e) 指定的元素追加到此列表的末尾。
        arrayList.add("张三");
        arrayList.add(100);
        arrayList.add(true);
        arrayList.add('a');
        arrayList.add(3.14);
        System.out.println(arrayList);

        int [] arr = new int[10];
        //泛型 用来约束集合中存储数据的数据类型 格式：类名<数据类型>
        ArrayList<String> lists = new ArrayList<>();
        lists.add("张三");
        /*lists.add(100);
        lists.add(true);
        lists.add('a');
        lists.add(3.14);*/
        lists.add("李四");
        lists.add("王二麻子");
        lists.add("赵六");
        lists.add("田七");
        lists.add("老八");
        lists.add("老幺0");
        lists.add("老幺1");
        lists.add("老幺2");
        System.out.println(lists);
        //void add(int index, E element) 在此列表中的指定位置插入指定的元素。
        lists.add(2,"思帅");
        System.out.println(lists);

        //E get(int index) 返回此列表中指定位置的元素。
        String s1 = lists.get(0);
        System.out.println(s1);
        System.out.println("----------");
        //获取集合中所有的元素 底层是数组，是数组就有索引，就是从0开始，到最大元素数量减一
        for (int i = 0; i < 8; i++) {
            String s = lists.get(i);
            System.out.println(s);
        }
        //求集合中存储元素的个数
//        int size() 返回此列表中的元素数。
        int size = lists.size();
        System.out.println(size);

        //遍历集合通用方法
        for (int i = 0; i < lists.size(); i++) {
            String s = lists.get(i);
            System.out.println(s);
        }


    }
}

```

#### 1.2 ArrayList集合存储数据的特点：

```java
/*
    ArrayList集合存储数据的特点：
        有序可可重复;

 */
public class Demo02 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");
        list.add("张三5");
        list.add("张三6");
        list.add("张三1");
        list.add("张三2");
        list.add("张三3");
        list.add("张三4");
        list.add("张三5");
        list.add("张三6");
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }
}
```

#### 1.3 ArrayList集合存储学生对象

```java
import java.util.ArrayList;

/*
    list集合存Student对象并遍历获取每一个学生的姓名和年龄
    步骤：
        1.创建集合对象
        2.创建学生对象
        3.把学生对象添加到集合中
        4.遍历集合获取学生对象，使用学生getXxx获取学的信息 输出到控制台
 */
public class Demo03 {
    public static void main(String[] args) {
        // 创建集合对象
        ArrayList<Student> students = new ArrayList<>();
        // 创建学生对象
        Student stu1 = new Student("张三", 18);
        Student stu2 = new Student("李四", 19);
        Student stu3 = new Student("王五", 20);
        Student stu4 = new Student("赵六", 21);
        Student stu5 = new Student("田七", 22);
        Student stu6 = new Student("老八", 23);
        // 把学生对象添加到集合中
        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);
        students.add(stu5);
        students.add(stu6);
        //4.遍历集合获取学生对象，使用学生getXxx获取学的信息 输出到控制台
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            //使用学生getXxx获取学的信息 输出到控制台
            System.out.println(student.getName()+"..."+student.getAge());
        }
        //5.求集合中所有 人的年龄和
        int sum = 0;
        for (int i = 0; i < students.size(); i++) {
            /*Student student = students.get(i);
            int age = student.getAge();
            sum+=age;*/
            sum+=students.get(i).getAge();
        }
    }
}

```

```java
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
}

```

### 2.Test

```java
//测试类，创建三个学生对象，存入Arraylist集合，之后遍历list集合，求出三个学生的平均成绩
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        //实例化三个Student对象
        Student s1 = new Student("小黑", 88);
        Student s2 = new Student("小马", 92);
        Student s3 = new Student("小智", 75);
        //创建一个ArrayList集合，这个集合里面存储的是Student类型，分别将上面的三个Student对象添加到集合中
//        ______________2________________
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        int sum = 0;
        //遍历Arraylist集合，获取每个学生的成绩并求和
//        ______________3________________  TODO
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getScore();
        }

        //求学生的平均成绩
        double avg = sum / 3;
        System.out.println("三个学生成绩的平均值为：" + avg);
    }
}
```

```java
public class Student {
//成员属性，满参构造方法
//______________1________________
	private String name;
	private int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	//2个属性的get/set方法
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

}

```

### 3.ArrayList常用方法

#### 3.1 ArrayList常用方法

```java
import java.util.ArrayList;
import java.util.Iterator;

/*
    boolean isEmpty() 如果此列表不包含元素，则返回 true 。
    Iterator<E> iterator() 以正确的顺序返回该列表中的元素的迭代器。
    E remove(int index) 删除该列表中指定位置的元素。
    boolean remove(Object o) 从列表中删除指定元素的第一个出现（如果存在）。
    E set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
 */
public class Demo01 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        //boolean isEmpty() 如果此列表不包含元素，则返回 true 。
        System.out.println(list.isEmpty());
        list.add("张三");
        /*String s = printList(list);
        System.out.println(s);*/
        list.add("李四");
        list.add("张三");
        list.add("王五");
        list.add("张三");

        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }*/
        //E remove(int index) 删除该列表中指定位置的元素。根据索引 删除指定元素，返回被删除的元素
//        String s = list.remove(0);
//        System.out.println(s);
//        System.out.println(list);
        //boolean remove(Object o) 从列表中删除指定元素的第一个出现（如果存在）。
        /*boolean b = list.remove("张三");
        System.out.println(b);
        System.out.println(list);*/
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals("张三")){
                list.remove("张三");
                break;
            }
        }
        System.out.println(list);

        //E set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
        String s = list.set(0, "李小四");
        System.out.println(s);
        System.out.println(list); //李小四
        System.out.println(list);

    }
    public static String printList(ArrayList<String> list){
        boolean empty = list.isEmpty();
        if (empty){
            return null;
        }else {
            return list.toString();
        }

    }
}

```



#### 3.2常用方法小结

```java
/*
        常用方法小结：
            boolean add(E e) 将指定的元素追加到此列表的末尾。
            void add(int index, E element) 在此列表中的指定位置插入指定的元素。
            int size() 返回此列表中的元素数。
            E get(int index) 返回此列表中指定位置的元素。
            Iterator<E> iterator() 以正确的顺序返回该列表中的元素的迭代器。
            E remove(int index) 删除该列表中指定位置的元素。
            boolean remove(Object o) 从列表中删除指定元素的第一个出现（如果存在）。
            E set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
 */
public class Demo02List小结 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        // boolean add(E e) 将指定的元素追加到此列表的末尾。
        list.add("思帅");
        list.add("杨涌");
        list.add("刘毅");
        list.add("高海谦");
        list.add("张宇");
        list.add("家豪");
        list.add("陶铖");
        list.add("赵宇飞");
        list.add("胡坷屹");
        System.out.println(list);
        list.add(1,"张三");
        list.add(5,"张三");
        list.add(7,"张三");
        list.add(8,"张三");
        list.add(11,"张三");
        list.add(12,"张三");
        System.out.println(list);
        //int size() 返回此列表中的元素数
        int size = list.size();
        System.out.println(size);

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            //E get(int index) 返回此列表中指定位置的元素。
            String s = list.get(i);
            System.out.println(s);
        }
        //迭代器 了解
        // Iterator<E> iterator() 以正确的顺序返回该列表中的元素的迭代器。
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println("------------");
        //E remove(int index) 删除该列表中指定位置的元素。
        //删除集合中的张三
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("张三")){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
        //E set(int index, E element) 用指定的元素替换此列表中指定位置的元素。
        list.set(5,"李家豪");
        System.out.println(list);


    }
}

```

#### 3.3小练习

```java
import java.util.ArrayList;
import java.util.Scanner;

/*
    使用ArrayList集合存储5学生对象【学号 姓名 性别 年龄 居住地址 考试成绩】
    筛选出成绩大于90学生，求男生成绩的平均值  || 筛选出成绩大于90学生，求女生成绩的平均值

    学生对象的创建需要键盘录入学生信息创建学生对象，提示：学号不能重复,可以定义方法判断学号不重复

    //1.创建学生类
    //2.测试类中
        创建集合对象，在添加学生对象到集合中之前，判断学号是否可用
        筛选 成绩大于90并且是男生 学生平均成绩
        筛选 成绩大于90并且是女生 学生平均成绩


 */
public class Demo03 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<Student> list = new ArrayList<>();
        //添加学生对象到集合中
        for (int i = 0; i < 5; i++) {
            Student student = createStudentObject(list);
            list.add(student);
        }
        System.out.println(list);
        //筛选 成绩大于90并且是男生 学生平均成绩
        double sumBoy = 0.0;
        int countBoy = 0;
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getGender().equals("男")&&stu.getScore()>90){
                sumBoy+=stu.getScore();
                countBoy++;
            }
        }
        double avgBoy = sumBoy/countBoy;
        System.out.println("成绩大于90并且是男生 学生平均成绩:"+avgBoy+"分");

        //筛选 成绩大于90并且是女生 学生平均成绩
        double sumGirl = 0.0;
        int countGirl = 0;

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (stu.getGender().equals("女") && stu.getScore()>90){
                sumGirl+=stu.getScore();
                countGirl++;
            }
        }
        double avgGirl = sumGirl/countGirl;
        System.out.println("成绩大于90并且是女生 学生平均成绩:"+avgGirl+"分");




    }

    public static Student createStudentObject(ArrayList<Student> list){
        Scanner sc = new Scanner(System.in);
        String id = null;
        while (true) {
            System.out.println("请输入学号：");
            id = sc.next();
            boolean flag = isExistingStudentID(list,id);
            if (flag){
                break;
            }else {
                System.out.println("您录入的学号已存在，请重新输入！");
            }
        }


        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入性别：");
        String gender = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("请输入地址：");
        String address = sc.next();
        System.out.println("请输入成绩：");
        double score = sc.nextDouble();
        Student student = new Student(id,name,gender,age,address,score);
        return student;
    }
    //判断学号是否在集合中存在，如果存在返回false 说明学号已存在不可以在使用 如果不存在返回true，说明学号可以使用
    private static boolean isExistingStudentID(ArrayList<Stdent> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId().equals(id)){
                return false;
            }
        }
        return true;
    }
}
```

```java
public class Student {
    private String id;
    private String name;
    private String gender;
    private int age;
    private String address;
    private double score;

    public Student() {
    }

    public Student(String id, String name, String gender, int age, String address, double score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.score = score;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
```

### 4.模拟购物车

```java
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        ArrayList<Item> shopCartList = new ArrayList<>();
        //键盘录入
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("1 添加商品");
            System.out.println("2 删除商品");
            System.out.println("3 修改购买数量");
            System.out.println("4 展示购物车");
            System.out.println("请输入你的操作：");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    System.out.println("添加商品");
                    addItem(shopCartList,sc);
                    break;
                case 2:
                    System.out.println("删除商品");
                    break;
                case 3:
                    System.out.println("修改购买数量");
                    break;
                case 4:
                    System.out.println("展示购物车");
                    showItemInfo(shopCartList);
                    break;
                default:
                    System.out.println("您输入有误！");

            }
        }
    }

    private static void showItemInfo(ArrayList<Item> shopCartList) {
        if (shopCartList.isEmpty()){
            System.out.println("购物车为空，请添加后查看");
            return;
        }
        System.out.println("========");
        for (int i = 0; i < shopCartList.size(); i++) {
            Item item = shopCartList.get(i);
            System.out.println(item.getId()+"\t"+item.getName()+"\t"+item.getDescription()+"\t"+item.getPrice()+"\t"+item.getCount());
        }

    }

    private static void addItem(ArrayList<Item> shopCartList,Scanner sc) {

        String id = null;
        while (true) {
            System.out.println("请输入商品的id:");
            id = sc.next();
            //判断商品的id是否存在在购物车中 如果不存
            int index = isExistingItemid(shopCartList,id);
            if (index == -1){
                break;
            }else { //利用购物车中存在的商品的索引，更新商品数量
                System.out.println("商品已在购物车中");
                Item item = shopCartList.get(index);
                int count = item.getCount();
//                int i = sc.nextInt();
                item.setCount(count+1);
                return;
                //shopCartList.get(index).setCount(shopCartList.get(index).getCount()+1);
            }
        }
        System.out.println("请输入商品的名称:");
        String name = sc.next();
        System.out.println("请输入商品的描述:");
        String description = sc.next();
        System.out.println("请输入商品的价格:");
        double price = sc.nextDouble();
        System.out.println("请输入商品的数量:");
        int count = sc.nextInt();
        Item item = new Item(id,name,description,price,count);
        shopCartList.add(item);
        System.out.println("添加成功");


    }
    //判断商品id 是否在集合中存在 如果存在返回，id对应商品对象，在集合中的索引，如果不存在返回值 -1
    private static int isExistingItemid(ArrayList<Item> shopCartList, String id) {
        for (int i = 0; i < shopCartList.size(); i++) {
            Item item = shopCartList.get(i);
            if (item.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
```

```java
public class Item {
    private String id;
    private String name;
    private String description;
    private double price;
    private int count;

    public Item() {
    }

    public Item(String id, String name, String description, double price, int count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

```













