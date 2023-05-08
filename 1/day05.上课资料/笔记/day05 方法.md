## day05 方法

学习目标：

 * 了解方法的概述
 * 掌握方法的定义和调用
 * 熟悉方法在内存中的调用过程
 * 掌握方法的重载
 * 掌握debug的使用

### 1.方法

#### 1.1方法概述和格式1

```java
/*
    方法的概述：
        1.方法就是解决问题办法
        2.编程中的方法，具有特定功能的代码块
    方法定义：
        格式1：
            public static void 方法名(){
                方法体
            }
         调用：
           在main方法中调用格式 ：方法名();
        特点：
            方法和方法之间是平行关系，不能嵌套定义
            方法定义后不会自己执行，需要被调用后才能执行
            方法定义的先后顺序和方法执行顺序无关 和方法调用的顺序有关，谁先调用谁先执行

 */
public class Demo01 {
    public static void printHelloWorld(){
        System.out.println("HelloWorld");
    }
    public static void main(String[] args) {
//        sum();
//        printHelloWorld();
        sum2();
    }
    public static void sum(){
        System.out.println(1+1);
    }
    //定义方法求1-100之间的数据和
    public static void sum2(){
        //定义求和变量
        int sum = 0;
        //使用循环遍历获取1--100之间所有数据
        for (int i = 1; i <= 100; i++) {
            sum+=i;
        }
        System.out.println("1--100之间所有数据:"+sum);
    }

}

```

#### 1.2方法定义格式2

```java
/*
    方法定义的格式2：
         public static void 方法名(数据类型 变量名) {
         }
         调用：
            在main方法中 ： 方法名(值) ：值要和方法中参数数据类型一致

            传递参数过程，和变量没有关系 和数据类型有关系，要求数据类型要一致

            需要几个参数，传递几个参数，需要什么数据类型的参数，就传递相匹配数据类型
 */
public class Demo02 {
    public static void main(String[] args) {
        //定义方法，求1 - n之间数据和
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num = scanner.nextInt();
//        sum(num);
        System.out.println("请输入第二个数字：");
        int num2 = scanner.nextInt();
        sum2(num2,num);
    }

    public static void sum(int n) {
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += i;
        }
        System.out.println(s);
    }
    //定义方法求两个数的和
    public static void sum2(int a,int b){
        System.out.println(a+b);
    }
}

```

#### 1.3方法定义的格式3

```java
import java.util.Scanner;

/*
    方法定义格式3：
        public static 返回值类型 方法名(参数列表){ //参数列表：参数可以有 一个，也可以有多个，也可以没有

            方法体

            return 值; //返回值的类型要和 方法的返回值类型相匹配
        }
        // 返回值类型根据需求 定义
     方法定义格式3调用：
        在main方法中调用：
            格式：

                方法名(参数......);直接调用，无意义 不推荐

                方法的返回值类型 变量名 = 方法名(参数......);//赋值调用

                System.out.println(方法名(参数......)); //输出调用



 */
public class Demo03 {
    public static void main(String[] args) {
        //键盘录入两个数字，定义方法接收两个数字，求他们最大值并返回
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int num2 = sc.nextInt();
        //直接调用，无意义 不推荐
//        getMax(num1,num2);
        //赋值调用
        int max = getMax(num1,num2);
        System.out.println(max);

        //输出调用
        System.out.println(getMax(num1,num2));
    }
    /*
        定义方法接收两个数字，求他们最大值并返回
        定义方法：
            参数：int a,int b
            功能：求最大值
            返回值：有 类型 int
     */
    public static int getMax(int a,int b){
        if (a>b){
            return a;
        }else {
            return b;
        }
    }
}

```

#### 1.4方法定义小结

