/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.plugins.entity;

/**
 *                       
 * @Filename ResourceConfig.java
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
 *<li>Date: 2012-7-30</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ResourceConfig {
	
	public String	javaPath;
	public String	resourcePath;
	public String	packageName;
	public String	entityPackage;
	public String	daoPackage;
	public String	mapperPackage;
	public String	author;
	
	/**
	 * @return Returns the javaPath
	 */
	public String getJavaPath() {
		return javaPath;
	}
	
	/**
	 * @param javaPath
	 * The javaPath to set.
	 */
	public void setJavaPath(String javaPath) {
		this.javaPath = javaPath;
	}
	
	/**
	 * @return Returns the resourcePath
	 */
	public String getResourcePath() {
		return resourcePath;
	}
	
	/**
	 * @param resourcePath
	 * The resourcePath to set.
	 */
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	
	/**
	 * @return Returns the packageName
	 */
	public String getPackageName() {
		return packageName;
	}
	
	/**
	 * @param packageName
	 * The packageName to set.
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	/**
	 * @return Returns the entityPackage
	 */
	public String getEntityPackage() {
		return entityPackage;
	}
	
	/**
	 * @param entityPackage
	 * The entityPackage to set.
	 */
	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}
	
	/**
	 * @return Returns the daoPackage
	 */
	public String getDaoPackage() {
		return daoPackage;
	}
	
	/**
	 * @param daoPackage
	 * The daoPackage to set.
	 */
	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}
	
	/**
	 * @return Returns the mapperPackage
	 */
	public String getMapperPackage() {
		return mapperPackage;
	}
	
	/**
	 * @param mapperPackage
	 * The mapperPackage to set.
	 */
	public void setMapperPackage(String mapperPackage) {
		this.mapperPackage = mapperPackage;
	}
	
	/**
	 * @return Returns the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @param author
	 * The author to set.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResourceConfig [javaPath=" + javaPath + ", resourcePath=" + resourcePath
				+ ", packageName=" + packageName + ", entityPackage=" + entityPackage
				+ ", daoPackage=" + daoPackage + ", mapperPackage=" + mapperPackage + ", author="
				+ author + "]";
	}
	
}
