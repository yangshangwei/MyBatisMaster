package com.artisan.mybatis.xml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.artisan.mybatis.xml.domain.SysRole;

public interface UserRoleMapper {

	/**
	 * 
	 * 
	 * @Title: selectSysRolesByUserIdAndRoleEnable
	 * 
	 * @Description: 根据用户ID和角色的Enable属性查询角色
	 * 
	 * @param userId
	 * @param enable
	 * @return
	 * 
	 * @return: List<SysRole>
	 */
	List<SysRole> selectSysRolesByUserIdAndRoleEnable(@Param("userId") Long userId, @Param("enable") Integer enable);


}
