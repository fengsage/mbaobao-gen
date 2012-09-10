/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.plugins;

import org.apache.log4j.Logger;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.mbaobao.gen.ConfigurationContext;

/**
 * @goal gen
 */
public class Table2BeanMojo extends AbstractMojo {
	
	private static final Logger	LOG	= Logger.getLogger(Table2BeanMojo.class);
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("===============Table2Bean===============");
		long startTime = System.currentTimeMillis();
		try {
			ConfigurationContext config = new PropertiesConfiguration();
			TableModel model = new TableModel(config);
			
			LOG.info(model);
			
			//			new GenFactory(config).export();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		getLog().info("Gen Finished total:" + (System.currentTimeMillis() - startTime));
	}
	
}
