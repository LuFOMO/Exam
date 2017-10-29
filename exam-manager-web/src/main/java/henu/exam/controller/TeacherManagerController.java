package henu.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import henu.exam.service.AdminTeacherManagerService;
import henu.exam.pojo.ExamResult;
import henu.exam.pojo.TbTeacher;

@Controller
@RequestMapping("/admin")
public class TeacherManagerController {

	@Autowired
	private AdminTeacherManagerService teacherMangerService;
	
	/**
	 * 获取教师列表
	 * @return
	 */
	@RequestMapping("/teacher/list")
	@ResponseBody
	public List<TbTeacher> getTeacherList(){
		List<TbTeacher> teacherList = teacherMangerService.getTeacherList();
		return teacherList;
	}
	/**
	 * 新增教师
	 * @param teacher
	 * @return
	 */
	@RequestMapping("/teacher/add")
	@ResponseBody
	public ExamResult addTeacher(TbTeacher teacher){
		ExamResult result = teacherMangerService.addTeacher(teacher);
		return result;
	}
	
	/**
	 * 修改教师信息
	 * @param teacher
	 * @return
	 */
	@RequestMapping("/teacher/edit")
	@ResponseBody
	public ExamResult editTeacher(TbTeacher teacher){
		ExamResult result = teacherMangerService.editTeacher(teacher);
		return result;
	}
	
	/**
	 * 删除教师
	 * @param ids
	 * @return
	 */
	@RequestMapping("/teacher/delete")
	@ResponseBody
	public ExamResult deleteTeacher(Integer[] ids){
		ExamResult result = teacherMangerService.deleteTeacher(ids);
		return result;
	}
	
}