```java
/*
    方法定义格式：
        格式1：
            public static void 方法名(){
                方法体
            }
        调用：
            在main方法中调用：方法名();
        格式2：
            public static void 方法名(参数列表){ //参数可以有一个也可以有多个，也可以没有，如果有多个要使用逗号隔开
                方法体
            }
        调用：
            在main方法中调用：方法名();

        格式3：
            public static 返回值类型 方法名(参数列表){ //参数可以有一个也可以有多个，也可以没有，如果有多个要使用逗号隔开
                方法体;
                return 值; //值要和方法的返回值数据类型一致
            }
 */
public class Demo04 {
    public static void main(String[] args) {
        //格式1调用：
        getNum();//直接调用
        //void x = getNum();//赋值调用
//        System.out.println(getNum());//输出调用
//        格式2:
        getSum(100);

        //格式3调用：
        int sum2 = getSum2(10, 20);
        System.out.println(sum2);
        System.out.println(getSum2(5,10));

    }

    //格式1
    //定义求所有水仙花数在控制台输出
    public static void getNum() {
        //1.循环 遍历获取所有三位数
        for (int i = 100; i <= 999; i++) {
            //2.求三位数各个位上的数字
            int ge = i % 10;
            int shi = i / 10 % 10;
            int bai = i / 100 % 10;
            if (ge * ge * ge + shi * shi * shi + bai * bai * bai == i) {
                System.out.println("水仙花数：" + i);
            }
        }

    }

    //格式2：
    //定义方法 求1到n之间的所有奇数和(n>1)在控制台输出
    public static void getSum(int n) {
        //1.定义变量
        int sum = 0;
        //2.获取1--n之间的所有数据
        for (int i = 1; i <= n; i++) {
            //3.判断是否是奇数
            if (i%2!=0){
                //4.是奇数就累加求和
                sum+=i;
            }
        }
        System.out.println("sum = "+sum);
    }

    //格式3：
    //定义方法求两个数的和 并返回
    public static int getSum2(int a,int b){
        return a+b;
    }


}

```

#### 1.5方法定义练习打印九九乘法表

```java
/*
    定义方法在控制台打印九九乘法表
    分析：
        1.不要返回值  返回值类型 void
        2.参数：没有参数
 */
public class Demo05 {
    public static void main(String[] args) {
        //调用方法
        print();

    }
    //定义方法
    public static void print(){
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+"*"+i+"="+i*j+"\t");
            }
            System.out.println();
        }

    }
}

```

#### 1.6打印数组

```java
/*
    定义方法打印数组中的元素
    输出格式:[1, 2, 3, 4, 5, 6, 7, 8, 9]
    分析：
        1.参数：int [] arr;
        2.返回值：没有返回值
 */
public class Demo06 {
    public static void main(String[] args) {
        int [] brr = {1,2,3,4,5,6,7,8,9};
        //调用方法
        printArray(brr);
    }
    public static void printArray(int [] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i== arr.length-1){ //判断是否是最后一个元素 ，如果是就直接打印元素
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i]+", ");//如果不是最后一个元素，就要打印元素拼接逗号和空格
            }
        }
        System.out.println("]");
        //System.out.println(Arrays.toString(arr));

    }

}

```

#### 1.7求最大值

```java
/*
    键盘录入两个数字，求最大值并返回给调用者

    分析：
        1.键盘录入
        2.定义方法：
            2.1 参数：int a,int b
            2.2 返回值 ：有 ，返回值类型：int
 */
public class Demo07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字：");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数字：");
        int num2 = sc.nextInt();
        //调用方法
        int max = getMaxs(num1, num2);
        System.out.println(max);


    }
    public static int getMaxs(int a, int b) {
        return a > b ? a : b;
    }

}

```

#### 1.8方法定义的通用格式

```java
/*
    方法定义的通用格式：
        public static 返回值类型 方法名(参数列表){
            方法体;
            return 值;
        }
        返回值类型：根据需求定义
        参数列表：参数可以有一个，可以有多个，可以没有，如果有多个参数使用逗号隔开
        方法体：方法的功能
        return ：用来返回方法最终结果，返回值的数据类型要和方法的返回值类型一致
    注意事项：
        1.方法不能嵌套定义
        2.方法在定义完成后，不会自己执行，需要被调用才执行
        3.方法名要做到见名知义，符合小驼峰的命名规范
        4.如果方法没有返回值，return语句可以省略不写 ，如果一定要写，只能 return;

        5.如果方法没有返回值，只能直接调用
        6.如果方法有返回值，可以直接调用,没有意义不推荐，还可以赋值调用，输出调用
        7.return语句下面，不能编写代码，因为永远执行不到，属于无效的代码
 */
public class Demo08方法定义的通用格式 {
    public static void main(String[] args) {

    }
}
```

#### 1.9获取数组最大值

```java
/*
    获取数组最大值
    分析：
        1.数组自定义
        2.方法定义：
            返回值：有 int类型
            参数： 有 数组
 */
public class Demo09 {
    public static void main(String[] args) {
        //1.定义数组
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int length = scanner.nextInt();
        int [] brr = new int[length];
        //生成1--100之间的随机数 填充数组
        Random random = new Random();
        for (int i = 0; i < brr.length; i++) {
            brr[i] = random.nextInt(100)+1;
        }
        //打印数组
        System.out.println(Arrays.toString(brr));

        //调用方法
        int max = getMax(brr);
        System.out.println(max);

    }
    //求数组最大值
    public static int getMax(int [] arr){
        //1.定义最大值
        int max = arr[0];
        //2.使用循环遍历数组获取每一个元素
        for (int i = 0; i < arr.length; i++) {
            //3.和定义最大值比较，如果比最大值还要大，就跟新最大值
            if (arr[i]>max){
                max = arr[i];
            }
        }
        //4.返回最大值
        return max;
    }
}
```

