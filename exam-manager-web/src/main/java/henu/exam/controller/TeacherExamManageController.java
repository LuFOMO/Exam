package henu.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import henu.exam.pojo.StudentMessage;
import henu.exam.pojo.TbExam;
import henu.exam.service.TeacherExamManageService;

@Controller
@SessionAttributes(value=("studentMsg"), types=StudentMessage.class)
public class TeacherExamManageController {

	@Autowired
	private TeacherExamManageService examManagerService;
	
	/**
	 * 获取所有的考试
	 * @return
	 */
	@RequestMapping("/teacher/exam/list")
	@ResponseBody
	public List<TbExam> getExamList(){
		List<TbExam> examList = examManagerService.getExamList();
		return examList;
	}

	/**
	 * 获取考试概况
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/get/student/message")
	public String getStudentMessage(Model model){
		int studentNum = examManagerService.getStudentNum();
		int studentLoginNum = examManagerService.getStudentLoginNum();
		int studentSubmitNum = examManagerService.getStudentSubmitNum();
		
		StudentMessage studentMsg = new StudentMessage();
		studentMsg.setTotalNum(studentNum);
		studentMsg.setLoginNum(studentLoginNum);
		studentMsg.setUnloginNum(studentNum-studentLoginNum);
		studentMsg.setSubmitNum(studentSubmitNum);
		studentMsg.setUnsumbitNum(studentNum-studentSubmitNum);
		
		model.addAttribute("studentMsg", studentMsg);
		return "redirect:/teacher/manage_summary";
	}
}
