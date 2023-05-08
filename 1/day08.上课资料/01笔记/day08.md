## day08

学习目标：

 *  了解什么是面向对象

     * 面向过程编程
     * 面向对象编程

 * 了解什么是类 什么是对象

 * 掌握类的定义

    * 属性  成员变量
    * 行为  成员方法

 * 掌握对象创建

    * new 
    * 构造方法
       * 格式
       * 特点

 * 熟悉成员变量和成员方法定义和使用

* 成员变量和局部变量的区别

* 熟悉对象内存图

* 掌握封装特性和优点

  ​

### 1.面向对象的入门

#### 1.面向对象和面向过程的区别

```java
面向过程：是一种以过程为中心的编程思想，实现功能的每一步，都是自己实现的
面向对象：是一种以对象为中心的编程思想，通过指挥对象实现具体的功能

面向对象思想小结：
  可观存在的任何一种事物，都可以看做为程序中的对象
  使用面向对象思想可以将复杂的问题简单化
  将我们从执行者的位置，变成了指挥者
```

#### 1.2什么是类

```java
类是对现实生活中一类具有共同属性和行为的事物的抽象
【类】是对事物，也就是对象的一种描述， 根据类去创建对象
```

#### 1.3类的组成

```java
属性
该事物的各种特征
	例如黑马学生事物的属性：姓名、年龄、毕业院校…
行为
该事物存在的功能（能够做的事情）
	例如黑马学生事物行为：学习、Java编程开发
```

#### 1.4类的定义和对象的使用

##### 1.4.1类的创建

```java
/*
    public class 类名 {
          // 成员变量
          变量1的数据类型 变量1；
          变量2的数据类型 变量2;
          …
           // 成员方法
          方法1;
          方法2;
}

 */
public class Student {
    //成员变量 属性
    String name;
    int age;
    //成员方法 行为
    public void study(){
        System.out.println("GOOD GOOD STUDY DAY DAY UP");
    }
}
```

##### 1.4.2 对象的创建和使用

```java
/*
    创建对象
        格式：类名 对象名 = new 类名();
        范例：Student s = new Student();
    使用对象
        1：使用成员变量
        格式：对象名.变量名
        范例：p.name
        2：使用成员方法
        格式：对象名.方法名()
        范例：p.study();
 */
public class Test01Student {
    public static void main(String[] args) {
        Student stu = new Student();
        System.out.println(stu); //com.itheima.Student@776ec8df
        /*
        com.itheima.Student@776ec8df
        com.itheima.Student :包名 + 类名 称为：全类名
        @ ：分割符
        776ec8df： 十六进制的内存地址
         */
        //对象的使用
        // 对象名.属性名
        stu.name = "张三";
        stu.age = 18;
        // 对象名.方法名();
        stu.study();

        //取值
        String x = stu.name;
        System.out.println("x = "+x);
        int y = stu.age;
        System.out.println("y = "+y);
    }
}

```

#### 1.5 面向对象入门小结

```java
/*
    类：  类是对同一类事物的描述，具有相同属性和行为为的一类事物统称
    对象： 对象是具体存在事物，就是类的实体，是类的具体体现；
    创建类：
        public class 类名{
            属性： 成员变量
            行为： 成员方法
        }
        public class Student{
            //属性： 成员变量
            String name;
            int age;
            //行为： 成员方法
            public void study(){
                sout("好好学习");
            }
        }
    创建对象：
        格式：
            类名 对象名/变量名 = new 类名();
        步骤：
            1.创建测试类
            2.书写main方法
            3.在main方法中创建对象
                Student stu = new Student();
    使用对象:
        步骤：
            1.使用属性或者叫使用成员变量 进行赋值
            格式：
                对象名.属性名 = 值;
                对象名.成员变量 = 值;
                stu.name = "张三";
                stu.age = 18;
             2.使用属性或者叫使用成员变量 进行取值
             格式：
                成员变量的数据类型 变量名 = 对象名.成员变量名;
                String x = stu.name;
                int y = stu.age;
                输出取值
                sout(stu.name);
                sout(stu.age);
              3.使用成员方法
              格式：
                对象名.成员方法名();

 */
public class Test02面向对象入门小结 {
}
```

#### 1.6面向对象的练习

```java
public class Phone {
    String brand;
    double price;

    //成员方法：打电话，发短信
    public void call(){
        System.out.println("打电话，说情话");
    }
    public void sendMessage(){
        System.out.println("发短信，他走了，你可以来了！");
    }
}

public class Test03Phone {
    public static void main(String[] args) {
        //创建对象
        Phone phone = new Phone();
        //调用成员变量
        phone.brand = "XIAOMI";
        phone.price = 2999.0;

        String brand = phone.brand;
        double price = phone.price;
        System.out.println(brand);
        System.out.println(price);
        //调用成员方法
        phone.call();
        phone.sendMessage();
    }
}
```

