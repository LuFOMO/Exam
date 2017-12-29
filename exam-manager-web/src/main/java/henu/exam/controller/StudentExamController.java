package henu.exam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import henu.exam.pojo.FileResult;
import henu.exam.pojo.TbFile;
import henu.exam.service.StudentExamService;
import henu.exam.util.CntValueCache;
import henu.exam.util.JsonUtils;

@Controller
public class StudentExamController {

	@Autowired
	private StudentExamService examService;
	
	/**
	 * 学生上传答案
	 * @param name
	 * @param answer
	 * @return
	 */
	@RequestMapping("/student/exam/file/upload")
	@ResponseBody
	public String uploadExamFile(String name, MultipartFile answer) {
		FileResult result = examService.uploadExamFile(name, answer);
		String json = JsonUtils.objectToJson(result);
		return json;
	}

	/**
	 * 学生查看已提交答案
	 * @param model
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/student/exam/paper/list")
	public String getUploadFile(Model model, HttpSession session) {
		String name = (String)session.getAttribute("name");
		if(name!=null) {
			TbFile file = examService.getUploadFile(name);
			model.addAttribute("file", file);
			return "/student/listdir";
		}else {
			return null;
		}
	}
	
	/**
	 * 获取通知
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/student/exam/get/notify", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getExamNotify(Model model) { 
		try {
			Object notifyList = CntValueCache.get("notifyList");
			if(notifyList!=null) {
				List<String> list = (List<String>) notifyList;
				String json = JsonUtils.objectToJson(list);
				return json;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
