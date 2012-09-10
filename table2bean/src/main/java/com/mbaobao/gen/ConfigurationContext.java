/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import com.mbaobao.gen.configuration.JavaBeanConfiguration;
import com.mbaobao.gen.configuration.JavaDaoConfiguration;
import com.mbaobao.gen.configuration.JdbcConfiguration;
import com.mbaobao.gen.configuration.MappingConfiguration;
import com.mbaobao.gen.configuration.SqlMapperConfiguration;

/**
 *                       
 * @Filename ConfigurationContext.java
 *
 * @Description 管理全局的配置信息
 *
 * @Version 1.0
 *
 * @Author fred
 *
 * @Email kuci@mbaobao.com
 *       
 * @History
 *<li>Author: fred</li>
 *<li>Date: 2012-7-22</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class ConfigurationContext {
	
	private JavaDaoConfiguration	javaDaoConfiguration;
	
	private JavaBeanConfiguration	javaBeanConfiguration;
	
	private SqlMapperConfiguration	mapperConfiguration;
	
	private JdbcConfiguration		jdbcConfiguration;
	
	private MappingConfiguration	mappingConfiguration;
	
	public JavaDaoConfiguration getJavaDaoConfiguration() {
		return javaDaoConfiguration;
	}
	
	public void setJavaDaoConfiguration(JavaDaoConfiguration javaDaoConfiguration) {
		this.javaDaoConfiguration = javaDaoConfiguration;
	}
	
	public SqlMapperConfiguration getMapperConfiguration() {
		return mapperConfiguration;
	}
	
	public void setMapperConfiguration(SqlMapperConfiguration mapperConfiguration) {
		this.mapperConfiguration = mapperConfiguration;
	}
	
	public JdbcConfiguration getJdbcConfiguration() {
		return jdbcConfiguration;
	}
	
	public void setJdbcConfiguration(JdbcConfiguration jdbcConfiguration) {
		this.jdbcConfiguration = jdbcConfiguration;
	}
	
	public JavaBeanConfiguration getJavaBeanConfiguration() {
		return javaBeanConfiguration;
	}
	
	public void setJavaBeanConfiguration(JavaBeanConfiguration javaBeanConfiguration) {
		this.javaBeanConfiguration = javaBeanConfiguration;
	}
	
	public MappingConfiguration getMappingConfiguration() {
		return mappingConfiguration;
	}
	
	public void setMappingConfiguration(MappingConfiguration mappingConfiguration) {
		this.mappingConfiguration = mappingConfiguration;
	}
	
	/**
	 * 验证配置
	 */
	public void validate() {
		if (javaDaoConfiguration == null) {
			throw new RuntimeException("javaDaoConfiguration can't null");
		}
		if (mapperConfiguration == null) {
			throw new RuntimeException("mapperConfiguration can't null");
		}
		if (jdbcConfiguration == null) {
			throw new RuntimeException("jdbcConfiguration can't null");
		}
		if (javaBeanConfiguration == null) {
			throw new RuntimeException("javaBeanConfiguration can't null");
		}
		if (mappingConfiguration == null) {
			throw new RuntimeException("mappingConfiguration can't null");
		}
		
	}
	
}
