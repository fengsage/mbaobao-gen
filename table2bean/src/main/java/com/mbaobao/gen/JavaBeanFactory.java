/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.mbaobao.gen.configuration.JdbcConfiguration;
import com.mbaobao.gen.db.DBConnection;
import com.mbaobao.gen.entity.JavaBean;
import com.mbaobao.gen.entity.JavaBeanField;
import com.mbaobao.gen.entity.Table;
import com.mbaobao.gen.entity.TableColumn;
import com.mbaobao.gen.entity.TableColumnEnum;
import com.mbaobao.gen.entity.TableMapping;
import com.mbaobao.gen.util.JavaBeansUtil;

/**
 *                       
 * @Filename JavaBeanFactory.java
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
 *<li>Date: 2012-7-22</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *Connection
 */
public class JavaBeanFactory {
	
	private static final Logger	LOG	= Logger.getLogger(JavaBeanFactory.class);
	
	private JdbcConfiguration	jdbcConfiguration;
	
	public List<JavaBean> loadJaveBeans(ConfigurationContext context) {
		this.jdbcConfiguration = context.getJdbcConfiguration();
		
		List<JavaBean> javaBeans = new ArrayList<JavaBean>();
		for (TableMapping mapping : context.getMappingConfiguration().getMappings()) {
			try {
				
				Table table = buildTable(mapping.getTableName());
				
				JavaBean bean = buildJavaBean(table);
				bean.setClassName(mapping.getJavaName());
				
				javaBeans.add(bean);
			} catch (SQLException e) {
				LOG.error("读取Table信息失败", e);
			}
		}
		return javaBeans;
	}
	
	private JavaBean buildJavaBean(final Table table) {
		JavaBean bean = new JavaBean();
		bean.setTable(table);
		for (TableColumn column : table.getColumns()) {
			bean.getFields().add(buildJavaBeanFiled(column));
		}
		return bean;
	}
	
	/**
	 * @param column
	 * @return
	 */
	private JavaBeanField buildJavaBeanFiled(TableColumn column) {
		JavaBeanField filed = new JavaBeanField();
		filed.setClsName(buildClsName(column.getColumnType()));
		filed.setName(JavaBeansUtil.getCamelCaseString(column.getName(), false));
		filed.setTableColumn(column);
		return filed;
	}
	
	private Table buildTable(String tableName) throws SQLException {
		LOG.info("读取表信息" + tableName);
		
		String sql = String.format("SELECT * FROM %s LIMIT 1", tableName);
		
		Statement st = DBConnection.getConnection(jdbcConfiguration).createStatement();
		ResultSet rs = st.executeQuery(sql);
		ResultSetMetaData md = rs.getMetaData();
		
		Table table = new Table();
		table.setName(tableName);
		for (int i = 1, size = md.getColumnCount(); i <= size; i++) {
			String name = md.getColumnName(i);
			String columnType = md.getColumnTypeName(i);
			TableColumnEnum type = TableColumnEnum.VARCHAR;
			
			try {
				type = TableColumnEnum.getByCode(columnType);
				if (type == null) {
					type = TableColumnEnum.VARCHAR;
				}
			} catch (Exception e) {
				throw new RuntimeException("无法识字段类型：" + columnType);
			}
			TableColumn column = new TableColumn(name, type, 0);
			table.getColumns().add(column);
		}
		
		LOG.info("读取表信息:" + tableName + "\t完成");
		return table;
	}
	
	@SuppressWarnings("rawtypes")
	private static Class buildClsName(TableColumnEnum columnType) {
		switch (columnType) {
			case DATE:
				return Date.class;
			case DOUBLE:
				return Double.class;
			case DATETIME:
				return Date.class;
			case FLOAT:
				return Float.class;
			case INT:
				return Integer.class;
			case INT_UNSIGNED:
				return Integer.class;
			case INTEGER:
				return Integer.class;
			case TEXT:
				return String.class;
			case TIMESTAMP:
				return Date.class;
			case TINYINT:
				return Integer.class;
			case VARCHAR:
				return String.class;
			case SMALLINT_UNSIGNED:
				return Integer.class;
			case DOUBLE_UNSIGNED:
				return Integer.class;
			case TINYINT_UNSIGNED:
				return Integer.class;
		}
		return String.class;
	}
	
}
