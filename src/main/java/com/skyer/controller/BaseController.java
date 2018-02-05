package com.skyer.controller;

import com.skyer.enumerate.ResultEnum;
import com.skyer.util.ResultInfo;

/**
 * 基类Controller
 * 
 * @author Zongqian
 */
public abstract class BaseController {

	/**
	 * 请求成功
	 * 
	 * @param data 请求成功返回的内容
	 * @return
	 */
	public Object success(Object data) {
		ResultInfo<Object> resultInfo = new ResultInfo<Object>();
		resultInfo.setCode(ResultEnum.SUCCESS.getCode());
		resultInfo.setData(data);
		return resultInfo;
	}

	/**
	 * 请求失败
	 * 
	 * @param msg 失败信息
	 * @return
	 */
	public Object fail(int code, String msg) {
		ResultInfo<Object> resultInfo = new ResultInfo<Object>();
		resultInfo.setCode(code);
		resultInfo.setData(msg);
		return resultInfo;
	}

}
