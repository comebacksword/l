## day09

学习目标：

 * 掌握API的使用
 * 掌握String类的使用
    * 掌握常用构造方法的使用
    * 掌握常用方法的使用
 * 掌握StringBuilder类的使用
    * 掌握常用构造方法额使用
    * 掌握常用方法的使用

### 1. API（Application Programming Interface，应用程序接口）

```java
Java API ：指的就是 JDK 中提供的各种功能的 Java类
这些类将底层的实现封装了起来，我们不需要关心这些类是如何实现的，
只需要学习这些类如何使用即可，我们可以通过帮助文档来学习这些API如何使用
```

#### 1.1 API使用的步骤

```java
/*
    API学习：
        1.API的使用
            1.1 打开API
            1.2 在索引下面搜索框中，填写你要查找的类 按下回车键 或 双击类名
            1.3 查看包结构
            1.4 查看描述
            1.5 学习常用构造方法
            1.6 学习常用的成员方法

 */
public class Demo01 {
    public static void main(String[] args) {

        //Scanner(InputStream source)
        //构造一个新的 Scanner ，产生从指定输入流扫描的值。
        Scanner scanner = new Scanner(System.in);


    }
}
```

#### 1.2API之Scanner

```java
import java.io.InputStream;
import java.util.Scanner;

/*
    Scanner类的使用:
        1. 在API中查找Scanner
        2. 查看包结构
            java.util.Scanner

           类结构：
            public final class Scanner extends Object implements Iterator<String>, Closeable
        3. 查看描述：
            一个简单的文本扫描器
        4.常用构造方法：
            Scanner(InputStream source) 构造一个新的 Scanner ，产生从指定输入流扫描的值。
        5.常用成员方法
            int nextInt() 将输入的下一个标记扫描为 int 。
            String next() 查找并返回此扫描仪的下一个完整令牌。
            String nextLine() 将此扫描仪推进到当前行并返回跳过的输入。

 */
public class Demo02Scanner类的使用 {
    public static void main(String[] args) {
       /* InputStream source = System.in;
        Scanner scanner = new Scanner(source);*/
        Scanner sc = new Scanner(System.in);
        //int nextInt() 将输入的下一个标记扫描为 int 。
        /*System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        System.out.println(num);*/

        //String next() 查找并返回此扫描仪的下一个完整令牌。 遇到空格结束数据接收
        System.out.println("请输入一个字符串：");
        String s1 = sc.next();
        System.out.println(s1);

        //String nextLine() 将此扫描仪推进到当前行并返回跳过的输入。遇到回车换行，就结束数据接收
        System.out.println("请输入一个字符串：");
        String s2 = sc.nextLine();
        System.out.println(s2);
    }
}
```

#### 1.3 键盘录入练习 

```java
import java.util.Scanner;

/*
    键盘录入姓名和年龄 性别，封装成学生对象，并输出值
    分析：
        1.键盘录入
        2.创建学生类
        3.使用构造方法创建对象 封装 输出值
 */
public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的姓名：");
        String name = sc.nextLine();
        System.out.println(name);
        System.out.println("请输入学生的年龄：");
        int age = sc.nextInt();
        System.out.println(age);
        System.out.println("请输入学生的性别：");
        String gender = sc.next();
        System.out.println(gender);
        // 3.使用构造方法创建对象
        Student student = new Student();
        //封装数据
        student.setName(name);
        student.setAge(age);
        student.setGender(gender);

        //输出值
        System.out.println(student.getName()+"..."+student.getAge()+"..."+ student.getGender());


    }
}

```

```java
public class Student {
    private String name;
    private int age;
    private String gender;

    public Student() {
    }

    public Student(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

```



#### 1.4  Scanner类中next()和nextLine方法的区别

```java
import java.util.Scanner;

/*
    Scanner类中next()和nextLine方法的区别
 */
public class Demo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s1 = sc.next();
        System.out.println(s1);

        System.out.println("请输入一个字符串：");
        String s2 = sc.nextLine();
        System.out.println(s2);

        System.out.println("请输入一个字符串：");
        String s3 = sc.nextLine();
        System.out.println(s3);
    }
}

```

#### 1.5 Scanner异常

```java
import java.util.Scanner;

/*
    Scanner异常:
         //不匹配或超出范围 InputMismatchException
         //如果此扫描仪已关闭 :IllegalStateException

 */
public class Demo05Scanner异常 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        sc.close(); java.lang.IllegalStateException
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        System.out.println(num);
        /*
            请输入一个整数：a
            //不匹配或超出范围
            报错：java.util.InputMismatchException

            如果此扫描仪已关闭 :
            java.lang.IllegalStateException
         */
    }
}

```

