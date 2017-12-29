package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
			if(admin.getPassword().equals(DigestUtils.md5DigestAsHex(pass.getBytes()))){
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
		if(pass.getOldpass().equals(DigestUtils.md5DigestAsHex(admin.getPassword().getBytes()))){
			admin.setPassword(DigestUtils.md5DigestAsHex(pass.getNewpass1().getBytes()));
			adminMapper.updateByPrimaryKey(admin);
		}
		return ExamResult.ok();
	}
}
