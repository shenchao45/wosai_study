package com.shenchao.common.log;

import java.lang.annotation.*;

/**
 * 使用在接口定义上，注解作用：拦截Service方法.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceAnnotation {

}