```java
public class TV {
    String brand;
    double price;

    public void watchTv(){
        System.out.println("正在播放新闻联播");
    }
}

public class TestTV {
    public static void main(String[] args) {
        //创建对象
        TV tv = new TV();
        //成员变量赋值
        tv.brand = "HUAWEI";
        tv.price = 188888.88;
        //成员变量取值
        String brand = tv.brand;
        double price = tv.price;
        System.out.println(brand);
        System.out.println(price);

        System.out.println(tv.brand);
        System.out.println(tv.price);

        //使用成员方法
        tv.watchTv();
    }
}
```

```java
public class 洗衣机 {
    String 品牌;
    double 价格;

    public void 洗衣服(){
        System.out.println("一个会中文的洗衣机在洗衣服");
    }
}
public class 测试洗衣机类 {
    public static void main(String[] args) {
        洗衣机 隔壁老王家 = new 洗衣机();
        //属性的使用
        隔壁老王家.品牌 = "海尔兄弟";
        隔壁老王家.价格 = 888.0;

        String x = 隔壁老王家.品牌;
        double y = 隔壁老王家.价格;
        System.out.println(x);
        System.out.println(y);
        System.out.println(隔壁老王家.品牌);
        System.out.println(隔壁老王家.价格);
        //行为的使用
        隔壁老王家.洗衣服();
    }
}
```

### 2.面向对象

#### 2.1private 关键字和this关键字

```java
/*
    private: 修饰成员变量
        表示私有的，外界不能直接访问，只能在本类中访问
        如果测试类中本类的对象，需要访问私有成员变量 赋值，在本类提供setXxx 给私有成员变量赋值
        如果测试类中本类的对象，需要访问私有成员变量 取值，在本类提供getXxx 给私有成员变量取值
    this关键字：
        1.区分成员变量和局部变量
        2.代表当前对象的引用，那个对象调用此方法，方法中的this，就是此对象
 */
public class Test01Student {
    public static void main(String[] args) {
        //创建对象
        Student student = new Student();
        //使用成员变量
        //student.name = "林青霞";
        student.setName("林青霞");
        //student.age = 300; // 0 -- 120
        student.setAge(16);


//        System.out.println(student.name);
        //System.out.println(student.age);
        String name = student.getName();
        System.out.println(name);
        int age = student.getAge();
        System.out.println(age);

        Student student1 = new Student();
        student1.setName("王祖贤");
        student1.setAge(17);

        System.out.println(student1.getName());
        System.out.println(student1.getAge());
    }
}
```

```java
public class Student {
    private String name;
    private int age;

    public void setAge(int age){
        if (age>0&&age<=120){
            this.age = age;
        }else {
            System.out.println("您给的年龄不合理！");
        }
    }
    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void study(){
        System.out.println("好好学习，天天向上！");
    }
    public void eat(){
        System.out.println("吃饭饭！");
    }
    public void sleep(){
        System.out.println("单身狗，抱着自己，睡觉觉！");
    }
}
```

#### 2.2构造方法

```java
/*
    构造方法：
        作用：构造作用用来创建对象和new关键字
        格式：
            格式1： public 类名(){}
            格式2： public 类名(参数列表){......}

    特点：
        1.如果本类中没有构造方法，JVM会默认提供一个无参的构造方法
        2.构造方法可以重载
        3.构造方法没有返回值，也不能使用 void
        4.构造方法中没有return关键字 ,可以写，但是没有必要，非要写return;
 */
public class Test02Phone {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone xiaomi = new Phone("XIAOMI");
        Phone phone1 = new Phone(2999.0);
        Phone huawei = new Phone("HUAWEI",17998.0);

    }
}

```

```java
/*
标准类的编写：
    1.成员变量私有化 提供getXxx和SetXxx方法
    2.提供空参满参的构造方法

 */
public class Phone {
   private String brand;
   private double price;
   private String productAddress;
   //无参构造方法
   public Phone(){
       System.out.println("无参构造方法被调用！");
   }
   /*public Phone(String productAddress){
       this.productAddress = productAddress;
   }*/
   //有参构造方法
    public Phone(String brand){
        System.out.println("有参构造方法被调用！ brand");
       this.brand = brand;
    }
    public Phone(double price){
        System.out.println("有参构造方法被调用！ price");
        this.price = price;
    }

    public Phone(String brand,double price){
        System.out.println("满参构造方法被调用！ price");
       this.brand = brand;
       this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void call(){
        System.out.println("打电话");
    }
    public void sendMessage(){
        System.out.println("发短信");
    }
}

```

#### 2.3面向对象的特征

