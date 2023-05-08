# day08-线程安全,死锁,状态,通讯,线程池

## 今日目标

- 线程安全
-  线程死锁
-  线程的状态
-  线程间通讯
-  线程池

## 1 线程安全

### 1.1 线程安全产生的原因 

- 多个线程在对共享数据进行读改写的时候，可能导致的数据错乱就是线程的安全问题了

```java
package com.itheima.ticket_demo;

/*
    电影院
 */
public class Ticket implements Runnable {
    private int ticketCount = 100; // 一共有一百张票

    @Override
    public void run() {
        while (true) {
            // 如果票的数量为0 , 那么停止买票
            if (ticketCount == 0) {
                break;
            } else {
                // 有剩余的票 , 开始卖票
                ticketCount--;
                System.out.println(Thread.currentThread().getName() + "卖出一张票,剩下" + ticketCount + "张");
            }
        }
    }
}

```

```java
package com.itheima.ticket_demo;

/*
    1 定义一个类Ticket实现Runnable接口，里面定义一个成员变量：private int ticketCount = 100;
    2 在Ticket类中重写run()方法实现卖票，代码步骤如下
        A：判断票数大于0，就卖票，并告知是哪个窗口卖的
        B：票数要减1
        C：卖光之后，线程停止
    3 定义一个测试类TicketDemo，里面有main方法，代码步骤如下
        A：创建Ticket类的对象
        B：创建三个Thread类的对象，把Ticket对象作为构造方法的参数，并给出对应的窗口名称
        C：启动线程

 */
public class TicketDemo {
    public static void main(String[] args) {
        // 创建任务类对象
        Ticket ticket = new Ticket();

        // 创建三个线程类对象
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        // 给三个线程命名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        // 开启三个线程
        t1.start();
        t2.start();
        t3.start();
    }
}

```

##### 注意 : 以上代码是有问题 , 接下来继续改进

- 因为出票是有时间的 , 所有现在在每次买票之前, 休眠100毫秒 , 尝试执行代码

```java
package com.itheima.ticket_demo;

/*
    电影院
 */
public class Ticket implements Runnable {
    private int ticketCount = 100; // 一共有一百张票

    @Override
    public void run() {
        while (true) {
            // 如果票的数量为0 , 那么停止买票
            if (ticketCount <= 0) {
                break;
            } else {

                // 模拟出票的时间
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 有剩余的票 , 开始卖票
                ticketCount--;
                System.out.println(Thread.currentThread().getName() + "卖出一张票,剩下" + ticketCount + "张");
            }
        }
    }
}

```

```java
package com.itheima.ticket_demo;

/*
    1 定义一个类Ticket实现Runnable接口，里面定义一个成员变量：private int ticketCount = 100;
    2 在Ticket类中重写run()方法实现卖票，代码步骤如下
        A：判断票数大于0，就卖票，并告知是哪个窗口卖的
        B：票数要减1
        C：卖光之后，线程停止
    3 定义一个测试类TicketDemo，里面有main方法，代码步骤如下
        A：创建Ticket类的对象
        B：创建三个Thread类的对象，把Ticket对象作为构造方法的参数，并给出对应的窗口名称
        C：启动线程

 */
public class TicketDemo {
    public static void main(String[] args) {
        // 创建任务类对象
        Ticket ticket = new Ticket();

        // 创建三个线程类对象
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        // 给三个线程命名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        // 开启三个线程
        t1.start();
        t2.start();
        t3.start();
    }
}

```

- ##### 通过上述代码的执行结果 , 发现了出现了负号票 , 和相同的票 , 数据有问题

  - 问题出现的原因 : 多个线程在对共享数据进行读改写的时候，可能导致的数据错乱就是线程的安全问题了

### 1.2 线程的同步

- 概述 : java允许多线程并发执行，当多个线程同时操作一个可共享的资源变量时（如数据的增删改查），将会导致数据不准确，相互之间产生冲突，因此加入同步锁以避免在该线程没有完成操作之前，被其他线程的调用，从而保证该变量的唯一性和准确性

- 分类 
  -  同步代码块
  -  同步方法
  - 锁机制。Lock

### 1.3 同步代码块

