

day03-多态 ,内部类,常用API

## 今日目标

- ##### 多态

- ##### 内部类

- ##### 常用API

  

## 1 多态

### 1.1 面向对象三大特征 ?

- 封装 , 继承 , 多态

### 1.2 什么是多态 ?

- 一个对象在不同时刻体现出来的不同形态

- 举例 : 一只猫对象
  - 我们可以说猫就是猫 : Cat cat = new Cat();
  - 我们也可以说猫是动物 : Animal cat = new Cat();
  - 这里对象在不同时刻,体现出来的不同形态 , 我们就可以理解为多态

### 1.3 多态的前提

- 有继承/实现关系
- 有方法重写 
- 父类的引用指向子类的对象

```java
package com.itheima.polymorphism_demo;
/*
    多态的三个前提条件
        1 需要有继承/实现关系
        2 需要有方法重写
        3 父类的引用指向子类的对象
 */
public class AnimalTest {
    public static void main(String[] args) {
        // 3 父类的引用指向子类的对象
        // 多态形式对象
        Animal a = new Cat();
    }
}

class Animal{
    public void eat(){
        System.out.println("吃东西");
    }
}

class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼....");
    }
}

```

### 1.4 多态的成员访问特点

- 构造方法 : 和继承一样 , 子类通过super()访问父类的构造方法
- 成员变量 : 编译看左边(父类) , 执行看左边(父类)
- 成员方法 : 编译看左边(父类) , 执行看右边(子类)

```java
package com.itheima.polymorphism_demo;

/*
    多态的成员访问特点 :
        1 构造方法 : 和继承一样 , 都是通过super()访问父类的构造方法
        2 成员变量 : 编译看左边(父类) , 执行看左边(父类)
        3 成员方法 : 编译看左边(父类) , 执行看右边(子类) , 注意 , 如果执行时
            1) 子类没有回动态去找父类中的方法
            2) 子类的特有方法无法进行调用(多态的缺点)
 */
public class MemberTest {
    public static void main(String[] args) {
        // 父类的引用指向子类的对象
        Fu f = new Zi();

        // 多态对象调用成员变量
        System.out.println(f.num);

        // 多态对新乡调用调用成员方法
        f.show();

        // 多态对象不能调用子类特有的方法
        // f.show2();
    }
}

class Fu {
    int num = 100;

    public void show() {
        System.out.println("父类的show方法");
    }
}

class Zi extends Fu {
    int num = 10;

    public void show() {
        System.out.println("子类的show方法");
    }

    public void show2(){
        System.out.println("子类特有的方法");
    }
}

```

### 1.5 多态的优缺点

- 优点 : 提高代码的扩展性
- 缺点 : 不能调用子类特有的功能

```java
package com.itheima.polymorphism_test;

public abstract class Animal {
    private String breed;
    private String color;

    public Animal() {
    }

    public Animal(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void eat();
}

```

```java
package com.itheima.polymorphism_test;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(String breed, String color) {
        super(breed, color);
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼...");
    }

    public void catchMouse() {
        System.out.println("抓老鼠...");
    }
}

```

```java
package com.itheima.polymorphism_test;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(String breed, String color) {
        super(breed, color);
    }

    @Override
    public void eat() {
        System.out.println("狗吃骨头!");
    }

    public void lookDoor(){
        System.out.println("狗看门...");
    }
}

```

```java
package com.itheima.polymorphism_test;

public class Pig extends Animal {
    public Pig() {
    }

    public Pig(String breed, String color) {
        super(breed, color);
    }

    @Override
    public void eat() {
        System.out.println("猪拱白菜...");
    }

    public void sleep() {
        System.out.println("一直再睡...");
    }
}

```

