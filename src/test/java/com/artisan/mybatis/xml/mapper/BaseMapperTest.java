package com.artisan.mybatis.xml.mapper;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;

public class BaseMapperTest {

	private static Logger logger = Logger.getLogger(BaseMapperTest.class);
	private static SqlSessionFactory sessionFactory;

	@BeforeClass
	public static void init() {
		try {
			// 根据mybatis的配置文件创建sqlSessionFactory
			String config = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(config);

			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			logger.info("sessionFactory bulit successfully");

			reader.close();
			logger.info("reader close successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlSession() {
		return sessionFactory.openSession();
	}

}