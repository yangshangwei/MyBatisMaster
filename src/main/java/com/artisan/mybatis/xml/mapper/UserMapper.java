package com.artisan.mybatis.xml.mapper;

import java.util.List;

import com.artisan.mybatis.xml.domain.SysRole;
import com.artisan.mybatis.xml.domain.SysUser;

public interface UserMapper {
	/**
	 * 
	 * 
	 * @Title: selectSysUserById
	 * 
	 * @Description: 通过ID查询系统用户
	 * 
	 * @param id
	 * @return
	 * 
	 * @return: SysUser
	 */
	SysUser selectSysUserById(Long id);

	// 仅仅是为了测试mapUnderscoreToCamelCase 全局属性
	SysUser selectUserByIdUseMapUnderscoreToCamelCase(Long id);

	/**
	 * 
	 * 
	 * @Title: selectAll
	 * 
	 * @Description: 查询全部的SysUser
	 * 
	 * @return
	 * 
	 * @return: List<SysUser>
	 */
	List<SysUser> selectAll();

	/**
	 * 
	 * 
	 * @Title: selectRoleByUserId
	 * 
	 * @Description: 根据用户ID查询用户角色
	 * 
	 * @param userId
	 * @return
	 * 
	 * @return: List<SysRole>
	 */
	List<SysRole> selectRoleListByUserId(Long userId);

	// 为了测试返回sysuser中的部分信息
	List<SysRole> selectRoleListByUserIdMoreInfo(Long userId);

	/**
	 * 
	 * 
	 * @Title: insertSysUser
	 * 
	 * @Description: 增加SysUser
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: int 受影响的行数
	 */
	int insertSysUser(SysUser sysUser);
}
