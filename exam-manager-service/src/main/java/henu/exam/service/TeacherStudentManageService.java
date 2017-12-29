package henu.exam.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import henu.exam.pojo.EasyUIResult;
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
	
	/**
	 * 通过ip查找学生信息
	 * @param ip
	 * @return
	 */
	public TbStudent findStudentByIP(String ip);
	
	/**
	 * 解除学生ip绑定
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int editStudentIP(Integer id) throws Exception;
	
	/**
	 * 根据id删除学生信息
	 * @param id
	 * @return
	 */
	public int deleteStudent(Integer[] ids);
	
	/**
	 * 分页显示学生信息
	 * @return
	 */
	public EasyUIResult getStudentList(int page, int rows);
	
	/**
	 * 获取分页查询的条数
	 * @return
	 */
	public int getPageSize();
	
	/**
	 * 批量导入学生名单
	 * @param eid
	 * @param file
	 * @return
	 */
	public int addStudentAll(Integer eid, MultipartFile file) throws Exception;
	
}
