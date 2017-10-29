package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.mapper.TbExamMapper;
import henu.exam.pojo.ExamResult;
import henu.exam.pojo.TbExam;
import henu.exam.pojo.TbExamExample;
import henu.exam.service.AdminExamManageService;

@Service
public class AdminExamManageServiceImpl implements AdminExamManageService{

	@Autowired
	private TbExamMapper examMapper;
	
	@Override
	public List<TbExam> getExamList() {
		TbExamExample example = new TbExamExample();
		List<TbExam> list = examMapper.selectByExample(example);
		return list;
	}

	@Override
	public ExamResult cleanExam(Integer id) {
		return ExamResult.ok();
	}
	
	@Override
	public ExamResult deleteExam(Integer[] ids) {
		for (Integer id : ids) {
			examMapper.deleteByPrimaryKey(id);
		}
		return ExamResult.ok();
	}
}
