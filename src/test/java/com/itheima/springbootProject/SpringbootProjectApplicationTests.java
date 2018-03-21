package com.itheima.springbootProject;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.springbootProject.mapper.UserMapper;
import com.itheima.springbootProject.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProjectApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		User user = userMapper.selectUserById(10);
		System.out.println(user);
	}
	@Test
	public void contextPageHelper() {
		//首先需要先开始分页  紧跟着的第一个查询才会被分页
		//后续不能有查询,不然count(*)会省略掉
		//pageNUm是当前页,pageSize是没页显示数据条数
		PageHelper.startPage(1,2);
		List<User> list = userMapper.selectUserAll();
		Page<User> page= (Page<User>) list;
		System.out.println("总记录数:"+page.getTotal());
		System.out.println("总页数:"+page.getPages());
		System.out.println("1查询的结果的条数"+list.size());
		List<User> list2 = userMapper.selectUserAll();
		System.out.println("2查询的结果的条数"+list2.size());
	}
	@Test
	public  void  commonmapperTest(){
		//查询的条件
		User user = new User();
		user.setId(10);
		user.setSex("1");
		List<User> userList = userMapper.select(user);
		User user1 = userMapper.selectOne(user);
		System.out.println(user1);
		System.out.println(userList);

	}
}
