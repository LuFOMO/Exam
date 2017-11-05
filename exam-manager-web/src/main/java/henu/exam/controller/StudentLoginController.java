package henu.exam.controller;

import javax.servlet.http.HttpServletRequest;

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
	 * @throws Exception 
	 */
	@RequestMapping("/student/login")
	public String login(Model model, String sid, String name, HttpServletRequest request) throws Exception{
		boolean flag = loginService.studentLogin(sid, name, request);
		if(flag){
			model.addAttribute("name", name);
			return "/student/main";
		}else{
			return "redirect:/";
		}
	}
}
