package com.fq2git.redis.service;

import com.fq2git.redis.entity.UserEntity;

public interface UserService {

    /**
     * 根据id获取单个
     * @param id
     * @return
     */
    UserEntity finById(Long id);

}
