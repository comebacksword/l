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



# 【关键字】

## 题目1

定义一个数学工具类，类名使用MyMath。

要求：

1. 该工具类不能有子类，不接受扩展。
2. 该工具类不能被外界创建对象，构造方法需要私有化。
3. 定义静态常量：PI，用来保存圆周率：3.14。
4. 定义静态方法max，获取两个整数的较大值。
5. 定义静态方法min，获取两个整数的较小值。



答案：

```java
package com.itheima.homework;

/*
    定义一个数学工具类，类名使用MyMath。

    要求：
    1. 该工具类不能有子类，不接受扩展。
    2. 该工具类不能被外界创建对象，构造方法需要私有化。
    3. 定义静态常量：PI，用来保存圆周率：3.14。
    4. 定义静态方法max，获取两个整数的较大值。
    5. 定义静态方法min，获取两个整数的较小值。

 */
public final class MyMath {

    private MyMath() {
    }

    public static final double PI = 3.14;

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

}
```



# 【接口】

## 题目2

1. 请定义“员工(类)”：
   属性：姓名、性别、年龄(全部私有)
   行为：工作(抽象)
   无参、全参构造方法
   get/set方法

2. 请定义“绘画(接口)”
   抽象方法：绘画
3. 请定义“Java讲师类”继承自“员工类”
4. 请定义”UI讲师类”，继承自“员工类”，并实现“绘画”接口。

**要求**：

1. 请按上述要求设计出类结构，并实现相关的方法。
2. 测试类中创建对象测试，属性可自定义：
   - 创建一个Java讲师类对象，调用工作的方法。
   - 创建一个UI讲师类对象，调用工作方法，和绘画方法。

**答案：**

```java
package com.itheima.homework;

public abstract class Employee {
    private String name;
    private String sex;
    private int age;

    public Employee() {
    }

    public Employee(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void work();
}

```

```java
package com.itheima.homework;

public class JavaTeacher extends Employee{

    public JavaTeacher() {
    }

    public JavaTeacher(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void work() {
        System.out.println("讲java课程...");
    }
}

```

```jav
package com.itheima.homework;

public class UITeacher extends Employee implements Paint {
    public UITeacher() {
    }

    public UITeacher(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void work() {
        System.out.println("讲解UI课程");
    }

    @Override
    public void paint() {
        System.out.println("具备画图技术");
    }
}

```

```java
package com.itheima.homework;

/*
    1. 请定义“员工(类)”：
       属性：姓名、性别、年龄(全部私有)
       行为：工作(抽象)
       无参、全参构造方法
       get/set方法

2. 请定义“绘画(接口)”
   抽象方法：绘画
3. 请定义“Java讲师类”继承自“员工类”
4. 请定义”UI讲师类”，继承自“员工类”，并实现“绘画”接口。

**要求**：

1. 请按上述要求设计出类结构，并实现相关的方法。
2. 测试类中创建对象测试，属性可自定义：
   - 创建一个Java讲师类对象，调用工作的方法。
   - 创建一个UI讲师类对象，调用工作方法，和绘画方法。
 */
public class Test2 {
    public static void main(String[] args) {
        JavaTeacher javaTeacher = new JavaTeacher("柳岩", "女", 18);
        System.out.println(javaTeacher.getName() + "--" + javaTeacher.getSex() + "--" + javaTeacher.getAge());
        javaTeacher.work();

        UITeacher uiTeacher = new UITeacher("景甜", "女", 18);
        System.out.println(uiTeacher.getName() + "--" + uiTeacher.getSex() + "--" + uiTeacher.getAge());
        uiTeacher.work();
        uiTeacher.paint();
    }
}

```



**运行结果：**

```java
JavaTeacher{name='小明', gender='男', age=25}
小明讲Java课
UITeacher{name='小红', gender='女', age=18}
小红讲UI设计课
小红画画
```



## 题目3

1. 编写一个接口ShapePara，要求： 接口中的方法：

   ```
    int getArea()：获得图形的面积。
    int getCircumference()：获得图形的周长
   ```

