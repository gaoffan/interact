package org.sacc.interact.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Homeworkview {

    private int id;
    private int userId;
    private int homeworkId;
    private String remark;
    private String fileName;

    private int isShow;
    private byte[] content;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public byte[] getContent() {
        return content;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public int getHomeworkId() {
        return homeworkId;
    }

    public int getIsShow() {
        return isShow;
    }

    public String getRemark() {
        return remark;
    }

    public void setHomeworkId(int homeWorkId) {
        this.homeworkId = homeWorkId;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