```
同步代码块 : 锁住多条语句操作共享数据，可以使用同步代码块实现

第一部分 : 格式
           synchronized(任意对象) {
                   多条语句操作共享数据的代码
           }

第二部分 : 注意
           1 默认情况锁是打开的，只要有一个线程进去执行代码了，锁就会关闭
           2 当线程执行完出来了，锁才会自动打开

第三部分 : 同步的好处和弊端
            好处 : 解决了多线程的数据安全问题
            弊端 : 当线程很多时，因为每个线程都会去判断同步上的锁，这是很耗费资源的，无形中会降低程序的运行效率
```

```java
public class Ticket implements Runnable {
    private int ticketCount = 100; // 一共有一百张票

    @Override
    public void run() {
        while (true) {
            synchronized (Ticket.class) {
                // 如果票的数量为0 , 那么停止买票
                if (ticketCount <= 0) {
                    break;
                } else {
                    // 模拟出票的时间
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 有剩余的票 , 开始卖票
                    ticketCount--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张票,剩下" + ticketCount + "张");
                }
            }
        }
    }
}
```

```java
package com.itheima.synchronized_demo1;

/*
    1 定义一个类Ticket实现Runnable接口，里面定义一个成员变量：private int ticketCount = 100;
    2 在Ticket类中重写run()方法实现卖票，代码步骤如下
        A：判断票数大于0，就卖票，并告知是哪个窗口卖的
        B：票数要减1
        C：卖光之后，线程停止
    3 定义一个测试类TicketDemo，里面有main方法，代码步骤如下
        A：创建Ticket类的对象
        B：创建三个Thread类的对象，把Ticket对象作为构造方法的参数，并给出对应的窗口名称
        C：启动线程

 */
public class TicketDemo {
    public static void main(String[] args) {
        // 创建任务类对象
        Ticket ticket = new Ticket();

        // 创建三个线程类对象
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        // 给三个线程命名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        // 开启三个线程
        t1.start();
        t2.start();
        t3.start();
    }
}

```

### 1.4 同步方法

```
同步方法：就是把synchronized关键字加到方法上

格式：修饰符 synchronized 返回值类型 方法名(方法参数) {    }

同步代码块和同步方法的区别:
    1 同步代码块可以锁住指定代码,同步方法是锁住方法中所有代码
    2 同步代码块可以指定锁对象,同步方法不能指定锁对象

注意 : 同步方法时不能指定锁对象的 , 但是有默认存在的锁对象的。
    1 对于非static方法,同步锁就是this。
    2 对于static方法,我们使用当前方法所在类的字节码对象(类名.class)。   Class类型的对象
```

```java
package com.itheima.synchronized_demo2;

/*
    同步方法：就是把synchronized关键字加到方法上

    格式：修饰符 synchronized 返回值类型 方法名(方法参数) {    }

    同步代码块和同步方法的区别:
        1 同步代码块可以锁住指定代码,同步方法是锁住方法中所有代码
        2 同步代码块可以指定锁对象,同步方法不能指定锁对象

    注意 : 同步方法时不能指定锁对象的 , 但是有默认存在的锁对象的。
        1 对于非static方法,同步锁就是this。
        2 对于static方法,我们使用当前方法所在类的字节码对象(类名.class)。   Class类型的对象

 */
public class Ticket implements Runnable {
    private int ticketCount = 100; // 一共有一百张票

    @Override
    public void run() {
        while (true) {
            if (method()) {
                break;
            }
        }
    }

    private synchronized boolean method() {
        // 如果票的数量为0 , 那么停止买票
        if (ticketCount <= 0) {
            return true;
        } else {
            // 模拟出票的时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 有剩余的票 , 开始卖票
            ticketCount--;
            System.out.println(Thread.currentThread().getName() + "卖出一张票,剩下" + ticketCount + "张");
            return false;
        }
    }
}

```

```java
package com.itheima.synchronized_demo2;

/*
    1 定义一个类Ticket实现Runnable接口，里面定义一个成员变量：private int ticketCount = 100;
    2 在Ticket类中重写run()方法实现卖票，代码步骤如下
        A：判断票数大于0，就卖票，并告知是哪个窗口卖的
        B：票数要减1
        C：卖光之后，线程停止
    3 定义一个测试类TicketDemo，里面有main方法，代码步骤如下
        A：创建Ticket类的对象
        B：创建三个Thread类的对象，把Ticket对象作为构造方法的参数，并给出对应的窗口名称
        C：启动线程

 */
public class TicketDemo {
    public static void main(String[] args) {
        // 创建任务类对象
        Ticket ticket = new Ticket();

        // 创建三个线程类对象
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        // 给三个线程命名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        // 开启三个线程
        t1.start();
        t2.start();
        t3.start();
    }
}
```

