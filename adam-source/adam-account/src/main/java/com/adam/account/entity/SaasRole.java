package com.adam.account.entity;

import com.adam.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author Moky
 * @since 2021-12-28
 */
@TableName("saas_role")
@ApiModel(value = "SaasRole对象", description = "角色表")
public class SaasRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("系统编号")
    private Integer subsystemId;

    @ApiModelProperty("角色状态，0启用，1禁用，2逻辑删除")
    private Integer roleStatus;

    @ApiModelProperty("角色备注")
    private String roleRemark;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Integer getSubsystemId() {
        return subsystemId;
    }

    public void setSubsystemId(Integer subsystemId) {
        this.subsystemId = subsystemId;
    }
    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }
    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    @Override
    public String toString() {
        return "SaasRole{" +
            "roleName=" + roleName +
            ", subsystemId=" + subsystemId +
            ", roleStatus=" + roleStatus +
            ", roleRemark=" + roleRemark +
        "}";
    }
}
