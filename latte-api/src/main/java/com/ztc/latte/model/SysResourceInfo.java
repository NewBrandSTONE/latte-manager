package com.ztc.latte.model;

import com.ztc.latte.base.BaseEntity;
import lombok.Data;

@Data
public class SysResourceInfo extends BaseEntity {

    private Long id;

    private String sysResourceUid;

    private String sysResourceName;

    private Integer sysResourceLevel;

    private String sysResourcePath;

    private String sysParentUid;

    private String createTime;

    private String createEmp;

    private String updateTime;

    private String updateEmp;

    private Byte isDelete;

    private static final long serialVersionUID = 1L;

}