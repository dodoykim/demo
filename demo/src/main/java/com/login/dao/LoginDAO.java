package com.login.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public String getPassword(String id) {
		return sqlSession.selectOne("login.passwordCheck", id);
	}
}
