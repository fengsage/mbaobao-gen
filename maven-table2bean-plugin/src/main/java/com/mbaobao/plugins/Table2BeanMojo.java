/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.plugins;

import java.sql.SQLException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.mbaobao.gen.GenFactory;

/**
 * @goal gen
 */
public class Table2BeanMojo extends AbstractMojo {
	
	@Override
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("===============Table2Bean===============");
		long startTime = System.currentTimeMillis();
		
		try {
			new GenFactory(new PropertiesConfiguration()).export();
		} catch (SQLException e) {
			getLog().error("", e);
		}
		
		getLog().info("Gen wast:" + (System.currentTimeMillis() - startTime));
	}
	
}
