package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.mapper.TbStudentMapper;
import henu.exam.pojo.TbStudent;
import henu.exam.pojo.TbStudentExample;
import henu.exam.pojo.TbStudentExample.Criteria;
import henu.exam.service.TeacherStudentManageService;
import henu.exam.util.ExamResult;

@Service
public class TeacherStudentManageServiceImpl implements TeacherStudentManageService{

	@Autowired
	private TbStudentMapper studentMapper;

	@Override
	public ExamResult addStudent(TbStudent student) {
		studentMapper.insert(student);
		return ExamResult.ok();
	}

	@Override
	public TbStudent findStudent(String sid, String name, String clazz) {
		
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		List<TbStudent> studentList = null;
		TbStudent student = new TbStudent();
		if(!"".equals(sid)){
			criteria.andSidEqualTo(sid);
			studentList = studentMapper.selectByExample(example);
		}
		if(!"".equals(name)){
			criteria.andNameEqualTo(name);
			criteria.andClazzEqualTo(clazz);
			studentList = studentMapper.selectByExample(example);
		}
		if(studentList!=null && studentList.size()>0){
			student = studentList.get(0);
			return student;
		}
		return null;
	}

	@Override
	public TbStudent findStudentByIP(String ip) {
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIpbindingEqualTo(ip);
		List<TbStudent> studentList = studentMapper.selectByExample(example);
		if(studentList!=null && studentList.size()>0){
			TbStudent student = new TbStudent();
			student = studentList.get(0);
			return student;
		}
		return null;
	}
	
	
	
}
