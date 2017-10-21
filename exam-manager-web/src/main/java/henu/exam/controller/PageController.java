package henu.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	
//	/WEB-INF/jsp/teacher/login.jsp
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return "teacher/"+page;
	}
}
