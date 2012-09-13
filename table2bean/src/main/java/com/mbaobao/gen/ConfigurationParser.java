/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mbaobao.gen.configuration.JavaBeanConfiguration;
import com.mbaobao.gen.configuration.JavaDaoConfiguration;
import com.mbaobao.gen.configuration.JdbcConfiguration;
import com.mbaobao.gen.configuration.MappingConfiguration;
import com.mbaobao.gen.configuration.SqlMapperConfiguration;

/**
 *                       
 * @Filename ConfigurationParser.java
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
public class ConfigurationParser {
	
	private Properties	properties;
	
	public ConfigurationContext parseConfiguration(InputStream inputStream) throws IOException {
		properties = new Properties();
		properties.load(inputStream);
		return parseConfiguration(properties);
	}
	
	public ConfigurationContext parseConfiguration(Properties properties) throws IOException {
		ConfigurationContext context = new ConfigurationContext();
		context.setJavaDaoConfiguration(readJavaDao(properties));
		context.setJdbcConfiguration(readJdbcConfig(properties));
		context.setMapperConfiguration(readMapperConfig(properties));
		context.setJavaBeanConfiguration(readJavaBeanConfig(properties));
		context.setMappingConfiguration(readMappingConfig(properties));
		return context;
	}
	
	private MappingConfiguration readMappingConfig(Properties properties) {
		MappingConfiguration config = new MappingConfiguration();
		config.loadTableMapping(properties.getProperty("gen.mapping"));
		return config;
	}
	
	private JavaBeanConfiguration readJavaBeanConfig(Properties properties) {
		JavaBeanConfiguration config = new JavaBeanConfiguration();
		config.setTargetPackage(properties.getProperty("gen.java.path.bean"));
		config.setTargetProject(properties.getProperty("gen.java.path"));
		return config;
	}
	
	private JavaDaoConfiguration readJavaDao(Properties properties) {
		JavaDaoConfiguration config = new JavaDaoConfiguration();
		config.setTargetPackage(properties.getProperty("gen.java.path.dao"));
		config.setTargetProject(properties.getProperty("gen.java.path"));
		return config;
	}
	
	private SqlMapperConfiguration readMapperConfig(Properties properties) {
		SqlMapperConfiguration config = new SqlMapperConfiguration();
		config.setTargetPackage(properties.getProperty("gen.resource.path.mapper"));
		config.setTargetResource(properties.getProperty("gen.resource.path"));
		return config;
	}
	
	private JdbcConfiguration readJdbcConfig(Properties properties) {
		JdbcConfiguration config = new JdbcConfiguration();
		config.setDriverClass(properties.getProperty("gen.jdbc.default.driver"));
		config.setUrl(properties.getProperty("gen.jdbc.default.url"));
		config.setUsername(properties.getProperty("gen.jdbc.default.username"));
		config.setPassword(properties.getProperty("gen.jdbc.default.password"));
		return config;
	}
	
}
