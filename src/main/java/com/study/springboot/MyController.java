package com.study.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.dao.ISimpleBbsDao;
import com.study.springboot.jdbc.IMyUserDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;
	
	@Autowired
	private IMyUserDao userDao;
	
	@GetMapping("/")
	public @ResponseBody String root() throws Exception {
		// MyBatis : SimpleBBS
		return "MyBatis 사용하기";
	}
	
	@GetMapping("/user")
	public String userlistPage(Model model) {
		model.addAttribute("users", userDao.list());
		return "userList";
	}
	
	@GetMapping("/list")
	public String userListPage(Model model) {
		model.addAttribute("list", dao.listDao());
		
		int nTotalCount = dao.articleCount();
		System.out.println("Count : " + nTotalCount);
		return "/list";
	}
	
	@GetMapping("/view")
	public String view(HttpServletRequest req, Model model) {
		String sid = req.getParameter("id");
		model.addAttribute("dto", dao.viewDao(sid));
		return "/view";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "/writeForm";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, Model model) {
				
		String sName = req.getParameter("writer");
		String sTitle = req.getParameter("title");
		String sContent = req.getParameter("content");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("item1", sName);
		map.put("item2", sTitle);
		map.put("item3", sContent);
		
		int nResult = dao.writeDao(map);
		System.out.println("Write : " + nResult);
		
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		
		String sId = req.getParameter("id");
		int nResult = dao.deleteDao(sId);
		System.out.println("Delete : " + nResult);
		
		return "redirect:list";
	}
}
