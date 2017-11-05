package henu.exam.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

import henu.exam.pojo.SystemConfig;
import henu.exam.service.AdminManageSystemConfigService;
import henu.exam.util.ExamResult;

@Service
public class AdminManageSystemConfigServiceImpl implements AdminManageSystemConfigService{

	@Override
	public SystemConfig getSystemConfig() {
		try {
			String path = "F:/JavaEE/WorkSpace4/systemconfig.xml";
//			String path = "classpath*:/systemconfig/systemconfig.xml";
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new File(path));
			Element root = doc.getRootElement();
			SystemConfig config = new SystemConfig();
			config.setInterval(Integer.parseInt(root.elementText("interval")));
			config.setPagesize(Integer.parseInt(root.elementText("pagesize")));
			config.setTimegap(Integer.parseInt(root.elementText("timegap")));
			config.setMinfilesize(Integer.parseInt(root.elementText("minfilesize")));
			config.setMaxfilesize(Integer.parseInt(root.elementText("maxfilesize")));
			config.setCk(root.elementText("ck"));
			return config;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ExamResult editSystemConfig(SystemConfig config) throws Exception{
		
		String path = "F:/JavaEE/WorkSpace4/systemconfig.xml";
		Document doc = new SAXReader().read(new File(path));
		List<Element> list = doc.getRootElement().elements();
		list.get(0).setText(config.getInterval()+"");
		list.get(1).setText(config.getPagesize()+"");
		list.get(2).setText(config.getTimegap()+"");
		list.get(3).setText(config.getMinfilesize()+"");
		list.get(4).setText(config.getMaxfilesize()+"");
		if("on".equals(config.getCk())){
			list.get(5).setText("是");
		}else{
			list.get(5).setText("否");
		}
		
		FileOutputStream out = new FileOutputStream(path);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
		return ExamResult.ok();
	}

	
}
