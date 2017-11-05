package henu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import henu.exam.pojo.Pass;
import henu.exam.service.AdminBasicService;
import henu.exam.util.ExamResult;

//将model中保存的值复制一份到session中
@SessionAttributes(value={"name"}, types=String.class)
@Controller
public class AdminBasicController {

	@Autowired
	private AdminBasicService basicService;
	
	/**
	 * 管理员登录
	 * @param model
	 * @param name
	 * @param pass
	 * @return
	 */
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public String adminLogin(Model model, String name, String pass) throws Exception{
		boolean flag = basicService.adminLogin(name, pass);
		if(flag){
			model.addAttribute("name", name);
			return "/admin/main";
		}else{
			return "redirect:/";
		}
	}
	
	/**
	 * 管理员退出
	 * @param session
	 * @param sessionStatus 可以通过SessionStatus.setComplete()清除@SessionAttributes
	 * @return
	 */
	@RequestMapping("/admin/logout")
	public String adminLogut(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	/**
	 * 修改管理员口令
	 * @param pass
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/password/edit")
	public String adminEditPass(Pass pass, SessionStatus sessionStatus){
		ExamResult result = basicService.adminEditPass(pass);
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
