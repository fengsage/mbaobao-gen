package com.mbaobao.gen.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import com.mbaobao.gen.configuration.JdbcConfiguration;

public class DBConnection {
	
	private DataSource	dataSource;
	
	public DBConnection(JdbcConfiguration configuration) {
		PoolProperties p = new PoolProperties();
		p.setDriverClassName(configuration.getDriverClass());
		p.setUrl(configuration.getUrl());
		p.setUsername(configuration.getUsername());
		p.setPassword(configuration.getPassword());
		p.setJmxEnabled(true);
		p.setTestWhileIdle(false);
		p.setTestOnBorrow(true);
		p.setValidationQuery("SELECT 1");
		p.setTestOnReturn(false);
		p.setValidationInterval(30000);
		p.setTimeBetweenEvictionRunsMillis(30000);
		p.setMaxActive(100);
		p.setInitialSize(10);
		p.setMaxWait(10000);
		p.setRemoveAbandonedTimeout(60);
		p.setMinEvictableIdleTimeMillis(30000);
		p.setMinIdle(10);
		p.setLogAbandoned(true);
		p.setRemoveAbandoned(true);
		p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
								+ "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
		
		this.dataSource = new DataSource();
		this.dataSource.setPoolProperties(p);
		
	}
	
	public DataSource getDataSource() {
		return this.dataSource;
	}
	
	public static Connection getConnection(JdbcConfiguration configuration) {
		try {
			Connection con = new DBConnection(configuration).getDataSource().getConnection();
			return con;
		} catch (SQLException e) {
		}
		throw new RuntimeException("无法取得数据源连接");
	}
	
	/**
	 * 释放数据库的资源.
	 * 
	 * @param conn
	 *        数据库连接
	 * @param stat
	 *        {@link Statement}对象
	 * @param rs
	 *        {@link ResultSet}对象
	 */
	public static void closeConnection(Connection conn, Statement stat, ResultSet rs) {
		try {
			// 关闭结果集对象.
			if (rs != null && !rs.isClosed()) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			// 当关闭失败时,记录错误信息,并报告上层代码.
			throw new RuntimeException(e);
		} finally {
			try {
				// 关闭Statement对象.
				if (stat != null && !stat.isClosed()) {
					stat.close();
					stat = null;
				}
			} catch (SQLException e) {
				// 当关闭失败时,记录错误信息,并报告上层代码.
				throw new RuntimeException(e);
			} finally {
				try {
					// 关闭数据库连接.
					if (conn != null && !conn.isClosed()) {
						conn.close();
						conn = null;
					}
				} catch (SQLException e) {
					// 当关闭失败时,记录错误信息,并报告上层代码.
					throw new RuntimeException(e);
				}
			}
		}
	}
}
