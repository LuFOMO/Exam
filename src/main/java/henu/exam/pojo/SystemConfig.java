package henu.exam.pojo;

public class SystemConfig {
	
	private int interval;
	private int pagesize;
	private int timegap;
	private int minfilesize;
	private int maxfilesize;
	private String ck;
	
	
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTimegap() {
		return timegap;
	}
	public void setTimegap(int timegap) {
		this.timegap = timegap;
	}
	public int getMinfilesize() {
		return minfilesize;
	}
	public void setMinfilesize(int minfilesize) {
		this.minfilesize = minfilesize;
	}
	public int getMaxfilesize() {
		return maxfilesize;
	}
	public void setMaxfilesize(int maxfilesize) {
		this.maxfilesize = maxfilesize;
	}
	public String getCk() {
		return ck;
	}
	public void setCk(String ck) {
		this.ck = ck;
	}

}
