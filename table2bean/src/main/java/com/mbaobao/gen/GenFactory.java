/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mbaobao.gen.entity.Table;
import com.mbaobao.gen.entity.TableMapping;
import com.mbaobao.gen.util.PropertiesHelp;

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
	
	private static final Logger	logger		= Logger.getLogger(GenFactory.class);
	
	private static final String	MAPPING		= PropertiesHelp.getProperty("gen.mapping");
	
	private static final String	TEMPATE_DIR	= GenFactory.class.getResource("/").getPath()
												+ "templates";
	
	public static List<TableMapping> loadTableMapping() {
		logger.info("读取mapping配置数据...");
		List<TableMapping> list = new ArrayList<TableMapping>();
		String[] tables = MAPPING.split(",");
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
	
	public static void export(String path) throws SQLException {
		String resource = GenFactory.class.getResource("/").getPath();
		if (path != null) {
			path = resource + path;
		} else {
			path = resource;
		}
		logger.info("导出目录:" + path);
		List<TableMapping> mappings = loadTableMapping();//读取数据库映射
		for (TableMapping mapping : mappings) {
			Table table = TableModel.getTableInfo(mapping.getTableName());
			//生成Encrypt
			exportJavaBean(mapping.getJavaName(), table, path);
			//生成Dao
			//			exportJavaDao(mapping.getJavaName(), table, path);
			//生成mapping
			//			exportSqlMapper(mapping.getJavaName(), table, path);
		}
	}
	
	public static void exportJavaBean(String javaName, Table table, String path) {
		String source = VelocityUtil.loadVelocity("bean.vm",
			buildVelocityData(javaName, table, path));
		
		System.out.println(source);
	}
	
	public static void exportJavaDao(String javaName, Table table, String path) {
		String source = VelocityUtil.loadVelocity("dao.vm",
			buildVelocityData(javaName, table, path));
		
	}
	
	public static void exportSqlMapper(String javaName, Table table, String path) {
		String source = VelocityUtil.loadVelocity("sqlmapper.vm",
			buildVelocityData(javaName, table, path));
		
	}
	
	private static Map<String, Object> buildVelocityData(String javaName, Table table, String path) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("java", JavaBeanFactory.convert(table, javaName));
		map.put("path", path);
		//配置一些环境信息
		setEnvironment(map);
		return map;
	}
	
	private static void setEnvironment(Map<String, Object> data) {
		Map<String, String> env = new HashMap<String, String>();
		env.put("package", PropertiesHelp.getProperty("gen.package"));
		env.put("author", PropertiesHelp.getProperty("gen.author"));
		env.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
		data.put("env", env);
	}
	
	public static void main(String[] args) throws SQLException {
		GenFactory.export(null);
	}
}
