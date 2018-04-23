package com.artisan.mybatis.xml.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	 * @return: int 受影响的行数 ，这里仅仅是为了做记录，void在实际业务中更常用
	 */
	int insertSysUser(SysUser sysUser);

	// 演示使用JDBC方式返回主键的自增长值
	int insertSysUser2(SysUser sysUser);

	// 演示使用selectKey的方式返回主键的自增长值
	int insertSysUser3(SysUser sysUser);

	/**
	 * 
	 * 
	 * @Title: updateSysUserById
	 * 
	 * @Description: 修改SysUser
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: int 受影响的行数,这里仅仅是为了做记录，void在实际业务中更常用
	 */
	int updateSysUserById(SysUser sysUser);

	/**
	 * 
	 * 
	 * @Title: deleteSysUserById
	 * 
	 * @Description: 根据ID删除sysuser
	 * 
	 * @param id
	 * @return
	 * 
	 * @return: int
	 */
	int deleteSysUserById(Long id);

	// 动态SQL if BEGIN

	/**
	 * 
	 * 
	 * @Title: selectSysUsersAdvanced
	 * 
	 * @Description: 根据动态条件查询用户信息
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: List<SysUser>
	 */
	List<SysUser> selectSysUsersAdvanced(SysUser sysUser);

	/**
	 * 
	 * 
	 * @Title: updateSysUserByIdSelective
	 * 
	 * @Description: 根据主键更新SysUser
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: int
	 */
	int updateSysUserByIdSelective(SysUser sysUser);

	/**
	 * 
	 * 
	 * @Title: insertSysUserDyn
	 * 
	 * @Description: insertSysUserDyn
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: int
	 */
	int insertSysUserDyn(SysUser sysUser);

	// 动态SQLif END

	// 动态SQL choose BEGIN
	/**
	 * 
	 * 
	 * @Title: selectSysUserByIdOrByUserName
	 * 
	 * @Description: 根据用户id或者用户名查询用户
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: SysUser
	 */
	SysUser selectSysUserByIdOrByUserName(SysUser sysUser);

	// 动态sql choose END

	// 动态SQL where set BEGIN

	/**
	 * 
	 * 
	 * @Title: selectSysUsersAdvancedWithWhere
	 * 
	 * @Description: selectSysUsersAdvancedWithWhere
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: List<SysUser>
	 */
	List<SysUser> selectSysUsersAdvancedWithWhere(SysUser sysUser);

	/**
	 * 
	 * 
	 * @Title: updateSysUserByIdWithSetSelective
	 * 
	 * @Description: 根据主键更新SysUser
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: int
	 */
	int updateSysUserByIdWithSetSelective(SysUser sysUser);

	// 动态SQL where set END

	// 动态SQL foreach实现in集合 BEGIN

	/**
	 * 
	 * 
	 * @Title: selectSysUserByIdList
	 * 
	 * @Description: 根据用户ID集合查询用户
	 * 
	 * @param ids
	 * @return
	 * 
	 * @return: List<SysUser>
	 */
	List<SysUser> selectSysUserByIdList(List<Long> ids);

	// 动态SQL foreach实现in集合 END

	// 动态SQL foreach实现批量 insert BEGIN（仅部分数据库支持）
	/**
	 * 
	 * 
	 * @Title: insertSysUserList
	 * 
	 * @Description: 批量新增用户
	 * 
	 * @param sysUserList
	 * @return
	 * 
	 * @return: int
	 */
	int insertSysUserList(List<SysUser> sysUserList);

	// 动态SQL foreach实现批量 insert END（仅部分数据库支持）

	// 动态SQL foreach实现动态update
	/**
	 * 
	 * 
	 * @Title: updateSysUserByMap
	 * 
	 * @Description: updateSysUserByMap
	 * 
	 * @param sysUser
	 * @return
	 * 
	 * @return: void
	 */
	void updateSysUserByMap(Map<String, Object> map);

	void updateSysUserByMapWithParam(@Param("userMap") Map<String, Object> map);
	// 动态SQL foreach实现动态update

}
