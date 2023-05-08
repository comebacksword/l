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

# 【异常】

## 题目1

请定义main()方法，在main()中按以下顺序要求编写代码：

1. 分别从控制台接收两个整数
1. 计算“第一个数 / 第二个数”的结果，并打印；
1. 为了防止第二个数为0导致异常，请在计算时使用异常处理。当出现异常时，向用户打印：第二个数不能为0！！

答案：

```java
package com.itheima.homework.test1;

import java.util.Scanner;

/*
    请定义main()方法，在main()中按以下顺序要求编写代码：
        1. 分别从控制台接收两个整数
        2. 计算“第一个数 / 第二个数”的结果，并打印；
        3. 为了防止第二个数为0导致异常，请在计算时使用异常处理。当出现异常时，向用户打印：第二个数不能为0！！
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个整数:");
        int num1 = sc.nextInt();

        System.out.println("请输入第二个整数:");
        int num2 = sc.nextInt();

        try {
            System.out.println(num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0!");
        }
    }
}

```





## 题目2

 请定义main()方法，在main()中按以下顺序要求编写代码：

1. 定义一个String[]数组如下：

   `String[] arr = {”星期一”,”星期二”,”星期三”,”星期四”,”星期五”,”星期六”,”星期日”};`

1. 请用户输入一个整数1--7的值：
   根据用户输入，从数组中取出对应的星期名称，例如：
   用户输入：1
   程序提示：星期一

1. 为了防止用户输入小于1或者大于7的值，请使用异常处理从数组中取出对应的“星期名称”，在异常处理中打印：输入错误！！



答案：

```java
package com.itheima.homework.test2;

import java.util.Map;
import java.util.Scanner;

/*
     请定义main()方法，在main()中按以下顺序要求编写代码：

    1. 定义一个String[]数组如下：
       String[] arr = {”星期一”,”星期二”,”星期三”,”星期四”,”星期五”,”星期六”,”星期日”};

    2. 请用户输入一个整数1--7的值：
       根据用户输入，从数组中取出对应的星期名称，例如：
       用户输入：1
       程序提示：星期一

    3. 为了防止用户输入小于1或者大于7的值，请使用异常处理从数组中取出对应的“星期名称”，在异常处理中打印：输入错误！！
 */
public class Test2 {
    public static void main(String[] args) {
        String[] arr = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入1-7:");
        int weekDay = sc.nextInt();

        try {
            System.out.println(arr[1- weekDay]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("录入的数据不再1-7之间");
        }
    }
}

```



# 【自定义异常】

## 题目3

按以下步骤要求编写代码：

1. 定义一个“年龄异常类”：AgeException，使其继承自RuntimeException，并添加无参、String参数的构造方法；
1. 定义一个“性别异常类”：SexException，使其继承自RuntimeException，并添加无参、String参数的构造方法；
1. 定义一个Student类，属性：姓名、性别、年龄。
   在性别的set方法中判断是否是男/女，如果不是则抛出：性别异常
   在年龄的set方法中判断年龄是否是15--50之间，如果不是则抛出：年龄异常
1. 编写测试类，创建一个Student对象，并在try{}中调用setXxx()方法为对象属性赋值，在catch()中打印年龄错误。



答案：

AgeExeption

```java
package com.itheima.homework.test3;

public class AgeException extends RuntimeException {

    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }
}

```

SexException

```java
package com.itheima.homework.test3;

public class SexException extends RuntimeException {

    public SexException() {
    }

    public SexException(String message) {
        super(message);
    }
}

```

Student

```java
package com.itheima.homework.test3;

public class Student {
    private String name;
    private String sex;
    private int age;

    public Student() {
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
        if (!(sex.equals("男") || sex.equals("女"))) {
            throw new SexException();
        }
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 15 || age > 50) {
            throw new AgeException();
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}

```

测试类

```java
package com.itheima.homework.test3;

/*
    按以下步骤要求编写代码：

    1. 定义一个“年龄异常类”：AgeException，使其继承自RuntimeException，并添加无参、String参数的构造方法；
    2. 定义一个“性别异常类”：SexException，使其继承自RuntimeException，并添加无参、String参数的构造方法；
    3. 定义一个Student类，属性：姓名、性别、年龄。
       在性别的set方法中判断是否是男/女，如果不是则抛出：性别异常
       在年龄的set方法中判断年龄是否是15--50之间，如果不是则抛出：年龄异常
    4. 编写测试类，创建一个Student对象，并在try{}中调用setXxx()方法为对象属性赋值，在catch()中打印年龄错误。
 */
public class Test3 {
    public static void main(String[] args) {
        Student s = new Student();

        try {
            s.setAge(100);
        } catch (AgeException e) {
            System.out.println("年龄有误");
        }

        System.out.println(s);
    }
}

```









