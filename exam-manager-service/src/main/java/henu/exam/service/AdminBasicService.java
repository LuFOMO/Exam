package henu.exam.service;

import henu.exam.pojo.ExamResult;
import henu.exam.pojo.Pass;

public interface AdminBasicService {

	/**
	 * 管理员登录
	 * @param name
	 * @param pass
	 */
	public boolean adminLogin(String name, String pass);
	
	/**
	 * 修改管理员口令
	 * @param pass
	 * @return
	 */
	public ExamResult adminEditPass(Pass pass);
}
