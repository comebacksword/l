## 选择题

### 题目1(单选):

**对于以下多线程创建代码补全( A )**

```java
public class MyThread01 {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        // 开启线程
        __位置3__
    }
}
class MyThread  __位置1__  Thread {
    @Override
    public void __位置2__() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("i:" + i);
        }
    }
}
```



#### 选项 :

​	A. 位置1: extends       	 位置2: run  	位置3: mt.start();

​	B. 位置1: extends       	 位置2: run  	位置3: mt.run();

​	C. 位置1: implements 	位置2: run  	位置3: mt.start();

​	D. 位置1: implements 	位置2: run  	位置3: mt.start();



### 题目2(单选):

**对于以下多线程创建代码补全( C )**

```java
public class MyThread02 {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread thread= new Thread(__位置3__);
        thread.start();
    }
}

class MyRunnable __位置1__ Runnable {
    @Override
    public void __位置2__() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("i:" + i);
        }
    }
}
```



#### 选项 :

​	A. 位置1: extends 		  位置2: run	位置3:mr

​	B. 位置1: extends 		  位置2: call	位置3:"线程名"

​	C. 位置1: implements	位置2: run	位置3:mr

​	D. 位置1: implements	位置2: run	位置3:"线程名"



### 题目3(单选):

**关于下列同步说法错误的是 ( D )**

#### 选项 :

​	A. 同步代码块可以锁住指定代码,同步方法是锁住方法中所有代码

​	B. 同步代码块可以指定锁对象,同步方法不能指定锁对象

​	C. 对于非static方法,同步锁是this

​	D. 对于static方法,同步锁是调用此方法的对象



### 题目4(单选):

**将下列线程的死锁代码补全（ C ) **

```java
public class DeadLockDemo {
    public static void main(String[] args) {
        String 筷子A = "筷子A";
        String 筷子B = "筷子B";

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (__位置1__) {
                        System.out.println("小白拿到了筷子A ,等待筷子B....");
                        synchronized (__位置2__) {
                            System.out.println("小白拿到了筷子A和筷子B , 开吃!!!!!");
                        }
                    }
                }
            }
        }, "小白").__位置3__


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (筷子B) {
                        System.out.println("小黑拿到了筷子B ,等待筷子A....");
                        synchronized (筷子A) {
                            System.out.println("小黑拿到了筷子B和筷子A , 开吃!!!!!");
                        }
                    }
                }
            }
        }, "小黑").start();
    }
}
```

#### 选项 :

​	A. 位置1:筷子A	 位置2:筷子B 	位置3: run();

​	B. 位置1:筷子B	 位置2:筷子A 	位置3: start();

​	C. 位置1:筷子A	 位置2:筷子B 	位置3: start();

​	D. 位置1:筷子B	 位置2:筷子A	 位置3: run();



### 题目5(单选):

**下列关于线程状态正确的是 ( C )**

#### 选项 : 

​	A. NEW,RUNNABLE,BLOCKED,RUNNING,TIMED_WAITING,TERMINATED

​	B. NEW,RUNNABLE,BLOCKED,RUNNING,WAITING,TERMINATED

​	C. NEW,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING,TERMINATED

​	D. NEW,RUNNABLE,BLOCKED,WAIT,TIMED_WAITING,TERMINATED



### 题目6(多选):

**关于等待唤醒方法描述正确的是( ACD )**

#### 选项 :

​	A. wait方法调用会导致当前线程释放掉锁资源

​	B. notify和notifyAll方法调用会导致当前线程释放掉锁资源

​	C. 等待和唤醒的方法，都要使用锁对象调用

​	D. 等待和唤醒方法应该使用相同的锁对象调用



### 题目7(单选):

**关于线程池使用的流程顺序是( BCDA )**

#### 选项 :

​	A. 如果线程池中的所有线程都被占用，提交的任务，只能等待线程池中的线程处理完当前任

​	B. 创建线程池指定线程开启的数量

​	C. 提交任务给线程池，线程池中的线程就会获取任务，进行处理任务

​	D. 线程处理完任务，不会销毁，而是返回到线程池中，等待下一个任务执行



### 题目8(单选):

**下列关于线程池说法错误的是( D )**

#### 选项 :

​	A. 减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。

​	B. 当任务到达时，任务可以不需要等待线程创建 , 就能立即执行

​	C. 为线程池提交任务的方法是submit方法

​	D. 关闭线程池方法close方法



### 题目9(单选):

**为下列线程池处理Runnable任务的代码补全( B )**

```java
package com.itheima.threadpool_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    1 需求 :
        使用线程池模拟游泳教练教学生游泳。
        游泳馆（线程池）内有3名教练（线程）
        游泳馆招收了5名学员学习游泳（任务）。

    2 实现步骤：
        创建线程池指定3个线程
        定义学员类实现Runnable，
        创建学员对象给线程池
 */
public class Test1 {
    public static void main(String[] args) {
        // 创建指定线程的线程池
        ExecutorService threadPool = Executors.__位置1__(3);

        // 提交任务
        threadPool.__位置2__(new MyRunnable());

        // 关闭线程池
        threadPool.__位置3__();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "执行了...");
    }
}
```

#### 选项 :

​	A. 位置1: ExecutorService			 位置2:submit	位置3:shutdown	

​	B. 位置1: newFixedThreadPool	位置2:submit	位置3:shutdown	

​	C. 位置1: newFixedThreadPool	位置2:add		  位置3:close

​	D. 位置1: newFixedThreadPool	位置2:submit	位置3:close



### 题目10(单选):

**为下列线程池处理Callable任务的代码补全( B )**

```java
public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建指定线程数量的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        Future<Integer> future = threadPool.submit(__位置2__);
        Integer sum = future.__位置3__();
        System.out.println(sum);
    }
}

class CalculateTask implements Callable<Integer> {
    private int num;

    public CalculateTask(int num) {
        this.num = num;
    }

    @Override
    public __位置1__ call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}
```

#### 选项 :

​	A. 位置1: Integer		  位置2: new CalculateTask(100) 		位置3: getResult

​	B. 位置1: Integer		  位置2: new CalculateTask(100) 		位置3: get

​	C. 位置1: String   		 位置2: new Callable(100) 				   位置3: getResult

​	D. 位置1: String   		 位置2: new CalculateTask(100) 		位置3: get

