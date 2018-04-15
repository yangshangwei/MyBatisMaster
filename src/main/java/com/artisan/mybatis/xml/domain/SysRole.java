package com.artisan.mybatis.xml.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @ClassName: SysRole
 * 
 * @Description: 角色表
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月13日 下午9:29:31
 */
public class SysRole implements Serializable {
	private static final long serialVersionUID = 6320941908222932112L;
	/**
	 * 角色ID
	 */
	private Long id;
	/**
	 * 角色名
	 */
	private String roleName;
	/**
	 * 有效标志
	 */
	private Integer enabled;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 创建时间
	 */
	private Date createTime;


	/**
	 * 用户信息
	 */
	private SysUser user;

	/**
	 * 角色包含的权限列表
	 */
	List<SysPrivilege> privilegeList;



	/**
	 * 
	 * Setter/Getter
	 *
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}


	public List<SysPrivilege> getPrivilegeList() {
		return privilegeList;
	}

	public void setPrivilegeList(List<SysPrivilege> privilegeList) {
		this.privilegeList = privilegeList;
	}

	@Override
	public String toString() {
		return "SysRole [id=" + id + ", roleName=" + roleName + ", enabled=" + enabled + ", createBy=" + createBy + ", createTime=" + createTime + ", user=" + user + ", privilegeList="
				+ privilegeList + "]";
	}


}
