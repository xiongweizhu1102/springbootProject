package com.itheima.springbootProject.mapper;

import com.itheima.springbootProject.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author bear
 * @version 1.0
 * @description com.itheima.springbootProject.mapper
 * @date 2018/3/20
 */
//@Mapper 此地是mybatis的mapper注解形成映射关系
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
    @Select("select * from user")
    List<User> selectUserAll();
    @Select("select * from user where id=#{id}")//select语句
    User selectUserById(Integer id);
}
