/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.entity;

import java.io.Serializable;

/**
 *                       
 * @Filename TableColumn.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author fred
 *
 * @Email kuci@mbaobao.com
 *       
 * @History
 *<li>Author: fred</li>
 *<li>Date: 2012-7-21</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class TableColumn implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 1097875736357252131L;
	
	private String				name;
	
	private TableColumnEnum		columnType;
	
	private Integer				length;
	
	private Boolean				notNull				= true;
	
	/**
	 * 构建一个<code>TableColumn.java</code>
	 * @param name
	 * @param columnType
	 * @param length
	 */
	public TableColumn(String name, TableColumnEnum columnType, Integer length) {
		super();
		this.name = name;
		this.columnType = columnType;
		this.length = length;
		this.notNull = true;
	}
	
	/**
	 * 构建一个<code>TableColumn.java</code>
	 * @param name
	 * @param columnType
	 * @param length
	 * @param notNull
	 */
	public TableColumn(String name, TableColumnEnum columnType, Integer length, Boolean notNull) {
		super();
		this.name = name;
		this.columnType = columnType;
		this.length = length;
		this.notNull = notNull;
	}
	
	/**
	 * @return Returns the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 * The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return Returns the columnType
	 */
	public TableColumnEnum getColumnType() {
		return columnType;
	}
	
	/**
	 * @param columnType
	 * The columnType to set.
	 */
	public void setColumnType(TableColumnEnum columnType) {
		this.columnType = columnType;
	}
	
	/**
	 * @return Returns the length
	 */
	public Integer getLength() {
		return length;
	}
	
	/**
	 * @param length
	 * The length to set.
	 */
	public void setLength(Integer length) {
		this.length = length;
	}
	
	/**
	 * @return Returns the notNull
	 */
	public Boolean getNotNull() {
		return notNull;
	}
	
	/**
	 * @param notNull
	 * The notNull to set.
	 */
	public void setNotNull(Boolean notNull) {
		this.notNull = notNull;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TableColumn [name=" + name + ", columnType=" + columnType + ", length=" + length
				+ ", notNull=" + notNull + "]";
	}
	
}
