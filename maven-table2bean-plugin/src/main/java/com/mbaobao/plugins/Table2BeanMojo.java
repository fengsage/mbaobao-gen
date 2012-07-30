/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.plugins;

import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.mbaobao.gen.GenFactory;
import com.mbaobao.gen.entity.TableMapping;
import com.mbaobao.plugins.entity.DatabaseConfig;
import com.mbaobao.plugins.entity.MavenConfiguration;
import com.mbaobao.plugins.entity.ResourceConfig;

/**
 * @goal gen
 */
public class Table2BeanMojo extends AbstractMojo {
	
	/**
	 * @parameter
	 */
	private ResourceConfig		resource;
	
	/**
	 * @parameter
	 */
	private DatabaseConfig		database;
	
	/**
	 *  @parameter
	 */
	private List<TableMapping>	mappings;
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("===============Table2Bean===============");
		
		getLog().info("DataBase Configuration:" + database);
		getLog().info("Resource Configuration:" + resource);
		getLog().info("TableMapping Configuration:" + mappings);
		
		long startTime = System.currentTimeMillis();
		
		new GenFactory(new MavenConfiguration(database, resource, mappings));
		
		getLog().info("Gen Database wast:" + (System.currentTimeMillis() - startTime));
	}
	
}
