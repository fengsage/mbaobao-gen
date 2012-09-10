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
	
	public Table() {
		super();
	}
	
	public Table(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<TableColumn> getColumns() {
		return columns;
	}
	
	public void setColumns(List<TableColumn> columns) {
		this.columns = columns;
	}
	
	@Override
	public String toString() {
		return "Table [name=" + name + ", columns=" + columns + "]";
	}
	
}
