package com.skyer.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyer.enumerate.ResultEnum;
import com.skyer.service.BookService;
import com.skyer.service.UserService;
import com.skyer.util.MD5Util;
import com.skyer.vo.User;

/**
 * 用户控制器
 * 
 * @author Zongqian
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private final static Logger L = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;

	/**
	 * 登录操作
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Object login(User user, HttpServletRequest req) {
		try {
			User u = userService.findByUserName(user.getUserName());
			if (u == null) {
				return super.fail(ResultEnum.NO_THIS_USER.getCode(), ResultEnum.NO_THIS_USER.getValue());
			}
			boolean flag = MD5Util.validPassword(user.getPassword(), u.getPassword());
			if (flag) {
				req.getSession().setAttribute("user", u);
				List<Map<String, Object>> list = bookService.getNumberInfo();
				req.getSession().setAttribute("list", list);
				return super.success("登录成功！");
			}
			return super.fail(ResultEnum.PASSWORD_WRONG.getCode(), ResultEnum.PASSWORD_WRONG.getValue());
		} catch (Exception e) {
			L.error("--------------------------", e);
			e.printStackTrace();
		}
		return super.fail(ResultEnum.SEARCH_ERROR.getCode(), ResultEnum.SEARCH_ERROR.getValue());
	}

	/**
	 * 登出操作
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	@ResponseBody
	public Object logout(HttpServletRequest req) {
		try {
			req.getSession().removeAttribute("user");
			return super.success("登出成功！");
		} catch (Exception e) {
			L.error("--------------------------", e);
			e.printStackTrace();
		}
		return super.fail(ResultEnum.HANDLE_ERROR.getCode(), ResultEnum.HANDLE_ERROR.getValue());
	}

}
