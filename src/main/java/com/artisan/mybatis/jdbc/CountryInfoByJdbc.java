package com.artisan.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.artisan.mybatis.simple.model.Country;

/**
 * 
 * 
 * @ClassName: CountryInfoByJdbc
 * 
 * @Description: JDBC连接访问数据库，方便与Mybatis对比
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月10日 上午1:12:11
 */
public class CountryInfoByJdbc {
	private static final Logger logger = Logger.getLogger(CountryInfoByJdbc.class);
	private static final String QUERY_COUNTRY_BY_CODE = "select id ,countryname ,countrycode from country where countrycode = ? ";

	public static void main(String[] args) {
		// 数据库连接
		Connection connection = null;
		// 预编译的PreparedStatement，提高数据库效率
		PreparedStatement preparedStatement = null;
		// 结果集
		ResultSet resultSet = null;
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 通过数据库驱动管理类获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/artisan", "root", "root");
			// 获取preparedStatement
			preparedStatement = connection.prepareStatement(QUERY_COUNTRY_BY_CODE);
			// 设置参数
			preparedStatement.setString(1, "CN");
			// 通过preparedStatement执行SQL
			resultSet = preparedStatement.executeQuery();
			// 遍历查询结果
			while (resultSet.next()) {
				Country country = new Country();
				country.setId(Integer.parseInt(resultSet.getString("id")));
				country.setCountryname(resultSet.getString("countryname"));
				country.setCountrycode(resultSet.getString("countrycode"));
				logger.info("通过jdbc获取的结果：" + country);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
