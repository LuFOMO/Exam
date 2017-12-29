package henu.exam.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import henu.exam.pojo.FileResult;
import henu.exam.pojo.TbExam;

public interface TeacherExamManageService {

	/**
	 * 新增考试
	 * @return
	 */
	public int addExam(TbExam Exam) throws Exception;
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
	
	/**
	 * 根据id获取考试信息
	 * @param id
	 * @return
	 */
	public TbExam getExamById(Integer id);
	
	public int editExam(TbExam exam);
	
	/**
	 * 上传试卷
	 * @return
	 */
	public FileResult uploadExamPaper(Integer id, MultipartFile paper) throws Exception;
	
	/**
	 * 下载查看试卷
	 * @param id
	 * @return
	 */
	public String downloadExamPaper(Integer id);
	
	/**
	 * 判断考试是否可以开始
	 * @param getTime
	 * @param id
	 * @return
	 */
	public int calcExamTime(String start, String started, Integer id);
	
	/**
	 * 开启考试
	 * @param id
	 * @return
	 */
	public int startExam(Integer id);
	
	/**
	 * 考试清理
	 * @param id
	 * @return
	 */
	public int cleanExam(Integer id);
	
	/**
	 * 删除考试
	 * @param id
	 * @return
	 */
	public int deleteExam(Integer id);
}
