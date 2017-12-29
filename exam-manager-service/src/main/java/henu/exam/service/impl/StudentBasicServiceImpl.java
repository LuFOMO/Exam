package henu.exam.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.mapper.TbExamMapper;
import henu.exam.mapper.TbStudentMapper;
import henu.exam.pojo.TbExam;
import henu.exam.pojo.TbExamExample;
import henu.exam.pojo.TbStudent;
import henu.exam.pojo.TbStudentExample;
import henu.exam.pojo.TbStudentExample.Criteria;
import henu.exam.service.StudentBasicService;

@Service
public class StudentBasicServiceImpl implements StudentBasicService{

	@Autowired
	private TbStudentMapper studentMapper;
	@Autowired
	private TbExamMapper examMapper;
	
	@Override
	public TbExam checkExam() {
		TbExam exam = new TbExam();
		TbExamExample example = new TbExamExample();
		List<TbExam> list = examMapper.selectByExample(example);
		if(list != null && list.size()>0){
			exam = list.get(0);
			return exam;
		}else{
			return null;
		}
	}
	
	@Override
	public int studentLogin(String sid, String name, HttpServletRequest request) throws Exception{
		int i = 0;
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbStudent> studentList = studentMapper.selectByExample(example);
		TbStudent student = null;
		if(studentList!=null && studentList.size()>0){
			student = studentList.get(0);
			//在登录前应判断学生的ip地址是否绑定，若绑定则不能登录
			if("是".equals(student.getIpbinding())) {
				return i;
			}
			if(sid.equals(student.getSid())){
				//获取学生登录时的ip，更新数据库中学生状态
				String ip = request.getHeader("x-forwarded-for");
				if(ip == null){
					ip = request.getRemoteAddr();
				}	
				student.setIp(ip);
				student.setIpbinding("是");
				student.setIsLogin("是");
				i = studentMapper.updateByPrimaryKey(student);
				return i;
			}
		}
		return i;
	}

	@Override
	public int studentLogout(String name)  throws Exception{
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbStudent> studentList = studentMapper.selectByExample(example);
		TbStudent student = null;
		if(studentList!=null && studentList.size()>0){
			student = studentList.get(0);
			//解除绑定
			student.setIpbinding("否");
			int i = studentMapper.updateByPrimaryKey(student);
			return i;
		}
		return 0;
	}
	
	

}