#### 1.6 Random类

```java
import java.util.Random;

/*
    Random类：
        1.类结构
            java.util.Random
            public class Random extends Object implements Serializable
        2.学习类的描述
            该类的实例用于生成伪随机数的流
        3.构造方法
            Random() 创建一个新的随机数生成器。
            Random(long seed) 使用单个 long种子创建一个新的随机数生成器。
        4.成员方法中的常用方法
            //int nextInt(int bound)返回伪随机的，均匀分布 int值介于0（含）和指定值（不包括），从该随机数生成器的序列绘制。
            //int nextInt() 返回下一个伪随机数，从这个随机数发生器的序列中均匀分布 int值。
        5.nextInt方法中出现的异常
            IllegalArgumentException: bound must be positive

 */
public class Demo06Random {
    public static void main(String[] args) {
        //Random() 创建一个新的随机数生成器。
        Random random = new Random();
        System.out.println(random);
        //Random(long seed) 使用单个 long种子创建一个新的随机数生成器。
        Random random1 = new Random(100L);
        System.out.println(random1);

        //常用方法
        //int nextInt(int bound)返回伪随机的，均匀分布 int值介于0（含）和指定值（不包括），从该随机数生成器的序列绘制。
        int num = random.nextInt(10);
        System.out.println(num);

        //int nextInt() 返回下一个伪随机数，从这个随机数发生器的序列中均匀分布 int值。
        int num2 = random.nextInt();
        System.out.println(num2);

        /*
            java.lang.IllegalArgumentException: bound must be positive
         */
//        int num3 = random.nextInt(0);
//        System.out.println(num3);

    }
}

```

### 2.String类的学习

#### 2.1String类的概述和构造方法

```java
import java.util.Arrays;

/*
    String:
        1.查看类结构
            java.lang.String
            public final class String extends Object implements Serializable, Comparable<String>, CharSequence
        2.描述
            String类代表字符串。 Java程序中的所有字符串文字（例如"abc" ）都被实现为此类的实例。
            字符串不变; 它们的值在创建后不能被更改。因为String对象是不可变的，它们可以被共享。
        3.常用构造方法
            String(String original) 初始化新创建的String对象，使其表示与参数相同的字符序列; 换句话说，新创建的字符串是参数字符串的副本。
            String() 初始化新创建的 String对象，使其表示空字符序列。
            String(byte[] bytes)通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
            String(byte[] bytes, int offset, int length) 通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。
            String(char[] value) 分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。
            String(char[] value, int offset, int count) 分配一个新的 String ，其中包含字符数组参数的子阵列中的字符。
 */
public class Demo01 {
    public static void main(String[] args) {
        String name1 = "张三";
        String name2 = "张三";
        //String(String original) 初始化新创建的String对象，使其表示与参数相同的字符序列; 换句话说，新创建的字符串是参数字符串的副本。
        String name3 = new String("张三");
        String name4 = new String("张三");
//        System.out.println(name3 == name4);
        //String() 初始化新创建的 String对象，使其表示空字符序列。
        String s1 = new String();//String s = "";
        System.out.println(s1);
        //String(byte[] bytes)通过使用平台的默认字符集解码指定的字节数组来构造新的 String 。
        byte[] bytes = {97,98,99,100,101,102,103};
        String s2 = new String(bytes);
        System.out.println(s2);
        //String(byte[] bytes, int offset, int length) 通过使用平台的默认字符集解码指定的字节子阵列来构造新的 String 。
        String s3 = new String(bytes, 2, 3);
        System.out.println(s3);

        //String(char[] value) 分配一个新的 String ，以便它表示当前包含在字符数组参数中的字符序列。
        char[] chars = {'a','b','c','d','e','f','g'};
        String s4 = new String(chars);
        System.out.println(s4);
        //String(char[] value, int offset, int count) 分配一个新的 String ，其中包含字符数组参数的子阵列中的字符。
        String s5 = new String(chars, 0, 3);
        System.out.println(s5);

        //如果要定义一个已知值的字符串
        String s = "值";


    }
}
```

#### 2.2 面试题

```java
public class Demo02 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ab";
        String s3 = s2 + "c"; // new StringBuilder(s2).append("c").toString();
        String s4 = "ab" + "c";
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //true
    }
}
```

#### 2.3字符串的常用方法

