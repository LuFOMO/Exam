package henu.exam.util;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FtpDeleteUtil{	

	/**
	 * 使用ftp删除文件
	 * @param remote
	 * @param ftpClient
	 * @return
	 */
	public static boolean deleteFile(String remote , FTPClient ftpClient){
		boolean result = true;
		try {
			if(!ftpClient.deleteFile(remote))
				result = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
		}
	
	/**
	 * 递归删除文件和目录
	 * @param remote
	 * @param ftpClient
	 * @return
	 */
	public static boolean deleteDirectory(String remote ,FTPClient ftpClient){
		boolean result = true;
		try{
			if(ftpClient.changeWorkingDirectory(remote)){
				FTPFile[] files = ftpClient.listFiles();
				for(FTPFile f : files){
					System.out.println(f.getName());
					if(f.isFile()){
						if(ftpClient.deleteFile(remote.equals("/") ? remote + f.getName() : remote + "/"+f.getName())) {
							System.out.println("remove "+f.getName());
						}else {
							return false;
						}
					}else {
						deleteDirectory(remote.equals("/") ? remote + f.getName() : remote + "/" + f.getName(),ftpClient);
					}
				}
				//目录为空，返回到父目录将空目录删除
				if(ftpClient.changeToParentDirectory()){
					if(!ftpClient.removeDirectory(remote)) {
					 	return false;
					}
				}
			}else {
				return false;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return result;
	}
}