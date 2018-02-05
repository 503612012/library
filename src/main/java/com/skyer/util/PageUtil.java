package com.skyer.util;

/**
 * 分页工具类
 * 
 * @author Zongqian
 */
public class PageUtil {

	private int pageNum; // 当前页码
	private int pageSize; // 每页显示数量
	private int index; // 查询起始索引

	public PageUtil() {
		super();
	}

	public PageUtil(int pageNum, int pageSize) {
		this.pageSize = pageSize;
		this.index = (pageNum - 1) * pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
