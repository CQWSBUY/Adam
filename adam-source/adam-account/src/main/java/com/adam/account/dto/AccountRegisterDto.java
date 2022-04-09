package com.adam.account.dto;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: TODO
 * @date 2021/12/29 13:38
 */
public class AccountRegisterDto {
    /**
     * 用户名
     */
    private String accountName;
    /**
     * 用户手机号
     */
    private String accountPhone;
    /**
     * 用户密码
     */
    private String accountPassword;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPhone() {
        return accountPhone;
    }

    public void setAccountPhone(String accountPhone) {
        this.accountPhone = accountPhone;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}
