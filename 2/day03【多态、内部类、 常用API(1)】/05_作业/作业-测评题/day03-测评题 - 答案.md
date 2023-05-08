## 选择题

### 题目1(多选):

**下列关于多态的前提描述正确的是(  ACD  )**

#### 选项 :

​	A. 继承/实现关系

​	B. 子父类存在同名成员变量

​	C. 方法重写 

​	D. 父类的引用指向子类的对象



### 题目2(单选):

**下列关于多态成员访问的特点错误的是(  C  )**

#### 选项 :

​	A. 构造方法和继承一样 , 子类通过super()访问父类的构造方法

​	B. 成员变量编译看左边(父类) , 执行看左边(父类)

​	C. 成员变量就近原则

​	D. 成员方法编译看左边(父类) , 执行看右边(子类)



### 题目3(单选):

**查看下列代码 , 选出程序正确的执行结果( C )**

```java
public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        ((Cat)a).catchMouse();
    }
}

abstract class Animal {
    public abstract void eat();
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }
}
class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
    public void catchMouse(){
        System.out.println("猫抓老鼠");
    }
}
```

#### 选项 :

​	A. 猫抓老鼠

​	B. 编译报错

​	C. ClassCastException异常

​	D. 正常执行, 无任何输出结果



### 题目4(单选):

**下列关于成员内部类创建对象的格式正确的是（C ) **

#### 选项 :

​	A. 外部类名  对象名 = new 外部类名.new 内部类名(参数);

​	B. 外部类名  对象名 = new 外部类名(参数).new 内部类名(参数);

​	C. 外部类名.内部类名  对象名 = new 外部类名(参数).new 内部类名(参数);

​	D. 外部类名.内部类名  对象名 = new 外部类名.内部类名(参数);



### 题目5(单选):

**下列关于Object类中toString方法说法错误的是 ( D )**

#### 选项 :

​	A. 如果一个类没有重写toString方法 , 那么打印此类的对象 , 打印的是此对象的地址值

​	B. 如果一个类重写了toString方法 , 那么打印此类的对象 , 打印的是此对象的属性值

​	C. toString方法作用是把对象转成字符串 , 快速查看一个对象的属性值

​	D. 如果想要执行toString方法,需要使用对象进行调用



### 题目6(单选):

**下列关于Object类中equals方法说法错误的是 ( D )**

#### 选项 :

​	A. ==比较基本数据类型比较的是数据值 , 比较引用数据类型比较的是地址值

​	B. 如果一个类没有重写equals方法 , 那么比较此类的对象 . 比较的是地址值

​	C. 如果一个类重写了equals方法 . 那么比较此类的对象 , 比较的是属性值是否相等

​	D.使用equals方法主要的目的是比较地址值是否相等



### 题目7(单选):

**观察以下代码,选出格式化日期的正确选项 ( B )**

```java
public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat(__待填写内容__);

        String strDate = sdf.format(date);
		// 打印效果:  "2021年12月01日 15:37:11:123"
        System.out.println(strDate);
    }
}
```



#### 选项 :

​	A.  "yyyy/MM/dd HH:mm:ss"

​	B. "yyyy年MM月dd日 HH:mm:ss:SSS"

​	C. "yyyy年MM月dd日 HH:mm:ss"

​	D. "yyyy-MM-dd HH:mm:ss:SSS"



### 题目8(多选):

**下列属于Math类中的方法有( ABD )**

#### 选项 :

​	A. round()

​	B. pow()

​	C. sort()

​	D. random()

