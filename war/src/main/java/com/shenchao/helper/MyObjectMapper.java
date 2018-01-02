package com.shenchao.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyObjectMapper extends ObjectMapper{
    public MyObjectMapper() {
        super();
        // 序列化输出不包含null的属性
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 反序列化时忽略未知属性
        this.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
}