#### 1.10 方法在内存中的运行流程

```java
public class Demo10 {
    public static void main(String[] args) {
        eat();
    }

    public static void eat() {
        System.out.println("吃饭饭！");
    }
}
```

```java
public class Demo11 {
    public static void main(String[] args) {
        eat();
    }

    public static void eat() {
        study();
        System.out.println("吃饭");
        sleep();
    }

    public static void sleep() {
        System.out.println("睡觉");
    }

    public static void study() {
        System.out.println("学习");
    }
}

```

#### 1.11 方法重载

```java
import java.util.Arrays;
/*
    方法重载：
        1.在同一个类中，方法名相同
        2.参数不同：
            参数类型不同
            参数个数不同
            参数类型顺序不同
         3.和返回值无关
 */
public class Demo12重载 {
    public static void main(String[] args) {
        int [] brr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(brr));
        double [] crr = {1.0,2.0,3.0,4,5,6,7,8,9};
        System.out.println(Arrays.toString(crr));
    }
    public static void sum(){

    }
    public static void sum(int a,int b){

    }
    public static void sum(double a,double b){

    }
    public static void sum(long a,int b){

    }
    public static int sum(int  a,long b){
        return 0;
    }
}
```

#### 1.12 形参和实参

```java
import java.util.Scanner;

/*
    形参：形式参数
        方法定义时的参数
    实参：实际参数
        方法调用时传递的参数，有实际的值

 */
//键盘录入一个数字，定义方法求奇偶数
public class Demo13形参和实参 {
    public static void main(String[] args) {
        //键盘录入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数：");
        int num = sc.nextInt();
        isEvenNum(num);
    }
    /*
        定义方法：
            返回值：void
            参数：int a;
     */
    public static void isEvenNum(int a){
        //判断奇偶数
        if (a%2==0){
            System.out.println(a+"是偶数！");
        }else {
            System.out.println(a+"是奇数！");
        }
    }

}

```

#### 1.13 基本数据类型在方法的调用过程中，形参的改变，不影响实参

```java
/*
    基本数据类型在方法的调用过程中，形参的改变，不影响实参
 */
public class Demo14 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a); //10
        System.out.println(b); //20
        changeNum(a,b);
        System.out.println(a); //10
        System.out.println(b); //20
    }

    public static void changeNum(int a, int b) {
        System.out.println(a); //10
        System.out.println(b); //20
        a = a+b; // 30
        b = a+b; // 50
        System.out.println(a); //30
        System.out.println(b); //50
    }
}

```

#### 1.14 引用数据类型在方法的调用过程中，形参的改变，影响实参

```java
/*
    引用数据类型在方法的调用过程中，形参的改变，影响实参
 */
public class Demo15 {
    public static void main(String[] args) {
        int [] arr = new int[3];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        System.out.println(arr);
        System.out.println(arr[0]); //10
        System.out.println(arr[1]); //20
        System.out.println(arr[2]); //30
        changeNum(arr);
        System.out.println(arr);
        System.out.println(arr[0]); //10 11
        System.out.println(arr[1]); //20 22
        System.out.println(arr[2]); //30 33
    }

    public static void changeNum(int[] arr) {
        System.out.println(arr);
        System.out.println(arr[0]);//10
        System.out.println(arr[1]);//20
        System.out.println(arr[2]);//30
        arr[0] = 11;
        arr[1] = 22;
        arr[2] = 33;
        System.out.println(arr);
        System.out.println(arr[0]);//11
        System.out.println(arr[1]);//22
        System.out.println(arr[2]);//33
    }
}

```

#### 1.15 获取数组最大值和最小值

```java
/*
    获取数组最大值和最小值

    需求：设计一个方法用于获取数组中元素的最大值，和最小值
    分析：
        1.参数：int [] arr
        2.返回值：int []

 */
public class Demo16 {
    public static void main(String[] args) {
        //定义一个数组，用静态初始化完成数组元素初始化
        int[] arr = {87, 10, 70, 74, 3, 18, 67, 63, 94, 37};
        int[] maxAndMin = getMaxAndMin(arr);
        System.out.println(maxAndMin[0]);
        System.out.println(maxAndMin[1]);

        System.out.println(Arrays.toString(maxAndMin));

    }

    public static int[] getMaxAndMin(int[] arr) {
        //1.定义最大值
        int max = arr[0];
        //2.循环遍历
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //2.定义最小值
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
//        int [] brr = {max,min};
        int[] brr = new int[2];
        brr[0] = max;
        brr[1] = min;

        return brr;
    }
}

```



















