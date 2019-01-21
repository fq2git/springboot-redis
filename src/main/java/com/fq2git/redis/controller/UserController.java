package com.fq2git.redis.controller;

import com.fq2git.redis.entity.UserEntity;
import com.fq2git.redis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"人员接口"})
@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate<Object,UserEntity> redisTemplate;

    @ApiOperation(value = "根据id获取一个人员对象")
    @GetMapping("/{id}")
    public UserEntity findById(@PathVariable("id") Long id){
        UserEntity userEntity;
        if(redisTemplate.opsForValue().get("finbyid_"+id) != null){
            userEntity = redisTemplate.opsForValue().get("finbyid_"+id);
            return userEntity;
        }
        userEntity = userService.finById(id);
        //获取到后放到缓存中 更新，删除
        if(userEntity != null){
            redisTemplate.opsForValue().set("finbyid_"+id,userEntity);
        }
        return userEntity;
    }
}
