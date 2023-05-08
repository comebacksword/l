# day04-常用API,正则表达式,Collection集合

## 今日目标  

- BigInteger类
- BigDecimal类
- Arrays类
- 包装类
- String类的常用方法
- 正则表达式
- Collection集合

## 1 BigInteger类

### 1.1 概述

- 概述 : java.math.BigInteger类是一个引用数据类型 , 可以用于计算一些大的整数 , 当超出基本数据类型数据范围的整数运算时就可以使用BigInteger了。

### 1.2 构造方法

- 构造方法 : 可以将整数的字符串 . 转成BigInteger类型的对象

### 1.3 成员方法

- | **方法声明**                                      | **描述**                           |
  | ------------------------------------------------- | ---------------------------------- |
  | public BigInteger **add** (BigInteger value)      | 超大整数加法运算                   |
  | public BigInteger **subtract** (BigInteger value) | 超大整数减法运算                   |
  | public BigInteger **multiply** (BigInteger value) | 超大整数乘法运算                   |
  | public BigInteger **divide** (BigInteger value)   | 超大整数除法运算，除不尽取整数部分 |

```java
package com.itheima.api_demo.biginteger_demo;

import java.math.BigInteger;

/*
    构造方法 :
        BigInteger(String value)	可以将整数的字符串，转换为BigInteger对象
    成员方法 :
        public BigInteger add (BigInteger value)	    超大整数加法运算
        public BigInteger subtract (BigInteger value)	超大整数减法运算
        public BigInteger multiply (BigInteger value)	超大整数乘法运算
        public BigInteger divide (BigInteger value)	超大整数除法运算，除不尽取整数部分

 */
public class BigIntegerDemo {
    public static void main(String[] args) {
        // 获取大整数对象
        BigInteger bigInteger1 = new BigInteger("2147483648");
        // 获取大整数对象
        BigInteger bigInteger2 = new BigInteger("2");
        // public BigInteger add (BigInteger value)	    超大整数加法运算
        BigInteger add = bigInteger1.add(bigInteger2);
        System.out.println(add);

        System.out.println("=============");

        // public BigInteger subtract (BigInteger value)	超大整数减法运算
        BigInteger subtract = bigInteger1.subtract(bigInteger2);
        System.out.println(subtract);

        System.out.println("=============");

        // public BigInteger multiply (BigInteger value)	超大整数乘法运算
        BigInteger multiply = bigInteger1.multiply(bigInteger2);
        System.out.println(multiply);

        System.out.println("=============");
        // public BigInteger divide (BigInteger value)	超大整数除法运算，除不尽取整数部分
        BigInteger divide = bigInteger1.divide(bigInteger2);
        System.out.println(divide);
    }
}
```

## 2 BigDecimal类

### 2.1 概述

- 概述 : java.math.BigDecimal可以对大浮点数进行运算，保证运算的准确性。float，double 他们在存储及运算的时候，会导致数据精度的丢失。如果要保证运算的准确性，就需要使用BigDecimal。

### 2.2 构造方法

- 构造方法 : 
  - public BigDecimal(String val) : 将 BigDecimal 的字符串表示形式转换为 BigDecimal

### 2.3 成员方法

- 成员方法 : 

  - | **方法声明**                                                 | **描述**                                                     |
    | ------------------------------------------------------------ | ------------------------------------------------------------ |
    | public BigDecimal **add**(BigDecimal value)                  | 加法运算                                                     |
    | public BigDecimal **subtract**(BigDecimal value)             | 减法运算                                                     |
    | public BigDecimal **multiply**(BigDecimal value)             | 乘法运算                                                     |
    | public BigDecimal **divide**(BigDecimal value)               | 除法运算(除不尽会有异常)                                     |
    | public BigDecimal divide(BigDecimal divisor, int roundingMode) | 除法运算(除不尽，使用该方法)参数说明：scale 精确位数，roundingMode取舍模式         BigDecimal.ROUND_HALF_UP 四舍五入      BigDecimal.ROUND_FLOOR 去尾法      BigDecimal.ROUND_UP 进一法 |

