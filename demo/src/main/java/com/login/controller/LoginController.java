package com.login.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.login.service.LoginService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	
	@Autowired // 서베스객체 자동 주입
	private LoginService loginService;
	
	
	@RequestMapping("/home")
	@ResponseBody
	public ModelAndView loginTest() throws Exception{
		ModelAndView mav = new ModelAndView("loginHome");
		return mav;
	}
	
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(@RequestParam(value="id") String id, @RequestParam(value="password") String password, HttpServletResponse response){
		String pwd = loginService.getPassword(id);
		if(pwd == null || pwd == "") {
			return "0";
		}else if(pwd.equals(password) == true) {
			return "1";
		}else{
			return "2";
		}
	}
	
	@RequestMapping("/join")
	public ModelAndView join() throws Exception{
		ModelAndView mav = new ModelAndView("join");
		return mav;
	}
}
