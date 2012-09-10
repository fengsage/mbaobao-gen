/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.mbaobao.test;

import junit.framework.TestCase;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

import com.mbaobao.plugins.Table2BeanMojo;

/**
 *                       
 * @Filename MojoTest.java
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
 *<li>Date: 2012-8-14</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class MojoTest extends TestCase {
	
	public void testMojo() throws MojoExecutionException, MojoFailureException {
		new Table2BeanMojo().execute();
	}
	
}
