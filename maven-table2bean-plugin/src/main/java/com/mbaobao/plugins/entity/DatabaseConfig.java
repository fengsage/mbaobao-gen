/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.plugins.entity;

/**
 *                       
 * @Filename DatabaseConfig.java
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
 *<li>Date: 2012-7-30</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class DatabaseConfig {
	
	private String	jdbcDriver;
	
	private String	jdbcUrl;
	
	private String	jdbcUsername;
	
	private String	jdbcPassword;
	
	/**
	 * @return Returns the jdbcDriver
	 */
	public String getJdbcDriver() {
		return jdbcDriver;
	}
	
	/**
	 * @param jdbcDriver
	 * The jdbcDriver to set.
	 */
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	
	/**
	 * @return Returns the jdbcUrl
	 */
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	
	/**
	 * @param jdbcUrl
	 * The jdbcUrl to set.
	 */
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	
	/**
	 * @return Returns the jdbcUsername
	 */
	public String getJdbcUsername() {
		return jdbcUsername;
	}
	
	/**
	 * @param jdbcUsername
	 * The jdbcUsername to set.
	 */
	public void setJdbcUsername(String jdbcUsername) {
		this.jdbcUsername = jdbcUsername;
	}
	
	/**
	 * @return Returns the jdbcPassword
	 */
	public String getJdbcPassword() {
		return jdbcPassword;
	}
	
	/**
	 * @param jdbcPassword
	 * The jdbcPassword to set.
	 */
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DatabaseConfig [jdbcDriver=" + jdbcDriver + ", jdbcUrl=" + jdbcUrl
				+ ", jdbcUsername=" + jdbcUsername + ", jdbcPassword=" + jdbcPassword + "]";
	}
	
}
