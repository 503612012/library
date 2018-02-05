package com.skyer.util;

/**
 * 自定义返回类
 * 
 * @author Zongqian
 */
public class ResultInfo<T> {

	private int code; // 返回代码(200:成功,500:失败)
	private T data; // 返回的数据,正确的信息或错误描述信息

	public ResultInfo() {
		super();
	}

	public ResultInfo(int code, T data) {
		super();
		this.code = code;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public ResultInfo<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResultInfo<T> setData(T data) {
		this.data = data;
		return this;
	}

}
