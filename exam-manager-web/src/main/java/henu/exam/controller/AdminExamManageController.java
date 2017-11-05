package henu.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import henu.exam.pojo.TbExam;
import henu.exam.service.AdminExamManageService;
import henu.exam.util.ExamResult;
import henu.exam.util.ExceptionUtil;

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
	public List<TbExam> getExamList() throws Exception{
		List<TbExam> examList = null;
		try {
			examList = examManageService.getExamList();
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionUtil.getStackTrace(e);
		}
		return examList;
	}
	
	/**
	 * 清理考试
	 * @param ids
	 * @return
	 */
	@RequestMapping("/admin/exam/clean")
	@ResponseBody
	public ExamResult cleanExam(Integer id) throws Exception{
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
	public ExamResult deleteExam(Integer[] ids) throws Exception{
		ExamResult result = examManageService.deleteExam(ids);
		return result;
	}
}
