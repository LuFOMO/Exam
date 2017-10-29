package henu.exam.pojo;

public class Pass {
	
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String oldpass;
	private String newpass1;
	private String newpass2;
	
	public String getOldpass() {
		return oldpass;
	}
	public void setOldpass(String oldpass) {
		this.oldpass = oldpass;
	}
	public String getNewpass1() {
		return newpass1;
	}
	public void setNewpass1(String newpass1) {
		this.newpass1 = newpass1;
	}
	public String getNewpass2() {
		return newpass2;
	}
	public void setNewpass2(String newpass2) {
		this.newpass2 = newpass2;
	}
}
