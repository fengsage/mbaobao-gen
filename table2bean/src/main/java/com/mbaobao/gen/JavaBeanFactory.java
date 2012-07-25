/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.util.Date;

import com.mbaobao.gen.entity.JavaBean;
import com.mbaobao.gen.entity.JavaBeanField;
import com.mbaobao.gen.entity.Table;
import com.mbaobao.gen.entity.TableColumn;
import com.mbaobao.gen.entity.TableColumnEnum;

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
 *
 */
public class JavaBeanFactory {
	
	public static JavaBean convert(Table table, String javaName) {
		JavaBean bean = new JavaBean(javaName);
		for (TableColumn column : table.getColumns()) {
			JavaBeanField field = new JavaBeanField();
			field.setName(buildFieldName(column.getName()));
			field.setColumnName(column.getName());
			field.setClsName(buildClsName(column.getColumnType()));
			field.setGetMethodName(buildGetMethod(field.getName()));
			field.setSetMethodName(buildSetMethod(field.getName()));
			bean.getFields().add(field);
		}
		return bean;
	}
	
	private static String buildSetMethod(String name) {
		return "set" + firstLetterUpper(name);
	}
	
	private static String buildGetMethod(String name) {
		return "get" + firstLetterUpper(name);
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
		}
		return String.class;
	}
	
	private static String buildFieldName(String name) {
		String[] strs = name.split("_");//假设表名是这样定义的
		StringBuilder builder = new StringBuilder();
		if (strs.length > 1) {
			builder.append(strs[0].toLowerCase());
			for (int i = 1, size = strs.length; i < size; i++) {
				builder.append(firstLetterUpper(strs[i]));
			}
			return builder.toString();
		}
		return name;
	}
	
	public static String firstLetterUpper(String string) {
		if (string.length() < 1) {
			return string;
		}
		return string.substring(0, 1).toUpperCase() + string.substring(1, string.length());
	}
	
	public static String firstLetterLower(String string) {
		if (string.length() < 1) {
			return string;
		}
		return string.substring(0, 1).toLowerCase() + string.substring(1, string.length());
	}
	
	public static void main(String[] args) {
		System.out.println(buildFieldName("a_b_c"));
	}
	
}
