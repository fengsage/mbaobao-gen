/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

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
			field.setTypeName(buildTypeName(column.getColumnType()));
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
	
	private static String buildTypeName(TableColumnEnum columnType) {
		switch (columnType) {
			case DATE:
				return "Date";
			case DOUBLE:
				return "Double";
			case DATETIME:
				return "Date";
			case FLOAT:
				return "Float";
			case INT:
				return "Integer";
			case INT_UNSIGNED:
				return "Integer";
			case INTEGER:
				return "Integer";
			case TEXT:
				return "String";
			case TIMESTAMP:
				return "Long";
			case TINYINT:
				return "Integer";
			case VARCHAR:
				return "String";
		}
		return "String";//无奈的选择
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
	
	private static String firstLetterUpper(String string) {
		if (string.length() < 1) {
			return string;
		}
		string = string.toLowerCase();
		return string.substring(0, 1).toUpperCase() + string.substring(1, string.length());
	}
	
	public static void main(String[] args) {
		System.out.println(buildFieldName("a_b_c"));
	}
	
}
