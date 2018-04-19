package com.artisan.mybatis.xml.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.artisan.mybatis.xml.domain.SysRole;

public class RoleMapperTest extends BaseMapperTest {

	private static final Logger logger = Logger.getLogger(RoleMapperTest.class);

	SqlSession sqlSession;

	@Test
	public void selectSysRoleByIdTest() {

		logger.info("selectSysRoleByIdTest");
		try {
			// 获取SqlSession
			sqlSession = getSqlSession();
			// 获取接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			// 调用接口方法
			SysRole sysRole = roleMapper.selectSysRoleById((long) 1);
			// 期待不为空
			Assert.assertNotNull(sysRole);
			// 期望为 roleName="管理员"
			Assert.assertEquals("管理员", sysRole.getRoleName());

			logger.info("sysRole Info:" + sysRole);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 
	 * 
	 * @Title: selectSysRoleByIdTest2
	 * 
	 * @Description: 测试的时候需要将 <setting name="mapUnderscoreToCamelCase"
	 *               value="true"/> 放开
	 * 
	 * 
	 * @return: void
	 */
	@Test
	public void selectSysRoleByIdTest2() {
		logger.info("selectSysRoleByIdTest2");
		try {
			// 获取SqlSession
			sqlSession = getSqlSession();
			// 获取接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			// 调用接口方法
			SysRole sysRole = roleMapper.selectSysRoleById2((long) 2);
			// 期待不为空
			Assert.assertNotNull(sysRole);
			// 期望为 roleName="普通用户"
			Assert.assertEquals("普通用户", sysRole.getRoleName());

			logger.info("sysRole Info:" + sysRole);
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void selectSysRoleByIdTest3() {
		logger.info("selectSysRoleByIdTest3");
		try {
			// 获取SqlSession
			sqlSession = getSqlSession();
			// 获取接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			// 调用接口方法
			SysRole sysRole = roleMapper.selectSysRoleById3((long) 2);
			// 期待不为空
			Assert.assertNotNull(sysRole);
			// 期望为 roleName="普通用户"
			Assert.assertEquals("普通用户", sysRole.getRoleName());

			logger.info("sysRole Info:" + sysRole);
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void selectAllSysTest() {
		logger.info("selectAllSysTest");
		try {
			// 获取SqlSession
			sqlSession = getSqlSession();
			// 获取接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			// 调用接口方法
			List<SysRole> sysRoleList = roleMapper.selectAllSysRole();
			// 期待不为空
			Assert.assertNotNull(sysRoleList);
			// 期望为sysRoleList > 0
			Assert.assertTrue(sysRoleList.size() > 0);

			for (SysRole sysRole2 : sysRoleList) {
				logger.info("sysRole Info:" + sysRole2);
			}

		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void insertSysRoleTest() {
		logger.info("insertSysRoleTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取RoleMapper接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = new SysRole();
			sysRole.setId((long) 99);
			sysRole.setRoleName("小工匠");
			sysRole.setEnabled(1);
			sysRole.setCreateBy("test");
			sysRole.setCreateTime(new Date());
			// 新增用户 ,返回受影响的行数
			int result = roleMapper.insertSysRole(sysRole);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			// 期望roleName 为小工匠
			Assert.assertEquals("小工匠", sysRole.getRoleName());

			logger.info("sysRole:" + sysRole);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 为了保持测试数据的干净，这里选择回滚
			// 由于默认的sqlSessionFactory.openSession()是不自动提交的
			// 除非显式的commit，否则不会提交到数据库
			sqlSession.rollback();
			logger.info("为了保持测试数据的干净，这里选择回滚,不写入mysql,请观察日志，回滚完成");

			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void insertSysRoleTest2() {
		logger.info("insertSysRoleTest2");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取RoleMapper接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = new SysRole();
			sysRole.setRoleName("小工匠2");
			sysRole.setEnabled(1);
			sysRole.setCreateBy("test2");
			sysRole.setCreateTime(new Date());
			// 新增用户 ,返回受影响的行数
			int result = roleMapper.insertSysRole2(sysRole);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			// 期望roleName 为小工匠
			Assert.assertEquals("小工匠2", sysRole.getRoleName());

			logger.info("sysRole:" + sysRole);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 为了保持测试数据的干净，这里选择回滚
			// 由于默认的sqlSessionFactory.openSession()是不自动提交的
			// 除非显式的commit，否则不会提交到数据库
			sqlSession.rollback();
			logger.info("为了保持测试数据的干净，这里选择回滚,不写入mysql,请观察日志，回滚完成");

			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void insertSysRoleTest3() {
		logger.info("insertSysRoleTest3");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取RoleMapper接口
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			SysRole sysRole = new SysRole();
			sysRole.setRoleName("小工匠3");
			sysRole.setEnabled(1);
			sysRole.setCreateBy("test3");
			sysRole.setCreateTime(new Date());
			// 新增用户 ,返回受影响的行数
			int result = roleMapper.insertSysRole3(sysRole);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			// 期望roleName 为小工匠
			Assert.assertEquals("小工匠3", sysRole.getRoleName());

			logger.info("sysRole:" + sysRole);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 为了保持测试数据的干净，这里选择回滚
			// 由于默认的sqlSessionFactory.openSession()是不自动提交的
			// 除非显式的commit，否则不会提交到数据库
			sqlSession.rollback();
			logger.info("为了保持测试数据的干净，这里选择回滚,不写入mysql,请观察日志，回滚完成");

			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}
}