```java
package com.itheima.api_demo.bigdecimal_demo;

import java.math.BigDecimal;

/*
    构造方法 :
        public BigDecimal(String val)	将 BigDecimal 的字符串表示形式转换为 BigDecimal
    成员方法 :
        public BigDecimal add(BigDecimal value)	加法运算
        public BigDecimal subtract(BigDecimal value)	减法运算
        public BigDecimal multiply(BigDecimal value)	乘法运算
        public BigDecimal divide(BigDecimal value)	除法运算(除不尽会有异常)
        public BigDecimal divide(BigDecimal value, int scale, RoundingMode roundingMode)	除法运算(除不尽，使用该方法)
        参数说明：
        scale 精确位数，
        roundingMode取舍模式
                   BigDecimal.ROUND_HALF_UP 四舍五入
                   BigDecimal.ROUND_FLOOR 去尾法
                   BigDecimal.ROUND_UP  进一法
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = new BigDecimal("0.1");
        BigDecimal bigDecimal2 = new BigDecimal("0.2");

        // public BigDecimal add(BigDecimal value)	加法运算
        BigDecimal add = bigDecimal1.add(bigDecimal2);
        System.out.println(add);

        System.out.println("=================");

        // public BigDecimal subtract(BigDecimal value)	减法运算
        BigDecimal subtract = bigDecimal1.subtract(bigDecimal2);
        System.out.println(subtract);

        System.out.println("=================");

        // public BigDecimal multiply(BigDecimal value)	乘法运算
        BigDecimal multiply = bigDecimal1.multiply(bigDecimal2);
        System.out.println(multiply);

        System.out.println("=================");

        // public BigDecimal divide(BigDecimal value)	除法运算(除不尽会有异常)
        // BigDecimal divide = bigDecimal1.divide(bigDecimal2);
        // System.out.println(divide);

        /*
            public BigDecimal divide(BigDecimal divisor, int roundingMode)	除法运算(除不尽，使用该方法)
            参数说明：
            scale 精确位数，
            roundingMode : 取舍模式
                       BigDecimal.ROUND_HALF_UP 四舍五入
                       BigDecimal.ROUND_FLOOR 去尾法
                       BigDecimal.ROUND_UP  进一法
        */

        // BigDecimal divide = bigDecimal1.divide(bigDecimal2, 3, BigDecimal.ROUND_HALF_UP);
        // BigDecimal divide = bigDecimal1.divide(bigDecimal2, 3, BigDecimal.ROUND_FLOOR);
        // BigDecimal divide = bigDecimal1.divide(bigDecimal2, 3, BigDecimal.ROUND_UP);
        // System.out.println(divide);

    }
}

```



## 3 Arrays类

### 3.1 概述

- 概述 : java.util.Arrays是数组的工具类，里面有很多静态的方法用来对数组进行操作（如排序和搜索），还包含一个静态工厂，可以将数组转换为List集合（后面会讲到集合知识

### 3.2 构造方法

- 构造方法 : private Arrays(){}

- | **public static void sort(int[] a)**       | **按照数字顺序排列指定的数组**         |
  | ------------------------------------------ | -------------------------------------- |
  | **public static String toString(int[] a)** | **返回指定数组的内容的字符串表示形式** |

```java
package com.itheima.api_demo.arrays_demo;

import java.util.Arrays;
import java.util.Random;

/*
    1 随机生成10个[0,100]之间的整数，放到整数数组中，按照从小到大的顺序排序并打印元素内容。
 */
public class ArraysDemo {
    public static void main(String[] args) {
        // 创建数组
        int[] arr = new int[10];

        // 创建随机数对象
        Random r = new Random();

        // 采用随机数给数组的每一个元素赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(101);
        }

        // 对数组进行排序
        Arrays.sort(arr);

        // 把数组转成指定格式的字符串
        System.out.println(Arrays.toString(arr));
    }
}

```

## 4 包装类

### 4.1 概述

- ##### 概述 :

  - Java中基本数据类型对应的引用数据类型

### 4.2 包装类的作用

