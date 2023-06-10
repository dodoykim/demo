package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.dao.LoginDAO;


@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;
	
	public String getPassword(String id) {
		return loginDAO.getPassword(id);
	}
}
