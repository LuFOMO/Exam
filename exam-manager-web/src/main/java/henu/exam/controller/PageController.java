package henu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import henu.exam.pojo.ExamResult;
import henu.exam.service.CheckExamService;

@Controller
public class PageController {

	@Autowired
	private CheckExamService checkExamService;
	
	
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
	
	/**
	 * 判断学生是否可以登录
	 * @return
	 */
	@RequestMapping("/exam/get")
	@ResponseBody
	public ExamResult getExam(){
		ExamResult result = checkExamService.checkExam();
		return result;
	}
}
