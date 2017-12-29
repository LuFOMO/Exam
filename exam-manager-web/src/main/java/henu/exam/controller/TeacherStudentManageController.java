package henu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import henu.exam.pojo.EasyUIResult;
import henu.exam.pojo.TbStudent;
import henu.exam.service.TeacherStudentManageService;
import henu.exam.util.ExamResult;

@Controller
public class TeacherStudentManageController {

	@Autowired
	private TeacherStudentManageService studentManagerService;
	
	/**
	 * 分页显示学生信息
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/teacher/student/list")
	@ResponseBody
	public EasyUIResult getStudentList(Integer page, Integer rows) {
		EasyUIResult result = studentManagerService.getStudentList(page, rows);
		return result;
	}
	
	/**
	 * 添加学生信息
	 * @param student
	 * @return
	 */
	@RequestMapping("/teacher/manage/student/add")
	@ResponseBody
	public ExamResult  addStudent(TbStudent student){
		try {
			ExamResult result = studentManagerService.addStudent(student);
			return result;
		} catch (Exception e) {
			return ExamResult.build(500, "添加学生信息失败");
		}
	}
	
	/**
	 * 教师考中管理查找学生信息
	 * @param sid
	 * @param name
	 * @param clazz
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/manage/student/search")
	public String StudentSearch(String sid, String name, String clazz, Model model){
		TbStudent student = findStudents(sid, name, clazz, model);
		if(student!=null){
			model.addAttribute("stu1", student);
		}else{
			model.addAttribute("error", "未查到学生信息");
		}
		return "/teacher/manage_student";
	}
	
	/**
	 * 教师解除锁定查找学生信息
	 * @param sid
	 * @param name
	 * @param clazz
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/manage/binding/search")
	public String StudentIPManage(String sid, String name, String clazz, Model model){
		TbStudent student = findStudents(sid, name, clazz, model);
		if(student!=null){
			model.addAttribute("stu2", student);
		}else{
			model.addAttribute("error", "未查到学生信息");
		}
		return "/teacher/manage_unlock";
	}

	/**
	 * 根据学号 姓名 班级查询学生信息
	 * @param sid
	 * @param name
	 * @param clazz
	 * @return
	 */
	private TbStudent findStudents(String sid, String name, String clazz, Model model) {
		TbStudent student = studentManagerService.findStudent(sid, name, clazz);
		return student;
	}
	
	/**
	 * 根据ip查询学生信息
	 * @param ip
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/manage/binding/searchip")
	public String findStudentByIP(String ip, Model model){
		TbStudent student = studentManagerService.findStudentByIP(ip);
		if(student!=null){
			model.addAttribute("stu2", student);
		}else{
			model.addAttribute("error", "未查到学生信息");
		}
		return "/teacher/manage_unlock";
	}
	
	/**
	 * 根据id解除ip绑定
	 * @param id
	 * @return
	 */
	@RequestMapping("/teacher/manage/binding/delete/{id}")
	@ResponseBody
	public ExamResult editStudentIP(@PathVariable Integer id, SessionStatus status) {
		try {
			int i = studentManagerService.editStudentIP(id);
			if(i == 1) {
				status.setComplete();
				return ExamResult.ok();
			}
			else {
				return ExamResult.build(500, "解除IP绑定失败");
			}
		}catch(Exception e) {
			return ExamResult.build(500, "解除IP绑定失败");
		}
	}
	
	/**
	 * 根据id删除学生信息
	 * @param ids
	 * @return
	 */
	@RequestMapping("/teacher/student/delete")
	@ResponseBody
	public ExamResult deleteStudent(Integer[] ids) {
		int i = studentManagerService.deleteStudent(ids);
		if(i==1) {
			return ExamResult.ok();
		}else {
			return ExamResult.build(500, "删除学生信息失败");
		}
	}
	
	/**
	 * 获取分页查询条数
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/exam/get/pagesize")
	public String getPageSize(Model model) {
		int pageSize = studentManagerService.getPageSize();
		model.addAttribute("pagesize", pageSize);
		return "/teacher/exam_student";
	}
	
	/**
	 * 批量导入学生名单
	 * @param eid
	 * @param file
	 * @return
	 */
	@RequestMapping("/teacher/student/addAll")
	@ResponseBody
	public ExamResult addStudentAll(Integer eid, MultipartFile file) {
		try {
			int i = studentManagerService.addStudentAll(eid, file);
			if(i==1) {
				return ExamResult.ok();
			}else {
				return ExamResult.build(500, "导入学生名单失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ExamResult.build(500, "导入学生名单失败");
		}
	}
}
