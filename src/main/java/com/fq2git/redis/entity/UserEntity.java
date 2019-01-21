package com.fq2git.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 无参构造
 * 有参构造(id,name)
 * Data
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity implements Serializable {
    private Long id;
    private String name;
}
