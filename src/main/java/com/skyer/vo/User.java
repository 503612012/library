package com.skyer.vo;

/**
 * 用户实体类
 * 
 * @author Zongqian
 */
public class User {

	private int id; // 主键
	private String userName; // 用户名
	private String password; // 密码
	private String createTime; // 创建时间
	private String status; // 状态(0可用,1禁用)
	private String isAdmin; // 管理权限(0管理员,1普通用户)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

}
