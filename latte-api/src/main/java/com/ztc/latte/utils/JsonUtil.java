package com.ztc.latte.utils;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

    /**
     * 对象转json
     *
     * @param object
     * @return
     */
    public static String objectToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * json转对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

}
