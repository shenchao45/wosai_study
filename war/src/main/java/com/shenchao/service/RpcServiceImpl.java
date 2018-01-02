package com.shenchao.service;

import com.shenchao.common.log.ServiceAnnotation;
import com.shenchao.util.CollectionUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@ServiceAnnotation
public class RpcServiceImpl implements RpcService{

    @Override
    public Map sayHi(String hello) {
        System.out.println(hello);
        return CollectionUtil.hashMap("result", hello);
    }
}