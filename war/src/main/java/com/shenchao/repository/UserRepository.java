package com.shenchao.repository;

import com.shenchao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shenchao on 17/12/12.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
