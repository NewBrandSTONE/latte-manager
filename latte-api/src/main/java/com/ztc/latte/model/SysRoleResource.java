package com.ztc.latte.model;

import com.ztc.latte.base.BaseEntity;
import lombok.Data;

@Data
public class SysRoleResource extends BaseEntity {

    private Long id;

    private String sysRoleUid;

    private String sysResourceUid;

    private String createTime;

    private String createEmp;

    private String updateTime;

    private String updateEmp;

    private static final long serialVersionUID = 1L;

}