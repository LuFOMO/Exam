package henu.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import henu.exam.pojo.TbExam;
import henu.exam.service.StudentBasicService;
import henu.exam.service.StudentExamService;
import henu.exam.util.ExamResult;
import henu.exam.util.ExceptionUtil;

@Controller
public class StudentBasicController {

	@Autowired
	private StudentBasicService loginService;
	@Autowired
	private StudentExamService examService;
	
	/**
	 * 判断学生是否可以登录
	 * @return
	 */
	@RequestMapping("/exam/get")
	@ResponseBody
	public ExamResult getExam(HttpServletRequest request){
		TbExam exam = loginService.checkExam();
		if(exam!=null) {
			request.getSession().setAttribute("exam", exam);
			return ExamResult.ok();
		}
		return ExamResult.build(500, "暂时无法登录");
	}
	
	/**
	 * 学生登录
	 * @param name
	 * @param pass
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="/student/login", method=RequestMethod.POST)
	public String login(String sid, String name, HttpServletRequest request){
		try {
			int i = loginService.studentLogin(sid, name, request);
			//获取教师通知的刷新间隔
			int interval = examService.getInterval();
			if(i==1){
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("time", interval);
				return "/student/main";
			}else{
				return "redirect:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionUtil.getStackTrace(e);
			return "redirect:/";
		}
	}
	
	/**
	 * 学生退出
	 * @param request
	 * @return
	 */
	@RequestMapping("/student/logout")
	public String studentLogout(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			String name = (String)session.getAttribute("name");
//			loginService.studentLogout(name);
			session.removeAttribute("name");
			return "redirect:/";
		}catch(Exception e) {
			ExceptionUtil.getStackTrace(e);
			//退出失败
			return "/student/main";
		}
	}
}
