package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.mapper.TbExamMapper;
import henu.exam.mapper.TbStudentMapper;
import henu.exam.pojo.StudentMessage;
import henu.exam.pojo.TbExam;
import henu.exam.pojo.TbExamExample;
import henu.exam.pojo.TbStudentExample;
import henu.exam.pojo.TbStudentExample.Criteria;
import henu.exam.service.TeacherExamManageService;

@Service
public class TeacherExamManageServiceImpl implements TeacherExamManageService{

	@Autowired
	private TbExamMapper examMapper;
	@Autowired
	private TbStudentMapper studentMapper;
	
	@Override
	public List<TbExam> getExamList() {
		TbExamExample example = new TbExamExample();
		List<TbExam> examList = examMapper.selectByExample(example );
		return examList;
	}

	@Override
	public int getStudentNum() {
		TbStudentExample example = new TbStudentExample();
		int studentNum = studentMapper.countByExample(example );
		return studentNum;
	}
	
	@Override
	public int getStudentLoginNum() {
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsLoginEqualTo("是");
		int studentLoginNum = studentMapper.countByExample(example );
		return studentLoginNum;
	}

	@Override
	public int getStudentSubmitNum() {
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsSubmitEqualTo("是");
		int studentSubmitNum = studentMapper.countByExample(example );
		return studentSubmitNum;
	}

}
