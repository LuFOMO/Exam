package henu.exam.pojo;

public class TbFile {
    private Integer sid;

    private String filename;

    private Integer filesize;

    private String uploadtime;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime == null ? null : uploadtime.trim();
    }
}