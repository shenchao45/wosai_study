package com.shenchao.helper;

/**
 * Created by shenchao on 17/12/13.
 */

import com.fasterxml.jackson.core.JsonGenerator;
import net.logstash.logback.decorate.JsonGeneratorDecorator;

public class NonEscapingJsonGeneratorDecorator implements JsonGeneratorDecorator {

    @Override
    public JsonGenerator decorate(JsonGenerator generator) {
        // 取消对非ASCII字符的转码
        return generator.disable(JsonGenerator.Feature.ESCAPE_NON_ASCII);
    }
}