```java
package com.itheima.polymorphism_test;

/*
    如果方法的参数是一个类的话 , 那么调用此方法需要传入此类的对象 , 或者子类对象

    多态的好处 :
        提高代码的扩展性 , 灵活性
    多态的缺点:
        不能调用子类的特有功能
 */
public class AnimalTest {
    public static void main(String[] args) {
        useAnimal(new Cat());

        System.out.println("---------");

        useAnimal(new Dog());

        System.out.println("---------");

        useAnimal(new Pig());
    }

    public static void useAnimal(Animal a){// Animal a = new Dog()
        a.eat();
        // 多态不能访问子类特有的功能
        // 如果解决 ?

        // 向下转型
        if(a instanceof Cat) {
            Cat cat = (Cat) a;
            cat.catchMouse();
        }
        if(a instanceof Dog) {
            Dog dog = (Dog) a;
            dog.lookDoor();
        }

        if(a instanceof Pig) {
            ((Pig) a).sleep();
        }
    }

//    // 定义一个使用猫类的方法
//    public static void useAnimal(Cat c) {// Cat c = new Cat();
//        c.eat();
//        c.catchMouse();
//    }
//
//    // 定义一个使用狗类的方法
//    public static void useAnimal(Dog d) {// Dog d = new Dog();
//        d.eat();
//        d.lookDoor();
//    }
//
//    // 定义一个使用猪类的方法
//    public static void useAnimal(Pig pig) {
//        pig.eat();
//        pig.sleep();
//    }
}

```

### 1.6 多态的转型

- 向上转型 :  把子类类型数据转成父类类型数据  Animal a = new Cat();
- 向下转型 :  把父类类型数据转成子类类型数据  Cat cat = (Cat)a;

### 1.7 多态的转型注意

- 如果被转的对象 , 对应的实际类型和目标类型不是同一种数据类型 , 那么转换时会出现ClassCastException异常

- ```java
  异常代码如下
  public static void main(String[] args) {
      Animal a = new Cat();
      useAnimal(a);
  }
  public static void useAnimal(Animal a) {
      Dog d = (Dog) a;
      d.eat();
  }
  
  ```

### 1.8 解决转型安全隐患

- 使用关键字   instanceof
- 作用 : 判断一个对象是否属于一种引用数据类型
- 格式 : 对象名 instanceof 引用数据类型
  - 通俗的理解：判断关键字左边的变量，是否是右边的类型，返回boolean类型结果

## 2 内部类

### 2.1 内部类的分类

- ##### 什么是内部类 ?

  - 一个A类 中 定义一个B类 , 那么B类就属于A类的内部类 , A类就属于B类的外部类

    ![image-20210402191054318](D:\传智播客\上海-JavaSE进阶面授\day03【多态，内部类 , 常用API 1】\笔记\img\image-20210402191054318.png)

- ##### 什么时候使用内部类 ?

  - 多个事物之间有包含关系, 可以使用内部类

- ##### 内部类分类 ? 

  - 成员内部类
  - 局部内部类
  - 匿名内部类

### 2.2 成员内部类

- 定义的位置 : 类中方法外

- 创建成员内部类对象格式 : 外部类名.内部类名  对象名 = new 外部类名().new 内部类名(参数);

  ```java
  package com.itheima.innerclass_demo.member_innerclass;
  
  // 外部类
  public class Person {
      // 成员内部类
      public class Heart {
          // 频率变量
          private int rate;
          // 跳动方法
          public void beats() {
              System.out.println("咚咚咚!");
          }
      }
  }
  
  class Test {
      public static void main(String[] args) {
          // 创建内部类对象
          Person.Heart heart = new Person().new Heart();
          // 调用内部类中的方法
          heart.beats();
      }
  }
  ```

- ##### 成员内部类访问外部类的成员

  - 在内部类中有代表外部类对象的格式 : 外部类名的.this  , 私有的也可以访问
  - 外部类要想访问内部类成员 , 需要创建内部类对象

  ```java
  package com.itheima.innerclass_demo.member_innerclass;
  
  public class Person {
      private String name = "张三";
      private int num = 10;
      
      // 成员内部类
      public class Heart {
          int num = 100;
          // 频率
          private int rate;
          // 跳动
          public void beats() {
              System.out.println("咚咚咚!");
          }
          // 调用外部类的成员
          public void show(){
              int num = 1000;
              System.out.println(Person.this.name);
              System.out.println(num);// 1000 就近原则
              System.out.println(this.num);// 100
              System.out.println(Person.this.num);// 10
  
          }
      }
  }
  
  class Test {
      public static void main(String[] args) {
          Person.Heart heart = new Person().new Heart();
          heart.beats();
          heart.show();
      }
  }
  ```

