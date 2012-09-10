/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.entity;

import java.io.Serializable;

/**
 *                       
 * @Filename JavaBeanField.java
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
 *<li>Date: 2012-7-22</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
@SuppressWarnings("rawtypes")
public class JavaBeanField implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 3875901248873063954L;
	
	/**属性名*/
	private String				name;
	
	/**属性类型*/
	private Class				clsName;
	
	/**数据库字段*/
	private TableColumn			tableColumn;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Class getClsName() {
		return clsName;
	}
	
	public void setClsName(Class clsName) {
		this.clsName = clsName;
	}
	
	public TableColumn getTableColumn() {
		return tableColumn;
	}
	
	public void setTableColumn(TableColumn tableColumn) {
		this.tableColumn = tableColumn;
	}
	
	@Override
	public String toString() {
		return String.format("JavaBeanField [name=%s, clsName=%s, tableColumn=%s]", name, clsName,
			tableColumn);
	}
	
}
