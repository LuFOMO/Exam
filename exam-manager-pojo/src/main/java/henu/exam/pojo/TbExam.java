package henu.exam.pojo;

import java.util.Date;

public class TbExam {
    private Integer id;

    private String name;

    private Integer studentNum;

    private String teachname;

    private Date starttime;

    private String autostart;

    private String started;

    private String finished;

    private String archived;

    private String cleaned;

    private String exampaper;

    private String paperUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getTeachname() {
        return teachname;
    }

    public void setTeachname(String teachname) {
        this.teachname = teachname == null ? null : teachname.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getAutostart() {
        return autostart;
    }

    public void setAutostart(String autostart) {
        this.autostart = autostart == null ? null : autostart.trim();
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started == null ? null : started.trim();
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished == null ? null : finished.trim();
    }

    public String getArchived() {
        return archived;
    }

    public void setArchived(String archived) {
        this.archived = archived == null ? null : archived.trim();
    }

    public String getCleaned() {
        return cleaned;
    }

    public void setCleaned(String cleaned) {
        this.cleaned = cleaned == null ? null : cleaned.trim();
    }

    public String getExampaper() {
        return exampaper;
    }

    public void setExampaper(String exampaper) {
        this.exampaper = exampaper == null ? null : exampaper.trim();
    }

    public String getPaperUrl() {
        return paperUrl;
    }

    public void setPaperUrl(String paperUrl) {
        this.paperUrl = paperUrl == null ? null : paperUrl.trim();
    }
}