2. 编写一个圆类Circle，要求：圆类Circle实现接口ShapePara。

   **该类含有一个静态常量：**

   ```
   PI： double类型，值为3.14
   ```

   **该类包含有成员变量：**

   ```java
   radius:	public修饰的double类型radius,表示圆的半径。
   x:	private修饰的double型变量x，表示圆心的横坐标。
   y:	protected修饰的double型变量y，表示圆心的纵坐标。
   ```

   **包含的方法有：**

   ```java
   Circle(double radius) 有参构造方法。以形参表中的参数初始化半径，圆心为坐标原点（x=0,y=0）。 
     
   double getRadius()：获取半径为方法的返回值。
     
   void setCenter(double x, double  y)：利用形参表中的参数设置类Circle的圆心坐标。
     
   void setRadius(double  radius)：利用形参表中的参数设置类Circle的radius域。
   ```



请根据上述要求代码实现相关类和接口，并定创建测试类，定义一个圆对象。半径为10，求周长和面积。

```
注：
圆周长公式： 周长 = PI*2*radius
圆面积公式： 面积 = PI * radius*radius
```

**代码：**

```java
package com.itheima.homework.test3;

// 图形 接口
public interface ShapePara {
    // 获得图形的面积
    public abstract int getArea();

    // 获得图形的周长
    public abstract int getCircumference();
}

// 圆类 实现了 图形
class Circle implements ShapePara {
    // 该类含有一个静态常量
    public static final double PI = 3.14;

    // 圆的半径
    public double radius;
    // 表示圆心的横坐标
    private double x;
    // 表示圆心的纵坐标
    protected double y;

    // 有参构造方法 , 以形参表中的参数初始化半径，圆心为坐标原点（x=0,y=0）
    public Circle(double radius) {
        this.radius = radius;
    }

    // 获取半径的值方法
    public double getRadius() {
        return radius;
    }
    // 设置半径的值方法
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 获取x坐标点
    public double getX() {
        return x;
    }
    // 给x坐标设置
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // 获得图形的面积
    @Override
    public int getArea() {
        return (int) (PI * radius*radius);
    }

    // 获得图形的周长
    @Override
    public int getCircumference() {
        return (int) (PI * 2 * radius);
    }

    // 利用形参表中的参数设置类Circle的圆心坐标
    public void setCenter(double x, double  y){
        // 不许要实现此功能
    }
}

```

```java
package com.itheima.homework.test3;
/*
    1. 编写一个接口ShapePara，要求： 接口中的方法：
        int getArea()：获得图形的面积。
        int getCircumference()：获得图形的周长

    2. 编写一个圆类Circle，要求：圆类Circle实现接口ShapePara。
        该类含有一个静态常量：
        PI： double类型，值为3.14
        该类包含有成员变量：
        radius: public修饰的double类型radius,表示圆的半径。
        x:	private修饰的double型变量x，表示圆心的横坐标。
        y:	protected修饰的double型变量y，表示圆心的纵坐标。

   **包含的方法有：**

   ```java
   Circle(double radius) 有参构造方法。以形参表中的参数初始化半径，圆心为坐标原点（x=0,y=0）。

   double getRadius()：获取半径为方法的返回值。
   void setRadius(double  radius)：利用形参表中的参数设置类Circle的radius域。

   void setCenter(double x, double  y)：利用形参表中的参数设置类Circle的圆心坐标。

```

请根据上述要求代码实现相关类和接口，并定创建测试类，定义一个圆对象。半径为10，求周长和面积。

```
注：
圆周长公式： 周长 = PI*2*radius
圆面积公式： 面积 = PI * radius*radius
​```

**代码：**
 */
public class Test3 {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        // 获取圆的面积
        System.out.println(circle.getArea());
        // 获取圆的周长
        System.out.println(circle.getCircumference());

    }
}
```



## 题目4

创建接口Charge(计费方法)，其中有一个抽象方法charge()， 
创建接口Play，其中有一个抽象方法play()，
创建类Bus来实现接口Charge，对于Bus中的charge()，实现为输出“公共汽车：1元/张，不计公里数”。 
创建类Taxi来实现接口Charge，对于Taxi中的charge()，实现为输出“出租车：1.6元/公里，起价3公里。” 

声明类Cinema来同时实现接口Charge，Play。对于Cinema中的charge()，实现为输出`解放电影院：“30元/张，凭学生证享受半价。”` 对于Cinema中的play()。实现输出为`“正在放映电影。“` 