- ##### 包装类的作用 : 

  - 基本数据类型 , 没有变量 , 没有方法 , 包装类就是让基本数据类型拥有变量和属性 , 实现对象化交互
  - 基本数据类型和字符串之间的转换

### 4.3 基本数据类型和包装类对应

- ##### 基本数据类型和包装类的对应关系

  | **基本数据类型** | **包装类型** |
  | ---------------- | ------------ |
  | byte             | Byte         |
  | short            | Short        |
  | int              | Integer      |
  | long             | Long         |
  | float            | Float        |
  | double           | Double       |
  | char             | Character    |
  | boolean          | Boolean      |

### 4.4 自动装箱和自动拆箱

- 自动转型和自动拆箱

  - 自动装箱和拆箱是JDK1.5开始的
  - 自动装箱 : 基本数据类型自动转成对应的包装类类型
  - 自动拆箱 : 包装类类型自动转成对应的基本数据类型

  ```java
  Integer i1 = 10;
  int i2 = i1;
  ```

### 4.5 基本数据类型和字符串之间的转换

- 使用包装类, 对基本数据类型和字符串之间的转换

  - 在开发过程中数据在不同平台之间传输时都以字符串形式存在的，有些数据表示的是数值含义，如果要用于计算我们就需要将其转换基本数据类型.

  - 基本数据类型--> String

    - 直接在数值后加一个空字符串
    - 通过String类静态方法valueOf()

  - String --> 基本数据类型

    - | public static byte parseByte(String s)：将字符串参数转换为对应的byte基本类型。 |
      | ------------------------------------------------------------ |
      | public static short parseShort(String s)：将字符串参数转换为对应的short基本类型。 |
      | public static int parseInt(String s)：将字符串参数转换为对应的int基本类型。 |
      | public static long parseLong(String s)：将字符串参数转换为对应的long基本类型。 |
      | public static float parseFloat(String s)：将字符串参数转换为对应的float基本类型。 |
      | public static double parseDouble(String s)：将字符串参数转换为对应的double基本类型。 |
      | public static boolean parseBoolean(String s)：将字符串参数转换为对应的boolean基本类型。 |

- 注意事项 : 

  - 包装类对象的初始值为null（是一个对象）
  - Java中除了float和double的其他基本数据类型，都有常量池
    - 整数类型：[-128,127]值在常量池
    - 字符类型：[0,127]对应的字符在常量池
    - 布尔类型：true，false在常量池

  - 在常量池中的数据 , 会进行共享使用 , 不在常量池中的数据会创建一个新的对象

## 5 String类的常用方法

### 5.1 常用方法

![image-20210404212729376](D:\传智播客\上海-JavaSE进阶面授\day04【常用API 2，正则 , Collection集合，迭代器】\笔记\img\image-20210404212729376.png)

```java
package com.itheima.api_demo.string_demo;

/*
    已知字符串，完成需求
    String str = "I Love Java, I Love Heima";
    判断是否存在  “Java”
    判断是否以Heima字符串结尾
    判断是否以Java开头
    判断 Java在字符串中的第一次出现位置
    判断  itcast 所在的位置

 */
public class Test {
    public static void main(String[] args) {
        String str = "I Love Java, I Love Heima";

        // 判断是否存在  “Java”
        System.out.println(str.contains("Java"));// true

        // 判断是否以Heima字符串结尾
        System.out.println(str.endsWith("Heima"));// true

        // 判断是否以Java开头
        System.out.println(str.startsWith("Java"));// false

        // 判断 Java在字符串中的第一次出现位置
        System.out.println(str.indexOf("Java"));// 7

        // 判断  itcast 所在的位置
        System.out.println(str.indexOf("itcast"));// -1
    }
}

```

```java
package com.itheima.api_demo.string_demo;

/*
    已知字符串，完成右侧需求
    String str = "I Love Java, I Love Heima";
    需求：
    1.将所有 Love 替换为 Like ,打印替换后的新字符串
    2.截取字符串 "I Love Heima"
    3.截取字符串 "Java"

 */
public class Test2 {
    public static void main(String[] args) {
        String str = "I Love Java, I Love Heima";

        // 1.将所有 Love 替换为 Like ,打印替换后的新字符串
        System.out.println(str.replace("Love", "Like"));
        // 2.截取字符串 "I Love Heima"
        System.out.println(str.substring(13));
        // 3.截取字符串 "Java"
        System.out.println(str.substring(7 , 11));

    }
}

```

