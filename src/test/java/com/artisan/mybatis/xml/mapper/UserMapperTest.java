package com.artisan.mybatis.xml.mapper;

import java.util.Date;
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

	@Test
	public void insertSysUserTest() {
		logger.info("insertSysUserTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("artisanTest");
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("test@artisan.com");
			sysUser.setUserInfo("测试用户");
			// 模拟头像
			sysUser.setHeadImg(new byte[] { 1, 2, 3 });
			sysUser.setCreateTime(new Date());
			// 新增用户 ,返回受影响的行数
			int result = userMapper.insertSysUser(sysUser);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			// id 为null , 因为没有给ID赋值，也没有配置回写id的值 ，期望是null
			Assert.assertNull(sysUser.getId());

			logger.info("受影响的行数:" + result);
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
	public void insertSysUser2Test() {
		logger.info("insertSysUser2Test");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("artisanTest");
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("test@artisan.com");
			sysUser.setUserInfo("测试用户");
			// 模拟头像
			sysUser.setHeadImg(new byte[] { 1, 2, 3 });
			sysUser.setCreateTime(new Date());
			// 新增用户 ,返回受影响的行数
			int result = userMapper.insertSysUser2(sysUser);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			// id不为null ,因为使用了 useGeneratedKeys="true" keyProperty="id"
			Assert.assertNotNull(sysUser.getId());

			logger.info("受影响的行数:" + result);
			logger.info("userId:" + sysUser.getId());
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
	public void insertSysUser3Test() {
		logger.info("insertSysUser3Test");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			SysUser sysUser = new SysUser();
			sysUser.setUserName("artisanTest");
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("test@artisan.com");
			sysUser.setUserInfo("测试用户");
			// 模拟头像
			sysUser.setHeadImg(new byte[] { 1, 2, 3 });
			sysUser.setCreateTime(new Date());
			// 新增用户 ,返回受影响的行数
			int result = userMapper.insertSysUser3(sysUser);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			// id不为null ,因为使用了 useGeneratedKeys="true" keyProperty="id"
			Assert.assertNotNull(sysUser.getId());

			logger.info("受影响的行数:" + result);
			logger.info("userId:" + sysUser.getId());
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
	public void updateSysUserByIdTest() {
		logger.info("updateSysUserByIdTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			// 先根据ID查询出对应的sysuser
			SysUser sysUser = userMapper.selectSysUserById((long) 1);
			// 当前数据库用户的userName期望为admin
			Assert.assertEquals("admin", sysUser.getUserName());

			// 修改用户名
			sysUser.setUserName("adminUpdated");
			// 修改邮件
			sysUser.setUserEmail("updateSysUser@artisan.com");
			// 修改用户 ,返回受影响的行数
			int result = userMapper.updateSysUserById(sysUser);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			logger.info("受影响的行数:" + result);

			logger.info("userName:" + sysUser.getUserName() + ",userEmail:" + sysUser.getUserEmail());

			// 期望的用户名为adminUpdated
			Assert.assertEquals("adminUpdated", sysUser.getUserName());
			// 期望的邮箱为updateSysUser@artisan.com
			Assert.assertEquals("updateSysUser@artisan.com", sysUser.getUserEmail());
			
			
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
	public void deleteSysUserByIdTest() {
		logger.info("deleteSysUserByIdTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			// 调用删除接口
			int result = userMapper.deleteSysUserById((long) 1);
			// 期望影响的结果条数为 1
			Assert.assertEquals(1, result);

			// 再次查询
			SysUser sysUser = userMapper.selectSysUserById((long) 1);
			// 期望查询出来的sysUser 为 null
			Assert.assertNull(sysUser);
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

