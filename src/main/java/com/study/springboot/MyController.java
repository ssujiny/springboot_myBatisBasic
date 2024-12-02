package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.jdbc.IMyUserDao;

@Controller
public class MyController {
	
	@Autowired
	private IMyUserDao userDao;
	
	@GetMapping("/")
	public @ResponseBody String root() throws Exception {
		return "MyBatis 사용하기";
	}
	
	@GetMapping("/user")
	public String userListPage(Model model) {
		model.addAttribute("users", userDao.list());
		return "userList";
	}
}
