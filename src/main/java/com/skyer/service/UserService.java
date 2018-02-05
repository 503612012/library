package com.skyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyer.mapper.UserMapper;
import com.skyer.vo.User;

/**
 * 用户服务层
 * 
 * @author Zongqian
 */
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 通过用户名查找
	 */
	public User findByUserName(String userName) {
		return userMapper.findByUserName(userName);
	}

}