### 1.5 Lock锁

```
虽然我们可以理解同步代码块和同步方法的锁对象问题，但是我们并没有直接看到在哪里加上了锁，在哪里释放了锁，
为了更清晰的表达如何加锁和释放锁，JDK5以后提供了一个新的锁对象Lock

Lock中提供了获得锁和释放锁的方法
    void lock()：获得锁
    void unlock()：释放锁

Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来实例化
    ReentrantLock的构造方法
    ReentrantLock()：创建一个ReentrantLock的实例

注意：多个线程使用相同的Lock锁对象，需要多线程操作数据的代码放在lock()和unLock()方法之间。一定要确保unlock最后能够调用
```

```java
package com.itheima.synchronized_demo3;

import java.util.concurrent.locks.ReentrantLock;

/*
    虽然我们可以理解同步代码块和同步方法的锁对象问题，但是我们并没有直接看到在哪里加上了锁，在哪里释放了锁，
    为了更清晰的表达如何加锁和释放锁，JDK5以后提供了一个新的锁对象Lock

    Lock中提供了获得锁和释放锁的方法
        void lock()：获得锁
        void unlock()：释放锁

    Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来实例化
        ReentrantLock的构造方法
        ReentrantLock​()：创建一个ReentrantLock的实例

    注意：多个线程使用相同的Lock锁对象，需要多线程操作数据的代码放在lock()和unLock()方法之间。一定要确保unlock最后能够调用

 */
public class Ticket implements Runnable {
    private int ticketCount = 100; // 一共有一百张票
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();// 加锁
                // 如果票的数量为0 , 那么停止买票
                if (ticketCount <= 0) {
                    break;
                } else {
                    // 模拟出票的时间
                    Thread.sleep(100);
                    // 有剩余的票 , 开始卖票
                    ticketCount--;
                    System.out.println(Thread.currentThread().getName() + "卖出一张票,剩下" + ticketCount + "张");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();// 释放锁
            }
        }
    }
}

```

```java
package com.itheima.synchronized_demo3;

/*
    1 定义一个类Ticket实现Runnable接口，里面定义一个成员变量：private int ticketCount = 100;
    2 在Ticket类中重写run()方法实现卖票，代码步骤如下
        A：判断票数大于0，就卖票，并告知是哪个窗口卖的
        B：票数要减1
        C：卖光之后，线程停止
    3 定义一个测试类TicketDemo，里面有main方法，代码步骤如下
        A：创建Ticket类的对象
        B：创建三个Thread类的对象，把Ticket对象作为构造方法的参数，并给出对应的窗口名称
        C：启动线程

 */
public class TicketDemo {
    public static void main(String[] args) {
        // 创建任务类对象
        Ticket ticket = new Ticket();

        // 创建三个线程类对象
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        // 给三个线程命名
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
        // 开启三个线程
        t1.start();
        t2.start();
        t3.start();
    }
}

```

## 2 线程死锁

### 2.1 概述 : 

- 死锁是一种少见的，而且难于调试的错误，在两个线程对两个同步锁对象具有循环依赖时，就会大概率的出现死锁。我们要避免死锁的产生。否则一旦死锁，除了重启没有其他办法的

### 2.2 产生条件 : 

- 多个线程
- 存在锁对象的循环依赖

### 2.3 代码实践

```java
package com.itheima.deadlock_demo;

/*
    死锁 :
        死锁是一种少见的，而且难于调试的错误，在两个线程对两个同步锁对象具有循环依赖时，就会大概率的出现死锁。
        我们要避免死锁的产生。否则一旦死锁，除了重启没有其他办法的
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String 筷子A = "筷子A";
        String 筷子B = "筷子B";

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (筷子A) {
                        System.out.println("小白拿到了筷子A ,等待筷子B....");
                        synchronized (筷子B) {
                            System.out.println("小白拿到了筷子A和筷子B , 开吃!!!!!");
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "小白").start();


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
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "小黑").start();
    }
}

```

## 3 线程的状态

![image-20210411221907949](D:\传智播客\上海-JavaSE进阶面授\day09【线程安全，死锁，线程状态，线程间通信，线程池】\笔记\img\image-20210411221907949.png)

![image-20210411221949088](D:\传智播客\上海-JavaSE进阶面授\day09【线程安全，死锁，线程状态，线程间通信，线程池】\笔记\img\image-20210411221949088.png)

## 4 线程通信

