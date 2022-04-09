package com.adam.account.service;

import com.adam.account.dto.AccountRegisterDto;
import com.adam.account.entity.AdamAccount;
import com.adam.account.vo.UserLoginVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 统一用户管理系统-账户 服务类
 * </p>
 *
 * @author Moky
 * @since 2021-12-28
 */
public interface IAdamAccountService extends IService<AdamAccount> {

    UserLoginVo doRegister(AccountRegisterDto dto);
}
