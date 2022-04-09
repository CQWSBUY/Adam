package com.adam.account.controller;


import com.adam.account.dto.AccountRegisterDto;
import com.adam.account.service.IAdamAccountService;
import com.adam.account.vo.UserLoginVo;
import com.adam.common.result.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 统一用户管理系统-账户 前端控制器
 * </p>
 *
 * @author Moky
 * @since 2021-12-28
 */
@Controller
@RequestMapping("/account/adam-account")
public class AdamAccountController {

    @Autowired
    private IAdamAccountService adamAccountService;
    /**
     * 用户注册
     *
     * @param dto
     * @return
     */
    @PostMapping("/doRegister")
    public JSONResult doRegister(@RequestBody @Validated AccountRegisterDto dto) {
        UserLoginVo result = adamAccountService.doRegister(dto);
        return JSONResult.success(result);
    }
}