- 线程间的通讯技术就是通过等待和唤醒机制，来实现多个线程协同操作完成某一项任务，例如经典的生产者和消费者案例。等待唤醒机制其实就是让线程进入等待状态或者让线程从等待状态中唤醒，需要用到两种方法，如下：

- 等待方法 : 

  - void wait()   让线程进入无限等待。
  - void wait(long timeout)   让线程进入计时等待 
  - 以上两个方法调用会导致当前线程释放掉锁资源。  

- 唤醒方法 : 

  -  void notify()  唤醒在此对象监视器（锁对象）上等待的单个线程。
  -  void notifyAll() 唤醒在此对象监视器上等待的所有线程。 
  -  以上两个方法调用不会导致当前线程释放掉锁资源

- 注意

  - 等待和唤醒的方法，都要使用锁对象调用（需要在同步代码块中调用)
  - 等待和唤醒方法应该使用相同的锁对象调用

- ```java
  package com.itheima.waitnotify_demo;
  
  /*
      1 线程进入无限等待
          注意：进入无限等待需要使用锁在同步代码中调用wait方法
   */
  public class Test1 {
      public static void main(String[] args) {
          Object obj = new Object(); // 作为锁对象
  
          new Thread(new Runnable() {
              @Override
              public void run() {
                  synchronized (obj) {
                      System.out.println("线程开始执行");
                      System.out.println("线程进入无线等待....");
                      try {
                          obj.wait(); // 进入无线等待状态 , 并释放锁
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      System.out.println("无线等待被唤醒....");
                  }
              }
          }).start();
      }
  }
  
  ```

- ```java
  package com.itheima.waitnotify_demo;
  
  /*
      线程进入无限等待后被唤醒
      注意：等待和唤醒是两个或多个线程之间实现的。进入无限等待的线程是不会自动唤醒，只能通过其他线程来唤醒。
   */
  public class Test2 {
      public static void main(String[] args) {
          Object obj = new Object(); // 作为锁对象
  
          new Thread(new Runnable() {
              @Override
              public void run() {
                  synchronized (obj) {
                      System.out.println("线程开始执行");
                      System.out.println("线程进入无线等待....");
                      try {
                          obj.wait(); // 进入无线等待状态 , 并释放锁
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      System.out.println("无线等待被唤醒....");
                  }
              }
          }).start();
  
  
          new Thread(new Runnable() {
              @Override
              public void run() {
                  try {
                      Thread.sleep(3000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  synchronized (obj) {
                      obj.notify();// 随机唤醒此监视器中等待的线程 , 不会释放锁
                      System.out.println("唤醒后 , 5秒钟后释放锁");
                      try {
                          Thread.sleep(5000);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }// 释放锁
              }
          }).start();
      }
  }
  
  ```

- ```java
  package com.itheima.waitnotify_demo;
  
  /*
      3 线程进入计时等待并唤醒
          注意：进入计时等待的线程，时间结束前可以被其他线程唤醒。时间结束后会自动唤醒
   */
  public class Test3 {
      public static void main(String[] args) {
          new Thread(new Runnable() {
              @Override
              public void run() {
                  synchronized (Test3.class) {
                      System.out.println("获取到锁 , 开始执行");
                      try {
                          System.out.println("进入计时等待...3秒");
                          Test3.class.wait(3000);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      System.out.println("自动唤醒.");
                  }
              }
          }).start();
      }
  }
  
  ```

- ##### 生产者和消费者案例

  ```java
  package com.itheima.waitnotify_demo2;
  
  import sun.security.krb5.internal.crypto.Des;
  
  /*
      生产者步骤：
          1，判断桌子上是否有汉堡包
              如果有就等待，如果没有才生产。
          2，把汉堡包放在桌子上。
          3，叫醒等待的消费者开吃
   */
  public class Cooker implements Runnable {
      @Override
      public void run() {
          while (true) {
              synchronized (Desk.lock) {
                  if (Desk.count == 0) {
                      break;
                  } else {
                      if (Desk.flag) {
                          // 桌子上有食物
                          try {
                              Desk.lock.wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      } else {
                          // 桌子上没有食物
                          System.out.println("厨师生产了一个汉堡包...");
                          Desk.flag = true;
                          Desk.lock.notify();
                      }
                  }
              }
          }
      }
  }
  
  ```

  ```java
  package com.itheima.waitnotify_demo2;
  
  import sun.security.krb5.internal.crypto.Des;
  
  /*
      消费者步骤：
          1，判断桌子上是否有汉堡包。
          2，如果没有就等待。
          3，如果有就开吃
          4，吃完之后，桌子上的汉堡包就没有了
              叫醒等待的生产者继续生产
              汉堡包的总数量减一
   */
  public class Foodie implements Runnable {
      @Override
      public void run() {
          while (true) {
              synchronized (Desk.lock) {
                  if (Desk.count == 0) {
                      break;
                  } else {
                      if (Desk.flag) {
                          // 桌子上有食物
                          System.out.println("吃货吃了一个汉堡包...");
                          Desk.count--; // 汉堡包的数量减少一个
                          Desk.flag = false;// 桌子上的食物被吃掉 , 值为false
                          Desk.lock.notify();
                      } else {
                          // 桌子上没有食物
                          try {
                              Desk.lock.wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  }
              }
          }
      }
  }
  
  ```

  ```java
  package com.itheima.waitnotify_demo2;
  
  public class Test {
      public static void main(String[] args) {
          new Thread(new Foodie()).start();
          new Thread(new Cooker()).start();
      }
  }
  
  ```

  

