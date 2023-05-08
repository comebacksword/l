## day11

学习目标：

 * 掌握添加学生功能的编写
 * 掌握查询学生功能的编写
 * 掌握修改学生功能的编写
 * 掌握删除学生功能的编写

### 1.学生类

```java
public class Student {
    private String id;      //学号
    private String name;    //姓名
    private String gender;  //性别
    private int age;        //年龄
    private String birthday;//生日

    public Student() {
    }

    public Student(String id, String name, String gender, int age, String birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

```

### 2.学生管理系统

```java
import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagerSystem {
    public static void main(String[] args) {
        //创建集合容器，用来存储学生对象
        ArrayList<Student> list = new ArrayList<>();
        //键盘录入
        Scanner sc = new Scanner(System.in);
        //主界面的编写
        wc:
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择:");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    //System.out.println("1 添加学生");
                    addStudent(list, sc);
                    break;
                case 2:
//                    System.out.println("2 删除学生");
                    removeStudent(list,sc);
                    break;
                case 3:
//                    System.out.println("3 修改学生");
                    updateStudent(list,sc);
                    break;
                case 4:
//                    System.out.println("4 查看学生");
                    showStudents(list);
                    break;
                case 5:
                    System.out.println("5 退出");
//                    break wc;
                    System.exit(0);
                default:
                    System.out.println("您的输入有误，请重新选择！");
            }
        }

    }
    //修改学生信息
    private static void updateStudent(ArrayList<Student> list, Scanner sc) {
        //判断集合是否为空
        if (list.isEmpty()){
            System.out.println("无信息，请添加后在操作！");
            return;
        }
        //修改学生信息
        System.out.println("请输入学生的学号：");
        String updateId = sc.next();
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId().equals(updateId)){
                //修改学生信息
               /* System.out.println("请输入你要修改的学生的姓名：");
                String name = sc.next();
                System.out.println("请输入你要修改的学生的性别：");
                String gender = sc.next();
                System.out.println("请输入你要修改的学生的年龄：");
                int age = sc.nextInt();
                System.out.println("请输入你要修改的学生的生日：");
                String birthday = sc.next();
                student.setName(name);
                student.setGender(gender);
                student.setAge(age);
                student.setBirthday(birthday);*/

                Student stu = getStudent(sc, updateId);
                list.set(i,stu);

                System.out.println("修改成功！");
            }else {
                System.out.println("学号不存在，请检查后，在操作");
            }
        }

    }

    //删除学生 根据学生学号删除学生
    private static void removeStudent(ArrayList<Student> list, Scanner sc) {
        //判断集合是否为空
        if (list.isEmpty()){
            System.out.println("无信息，请添加后在操作！");
            return;
        }
        //输入学生学号
        System.out.println("请输入你要删除的学生的学号：");
        String deleteId = sc.next();
        /*
            定义判断学号是否存在的方法
                参数：集合 学号
                返回值：int index
         */
        int index = isExistingStudentID(list,deleteId);
        if (index !=-1){
            list.remove(index);
            System.out.println("删除成功");
        }else {
            System.out.println("您输入的学号不存在，请检查后，在操作！");
        }
    }
    //判断学号是否在集合中存在，如果存在返回索引，如果不存在返回 -1
    private static int isExistingStudentID(ArrayList<Student> list, String deleteId) {
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getId().equals(deleteId)){
                return i;
            }
        }
        return -1;
    }

    //查看学生信息
    private static void showStudents(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("无信息，请添加后查询！");
            return;
        }
        System.out.println("学号\t\t姓名\t\t性别\t\t年龄\t\t生日");
        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId() + "\t\t" + student.getName() + "\t\t" + student.getGender() + "\t\t" + student.getAge() + "\t\t" + student.getBirthday()
            );
        }

    }

    //1 添加学生
    private static void addStudent(ArrayList<Student> list, Scanner sc) {
        /*String id = null;
        while (true) {
            System.out.println("请输入你要添加的学生的学号：");
            id = sc.next();
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                Student stu = list.get(i);
                if (stu.getId().equals(id)) {
                    flag = false;
                }
            }
            if (flag) {
                break;
            } else {
                System.out.println("学号已经被占用，请从新输入！");
            }
        }*/
        String id = null;
        while (true) {
            System.out.println("请输入你要添加的学生的学号：");
            id = sc.next();
            int index = isExistingStudentID(list, id);
            if (index == -1){
                //System.out.println("学号不存在，可以使用");
                break;
            }else {
                System.out.println("学号已经被占用，请从新输入！");
            }
        }


        Student student = getStudent(sc, id);
        list.add(student);
        System.out.println("添加成功！");

    }
    //输入学生信息  已知学号存在
    private static Student getStudent(Scanner sc, String id) {
        System.out.println("请输入你要添加的学生的姓名：");
        String name = sc.next();
        System.out.println("请输入你要添加的学生的性别：");
        String gender = sc.next();
        System.out.println("请输入你要添加的学生的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入你要添加的学生的生日：");
        String birthday = sc.next();
        Student student = new Student(id, name, gender, age, birthday);
        return student;
    }
}

```













