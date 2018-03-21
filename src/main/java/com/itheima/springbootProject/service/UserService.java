package com.itheima.springbootProject.service;

import com.itheima.springbootProject.pojo.User;

import java.util.List;

/**
 * @author bear
 * @version 1.0
 * @description com.itheima.springbootProject.service
 * @date 2018/3/20
 */
public interface UserService {
    public List<User> selectUserAll();
}
