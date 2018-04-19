package com.artisan.mybatis.xml.provider;

import org.apache.ibatis.jdbc.SQL;


/**
 * 
 * 
 * @ClassName: PrivilegeProvider
 * 
 * @Description: 权限Mapper对应的Provider实现
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月19日 上午3:30:41
 */
public class PrivilegeProvider {

	/**
	 * 
	 * 
	 * @Title: selectSysPrivilegeById
	 * 
	 * @Description: 记得数据库字段和Java实体类属性映射，否则取出的来的是null
	 * 
	 * @param id
	 * @return
	 * 
	 * @return: String
	 */
	public String selectSysPrivilegeById(Long id) {
		// 第一种写法
		// return
		// "SELECT id, privilege_name privilegeName, privilege_url privilegeUrl FROM  sys_privilege  WHERE id = #{id} ";

		// 第二种写法
		return new SQL() {
			{
				SELECT("id, privilege_name privilegeName, privilege_url privilegeUrl");
				FROM("sys_privilege");
				WHERE("id = #{id}");
			}
		}.toString();

	}

}
