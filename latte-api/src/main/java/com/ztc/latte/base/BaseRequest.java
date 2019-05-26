package com.ztc.latte.base;

import lombok.Data;

@Data
public class BaseRequest<T> extends BaseEntity {

    private String reqId;
    private T data;
    private String userId;
    private String token;
    private String sign;

}
