/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *                       
 * @Filename TableColumnEnum.java
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
 *<li>Date: 2012-7-20</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public enum TableColumnEnum {
	
	FLOAT("FLOAT", "单精度"),
	
	DOUBLE("DOUBLE", "双精度"),
	
	INT_UNSIGNED("INT UNSIGNED", "无符号整数"),
	
	DOUBLE_UNSIGNED("DOUBLE UNSIGNED", ""),
	
	TINYINT_UNSIGNED("TINYINT UNSIGNED", ""),
	
	SMALLINT_UNSIGNED("SMALLINT UNSIGNED", ""),
	
	BIGINT_UNSIGNED("BIGINT UNSIGNED", ""),
	
	INT("INT", "整数"),
	
	CHAR("CHAR", ""),
	
	TINYINT("TINYINT", "短整数"),
	
	INTEGER("INTEGER", "整数"),
	
	TEXT("TEXT", "大文本"),
	
	VARCHAR("VARCHAR", "字符串"),
	
	DATE("DATE", "日期"),
	
	DATETIME("DATETIME", "日期时间"),
	
	TIMESTAMP("TIMESTAMP", "时间戳");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>TableColumnEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private TableColumnEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return TableColumnEnum
	 */
	public static TableColumnEnum getByCode(String code) {
		for (TableColumnEnum cacheCode : values()) {
			if (cacheCode.getCode().equals(code)) {
				return cacheCode;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<TableColumnEnum>
	 */
	public List<TableColumnEnum> getAllEnum() {
		List<TableColumnEnum> list = new ArrayList<TableColumnEnum>();
		for (TableColumnEnum cache : values()) {
			list.add(cache);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (TableColumnEnum cache : values()) {
			list.add(cache.code());
		}
		return list;
	}
}
