package henu.exam.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

public class DownloadUtil{

	/**
	 * 通过浏览器下载本地文件
	 * @param path
	 * @param response
	 * @return
	 */
	public static HttpServletResponse fromLocalByBrowser(String path, HttpServletResponse response) {
	    try {
	      // path是指欲下载的文件的路径。
	      File file = new File(path);
	      // 取得文件名。
	      String filename = file.getName();
	      // 以流的形式下载文件。
	      InputStream fis = new BufferedInputStream(new FileInputStream(path));
	      byte[] buffer = new byte[fis.available()];
	      fis.read(buffer);
	      // 清空response
	      response.reset();
	      // 设置response的Header
	      response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
	      response.addHeader("Content-Length", "" + file.length());
	      OutputStream os = new BufferedOutputStream(response.getOutputStream());
	      response.setContentType("application/octet-stream");
	      os.write(buffer);
	      os.flush();
	      os.close();
	      fis.close();
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    }
	    return response;
	  }
	/**
	 * 通过浏览器下载网络文件
	 * @param  url     
	 * @param  response 
	 * @return          
	 */
	public static HttpServletResponse fromUrlByBrowser(String urlStr, HttpServletResponse response) {
	    try {
	    	URL url = new URL(urlStr);    
		    HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
		    //设置超时间为3秒  
		    conn.setConnectTimeout(3*1000);  
		    //防止屏蔽程序抓取而返回403错误  
		    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
		
		    //得到输入流  
		    InputStream is = conn.getInputStream();
	        // 取得文件名
	        String filename = urlStr.substring(urlStr.lastIndexOf("/")+1);
	   
	        // 以流的形式下载文件。
	        InputStream fis = new BufferedInputStream(is);
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        // 清空response
	        response.reset();
	        // 设置response的Header
	        response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
	        OutputStream os = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");
	        os.write(buffer);
	        os.flush();
	        os.close();
	        fis.close();
	      } catch (IOException ex) {
	        ex.printStackTrace();
	      }
	    return response;
  }
	
	
	/** 
	* 从网络Url中下载文件 
	* @param urlStr 
	* @param fileName 
	* @param savePath 
	* @throws IOException 
	*/  
	public static void  fromUrl(String urlStr,String fileName,String savePath) {
		try {
		    URL url = new URL(urlStr);    
		    HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
		    //设置超时间为3秒  
		    conn.setConnectTimeout(3*1000);  
		    //防止屏蔽程序抓取而返回403错误  
		    conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
		
		    //得到输入流  
		    InputStream is = conn.getInputStream();  
		    
		    // 以流的形式下载文件。
	        InputStream fis = new BufferedInputStream(is);
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
		    //文件保存位置  
		    File saveDir = new File(savePath);  
		    if(!saveDir.exists()){  
		        saveDir.mkdir();  
		    }  
		    File file = new File(saveDir+File.separator+fileName);      
		    FileOutputStream fos = new FileOutputStream(file);       
		    fos.write(buffer);  
		    fos.flush();
		    fos.close();    
		    fis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}  	
}

