package com.artisan.mybatis.xml.domain;

import java.io.Serializable;

/**
 * 
 * 
 * @ClassName: SysRoleExtend
 * 
 * @Description: SysRole的扩展类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月15日 下午4:57:02
 */
public class SysRoleExtend implements Serializable {

	private static final long serialVersionUID = 3623672805974283816L;

	private String userName;
	private String userEmail;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
