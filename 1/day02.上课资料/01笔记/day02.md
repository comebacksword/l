## day02

学习目标：

 *  掌握类型转换

     * 隐式类型转换
     * 强制类型转换
 *  运算符

    * 算术运算符	

       * ‘+
       * ’-
       * ‘*
       * ’/
       * ‘%

    * 逻辑运算符

       * &
       * |
       * ！
       * ^

    * 关系运算符

       * '>
       * ’>=
       * <
       * <=
       * ==
       * !=

    * 三元运算符

       * 关系表达式?表达式1：表达式2

    * 赋值运算符

       * =
       * +=
       * -=
       * *=
       * /=
       * %=
   *  短路逻辑运算符

     * &&
     * ||
   *  字符+ 字符串+
   *  自增自减运算符

     * ++
     * --

*  键盘录入
    *  导包 java.util.Scanner
    *  创建对象 Scanner sc = new Scanner(System.in);
    *  接收键盘录入的数据 int num = sc.nextInt();


### 1类型转换

#### 1.1隐式类型转换

```java
定义：小的数据类型向大的数据类型转换，也叫自动类型转换
  
byte -- short 
  				--> int --> long --> float --> double
  		char
byte 和 short 不能直接转成 char 类型
byte short char 在参与运算的时候 自动转成 int 类型的数据 参与运算
```

```java
public class Demo01自动类型转换 {
    public static void main(String[] args) {
        byte a = 10;
        int b = a;
        System.out.println(a);
        System.out.println(b);
        //byte 和 short 不能直接转成 char 类型
        //char c = a;
        
        double d = a;
        System.out.println(d);
    }
}
```

#### 1.2强制类型转换	

```java
定义：大的数据类型向小的数据类型转换，有可能造成数据精度丢失
  
格式：
  	目标数据类型 变量名 = (目标数据类型)变量名或值;
```

```java
/*
定义：大的数据类型向小的数据类型转换，有可能造成数据精度丢失
     如果大的数据类型数值在小的数据类型的取值范围内，就不会造成数据精度丢失
     如果大的数据类的数值超出了小的数据类型的取值范围，就会造成数据精度丢失

格式：
  	目标数据类型 变量名 = (目标数据类型)变量名或值;
 */
public class Demo02强制类型转换 {
    public static void main(String[] args) {
        //如果大的数据类型数值在小的数据类型的取值范围内，就不会造成数据精度丢失
        int a = 10;
        byte b = (byte) a;
        System.out.println(a);
        //如果大的数据类的数值超出了小的数据类型的取值范围，就会造成数据精度丢失
        int c = 130;
        byte d = (byte) c;
        System.out.println(c);
        System.out.println(d);

    }
}

```

### 2.运算符

#### 2.1算术运算符

```java
/*
    算术运算符:
        +: 数学的加
        -: 数学的减
        *: 数学的乘
        /: 数学的除 求商
        %: 数学的除 求余数
 */
public class Demo01算术运算符 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);

        System.out.println(a/b);//求商
        System.out.println(a%b);//求余数

    }
}
```

#### 2.2赋值运算符

```java
/*
    赋值运算符：
        = ：把右边的值或者变量赋值给左边的变量

        +=:把左边变量和右边变量或值相加再赋值给左边变量
        -=:把左边变量和右边变量或值相减再赋值给左边变量
        *=:把左边变量和右边变量或值相乘再赋值给左边变量
        /=:把左边变量和右边变量或值相除的商再赋值给左边变量
        %=:把左边变量和右边变量或值相除的余数再赋值给左边变量
 */
public class Demo02赋值运算符 {
    public static void main(String[] args) {
        // = ：把右边的值或者变量赋值给左边的变量
        int a = 10;
        int b = a;
        //+=:把左边变量和右边变量或值相加再赋值给左边变量
        int c = 20;
        c += 10; // c = c + 10;
        System.out.println(c);
        //-=:把左边变量和右边变量或值相减再赋值给左边变量
        c -= 15;
        System.out.println(c);

        //*=:把左边变量和右边变量或值相乘再赋值给左边变量
        c*=2;
        System.out.println(c);

        //=:把左边变量和右边变量或值相除的商再赋值给左边变量
        c/=5;
        System.out.println(c);

        //%=:把左边变量和右边变量或值相除的余数再赋值给左边变量
        c%=10;
        System.out.println(c);

        //复合赋值运算符，隐含了一个强制类型转换
        short s = 4;
        s+=5; // s = (short) (s+5);
        System.out.println(s);
   }
}
```

#### 2.3自增自减运算符

