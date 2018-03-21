package com.itheima.springbootProject.service.impl;

import com.itheima.springbootProject.mapper.UserMapper;
import com.itheima.springbootProject.pojo.User;
import com.itheima.springbootProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bear
 * @version 1.0
 * @description com.itheima.springbootProject.service.impl
 * @date 2018/3/20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
  //  @Cacheable(value = "userCache",key="'userKey'")
   // key:userCache+"框架生成的一些随机数"+userKey
    @Override
    public List<User> selectUserAll() {
        System.out.println("缓存了");
        redisTemplate.boundValueOps("hello").set("haha");
        System.out.println(redisTemplate.boundValueOps("hello").get());
        return userMapper.selectUserAll();
    }
}
