package henu.exam.service;

import javax.servlet.http.HttpServletRequest;

public interface StudentLoginService {

	/**
	 * 学生登录
	 * @param sid
	 * @param name
	 * @return
	 */
	public boolean studentLogin(String sid, String name,  HttpServletRequest request) throws Exception;
}
