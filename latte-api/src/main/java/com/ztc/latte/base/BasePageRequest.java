package com.ztc.latte.base;

import lombok.Data;

@Data
public class BasePageRequest extends BaseEntity {

    private Integer page = 1;
    private Integer pageSize = 10;

}
