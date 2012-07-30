/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mbaobao.gen.entity.TableMapping;
import com.mbaobao.gen.util.PropertiesHelp;
import com.mbaobao.gen.util.StringUtil;

/**
 *                       
 * @Filename PropertiesConfiguration.java
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
public class PropertiesConfiguration extends Configuration {
	
	private static final Logger	logger	= Logger.getLogger(PropertiesConfiguration.class);
	
	public PropertiesConfiguration() {
		initEnv();
		initJDBC();
		initMappings();
	}
	
	private void initEnv() {
		this.javaPath = PropertiesHelp.getProperty("gen.java.path");
		this.resourcePath = PropertiesHelp.getProperty("gen.resources.path");
		this.packageName = PropertiesHelp.getProperty("gen.java.package");
		if (StringUtil.isEmpty(this.packageName)) {
			this.packageName = "com.mbaobao.table2bean";
		}
		this.entityPackage = PropertiesHelp.getProperty("gen.package.entity");
		if (StringUtil.isEmpty(this.entityPackage)) {
			this.entityPackage = this.packageName + ".entity";
		}
		this.daoPackage = PropertiesHelp.getProperty("gen.package.dao");
		if (StringUtil.isEmpty(this.daoPackage)) {
			this.daoPackage = this.packageName + ".dao";
		}
		this.mapperPackage = PropertiesHelp.getProperty("gen.package.mapper");
		if (StringUtil.isEmpty(this.mapperPackage)) {
			this.mapperPackage = "sql-mapper";
		}
		this.author = PropertiesHelp.getProperty("gen.author");
		if (StringUtil.isEmpty(this.author)) {
			this.author = "Table2Bean Tools";
		}
	}
	
	private void initMappings() {
		String mappingConfig = PropertiesHelp.getProperty("gen.mapping");
		if (!StringUtil.isEmpty(mappingConfig)) {
			this.mappings = loadTableMapping(mappingConfig);
		}
	}
	
	private void initJDBC() {
		this.jdbcDriver = PropertiesHelp.getProperty("prop.jdbc.default.driver");
		this.jdbcUrl = PropertiesHelp.getProperty("prop.jdbc.default.url");
		this.jdbcUsername = PropertiesHelp.getProperty("prop.jdbc.default.username");
		this.jdbcPassword = PropertiesHelp.getProperty("prop.jdbc.default.password");
	}
	
	private static List<TableMapping> loadTableMapping(String mappingConfig) {
		logger.info("读取mapping配置数据...");
		List<TableMapping> list = new ArrayList<TableMapping>();
		String[] tables = mappingConfig.split(",");
		for (String table : tables) {
			String[] mapping = table.split(":");
			if (mapping.length < 2) {
				throw new RuntimeException("读取mapping配置异常.\t格式:[table_name]:[java_name]");
			}
			list.add(new TableMapping(mapping[0], mapping[1]));
		}
		logger.info("读取mapping配置数据完成:" + list);
		return list;
	}
	
}
