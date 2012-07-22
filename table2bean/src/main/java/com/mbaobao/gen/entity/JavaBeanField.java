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
	
	private String				name;
	
	private String				columnName;
	
	private Class				clsName;
	
	private String				setMethodName;
	
	private String				getMethodName;
	
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
	 * @return Returns the setMethodName
	 */
	public String getSetMethodName() {
		return setMethodName;
	}
	
	/**
	 * @param setMethodName
	 * The setMethodName to set.
	 */
	public void setSetMethodName(String setMethodName) {
		this.setMethodName = setMethodName;
	}
	
	/**
	 * @return Returns the getMethodName
	 */
	public String getGetMethodName() {
		return getMethodName;
	}
	
	/**
	 * @param getMethodName
	 * The getMethodName to set.
	 */
	public void setGetMethodName(String getMethodName) {
		this.getMethodName = getMethodName;
	}
	
	/**
	 * @return Returns the columnName
	 */
	public String getColumnName() {
		return columnName;
	}
	
	/**
	 * @param columnName
	 * The columnName to set.
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	/**
	 * @return Returns the clsName
	 */
	public Class getClsName() {
		return clsName;
	}
	
	/**
	 * @param clsName
	 * The clsName to set.
	 */
	public void setClsName(Class clsName) {
		this.clsName = clsName;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JavaBeanField [name=" + name + ", columnName=" + columnName + ", clsName="
				+ clsName + ", setMethodName=" + setMethodName + ", getMethodName=" + getMethodName
				+ "]";
	}
	
}
