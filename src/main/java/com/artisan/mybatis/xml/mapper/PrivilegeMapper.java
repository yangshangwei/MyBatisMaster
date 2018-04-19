package com.artisan.mybatis.xml.mapper;

import org.apache.ibatis.annotations.SelectProvider;

import com.artisan.mybatis.xml.domain.SysPrivilege;
import com.artisan.mybatis.xml.provider.PrivilegeProvider;

/**
 * 
 * 
 * @ClassName: PrivilegeMapper
 * 
 * @Description: 演示Provider方式
 * 
 * @author: Mr.Yang
 * 
 * @date: 2018年4月19日 上午3:26:13
 */
public interface PrivilegeMapper {
	
	@SelectProvider(type = PrivilegeProvider.class, method = "selectSysPrivilegeById")
	SysPrivilege selectSysPrivilegeById(Long id);

}
