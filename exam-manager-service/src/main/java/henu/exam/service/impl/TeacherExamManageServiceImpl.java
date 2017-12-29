package henu.exam.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import henu.exam.mapper.TbExamMapper;
import henu.exam.mapper.TbStudentMapper;
import henu.exam.pojo.FileResult;
import henu.exam.pojo.TbExam;
import henu.exam.pojo.TbExamExample;
import henu.exam.pojo.TbStudentExample;
import henu.exam.pojo.TbStudentExample.Criteria;
import henu.exam.service.TeacherExamManageService;
import henu.exam.util.FtpUtil;

@Service
public class TeacherExamManageServiceImpl implements TeacherExamManageService{

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
	private TbExamMapper examMapper;
	@Autowired
	private TbStudentMapper studentMapper;
	
	@Override
	public List<TbExam> getExamList() {
		TbExamExample example = new TbExamExample();
		List<TbExam> examList = examMapper.selectByExample(example);
		return examList;
	}

	@Override
	public int getStudentNum() {
		TbStudentExample example = new TbStudentExample();
		int studentNum = studentMapper.countByExample(example );
		return studentNum;
	}
	
	@Override
	public int getStudentLoginNum() {
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsLoginEqualTo("是");
		int studentLoginNum = studentMapper.countByExample(example );
		return studentLoginNum;
	}

	@Override
	public int getStudentSubmitNum() {
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsSubmitEqualTo("是");
		int studentSubmitNum = studentMapper.countByExample(example );
		return studentSubmitNum;
	}

	@Override
	public int addExam(TbExam exam) throws Exception {
		
		//只允许存在一场考试，添加考试前先查询数据库。
		List<TbExam> examList = getExamList();
		if(examList!=null&&examList.size()>0) {
			return 0;
		}
		if("on".equals(exam.getAutostart())) {
			exam.setAutostart("是");
		}else {
			exam.setAutostart("否");
		}
		exam.setStarted("否");
		exam.setFinished("否");
		exam.setArchived("否");
		exam.setCleaned("否");
		int i = examMapper.insert(exam);
		return i;
	}

	@Override
	public TbExam getExamById(Integer id) {
		TbExam exam = examMapper.selectByPrimaryKey(id);
		return exam;
	}

	@Override
	public int editExam(TbExam exam) {
		if("on".equals(exam.getAutostart())) {
			exam.setAutostart("是");
		}else {
			exam.setAutostart("否");
		}
		exam.setStarted("否");
		exam.setFinished("否");
		exam.setArchived("否");
		exam.setCleaned("否");
		int i = examMapper.updateByPrimaryKey(exam);
		return i;
	}

	@Override
	public FileResult uploadExamPaper(Integer id, MultipartFile paper) throws Exception {
		FileResult fileResult = new FileResult();
		if(paper.isEmpty()) {
			fileResult.setError(1);
			fileResult.setMessage("未选中文件");
			return fileResult;
		}
		TbExam exam = examMapper.selectByPrimaryKey(id);
		
		String name = paper.getOriginalFilename();
		String examName = exam.getName();
		String filePath = "/"+examName+new DateTime().toString("/yyyy/MM/dd");
		try {
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD,
				FTP_BASE_PATH, filePath, name, paper.getInputStream());
			if(!result) {
				fileResult.setError(1);
				fileResult.setMessage("文件上传失败");
				return fileResult;
			}
			fileResult.setError(0);
			
			exam.setPaperUrl(FILE_BASE_URL + filePath + "/" + name);
			exam.setExampaper("是");
			examMapper.updateByPrimaryKey(exam);
			return fileResult;
		}catch(Exception e) {
			e.printStackTrace();
			fileResult.setError(1);
			fileResult.setMessage("文件上传失败");
			return fileResult;
		}
	}

	@Override
	public String downloadExamPaper(Integer id) {
		TbExam exam = examMapper.selectByPrimaryKey(id);
		if(exam!=null) {
			String paperUrl = exam.getPaperUrl();
			return paperUrl;
		}
		return null;
	}

	@Override
	public int cleanExam(Integer id) {
		int i = 0;
		TbExam exam = examMapper.selectByPrimaryKey(id);
		if(exam==null) {
			return i;
		}
		if(!"是".equals(exam.getArchived())) {
			return i;
		}
		//判断教师是否可以清理考试
		String right = checkHasRight();
		if(!"是".equals(right)) {
			return i;
		}
		exam.setCleaned("是");
		//删除本次考试学生信息
		TbStudentExample example = new TbStudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andEidEqualTo(id);
		i = studentMapper.deleteByExample(example );
		if(i==0) {
			return i;
		}
		//递归删除文件和目录
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
			//删除教师上传的试卷
			String path = FTP_BASE_PATH+"/"+exam.getName();
			boolean result = deleteDir(ftp, FTP_BASE_PATH);
			if(result==false) {
				return i;
			}
			//删除学生提交的答案
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (Exception ioe) {
				}
			}
		}
		//更新考试表
		i = examMapper.updateByPrimaryKey(exam);
		return i;
	}

	@Override
	public int deleteExam(Integer id) {
		int i = 0;
		TbExam exam = examMapper.selectByPrimaryKey(id);
		if(exam==null) {
			return i;
		}
		if(!"是".equals(exam.getCleaned())) {
			return i;
		}
		//判断教师是否可以清理考试
		String right = checkHasRight();
		if(!"是".equals(right)) {
			return i;
		}
		//删除考试
		i = examMapper.deleteByPrimaryKey(id);
		return i;
	}
	
	@Override
	public int calcExamTime(String start, String started, Integer id) {
		if("是".equals(started)) {
			TbExam exam = examMapper.selectByPrimaryKey(id);
			if(exam!=null) {
				exam.setStarted(started);
				int i = examMapper.updateByPrimaryKey(exam);
				return i;
			}
		}
		return 1;
	}

	@Override
	public int startExam(Integer id) {
		TbExam exam = examMapper.selectByPrimaryKey(id);
		if(exam!=null) {
			exam.setStarted("是");
			int i = examMapper.updateByPrimaryKey(exam);
			return i;
		}
		return 0;
	}

	/**
	 * 判断教师是否有清理和删除考试的权限
	 * @return
	 */
	public String checkHasRight() {
		try {
			String path = "G:/JavaEE/WorkSpace4/systemconfig.xml";
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(path));
			Element root = doc.getRootElement();
			return root.elementText("ck");
		}catch(Exception e) {
			return null;
		}
	}
	
	
	/**
	 * 递归删除文件和目录
	 * @param ftp
	 * @param dirPath
	 * @return
	 * @throws IOException
	 */
	private boolean deleteDir(FTPClient ftp, String dirPath) throws IOException {
		boolean result = true;
		try {
			//切换到上传目录
			if(!ftp.changeWorkingDirectory(dirPath)) {
				return false;
			}
			//列出当前目录下的所有文件
			FTPFile[] listFiles = ftp.listFiles();
			for (FTPFile file : listFiles) {
				System.out.println(file.toString());
				//如果为文件则删除
				if(file.isFile()) {
					if(!ftp.deleteFile(dirPath+"/"+file.getName())) {
						return false;
					}
				}else {
					deleteDir(ftp, dirPath+"/"+file.getName());
				}
			}
			if(ftp.changeToParentDirectory()) {
				//如果是空目录则删除
				if(!ftp.removeDirectory(dirPath)) {
					return false;
				}
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
