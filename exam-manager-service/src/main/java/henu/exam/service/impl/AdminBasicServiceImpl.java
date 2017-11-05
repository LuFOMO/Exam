package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.service.AdminBasicService;
import henu.exam.util.ExamResult;
import henu.exam.mapper.TbAdminMapper;
import henu.exam.pojo.TbAdmin;
import henu.exam.pojo.TbAdminExample;
import henu.exam.pojo.TbAdminExample.Criteria;
import henu.exam.pojo.Pass;

@Service
public class AdminBasicServiceImpl implements AdminBasicService{

	@Autowired
	private TbAdminMapper adminMapper;
	
	@Override
	public boolean adminLogin(String name, String pass) throws Exception{
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbAdmin> adminList = adminMapper.selectByExample(example );
		
		TbAdmin admin = null;
		if(adminList!=null && adminList.size()>0){
			admin = adminList.get(0);
			if(pass.equals(admin.getPassword())){
				return true;
			}
		}
		return false;
	}

	@Override
	public ExamResult adminEditPass(Pass pass) {
		String name = pass.getName();
		TbAdminExample example = new TbAdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbAdmin> adminList = adminMapper.selectByExample(example);
		TbAdmin admin = null;
		if(adminList!=null && adminList.size()>0){
			admin = adminList.get(0);
		}
		if(pass.getOldpass().equals(admin.getPassword())){
			admin.setPassword(pass.getNewpass1());
			adminMapper.updateByPrimaryKey(admin);
		}
		return ExamResult.ok();
	}
}
