package henu.exam.service;

import henu.exam.pojo.ExamResult;
import henu.exam.pojo.SystemConfig;

public interface ManageSystemConfigService {

	/**
	 * 获取系统配置信息
	 * @return
	 */
	public SystemConfig getSystemConfig();
	
	/**
	 * 修改系统配置信息
	 */
	public ExamResult editSystemConfig(SystemConfig config)throws Exception;
}
