package com.adam.gateway.authentication;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mokaiyang
 * @version 1.0
 * @description: TODO
 * @date 2021/12/24 16:38
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object o, String s) {
        // 返回此 loginId 拥有的权限列表
        //调用account服务
        List<String> result = new ArrayList<>();
        result.add("user");
        return result;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        // 返回此 loginId 拥有的角色列表
        //调用account服务
        List<String> result = new ArrayList<>();
        return result;
    }
}
