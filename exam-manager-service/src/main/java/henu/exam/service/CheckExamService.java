package henu.exam.service;

import henu.exam.pojo.ExamResult;

public interface CheckExamService {
	
	/**
	 * 判断学生是否可以登录
	 * @return
	 */
	public ExamResult checkExam();

}
