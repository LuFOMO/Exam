package henu.exam.pojo;
/**
 * 上传文件返回值
 * @author 茶沫儿
 *
 */
public class FileResult {

	/**
	 * 上传文件返回值，成功：0	失败：1	
	 */
	private Integer error;
	/**
	 * 错误时的错误消息
	 */
	private String message;
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
