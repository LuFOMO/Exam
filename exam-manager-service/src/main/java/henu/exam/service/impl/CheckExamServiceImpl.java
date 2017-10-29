package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.mapper.TbExamMapper;
import henu.exam.pojo.ExamResult;
import henu.exam.pojo.TbExam;
import henu.exam.pojo.TbExamExample;
import henu.exam.service.CheckExamService;

@Service
public class CheckExamServiceImpl implements CheckExamService{

	@Autowired
	private TbExamMapper examMapper;
	
	@Override
	public ExamResult checkExam() {
		TbExamExample example = new TbExamExample();
		List<TbExam> list = examMapper.selectByExample(example);
		if(list != null && list.size()>0){
			return ExamResult.ok();
		}else{
			return ExamResult.build(500, "暂时无法登录");
		}
	}

}