### 2.3 匿名内部类

- 匿名内部类 : 没有名字的类 ,  一次性产品
- 使用场景 : 直接调用方法 , 作为方法的传参 , 返回值类型 
- 好处 : 简化代码 , 快速实现接口或者抽象的抽象方法
- 格式 : 
  - new 类名/接口名(){  重写抽象方法 }   注意 : 此处创建的是子类对象!!!
- 使用方式 :
  - 直接调用方法
  - 作为方法的参数传递
  - 作为方法的返回值类型

```java
//接口
interface Flyable {
    void fly();
}
```

```java
// 直接调用方法
Flyable f1 = new Flyable() {
    @Override
    public void fly() {
        System.out.println("不知道什么在飞.....");
    }
};
f1.fly();
```

```java
// 作为方法的参数传递
showFlyable(
    new Flyable() {
        @Override
        public void fly() {
            System.out.println("不知道什么在飞3333");
        }
    }
);

public static void showFlyable(Flyable flyable) {
	flyable.fly();
}
```

```java
// 作为方法的返回值类型
public static Flyable getFlyable() {
	return new Flyable() {
        @Override
        public void fly() {
            System.out.println("3333333333333");
        }
    };
}
```

```java
package com.itheima.innerclass_demo.anonymous_innerclass;

/*
    1 如果方法的参数是一个类的话 , 调用此方法需要传入此类的对象或者此类的子类对象
    2 如果方法的返回值类型是一个类的话 , 需要返回此类的对象 , 或者此类的子类对象

     3 如果方法的参数是一个接口的话 , 调用此方法需要传入此接口的实现类对象
     4 如果方法的返回值类型是一个接口的话 , 需要返回此接口的实现类对象


     匿名内部类 : 代表的就是子类对象!!!
        new 类名/接口名(){
            重写抽象类或者接口中的抽象方法
        };

     使用方向 :
        1 调用方法
        2 作为方法参数传递
        3 作为方法的返回值
 */
public interface Swim {
    public abstract void swimming();
}

class Test {
    public static void main(String[] args) {
//        // 子类对象!!!
        //  1 调用方法
//       new Swim() {
//            @Override
//            public void swimming() {
//                System.out.println("匿名内部类 , 重写了接口中的抽象方法...");
//            }
//        }.swimming();


//        //   2 作为方法参数传递
//        useSwim(new Swim() {
//            @Override
//            public void swimming() {
//                System.out.println("匿名内部类 , 重写了接口中的抽象方法...");
//            }
//        });

//        // 3 作为方法的返回值
//        Swim s = getSwim();
//        s.swimming();
    }


    public static Swim getSwim() {
        return new Swim() {
            @Override
            public void swimming() {
                System.out.println("匿名内部类 , 重写了接口中的抽象方法...");
            }
        };
    }


    /*
        Swim swim = new Swim() {
            @Override
            public void swimming() {
                System.out.println("匿名内部类 , 重写了接口中的抽象方法...");
            }
        };
     */
    public static void useSwim(Swim swim) {
        swim.swimming();
    }
}
```



## 3 API 

### 3.1 Object类

- 概述 : 类Object是类层次结构的根，每个类都把Object作为超类。 所有对象（包括数组）都实现了这个类的方法
- 方法 : public String toString()
  - 如果一个类没有重写toString方法 , 那么打印此类的对象 , 打印的是此对象的地址值
  - 如果一个类重写了toString方法 , 那么打印此类的对象 , 打印的是此对象的属性值
  - 好处 : 把对象转成字符串 , 快速查看一个对象的属性值
  - 执行时机 : 打印对象时会默认调用toString方法
