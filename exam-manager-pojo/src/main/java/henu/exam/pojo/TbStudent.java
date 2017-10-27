package henu.exam.pojo;

import java.util.Date;

public class TbStudent {
    private Integer id;

    private String sid;

    private String name;

    private String clazz;

    private String ip;

    private String isLogin;

    private String ipbinding;

    private String isSubmit;

    private Date submittime;

    private String submitUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin == null ? null : isLogin.trim();
    }

    public String getIpbinding() {
        return ipbinding;
    }

    public void setIpbinding(String ipbinding) {
        this.ipbinding = ipbinding == null ? null : ipbinding.trim();
    }

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit == null ? null : isSubmit.trim();
    }

    public Date getSubmittime() {
        return submittime;
    }

    public void setSubmittime(Date submittime) {
        this.submittime = submittime;
    }

    public String getSubmitUrl() {
        return submitUrl;
    }

    public void setSubmitUrl(String submitUrl) {
        this.submitUrl = submitUrl == null ? null : submitUrl.trim();
    }
}