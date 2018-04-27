package com.artisan.mybatis.xml.mapper;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MultiDBMapperTest extends BaseMapperTest {

	public String getDatabaseProductName() {

		String productName = null;
		try {
			String dbfile = "db.properties";
			InputStream in = ClassLoader.getSystemResourceAsStream(dbfile);
			Properties p = new Properties();
			p.load(in);
			Class.forName(p.getProperty("jdbc.driver"));
			String url = p.getProperty("jdbc.url");
			String user = p.getProperty("jdbc.username");
			String pass = p.getProperty("jdbc.password");
			Connection con = DriverManager.getConnection(url, user, pass);
			DatabaseMetaData dbmd = con.getMetaData();
			productName = dbmd.getDatabaseProductName();
			System.out.println("数据库名称是：" + productName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productName;
	}
	
	@Test
	public void getSysTimeTest() {
		// 获取数据库名称
		getDatabaseProductName();
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();
		// 获取MultiDBMapper
		MultiDBMapper multiDBMapper = sqlSession.getMapper(MultiDBMapper.class);
		// 调用接口方法
		String sysTime = multiDBMapper.getSysTime();
		System.out.println("当前时间:" + sysTime);
		sqlSession.close();
	}

}
