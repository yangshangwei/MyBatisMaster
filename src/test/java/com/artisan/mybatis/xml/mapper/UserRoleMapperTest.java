package com.artisan.mybatis.xml.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.artisan.mybatis.xml.domain.SysRole;

/**
 * 
 * 
 * @ClassName: UserRoleMapperTest
 * 
 * @Description: UserRoleMapperTest测试类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月16日 下午3:34:45
 */
public class UserRoleMapperTest extends BaseMapperTest {

	private static final Logger logger = Logger.getLogger(UserRoleMapperTest.class);
	private SqlSession sqlSession;

	@Test
	public void selectSysRolesByUserIdAndRoleEnableTest(){

		logger.info("selectSysRolesByUserIdAndRoleEnableTest");
		
		try {
			// 获取SqlSession
			sqlSession = getSqlSession();
			// 获取UserRoleMapper
			UserRoleMapper userRoleMapper = sqlSession.getMapper(UserRoleMapper.class);
			
			// 通过接口调用方法
			List<SysRole> roleList = userRoleMapper.selectSysRolesByUserIdAndRoleEnable((long) 1, 1);
			
			// 期望roleList不为空
			Assert.assertNotNull(roleList);
			// 期望roleList> 0
			Assert.assertTrue(roleList.size() > 0);
			
			for (SysRole sysRole : roleList) {
				logger.info(sysRole);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
			logger.info("sqlSession close successfully ");
		}
	}

}
