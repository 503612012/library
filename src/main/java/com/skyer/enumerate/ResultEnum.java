package com.skyer.enumerate;

/**
 * 自定义枚举
 * 
 * @author Zongqian
 */
public enum ResultEnum {

	SUCCESS(200, "success"), 
	SEARCH_ERROR(300, "查询失败！"), 
	HANDLE_ERROR(301, "操作失败！"),
	NO_THIS_USER(302, "查无此人！"),
	PASSWORD_WRONG(303, "密码错误！");

	private int code;
	private String value;

	private ResultEnum(int code, String value) {
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