```java
/*
    面向对象的特征：
        封装：
            表现形式：
                1.private 关键字 修饰成员变量
                2.特定功能代码 封装方法
                3.具有形同属性和行为一类事物，封装成类
        继承：
            父类和子类产生关系，extends
        多态：
            父类的引用存放子类对象
 */

public class Test03 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        //输出数组的元素，如下：[1,2,3,4,5,6,7,8,9]
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+", ");
            }
        }
        System.out.println("]");
    }
}

class Cat extends Animal{
    public static void main(String[] args) {
        Animal cat = new Cat();
    }
}
class Animal{}

```

#### 2.4 局部变量和成员变量区别

```java
/*
    局部变量和成员变量区别：
        代码中的位置：
            成员变量：类中方法外
            局部变量：在方法的声明上 或者方法内部
        在内存中的位置：
            成员变量：在堆中
            局部变量：在栈中
        声明周期不一样：
            局部变量：随着方法的调用而存在，随着方法的弹栈而消失
            成员变量：随着对象的创建而存在，对象对象的消失而消失
        初始化值：
            局部变量没有默认，成员变量有默认值

 */
public class Phone {
    private String name;
    private double price;
    private String productAddress;

    //提供空参满参的构造方法

    public Phone() {
    }

    public Phone(String name, double price, String productAddress) {
        this.name = name;
        this.price = price;
        this.productAddress = productAddress;
    }
    //提供get和set方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }
}

```

```java
public class Test01Phone {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setName("HUAWEI");
        phone.setPrice(17988.0);
        phone.setProductAddress("Made in China");
        System.out.println(phone.getName());
        System.out.println(phone.getPrice());
        System.out.println(phone.getProductAddress());
    }
}
```

#### 2.5标准类的编写

```java
/*
标准类的编写：
    1.成员变量私有化 提供getXxx和SetXxx方法
    2.提供空参满参的构造方法

 */
public class Phone {
    private String name;
    private double price;
    private String productAddress;

    //提供空参满参的构造方法

    public Phone() {
    }

    public Phone(String name, double price, String productAddress) {
        this.name = name;
        this.price = price;
        this.productAddress = productAddress;
    }
    //提供get和set方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress;
    }
}
```

### 3.对象内存图

![单个对象的内存图](img\单个对象的内存图.png)

![两个对象的内存图](img\两个对象的内存图.png)

![两个引用指向同一个内存的内存图](img\两个引用指向同一个内存的内存图.png)



### 4.垃圾回收机制

#### 4.1 垃圾回收机制的意义

```java
Java语言中一个显著的特点就是引入了垃圾回收机制，使c++程序员最头疼的内存管理的问题迎刃而解，它使得Java程序员在编写程序的时候不再需要考虑内存管理。

ps:内存泄露是指该内存空间使用完毕之后未回收，在不涉及复杂数据结构的一般情况下，Java 的内存泄露表现为一个内存对象的生命周期超出了程序需要它的时间长度，我们有时也将其称为“对象游离”。
```

#### 4.2垃圾回收机制中的算法 引用计数法(Reference Counting Collector)

```java
Java语言规范没有明确地说明JVM使用哪种垃圾回收算法，但是任何一种垃圾回收算法一般要做2件基本的事情：（1）发现无用信息对象；（2）回收被无用对象占用的内存空间，使该空间可被程序再次使用。
```

```java
引用计数法(Reference Counting Collector) 算法分析
  引用计数是垃圾收集器中的早期策略。在这种方法中，堆中每个对象实例都有一个引用计数。当一个对象被创建时，且将该对象实例分配给一个变量，该变量计数设置为1。当任何其它变量被赋值为这个对象的引用时，计数加1（a = b,则b引用的对象实例的计数器+1），但当一个对象实例的某个引用超过了生命周期或者被设置为一个新值时，对象实例的引用计数器减1。任何引用计数器为0的对象实例可以被当作垃圾收集。当一个对象实例被垃圾收集时，它引用的任何对象实例的引用计数器减1。
```

```java
引用计数法(Reference Counting Collector) 优缺点
  优点：
　　引用计数收集器可以很快的执行，交织在程序运行中。对程序需要不被长时间打断的实时环境比较有利。
  缺点： 
　　无法检测出循环引用。如父对象有一个对子对象的引用，子对象反过来引用父对象。这样，他们的引用计数永远不可能为0.
引用计数算法无法解决循环引用问题:
public class Main {
    public static void main(String[] args) {
        MyObject object1 = new MyObject();
        MyObject object2 = new MyObject();
         
        object1.object = object2;
        object2.object = object1;
         
        object1 = null;
        object2 = null;
    }
}
最后面两句将object1和object2赋值为null，也就是说object1和object2指向的对象已经不可能再被访问，但是由于它们互相引用对方，导致它们的引用计数器都不为0，那么垃圾收集器就永远不会回收它们。
```









