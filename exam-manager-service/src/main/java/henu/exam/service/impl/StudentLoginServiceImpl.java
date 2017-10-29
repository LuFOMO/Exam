package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.mapper.TbStudentMapper;
import henu.exam.pojo.TbStudent;
import henu.exam.pojo.TbStudentExample;
import henu.exam.pojo.TbStudentExample.Criteria;
import henu.exam.service.StudentLoginService;

@Service
public class StudentLoginServiceImpl implements StudentLoginService{

	@Autowired
	private TbStudentMapper studentMapper;
	@Override
	public boolean studentLogin(String sid, String name) {
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbStudent> studentList = studentMapper.selectByExample(example);
		TbStudent student = null;
		if(studentList!=null && studentList.size()>0){
			student = studentList.get(0);
			if(sid.equals(student.getSid())){
				return true;
			}
		}
		return false;
	}

}
