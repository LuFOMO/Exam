package henu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import henu.exam.pojo.Pass;
import henu.exam.service.TeacherBasicService;

@Controller
public class TeacherBasicController {

	@Autowired
	private TeacherBasicService basicService;
	
	/**
	 * 教师登录
	 * @param name
	 * @param pass
	 * @param request
	 * @return
	 */
	@RequestMapping("/teacher/login")
	public String login(String name, String pass, HttpServletRequest request){
		boolean flag = basicService.teacherLogin(name, pass);
		if(flag){
			request.getSession().setAttribute("name", name);
			return "/teacher/main";
		}else{
			return "redirect:/";
		}
	}
	
	/**
	 * 教师登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/teacher/logout")
	public String teacherLogut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("name");
		return "redirect:/";
	}
	
	
	/**
	 * 修改管理员口令
	 * @param pass
	 * @param request
	 * @return
	 */
	@RequestMapping("/teacher/passwd/edit")
	public String teacherEditPass(Pass pass, HttpServletRequest request){
		basicService.teacherEditPass(pass);
		HttpSession session = request.getSession();
		session.removeAttribute("name");
		return "redirect:/";
	}
}
