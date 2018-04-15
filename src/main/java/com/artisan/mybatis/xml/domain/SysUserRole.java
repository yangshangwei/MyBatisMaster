package com.artisan.mybatis.xml.domain;

/**
 * 
 * 
 * @ClassName: SysUserRole
 * 
 * @Description: 用户角色关联表
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月13日 下午9:44:31
 */
public class SysUserRole {
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 角色ID
	 */
	private Long roleId;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SysUserRole [userId=" + userId + ", roleId=" + roleId + "]";
	}

}
