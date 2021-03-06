package com.ztc.latte.exception;

import com.ztc.latte.base.BaseException;

public class SystemExceptions extends BaseException {

    private String code;
    private String msg;

    public SystemExceptions(String message) {
        super(message);
        this.msg = message;
    }

    public SystemExceptions(IErrorMsg errorMsg) {
        super(errorMsg.getCode());
        this.code = errorMsg.getCode();
        this.msg = errorMsg.getMsg();
    }

    public SystemExceptions(String message, String code) {
        super(message);
        this.msg = message;
        this.code = code;
    }

    public SystemExceptions(String message, Throwable throwable) {
        super(message);
        this.msg = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
