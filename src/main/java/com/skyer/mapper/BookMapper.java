package com.skyer.mapper;

import java.util.List;
import java.util.Map;

import com.skyer.vo.Book;

/**
 * BookMapper接口
 * 
 * @author Zongqian
 */
public interface BookMapper {

	/**
	 * 查询所有图书
	 */
	public List<Map<String, Object>> findAll();

	/**
	 * 添加图书
	 */
	public int add(Book book);

	/**
	 * 通过主键获取
	 */
	public Book findById(String id);

	/**
	 * 获取首页数据信息
	 */
	public List<Map<String, Object>> getNumberInfo();

}