```java
/*
    自增运算符：
    ++:
        对变量自增一
        单独使用：
            ++在变量的前面或者后，都是对变量自增一
        参与运算：
            ++在变量后先参与操作，后自增一
            ++在变量的前面，先自增一，后参与操作

    自减运算符：
    --:
        对变量自减一
        单独使用：
            --在变量的前面或者后，都是对变量自减一
        参与运算：
            --在变量后先参与操作，后自减一
            --在变量前先自减一，后参与操作，
 */
public class Demo03自增自减运算符 {
    public static void main(String[] args) {
        int a = 10;
        //a++;
//        ++a;
//        int b = a++;
        int b = ++a;
        System.out.println(a);
        System.out.println(b);

        int c = 20;
//        --c;
//        c--;
//        int d = c--;
        int d = --c;
        System.out.println(c);
        System.out.println(d);
    }
}

```

#### 2.4字符的加操作

```java
/*
    字符的加操作：
        1.先把字符转成对应的ASCII码
        2.参与运算

    ASCII ((American Standard Code for Information Interchange): 美国信息交换标准代码）是基于拉丁字母的一套电脑编码系统，主要用于显示现代英语和其他西欧语言。
 */
public class Demo04字符的加操作 {
    public static void main(String[] args) {
        System.out.println('a'+1); // 'a' =97
        System.out.println('A'+1); // 'A' =65
        System.out.println('0'+1); // '0' =48
    }
}
```

#### 2.5字符串的加操作

```java
/*
    字符串的加操作:
        拼接
 */
public class Demo05字符串的加操作 {
    public static void main(String[] args) {
        System.out.println(1+2+3+4+5+"HelloWorld"+6+7+8+9);
        // 15HelloWorld6789
    }
}
```

#### 2.6关系运算符

```java
/*
    关系运算符：
        >
        >=
        <
        <=
        ==
        !=
    关系运算符结果是：布尔类型的值true 或者false
 */
public class Demo06关系运算符 {
    public static void main(String[] args) {
        int a = 10 ;
        int b = 20;
        System.out.println(a>b); //false
        System.out.println(a<b); //true
        a = 20;
        System.out.println(a == b);//true
        System.out.println(a != b);//false
        System.out.println(a>=b);//true
        System.out.println(a<=b);//true

        a = 30;
        System.out.println(a>=b);//true
        System.out.println(a<=b);//false

    }
}

```

#### 2.7逻辑运算符

```java
/*
    逻辑运算符: 两边只能放关系表达式，值应该是true或false
        & : 见false则false
        | : 见true则true
        ^ : 相同false 不同true
        ! : 取反

 */
public class Demo07逻辑运算符 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;
        System.out.println(a > c & b > c); // false & false ==> false
        System.out.println(a < c & b > c); // true  & false ==> false
        System.out.println(a > c & b < c); // false & true  ==> false
        System.out.println(a < c & b < c); // true  & true  ==> true
        System.out.println("========================");
        System.out.println(a > c | b > c); // false | false ==> false
        System.out.println(a < c | b > c); // true  | false ==> true
        System.out.println(a > c | b < c); // false | true  ==> true
        System.out.println(a < c | b < c); // true  | true  ==> true
        System.out.println("========================");
        System.out.println(a > c ^ b > c); // false ^ false ==> false
        System.out.println(a < c ^ b > c); // true  ^ false ==> true
        System.out.println(a > c ^ b < c); // false ^ true  ==> true
        System.out.println(a < c ^ b < c); // true  ^ true  ==> false
        System.out.println("========================");
        System.out.println(a > c );     //false
        System.out.println(!(a > c) );  //true
        System.out.println(!!(a > c) ); //false
        System.out.println(!!!(a > c) );//true
  }
}
```

#### 2.8三元运算符

```java
/*
    三元运算符：
        格式：关系表达式 ? 表达式1:表达式2
        运算规则：
            1.先判断关系表达式的值
            2.如果关系表达式的值为true,取表达式1的值
            3.如果关系表达式的值为false，去表达式2的值
 */
public class Demo09三元运算符 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //求两个数的最大值
        int max = a>b?a:b;
        System.out.println(max);
        //求两个数的最小值
//        int min = a<b?a:b;
        int min = a>b?b:a;
        System.out.println(min);
    }
}

```

#### 2.9练习

```java
public class Demo10 {
    public static void main(String[] args) {
        int c = 10;
        int d = 5;
        int rs3 = c++ + ++c - --d - ++d + 1 + c--;
        System.out.println(rs3); // 26
        System.out.println(c);   // 11
        System.out.println(d);   // 5
    }
}
```

