package henu.exam.service;

import java.util.List;

import henu.exam.pojo.ExamResult;
import henu.exam.pojo.TbTeacher;

public interface AdminTeacherManagerService {

	/**
	 * 获取教师列表
	 * @return
	 */
	public List<TbTeacher> getTeacherList();
	/**
	 * 新增教师
	 * @param teacher
	 * @return
	 */
	public ExamResult addTeacher(TbTeacher teacher);
	/**
	 * 修改教师信息
	 * @param id
	 * @return
	 */
	public ExamResult editTeacher(TbTeacher teacher);
	
	/**
	 * 删除教师
	 * @param ids
	 * @return
	 */
	public ExamResult deleteTeacher(Integer[] ids);
}