```java
import java.util.Arrays;

/*
    字符串的常用方法：
        boolean equals(Object anObject) 将此字符串与指定对象进行比较。
        char charAt(int index) 返回 char指定索引处的值。
        boolean endsWith(String suffix) 测试此字符串是否以指定的后缀结尾。
        byte[] getBytes() 使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
        int length() 返回此字符串的长度。
        String replace(CharSequence target, CharSequence replacement) 将与字面目标序列匹配的字符串的每个子字符串替换为指定的字面替换序列。
        String substring(int beginIndex) 返回一个字符串，该字符串是此字符串的子字符串。
        String trim() 返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
 */
public class Demo03 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); //true
        String s3 = new String("abc");
        System.out.println(s1 == s3); //false
        //boolean equals(Object anObject) 将此字符串与指定对象进行比较。
        boolean b1 = s1.equals(s2);
        System.out.println(b1); //true
        boolean b2 = s1.equals(s3);
        System.out.println(b2); //true

        //char charAt(int index) 返回 char指定索引处的值。
        String s4 = "abcdefg";
//        char c = s4.charAt(0);
//        System.out.println(c);
        /*for (int i = 0; i < 7; i++) {
            char c1 = s4.charAt(i);
            System.out.println(c1);
        }*/
        //boolean endsWith(String suffix) 测试此字符串是否以指定的后缀结尾。
        String date = "2021年5月";
        boolean b3 = date.endsWith("5月");
        System.out.println(b3);
        //boolean startsWith(String prefix) 测试此字符串是否以指定的前缀开头。
        String s5 = "李家豪";
        boolean b4 = s5.startsWith("李");
        System.out.println(b4);
        //byte[] getBytes() 使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
        String name = "刘毅";
        byte[] bytes = name.getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));

        //boolean isEmpty()返回 true如果，且仅当 length()为 0 。
        String s6 = "";
        boolean b5 = s6.isEmpty();
        System.out.println(b5);
        System.out.println(s5.isEmpty());

        // int length() 返回此字符串的长度。
        String s7 = "abcdefg";
        int length = s7.length();
        System.out.println(length);
        /*for (int i = 0; i < s7.length(); i++) {
            System.out.println(s7.charAt(i));
        }*/
        //args.length

        //String replace(CharSequence target, CharSequence replacement) 将与字面目标序列匹配的字符串的每个子字符串替换为指定的字面替换序列。
        String massage = "你真的TMD你真的TMD你真的TMD你真的TMD";
        String replace = massage.replace("TMD", "***");
        System.out.println(replace);

        //String[] split(String regex) 将此字符串分割为给定的 regular expression的匹配。
        String stuInfo = "张三,23";
        String[] sp1 = stuInfo.split(",");
        System.out.println(Arrays.toString(sp1));

        //String substring(int beginIndex) 返回一个字符串，该字符串是此字符串的子字符串。
        String s8 = "abcdefg";
        String s9 = s8.substring(3);
        System.out.println(s9);
        //String substring(int beginIndex, int endIndex) 返回一个字符串，该字符串是此字符串的子字符串。
        String s10 = s8.substring(1, 3);
        System.out.println(s10);

        //char[] toCharArray() 将此字符串转换为新的字符数组。
        char[] chars = s8.toCharArray();
        System.out.println(Arrays.toString(chars));
       /* for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }*/
        //String toLowerCase()将所有在此字符 String使用默认语言环境的规则，以小写。
        String s11 = "ABCdefg";
        String s12 = s11.toLowerCase();
        System.out.println(s12);
        //String toUpperCase() 将所有在此字符 String使用默认语言环境的规则大写。
        String s13 = s11.toUpperCase();
        System.out.println(s13);

//        System.out.println(s11.equals(s12));//false

        //boolean equalsIgnoreCase(String anotherString) 将此 String与其他 String比较，忽略案例注意事项。
        System.out.println(s11.equalsIgnoreCase(s12));

        // String trim() 返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
        String username = "                      admin                 ";
        System.out.println(username);
        String s14 = username.trim();
        System.out.println(s14);

    }
}

```

#### 2.4 切割学生信息字符串，封装成学生对象

```java
/*
    切割学生信息字符串，封装成学生对象
 */
public class Demo04练习 {
    public static void main(String[] args) {
        String stuInfo = "张三,男,18";
        //使用split方法切割字符串
        String[] stu = stuInfo.split(",");
        String name = stu[0];
        String gender = stu[1];
        String age = stu[2];
        Student student = new Student();
        student.setName(name);
        student.setGender(gender);
        student.setAge(Integer.valueOf(age));//Integer.valueOf(age) 把字符串的数字，转成int类型的值


        System.out.println(student.getName());
        System.out.println(student.getGender());
        System.out.println(student.getAge());
    }
}

```

```java
public class Student {
    private String name;
    private String gender;
    private int age;

    public Student() {
    }

    public Student(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
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
}

```



