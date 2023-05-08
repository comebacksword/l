package com.itheima.domain;

/**
 *  每个用户一个账户对象，需要设计账户类，账户类至少包含(卡号、用户名、余额、取现额度、密码)
 */
public class Account {
    private String cardID; //卡号
    private String username;//用户名
    private String password;//密码
    private double money;//余额
    private double quotaMoney;//取现额度

    public Account() {
    }

    public Account(String cardID, String username, String password, double money, double quotaMoney) {
        this.cardID = cardID;
        this.username = username;
        this.password = password;
        this.money = money;
        this.quotaMoney = quotaMoney;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotaMoney() {
        return quotaMoney;
    }

    public void setQuotaMoney(double quotaMoney) {
        this.quotaMoney = quotaMoney;
    }
}
