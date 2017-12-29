package henu.exam.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import henu.exam.mapper.TbStudentMapper;
import henu.exam.pojo.EasyUIResult;
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
		criteria.andIpEqualTo(ip);
		List<TbStudent> studentList = studentMapper.selectByExample(example);
		if(studentList!=null && studentList.size()>0){
			TbStudent student = new TbStudent();
			student = studentList.get(0);
			return student;
		}
		return null;
	}

	@Override
	public int editStudentIP(Integer id) throws Exception{
		TbStudent student = studentMapper.selectByPrimaryKey(id);
		if(student!=null){
			student.setIpbinding("否");
			student.setIp(null);
			int i = studentMapper.updateByPrimaryKey(student);
			return i;
		}
		return 0;
	}

	@Override
	public int deleteStudent(Integer[] ids) {
		int i = 0;
		for (Integer id : ids) {
			i = studentMapper.deleteByPrimaryKey(id);
			if(i==0) {
				return i;
			}
		}
		return i;
	}

	@Override
	public EasyUIResult getStudentList(int page, int rows) {
		PageHelper.startPage(page, rows);
		TbStudentExample example = new TbStudentExample();
		List<TbStudent> list = studentMapper.selectByExample(example );
		PageInfo<TbStudent> pageInfo = new PageInfo<>(list);
		EasyUIResult result = new EasyUIResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

	@Override
	public int getPageSize() {
		String path = "G:/JavaEE/WorkSpace4/systemconfig.xml";
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File(path));
			Element root = doc.getRootElement();
			int pagesize = Integer.parseInt(root.elementText("pagesize"));
			return pagesize;
		} catch (DocumentException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int addStudentAll(Integer eid, MultipartFile file) throws Exception {
		InputStream is = file.getInputStream();
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		TbStudent student = null;
		int i = 0;
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					student = new TbStudent();
					HSSFCell sid = hssfRow.getCell(0);
					HSSFCell name = hssfRow.getCell(1);
					HSSFCell clazz = hssfRow.getCell(2);
					student.setSid(getValue(sid));
					student.setName(getValue(name));
					student.setClazz(getValue(clazz));
					student.setEid(eid);
					i = studentMapper.insert(student);
				}
			}
		}
		return i;
	}
	
	 @SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }		
	
}
