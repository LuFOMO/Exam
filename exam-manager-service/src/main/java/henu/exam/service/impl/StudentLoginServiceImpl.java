package henu.exam.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public boolean studentLogin(String sid, String name, HttpServletRequest request) throws Exception{
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbStudent> studentList = studentMapper.selectByExample(example);
		TbStudent student = null;
		if(studentList!=null && studentList.size()>0){
			student = studentList.get(0);
			if(sid.equals(student.getSid())){
				//获取学生登录时的ip，更新数据库中学生状态
				String ip = request.getHeader("x-forwarded-for");
				if(ip == null){
					ip = request.getRemoteAddr();
				}	
				student.setIp(ip);
				student.setIpbinding("是");
				student.setIsLogin("是");
				studentMapper.updateByPrimaryKey(student);
				return true;
			}
		}
		return false;
	}

}
