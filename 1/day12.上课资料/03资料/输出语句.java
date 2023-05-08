1.登录注册主界面的编写
System.out.println("======欢迎您进入到黑马ATM系统===============");
System.out.println("1、登录账户");
System.out.println("2、注册账户");
System.out.println("请您选择操作：");
2.
System.out.println("==================欢迎您进入到登录操作======================");
3.登录后展示的界面
System.out.println("==================欢迎您进入到操作界面======================");
System.out.println("1、查询");
System.out.println("2、存款");
System.out.println("3、取款");
System.out.println("4、转账");
System.out.println("5、修改密码");
System.out.println("6、退出");
System.out.println("7、注销账户");
System.out.println("请您输入操作命令：");
4.查询账户信息
System.out.println("==================您当前账户详情信息如下======================");
System.out.println("卡号：" + acc.getCardId());
System.out.println("户主：" + acc.getUserName());
System.out.println("余额：" + acc.getMoney());
System.out.println("当次取现额度：" + acc.getQuotaMoney());
5.存款
System.out.println("==================欢迎进入账户存款操作======================");
System.out.println("请您输入存款金额：");
double money = sc.nextDouble();
acc.setMoney(acc.getMoney() + money);
showAccount(acc);
6.取款
System.out.println("==================欢迎进入账户取款操作======================");