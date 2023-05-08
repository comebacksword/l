## 选择题

### 题目1(单选):

**在下列选项中选出编译时期异常(  D  )**

#### 选项 :

​	A. ArrayIndexOutOfBoundsException

​	B. NullPointerException

​	C. ClassCastException

​	D. ParseException



### 题目2(多选):

**JVM默认处理异常的方案是(  ABD )**

#### 选项 : 

​	A. 打印异常的类型

​	B. 打印异常的原因

​	C. 打印异常的体系

​	D. 打印异常的位置



### 题目3(单选):

**下列对于捕获异常说法错误的是( C )**

#### 选项 :

​	A. 如果 try 中没有遇到问题 , 从上往下依次执行 , catch中不执行

​	B. 如果 try 中代码遇到了问题,下面的代码不会执行,会拿当前异常对象和异常类型匹配,匹配成功执行处理异常代码

​	C. 如果 try 中出现了异常 , 会把异常对象抛给调用者

​	D. 如果异常没有捕获到 , 虚拟机会帮助我们处理



### 题目4(多选):

**对于自定义异常的步骤正确的排序是（BAC) **

#### 选项 :

​	A. 如果定义的是编译时期异常需要继承Exception , 如果是运行时期异常需要继承RuntimeException

​	B. 定义异常类,类名以Exception结尾

​	C. 生成空参构造有参构造方法



### 题目5(单选):

**下列对于Lambda表达式的格式  ( 形式参数 )  -> { 代码块 ) 说法错误的是 ( B  )**

#### 选项 :

​	A. Lambda表达式必须作用在函数式接口上

​	B. 形式参数：如果有多个参数，参数之间用分号隔开；如果没有参数，留空即可

​	C. ->：由英文中画线和大于符号组成，固定写法。代表指向动作

​	D. 代码块：是我们具体要做的事情，也就是以前我们写的方法体内容



### 题目6(单选):

**下列对于Lambda表达式的省略模式说法错误的是( D )**

#### 选项 :

​	A. 参数类型可以省略，但是有多个参数的情况下，不能只省略一个

​	B. 如果参数有且仅有一个，那么小括号可以省略

​	C. 如果代码块的语句只有一条，可以省略大括号和分号和return，不能只省略一个

​	D. Lambda的指向箭头->可以省略 



### 题目7(多选):

**下列关于Stream流中获取功能有哪些( ACD )**

#### 选项 :

​	A. Collection接口中的默认方法stream()生成流

​	B. Map接口中的默认方法stream()生成流

​	C. Arrays中的静态方法stream生成流

​	D. Stream类中of方法生成流



### 题目8(多选):

**下列关于Stream流中中间功能有哪些( ABD )**

#### 选项 :

​	A. filter()方法用于对流中的数据进行过滤

​	B. sorted()方法将流中元素进行排序

​	C. collector()方法收集流中的数据

​	D. limit()方法截取指定参数个数的数据



### 题目9(多选):

**下列关于Stream流中终结功能有哪些((ABD )**

#### 选项 :

​	A. forEach()方法对流中的元素遍历

​	B. count()方法返回此流中的元素数

​	C. skip()方法跳过指定参数个数的数据

​	D. collector()方法收集流中的数据



### 题目10(单选):

**观察以下Stream流代码,最终输出的结果为( A )**

```java
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张三丰", "张翠山", "张无忌", "张三", "赵四");
        long count = list.stream().filter(s -> s.length() == 3).skip(2).count();
        System.out.println(count);
    }
}
```

#### 选项 :

​	A.  1

​	B.  2

​	C.  张翠山 , 张无忌

​	D.  张无忌

