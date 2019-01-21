package com.fq2git.redis;

import com.fq2git.redis.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootRedisApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object,UserEntity> userEntityRedisTemplate;


    @Test
    public void contextLoads() {
        //添加个字符串
        stringRedisTemplate.opsForValue().append("msg","redis测试字符串");
        //获取这个key对应的字符串
        String string = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(String.format("msg=:%s",string));
        //存放一个list
        stringRedisTemplate.opsForList().leftPush("mylist","1");
        stringRedisTemplate.opsForList().leftPush("mylist","2");
        stringRedisTemplate.opsForList().leftPush("mylist","3");
    }

    @Test
    public void test02(){
        UserEntity user = new UserEntity(1L,"顾小刚");
        userEntityRedisTemplate.opsForValue().set("uesr-20190121",user);
        UserEntity user1 = new UserEntity(1L,"顾小刚");
        UserEntity user2 = new UserEntity(2L,"方强");
        UserEntity user3 = new UserEntity(3L,"向总");
        UserEntity user4 = new UserEntity(4L,"王飞飞");
        List<UserEntity> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        //从左push list
        userEntityRedisTemplate.opsForList().leftPushAll("userlist",users);

        //获取前三个
        List<UserEntity> userslist = userEntityRedisTemplate.opsForList().range("userlist",0,3);
        for(UserEntity u:userslist){
            log.info("user{}",u);
        }

        //实体要有无参构造方法，不然就是坑。
        UserEntity userData = userEntityRedisTemplate.opsForValue().get("uesr-20190121");
        log.info("user{}",userData);
    }

}