## 5 线程池

### 5.1 线程使用存在的问题

- 如果并发的线程数量很多，并且每个线程都是执行一个时间很短的任务就结束了，这样频繁创建线程就会大大降低系统的效率，因为频繁创建线程和销毁线程需要时间。
  如果大量线程在执行，会涉及到线程间上下文的切换，会极大的消耗CPU运算资源

### 5.2 线程池的介绍

- 其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，无需反复创建线程而消耗过多资源。

### 5.3 线程池使用的大致流程

- 创建线程池指定线程开启的数量
- 提交任务给线程池，线程池中的线程就会获取任务，进行处理任务。
- 线程处理完任务，不会销毁，而是返回到线程池中，等待下一个任务执行。
- 如果线程池中的所有线程都被占用，提交的任务，只能等待线程池中的线程处理完当前任

### 5.4 线程池的好处

- 降低资源消耗。减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
- 提高响应速度。当任务到达时，任务可以不需要等待线程创建 , 就能立即执行。
- 提高线程的可管理性。可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗过多的内存 (每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机)。

### 5.4 Java提供好的线程池

- java.util.concurrent.ExecutorService 是线程池接口类型。使用时我们不需自己实现，JDK已经帮我们实现好了
- 获取线程池我们使用工具类java.util.concurrent.Executors的静态方
  - public static ExecutorService newFixedThreadPool (int num)  : 指定线程池最大线程池数量获取线程池
- 线程池ExecutorService的相关方法
  - <T> Future<T>  submit(Callable<T> task) 
  - Future<?> submit(Runnable task)
- 关闭线程池方法（一般不使用关闭方法，除非后期不用或者很长时间都不用，就可以关闭）
  - void shutdown()  启动一次顺序关闭，执行以前提交的任务，但不接受新任务

### 5.5 线程池处理Runnable任务

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
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        // 提交任务
        threadPool.submit(new Student("小花"));
        threadPool.submit(new Student("小红"));
        threadPool.submit(new Student("小明"));
        threadPool.submit(new Student("小亮"));
        threadPool.submit(new Student("小白"));

        threadPool.shutdown();// 关闭线程池
    }
}

class Student implements Runnable {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String coach = Thread.currentThread().getName();
        System.out.println(coach + "正在教" + name + "游泳...");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(coach + "教" + name + "游泳完毕.");
    }
}

```

### 5.6 线程池处理Callable任务

```java
package com.itheima.threadpool_demo;

import java.util.concurrent.*;

/*
    需求: Callable任务处理使用步骤
        1 创建线程池
        2 定义Callable任务
        3 创建Callable任务，提交任务给线程池
        4 获取执行结果

    <T> Future<T> submit(Callable<T> task) : 提交Callable任务方法    
    返回值类型Future的作用就是为了获取任务执行的结果。
    Future是一个接口，里面存在一个get方法用来获取值

    练一练：使用线程池计算 从0~n的和，并将结果返回
 */
public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建指定线程数量的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        Future<Integer> future = threadPool.submit(new CalculateTask(100));
        Integer sum = future.get();
        System.out.println(sum);
    }
}

// 使用线程池计算 从0~n的和，并将结果返回
class CalculateTask implements Callable<Integer> {
    private int num;

    public CalculateTask(int num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;// 求和变量
        for (int i = 0; i <= num; i++) {
            sum += i;
        }
        return sum;
    }
}

```

