/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename Table.java
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
 *<li>Date: 2012-7-20</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class Table implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 3118228418172380025L;
	
	private String				name;
	
	private List<TableColumn>	columns				= new ArrayList<TableColumn>();
	
	/**
	 * 构建一个<code>Table.java</code>
	 * @param name
	 */
	public Table(String name) {
		super();
		this.name = name;
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
	 * @return Returns the columns
	 */
	public List<TableColumn> getColumns() {
		return columns;
	}
	
	/**
	 * @param columns
	 * The columns to set.
	 */
	public void setColumns(List<TableColumn> columns) {
		this.columns = columns;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Table [name=" + name + ", columns=" + columns + "]";
	}
	
}
