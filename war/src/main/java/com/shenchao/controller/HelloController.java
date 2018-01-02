package com.shenchao.controller;

import com.shenchao.entity.User;
import com.shenchao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by shenchao on 17/12/12.
 */
@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/helloworld")
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/saveUser", produces = "application/json; charset=UTF-8")
    public User saveUser(User user) throws SQLException {
        userService.addUser(user);
        return user;
    }

    @GetMapping(value = "/findAll",produces = "application/json;charset=UTF-8")
    public List<User> findAll(){
        return userService.findAll();
    }


    @GetMapping(value = "/testException",produces = "text/html;charset=UTF-8")
    public String testException(){
        userService.testException();
        return "ok";
    }

    @GetMapping("/aaaa")
    public Object test(){
        return "hello";
    }

    @GetMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser(){
        return userService.findAll();
    }
}
