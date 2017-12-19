package com.shenchao.service;

import com.shenchao.entity.User;

import java.util.List;

/**
 * Created by shenchao on 17/12/12.
 */
public interface UserService {
    void addUser(User user);

    void deleteUser(User user);

    List<User> findAll();

    void testException();
}
