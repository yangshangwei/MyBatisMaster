package com.artisan.mybatis.xml.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.artisan.mybatis.xml.domain.SysPrivilege;

public class PrivilegeMapperTest extends BaseMapperTest {

	private static final Logger logger = Logger.getLogger(PrivilegeMapperTest.class);

	@Test
	public void selectSysPrivilegeByIdTest() {
		SqlSession sqlSession = null;
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

	@Test
	public void selectPrivilegeByIdWithCacheTest() {
		logger.info("selectPrivilegeByIdWithCacheTest");
		SqlSession sqlSession =  getSqlSession();
		SysPrivilege sysPrivilege = null;
		try {
			// 获取接口
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			// 调用接口方法
			sysPrivilege = privilegeMapper.selectPrivilegeByIdWithCache(1L);
			sysPrivilege.setPrivilegeName("New Priv");
			// 再次调用相同的接口方法，查询相同的用户
			logger.info("再次调用相同的接口方法，查询相同的用户 Begin");
			SysPrivilege sysPrivilege2 = privilegeMapper.selectPrivilegeByIdWithCache(1L);
			logger.info("再次调用相同的接口方法，查询相同的用户 End");
			// 一级缓存在同一个sqlSession中，虽然没有更新数据库，但是会使用一级缓存
			Assert.assertEquals("New Priv", sysPrivilege2.getPrivilegeName());
			// sysPrivilege 和 sysPrivilege2 是同一个实例
			Assert.assertEquals(sysPrivilege, sysPrivilege2);
		} finally {
			// sqlSession关闭后，在二级缓存开启的前提下,会写入二级缓存
			sqlSession.close();
		}

		logger.info("重新获取一个SqlSession");
		sqlSession = getSqlSession();
		try {
			// 获取接口
			PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
			// 调用接口方法
			SysPrivilege sysPrivilege2 = privilegeMapper.selectPrivilegeByIdWithCache(1L);
			sysPrivilege.setPrivilegeName("New Priv");
			// 第二个session获取的权限名为 New Priv
			Assert.assertEquals("New Priv", sysPrivilege2.getPrivilegeName());
			// 这里的sysPrivilege2 和 前一个session中的sysPrivilege不是同一个实例
			Assert.assertNotEquals(sysPrivilege, sysPrivilege2);

			// 获取sysPrivilege3
			SysPrivilege sysPrivilege3 = privilegeMapper.selectPrivilegeByIdWithCache(1L);
			// 这里的sysPrivilege2 和sysPrivilege3是两个不同的实例
			Assert.assertNotEquals(sysPrivilege2, sysPrivilege3);
		} finally {
			// sqlSession关闭后，在二级缓存开启的前提下,会写入二级缓存
			sqlSession.close();
		}

	}
}
