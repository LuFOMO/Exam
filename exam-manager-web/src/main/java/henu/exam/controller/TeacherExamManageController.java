package henu.exam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import henu.exam.pojo.FileResult;
import henu.exam.pojo.StudentMessage;
import henu.exam.pojo.TbExam;
import henu.exam.service.TeacherExamManageService;
import henu.exam.util.CntValueCache;
import henu.exam.util.DownloadUtil;
import henu.exam.util.ExamResult;
import henu.exam.util.JsonUtils;

@Controller
public class TeacherExamManageController {

	@Autowired
	private TeacherExamManageService examManagerService;
	
	/**
	 * 新增考试
	 * @param exam
	 * @return
	 */
	@RequestMapping("/teacher/exam/add")
	@ResponseBody
	public ExamResult addExam(TbExam exam) {
		try {
			int i = 0;
			if(exam.getName()!=null &&exam.getStarttime()!=null) {
				i = examManagerService.addExam(exam);
			}
			if(i==1) {
				return ExamResult.ok();
			}else {
				return ExamResult.build(500, "新增考试失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ExamResult.build(500, "新增考试失败");
		}
	}
	/**
	 * 获取所有的考试
	 * @return
	 */     
	@RequestMapping("/teacher/exam/list")
	public String getExamList(Model model){
		List<TbExam> examList = examManagerService.getExamList();
		model.addAttribute("examList", examList);
		return "/teacher/exam_before";
	}

	/**
	 * 获取考试概况
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacher/get/student/message")
	public String getStudentMessage(Model model){
		int studentNum = examManagerService.getStudentNum();
		int studentLoginNum = examManagerService.getStudentLoginNum();
		int studentSubmitNum = examManagerService.getStudentSubmitNum();
		
		StudentMessage studentMsg = new StudentMessage();
		studentMsg.setTotalNum(studentNum);
		studentMsg.setLoginNum(studentLoginNum);
		studentMsg.setUnloginNum(studentNum-studentLoginNum);
		studentMsg.setSubmitNum(studentSubmitNum);
		studentMsg.setUnsumbitNum(studentNum-studentSubmitNum);
		
		model.addAttribute("studentMsg", studentMsg);
		return "/teacher/manage_summary";
	}
	
	/**
	 * 根据id获取考试信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/teacher/exam/edit/{id}")
	public String getExamById(Model model, @PathVariable Integer id) {
		TbExam exam = examManagerService.getExamById(id);
		model.addAttribute("exam", exam);
		return "/teacher/exam_modify";
	}
	
	/**
	 * 编辑考试信息
	 * @param exam
	 * @return
	 */
	@RequestMapping("/teacher/exam/edit")
	@ResponseBody
	public ExamResult editExam(TbExam exam) {
		try {
			int i = examManagerService.editExam(exam);
			if(i==1) {
				return ExamResult.ok();
			}else {
				return ExamResult.build(500, "编辑考试失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ExamResult.build(500, "编辑考试失败");
		}
	}
	
	/**
	 * 上传试卷
	 * @param id
	 * @param paper
	 * @return
	 */
	@RequestMapping("/teacher/exam/upload")
	@ResponseBody
	public String uploadExamPaper(Integer id, MultipartFile paper) throws Exception{
		FileResult result = examManagerService.uploadExamPaper(id, paper);
		String json = JsonUtils.objectToJson(result);
		return json;
	}
	
	/**
	 * 下载查看试卷
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/teacher/exam/download/{id}")
	public void downloadExamPaper(HttpServletResponse response, @PathVariable Integer id) throws Exception {
		String paperUrl = examManagerService.downloadExamPaper(id);
		DownloadUtil.fromUrlByBrowser(paperUrl, response);
	}
	
	/**
	 * 获取考试结束后的考试列表
	 * @return
	 */     
	@RequestMapping("/teacher/exam/after")
	public String getExamAfter(Model model){
		List<TbExam> examList = examManagerService.getExamList();
		model.addAttribute("examList", examList);
		return "/teacher/exam_after";
	}
	
	/**
	 * 考后清理
	 * @param id
	 * @return
	 */
	@RequestMapping("/teacher/exam/clean/{id}")
	public String examClean(@PathVariable Integer id) {
		int i = examManagerService.cleanExam(id);
		if(i==1) {
			//返回清理后的页面
			return "/teacher/exam_after";
		}else {
			//返回未清理的页面
			return "/teacher/exam_after";
		}
	}
	
	/**
	 * 删除考试
	 * @param id
	 * @return
	 */
	@RequestMapping("/teacher/exam/delete/{id}")
	public String deleteExam(@PathVariable Integer id) {
		int i = examManagerService.deleteExam(id);
		if(i==1) {
			return "/teacher/exam_after";
		}else {
			return "/teacher/exam_after";
		}
	}
	
	/**
	 * 获取通知列表
	 * @param request
	 * @return
	 */
	@RequestMapping("/teacher/manage/notify")
	public String getNofityList(HttpServletRequest request) {
		try {
			Object notifyList = CntValueCache.get("notifyList");
			if(notifyList!=null) {
				List<String> list = (List<String>) notifyList;
				request.setAttribute("notify", list);
			}
			return "/teacher/manage_notify";
		} catch (Exception e) {
			e.printStackTrace();
			return "/teacher/manage_notify";
		}
	}
	
	/**
	 * 判断考试是否可以开始
	 * @param start
	 * @param started
	 * @param id
	 * @return
	 */
	@RequestMapping("/teacher/exam/calcTime")
	@ResponseBody
	public ExamResult calcExamTime(HttpServletRequest request, String start, String started, Integer id) {
		examManagerService.calcExamTime(start, started, id);
		request.getSession().setAttribute("start", start);
		request.getSession().setAttribute("started", started);
		return ExamResult.ok();
	}
	
	/**
	 * 新增通知
	 * @param notice
	 * @return
	 */
	@RequestMapping("/teacher/manage/notify/add")
	@ResponseBody
	public ExamResult addNotify(String notice) {
		if(StringUtils.isBlank(notice)) {
			return ExamResult.build(500, "新增通知失败");
		}
		Object notifyList = CntValueCache.get("notifyList");
		List<String> list = null;
		if(notifyList==null) {
			list = new ArrayList<String>();
		}else {
			list = (List<String>)notifyList;
		}
		list.add(notice);
		CntValueCache.put("notifyList", list);
		return ExamResult.ok();
	}
	
	/**
	 * 删除通知
	 * @param id
	 */
	@RequestMapping("/teacher/manage/notify/delete")
	@ResponseBody
	public ExamResult deleteNotify(Integer id) {
		if(id==null) {
			return ExamResult.build(500, "删除通知失败");
		}
		try {
			List<String> notifyList = (List<String>)CntValueCache.get("notifyList");
			notifyList.remove((int)id);
			CntValueCache.put("notifyList", notifyList);
			return ExamResult.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ExamResult.build(500, "删除通知失败");
		}
		
	}
}
