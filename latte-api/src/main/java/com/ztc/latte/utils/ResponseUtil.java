package com.ztc.latte.utils;

import com.ztc.latte.base.BaseResponse;
import com.ztc.latte.enums.SystemMsg;
import com.ztc.latte.exception.BusinessExceptions;
import com.ztc.latte.exception.SystemExceptions;

public class ResponseUtil<T> {

    public static <T> BaseResponse<T> createDefaultResponse(String reqId) {
        BaseResponse<T> resp = new BaseResponse<>();
        resp.setReqId(reqId);
        resp.setCode(SystemMsg.SUCCESS.getCode());
        resp.setMsg(SystemMsg.SUCCESS.getMsg());
        return resp;
    }

    public static <T> void success(BaseResponse<T> baseResponse, T t) {
        baseResponse.setData(t);
    }

    private static <T> void businessException(BaseResponse<T> baseResponse, BusinessExceptions e) {
        baseResponse.setCode(e.getCode());
        baseResponse.setMsg(e.getMessage());
    }

    private static <T> void systemException(BaseResponse<T> baseResponse, SystemExceptions e) {
        baseResponse.setCode(e.getCode());
        baseResponse.setMsg(e.getMessage());
    }

    public static <T> void exception(BaseResponse<T> baseResponse) {
        baseResponse.setCode(SystemMsg.ERROR.getCode());
        baseResponse.setMsg(SystemMsg.ERROR.getMsg());
    }

    public static <T> void handleException(BaseResponse<T> baseResponse, Exception e) {
        if (e instanceof BusinessExceptions) {
            businessException(baseResponse, (BusinessExceptions) e);
        } else if (e instanceof SystemExceptions) {
            systemException(baseResponse, (SystemExceptions) e);
        } else {
            exception(baseResponse);
        }
    }
}