```java
package com.itheima.api_demo.string_demo;

/*
    已知字符串，完成右侧需求
    String str = "I Love Java, I Love Heima";
    需求：
    1 计算字符 a 出现的次数（要求使用toCharArray）
    2 计算字符 a 出现的次数（要求使用charAt）
    3 将字符串中所有英文字母变成小写
    4 将字符串中所有英文字母变成大写


 */
public class Test3 {
    public static void main(String[] args) {
        String str = "I Love Java, I Love Heima";

//        1 计算字符 a 出现的次数（要求使用toCharArray）
        int count1 = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a') {
                count1++;
            }
        }
        System.out.println("字符a出现了" + count1 + "次");


//        2 计算字符 a 出现的次数（要求使用charAt）
        int count2 = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a'){
                count2++;
            }
        }
        System.out.println("字符a出现了" + count2 + "次");

//        3 将字符串中所有英文字母变成小写
        String s1 = str.toLowerCase();
        System.out.println(s1);

//        4 将字符串中所有英文字母变成大写
        String s2 = str.toUpperCase();
        System.out.println(s2);
    }
}

```



## 6 正则表达式

### 6.1 概述 : 

- 正则表达式通常用来校验，检查字符串是否符合规则的

### 6.2 体验正则表达式

```java
package com.itheima.regex_demo;

import java.util.Scanner;

/*
    设计程序让用户输入一个QQ号码，验证QQ号的合法性：
    1. QQ号码必须是5--15位长度
    2. 而且首位不能为0
    3. 而且必须全部是数字

 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您的qq号码:");
        String qq = sc.nextLine();

        System.out.println(checkQQ2(qq));

    }

    private static boolean checkQQ(String qq) {
//        1. QQ号码必须是5--15位长度
        if (qq.length() < 5 || qq.length() > 15) {
            return false;
        }
//       2 . 而且首位不能为0
        if (qq.charAt(0) == '0') {
            return false;
        }

//        2. 而且必须全部是数字
        for (int i = 0; i < qq.length(); i++) {
            char ch = qq.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }

        return true;
    }

    // 正则表达式改进
    private static boolean checkQQ2(String qq) {
        return qq.matches("[1-9][0-9]{4,14}");
    }
}

```

### 6.3 正则表达式的语法

- ##### boolean  matches（正则表达式） :如果匹配正则表达式就返回true，否则返回false

  - boolean  matches（正则表达式） :如果匹配正则表达式就返回true，否则返回false

