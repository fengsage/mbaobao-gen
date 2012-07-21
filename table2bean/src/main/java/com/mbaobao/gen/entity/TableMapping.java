/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.entity;

import java.io.Serializable;

/**
 *                       
 * @Filename TableMapping.java
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
public class TableMapping implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 8329192356402408979L;
	
	private String				tableName;
	
	private String				javaName;
	
	/**
	 * 构建一个<code>TableMapping.java</code>
	 * @param tableName
	 * @param javaName
	 */
	public TableMapping(String tableName, String javaName) {
		super();
		this.tableName = tableName;
		this.javaName = javaName;
	}
	
	/**
	 * @return Returns the tableName
	 */
	public String getTableName() {
		return tableName;
	}
	
	/**
	 * @param tableName
	 * The tableName to set.
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * @return Returns the javaName
	 */
	public String getJavaName() {
		return javaName;
	}
	
	/**
	 * @param javaName
	 * The javaName to set.
	 */
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TableMapping [tableName=" + tableName + ", javaName=" + javaName + "]";
	}
	
}
