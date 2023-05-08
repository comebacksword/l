# day14



# 1 代理设计模式

### 学习目标

- 能够理解在代码设计中，代理模式的作用

### 学习内容

**1）概述**

为什么要有“代理”？

- 生活中就有很多例子，比如委托业务，黄牛（票贩子）等等，**代理就是被代理者没有能力或者不愿意去完成某件事情，需要找个人代替自己去完成这件事**，这才是“代理”存在的原因。例如要租房子，房产中介可以在我们住房前代理我们找房子。中介就是代理，而自己就是被代理了。



**作用 : 在代码设计中，代理模式作用主要就是让被代理对象的某个方法执行之前或者执行之后加入其他增强逻辑。**

```
前增强
被代理对象调用方法；
后增强
```

举例 : 现在要执行一个方法 , 我们想要计算执行的时间 , 可以时间前增强和后增强计算时间差



**2）实现代理的前提条件**

- 抽象角色 ：声明功能
- 代理角色 ：实现抽象功能，完成代理逻辑
- 被代理角色 ：实现抽象功能



**意味着被代理角色和代理角色有着共同的父类型（既抽象角色)**



![image-20200908090026037](D:/传智播客/课程资料/JavaSe课程/JavaSE参考视频/day14【反射，注解，动态代理模式】/01_笔记/day14【反射，注解，动态代理模式】/imgs/image-20200908090026037.png) 

**3) 代理模式存在两种实现方式：**

1. 静态代理
2. 动态代理



### 知识小结

1. 请说出代码中代理模式的作用？

   ```
   被代理某个方法执行的前或者后进行功能增强
   ```

2. 请说出代理模式中的三个角色？

   ```
   抽象角色
   代理角色
   被代理角色
   ```

   

## 1.1 静态代理

### 学习目标

- 能够写出静态代理模式代码

### 内容讲解

- 静态代理是由程序员创建或工具生成代理类的源码  , 再编译代理类。

  在程序运行前就已经存在代理类的字节码文件，代理类和被代理类的关系在运行前就确定了。

  **简单理解 : 在程序运行前 , 代理类就已经存在了 , 后面要学习的动态代理恰好相反 , 是程序运行时动态产生**



- **静态代理实现的步骤 ：**

  - 存在一个抽象角色
  - 定义被代理角色
  - 定义代理，增强被代理角色的功能

  

- **案例实践：**

  以现实中 , 经纪人代理明星

  **已知存在接口：**

  ```java
  //1.抽象角色
  interface Star {
      double liveShow(double money);
      
      void sleep();
  }
  ```

- **定义被代理类：**

  定义王宝强类，实现Star方法

  ```java
  
  ```

- **定义代理类：**

  定义宋喆经纪人类

  ```java
  
  ```

- ##### 定义测试类进行测试

  ```java
  
  ```

  

- 关系图：

![image-20200908092851064](D:/传智播客/课程资料/JavaSe课程/JavaSE参考视频/day14【反射，注解，动态代理模式】/01_笔记/day14【反射，注解，动态代理模式】/imgs/image-20200908092851064.png) 

宋喆和宝强都有共同的父类型。他们的业务方法都是一样。



静态代理和装饰模式的对比

原则上的区别，**代理为了控制对某个函数前后的操作**，而**装饰着模式是为了添加某一操作**（其实目标没差太远）



### 知识小结

- 请问什么叫做静态代理？

  代码执行前，已经确定了代理的代码逻辑。




## 1.2 动态代理

### 学习目标

- 能够知道什么是动态代理
- 能够熟悉动态代理相关API
- 能够熟悉动态代理代码执行流程

### 内容讲解

#### 1）概述

- 在实际开发过程中往往我们自己不会去创建代理类而是通过JDK提供的`Proxy`类在程序运行时

  运用反射机制动态创建而成，这就是我们所谓的**动态代理**。

```
与静态代理之间的区别，在于不用自己写代理类
	1 静态代理是在程序执行前, 已经存在了代理类
	2 动态代码是程序执行时 , 通过反射技术动态生成代理对象
```



- 虽然我们不需要自己定义代理类型创建代理对象

  但是我们要定义对**被代理对象直接访问方法的拦截，以实现在真实对象访问方法的前后增强功能**。



- 动态代理技术在框架中使用居多，例如：很快要学到的数据库框架MyBatis框架等后期学的一些主流框架技术（Spring，SpringMVC）中都使用了动态代理技术。



#### 2）API学习

- **Proxy类**

- `java.lang.reflect.Proxy`类提供了用于创建动态代理类和实例的**静态方法**

  它还是由这些方法创建的所有动态代理类的超类（代理类的父类是Proxy）。 

  

```java
public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)获取代理对象的方法 
    
- 返回值：该方法返回就是动态生成的代理对象
- 参数列表说明：
  1. ClassLoader loader 	- 定义代理类的类加载器
  2. Class<?>[] interfaces 	- 代理类要实现的接口列表，要求与被代理类的接口一样。
  3. InvocationHandler h 	- 就是具体实现代理逻辑的接口 
```



