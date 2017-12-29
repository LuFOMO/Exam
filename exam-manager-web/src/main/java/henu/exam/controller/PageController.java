package henu.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/**
	 * 返回登录页面
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	/**
	 * 实现页面间的跳转
	 * @param lib
	 * @param page
	 * @return
	 */
	@RequestMapping("/{lib}/{page}")
	public String showPage(@PathVariable String lib, @PathVariable String page){
		return lib+"/"+page;
	}
}
