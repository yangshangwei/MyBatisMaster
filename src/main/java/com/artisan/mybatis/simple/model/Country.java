package com.artisan.mybatis.simple.model;

/**
 * 
 * 
 * @ClassName: Country
 * 
 * @Description: Country 实体类
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月9日 下午5:54:29
 */
public class Country {

	private int id;
	private String countryname;
	private String countrycode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", countryname=" + countryname + ", countrycode=" + countrycode + "]";
	}

}
