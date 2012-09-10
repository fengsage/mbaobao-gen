/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.generate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;

import com.mbaobao.gen.ConfigurationContext;
import com.mbaobao.gen.VelocityUtil;
import com.mbaobao.gen.entity.JavaBean;

/**
 *                       
 * @Filename GeneratedFile.java
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
public abstract class GeneratedFile {
	
	public static final Logger	LOG	= Logger.getLogger(GeneratedFile.class);
	
	/**
	 * 设置环境变量
	 * @param velocityContext
	 * @param bean 
	 */
	public abstract void setContextData(VelocityContext velocityContext, JavaBean bean);
	
	/**
	 * 返回模版名
	 * @return
	 */
	public abstract String genFileTempateName();
	
	/**
	 * 生成文件
	 * @param configContext
	 * @param bean
	 * @return
	 */
	public String generatedFile(final ConfigurationContext configContext, final JavaBean bean) {
		try {
			
			VelocityContext velocityContext = initVelocityContext(configContext);
			
			setContextData(velocityContext, bean);//设置环境变量
			
			return VelocityUtil.exportContent(genFileTempateName(), velocityContext);
		} catch (Exception e) {
			LOG.error("generated file error!", e);
		}
		return null;
	}
	
	private VelocityContext initVelocityContext(ConfigurationContext configContext) {
		VelocityContext context = new VelocityContext();
		setEnvContext(context, configContext);
		return context;
	}
	
	private void setEnvContext(VelocityContext velocityContext,
								final ConfigurationContext configContext) {
		
		Map<String, String> env = new HashMap<String, String>();
		env.put("entityPackage", configContext.getJavaBeanConfiguration().getTargetPackage());
		env.put("daoPackage", configContext.getJavaDaoConfiguration().getTargetPackage());
		env.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		velocityContext.put("env", env);
	}
	
}
