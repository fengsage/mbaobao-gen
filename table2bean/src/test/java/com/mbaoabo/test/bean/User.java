/**
 * mbaobao.com Inc.
 * Copyright (c) 2012 All Rights Reserved.
 */
package com.mbaoabo.test.bean;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;

/**
 *
 * This tools just a simple useful tools, gen table to javabean
 *
 * "I hope this tools can save your time"
 *
 * Generated by <tt>Tabl2Bean</tt> on 2012-09-10 22:36:21.
 *
 * @author fredzhu (kuci@mbaobao.com)
 * @version v1.0 2012-09-10 22:36:21 $
 */
public class User implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1L;

	//========== properties ==========
	
	private Integer id;
	private String username;
	private String flowerName;
	private String password;
	private String phone;
	private String roleIds;
	private String appIds;
	private Integer isLock;
	private Integer isDel;
	private String addUser;
	private String lastLoginIp;
	private Date lastLoginTime;
	private Date createTime;
	private Date updateTime;

    //========== getters and setters ==========
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFlowerName() {
		return flowerName;
	}
	
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoleIds() {
		return roleIds;
	}
	
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getAppIds() {
		return appIds;
	}
	
	public void setAppIds(String appIds) {
		this.appIds = appIds;
	}
	public Integer getIsLock() {
		return isLock;
	}
	
	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}
	public Integer getIsDel() {
		return isDel;
	}
	
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public String getAddUser() {
		return addUser;
	}
	
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	* 重载toString方法
	* @return
	*
	* @see java.lang.Object#toString()
	*/
	@Override
    public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

