package henu.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import henu.exam.pojo.SystemConfig;
import henu.exam.service.AdminManageSystemConfigService;
import henu.exam.util.ExamResult;

@SessionAttributes(value="{config}", types=SystemConfig.class)
@Controller
public class AdminManageSystemConfigController {

	@Autowired
	private AdminManageSystemConfigService systemConfigService;
	
	/**
	 * 获取配置信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/system/config")
	public String getSystemConfig(Model model){
		SystemConfig config = systemConfigService.getSystemConfig();
		model.addAttribute("config", config);
		return "redirect:/admin/config";
	}
	
	/**
	 * 修改配置信息
	 * @param config
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/admin/config/edit")
	@ResponseBody
	public ExamResult editSystemConfig(SystemConfig config) throws Exception{
		ExamResult result = systemConfigService.editSystemConfig(config);
		return result;
	}
}