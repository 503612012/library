package com.skyer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyer.mapper.BookMapper;
import com.skyer.vo.Book;

/**
 * 图书服务层
 * 
 * @author Zongqian
 */
@Service
public class BookService {

	@Autowired
	private BookMapper bookMapper;

	/**
	 * 查询所有图书
	 */
	public List<Map<String, Object>> findAll() {
		return bookMapper.findAll();
	}

	/**
	 * 添加图书
	 */
	public boolean add(Book book) {
		if (book.getRemark().contains("外借")) {
			book.setStatus("1");
		} else {
			book.setStatus("0");
		}
		return bookMapper.add(book) > 0;
	}

	/**
	 * 通过主键获取
	 */
	public Book findById(String id) {
		return bookMapper.findById(id);
	}

	/**
	 * 获取首页数据信息
	 * @return
	 */
	public List<Map<String, Object>> getNumberInfo() {
		return bookMapper.getNumberInfo();
	}

}
