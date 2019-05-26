package com.ztc.latte.model;

import com.ztc.latte.base.BaseEntity;
import lombok.Data;

@Data
public class SysUserRole extends BaseEntity {

    private Long id;

    private String sysUserUid;

    private String sysRoleUid;

    private String createTime;

    private String createEmp;

    private String updateTime;

    private String updateEmp;

    private static final long serialVersionUID = 1L;

}