- ##### 字符类

  -  [abc] ：代表a或者b，或者c字符中的一个。
  - [^abc]：代表除a,b,c以外的任何字符。
  - [a-z] ：代表a-z的所有小写字符中的一个。
  - [A-Z] ：代表A-Z的所有大写字符中的一个。
  - [0-9] ：代表0-9之间的某一个数字字符。
  - [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
  - [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符

```java
package com.itheima.regex_demo;
/*
    字符类 : 方括号被用于指定字符
    [abc] ：代表a或者b，或者c字符中的一个。
    [^abc]：代表除a,b,c以外的任何字符。
    [a-z] ：代表a-z的所有小写字符中的一个。
    [A-Z] ：代表A-Z的所有大写字符中的一个。
    [0-9] ：代表0-9之间的某一个数字字符。
    [a-zA-Z0-9]：代表a-z或者A-Z或者0-9之间的任意一个字符。
    [a-dm-p]：a 到 d 或 m 到 p之间的任意一个字符

    需求 :
    1 验证str是否以h开头，以d结尾，中间是a,e,i,o,u中某个字符
    2 验证str是否以h开头，以d结尾，中间不是a,e,i,o,u中的某个字符
    3 验证str是否a-z的任何一个小写字符开头，后跟ad
    4 验证str是否以a-d或者m-p之间某个字符开头，后跟ad
    注意: boolean  matches（正则表达式） :如果匹配正则表达式就返回true，否则返回false
 */
public class RegexDemo {
    public static void main(String[] args) {
//        1 验证str是否以h开头，以d结尾，中间是a,e,i,o,u中某个字符
        System.out.println("had".matches("h[aeiou]d"));

//        2 验证str是否以h开头，以d结尾，中间不是a,e,i,o,u中的某个字符
        System.out.println("hwd".matches("h[^aeiou]d"));

//        3 验证str是否a-z的任何一个小写字符开头，后跟ad
        System.out.println("aad".matches("[a-z]ad"));

//        4 验证str是否以a-d或者m-p之间某个字符开头，后跟ad
        System.out.println("bad".matches("[a-dm-p]ad"));

    }
}
```

- ##### 逻辑运算符

  - && ：并且
  - |    ：或者

```java
package com.itheima.regex_demo;
/*
    逻辑运算符 :
        1 && : 并且
        2 |  : 或者

    需求 :
        1 要求字符串是除a、e、i、o、u外的其它小写字符开头，后跟ad
        2 要求字符串是aeiou中的某个字符开头，后跟ad
 */
public class RegexDemo2 {
    public static void main(String[] args) {
//        1 要求字符串是除a、e、i、o、u外的其它小写字符开头，后跟ad
        System.out.println("vad".matches("[a-z&&[^aeiou]]ad"));
//        2 要求字符串是aeiou中的某个字符开头，后跟ad
        System.out.println("aad".matches("[a|e|i|o|u]ad"));
    }
}

```

- ##### 预定义字符类

  - "."  ： 匹配任何字符。
  - "\d"：任何数字[0-9]的简写；
  - "\D"：任何非数字[^0-9]的简写；
  - "\s" ： 空白字符：[ \t\n\x0B\f\r] 的简写
  - "\S" ： 非空白字符：[^\s] 的简写
  - "\w" ：单词字符：[a-zA-Z_0-9]的简写
  - "\W"：非单词字符：[^\w]

```java
package com.itheima.regex_demo;
/*
    预定义字符 : 简化字符类的书写

    "."  ：匹配任何字符。
    "\d" ：任何数字[0-9]的简写
    "\D" ：任何非数字[^0-9]的简写
    "\s" ：空白字符：[\t\n\x0B\f\r] 的简写
    "\S" ：非空白字符：[^\s] 的简写
    "\w" ：单词字符：[a-zA-Z_0-9]的简写
    "\W" ：非单词字符：[^\w]

    需求 :
       1 验证str是否3位数字
       2 验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字
       3 验证字符串是否以h开头，以d结尾，中间是任何字符

 */
public class RegexDemo3 {
    public static void main(String[] args) {
//        1 验证str是否3位数字
        System.out.println("123".matches("\\d\\d\\d"));

//        2 验证手机号：1开头，第二位：3/5/8，剩下9位都是0-9的数字 ）
        System.out.println("15188888888".matches("1[358]\\d\\d\\d\\d\\d\\d\\d\\d\\d"));

//        3 验证字符串是否以h开头，以d结尾，中间是任何字符
        System.out.println("had".matches("h.d"));
    }
}

```

- ##### 数量词

  - X? : 0次或1次
  - X* : 0次到多次
  - X+ : 1次或多次
  - X{n} : 恰好n次
  - X{n,} : 至少n次
  - X{n,m}: n到m次(n和m都是包含的)

```java
package com.itheima.regex_demo;

/*
    数量词 :
        - X?    : 0次或1次
        - X*    : 0次到多次
        - X+    : 1次或多次
        - X{n}  : 恰好n次
        - X{n,} : 至少n次
        - X{n,m}: n到m次(n和m都是包含的)

    需求 :
      1 验证str是否3位数字
      2 验证str是否是多位(大于等于1次)数字
      3 验证str是否是手机号 ( 1开头，第二位：3/5/8，剩下9位都是0-9的数字)
      4 验证qq号码：1).5--15位；2).全部是数字;3).第一位不是0

 */
public class RegexDemo4 {
    public static void main(String[] args) {
//        1 验证str是否3位数字
        System.out.println("123".matches("\\d{3}"));

//        2 验证str是否是多位(大于等于1次)数字
        System.out.println("123456".matches("\\d+"));

//        3 验证str是否是手机号 ( 1开头，第二位：3/5/8，剩下9位都是0-9的数字)
        System.out.println("15188888888".matches("1[358]\\d{9}"));

//        4 验证qq号码：1).5--15位；2).全部是数字;3).第一位不是0
        System.out.println("122103987".matches("[1-9]\\d{4,14}"));
    }
}

```

- ##### 分组括号 : 

  - 将要重复使用的正则用小括号括起来，当做一个小组看待

```java
package com.itheima.regex_demo;
/*
    分组括号 : 将要重复使用的正则用小括号括起来，当做一个小组看待
    需求 :  window秘钥 , 分为5组，每组之间使用 - 隔开 , 每组由5位A-Z或者0-9的字符组成 , 最后一组没有 -
    举例 :
        xxxxx-xxxxx-xxxxx-xxxxx-xxxxx
        DG8FV-B9TKY-FRT9J-99899-XPQ4G
    分析：
        前四组其一  ：DG8FV-    正则：[A-Z0-9]{5}-
        最后一组    ：XPQ4G     正则：[A-Z0-9]{5}

    结果 : ([A-Z0-9]{5}-){4}[A-Z0-9]{5}

 */
public class RegexDemo5 {
    public static void main(String[] args) {
        System.out.println("DG8FV-B9TKY-FRT9J-99899-XPQ4G".matches("([A-Z0-9]{5}-){4}[A-Z0-9]{5}"));
    }
}

```

- ##### 字符串中常用含有正则表达式的方法

  - public String[] split ( String regex ) 可以将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
  - public String replaceAll ( String regex , String newStr ) 可以将当前字符串中匹配regex正则表达式的字符串替换为newStr。

```java
package com.itheima.regex_demo;

import java.util.Arrays;

/*

    1 字符串中常用含有正则表达式的方法
        public String[] split ( String regex ) 可以将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
        public String replaceAll ( String regex , String newStr ) 可以将当前字符串中匹配regex正则表达式的字符串替换为newStr。

    需求:
        1 将以下字符串按照数字进行切割
        String str1 = "aa123bb234cc909dd";

        2 将下面字符串中的"数字"替换为"*“a
        String str2 = "我卡里有100000元，我告诉你卡的密码是123456，要保密哦";

 */
public class RegexDemo6 {
    public static void main(String[] args) {
        // 1 将以下字符串按照数字进行切割
        String str1 =  "aa123bb234cc909dd";
        String[] strs = str1.split("\\d+");
        System.out.println(Arrays.toString(strs));

        // 2 将下面字符串中的"数字"替换为"*“a
        String str2 = "我卡里有100000元，我告诉你卡的密码是123456，要保密哦";
        System.out.println(str2.replaceAll("\\d+" , "*"));
    }
}

```

## 7 引用数据类型使用

### 7.1 使用方式

	- 基本数据类型可以当做方法的参数，返回值及成员变量使用，传递或者保存的是数据值。
	- 引用数据类型也可以当做方法的参数，返回值及字段使用，传递或者保存的是对象的引用（地址）。
	- 特别要注意，如果是抽象类或者接口那么传递或者保存的就是子类对象的地址引用了

```java
package com.itheima.datatype_demo;


public interface Player {
    public abstract void play();
}

abstract class Mp3Player implements Player {

}

class IPod extends Mp3Player {
    @Override
    public void play() {
        System.out.println("IPod播放音乐...");
    }
}


```

```java
package com.itheima.datatype_demo;

/*
   1 分别定义含有Play，Mp3Player , Ipod参数的方法，并调用传入实参进行测试

   2  定义一个学生类，里面定义含有Player， Mp3Player,Ipod类型的成员变量
      创建学生对象并给成员变量赋值

 */
public class PlayerTest {
    public static void main(String[] args) {
        show1(new IPod());
        show2(new IPod());
        show2(new IPod());

        Student s = new Student();
        s.setPlayer(new IPod());
        s.setMp3Player(new IPod());
        s.setiPod(new IPod());
    }

    public static void show1(Player player) {// 方法的参数是一个接口 , 接收实现类对象
        player.play();
    }

    public static void show2(Mp3Player player) {// 方法的参数是一个抽象类 , 接收子类对象
        player.play();
    }

    public static void show3(Mp3Player player) {// 方法的参数是具体的类 , 接收此类对象或者子类对象
        player.play();
    }
}

/*
    定义一个学生类，里面定义含有Player， Mp3Player,Ipod类型的成员变量
    创建学生对象并给成员变量赋值
 */
class Student {
    private Player player;   // 接口的类型的成员变量 , 保存的是实现类对象地址
    private Mp3Player mp3Player; // 实现类的类型的成员变量 , 保存的是子类对象地址
    private IPod iPod; // 具体类类型的成员变量 , 保存的是此类对象或者此类的子类对象地址


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Mp3Player getMp3Player() {
        return mp3Player;
    }

    public void setMp3Player(Mp3Player mp3Player) {
        this.mp3Player = mp3Player;
    }

    public IPod getiPod() {
        return iPod;
    }

    public void setiPod(IPod iPod) {
        this.iPod = iPod;
    }
}

```



## 8 Collection集合

### 8.1 集合和数组的区别

- ##### 长度区别 

  - 数组 : 长度固定
  - 集合 : 长度可变

- ##### 存储数据类型 

  - 数组 : 可以存储基本数据类型, 也可以存储引用数据类型
  - 集合 : 只能存储引用数据类型 , 要想存储基本数据类型 , 需要存储对应的包装类类型

### 8.2 集合的体系

![image-20210404232635762](D:\传智播客\上海-JavaSE进阶面授\day04【常用API 2，正则 , Collection集合，迭代器】\笔记\img\image-20210404232635762.png)

### 8.3 Collection集合常用的方法

- 在学习集合体系，一般先学习顶层接口。学习了顶层接口的方法，子类型继承而来的方法，就可以不用重复学习。
  - public boolean add(E e)：  把给定的对象添加到当前集合中 。
  - public void clear() :清空集合中所有的元素。
  - public boolean remove(E e): 把给定的对象在当前集合中删除。
  - public boolean contains(Object obj): 判断当前集合中是否包含给定的对象。
  - public boolean isEmpty(): 判断当前集合是否为空。
  - public int size(): 返回集合中元素的个数。
  - public Object[] toArray(): 把集合中的元素，存储到数组中

### 8.4 迭代器 

- ##### 概述 : 

  - 迭代器就是对Iterator的称呼 , 专门用来对Collection集合进行遍历使用的。学习迭代器的目的就是为了遍历集合

- ##### 注意 : 

  - 只有继承/实现Iterable接口才具有迭代的能力
  - Collection接口继承了Iterable接口所以 , Collection及其子类都具备迭代的能力

- ##### 获取迭代器对象的方式

  - 通过Collection集合对象调用Iterable接口中的iterator方法 , 就可以获取迭代器对象

- ##### Iterator(迭代器)中的方法

  | boolean      | hasNext() | 如果迭代具有更多元素，则返回 true 。                     |
  | ------------ | --------- | -------------------------------------------------------- |
  | E            | next()    | 返回迭代中的下一个元素。                                 |
  | default void | remove()  | 从底层集合中删除此迭代器返回的最后一个元素（可选操作）。 |

- ##### 迭代器的注意事项

  - 当迭代器迭代元素完成后，不能继续next获取元素，否则会报：NoSuchElementException
  - 当迭代器在使用的过程中，不能使用集合对象直接增删元素。会导致报错ConcurrentModificationException。如果要删除可以使用迭代器来删除

### 8.5 增强for循环

- 增强for循环（foreach），专门用来遍历集合或者数组，底层实现使用迭代器

- 定义格式 : 

  ```java
  for(元素的类型 变量名 : 数组/单列集合 ){
      变量代表的就是集合或者数组的元素
  }
  ```

  