- 方法 : public boolean equals()
  - 如果一个类没有重写equals方法 , 那么比较此类的对象 . 比较的是地址值
  - 如果一个类重写了equals方法 . 那么比较此类的对象 , 比较的是属性值是否相等
  - 好处 : 可以比较对象的内容

### 3.2 Objects类

- Objects是JDK1.7新增的一个对象工具类，里面都是静态方法可以用来操作对象。比如对象的比较，计算对象的hash值，判断对手是否为空....比如里面的equals方法，可以避免空指针异常

```java
public static boolean equals(Object a, Object b):判断两个对象是否相等
    
public static boolean equals(Object a, Object b) {
    return (a == b) || (a != null && a.equals(b));
}
a.equals(b) :如果a是null值，肯定会空指针
Objects.equals(a,b);：如果a是null，不会导致空指针异常
```



### 3.2  Date类

- ##### 概述 : java.util.Date 表示特定的瞬间，精确到毫秒

- ##### 构造方法 : 

  - public Date(): 创建的对象，表示的是当前计算机系统的时间
  - public Date(long time): Date对象 = 1970/1/1 0:0:0 + time毫秒值

- ##### 成员方法 : 

  - public long getTime(): 返回毫秒值 = 当前Date代表的时间 - 1970/1/1 0:0:0
  - public void setTime(long t): Date对象 = 1970/1/1 0:0:0 + time毫秒值

```java
package com.itheima.api_demo.date_demo;

import java.util.Date;

/*
    Date类 : 代表的是一个瞬间 , 精确到毫秒

    构造方法 :
        public Date() : 代表的是当前系统时间
        public Date(long date) : Date对象 = 1970/1/1 0:0:0 + long类型的毫秒值

    成员方法 :
        public void setTime(long date) : Date对象 = 1970/1/1 0:0:0 + long类型的毫秒值
        public long getTime() : 返回的是毫秒值 = Date代表的时间 - 1970/1/1 0:0:0
 */
public class DateDemo {
    public static void main(String[] args) {
        //  public Date() : 代表的是当前系统时间
//        Date d = new Date();
//        System.out.println(d);

        //  public Date(long date) : Date对象 = 1970/1/1 0:0:0 + long类型的毫秒值
//        Date d2 = new Date(1000L * 60 * 60 * 24); // 1970/1/1 0:0:0 + 一天的毫秒值
//        System.out.println(d2);

        Date d = new Date();
        // public void setTime(long date) : Date对象 = 1970/1/1 0:0:0 + long类型的毫秒值
        // d.setTime(1000L * 60 * 60 * 24);
        System.out.println(d);

        // public long getTime() : 返回的是毫秒值 = Date代表的时间 - 1970/1/1 0:0:0
        // System.out.println(d.getTime());

    }
}
```

### 3.3 DateFormat类

- 概述 : 主要用于操作日期格式的一个类

- 作用 :

  - 格式化 : Date --> String
  - 解析 : String --> Date

- 构造方法 : 

  - SimpleDateFormat(String  pattern)    给定日期模板创建日期格式化对象

    <img src="D:\传智播客\上海-JavaSE进阶面授\day03【多态，内部类 , 常用API 1】\笔记\img\image-20210402212755339.png" alt="image-20210402212755339" style="zoom:80%;" />

- 成员方法 : 

  - public String format ( Date d )：格式化，将日期对象格式化为字符串
  - public Date parse ( String s )：解析，将字符串解析为日期对象

