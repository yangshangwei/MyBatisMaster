package com.artisan.mybatis.xml.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.artisan.mybatis.xml.domain.SysRole;
import com.artisan.mybatis.xml.domain.SysUser;

/**
 * 
 * 
 * @ClassName: UserMapperTest
 * 
 * @Description: UserMapperTest 单元测试类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月14日 下午1:59:31
 */
public class UserMapperTest extends BaseMapperTest {

	private static Logger logger = Logger.getLogger(UserMapperTest.class);

	@Test
	public void selectSysUserByIdTest() {
		logger.info("selectSysUserByIdTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectSysUserById方法，查询id=1的用户
			SysUser sysUser = userMapper.selectSysUserById((long) 1);
			// sysUser不为空
			Assert.assertNotNull(sysUser);
			// userName = "admin"
			Assert.assertEquals("admin", sysUser.getUserName());
			logger.info(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void selectAllTest() {
		logger.info("selectAllTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectAll,查询全部用户
			List<SysUser> userList = userMapper.selectAll();
			// 结果不为空
			Assert.assertNotNull(userList);
			// 结果大于0
			Assert.assertTrue(userList.size() > 0);

			logger.info("userList总数为:" + userList.size());
			for (SysUser sysUser : userList) {
				logger.info(sysUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void selectUserByIdUseMapUnderscoreToCamelCaseTest() {
		logger.info("selectUserByIdUseMapUnderscoreToCamelCaseTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectSysUserById方法，查询id=1的用户
			SysUser sysUser = userMapper.selectUserByIdUseMapUnderscoreToCamelCase((long) 1001);
			// sysUser不为空
			Assert.assertNotNull(sysUser);
			// userName = "admin"
			Assert.assertEquals("test", sysUser.getUserName());
			logger.info(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void selectRoleListByUserIdTest() {
		logger.info("selectRoleListByUserIdTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectRoleListByUserId方法，查询用户id=1的角色
			List<SysRole> roleList = userMapper.selectRoleListByUserId((long) 1);
			// roleList不为空
			Assert.assertNotNull(roleList);
			// roleList > 0
			Assert.assertTrue(roleList.size() > 0);

			logger.info(roleList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void selectRoleListByUserIdMoreInfoTest() {
		logger.info("selectRoleListByUserIdMoreInfoTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectRoleListByUserId方法，查询用户id=1的角色
			List<SysRole> roleList = userMapper.selectRoleListByUserIdMoreInfo((long) 1);
			// roleList不为空
			Assert.assertNotNull(roleList);
			// roleList > 0
			Assert.assertTrue(roleList.size() > 0);

			logger.info(roleList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}
}
