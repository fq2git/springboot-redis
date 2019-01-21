package com.fq2git.redis.rowmapper;

import com.fq2git.redis.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity>,Serializable {

    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getLong("id"));
        userEntity.setName(resultSet.getString("name"));
        return userEntity;
    }
}
