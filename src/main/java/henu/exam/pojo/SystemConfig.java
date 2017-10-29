package henu.exam.pojo;

public class SystemConfig {
	
	private int interval;
	private int pagesize;
	private int timegap;
	private long minfilesize;
	private long maxfilesize;
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
	public long getMinfilesize() {
		return minfilesize;
	}
	public void setMinfilesize(long minfilesize) {
		this.minfilesize = minfilesize;
	}
	public long getMaxfilesize() {
		return maxfilesize;
	}
	public void setMaxfilesize(long maxfilesize) {
		this.maxfilesize = maxfilesize;
	}
	public String getCk() {
		return ck;
	}
	public void setCk(String ck) {
		this.ck = ck;
	}

}
