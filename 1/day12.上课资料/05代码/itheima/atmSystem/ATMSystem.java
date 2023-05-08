package com.itheima.atmSystem;

import com.itheima.domain.Account;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystem {
    public static void main(String[] args) {
        //定义集合对象存储所有账户信息
        ArrayList<Account> accountArrayList = new ArrayList<>();

        //键盘录入的对象
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("======欢迎您进入到黑马ATM系统===============");
            System.out.println("1、登录账户");
            System.out.println("2、注册账户");
            System.out.println("请您选择操作:");
            int num = sc.nextInt();
            switch (num) {
                case 1:
//                    System.out.println("1、登录账户");
                    login(accountArrayList, sc);
                    break;
                case 2:
//                    System.out.println("2、注册账户");
                    register(accountArrayList, sc);
                    break;
                default:
                    System.out.println("您的输入有误！");
            }
        }
    }

    //登录账户
    private static void login(ArrayList<Account> accountArrayList, Scanner sc) {
        if (accountArrayList.isEmpty()) {
            System.out.println("账户个数为0，先注册在登录！");
            return;
        }
        System.out.println("==================欢迎您进入到登录操作======================");
        System.out.println("请您输入登录的卡号：");
        String inputCardID = sc.next();
        Account account = isCardIDExisting(accountArrayList, inputCardID);
        if (account == null) {
            System.out.println("您输入的卡号不存在，请检查后在操作");
            return;
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("请输入您的密码：");
            String inputPassWord = sc.next();
            if (account.getPassword().equals(inputPassWord)) {
                System.out.println("尊贵的：" + account.getUsername() + "先生/女士进入系统，您可开始办理你的业务了!您的卡号：" + account.getCardID());
                //展示用户操作界面
                showCommand(accountArrayList, account, sc);
                return;
            } else {
                if (2 - i == 0) {
                    System.out.println("您的账户被锁定，请到柜台办理！");
                    return;
                } else {
                    System.out.println("密码错误，请重新输入！你还有" + (2 - i) + "次机会！");
                }
            }
        }


    }

    //展示用户操作界面
    private static void showCommand(ArrayList<Account> accountArrayList, Account account, Scanner sc) {
        while (true) {
            System.out.println("==================欢迎您进入到用户操作界面======================");
            System.out.println("1、查询");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销账户");
            System.out.println("请您输入操作命令：");
            int num = sc.nextInt();
            switch (num) {
                case 1:
                    // System.out.println("1、查询");
                    //账户详情信息
                    showAccountInfo(account);
                    break;
                case 2:
//                    System.out.println("2、存款");
                    depositToAccount(account, sc);
                    break;
                case 3:
//                    System.out.println("3、取款");
                    withDrawByAccount(account,sc);
                    break;
                case 4:
//                    System.out.println("4、转账");
                    transferAccounts(accountArrayList,account,sc);
                    break;
                case 5:
//                    System.out.println("5、修改密码");
                    changePassword(account,sc);
                    return;
                case 6:
//                    System.out.println("6、退出");
                    return;
                case 7:
//                    System.out.println("7、注销账户");
                    accountArrayList.remove(account);
                    System.out.println("账户已注销！");
                    return;
                default:
                    System.out.println("您的输入有误，请重新输入");
            }
        }
    }
    //转账
    private static void transferAccounts(ArrayList<Account> accountArrayList, Account account, Scanner sc) {
        System.out.println("==================欢迎您进入到转账操作======================");
        if (accountArrayList.size()<2){
            System.out.println("当前系统账户不足两个，不能转账！");
            return;
        }
        if (account.getMoney()<=0){
            System.out.println("你自己都没钱，就别转了！");
            return;
        }
        System.out.println("请输入转账的卡号：");
        String transferCardID = sc.next();
        Account transferAccount = isCardIDExisting(accountArrayList, transferCardID);
        if (transferAccount == null){
            System.out.println("不存在该账户，请重新确认操作！");
            return;
        }else {
            System.out.println("你要为 *"+transferAccount.getUsername().substring(1)+"转账!");
            System.out.println("请输入姓氏确认：");
            String lastName = sc.next();
            if (transferAccount.getUsername().startsWith(lastName)){
                //可以转账
                System.out.println("请输入你要转账金额：");
                double transferMoney = sc.nextDouble();
                if (account.getMoney()>=transferMoney){
                    //从当前账户中转出
                    account.setMoney(account.getMoney()-transferMoney);
                    //存入到对方主账户
                    transferAccount.setMoney(transferAccount.getMoney()+transferMoney);
                    System.out.println("转账成功！");
                    //跳转到用户详情界面
                    showAccountInfo(account);
                }else {
                    System.out.println("余额不足！");
                    return;
                }
            }else {
                System.out.println("您输入姓氏有误，请重新选择！");
            }
        }
    }

    private static void changePassword(Account account, Scanner sc) {
        System.out.println("==================欢迎进入修改密码的操作======================");
        while (true) {
            System.out.println("请输入原密码：");
            String password = sc.next();
            if (account.getPassword().equals(password)){
                while (true) {
                    System.out.println("请输入新密码：");
                    String newPassWord = sc.next();
                    if (newPassWord.equals(password)){
                        System.out.println("新旧密码，不能一样！");
                        continue;
                    }else {
                        System.out.println("请确认您的新密码：");
                        String reNewPassWord = sc.next();
                        if (newPassWord.equals(reNewPassWord)){

                            account.setPassword(newPassWord);
                            return;
                        }else {
                            System.out.println("两次密码输入不一致！");
                        }
                    }

                }
            }else {
                System.out.println("密码错误，请重新输入！");
            }
        }

    }

    private static void withDrawByAccount(Account account, Scanner sc) {
        System.out.println("==================欢迎进入账户取款操作======================");
        double money = account.getMoney();
        if (money<=100){
            System.out.println("账户余额不足！");
            return;
        }
        double withDrawMoney;
        //判断是否超出当次取现额度
        while (true) {
            System.out.println("请输入你要取款的金额：");
            withDrawMoney = sc.nextDouble();
            if (withDrawMoney>account.getQuotaMoney()){  // 30000  50000
                System.out.println("您的取款金额超出了，当次取现的额度！");
            }else if (money<withDrawMoney){//判断账户余额是否大于取现额度  // 29999  30000
                System.out.println("账户余额不足！");
                return;
            }else {
                break;
            }
        }
        account.setMoney(money-withDrawMoney);
        System.out.println("取款成功！");
        showAccountInfo(account);

    }

    //存款到当前账户
    private static void depositToAccount(Account account, Scanner sc) {
        System.out.println("==================欢迎进入账户存款操作======================");
        while (true) {
            System.out.println("请您输入存款金额：");
            double inputMoney = sc.nextDouble();
            if (inputMoney >= 100 && inputMoney%100==0) {
                double money = account.getMoney();
                account.setMoney(money + inputMoney);
                System.out.println("您已经存款成功！");
                break;
            }else {
                System.out.println("您输入的金额不合理，请输入100的整数倍！");
            }
        }
        //调用展示用户详情界面
        showAccountInfo(account);
    }

    //账户详情信息
    private static void showAccountInfo(Account account) {
        System.out.println("==================您当前账户详情信息如下=====================");
        System.out.println("卡号：" + account.getCardID());
        System.out.println("姓名：" + account.getUsername());
        System.out.println("余额：" + account.getMoney());
        System.out.println("当次取现额度：" + account.getQuotaMoney());
    }

    //注册账户
    private static void register(ArrayList<Account> accountArrayList, Scanner sc) {
        System.out.println("==================欢迎您进入到开户操作======================");
        System.out.println("请您输入账户名称：");
        String username = sc.next();
        String password;
        while (true) {
            System.out.println("请您输入账户密码：");
            password = sc.next();
            System.out.println("请您输入确认密码：");
            String rePassWord = sc.next();
            if (password.equals(rePassWord)) {
                break;
            } else {
                System.out.println("两次输入的密码不一致！");
            }
        }
        //银行系统生成银行卡号
        String cardID = createCardId(accountArrayList);

        System.out.println("请您设置当次取现额度：");
        double quotaMoney = sc.nextDouble();

        Account account = new Account(cardID, username, password, 0.0, quotaMoney);
        accountArrayList.add(account);
        System.out.println("恭喜您," + account.getUsername() + "先生/女士，您开户完成，您的卡号是：" + account.getCardID());
    }

    //银行系统生成银行卡号
    private static String createCardId(ArrayList<Account> accountArrayList) {
        //开户的卡号是系统自动生成的8位数。
        Random random = new Random();
        while (true) {
            String cardID = "";
            for (int i = 0; i < 8; i++) {
                cardID += random.nextInt(10);
            }
        /*
            定义方法判断卡号是否存在
            参数：ArrayList<Account> accountArrayList,String cardID
            返回值：有 返回值类型 Account account
         */
            //判断卡号是否存在 返回账户信息
            Account account = isCardIDExisting(accountArrayList, cardID);
            if (account == null) {
                return cardID;
            }
        }
    }

    //判断卡号是否存在 返回账户信息 如果卡号存在在账户集合中返回账户信息，如果不存在返回null
    private static Account isCardIDExisting(ArrayList<Account> accountArrayList, String cardID) {
        for (int i = 0; i < accountArrayList.size(); i++) {
            Account account = accountArrayList.get(i);
            if (account.getCardID().equals(cardID)) {
                return account;
            }
        }
        return null;
    }
}
