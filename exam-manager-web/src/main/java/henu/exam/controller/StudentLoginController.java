package henu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import henu.exam.service.StudentLoginService;

@SessionAttributes(value={"name"}, types=String.class)
@Controller
public class StudentLoginController {

	@Autowired
	private StudentLoginService loginService;
	
	/**
	 * 学生登录
	 * @param name
	 * @param pass
	 * @return
	 */
	@RequestMapping("/student/login")
	public String login(Model model, String sid, String name){
		boolean flag = loginService.studentLogin(sid, name);
		if(flag){
			model.addAttribute("name", name);
			return "/student/main";
		}else{
			return "redirect:/";
		}
	}
}
