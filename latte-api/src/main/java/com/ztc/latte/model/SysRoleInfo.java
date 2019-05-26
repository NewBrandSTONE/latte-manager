package com.ztc.latte.model;

import com.ztc.latte.base.BaseEntity;
import lombok.Data;

@Data
public class SysRoleInfo extends BaseEntity {

    private Long id;

    private String sysRoleUid;

    private String sysRoleName;

    private String sysRoleDesc;

    private String createTime;

    private String createEmp;

    private String updateTime;

    private String updateEmp;

    private Byte isDelete;

    private static final long serialVersionUID = 1L;

}