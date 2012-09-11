/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.plugins;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.mbaobao.gen.ConfigurationContext;
import com.mbaobao.gen.ConfigurationParser;
import com.mbaobao.gen.MyBatisGenerator;

/**
 * @goal gen
 */
public class Table2BeanMojo extends AbstractMojo {
	
	private static final Logger	LOG	= Logger.getLogger(Table2BeanMojo.class);
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("===============Table2Bean===============");
		long startTime = System.currentTimeMillis();
		
		ConfigurationParser parser = new ConfigurationParser();
		
		try {
			ConfigurationContext context = parser.parseConfiguration(this.getClass()
				.getClassLoader().getResourceAsStream("config.properties"));
			
			//生成code
			MyBatisGenerator generator = new MyBatisGenerator(context);
			generator.generate();
			
		} catch (IOException e) {
			LOG.error("", e);
		}
		
		getLog().info("Gen Finished total:" + (System.currentTimeMillis() - startTime));
	}
	
}
