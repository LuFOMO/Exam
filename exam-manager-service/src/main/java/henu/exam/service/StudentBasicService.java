package henu.exam.service;

import javax.servlet.http.HttpServletRequest;

import henu.exam.pojo.TbExam;

public interface StudentBasicService {

	/**
	 * 判断学生是否可以登录
	 * @return
	 */
	public TbExam checkExam();
	
	/**
	 * 学生登录
	 * @param sid
	 * @param name
	 * @return
	 */
	public int studentLogin(String sid, String name,  HttpServletRequest request) throws Exception;
	
	/**
	 * 学生退出
	 * @param name
	 * @return
	 */
	public int studentLogout(String name) throws Exception;
	
}
