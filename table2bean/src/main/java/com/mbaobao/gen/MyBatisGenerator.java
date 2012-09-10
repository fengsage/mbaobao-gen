/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.util.List;

import org.apache.log4j.Logger;

import com.mbaobao.gen.entity.JavaBean;
import com.mbaobao.gen.generate.GeneratedFile;
import com.mbaobao.gen.generate.GeneratedJavaDaoFile;
import com.mbaobao.gen.generate.GeneratedJavaEntityFile;
import com.mbaobao.gen.generate.GeneratedXmlFile;

/**
 *                       
 * @Filename MyBatisGenerator.java
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
 *<li>Date: 2012-8-14</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class MyBatisGenerator {
	
	private static final Logger		LOG				= Logger.getLogger(MyBatisGenerator.class);
	
	private ConfigurationContext	context;
	
	private GeneratedFile[]			generateFile	= { new GeneratedJavaDaoFile(),
			new GeneratedJavaEntityFile(), new GeneratedXmlFile() };
	
	public MyBatisGenerator(ConfigurationContext configuration) {
		if (configuration == null) {
			throw new RuntimeException("configuration不能null");
		} else {
			this.context = configuration;
		}
		this.context.validate();
	}
	
	/**
	 * 生成代码
	 */
	public void generate() {
		long _st = System.currentTimeMillis();
		LOG.info("generator init");
		List<JavaBean> javaBeans = new JavaBeanFactory().loadJaveBeans(this.context);
		for (GeneratedFile gen : generateFile) {
			for (JavaBean bean : javaBeans) {
				gen.init(context, bean);
				gen.exportFile();
			}
		}
		LOG.info("generator success," + (System.currentTimeMillis() - _st));
	}
	
}
