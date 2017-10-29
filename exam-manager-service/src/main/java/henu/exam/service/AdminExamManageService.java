package henu.exam.service;

import java.util.List;

import henu.exam.pojo.ExamResult;
import henu.exam.pojo.TbExam;

public interface AdminExamManageService {

	/**
	 * 获取当前所有考试
	 * @param exam
	 * @return
	 */
	public List<TbExam> getExamList();
	
	/**
	 * 清理考试
	 * @param id
	 * @return
	 */
	public ExamResult cleanExam(Integer id);
	
	/**
	 * 删除已清理的考试
	 * @param ids
	 * @return
	 */
	public ExamResult deleteExam(Integer[] ids);
}
