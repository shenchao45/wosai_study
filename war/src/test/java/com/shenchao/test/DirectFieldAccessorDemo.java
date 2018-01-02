package com.shenchao.test;

import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import test.bean.Bean1;

@ContextConfiguration(locations = {"classpath:spring/spring-test.xml"})
public class DirectFieldAccessorDemo extends AbstractTestNGSpringContextTests {
    @Autowired
    public Bean1 bean1;

    @Test
    public void test123(){

        //嵌套设置/访问对象字段数据
        DirectFieldAccessor accessor = new DirectFieldAccessor(bean1);
//如果嵌套对象为null，字段创建
        accessor.setAutoGrowNestedPaths(true);
//设置字段值
        accessor.setPropertyValue("name", "zhangsan");
//读取字段值
        System.out.println(accessor.getPropertyValue("name"));
    }
}
