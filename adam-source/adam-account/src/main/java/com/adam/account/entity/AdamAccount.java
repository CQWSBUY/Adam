package com.adam.account.entity;

import com.adam.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 统一用户管理系统-账户
 * </p>
 *
 * @author Moky
 * @since 2021-12-28
 */
@TableName("adam_account")
@ApiModel(value = "AdamAccount对象", description = "统一用户管理系统-账户")
public class AdamAccount extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("账户编号")
    private Long accountId;

    @ApiModelProperty("用户名")
    private String accountName;

    @ApiModelProperty("手机号")
    private String accountPhone;

    @ApiModelProperty("密码")
    private String accountPassword;

    @ApiModelProperty("盐")
    private String accountSalt;

    @ApiModelProperty("0 md5 1md5+盐")
    private Integer encryptionSchema;

    @ApiModelProperty("当前登录IP")
    private String currentLoginIp;

    @ApiModelProperty("当前登录终端类型")
    private Integer currentLoginType;

    @ApiModelProperty("上次登录IP")
    private String lastLoginIp;

    @ApiModelProperty("上次登录的终端类型")
    private String lastLoginType;

    @ApiModelProperty("绑定邮箱地址")
    private String accountEmail;

    @ApiModelProperty("性别")
    private Integer accountSex;

    @ApiModelProperty("生日")
    private LocalDate accountBirth;

    @ApiModelProperty("头像地址")
    private String accountHeadImg;

    @ApiModelProperty("账户状态0启用1禁用")
    private Integer accountStatus;

    @ApiModelProperty("图片信息key")
    private String headImageKey;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
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
    public String getAccountSalt() {
        return accountSalt;
    }

    public void setAccountSalt(String accountSalt) {
        this.accountSalt = accountSalt;
    }
    public Integer getEncryptionSchema() {
        return encryptionSchema;
    }

    public void setEncryptionSchema(Integer encryptionSchema) {
        this.encryptionSchema = encryptionSchema;
    }
    public String getCurrentLoginIp() {
        return currentLoginIp;
    }

    public void setCurrentLoginIp(String currentLoginIp) {
        this.currentLoginIp = currentLoginIp;
    }
    public Integer getCurrentLoginType() {
        return currentLoginType;
    }

    public void setCurrentLoginType(Integer currentLoginType) {
        this.currentLoginType = currentLoginType;
    }
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
    public String getLastLoginType() {
        return lastLoginType;
    }

    public void setLastLoginType(String lastLoginType) {
        this.lastLoginType = lastLoginType;
    }
    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }
    public Integer getAccountSex() {
        return accountSex;
    }

    public void setAccountSex(Integer accountSex) {
        this.accountSex = accountSex;
    }
    public LocalDate getAccountBirth() {
        return accountBirth;
    }

    public void setAccountBirth(LocalDate accountBirth) {
        this.accountBirth = accountBirth;
    }
    public String getAccountHeadImg() {
        return accountHeadImg;
    }

    public void setAccountHeadImg(String accountHeadImg) {
        this.accountHeadImg = accountHeadImg;
    }
    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }
    public String getHeadImageKey() {
        return headImageKey;
    }

    public void setHeadImageKey(String headImageKey) {
        this.headImageKey = headImageKey;
    }

    @Override
    public String toString() {
        return "AdamAccount{" +
            "accountId=" + accountId +
            ", accountName=" + accountName +
            ", accountPhone=" + accountPhone +
            ", accountPassword=" + accountPassword +
            ", accountSalt=" + accountSalt +
            ", encryptionSchema=" + encryptionSchema +
            ", currentLoginIp=" + currentLoginIp +
            ", currentLoginType=" + currentLoginType +
            ", lastLoginIp=" + lastLoginIp +
            ", lastLoginType=" + lastLoginType +
            ", accountEmail=" + accountEmail +
            ", accountSex=" + accountSex +
            ", accountBirth=" + accountBirth +
            ", accountHeadImg=" + accountHeadImg +
            ", accountStatus=" + accountStatus +
            ", headImageKey=" + headImageKey +
        "}";
    }
}
