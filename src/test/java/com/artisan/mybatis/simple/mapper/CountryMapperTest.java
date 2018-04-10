package com.artisan.mybatis.simple.mapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.artisan.mybatis.simple.model.Country;

public class CountryMapperTest {

	static SqlSessionFactory sessionFactory;
	SqlSession sqlSession;

	@Before
	public void init() {
		try {
			// 根据mybatis的配置文件创建sqlSessionFactory
			String config = "mybatis-config.xml";
			InputStream ins = Resources.getResourceAsStream(config);
			sessionFactory = new SqlSessionFactoryBuilder().build(ins);
			ins.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		// 使用SqlSessionFactory打开sqlSession
		sqlSession = sessionFactory.openSession();
		// 使用sqlSession 操作数据库
		List<Country> countryList = sqlSession.selectList("com.artisan.mybatis.simple.mapper.CountryMapper.selectAll");

		System.out.println(countryList);

	}

	@After
	public void destory() {
		sqlSession.close();
	}
}
