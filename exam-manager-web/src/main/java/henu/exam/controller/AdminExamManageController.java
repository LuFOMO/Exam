package henu.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import henu.exam.pojo.ExamResult;
import henu.exam.pojo.TbExam;
import henu.exam.service.AdminExamManageService;

@Controller
public class AdminExamManageController {

	@Autowired
	private AdminExamManageService examManageService;
	
	/**
	 * 获取当前所有考试
	 * @return
	 */
	@RequestMapping("/admin/exam/list")
	@ResponseBody
	public List<TbExam> getExamList(){
		List<TbExam> examList = examManageService.getExamList();
		return examList;
	}
	
	/**
	 * 清理考试
	 * @param ids
	 * @return
	 */
	@RequestMapping("/admin/exam/clean")
	@ResponseBody
	public ExamResult cleanExam(Integer id){
		ExamResult result = examManageService.cleanExam(id);
		return result;
	}
	
	
	/**
	 * 删除已清理的考试
	 * @param ids
	 * @return
	 */
	@RequestMapping("/admin/exam/delete")
	@ResponseBody
	public ExamResult deleteExam(Integer[] ids){
		ExamResult result = examManageService.deleteExam(ids);
		return result;
	}
}
