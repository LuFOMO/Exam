package henu.exam.service;

import henu.exam.pojo.SystemConfig;
import henu.exam.util.ExamResult;

public interface AdminManageSystemConfigService {

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
