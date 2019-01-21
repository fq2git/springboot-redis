package com.fq2git.redis.service.impl;

import com.fq2git.redis.dao.UserDao;
import com.fq2git.redis.entity.UserEntity;
import com.fq2git.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public UserEntity finById(Long id) {
        return userDao.findById(id);
    }

}
