package com.ztc.latte.enums;

import com.ztc.latte.exception.IErrorMsg;

/**
 * 定义系统错误代码和原因
 */
public enum SystemMsg implements IErrorMsg {

    SUCCESS("0", "SUCCESS"),
    ERROR("9999", "ERROR");

    private String code;
    private String msg;

    SystemMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
