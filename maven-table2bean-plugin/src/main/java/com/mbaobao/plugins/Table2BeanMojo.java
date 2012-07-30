/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.mbaobao.plugins.entity.DatabaseConfig;
import com.mbaobao.plugins.entity.ResourceConfig;

/**
 * @goal gen
 */
public class Table2BeanMojo extends AbstractMojo {
	
	/**
	 * @parameter
	 */
	private ResourceConfig	resource;
	
	/**
	 * @parameter
	 */
	private DatabaseConfig	database;
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("===============Table2Bean===============");
		
		getLog().info("DataBase Configuration:" + database);
		
		getLog().info("Resource Configuration:" + resource);
		
	}
	
}
