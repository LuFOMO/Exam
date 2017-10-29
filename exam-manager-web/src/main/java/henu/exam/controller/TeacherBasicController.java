package henu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import henu.exam.pojo.ExamResult;
import henu.exam.pojo.Pass;
import henu.exam.service.TeacherBasicService;

@SessionAttributes(value={"name"}, types=String.class)
@Controller
public class TeacherBasicController {

	@Autowired
	private TeacherBasicService basicService;
	
	/**
	 * 教师登录
	 * @param name
	 * @param pass
	 * @return
	 */
	@RequestMapping("/teacher/login")
	public String login(Model model, String name, String pass){
		boolean flag = basicService.teacherLogin(name, pass);
		if(flag){
			model.addAttribute("name", name);
			return "/teacher/main";
		}else{
			return "redirect:/";
		}
	}
	
	/**
	 * 管理员退出
	 * @param session
	 * @param sessionStatus
	 * @return
	 */
	@RequestMapping("/teacher/logout")
	public String teacherLogut(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	
	/**
	 * 修改管理员口令
	 * @param pass
	 * @param id
	 * @return
	 */
	@RequestMapping("/teacher/passwd/edit")
	public String teacherEditPass(Pass pass, SessionStatus sessionStatus){
		ExamResult result = basicService.teacherEditPass(pass);
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
