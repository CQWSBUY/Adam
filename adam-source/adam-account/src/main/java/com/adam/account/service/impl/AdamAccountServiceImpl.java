package com.adam.account.service.impl;

import com.adam.account.dto.AccountRegisterDto;
import com.adam.account.entity.AdamAccount;
import com.adam.account.mapper.AdamAccountMapper;
import com.adam.account.service.IAdamAccountService;
import com.adam.account.vo.UserLoginVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 统一用户管理系统-账户 服务实现类
 * </p>
 *
 * @author Moky
 * @since 2021-12-28
 */
@Service
public class AdamAccountServiceImpl extends ServiceImpl<AdamAccountMapper, AdamAccount> implements IAdamAccountService {

    @Override
    public UserLoginVo doRegister(AccountRegisterDto dto) {
        AdamAccount adamAccount = new AdamAccount();
        BeanUtils.copyProperties(dto,adamAccount);
        String orgPwd = adamAccount.getAccountPassword();
        //获取盐
        //明文加密
        return null;
    }
}
