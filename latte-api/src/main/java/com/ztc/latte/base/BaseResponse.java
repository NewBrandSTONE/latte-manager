package com.ztc.latte.base;

import lombok.Data;

@Data
public class BaseResponse<T> extends BaseEntity {

    private String reqId;
    private String code;
    private String msg;
    private T data;

}
