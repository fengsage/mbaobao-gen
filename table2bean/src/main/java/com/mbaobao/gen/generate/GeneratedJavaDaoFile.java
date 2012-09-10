/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.generate;

import org.apache.velocity.VelocityContext;

import com.mbaobao.gen.entity.JavaBean;

/**
 *                       
 * @Filename GeneratedJavaFile.java
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
public class GeneratedJavaDaoFile extends GeneratedFile {
	
	private static final String	TEMPLATE_NAME	= "dao.vm";
	
	@Override
	public String genFileTempateName() {
		return TEMPLATE_NAME;
	}
	
	@Override
	public void setContextData(VelocityContext velocityContext, JavaBean bean) {
	}
	
}
