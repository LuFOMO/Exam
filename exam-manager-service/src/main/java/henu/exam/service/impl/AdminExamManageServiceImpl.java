package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.mapper.TbExamMapper;
import henu.exam.pojo.TbExam;
import henu.exam.pojo.TbExamExample;
import henu.exam.service.AdminExamManageService;
import henu.exam.util.ExamResult;

@Service
public class AdminExamManageServiceImpl implements AdminExamManageService{

	@Autowired
	private TbExamMapper examMapper;
	
	@Override
	public List<TbExam> getExamList() throws Exception{
		TbExamExample example = new TbExamExample();
		List<TbExam> list = examMapper.selectByExample(example);
		return list;
	}

	@Override
	public ExamResult cleanExam(Integer id) throws Exception{
		return ExamResult.ok();
	}
	
	@Override
	public ExamResult deleteExam(Integer[] ids) throws Exception{
		for (Integer id : ids) {
			int i = examMapper.deleteByPrimaryKey(id);
			if(i!=1){
				return ExamResult.build(500, "删除考试失败");
			}
		}
		return ExamResult.ok();
	}
}
