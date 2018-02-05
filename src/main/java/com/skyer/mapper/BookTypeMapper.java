package com.skyer.mapper;

import java.util.List;

import com.skyer.vo.BookType;

/**
 * BookTypeMapper接口
 * 
 * @author Zongqian
 */
public interface BookTypeMapper {

	/**
	 * 查询所有图书类别
	 */
	public List<BookType> findAll();

	/**
	 * 通过主键查询
	 */
	public BookType findById(int id);

}
