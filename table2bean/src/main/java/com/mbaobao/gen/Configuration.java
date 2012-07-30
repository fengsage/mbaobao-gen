/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen;

import java.io.File;
import java.util.List;

import com.mbaobao.gen.entity.TableMapping;

/**
 *                       
 * @Filename Configuration.java
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
public abstract class Configuration {
	
	/**环境相关*/
	public String				javaPath;
	public String				resourcePath;
	public String				packageName;
	public String				entityPackage;
	public String				daoPackage;
	public String				mapperPackage;
	public String				author;
	
	/**数据源相关*/
	public String				jdbcDriver;
	public String				jdbcUrl;
	public String				jdbcUsername;
	public String				jdbcPassword;
	
	/**mapping配置*/
	public List<TableMapping>	mappings;
	
	/**
	 * 读取配置文件
	 * @return
	 */
	public abstract Configuration loadConfiguration();
	
	public String getEntityPath() {
		return this.javaPath + File.separator + this.entityPackage.replace(".", File.separator);
	}
	
	public String getDaoPath() {
		return this.javaPath + File.separator + this.daoPackage.replace(".", File.separator);
	}
	
	public String getMaperPath() {
		return this.resourcePath + File.separator + this.mapperPackage.replace(".", File.separator);
	}
}
