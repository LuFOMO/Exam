package henu.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import henu.exam.service.AdminTeacherManageService;
import henu.exam.util.ExamResult;
import henu.exam.mapper.TbAdminMapper;
import henu.exam.mapper.TbTeacherMapper;
import henu.exam.pojo.TbAdmin;
import henu.exam.pojo.TbAdminExample;
import henu.exam.pojo.TbAdminExample.Criteria;
import henu.exam.pojo.TbTeacher;
import henu.exam.pojo.TbTeacherExample;

@Service
public class AdminTeacherManageServiceImpl implements AdminTeacherManageService{

	@Autowired
	private TbTeacherMapper teacherMapper;
	@Autowired
	private TbAdminMapper adminMapper;
	
	@Override
	public ExamResult addTeacher(TbTeacher teacher) throws Exception{
		//如果设置为管理员，则应将教师信息添加到管理员表中。
		if("on".equals(teacher.getIsAdmin())){
			teacher.setIsAdmin("是");
			TbAdmin admin = new TbAdmin();
			admin.setName(teacher.getName());
			admin.setPassword((teacher.getPassword()));
			admin.setFullname(teacher.getFullname());
			adminMapper.insert(admin);
		}else{
			teacher.setIsAdmin("否");
		}
		int i = teacherMapper.insert(teacher);
		if(i!=1){
			return ExamResult.build(500, "新增教师失败");
		}
		return ExamResult.ok();
	}

	@Override
	public List<TbTeacher> getTeacherList() throws Exception{
		TbTeacherExample example =new TbTeacherExample();
		List<TbTeacher> teacherList = teacherMapper.selectByExample(example );
		return teacherList;
	}
	
	@Override
	public ExamResult editTeacher(TbTeacher teacher) throws Exception{
		if("on".equals(teacher.getIsAdmin())){
			teacher.setIsAdmin("是");
			//判断管理员表中是否有教师信息，有则更新，无则新建。
			TbAdminExample example = new TbAdminExample();
			Criteria criteria = example.createCriteria();
			criteria.andNameEqualTo(teacher.getName());
			List<TbAdmin> adminList = adminMapper.selectByExample(example);
			TbAdmin admin = new TbAdmin();
			admin.setName(teacher.getName());
			admin.setPassword((teacher.getPassword()));
			admin.setFullname(teacher.getFullname());
			if (adminList==null ||adminList.size()== 0) {
				adminMapper.insert(admin);
			}else{
				adminMapper.updateByPrimaryKey(admin);
			}
		}else{
			teacher.setIsAdmin("否");
		}
		int i = teacherMapper.updateByPrimaryKey(teacher);
		if(i!=1){
			return ExamResult.build(500, "修改教师信息失败");
		}
		return ExamResult.ok();
	}

	@Override
	public ExamResult deleteTeacher(Integer[] ids) throws Exception{
		for (Integer id : ids) {
			//判断管理员表中是否有教师信息，有则删除。
			TbTeacher teacher = teacherMapper.selectByPrimaryKey(id);
			TbAdminExample example = new TbAdminExample();
			Criteria criteria = example.createCriteria();
			criteria.andNameEqualTo(teacher.getName());
			List<TbAdmin> adminList = adminMapper.selectByExample(example );
			if(adminList!=null && adminList.size()>0){
				TbAdmin admin = adminList.get(0);
				adminMapper.deleteByPrimaryKey(admin.getId());
			}
			
			//删除教师
			int i = teacherMapper.deleteByPrimaryKey(id);
			if(i!=1){
				return ExamResult.build(500, "删除教师失败");
			}
		}
		return ExamResult.ok();
	}

}
