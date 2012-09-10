/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaoabo.test;

import java.io.IOException;

import junit.framework.TestCase;

import com.mbaobao.gen.ConfigurationContext;
import com.mbaobao.gen.ConfigurationParser;
import com.mbaobao.gen.MyBatisGenerator;

/**
 *                       
 * @Filename MyBatisGeneratorTest.java
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
public class MyBatisGeneratorTest extends TestCase {
	
	public void testGenerator() throws IOException {
		ConfigurationParser parser = new ConfigurationParser();
		ConfigurationContext context = parser.parseConfiguration(this.getClass().getClassLoader()
			.getResourceAsStream("config.properties"));
		
		//生成code
		MyBatisGenerator generator = new MyBatisGenerator(context);
		generator.generate();
		
	}
	
}
