package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.springboot.dao.ISimpleBbsDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;
	
	@GetMapping("/")
	public String root() throws Exception {
		// MyBatis : SimpleBBS
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String userListPage(Model model) {
		model.addAttribute("list", dao.listDao());
		return "list";
	}
	
	@GetMapping("/view")
	public String view(HttpServletRequest req, Model model) {
		String sid = req.getParameter("id");
		model.addAttribute("dto", dao.viewDao(sid));
		return "view";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, Model model) {
		dao.writeDao(
			req.getParameter("writer"),
			req.getParameter("title"),
			req.getParameter("content")
		);
		
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		dao.deleteDao(req.getParameter("id"));
		return "redirect:list";
	}
}
