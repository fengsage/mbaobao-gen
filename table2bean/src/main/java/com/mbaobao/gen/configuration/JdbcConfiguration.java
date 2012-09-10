/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.configuration;

/**
 *                       
 * @Filename JdbcConfiguration.java
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
public class JdbcConfiguration {
	
	private String	driverClass;
	
	private String	url;
	
	private String	username;
	
	private String	password;
	
	public String getDriverClass() {
		return driverClass;
	}
	
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "JdbcConfiguration [driverClass=" + driverClass + ", url=" + url + ", username="
				+ username + ", password=" + password + "]";
	}
	
}