- InvocationHandler接口

  源码：

  ```java
  interface InvocationHandler{
      //代理逻辑
  	public Object invoke(Object proxy, Method method, Object[] args);
  }
  ```

  `java.lang.reflect.InvocationHandler`是代理对象的实际处理代理逻辑的接口，具体代理实现逻辑在其 invoke 方法中。

  **所有代理对象调用的方法，执行是都会经过invoke**。因此如果要对某个方法进行代理增强，就可以在这个invoke方法中进行定义。

  ​	

  方法说明如下：

  ```java
  public Object invoke(Object proxy, Method method, Object[] args);
    
  1. 返回值：方法被代理后执行的结果。
  2. 参数列表：
     1. proxy 	- 就是代理对象
     2. method 	- 代理对象调用的方法
     3. args 		- 代理类调用方法传入参数值的对象数组，如果方法不使用参数，则为 null。
    					 基本类型的参数被包装在适当基本包装器类的实例中。
  ```

  

#### 3）代码实践

- 将经纪人代理明星的案例使用动态代理实现
  - 把父接口定义
  - 定义被代理类：宝强
  - 动态生成代理类
  - 定义代理逻辑

```java
package _10动态代理的代码实现;

import java.beans.XMLEncoder;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Demo01 {
    public static void main(String[] args) {
        BaoQiang baoQiang = new BaoQiang();//被代理对象
        ClassLoader classLoader = baoQiang.getClass().getClassLoader();//获取类加载器
        Class[] interfaces = baoQiang.getClass().getInterfaces();//获取一个类型的所有实现的接口
        InvocationHandler handler = new MyInvocationHandler(baoQiang);//调用处理器
        //代理对象生成
        Star songZe = (Star) Proxy.newProxyInstance(classLoader, interfaces, handler);

        double result = songZe.liveShow(200);
        System.out.println("result = " + result);
        
        songZe.sleep();
    }
}


class MyInvocationHandler implements InvocationHandler {
    private BaoQiang baoQiang;

    public MyInvocationHandler(BaoQiang baoQiang) {
        this.baoQiang = baoQiang;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //特点：代理对象执行的方法，都会经过该方法

        Object result = null;//用来保存被代理对象方法执行的结果
        //前增强
        long t1 = System.currentTimeMillis();

        if (method.getName().equals("liveShow")) {
            //增强liveShow方法

            //前增强
            double money = (double) args[0];
            System.out.println("宋喆获取佣金：" + money * 0.8);

            result = method.invoke(baoQiang, money * 0.2);
            //后增强
            System.out.println("宋喆给宝强存了" + result + "元");

        } else {
            //没有受到额外的增强
            result = method.invoke(baoQiang, args);
        }

        //前后增强
        long t2 = System.currentTimeMillis();
        System.out.println(method.getName() + "运行花费时间：" + (t2 - t1));

        return result;
    }
}


class MyInvocationHandler2 implements InvocationHandler {
    BaoQiang baoQiang;

    public MyInvocationHandler2(BaoQiang baoQiang) {
        this.baoQiang = baoQiang;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //前增强
        //xxxx

        Object result = method.invoke(baoQiang, args);//被代理对象执行的方法

        //后增强
        //xxxx

        return result;
    }
}


//1.抽象角色
interface Star {
    double liveShow(double money);

    void sleep();
}

//2.被代理角色
class BaoQiang implements Star {

    @Override
    public double liveShow(double money) {
        System.out.println("宝强参加了一个真人秀节目，赚了" + money + "元");
        return money;
    }

    @Override
    public void sleep() {
        System.out.println("宝强累了，睡觉了！！");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

```



动态代理调用流程：

![image-20210306173851168](D:/传智播客/课程资料/JavaSe课程/JavaSE参考视频/day14【反射，注解，动态代理模式】/01_笔记/day14【反射，注解，动态代理模式】/imgs/image-20210306173851168.png)  

### 知识小结

1. 什么是动态代理？

   在代码执行前，没有代理类，代理类是在程序运行的时候动态生成

   ```
   Proxy.newProxyInstance
   ```

   

2. 动态代理有什么好处？

   动态代理可以为被代理对象的所有接口的所有方法做代理，动态代理可以在不改变方法源码的情况下，实现对方法功能的增强。

   

3. 动态代理相关的API有哪些？

   ```markdown
   Proxy
   	public static Object newProxyInstance(类加载器，接口列表，调用处理器)
   	类加载器 = 被代理对象.getClass().getClassLoader();
   	接口列表 = 被代理对象.getClass().getInterfaces();
   	调用处理器 = new InvocationHandler(){   实现  invoke 方法 };
   
   InvocationHandler
   	public Object invoke(代理对象,方法对象,方法的实参类别) 该方法执行时机是，代理对象调用方法时触发执行
   ```

   

4. 动态代理类的字节码在程序运行时由Java反射机制动态生成，无需程序员手工编写它的源代码。 

5. 缺点：只能针对接口的实现类做代理对象，普通类是不能做代理对象的。

   后面框架学习的时候会接触到CGLib（Code Genneration Library ）： 可以实现对类的代理