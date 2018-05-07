package com.artisan.mybatis.xml.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.artisan.mybatis.xml.domain.SysRole;

/**
 * 
 * 
 * @ClassName: RoleMapper
 * 
 * @Description: 这里通过注解的方式演示用法，一般情况下不推荐使用注解的方式
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月17日 下午8:34:54
 */
public interface RoleMapper {
	/**
	 * 
	 * 
	 * @Title: selectSysRoleById
	 * 
	 * @Description: 采用数据库字段别名和实体类属性同名的方式映射
	 * 
	 * @param roleId
	 * @return
	 * 
	 * @return: SysRole
	 */
	
	@Select({ "SELECT "
				+ " a.id, "
				+ " a.role_name roleName, "
				+ " a.enabled, "
				+ " a.create_by createBy, "
				+ " a.create_time createTime "
			+ " FROM "
				+ " sys_role a "
			+ " WHERE "
			+ " a.id = #{roleId}" })
	SysRole selectSysRoleById(Long roleId);
			
	
	/**
	 * 
	 * 
	 * @Title: selectSysRoleById2
	 * 
	 * @Description: 采用 MyBatis全局配置文件设置 mapUnderscoreToCamelCase 映射
	 *               通过配置这个属性为true可以自动将下画线方式命名的数据库列映射到java对象驼峰式命名属性中
	 * 
	 * @param roleId
	 * @return
	 * 
	 * @return: SysRole
	 */
	@Select({ "SELECT "
			+ " a.id, "
			+ " a.role_name , "
			+ " a.enabled, "
			+ " a.create_by , "
			+ " a.create_time "
		+ " FROM "
			+ " sys_role a "
		+ " WHERE "
		+ " a.id = #{roleId}" })
	SysRole selectSysRoleById2(Long roleId);
	
	
	
	
	/**
	 * 
	 * 
	 * @Title: selectSysRoleById3
	 * 
	 * @Description: 通过ResultMap的方式实现数据库列到java对象的映射
	 * 
	 * @param roleId
	 * @return
	 * 
	 * @return: SysRole
	 */

	@Results(id = "roleResultMap", value ={ 
		@Result(property = "id", column = "id", id = true),
 @Result(property = "roleName", column = "role_name"), @Result(property = "enabled", column = "enabled"),
			@Result(property = "createBy", column = "create_by"), @Result(property = "createTime", column = "create_time")
	})
	@Select({ "SELECT "
			+ " a.id, "
			+ " a.role_name , "
			+ " a.enabled, "
			+ " a.create_by , "
			+ " a.create_time "
		+ " FROM "
			+ " sys_role a "
		+ " WHERE "
		+ " a.id = #{roleId}" })
	SysRole selectSysRoleById3(Long roleId);


	/**
	 * 
	 * 
	 * @Title: selectSysRoleById4
	 * 
	 * @Description: 通过改方法演示在mybatis3.3.1版本及其之后的版本 通过@ResultMap应用带有id的@Results
	 * 
	 * @param roleId
	 * @return
	 * 
	 * @return: SysRole
	 */

	@ResultMap("roleResultMap")
	@Select({
 "SELECT  a.id, a.role_name,  a.enabled, a.create_by ,  a.create_time  FROM  sys_role a " })
	List<SysRole> selectAllSysRole();

	/**
	 * 
	 * 
	 * @Title: insertSysRole
	 * 
	 * @Description: insertSysRole 不需要返回主键的情况
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @return: int
	 */
	@Insert({ "insert into sys_role(id, role_name, enabled, create_by, create_time) values(#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})" })
	int insertSysRole(SysRole sysRole);

	/**
	 * 
	 * 
	 * @Title: insertSysRole2
	 * 
	 * @Description: insertSysRole2 返回自增主键的情况
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @return: int
	 */
	@Insert({ "insert into sys_role(role_name, enabled, create_by, create_time) values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})" })
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insertSysRole2(SysRole sysRole);

	/**
	 * 
	 * 
	 * @Title: insertSysRole3
	 * 
	 * @Description: insertSysRole3 返回非自增主键的情况
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @return: int
	 */
	@Insert({ "insert into sys_role(role_name, enabled, create_by, create_time) values(#{roleName}, #{enabled}, #{createBy}, #{createTime, jdbcType=TIMESTAMP})" })
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", resultType = Long.class, before = false)
	int insertSysRole3(SysRole sysRole);

	/**
	 * 
	 * 
	 * @Title: updateSysRoleById
	 * 
	 * @Description: updateSysRoleById
	 * 
	 * @param sysRole
	 * @return
	 * 
	 * @return: int
	 */
	@Update({ "update sys_role set role_name = #{roleName},enabled = #{enabled},create_by = #{createBy},create_time = #{createTime, jdbcType=TIMESTAMP} where id = #{id}" })
	int updateSysRoleById(SysRole sysRole);

	/**
	 * 
	 * 
	 * @Title: deleteSysRoleById
	 * 
	 * @Description: deleteSysRoleById
	 * 
	 * @param id
	 * @return
	 * 
	 * @return: int
	 */
	@Delete("delete from sys_role where id = #{id}")
	int deleteSysRoleById(Long id);

	/**
	 * 
	 * 
	 * @Title: selectAllRoleAndPrivileges
	 * 
	 * @Description: 查询全部角色对应的权限
	 * 
	 * @return
	 * 
	 * @return: List<SysRole>
	 */
	List<SysRole> selectAllRoleAndPrivileges();

}	
