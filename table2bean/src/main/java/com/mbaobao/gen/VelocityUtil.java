/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 *                       
 * @Filename VelocityUtil.java
 *template
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
 *<li>Date: 2012-7-21</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class VelocityUtil {
	
	private static final Logger		logger		= Logger.getLogger(VelocityUtil.class);
	
	private static final String		TEMPATE_DIR	= VelocityUtil.class.getResource("/").getPath()
													+ "templates";
	
	private static VelocityEngine	ve;
	
	static {
		logger.info("templates目录:" + TEMPATE_DIR);
		ve = new VelocityEngine();
		ve.setProperty("resource.loader", "file");
		ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, TEMPATE_DIR);
		ve.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
		ve.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		ve.init();
	}
	
	public static String loadVelocity(String vmPath, Map<String, Object> data) {
		Template tempate = ve.getTemplate(vmPath);
		StringWriter writer = new StringWriter();
		tempate.merge(buildContext(data), writer);
		writer.flush();
		return writer.toString();
	}
	
	private static VelocityContext buildContext(Map<String, Object> data) {
		VelocityContext context = new VelocityContext();
		for (String key : data.keySet()) {
			context.put(key, data.get(key));
		}
		return context;
	}
	
	public static void main(String[] args) {
		Map<String, Object> data = new HashMap<String, Object>();
		String resource = VelocityUtil.loadVelocity("bean.vm", data);
	}
}
