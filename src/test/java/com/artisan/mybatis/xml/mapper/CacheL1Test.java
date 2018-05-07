package com.artisan.mybatis.xml.mapper;


import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.artisan.mybatis.xml.domain.SysUser;

/**
 * 
 * 
 * @ClassName: CacheL1Test
 * 
 * @Description: 一级缓存设置
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年5月3日 上午12:06:05
 */
public class CacheL1Test extends BaseMapperTest {

	@Test
	public void cacheL1Test() {
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		SysUser sysUser1 = null;
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用接口方法,查询sysUser
			sysUser1 = userMapper.selectSysUserById(1L);
			// 对当前获取的对象重新赋值
			sysUser1.setUserName("New Name");

			System.out.println("再次查询id相同的sysUser Begin");
			// 再次查询id相同的sysUser，确保和上个查询 方法和参数相同
			SysUser sysUser2 = userMapper.selectSysUserById(1L);
			System.out.println("再次查询id相同的sysUser End");

			// 虽然么有更新数据库，但是这个用户名和sysUser1重新赋值的名字相同
			Assert.assertEquals("New Name", sysUser2.getUserName());
			// 无论如何，sysUser1 和 sysUser2 完全就是同一个实例
			Assert.assertEquals(sysUser1, sysUser2);

		} finally {
			// 关闭SqlSession
			sqlSession.clearCache();
		}

		System.out.println("【---------------开启新的SqlSession---------------】");

		// 获取一个新的SqlSession
		sqlSession = getSqlSession();
		try {
			// 获取UserMapper接口
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用接口方法,查询sysUser
			SysUser sysUser3 = userMapper.selectSysUserById(1L);
			// 第二个sqlSession获取的用户仍然是admin
			Assert.assertNotEquals("New Name", sysUser3.getUserName());
			// 这里的sysUser3 和 第一个sqlSession中的sysUser1是两个不同的实例
			Assert.assertNotEquals(sysUser1, sysUser3);
			// 执行删除操作
			userMapper.deleteSysUserById(2L);
			System.out.println("执行删除操作后，再次查询id相同的sysUser Begin");
			// 获取 sysUser4 ，确保和上个查询 方法和参数相同
			SysUser sysUser4 = userMapper.selectSysUserById(1L);
			System.out.println("执行删除操作后，再次查询id相同的sysUser End");
			// 这里sysUser3和sysUser4是两个不同的实例
			Assert.assertNotEquals(sysUser3, sysUser4);

		} finally {
			// 关闭SqlSession
			sqlSession.clearCache();
		}

	}
}
