package henu.exam.service;

import henu.exam.pojo.Pass;
import henu.exam.util.ExamResult;

public interface TeacherBasicService {

	/**
	 * 教师登录
	 * @param name
	 * @param pass
	 * @return
	 */
	public boolean teacherLogin(String name, String pass);
	
	/**
	 * 修改教师口令
	 * @param pass
	 * @return
	 */
	public ExamResult teacherEditPass(Pass pass);
}
