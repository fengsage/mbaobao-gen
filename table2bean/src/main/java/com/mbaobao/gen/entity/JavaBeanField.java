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
public class JavaBeanField implements Serializable {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 3875901248873063954L;
	
	private String				name;
	
	private String				columnName;
	
	private String				typeName;
	
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
	 * @return Returns the typeName
	 */
	public String getTypeName() {
		return typeName;
	}
	
	/**
	 * @param typeName
	 * The typeName to set.
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JavaBeanField [name=" + name + ", columnName=" + columnName + ", typeName="
				+ typeName + ", setMethodName=" + setMethodName + ", getMethodName="
				+ getMethodName + "]";
	}
	
}
