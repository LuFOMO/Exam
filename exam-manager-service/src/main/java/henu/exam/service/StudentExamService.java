package henu.exam.service;

import org.springframework.web.multipart.MultipartFile;

import henu.exam.pojo.FileResult;
import henu.exam.pojo.TbFile;

public interface StudentExamService {

	/**
	 * 学生提交答案
	 * @param name
	 * @param file
	 * @return
	 */
	public FileResult uploadExamFile(String name, MultipartFile answer);
	
	/**
	 * 学生查看已提交答案
	 * @return
	 */
	public TbFile getUploadFile(String name);
	
	/**
	 * 获取系统配置中后台时间间隔
	 * @return
	 */
	public int getInterval();
	
}
