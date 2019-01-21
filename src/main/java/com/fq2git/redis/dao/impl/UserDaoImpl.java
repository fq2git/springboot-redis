package com.fq2git.redis.dao.impl;

import com.fq2git.redis.dao.UserDao;
import com.fq2git.redis.entity.UserEntity;
import com.fq2git.redis.rowmapper.UserRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * UserDao 接口实现类
 */
@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public UserEntity findById(Long id) {

        String sql = "SELECT id,name FROM t_user WHERE id="+id;

        UserEntity userEntity = jdbcTemplate.queryForObject(sql,new UserRowMapper());

        log.info(String.format("查询了数据库--%s",sql));

        return userEntity;
    }

}
