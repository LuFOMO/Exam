package henu.exam.service;

import henu.exam.pojo.Pass;
import henu.exam.util.ExamResult;

public interface AdminBasicService {

	/**
	 * 管理员登录
	 * @param name
	 * @param pass
	 */
	public boolean adminLogin(String name, String pass) throws Exception;
	
	/**
	 * 修改管理员口令
	 * @param pass
	 * @return
	 */
	public ExamResult adminEditPass(Pass pass);
}
