package henu.exam.service;

public interface StudentLoginService {

	/**
	 * 学生登录
	 * @param sid
	 * @param name
	 * @return
	 */
	public boolean studentLogin(String sid, String name);
}
