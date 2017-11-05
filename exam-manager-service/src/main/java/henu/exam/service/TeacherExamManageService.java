package henu.exam.service;

import java.util.List;

import henu.exam.pojo.StudentMessage;
import henu.exam.pojo.TbExam;

public interface TeacherExamManageService {

	/**
	 * 获取所有的考试
	 * @return
	 */
	public List<TbExam> getExamList();

	/**
	 * 获取学生数量
	 * @return
	 */
	public int getStudentNum();
	
	/**
	 * 获取未登录的学生数量
	 * @return
	 */
	public int getStudentLoginNum();
	
	/**
	 * 获取提交的学生数量
	 * @return
	 */
	public int getStudentSubmitNum();
	
}