在测试类中创建Bus，Taxi，Cinema的对象，调用方法输出结果。



**代码：**

​```java
package com.itheima.homework.test4;

// 播放接口
public interface Play {
    // 播放方法
    public abstract void play();
}

```

```java
package com.itheima.homework.test4;
//  费用
public interface Charge {
    // 费用方法
    public abstract void charge();
}

```

```java
package com.itheima.homework.test4;

/*
    创建接口Charge，其中有一个抽象方法charge()， 
    创建接口Play，其中有一个抽象方法play()，
    创建类Bus来实现接口Charge，对于Bus中的charge()，实现为输出“公共汽车：1元/张，不计公里数”。 
    创建类Taxi来实现接口Charge，对于Taxi中的charge()，实现为输出“出租车：1.6元/公里，起价3公里。” 

     声明类Cinema来同时实现接口Charge，Play。对于Cinema中的charge()，实现为输出`解放电影院：“30元/张，凭学生证享受半价。”
     对于Cinema中的play()。实现输出为`“正在放映电影。“` 

    在测试类中创建Bus，Taxi，Cinema的对象，调用方法输出结果。
 */
public class Test4 {
    public static void main(String[] args) {

        Bus bus = new Bus();
        bus.charge();

        Taxi taxi = new Taxi();
        taxi.charge();

        Cinema cinema = new Cinema();
        cinema.charge();
        cinema.play();
    }
}

// 公交车
class Bus implements Charge {

    @Override
    public void charge() {
        System.out.println("公共汽车：1元/张，不计公里数");
    }
}

// 公交车
class Taxi implements Charge {

    @Override
    public void charge() {
        System.out.println("出租车：1.6元/公里，起价3公里");
    }
}

// 电影院
class Cinema implements Charge, Play {

    @Override
    public void charge() {
        System.out.println("30元/张，凭学生证享受半价");
    }

    @Override
    public void play() {
        System.out.println("正在放映电影");
    }
}
```



运行结果：

```java
公共汽车：1元/张，不计公里数
出租车：1.6元/公里，起价3公里
30元/张，凭学生证享受半价
正在放映电影
```





# 【枚举】

## 题目5

请为性别，方向，季度，星期，月份定义枚举类型表示。

```java
方向：上，下，左，右
季节：春，夏，秋，冬
星期：星期一....星期日
```



答案：

```java
package com.itheima.homework.test5;

// 方向
public enum Orientation {
    UP, DOWN, LEFT, RIGHT;
}

```

```java
package com.itheima.homework.test5;
//  季节：春，夏，秋，冬
public enum Season {
    SPRING , SUMMER , AUTUMN , WINTER;
}

```

```java
package com.itheima.homework.test5;

// 星期：星期一....星期日
public enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

```



## 题目6

创建一个类学生类，定义属性姓名，年龄，性别。要求性别使用枚举类型只能是男或者女两种值。

创建测试类，定义两个学生对象，设置属性值如下：

```java
姓名：小明，年龄：18，性别：男
姓名：小红，年龄：19，性别：女
```

要求：枚举名使用Sex，枚举常量名 BOY表示男，Girl表示女。



**答案：**

```java
package com.itheima.homework.test6;

/*
    创建一个类学生类，定义属性姓名，年龄，性别。要求性别使用枚举类型只能是男或者女两种值。
    创建测试类，定义两个学生对象，设置属性值如下：

    姓名：小明，年龄：18，性别：男
    姓名：小红，年龄：19，性别：女

    要求：枚举名使用Sex，枚举常量名 BOY表示男，Girl表示女。
 */
public class Test6 {
    public static void main(String[] args) {
        Student s = new Student("小明", 18, Sex.BOY);
        s.show();

        Student s2 = new Student("小红", 19, Sex.GIRL);
        s2.show();

    }
}

class Student {
    private String name;
    private int age;
    private Sex sex;

    public Student() {
    }

    public Student(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void show() {
        System.out.println("姓名：" + name + "，年龄：" + age + "，性别：" + sex.getSex());
    }
}


enum Sex {
    BOY("男"), GIRL("女");

    private String sex;

    private Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
```
