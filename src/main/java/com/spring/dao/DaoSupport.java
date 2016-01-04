package com.spring.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("daoSupport")
public class DaoSupport {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	/**
	 * 查找单个
	 * @param str
	 * @param obj
	 * @return
	 */
	public Object findForObject(String str,Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(str,obj);
	}

}