```java
package com.itheima.api_demo.dateformat_demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    SimpleDateFormat类 :
        "2021年04月03日 16:48:10"  ---> Date
        Date(Sat Apr 03 16:41:38 CST 2021) --> "2021年04月03日 16:48:10"

        作用 :
            格式化 : Date --> String
            解析   : String --> Date

        构造方法 :
            public SimpleDateFormat(String pattern) : pattern : 字符串类型的日期模板

        成员方法 ;
            public final String format(Date date) : 接收一个Date对象返回指定模式的字符串
            public Date parse(String source) : 接收一个字符串  , 返回一个Date对象



        1 获取当前的日期对象，使用格式：yyyy-MM-dd HH:mm:ss 来表示，例如：2020-10-31 17:00:00【格式化】

        2 将字符串的 2020年10月31日  17:00:00，转换为日期Date对象。【解析】

 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        // 解析   : String --> Date
        String strDate = "2020年10月31日 17:00:00";
        // 注意 : 解析时 , SimpleDateFormat的参数(日期模板) , 必须和要解析字符串的模式匹配
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //  public Date parse(String source) : 接收一个字符串  , 返回一个Date对象
        Date date = sdf.parse(strDate);
        System.out.println(date); // Sat Oct 31 17:00:00 CST 2020
    }

    private static void method() {
        // 格式化 : Date --> String
        // 获取当前系统时间
        Date date = new Date();
        // System.out.println(date);// Sat Apr 03 16:53:35 CST 2021

        // public SimpleDateFormat(String pattern) : pattern : 字符串类型的日期模板
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // public final String format(Date date) : 接收一个Date对象返回指定模式的字符串
        String strDate = sdf.format(date);

        System.out.println(strDate);
    }
}
```



### 3.4 Calendar类

- ##### 概述 : 

  - java.util.Calendar类表示日历，内含有各种时间信息，以及获取，计算时间的方法。
  - Calendar本身是一个抽象类，可以通过Calendar提供的静态方法getInstance日历子类对象

- ##### Calendar常用方法 : 

  | **方法名**                            | **说明**                                |
  | ------------------------------------- | --------------------------------------- |
  | public static Calendar getInstance()  | 获取一个它的子类GregorianCalendar对象。 |
  | public int get(int field)             | 获取指定日历字段的时间值。              |
  | public void set(int field,int value)  | 设置指定字段的时间值                    |
  | public void add(int field,int amount) | 为某个字段增加/减少指定的值             |

- get,set,add方法参数中都有一个整数类型的参数field，field用来区分当前要获取或者操作的日期时间数据的。field数据的值使用Calender中定义的整数常量来表示

  - Calendar.YEAR : 年 
  -  Calendar.MONTH ：月  
  - Calendar.DAY_OF_MONTH：月中的周
  - Calendar.HOUR：小时 
  - Calendar.MINUTE：分钟，
  - Calendar.SECOND：秒
  - Calendar.DAY_OF_WEEK：星期

- ##### 星期对应的关系

  ​     字段时间值  :   1           		2            			3          		  ...        7
  ​     真正的时间  : SUNDAY        MONDAY      TUESDAY    	 ...        SATURDAY

- ##### 月份对应的关系

  ​    字段时间值     :       0           				1             ....        	11
  ​    正真的时间     :     JANUARY     FEBRUARY       ....      	DECEMBER

```java
package com.itheima.api_demo.calendar_demo;
/*

    月份对应的关系
    字段时间值     :       0           1           ....        11
    正真的时间     :     JANUARY     FEBRUARY      ....      DECEMBER


 */
import java.util.Calendar;
/*
    成员方法 :
        public int get(int field)	获取指定日历字段的时间值。
        public void set(int field,int value)	设置指定字段的时间值
        public void add(int field,int amount)	为某个字段增加/减少指定的值
 */
public class CalendarDemo {
    public static void main(String[] args) {
        // 获取Calendar对象 , rightNow对象
        Calendar rightNow = Calendar.getInstance();

        // public void set(int field , int value)	设置指定字段的时间值
        // rightNow.set(Calendar.YEAR , 2024);
        // rightNow.set(Calendar.MONTH , 5);
        // rightNow.set(Calendar.DAY_OF_MONTH, 10);

        // public void add(int field,int amount)	为某个字段增加/减少指定的值
        // rightNow.add(Calendar.DAY_OF_MONTH , -3);

        //  public int get(int field)	 : 获取指定日历字段的时间值。
        int year = rightNow.get(Calendar.YEAR);
        int month = rightNow.get(Calendar.MONTH);
        int day = rightNow.get(Calendar.DAY_OF_MONTH);


        System.out.println(year); // 2021
        System.out.println(month);// 3
        System.out.println(day);  // 3
    }
}
```

