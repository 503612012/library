package com.skyer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyer.mapper.BookTypeMapper;
import com.skyer.vo.BookType;

/**
 * 图书类别服务层
 * 
 * @author Zongqian
 */
@Service
public class BookTypeService {

	@Autowired
	private BookTypeMapper bookTypeMapper;

	/**
	 * 查询所有图书类别
	 */
	public List<BookType> findAll() {
		return bookTypeMapper.findAll();
	}

}
