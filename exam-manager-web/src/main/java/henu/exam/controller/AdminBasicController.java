package henu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import henu.exam.pojo.Pass;
import henu.exam.service.AdminBasicService;

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
	public String adminLogin(String name, String pass, HttpServletRequest request) throws Exception{
		boolean flag = basicService.adminLogin(name, pass);
		if(flag){
			request.getSession().setAttribute("name", name);
			return "/admin/main";
		}else{
			return "redirect:/";
		}
	}
	
	/**
	 * 管理员退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/admin/logout")
	public String adminLogut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("name");
		return "redirect:/";
	}
	
	/**
	 * 修改管理员口令
	 * @param pass
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/password/edit")
	public String adminEditPass(Pass pass, HttpServletRequest request){
		basicService.adminEditPass(pass);
		HttpSession session = request.getSession();
		session.removeAttribute("name");
		return "redirect:/";
	}
}
