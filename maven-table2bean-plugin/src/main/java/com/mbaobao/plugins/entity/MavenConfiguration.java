/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.plugins.entity;

import java.util.List;

import com.mbaobao.gen.Configuration;
import com.mbaobao.gen.entity.TableMapping;
import com.mbaobao.gen.util.StringUtil;

/**
 *                       
 * @Filename MavenConfiguration.java
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
 *<li>Date: 2012-7-31</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class MavenConfiguration extends Configuration {
	
	private ResourceConfig		resource;
	
	private DatabaseConfig		database;
	
	private List<TableMapping>	tableMappings;
	
	public MavenConfiguration(DatabaseConfig database, ResourceConfig resource,
								List<TableMapping> tableMappings) {
		this.resource = resource;
		this.database = database;
		this.tableMappings = tableMappings;
		
		init();
	}
	
	/**
	 * 初始化
	 */
	private void init() {
		initEnv();
		initJDBC();
		initMappings();
	}
	
	private void initEnv() {
		this.javaPath = resource.getJavaPath();
		this.resourcePath = resource.getResourcePath();
		this.packageName = resource.getPackageName();
		if (StringUtil.isEmpty(this.packageName)) {
			this.packageName = "com.mbaobao.table2bean";
		}
		this.entityPackage = resource.getEntityPackage();
		if (StringUtil.isEmpty(this.entityPackage)) {
			this.entityPackage = this.packageName + ".entity";
		}
		this.daoPackage = resource.getDaoPackage();
		if (StringUtil.isEmpty(this.daoPackage)) {
			this.daoPackage = this.packageName + ".dao";
		}
		this.mapperPackage = resource.getMapperPackage();
		if (StringUtil.isEmpty(this.mapperPackage)) {
			this.mapperPackage = "sql-mapper";
		}
		this.author = resource.getAuthor();
		if (StringUtil.isEmpty(this.author)) {
			this.author = "Table2Bean Tools";
		}
	}
	
	private void initMappings() {
		this.mappings = tableMappings;
	}
	
	private void initJDBC() {
		this.jdbcDriver = database.getJdbcDriver();
		this.jdbcUrl = database.getJdbcUrl();
		this.jdbcUsername = database.getJdbcUsername();
		this.jdbcPassword = database.getJdbcPassword();
	}
	
}
