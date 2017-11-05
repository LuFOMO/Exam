package henu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.ObjectToStringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import henu.exam.pojo.TbStudent;
import henu.exam.service.TeacherStudentManageService;
import henu.exam.util.ExamResult;
import henu.exam.util.JsonUtils;

@Controller
@SessionAttributes(value={"stu1", "stu2"}, types=TbStudent.class)
public class TeacherStudentManageController {

	@Autowired
	private TeacherStudentManageService studentManagerService;
	
	
	/**
	 * 添加学生信息
	 * @param student
	 * @return
	 */
	@RequestMapping("/teacher/manager/student/add")
	public ExamResult  addStudent(TbStudent student){
		try {
			ExamResult result = studentManagerService.addStudent(student);
			return result;
		} catch (Exception e) {
			return ExamResult.build(500, "添加学生信息失败");
		}
	}
	
	/**
	 * 根据学号 姓名 班级查询学生信息
	 * @param sid
	 * @param name
	 * @param clazz
	 * @return
	 */
	@RequestMapping(value="/teacher/manager/student/search")
	public String findStudent(String sid, String name, String clazz, Model model){
		TbStudent student = studentManagerService.findStudent(sid, name, clazz);
		model.addAttribute("stu1", student);
		return "redirect:/teacher/manage_student";
	}
	
	/**
	 * 根据ip查询学生信息
	 * @param ip
	 * @param model
	 * @return
	 */
	public String findStudentByIP(String ip, Model model){
		TbStudent student = studentManagerService.findStudentByIP(ip);
		model.addAttribute("stu2", student);
		return "redirect:/teacher/manage_unlock";
	}
	
}
