package com.shenchao.test;

import org.testng.annotations.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectDemo {

    @Test
    public void testReflect(){
        new Child();
    }
}


abstract class Parent<T>{
    Class<T> clazz;


    public Parent() {
        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
//        clazz = (Class<T>) parameterizedType.getActualTypeArguments()[0];
//        parameterizedType.getRawType()
        Type rawType = parameterizedType.getRawType();
        System.out.println(rawType);
    }
}

class Demo{

}

class Child extends Parent<Demo>{

}
