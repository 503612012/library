package com.skyer.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyer.enumerate.ResultEnum;
import com.skyer.service.BookTypeService;
import com.skyer.vo.BookType;

/**
 * 图书类别控制器
 * 
 * @author Zongqian
 */
@Controller
@RequestMapping("/bookType")
public class BookTypeController extends BaseController {

	private final static Logger L = Logger.getLogger(BookTypeController.class);

	@Autowired
	private BookTypeService bookTypeService;

	/**
	 * 查询所有图书类别
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	@ResponseBody
	public Object findAll() {
		try {
			List<BookType> list = bookTypeService.findAll();
			return super.success(list);
		} catch (Exception e) {
			L.error("--------------------------", e);
			e.printStackTrace();
		}
		return super.fail(ResultEnum.SEARCH_ERROR.getCode(), ResultEnum.SEARCH_ERROR.getValue());
	}

}