#### 2.5手机号码,屏蔽中间四位

```java
import java.util.Scanner;

/*
    键盘录入一个手机号码,屏蔽中间四位
    13917295832 ==> 139****5832
 */
public class Demo05练习手机号码屏蔽 {
    public static void main(String[] args) {
        //1.键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个手机号：");
        String phoneNum = sc.nextLine();
        //2.使用字符串截取的方法
        String s1 = phoneNum.substring(0, 3);
        System.out.println(s1);
        String s2 = phoneNum.substring(7);
        System.out.println(s2);

        String newPhoneNum = s1+"****"+s2;
        System.out.println(newPhoneNum);
    }
}

```

#### 2.6模拟用户登录

```java
import java.util.Scanner;

/*
    模拟用户登录

 */
public class Demo06 {
    public static void main(String[] args) {
        String username = "admin";
        String password = "123456";
        //键盘录入
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            String userN = sc.nextLine();
            System.out.println("请输入密码：");
            String pwd = sc.nextLine();
            if (userN.trim().equals(username) && password.equals(pwd) ){
                System.out.println("登录成功，你可以上网看你想看的电影，玩你想玩的游戏！");
                break;
            }else {
                if (2-i==0){
                    System.out.println("您的账户被锁定，请联系管理员！");
                }else {
                    System.out.println("账户名或密码错误！您还有"+(2-i)+"次机会！");
                }
            }
        }
    }
}

```

### 3.StringBuilder类

#### 3.1 StringBuilder类的学习

```java
/*
    StringBuilder类的学习：
        1.类结构
            java.lang.StringBuilder
            public final class StringBuilder extends Object implements Serializable, CharSequence
        2.描述：
            一个可变的字符序列；
        3.构造方法
            StringBuilder() 构造一个没有字符的字符串构建器，初始容量为16个字符。
            StringBuilder(int capacity) 构造一个没有字符的字符串构建器，由 capacity参数指定的初始容量。
            StringBuilder(String str) 构造一个初始化为指定字符串内容的字符串构建器。
        4.成员方法
            int capacity() 返回当前容量。
            StringBuilder append(boolean b) 将 boolean参数的字符串表示附加到序列中。
            String toString() 返回表示此顺序中的数据的字符串。


 */
public class Demo01 {
    public static void main(String[] args) {
        //StringBuilder() 构造一个没有字符的字符串构建器，初始容量为16个字符。
        StringBuilder sb = new StringBuilder();
        //int capacity() 返回当前容量。
        int capacity = sb.capacity();
        System.out.println(capacity);

        //StringBuilder(int capacity) 构造一个没有字符的字符串构建器，由 capacity参数指定的初始容量。
        StringBuilder sb2 = new StringBuilder(32);
        int capacity1 = sb2.capacity();
        System.out.println(capacity1);

        //StringBuilder(String str) 构造一个初始化为指定字符串内容的字符串构建器。
        StringBuilder sb3 = new StringBuilder("abc");
        System.out.println(sb3);
        System.out.println(sb3.capacity());
        System.out.println("=============================");
        //常用方法
        //StringBuilder append(boolean b) 将 boolean参数的字符串表示附加到序列中。
        StringBuilder sb4 = sb.append(100);
        System.out.println(sb4);
        System.out.println(sb);
        System.out.println(sb == sb4);
        System.out.println("--------------------------");
        StringBuilder sb5 = sb4.append(true);
        System.out.println(sb4);
        System.out.println(sb5);
        System.out.println(sb);
        System.out.println(sb == sb4);
        System.out.println(sb5 == sb4);
        sb.append(100).append(true).append('a').append("zhangsan");
        System.out.println(sb);
        System.out.println(sb4);
        System.out.println(sb5);
        System.out.println("----------------------");
        System.out.println(sb.toString());
    }
}

```

#### 3.2 字符串反转输出练习

```java
/*
    键盘录入一个字符串,实现字符串的逆序输出
    举栗子：
        键盘录入 abc
        输出 cba
 */
public class Demo02练习 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();
        //定义一个空的字符串
        String str = "";
        /*for (int i = line.length()-1; i >= 0; i--) {
            char c = line.charAt(i);
            str+=c;
        }
        System.out.println(str);*/
        /*char[] chars = line.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            str+=chars[i];
        }
        System.out.println(str);*/
        /*StringBuilder sb = new StringBuilder(line);
        //StringBuilder reverse() 导致该字符序列被序列的相反代替。
        StringBuilder reverse = sb.reverse();
        System.out.println(sb);
        System.out.println(sb == reverse);*/
        System.out.println(new StringBuilder(line).reverse().toString());
    }
}

```





















