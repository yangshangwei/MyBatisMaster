package com.artisan.mybatis.xml.domain;

import java.io.Serializable;

/**
 * 
 * 
 * @ClassName: SysPrivilege
 * 
 * @Description: 权限表
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月13日 下午9:45:15
 */
public class SysPrivilege implements Serializable {

	private static final long serialVersionUID = 6315662516417216377L;
	/**
	 * 权限ID
	 */
	private Long id;
	/**
	 * 权限名称
	 */
	private String privilegeName;
	/**
	 * 权限URL
	 */
	private String privilegeUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public String getPrivilegeUrl() {
		return privilegeUrl;
	}

	public void setPrivilegeUrl(String privilegeUrl) {
		this.privilegeUrl = privilegeUrl;
	}

	@Override
	public String toString() {
		return "SysPrivilege [id=" + id + ", privilegeName=" + privilegeName + ", privilegeUrl=" + privilegeUrl + "]";
	}

}
