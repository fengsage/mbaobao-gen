/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
	
	public static final Logger		LOG	= Logger.getLogger(GeneratedFile.class);
	
	private ConfigurationContext	configContext;
	
	private String					fileContent;
	
	private JavaBean				javaBean;
	
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
	public abstract String getFileTempateName();
	
	/**
	 * 返回文件导出路径
	 * @param configContext 
	 * @return
	 */
	public abstract String getFileExportPath(ConfigurationContext configContext, JavaBean bean);
	
	/**
	 * 返回文件名
	 * @param configContext 
	 * @return
	 */
	public abstract String getFileExportFileName(JavaBean bean);
	
	/**
	 * 生成文件
	 * @param configContext
	 * @param bean
	 * @return
	 */
	public void init(final ConfigurationContext configContext, final JavaBean bean) {
		try {
			this.configContext = configContext;
			this.javaBean = bean;
			
			VelocityContext velocityContext = initVelocityContext(configContext);
			
			setContextData(velocityContext, bean);//设置环境变量
			
			this.fileContent = VelocityUtil.exportContent(getFileTempateName(), velocityContext);
			
		} catch (Exception e) {
			LOG.error("generated file error!", e);
		}
	}
	
	public void exportFile() {
		if (configContext == null) {
			throw new RuntimeException("configContext can't be null");
		}
		if (fileContent == null) {
			throw new RuntimeException("fileContent can't be null");
		}
		if (javaBean == null) {
			throw new RuntimeException("javaBean can't be null");
		}
		String path = getFileExportPath(this.configContext, this.javaBean);
		String fileName = getFileExportFileName(this.javaBean);
		
		exportFile(path, fileName, this.fileContent);
	}
	
	private void exportFile(String filePath, String fileName, String source) {
		try {
			LOG.info("\t导出文件:" + filePath);
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileWriter writer = new FileWriter(new File(filePath + File.separator + fileName));
			writer.write(source);
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("\t导出文件失败:" + e.getMessage());
		}
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
