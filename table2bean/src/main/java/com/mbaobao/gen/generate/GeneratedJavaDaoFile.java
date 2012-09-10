/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.generate;

import java.io.File;

import org.apache.velocity.VelocityContext;

import com.mbaobao.gen.ConfigurationContext;
import com.mbaobao.gen.entity.JavaBean;
import com.mbaobao.gen.util.JavaBeansUtil;

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
	public String getFileTempateName() {
		return TEMPLATE_NAME;
	}
	
	@Override
	public void setContextData(VelocityContext velocityContext, JavaBean bean) {
		velocityContext.put("java", bean);
		
		velocityContext.put("fieldName",
			JavaBeansUtil.getCamelCaseString(bean.getClassName(), false));
	}
	
	@Override
	public String getFileExportPath(ConfigurationContext configContext, JavaBean bean) {
		String path = configContext.getJavaDaoConfiguration().getTargetProject();
		String _package = configContext.getJavaDaoConfiguration().getTargetPackage()
			.replaceAll("\\.", File.separator);
		return String.format("%s%s%s%s", path, File.separator, _package, File.separator);
	}
	
	@Override
	public String getFileExportFileName(JavaBean bean) {
		return bean.getClassName() + "Dao.java";
	}
	
}
