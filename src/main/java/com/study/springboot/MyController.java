package com.study.springboot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.springboot.jdbc.IMyUserDao;
import com.study.springboot.service.ISimpleBbsService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	//@Autowired
	//ISimpleBbsDao dao;
	
	/*	자동주입으로 만들어질 객체 변수 값을 인터페이스타입 변수로 받음
	 * 	매퍼 사용 -> 코드상 인터페이스 구현한 클래스가 없기 때문
	 * 	"디자인 패턴: 자식 객체를 부모타입의 변수에 대입할 수 있다"
	 */
	@Autowired
	private IMyUserDao userDao;
	
	@Autowired
	ISimpleBbsService bbs;
	
	@GetMapping("/")
	public String root() throws Exception {
		// Service vs DAO
		return "redirect:list";
	}
	
	@GetMapping("/user")
	public String userlistPage(Model model) {
		model.addAttribute("users", userDao.list());
		return "userList";
	}
	
	@GetMapping("/list")
	public String userListPage(Model model) {
		//model.addAttribute("list", dao.listDao());
		model.addAttribute("list", bbs.list());
		
		int nTotalCount = bbs.count();
		System.out.println("Count : " + nTotalCount);
		
		return "/list";
	}
	
	@GetMapping("/view")
	public String view(HttpServletRequest req, Model model) {
		String sid = req.getParameter("id");
		model.addAttribute("dto", bbs.view(sid));
		
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
		
		// 이런 형식 자주 사용한다. 외워두자!
		Map<String, String> map = new HashMap<String, String>();
		map.put("item1", sName);
		map.put("item2", sTitle);
		map.put("item3", sContent);
		
		int nResult = bbs.write(map);
		System.out.println("Write : " + nResult);
		
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest req, Model model) {
		
		String sId = req.getParameter("id");
		int nResult = bbs.delete(sId);
		System.out.println("Delete : " + nResult);
		
		return "redirect:list";
	}
	
	@GetMapping("/mv")
	public ModelAndView test() {
		//데이터와 뷰를 동시에 설정 가능
		ModelAndView mv = new ModelAndView();
		
		List<String> list = new ArrayList<>();
		
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		mv.addObject("lists", list);
		mv.addObject("ObjectTest", "테스트입니다." );
		mv.addObject("name", "홍길동" );
		mv.setViewName("view/myView");
		
		return mv;
		
	}
}
