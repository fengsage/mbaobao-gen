package com.mbaoabo.test.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mbaoabo.test.bean.User;

/**
 * www.mbaobao.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */

/**
 *                       
 * @Filename DaoTest.java
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
 *<li>Date: 2012-7-23</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class DaoTest extends TestCase {
	
	public void testDao() throws IOException {
		Reader reader = Resources.getResourceAsReader("configuration.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();
		
		int id = 1;
		
		User user = new User();
		user.setId(id);
		user.setAddUser("add_user");
		user.setAppIds("1");
		user.setCreateTime(new Date());
		user.setFlowerName("苦慈");
		user.setIsDel(0);
		user.setIsLock(0);
		user.setLastLoginIp("localhost");
		user.setLastLoginTime(new Date());
		user.setPassword("123456");
		user.setPhone("123456");
		user.setRoleIds("2");
		user.setUpdateTime(new Date());
		user.setUsername("kuci@mbaobao.com");
		
		UserDao userDao = session.getMapper(UserDao.class);
		//新增
		Integer result = userDao.insert(user);
		assertTrue(result > 0);
		
		//修改
		//		user.setId(id);
		//		user.setFlowerName("kuci");
		//		result = userDao.update(user);
		//		assertTrue(result > 0);
		//查询
		User _u = new User();
		_u.setId(id);
		List<User> list = userDao.findUsersByPage(_u, 0, 1);
		assertTrue(list.size() > 0);
		_u = list.get(0);
		assertTrue("苦慈".equals(_u.getFlowerName()));
		//		//删除
		//		result = userDao.deleteByPrimary(id);
		//		assertTrue(result > 0);
		
		session.commit();
		session.close();
		
	}
	
}
