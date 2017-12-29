package henu.exam.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import henu.exam.mapper.TbFileMapper;
import henu.exam.mapper.TbStudentMapper;
import henu.exam.pojo.FileResult;
import henu.exam.pojo.TbFile;
import henu.exam.pojo.TbStudent;
import henu.exam.pojo.TbStudentExample;
import henu.exam.pojo.TbStudentExample.Criteria;
import henu.exam.service.StudentExamService;
import henu.exam.util.FtpUtil;

@Service
public class StudentExamServiceImpl implements StudentExamService {

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${FILE_BASE_URL}")
	private String FILE_BASE_URL;	
	
	@Autowired
	private TbStudentMapper studentMapper;
	@Autowired
	private TbFileMapper fileMapper;
	
	@Override
	public FileResult uploadExamFile(String name, MultipartFile answer) {
		FileResult fileResult = new FileResult();
		if(answer.isEmpty()) {
			fileResult.setError(1);
			fileResult.setMessage("未选中文件");
			return fileResult;
		}
		TbStudent student = new TbStudent();
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbStudent> studentList = studentMapper.selectByExample(example);
		if(studentList!=null && studentList.size()>0) {
			student = studentList.get(0);
		}
		String filePath = "/"+student.getClazz();
		//原始文件名
		String oldName = answer.getOriginalFilename();
		// 取扩展名
		String extName = oldName.substring(oldName.lastIndexOf("."));
		//限制上传文件为压缩文件
		if(!".zip".equals(extName) && !".rar".equals(extName) && !".7z".equals(extName)) {
			fileResult.setError(1);
			fileResult.setMessage("文件上传失败");
			return fileResult;
		}
		//文件命名方式为学号_姓名
		String newName = student.getSid()+"_"+student.getName()+extName;
		try {
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
					FTP_BASE_PATH, filePath, newName, answer.getInputStream());
			if(!result) {
				fileResult.setError(1);
				fileResult.setMessage("文件上传失败");
				return fileResult;
			}
			//上传成功 
			fileResult.setError(0);
			student.setIsSubmit("是");
			student.setSubmitUrl(FILE_BASE_URL+filePath+"/"+newName);
			studentMapper.updateByPrimaryKey(student);
			//生成学生对应的答案信息
			TbFile file = new TbFile();
			file.setSid(student.getId());
			file.setFilename(newName);
			file.setFilesize((int)answer.getSize());
			Date date = new Date();
			String uploadtime = date.toLocaleString();
			file.setUploadtime(uploadtime);
			//学生如果重复提交，应更新答案信息
			TbFile existFile = fileMapper.selectByPrimaryKey(student.getId());
			int i = 0;
			if(existFile==null) {
				i = fileMapper.insert(file);
			}
			i = fileMapper.updateByPrimaryKey(file);
			if(i==0) {
				fileResult.setError(1);
				fileResult.setMessage("文件上传失败");
				return fileResult;
			}
			return fileResult;
		} catch (IOException e) {
			e.printStackTrace();
			fileResult.setError(1);
			fileResult.setMessage("文件上传失败");
			return fileResult;
		}
	}

	@Override
	public TbFile getUploadFile(String name) {
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		List<TbStudent> list = studentMapper.selectByExample(example );
		TbStudent student = new TbStudent();
		if(list!=null && list.size()>0) {
			student = list.get(0);
		}
		Integer id = student.getId();
		TbFile file = fileMapper.selectByPrimaryKey(id);
		return file;
	}

	public int getInterval() {
		try {
			String path = "G:/JavaEE/WorkSpace4/systemconfig.xml";
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(path));
			Element root = doc.getRootElement();
			int interval = Integer.parseInt(root.elementText("interval"));
			//转换为毫秒值
			return interval*60*1000;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