## 题目4

请使用代码描述 

1. 写一个方法实现用户登陆，传入用户名和密码 

2. 如果用户名错误，就抛出自定义登陆异常(LoginException)，异常信息为用户名不存在。 

3. 如果密码错了就也抛出登陆异常,异常信息为密码错误 

4. 如果用户名和密码都对了,输出: 欢迎xxx 

说明：正确用户名和密码都是admin 

答案：

```java
package com.itheima.homework.test4;

/*
    请使用代码描述

    1. 写一个方法实现用户登陆，传入用户名和密码
    2. 如果用户名错误，就抛出自定义登陆异常(LoginException)，异常信息为用户名不存在。
    3. 如果密码错了就也抛出登陆异常,异常信息为密码错误
    4. 如果用户名和密码都对了,输出: 欢迎xxx
    说明：正确用户名和密码都是admin
 */
public class Test4 {
    public static void main(String[] args) {
        try {
            login("admin", "admin1111");
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public static void login(String username, String password) {
        if (!username.equals("admin")) {
            throw new LoginException("用户名错误");
        } else if (!password.equals("admin")) {
            throw new LoginException("密码错误");
        } else {
            System.out.println("登录成功,欢迎xxx");
        }
    }
}

```





# 【线程】

## 题目5

请使用继承Thread类的方式定义一个线程类，在run()方法中使用循环变量i遍历1--1000所有的数字。

定义main()方法，启动这个线程，然后再使用循环变量k遍历1--1000所有的数字。

请观察控制台打印，i和k交叉打印的情况



答案：

```java
package com.itheima.homework.test5;

/*
    请使用继承Thread类的方式定义一个线程类，在run()方法中使用循环变量i遍历1--1000所有的数字。
        1 定义main()方法，启动这个线程，然后再使用循环变量k遍历1--1000所有的数字。
        2 请观察控制台打印，i和k交叉打印的情况
 */
public class Test5 {
    public static void main(String[] args) {
        MyThread mt = new MyThread("线程1:");
        mt.start();
        for (int k = 0; k < 1000; k++) {
            System.out.println(Thread.currentThread().getName() + ": " + k);
        }
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

```






## 题目6

请使用实现Runnable接口的方式定义一个类，在run()方法中使用循环变量i遍历1--1000所有的数字。

定义main()方法，启动这个线程，然后再使用循环变量k遍历1--1000所有的数字。

请观察控制台打印，i和k交叉打印的情况。



答案：

```java
package com.itheima.homework.test6;

/*
 请使用实现Runnable接口的方式定义一个类，在run()方法中使用循环变量i遍历1--1000所有的数字。

    定义main()方法，启动这个线程，然后再使用循环变量k遍历1--1000所有的数字。

    请观察控制台打印，i和k交叉打印的情况。
 */
public class Test6 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable() , "线程1:");
        thread.start();
        for (int k = 0; k < 1000; k++) {
            System.out.println(Thread.currentThread().getName() + ": " + k);
        }
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

```





## 题目7

请使用继承Thread类的方式定义一个线程类，在run()方法中循环10次，每1秒循环1次，每次循环按“yyyy-MM-dd HH:mm:ss”的格式打印当前系统时间。

请定义测试类，并定义main()方法，启动此线程，观察控制台打印。

答案：

```java
package com.itheima.homework.test7;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    请使用继承Thread类的方式定义一个线程类，在run()方法中循环10次
    每1秒循环1次，每次循环按“yyyy-MM-dd HH:mm:ss”的格式打印当前系统时间。

    请定义测试类，并定义main()方法，启动此线程，观察控制台打印。
 */
public class Test7 {
    public static void main(String[] args) {
        new MyThread().start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = sdf.format(date);
            System.out.println(strDate);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

```



## 题目8

请使用“匿名Runnable”子类的方式实现线程，线程中计算1--500所有数字的累加和，并打印计算结果



```java
package com.itheima.homework.test8;

/*
    请使用“匿名Runnable”子类的方式实现线程，线程中计算1--500所有数字的累加和，并打印计算结
 */
public class Test8 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            int sum = 0;

            @Override
            public void run() {
                for (int i = 1; i <= 500; i++) {
                    sum += i;
                }
                System.out.println(sum);
            }
        }).start();
    }
}
```

