package com.artisan.mybatis.xml.domain;

/**
 * 
 * 
 * @ClassName: SysRolePrivilege
 * 
 * @Description: 角色权限关联表
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月13日 下午9:46:46
 */
public class SysRolePrivilege {
	/**
	 * 角色ID
	 */
	private Long roleId;
	/**
	 * 权限ID
	 */
	private Long privilegeId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}

	@Override
	public String toString() {
		return "SysRolePrivilege [roleId=" + roleId + ", privilegeId=" + privilegeId + "]";
	}

}
