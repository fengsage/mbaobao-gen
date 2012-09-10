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
 * @Filename JavaBean.java
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
public class JavaBean implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 510402812424422194L;
	
	private String				className;
	
	private List<JavaBeanField>	fields				= new ArrayList<JavaBeanField>();
	
	private Table				table;
	
	/**
	 * 构建一个<code>JavaBean.java</code>
	 * @param className
	 */
	public JavaBean(String className) {
		super();
		this.className = className;
	}
	
	/**
	 * 构建一个<code>JavaBean.java</code>
	 */
	public JavaBean() {
		super();
	}
	
	/**
	 * @return Returns the className
	 */
	public String getClassName() {
		return className;
	}
	
	/**buildJavaBeanFiled
	 * @param className
	 * The className to set.
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	
	/**
	 * @return Returns the fields
	 */
	public List<JavaBeanField> getFields() {
		return fields;
	}
	
	/**
	 * @param fields
	 * The fields to set.
	 */
	public void setFields(List<JavaBeanField> fields) {
		this.fields = fields;
	}
	
	/**
	 * @return Returns the table
	 */
	public Table getTable() {
		return table;
	}
	
	/**
	 * @param table
	 * The table to set.
	 */
	public void setTable(Table table) {
		this.table = table;
	}
	
	@Override
	public String toString() {
		return String.format("JavaBean [className=%s, fields=%s, table=%s]", className, fields,
			table);
	}
	
}
