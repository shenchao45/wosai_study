package com.shenchao.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import test.bean.Bean1;

@ContextConfiguration(locations = {"classpath:spring/spring-test.xml"})
public class TestSpring extends AbstractTestNGSpringContextTests {
    @Autowired
    private Bean1 bean1;

    @Test
    public void testName() throws Exception {
        bean1.say();
    }
}
