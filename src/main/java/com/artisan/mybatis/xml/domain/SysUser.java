package com.artisan.mybatis.xml.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 
 * 
 * @ClassName: SysUser
 * 
 * @Description: 用户表
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月13日 下午9:24:21
 */
public class SysUser implements Serializable {

	private static final long serialVersionUID = 5736486618394472355L;

	/**
	 * 用户ID
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String userPassword;

	/**
	 * 邮箱
	 */
	private String userEmail;

	/**
	 * 简介
	 */
	private String userInfo;

	/**
	 * 头像
	 */
	private byte[] headImg;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 用户角色: 一个用户拥有一个角色 ， 一对一
	 */
	private SysRole sysRole;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public byte[] getHeadImg() {
		return headImg;
	}

	public void setHeadImg(byte[] headImg) {
		this.headImg = headImg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail=" + userEmail + ", userInfo=" + userInfo + ", headImg=" + Arrays.toString(headImg)
				+ ", createTime=" + createTime + ", sysRole=" + sysRole + "]";
	}


}
