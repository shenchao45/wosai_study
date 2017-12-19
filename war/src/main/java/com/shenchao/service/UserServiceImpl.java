package com.shenchao.service;

import com.shenchao.entity.User;
import com.shenchao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by shenchao on 17/12/12.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void testException() {
        User user = new User();
        user.setPassword("22222");
        user.setUsername("aaaa");
        userRepository.save(user);
        if (true) {
            throw new RuntimeException("测试异常");
        }
        User user1 = new User();
        user1.setPassword("22222333");
        user1.setUsername("aaaa");
        userRepository.save(user1);
    }
}
