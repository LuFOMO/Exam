package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import henu.exam.mapper.TbTeacherMapper;
import henu.exam.pojo.Pass;
import henu.exam.pojo.TbTeacher;
import henu.exam.pojo.TbTeacherExample;
import henu.exam.pojo.TbTeacherExample.Criteria;
import henu.exam.service.TeacherBasicService;
import henu.exam.util.ExamResult;

@Service
public class TeacherBasicServiceImpl implements TeacherBasicService{

	@Autowired
	private TbTeacherMapper teacherMapper;
	
	@Override
	public boolean teacherLogin(String name, String pass) {
		TbTeacherExample example = new TbTeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbTeacher> teacherList = teacherMapper.selectByExample(example);
		TbTeacher teacher = null;
		if(teacherList!=null && teacherList.size()>0){
			teacher = teacherList.get(0);
			if(teacher.getPassword().equals(DigestUtils.md5DigestAsHex(pass.getBytes()))){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public ExamResult teacherEditPass(Pass pass) {
		String name = pass.getName();
		TbTeacherExample example = new TbTeacherExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbTeacher> teacherList = teacherMapper.selectByExample(example);
		TbTeacher teacher = null;
		if(teacherList!=null && teacherList.size()>0){
			teacher = teacherList.get(0);
		}
		if(pass.getOldpass().equals(DigestUtils.md5DigestAsHex(teacher.getPassword().getBytes()))){
			teacher.setPassword(DigestUtils.md5DigestAsHex(pass.getNewpass1().getBytes()));
			teacherMapper.updateByPrimaryKey(teacher);
		}
		return ExamResult.ok();
	}

}
