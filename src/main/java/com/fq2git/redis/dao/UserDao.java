package com.fq2git.redis.dao;

import com.fq2git.redis.entity.UserEntity;

/**
 * userDao 接口
 */
public interface UserDao {
     UserEntity findById(Long id);

}
