/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.generate;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;

import com.mbaobao.gen.ConfigurationContext;
import com.mbaobao.gen.entity.JavaBean;
import com.mbaobao.gen.entity.JavaBeanField;

/**
 *                       
 * @Filename GeneratedXmlFile.java
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
public class GeneratedXmlFile extends GeneratedFile {
	
	private static final String	TEMPLATE_NAME	= "sqlmapper.vm";
	
	@Override
	public String getFileTempateName() {
		return TEMPLATE_NAME;
	}
	
	@Override
	public void setContextData(VelocityContext velocityContext, JavaBean bean) {
		List<Map<String, String>> fileds = new ArrayList<Map<String, String>>();
		for (JavaBeanField filed : bean.getFields()) {
			fileds.add(convertJavaBean(filed));
		}
		velocityContext.put("fields", fileds);
		velocityContext.put("java", bean);
	}
	
	@Override
	public String getFileExportPath(ConfigurationContext configContext, JavaBean bean) {
		String path = configContext.getMapperConfiguration().getTargetResource();
		String _package = configContext.getMapperConfiguration().getTargetPackage()
			.replaceAll("\\.", File.separator);
		return String.format("%s%s%s%s", path, File.separator, _package, File.separator);
	}
	
	@Override
	public String getFileExportFileName(JavaBean bean) {
		return bean.getClassName() + "DaoMapper.xml";
	}
	
	private Map<String, String> convertJavaBean(JavaBeanField filed) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", filed.getName());
		map.put("columnName", filed.getTableColumn().getName());
		
		return map;
	}
	
}
