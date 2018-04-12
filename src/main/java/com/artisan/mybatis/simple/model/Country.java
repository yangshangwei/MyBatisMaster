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

	/**
	 * 由于java中的基本类型会有默认值,某些情况下动态sql无法实现null的情况,因此实体类中不建议使用基本类型
	 */
	private Long id;
	private String countryname;
	private String countrycode;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
