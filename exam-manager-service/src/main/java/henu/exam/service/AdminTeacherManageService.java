package henu.exam.service;

import java.util.List;

import henu.exam.pojo.TbTeacher;
import henu.exam.util.ExamResult;

public interface AdminTeacherManageService {

	/**
	 * 获取教师列表
	 * @return
	 */
	public List<TbTeacher> getTeacherList() throws Exception;
	/**
	 * 新增教师
	 * @param teacher
	 * @return
	 */
	public ExamResult addTeacher(TbTeacher teacher) throws Exception;
	/**
	 * 修改教师信息
	 * @param id
	 * @return
	 */
	public ExamResult editTeacher(TbTeacher teacher) throws Exception;
	
	/**
	 * 删除教师
	 * @param ids
	 * @return
	 */
	public ExamResult deleteTeacher(Integer[] ids) throws Exception;
}
