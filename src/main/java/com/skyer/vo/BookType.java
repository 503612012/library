package com.skyer.vo;

/**
 * 图书类别实体类
 * 
 * @author Zongqian
 */
public class BookType {

	private int id; // 主键
	private String typeName; // 类别名称
	private String status; // 状态(0可用,1禁用)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