```java
package com.itheima.api_demo.calendar_demo;

import java.util.Calendar;

/*
    1 写代码使用get方法，将年，月，日，时，分，秒，周获取出来
    特别注意获取月份，和星期有以下特点：
    直接获取的月份数据是从0开始的， 0表示1月，.....11表示12月
    周的获取，从周日开始计算，1就是周日，2就是周一 ......7就是周六


星期对应的关系
     字段时间值  :   1           2            3          ...        7
     真正的时间  : SUNDAY        MONDAY      TUESDAY     ...        SATURDAY

月份对应的关系
    字段时间值     :       0           1           ....        11
    正真的时间     :     JANUARY     FEBRUARY      ....      DECEMBER

 */
public class Test1 {
    public static void main(String[] args) {
        // 拿到当前时间
        Calendar now = Calendar.getInstance();

        System.out.println(now.get(Calendar.YEAR));
        System.out.println(now.get(Calendar.MONTH));
        System.out.println(now.get(Calendar.DAY_OF_MONTH));
        System.out.println(now.get(Calendar.HOUR));
        System.out.println(now.get(Calendar.MINUTE));
        System.out.println(now.get(Calendar.SECOND));

        int week = now.get(Calendar.DAY_OF_WEEK);// 7
        System.out.println(getWeek(week));// 字段值
    }

    public static String getWeek(int field){
        String[] str = { "" , "SUNDAY" , "MONDAY" , "TUESDAY" , "WEDNESDAY" , "THURSDAY" , "FRIDAY" , "SATURDAY"};
        return str[field];
    }
}
```

```java
package com.itheima.api_demo.calendar_demo;

import java.util.Calendar;

/*
    2 写代码实现，获取2022年10月1日是星期几？
    参考思路：
    直接获取日历对象，得到的是当前系统的日历时间信息。
    获取日历对象后，要重新设置日期
    再获取星期数据

 */
public class Test2 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        int week = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(getWeek(week));// 字段值
    }

    public static String getWeek(int field){
        String[] str = { "" , "SUNDAY" , "MONDAY" , "TUESDAY" , "WEDNESDAY" , "THURSDAY" , "FRIDAY" , "SATURDAY"};
        return str[field];
    }
}

```

```java
package com.itheima.api_demo.calendar_demo;

import java.util.Calendar;

/*
    3 计算10000天之后的年月日

    参考思路：
    先获取当前日历对象
    再调用add方法，指定DATE或者DAY_OF_MONTH，添加10000天
    再获取日历的年，月，日

 */
public class Test3 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 10000);


        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
    }
}

```

### 3.5 Math类

- 概述 : Math包含执行基本数字运算的方法，如基本指数，对数，平方根和三角函数。所提供的都是静态方法，可以直接调用

- 常用方法 : 

  | public static int abs(int a)                 | 获取参数a的绝对值： |
  | -------------------------------------------- | ------------------- |
  | public static double ceil(double a)          | 向上取整            |
  | public static double floor(double a)         | 向下取整            |
  | public static double pow(double a, double b) | 获取a的b次幂        |
  | public static long round(double a)           | 四舍五入取整        |

### 3.6 System类 

- System类包含几个有用的类字段和方法。 它不能被实例化

- 常用方法 : 

  | **方法名**                             | **说明**                                     |
  | -------------------------------------- | -------------------------------------------- |
  | public static void exit(int status)    | 终止当前运行的 Java 虚拟机，非零表示异常终止 |
  | public static long currentTimeMillis() | 返回当前时间(以毫秒为单位)                   |