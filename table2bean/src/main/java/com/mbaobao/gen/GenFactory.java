/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mbaobao.gen.entity.GenFileEnum;
import com.mbaobao.gen.entity.Table;
import com.mbaobao.gen.entity.TableMapping;

/**
 *                       
 * @Filename GenFactory.java
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
 *<li>Date: 2012-7-21</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class GenFactory {
	
	private static final Logger	logger	= Logger.getLogger(GenFactory.class);
	
	private Configuration		configuration;
	
	public GenFactory(Configuration configuration) {
		this.configuration = configuration;
	}
	
	public void export() throws SQLException {
		List<TableMapping> mappings = configuration.mappings;
		for (TableMapping mapping : mappings) {
			Table table = new TableModel(configuration).getTableInfo(mapping.getTableName());
			//生成Encrypt
			exportJavaBean(mapping.getJavaName(), table);
			//生成Dao
			exportJavaDao(mapping.getJavaName(), table);
			//生成mapping
			exportSqlMapper(mapping.getJavaName(), table);
		}
	}
	
	private void exportJavaBean(String name, Table table) {
		String source = VelocityUtil.loadVelocity("bean.vm", buildVelocityData(name, table));
		//导出文件
		exportFile(buildExportFilePath(GenFileEnum.ENTITY),
			buildExportFileName(name, GenFileEnum.ENTITY), source);
	}
	
	private void exportJavaDao(String name, Table table) {
		String source = VelocityUtil.loadVelocity("dao.vm", buildVelocityData(name, table));
		//导出文件
		exportFile(buildExportFilePath(GenFileEnum.DAO),
			buildExportFileName(name, GenFileEnum.DAO), source);
	}
	
	private void exportSqlMapper(String name, Table table) {
		String source = VelocityUtil.loadVelocity("sqlmapper.vm", buildVelocityData(name, table));
		//导出文件
		exportFile(buildExportFilePath(GenFileEnum.MAPPER),
			buildExportFileName(name, GenFileEnum.MAPPER), source);
	}
	
	private Map<String, Object> buildVelocityData(String javaName, Table table) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("java", JavaBeanFactory.convert(table, javaName));
		map.put("table", table);
		//配置一些环境信息
		setEnvironment(map);
		return map;
	}
	
	private String buildExportFilePath(GenFileEnum type) {
		switch (type) {
			case ENTITY:
				return configuration.getEntityPath();
			case DAO:
				return configuration.getDaoPath();
			case MAPPER:
				return configuration.getMaperPath();
		}
		throw new RuntimeException("不知道神马类型？" + type);
	}
	
	private String buildExportFileName(String name, GenFileEnum type) {
		switch (type) {
			case ENTITY:
				return name + ".java";
			case DAO:
				return name + "Dao.java";
			case MAPPER:
				return name + "DaoMapper.xml";
		}
		throw new RuntimeException("不知道神马类型？" + type);
	}
	
	private void setEnvironment(Map<String, Object> data) {
		Map<String, String> env = new HashMap<String, String>();
		env.put("package", configuration.packageName);
		env.put("entityPackage", configuration.entityPackage);
		env.put("daoPackage", configuration.daoPackage);
		env.put("author", configuration.author);
		env.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		data.put("env", env);
		data.put("factory", JavaBeanFactory.class);
	}
	
	private void exportFile(String filePath, String fileName, String source) {
		try {
			logger.info("导出文件:" + filePath);
			File file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileWriter writer = new FileWriter(new File(filePath + File.separator + fileName));
			writer.write(source);
			writer.flush();
		} catch (IOException e) {
			throw new RuntimeException("导出文件失败:" + e.getMessage());
		}
	}
	
	public static void main(String[] args) throws SQLException {
		new GenFactory(Configuration.loadConfiguration()).export();
	}
}
