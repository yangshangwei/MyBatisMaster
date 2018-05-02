package com.artisan.mybatis.xml.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	
	// 动态SQL if BEGIN

	@Test
	public void selectSysUsersAdvancedTest() {
		logger.info("selectSysUsersAdvanced");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		List<SysUser> userList = null;
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			logger.info("===========1.当用户只输入用户名时，需要根据用户名模糊查询===========");
			// 模拟前台传参 1.当用户只输入用户名时，需要根据用户名模糊查询
			SysUser sysUser = new SysUser();
			sysUser.setUserName("ad");
			// 调用selectSysUsersAdvanced,根据查询条件查询用户
			userList = userMapper.selectSysUsersAdvanced(sysUser);
			// 根据数据库sys_user表中的记录,可以匹配到admin, 期望userList不为空
			Assert.assertNotNull(userList);
			// 根据查询条件，期望只有1条数据
			Assert.assertTrue(userList.size() == 1);
			logger.info("userList:" + userList);
					
			// 为了测试 匹配多条记录的情况，我们将id=1001这条数据的userName 由test 改为artisan
			sysUser.setUserName("i");
			// 调用selectSysUsersAdvanced,根据查询条件查询用户
			userList = userMapper.selectSysUsersAdvanced(sysUser);
			// 根据数据库sys_user表中的记录,可以匹配到admin和artisan, 期望userList不为空
			Assert.assertNotNull(userList);
			// 根据查询条件，期望只有2条数据
			Assert.assertTrue(userList.size() == 2);

			logger.info("userList:" + userList);
			
			logger.info("===========2.当用户只输入邮箱使，根据邮箱进行完全匹配===========");
			// 模拟前台传参 2.当用户只输入邮箱使，根据邮箱进行完全匹配
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvanced(sysUser);
			Assert.assertNotNull(userList);
			Assert.assertTrue(userList.size() == 1);
			logger.info(userList);

			sysUser.setUserEmail("1admin@artisan.com");
			userList = userMapper.selectSysUsersAdvanced(sysUser);
			Assert.assertTrue(userList.size() == 0);

			logger.info("===========3.当用户同时输入用户名和密码时，用这两个条件查询匹配的用户===========");

			// 模拟组合查询条件,存在记录的情况
			sysUser.setUserName("i");
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvanced(sysUser);
			Assert.assertNotNull(userList);
			Assert.assertEquals("admin@artisan.com", sysUser.getUserEmail());
			Assert.assertTrue(userList.size() == 1);
			logger.info(userList);

			logger.info("===========4.当用户同时输入无法匹配的用户名和密码===========");
			// 模拟组合查询条件,不存在记录的情况
			sysUser.setUserName("x");
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvanced(sysUser);
			Assert.assertTrue(userList.size() == 0);
			logger.info(userList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	
	@Test
	public void updateSysUserByIdSelectiveTest() {
		logger.info("updateSysUserByIdSelectiveTest");
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
			sysUser.setUserName("dynamicUpdate");
			// 修改邮件
			sysUser.setUserEmail("dynamicUpdate@artisan.com");
			// 修改用户 ,返回受影响的行数
			int result = userMapper.updateSysUserByIdSelective(sysUser);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			logger.info("受影响的行数:" + result);

			// 重新查询（虽然未提交但是在一个会话中）
			sysUser = userMapper.selectSysUserById((long) 1);
			// 期望的用户名为dynamicUpdate
			Assert.assertEquals("dynamicUpdate", sysUser.getUserName());
			// 期望的邮箱为dynamicUpdate@artisan.com
			Assert.assertEquals("dynamicUpdate@artisan.com", sysUser.getUserEmail());

			// 检查其他字段有没有被更新为null 或者 空值
			Assert.assertEquals("123456", sysUser.getUserPassword());
			Assert.assertEquals("管理员用户", sysUser.getUserInfo());
			logger.info(sysUser);

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
	public void insertSysUserDynTest() {
		logger.info("insertSysUserDynTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			logger.info("=========不设置email=========");
			// 不设置userEmail ，观察是否能够插入默认的email
			SysUser sysUser = new SysUser();
			sysUser.setUserName("artisanTest");
			sysUser.setUserPassword("123456");
			sysUser.setUserInfo("测试用户");
			// 模拟头像
			sysUser.setHeadImg(new byte[] { 1, 2, 3 });
			sysUser.setCreateTime(new Date());
			// 新增用户 ,返回受影响的行数
			int result = userMapper.insertSysUserDyn(sysUser);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);

			// 获取这条新插入的sysUser
			sysUser = userMapper.selectSysUserById(sysUser.getId());
			// 没有设置userEmail ,期望是数据库的默认值
			Assert.assertEquals("default@artisan.com", sysUser.getUserEmail());
			logger.info(sysUser);

			logger.info("=========设置email=========");
			// 设置email
			sysUser.setUserName("artisanTest");
			sysUser.setUserPassword("123456");
			sysUser.setUserEmail("artisan@artisan.com");
			sysUser.setUserInfo("测试用户");
			// 模拟头像
			sysUser.setHeadImg(new byte[] { 1, 2, 3 });
			sysUser.setCreateTime(new Date());
			result = userMapper.insertSysUserDyn(sysUser);

			// 获取这条新插入的sysUser
			sysUser = userMapper.selectSysUserById(sysUser.getId());
			// 有设置userEmail ,期望是传入的值
			Assert.assertEquals("artisan@artisan.com", sysUser.getUserEmail());
			logger.info(sysUser);
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


	// 动态SQL if END
	
	// 动态SQL choose when otherwise BEGIN
	@Test
	public void selectSysUserByIdOrByUserNameTest() {
		logger.info("selectSysUserByIdOrByUserNameTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			logger.info("======. 模拟传入了正确的id 没有传username或者传入了错误的userName======");
			// 1. 模拟传入了正确的id 没有传username或者传入了错误的userName
			SysUser sysUser = new SysUser();
			sysUser.setId(1001L);
			sysUser.setUserName("noExistName");
			// 调用selectSysUserByIdOrByUserName,查询单个用户
			SysUser user = userMapper.selectSysUserByIdOrByUserName(sysUser);
			// 期望不为空
			Assert.assertNotNull(user);
			// userName 期望值为artisan
			Assert.assertEquals("artisan", user.getUserName());
			logger.info(user);

			logger.info("======2. 模拟不传id,但是传入了正确的 userName======");
			// 2. 模拟不传id,但是传入了正确的 userName
			sysUser = new SysUser();
			sysUser.setId(null);
			sysUser.setUserName("admin");
			user = userMapper.selectSysUserByIdOrByUserName(sysUser);
			// 期望不为空
			Assert.assertNotNull(user);
			// 根据id查询 sysuser,然后获取userName 期望值为artisan
			Assert.assertEquals("admin", user.getUserName());
			logger.info(user);

			logger.info("======3.什么都不传======");
			// 2. 模拟不传id,但是传入了正确的 userName
			sysUser = new SysUser();
			sysUser.setId(null);
			sysUser.setUserName(null);
			user = userMapper.selectSysUserByIdOrByUserName(sysUser);
			// 期望为空
			Assert.assertNull(user);
			logger.info(user);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
		
	}
	
	// 动态SQL choose when otherwise END
	
	// 动态SQL where set trim BEGIN
	@Test
	public void selectSysUsersAdvancedWithWhere() {
		logger.info("selectSysUsersAdvancedWithWhere");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		List<SysUser> userList = null;
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			logger.info("===========1.当用户只输入用户名时，需要根据用户名模糊查询===========");
			// 模拟前台传参 1.当用户只输入用户名时，需要根据用户名模糊查询
			SysUser sysUser = new SysUser();
			sysUser.setUserName("ad");
			// 调用selectSysUsersAdvanced,根据查询条件查询用户
			userList = userMapper.selectSysUsersAdvancedWithWhere(sysUser);
			// 根据数据库sys_user表中的记录,可以匹配到admin, 期望userList不为空
			Assert.assertNotNull(userList);
			// 根据查询条件，期望只有1条数据
			Assert.assertTrue(userList.size() == 1);
			Assert.assertEquals("admin", userList.get(0).getUserName());

			logger.info("userList:" + userList);

			// 为了测试 匹配多条记录的情况，我们将id=1001这条数据的userName 由test 改为artisan
			sysUser.setUserName("i");
			// 调用selectSysUsersAdvanced,根据查询条件查询用户
			userList = userMapper.selectSysUsersAdvancedWithWhere(sysUser);
			// 根据数据库sys_user表中的记录,可以匹配到admin和artisan, 期望userList不为空
			Assert.assertNotNull(userList);
			// 根据查询条件，期望只有2条数据
			Assert.assertTrue(userList.size() == 2);

			logger.info("userList:" + userList);

			logger.info("===========2.当用户只输入邮箱使，根据邮箱进行完全匹配===========");
			// 模拟前台传参 2.当用户只输入邮箱使，根据邮箱进行完全匹配
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvancedWithWhere(sysUser);
			Assert.assertNotNull(userList);
			Assert.assertTrue(userList.size() == 1);
			logger.info(userList);

			sysUser.setUserEmail("1admin@artisan.com");
			userList = userMapper.selectSysUsersAdvancedWithWhere(sysUser);
			Assert.assertTrue(userList.size() == 0);

			logger.info("===========3.当用户同时输入用户名和密码时，用这两个条件查询匹配的用户===========");
			// 模拟组合查询条件,存在记录的情况
			sysUser.setUserName("i");
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvancedWithWhere(sysUser);
			Assert.assertNotNull(userList);
			Assert.assertEquals("admin@artisan.com", sysUser.getUserEmail());
			Assert.assertTrue(userList.size() == 1);
			logger.info(userList);

			logger.info("===========4.当用户同时输入无法匹配的用户名和密码===========");
			// 模拟组合查询条件,不存在记录的情况
			sysUser.setUserName("x");
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvancedWithWhere(sysUser);
			Assert.assertTrue(userList.size() == 0);
			logger.info(userList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void updateSysUserByIdWithSetSelectiveTest() {
		logger.info("updateSysUserByIdWithSetSelective");
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
			sysUser.setUserName("dynamicUpdate");
			// 修改邮件
			sysUser.setUserEmail("dynamicUpdate@artisan.com");
			// 修改用户 ,返回受影响的行数
			int result = userMapper.updateSysUserByIdWithSetSelective(sysUser);

			// 只插入一条数据 ,期望是1
			Assert.assertEquals(1, result);
			logger.info("受影响的行数:" + result);
			// 重新查询（虽然未提交但是在一个会话中）
			sysUser = userMapper.selectSysUserById((long) 1);
			// 期望的用户名为dynamicUpdate
			Assert.assertEquals("dynamicUpdate", sysUser.getUserName());
			// 期望的邮箱为dynamicUpdate@artisan.com
			Assert.assertEquals("dynamicUpdate@artisan.com", sysUser.getUserEmail());

			// 检查其他字段有没有被更新为null 或者 空值
			Assert.assertEquals("123456", sysUser.getUserPassword());
			Assert.assertEquals("管理员用户", sysUser.getUserInfo());
			logger.info(sysUser);

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

	// 动态SQL where set trim END

	// 动态SQL foreach实现in集合 BEGIN
	@Test
	public void selectSysUserByIdListTest() {
		logger.info("selectSysUserByIdListTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 模拟idList
			List<Long> idList = new ArrayList<Long>();
			idList.add(1L);
			idList.add(1001L);
			// 调用接口方法
			List<SysUser> userList = userMapper.selectSysUserByIdList(idList);
			// userList不为空
			Assert.assertNotNull(userList);
			// userList > 0
			Assert.assertTrue(userList.size() > 0);
			// 期望返回2条数据，符合数据库中记录
			Assert.assertEquals(2, userList.size());
			logger.info(userList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	// 动态SQL foreach实现in集合 END

	// 动态SQL foreach实现批量insert BEGIN
	@Test
	public void insertSysUserListTest() {
		logger.info("insertSysUserListTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			// 模拟userList
			List<SysUser> userList = new ArrayList<SysUser>();

			for (int i = 0; i < 5; i++) {
				SysUser sysUser = new SysUser();
				sysUser.setUserName("artisanTest_" + i);
				sysUser.setUserPassword("123456_" + i);
				sysUser.setUserEmail("artisan_" + i + "@artisan.com");
				sysUser.setUserInfo("测试用户" + i);
				// 模拟头像
				sysUser.setHeadImg(new byte[] { 1, 2, 3 });
				sysUser.setCreateTime(new Date());
				
				// 添加到SysUser
				userList.add(sysUser);
			}

			// 新增用户 ,返回受影响的行数
			int result = userMapper.insertSysUserList(userList);
			// 返回批量的自增主键 配合 keyProperty="id" useGeneratedKeys="true" 这两个属性
			for (SysUser sysUser : userList) {
				logger.info(sysUser.getId());
			}
			// 只插入一条数据 ,期望是5
			Assert.assertEquals(5, result);

			// 重新查询
			List<SysUser> sysUserList = userMapper.selectAll();
			// 根据数据库之前的2条记录，加上本次新增的5条（虽未提交但还是在一个会话中，所以可以查询的到）
			Assert.assertNotNull(sysUserList);
			Assert.assertEquals(7, sysUserList.size());

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

	// 动态SQL foreach实现批量insert END

	@Test
	public void updateSysUserByMapTest() {
		logger.info("updateSysUserByMapTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			// 模拟Map
			Map<String, Object> userMap = new HashMap<String, Object>();
			// 查询条件，同时也是where后面的更新字段， 必须存在
			userMap.put("id", 1L);
			// 更新其他字段
			userMap.put("user_email", "map@artisan.com");
			userMap.put("user_name", "ARTISAN_ADMIN");

			// 调用接口,更新数据
			// userMapper.updateSysUserByMap(userMap);
			// 或者
			userMapper.updateSysUserByMapWithParam(userMap);
			
			// 根据当前id 查询用户
			SysUser sysUser = userMapper.selectSysUserById(1L);
			Assert.assertEquals("map@artisan.com", sysUser.getUserEmail());
			Assert.assertEquals("ARTISAN_ADMIN", sysUser.getUserName());
			
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
	public void selectSysUserByAdvancedConditionTest() {
		logger.info("selectSysUserByAdvancedConditionTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		List<SysUser> userList = null;
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			logger.info("===========1.当用户只输入用户名时，需要根据用户名模糊查询===========");
			// 模拟前台传参 1.当用户只输入用户名时，需要根据用户名模糊查询
			SysUser sysUser = new SysUser();
			sysUser.setUserName("ad");
			// 调用selectSysUserByAdvancedCondition,根据查询条件查询用户
			userList = userMapper.selectSysUserByAdvancedCondition(sysUser);
			// 根据数据库sys_user表中的记录,可以匹配到admin, 期望userList不为空
			Assert.assertNotNull(userList);
			// 根据查询条件，期望只有1条数据
			Assert.assertTrue(userList.size() == 1);
			logger.info("userList:" + userList);

			// 为了测试 匹配多条记录的情况，我们将id=1001这条数据的userName 由test 改为artisan
			sysUser.setUserName("i");
			// 调用selectSysUserByAdvancedCondition,根据查询条件查询用户
			userList = userMapper.selectSysUserByAdvancedCondition(sysUser);
			// 根据数据库sys_user表中的记录,可以匹配到admin和artisan, 期望userList不为空
			Assert.assertNotNull(userList);
			// 根据查询条件，期望只有2条数据
			Assert.assertTrue(userList.size() == 2);

			logger.info("userList:" + userList);

			logger.info("===========2.当用户只输入邮箱使，根据邮箱进行完全匹配===========");
			// 模拟前台传参 2.当用户只输入邮箱使，根据邮箱进行完全匹配
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvanced(sysUser);
			Assert.assertNotNull(userList);
			Assert.assertTrue(userList.size() == 1);
			logger.info(userList);

			sysUser.setUserEmail("1admin@artisan.com");
			userList = userMapper.selectSysUserByAdvancedCondition(sysUser);
			Assert.assertTrue(userList.size() == 0);

			logger.info("===========3.当用户同时输入用户名和密码时，用这两个条件查询匹配的用户===========");

			// 模拟组合查询条件,存在记录的情况
			sysUser.setUserName("i");
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUserByAdvancedCondition(sysUser);
			Assert.assertNotNull(userList);
			Assert.assertEquals("admin@artisan.com", sysUser.getUserEmail());
			Assert.assertTrue(userList.size() == 1);
			logger.info(userList);

			logger.info("===========4.当用户同时输入无法匹配的用户名和密码===========");
			// 模拟组合查询条件,不存在记录的情况
			sysUser.setUserName("x");
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUserByAdvancedCondition(sysUser);
			Assert.assertTrue(userList.size() == 0);
			logger.info(userList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void selectSysUsersAdvancedMulitDBTest() {
		logger.info("selectSysUsersAdvancedMulitDBTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		List<SysUser> userList = null;
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			logger.info("===========1.当用户只输入用户名时，需要根据用户名模糊查询===========");
			// 模拟前台传参 1.当用户只输入用户名时，需要根据用户名模糊查询
			SysUser sysUser = new SysUser();
			sysUser.setUserName("ad");
			// 调用selectSysUserByAdvancedCondition,根据查询条件查询用户
			userList = userMapper.selectSysUsersAdvancedMulitDB(sysUser);
			// 根据数据库sys_user表中的记录,可以匹配到admin, 期望userList不为空
			Assert.assertNotNull(userList);
			// 根据查询条件，期望只有1条数据
			Assert.assertTrue(userList.size() == 1);
			logger.info("userList:" + userList);

			// 为了测试 匹配多条记录的情况，我们将id=1001这条数据的userName 由test 改为artisan
			sysUser.setUserName("i");
			// 调用selectSysUserByAdvancedCondition,根据查询条件查询用户
			userList = userMapper.selectSysUsersAdvancedMulitDB(sysUser);
			// 根据数据库sys_user表中的记录,可以匹配到admin和artisan, 期望userList不为空
			Assert.assertNotNull(userList);
			// 根据查询条件，期望只有2条数据
			Assert.assertTrue(userList.size() == 2);

			logger.info("userList:" + userList);

			logger.info("===========2.当用户只输入邮箱使，根据邮箱进行完全匹配===========");
			// 模拟前台传参 2.当用户只输入邮箱使，根据邮箱进行完全匹配
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvanced(sysUser);
			Assert.assertNotNull(userList);
			Assert.assertTrue(userList.size() == 1);
			logger.info(userList);

			sysUser.setUserEmail("1admin@artisan.com");
			userList = userMapper.selectSysUsersAdvancedMulitDB(sysUser);
			Assert.assertTrue(userList.size() == 0);

			logger.info("===========3.当用户同时输入用户名和密码时，用这两个条件查询匹配的用户===========");

			// 模拟组合查询条件,存在记录的情况
			sysUser.setUserName("i");
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvancedMulitDB(sysUser);
			Assert.assertNotNull(userList);
			Assert.assertEquals("admin@artisan.com", sysUser.getUserEmail());
			Assert.assertTrue(userList.size() == 1);
			logger.info(userList);

			logger.info("===========4.当用户同时输入无法匹配的用户名和密码===========");
			// 模拟组合查询条件,不存在记录的情况
			sysUser.setUserName("x");
			sysUser.setUserEmail("admin@artisan.com");
			userList = userMapper.selectSysUsersAdvancedMulitDB(sysUser);
			Assert.assertTrue(userList.size() == 0);
			logger.info(userList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void selectSysUserAndSysRoleByIdTest() {
		logger.info("selectSysUserAndSysRoleByIdTest");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 注意:数据库中id=1的用户拥有2个角色，不适合这个例子。
			// 调用selectSysUserAndSysRoleById方法，查询id=1001的用户及其角色
			SysUser sysUser = userMapper.selectSysUserAndSysRoleById(1001L);
			// 期望用户不为空
			Assert.assertNotNull(sysUser);
			// 期望角色不为空
			Assert.assertNotNull(sysUser.getSysRole());

			logger.info(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}
	
	@Test
	public void selectSysUserAndSysRoleById2Test() {
		logger.info("selectSysUserAndSysRoleById2Test");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 注意:数据库中id=1的用户拥有2个角色，不适合这个例子。
			// 调用selectSysUserAndSysRoleById2方法，查询id=1001的用户及其角色
			SysUser sysUser = userMapper.selectSysUserAndSysRoleById2(1001L);
			// 期望用户不为空
			Assert.assertNotNull(sysUser);
			// 期望角色不为空
			Assert.assertNotNull(sysUser.getSysRole());

			logger.info(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}
	
	
	@Test
	public void selectSysUserAndSysRoleById3Test() {
		logger.info("selectSysUserAndSysRoleById3Test");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 注意:数据库中id=1的用户拥有2个角色，不适合这个例子。
			// 调用selectSysUserAndSysRoleById3方法，查询id=1001的用户及其角色
			SysUser sysUser = userMapper.selectSysUserAndSysRoleById3(1001L);
			// 期望用户不为空
			Assert.assertNotNull(sysUser);
			// 期望角色不为空
			Assert.assertNotNull(sysUser.getSysRole());

			logger.info(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void selectSysUserAndSysRoleById4Test() {
		logger.info("selectSysUserAndSysRoleById4Test");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 注意:数据库中id=1的用户拥有2个角色，不适合这个例子。
			// 调用selectSysUserAndSysRoleById4方法，查询id=1001的用户及其角色
			SysUser sysUser = userMapper.selectSysUserAndSysRoleById4(1001L);
			// 期望用户不为空
			Assert.assertNotNull(sysUser);
			// 期望角色不为空
			Assert.assertNotNull(sysUser.getSysRole());

			logger.info(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

	@Test
	public void selectSysUserAndSysRoleById5Test() {
		logger.info("selectSysUserAndSysRoleById5Test");
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 注意:数据库中id=1的用户拥有2个角色，不适合这个例子。
			// 调用selectSysUserAndSysRoleById5方法，查询id=1001的用户及其角色
			SysUser sysUser = userMapper.selectSysUserAndSysRoleById5(1001L);
			// 期望用户不为空
			Assert.assertNotNull(sysUser);
			// 期望角色不为空
			Assert.assertNotNull(sysUser.getSysRole());

			logger.info(sysUser);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}
	
}

