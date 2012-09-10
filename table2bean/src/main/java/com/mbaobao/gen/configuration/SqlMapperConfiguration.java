/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.configuration;

/**
 *                       
 * @Filename SqlMapperConfiguration.java
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
 *<li>Date: 2012-8-15</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class SqlMapperConfiguration {
	
	private String	targetResource;
	
	private String	targetPackage;
	
	public String getTargetResource() {
		return targetResource;
	}
	
	public void setTargetResource(String targetResource) {
		this.targetResource = targetResource;
	}
	
	public String getTargetPackage() {
		return targetPackage;
	}
	
	public void setTargetPackage(String targetPackage) {
		this.targetPackage = targetPackage;
	}
	
	@Override
	public String toString() {
		return "SqlMapperConfiguration [targetResource=" + targetResource + ", targetPackage="
				+ targetPackage + "]";
	}
	
}
