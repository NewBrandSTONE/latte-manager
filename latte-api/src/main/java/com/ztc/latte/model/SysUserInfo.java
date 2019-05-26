package com.ztc.latte.model;

import com.ztc.latte.base.BaseEntity;
import lombok.Data;

@Data
public class SysUserInfo extends BaseEntity {

    private Long id;

    private String sysUserUid;

    private String sysUsername;

    private String sysPwd;

    private String sysName;

    private String sysBirth;

    private String sysSex;

    private String sysCertType;

    private String sysCertVal;

    private String sysUserProv;

    private String sysProvName;

    private String sysUserCity;

    private String sysCityName;

    private String sysUserImg;

    private Integer sysImgCount;

    private String createTime;

    private String createEmp;

    private String updateTime;

    private String updateEmp;

    private Byte isDelete;

    private static final long serialVersionUID = 1L;

}