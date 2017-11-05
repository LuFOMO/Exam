package henu.exam.service;

import henu.exam.pojo.TbStudent;
import henu.exam.util.ExamResult;

public interface TeacherStudentManageService {

	/**
	 * 新增学生信息
	 * @param student
	 * @return
	 */
	public ExamResult addStudent(TbStudent student);
	
	/**
	 * 通过学号 姓名 班级查找学生
	 * @param sid
	 * @return
	 */
	public TbStudent findStudent(String sid, String name, String clazz); 
	
	public TbStudent findStudentByIP(String ip);
}
