/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.configuration;

/**
 *                       
 * @Filename JavaDaoConfiguration.java
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
public class JavaDaoConfiguration {
	
	private String	targetPackage;
	
	private String	targetProject;
	
	public String getTargetPackage() {
		return targetPackage;
	}
	
	public void setTargetPackage(String targetPackage) {
		this.targetPackage = targetPackage;
	}
	
	public String getTargetProject() {
		return targetProject;
	}
	
	public void setTargetProject(String targetProject) {
		this.targetProject = targetProject;
	}
	
	@Override
	public String toString() {
		return "JavaDaoConfiguration [targetPackage=" + targetPackage + ", targetProject="
				+ targetProject + "]";
	}
	
}
