package com.itheima.ATMSystem;

import com.itheima.domain.Account;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMSystemOS {
    public static void main(String[] args) {
        //创建集合存储用户信息
        ArrayList<Account> accountsList = new ArrayList<>();
        //键盘录入
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======欢迎您进入到黑马ATM系统===============");
            System.out.println("1.登录账户");
            System.out.println("2.注册账户");
            System.out.println("请您选择操作：");
            int num = sc.nextInt();
            switch (num) {
                case 1:
//                    System.out.println("1.登录账户");
                    login(accountsList, sc);
                    break;
                case 2:
//                    System.out.println("2.注册账户");
                    register(accountsList, sc);
                    break;
                default:
                    System.out.println("您输入的功能不存在，请确认后从新输入！");
            }
        }

    }

    //用户登录
    private static void login(ArrayList<Account> accountsList, Scanner sc) {
        if (accountsList.isEmpty()) {
            System.out.println("没有账户信息，请注册后在操作");
            return;
        }
        System.out.println("==================欢迎您进入到登录操作======================");
        while (true) {
            System.out.println("请您输入登录的卡号:");
            String cardID = sc.next();
            Account account = isCardIDExist(accountsList, cardID);
            if (account != null) {
                while (true) {
                    System.out.println("请您输入登录的密码：");
                    String pwd = sc.next();
                    if (account.getPassword().equals(pwd)) {
                        System.out.println("登录成功！");
                        showCommand(account, accountsList, sc);
                        return;
                    } else {
                        System.out.println("您的密码不正确！");
                    }
                }

            } else {
                System.out.println("不存在该卡号，请确认后，重新输入！");
            }
        }
    }

    /**
     * 用户登录后的操作界面
     *
     * @param account      当前账户信息类
     * @param accountsList 所有账户信息的集合
     * @param sc           键盘录入
     */
    private static void showCommand(Account account, ArrayList<Account> accountsList, Scanner sc) {
        while (true) {
            System.out.println("==================欢迎您进入到操作界面======================");
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
//                    System.out.println("1、查询");
                    findAccount(account);
                    break;
                case 2:
//                    System.out.println("2、存款");
                    savingsMoney(account, sc);
                    break;
                case 3:
//                    System.out.println("3、取款");
                    drawMoney(account, sc);
                    break;
                case 4:
//                    System.out.println("4、转账");
                    transferMoney(account, accountsList, sc);
                    break;
                case 5:
//                    System.out.println("5、修改密码");
                    updatePassWord(account, sc);
                    return;
                case 6:
                    System.out.println("您以安全退出，谢谢使用");
                    return;
                case 7:
//                    System.out.println("7、注销账户");
                    accountsList.remove(account);
                    System.out.println("您的账户已被注销，以后不能使用！");
                    return;
                default:
                    System.out.println("您选择的功能不存在，请确认后重新输入！");
                    break;
            }
        }

    }

    //修改密码
    private static void updatePassWord(Account account, Scanner sc) {
        System.out.println("==================欢迎进入密码修改操作======================");
        while (true) {
            System.out.println("请输入当前账户的密码：");
            String pwd = sc.next();
            if (account.getPassword().equals(pwd)) {
                while (true) {
                    System.out.println("请输入新的密码：");
                    String newPwd = sc.next();
                    //如果新密码和老密码不相同，更新密码
                    if (!account.getPassword().equals(newPwd)) {
                        //更新密码
                        System.out.println("请确认新的密码：");
                        String reNewPwd = sc.next();
                        if (newPwd.equals(reNewPwd)) {
                            account.setPassword(newPwd);
                            System.out.println("密码修改成功");
                            return;
                        } else {
                            System.out.println("两次输入不一致，请重新输入！");
                        }

                    } else {
                        System.out.println("新密码和旧密码不能相同，请重新输入新密");
                    }
                }
            } else {
                System.out.println("当前用户密码不正确！");
            }
        }

    }

    //转账功能
    private static void transferMoney(Account account, ArrayList<Account> accountsList, Scanner sc) {
        //判断账户是否大于2个
        if (accountsList.size() < 2) {
            System.out.println("当前账户不足2个，不能转账！");
            return;
        }
        //判断账户中是否有钱
        if (account.getMoney() <= 0) {
            System.out.println("您自己就没钱，就别转了！");
            return;
        }
        while (true) {
            System.out.println("============欢迎进入账户转账操作==============");
            System.out.println("请输入您要转账的账号：");
            String transferCardID = sc.next();
            //查询账户是否存在
            Account transferAccount = isCardIDExist(accountsList, transferCardID);
            //账户存在，进行转账操作
            if (transferAccount != null) {
                while (true) {
                    String transferUsername = transferAccount.getUsername();
                    System.out.println("你要给*" + transferUsername.substring(1) + "账户转账！");
                    System.out.println("请输入姓氏确认：");
                    String firstName = sc.next();
                    if (transferUsername.startsWith(firstName)) {
                        while (true) {
                            System.out.println("请输入你要转账的金额：");
                            double transferMoney = sc.nextDouble();
                            if (account.getMoney() >= transferMoney) {
                                //从当前账户转出
                                account.setMoney(account.getMoney() - transferMoney);
                                //存入到转入账户
                                transferAccount.setMoney(transferAccount.getMoney() + transferMoney);
                                System.out.println("转账成功！");
                                findAccount(account);
                                return;
                            } else {
                                System.out.println("余额不足！请确认后在转账！");
                            }
                        }
                    } else {
                        System.out.println("您输入的姓氏有误，请重新输入！");
                    }
                }

            } else {
                System.out.println("您输入的账号不存在，请确认后，重新输入！");
            }
        }

    }

    //取款界面
    private static void drawMoney(Account account, Scanner sc) {
        System.out.println("==================欢迎进入账户取款操作======================");
        if (account.getMoney() < 100) {
            System.out.println("您的账户余额不足100元，不能取款！");
            return;
        }
        while (true) {
            System.out.println("请输入您的取款金额【您的每次取现额度额" + account.getQuotaMoney() + "】：");
            double money = sc.nextDouble();
            if (money <= account.getMoney()) {
                if (money <= account.getQuotaMoney()) {
                    //取钱
                    account.setMoney(account.getMoney() - money);
                    //调用查询
                    findAccount(account);

                    return;
                } else {
                    System.out.println("您取款金额，超出当次限额！");
                }
            } else {
                System.out.println("余额不足：" + account.getMoney());
            }
        }
    }

    //存款界面
    private static void savingsMoney(Account account, Scanner sc) {
        System.out.println("==================欢迎进入账户存款操作======================");
        System.out.println("请您输入存款金额：");
        double money = sc.nextDouble();
        account.setMoney(account.getMoney() + money);
        System.out.println("存款成功！");
        //调用查询方法
        findAccount(account);
    }


    //用户详情界面
    private static void findAccount(Account account) {
        System.out.println("==================欢迎您进入黑马银行用户详情界面======================");
        System.out.println("您的账户信息如下：");
        System.out.println("卡号：" + account.getCardID());
        System.out.println("户主：" + account.getUsername());
        System.out.println("余额：" + account.getMoney());
        System.out.println("当次取现额度：" + account.getQuotaMoney());
    }

    //注册用户
    private static void register(ArrayList<Account> accountsList, Scanner sc) {
        //创建账户
        Account account = new Account();
        System.out.println("==================欢迎您进入到开户操作======================");
        System.out.println("请您输入账户名称：");
        String username = sc.next();
        account.setUsername(username);

        while (true) {
            System.out.println("请您输入账户密码：");
            String password = sc.next();
            System.out.println("请您输入确认密码：");
            String rePassword = sc.next();
            if (password.equals(rePassword)) {
                account.setPassword(password);
                break;
            } else {
                System.out.println("两次输入的密码不一致！");
            }
        }
        //生成卡号
        String cardID = createCardID(accountsList);
        account.setCardID(cardID);
        //每次取现额度
        System.out.println("请您设置当次取现额度：");
        double quotaMoney = sc.nextDouble();
        account.setQuotaMoney(quotaMoney);
        accountsList.add(account);
        System.out.println("恭喜您," + account.getUsername() + "先生/女士，您开户完成，您的卡号是：" + account.getCardID());
    }

    //生成卡号
    private static String createCardID(ArrayList<Account> accountsList) {
        //定义卡号 8 位数字
        while (true) {
            String cardID = "";
            Random random = new Random();
            for (int i = 0; i < 8; i++) {
                cardID += random.nextInt(10);
            }
            //判断卡号是否存在在集合中，如果存在从新生成
            Account account = isCardIDExist(accountsList, cardID);
            if (account == null) {
                return cardID;
            }
        }
    }

    //判断卡号是否存在，如果存在返回卡号所在的账户，如果不存在返回空
    private static Account isCardIDExist(ArrayList<Account> accountsList, String cardID) {
        //遍历集合
        for (int i = 0; i < accountsList.size(); i++) {
            //获取每一个账户
            Account account = accountsList.get(i);
            //如果存在返回账户信息
            if (account.getCardID().equals(cardID)) {
                return account;
            }
        }
        //如果不存在返回null
        return null;
    }

}
