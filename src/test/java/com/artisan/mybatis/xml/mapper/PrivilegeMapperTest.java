package com.artisan.mybatis.xml.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.artisan.mybatis.xml.domain.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest {

	private static final Logger logger = Logger.getLogger(PrivilegeMapperTest.class);

	SqlSession sqlSession;

	@Test
	public void selectSysPrivilegeByIdTest() {

		logger.info("selectSysPrivilegeByIdTest");
		try {
			// 获取SqlSession
			sqlSession = getSqlSession();
			// 获取接口
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			// 调用接口方法
			SysPrivilege sysPrivilege = privilegeMapper.selectSysPrivilegeById((long) 1);
			// 期待不为空
			Assert.assertNotNull(sysPrivilege);
			// 期望为PrivilegeName为"用户管理"
			Assert.assertEquals("用户管理", sysPrivilege.getPrivilegeName());

			logger.info("sysPrivilege Info:" + sysPrivilege);
		} finally {
			sqlSession.close();
		}
	}

}