#### 2.10求三个整数的最大值

```java
/*
    使用三元运算符，求三个整数的最大值:
        165 210 175
    1.先求前两个最大值，临时最大值
    2.使用临时最大值和第三个数字比较获取最大值
 */
public class Demo11求三个整数的最大值 {
    public static void main(String[] args) {
        int a = 165;
        int b = 210;
        int c = 175;
        //临时最大值
        int tempMax = a>b?a:b;
        //求最大值
        int max = tempMax>c?tempMax:c;
        System.out.println(max);
    }
}
```

### 3.键盘录入

#### 3.1键盘录入入门

```java
/*
    1.导包
        import java.util.Scanner
    2.创建对象
        Scanner sc = new Scanner(System.in);
    3.接收数据 int
        int num = sc.nextInt();
 */
//导包
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        //创建对象
        Scanner sc = new Scanner(System.in);
        //接收数据
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();
        System.out.println("键盘录入的数据是："+num);
    }
}
```

#### 3.2键盘录入三个数字，求最大值

```java
import java.util.Scanner;

/*
    键盘录入三个数字，求最大值
    分析：
        1.键盘录入
            导包
            创建对象
            接收数据
        2.求最大值
            2.1 先求两个数临时最大值
            2.2 在使用临时最大值和第三个数字比较 获取最大值
 */
public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("键盘输入第一个数字");
        int num = sc.nextInt();
        System.out.println("键盘输入第二个数字");
        int num1 = sc.nextInt();
        System.out.println("键盘输入第三个数字");
        int num2 = sc.nextInt();

        int temMax = num > num1 ? num : num1;
        int max = temMax > num2 ? temMax : num2;
        System.out.println(max);
    }
}

```

#### 3.3键盘录入一个四位数，求各个位上数字

```java
import java.util.Scanner;

/*
    键盘录入一个四位数，求各个位上数字
    分析：
        1.键盘录入
            导包
            创建对象
            接收数据 四位数
        2.求各个位上数字
            1234%10 = 4                num/1%10
            1234/10 = 123  123%10 =3   num/10%10
            1234/100 = 12  12%10 = 2   num/100%10
            1234/1000 = 1  1%10 = 1    num/1000%10
 */
public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个四位整数");
        int a = sc.nextInt();
        int ge = a%10;
        int shi = a/10%10;
        int bai = a/100%10;
        int qian = a/1000%10;
        System.out.println(ge);
        System.out.println(shi);
        System.out.println(bai);
        System.out.println(qian);
    }
}
```

#### 3.4键盘录入五位数，判断这个数字是否是回文数

```java
/*
    键盘录入五位数，判断这个数字是否是回文数
    12321  56765  17371
    分析：
        1.键盘录入
            导包
            创建对象
            接收数据
        2.求各个为上的数字
            int ge = num%10;
            int shi = num/10%10;
            int bai = num/100%10;
            int qian = num/1000%10;
            int wan = num/10000%10;

 */
import java.util.Scanner;
public class Demo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个五位数");
        int num = sc.nextInt();
        int ge = num%10;
        int shi = num/10%10;
        int bai = num/100%10;
        int qian = num/1000%10;
        int wan = num/10000%10;
        boolean a = ge==wan && shi==qian?true:false;
        System.out.println(a);
    }
}
```

#### 3.5判断是否是水仙花数

```java
/*
    键盘录入一个数字判断是否是水仙花数 153 370 371 407
    水仙花数：
        首先是一个三位
        其次各个位上的立方和等于数字本身  153 = 1*1*1 + 5*5*5 + 3*3*3
    思路：
        1.键盘录入
            导包
            创建对象
            接收数据
        2.求三位数各个位上数字
        3.求各个位上数字的立方和
        4.判断
 */
public class Demo05 {
    public static void main(String[] args) {
        //1.键盘录入
        //创建对象
        Scanner sc = new Scanner(System.in);
        //接收数据
        System.out.println("输入三位数");
        int i = sc.nextInt();
        //2.求三位数各个位上数字
        int sum, ge, shi, bai;
        ge = i % 10;
        shi = i / 10 % 10;
        bai = i / 100 % 10;
        //3.求各个位上数字的立方和
        sum = ge * ge * ge + shi * shi * shi + bai * bai * bai;
        boolean flag = sum == i ? true : false;
        /*if (sum == i) {
            System.out.println("是");
        } else {
            System.out.println("不是");
        }*/
        System.out.println(flag);
    }

}
```

