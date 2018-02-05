package com.skyer.mapper;

import com.skyer.vo.User;

/**
 * UserMapper接口
 * 
 * @author Zongqian
 */
public interface UserMapper {

	/**
	 * 通过用户名查找
	 */
	public User findByUserName(String userName);

}
