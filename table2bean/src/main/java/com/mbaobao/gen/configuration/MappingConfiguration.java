/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.gen.configuration;

import java.util.ArrayList;
import java.util.List;

import com.mbaobao.gen.entity.TableMapping;

/**
 *                       
 * @Filename MappingConfiguration.java
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
public class MappingConfiguration {
	
	private List<TableMapping>	mappings	= new ArrayList<TableMapping>();
	
	public List<TableMapping> getMappings() {
		return mappings;
	}
	
	public void loadTableMapping(String mappingConfig) {
		String[] tables = mappingConfig.split(",");
		for (String table : tables) {
			String[] mapping = table.split(":");
			if (mapping.length < 2) {
				throw new RuntimeException("读取mapping配置异常.\t格式:[table_name]:[java_name]");
			}
			mappings.add(new TableMapping(mapping[0], mapping[1]));
		}
	}
	
	@Override
	public String toString() {
		return "MappingConfiguration [mappings=" + mappings + "]";
	}
	
}
